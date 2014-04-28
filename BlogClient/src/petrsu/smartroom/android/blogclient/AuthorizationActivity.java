package petrsu.smartroom.android.blogclient;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AuthorizationActivity extends Activity implements OnTouchListener {
	
	/** The connect btn. */
	Button connectBtn;
	
	Button guestBtn;
	
	/** The edit name. */
	static EditText editName;
	
	/** The edit password. */
	static EditText editPassword;
	
	EditText editIP;
	
	static EditText editPort;
	
	static boolean isChairman;
	static boolean isRegistered;
	
	public static String ip;
	
	private Blog_KP KP;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_authorization);
		
        connectBtn = (Button) findViewById (R.id.connectBtn);
        connectBtn.setOnTouchListener(this);
        guestBtn = (Button) findViewById (R.id.guestBtn);
        guestBtn.setOnTouchListener(this);
        
        editName = (EditText) findViewById (R.id.editName);
        editPassword = (EditText) findViewById (R.id.editPassword);
        editIP = (EditText) findViewById (R.id.editIP);
        editPort = (EditText) findViewById (R.id.editPort);
        
        isChairman = false;
        isRegistered = false;
        
        KP = new Blog_KP();
	}
	
	
	@Override
	public boolean onTouch(View view, MotionEvent event) {
		final String name = editName.getText().toString();
		final String password = editPassword.getText().toString();
		int port = 10011;
		ip = editIP.getText().toString();
		
		switch(view.getId()) {
			case R.id.connectBtn:
				
				if(event.getAction() == MotionEvent.ACTION_DOWN) {
					connectBtn.setBackgroundResource(R.drawable.button_pressed);
				} else if(event.getAction() == MotionEvent.ACTION_UP) {
					connectBtn.setBackgroundResource(R.drawable.button);
					try {
						port = Integer.parseInt(editPort.getText().toString());
					} catch(NumberFormatException e) {
						Toast.makeText(this, R.string.portFormatErr, Toast.LENGTH_SHORT).show();
						return false;
					}
					joinSmartSpace(name, password, port);
				}
				break;
				
			case R.id.guestBtn:
				if(event.getAction() == MotionEvent.ACTION_DOWN) {
					guestBtn.setBackgroundResource(R.drawable.button_pressed);
				} else if(event.getAction() == MotionEvent.ACTION_UP) {
					guestBtn.setBackgroundResource(R.drawable.button);
					editName.setText("");
					editPassword.setText("");
					try {
						port = Integer.parseInt(editPort.getText().toString());
					} catch(NumberFormatException e) {
						Toast.makeText(this, R.string.portFormatErr, Toast.LENGTH_SHORT).show();
						return false;
					}
					joinAsGuest(port);
				}
				break;

		}
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.authorization, menu);
		return true;
	}
	
	public void joinAsGuest(final int port) {
		LayoutInflater inflater = LayoutInflater.from(this);
		final View dialogView = inflater.inflate(R.layout.guest_registration, null);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setView(dialogView);
		builder.setTitle(R.string.registrationTitle);
		builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				EditText editName = (EditText) dialogView.findViewById(R.id.guestName);
				EditText editPhone = (EditText) dialogView.findViewById(R.id.guestPhone);
				EditText editEmail = (EditText) dialogView.findViewById(R.id.guestEmail);
				String name = editName.getText().toString();
				String phone = editPhone.getText().toString();
				String email = editEmail.getText().toString();
				int ret_value = 0;
				
				if(name.equals(""))
					Toast.makeText(getApplicationContext(), R.string.guestNameEmpty, 
							Toast.LENGTH_SHORT).show();
				else {
					if(Blog_KP.connectSmartSpace("X", ip, port) != 0) {
						Toast.makeText(getApplicationContext(), R.string.connectionFail, 
								Toast.LENGTH_SHORT).show();
						return;
					}
					System.out.println("Connection done");
					Blog_KP.connectionState = 1;
					
					ret_value = Blog_KP.registerGuest(name, phone, email);
					
					if(ret_value == -1) {
						Toast.makeText(getApplicationContext(), R.string.registrationFail, 
								Toast.LENGTH_SHORT).show();
						return;
					} else if(ret_value == 1) {
						Toast.makeText(getApplicationContext(), R.string.nameIsUsed, 
								Toast.LENGTH_SHORT).show();
						return;
					}
					System.out.println("Registration done");					
				}
			}
		});
		builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				return;
			}
		});
		
		AlertDialog dialog = builder.create();
		dialog.show();
	}
	
	public void joinSmartSpace(final String name, final String password, final int port) {
		if(name.equals("") || password.equals("")) { 
			Toast.makeText(this, R.string.emptyFields, Toast.LENGTH_SHORT).show();
			return;
		}
		
		if(establishConnection(name, password, port) != 0) {
			Toast.makeText(this, R.string.connectionFail, Toast.LENGTH_SHORT).show();
			return;
		}
		
		try {
		    Thread.sleep(400);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
	public int establishConnection(String name, String password, int port) {
		
		if(Blog_KP.connectionState != 1) {
			if(Blog_KP.connectSmartSpace("X", ip, port) != 0) {
				Toast.makeText(this, R.string.connectionFail, Toast.LENGTH_SHORT).show();
				return -1;
			}
			
			Blog_KP.connectionState = 1;
			Log.i("Connection", "DONE");
		}

		if(!isRegistered) {
				
				if(Blog_KP.userRegistration(name, password) == 0) {
					Log.i("Java KP", "Registration successful");

					if(password.equals("chairman"))
						isChairman = true;
					isRegistered = true;	
				} else {
					Toast.makeText(this, R.string.registrationFail, 
							Toast.LENGTH_SHORT).show();
					Blog_KP.disconnectSmartSpace();
					Blog_KP.connectionState = -1;
					return -1;
				}
			Log.i("Registration", "DONE");
		}
		return 0;
	}

}

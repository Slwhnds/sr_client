package petrsu.smartroom.android.blogclient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {
	
	/** ���������, ������������ ��� �������� � AutorizationActivity */
	Intent intent;
	
	LoginActivity act;

	/** ��������� �����. */
	private String login;

	/** ������� �����. */
	private String curLogin;

	/** ������. */
	private String pass;

	/** ���� ��� ����� ������. */
	private EditText loginEditText;

	/** ���� ��� ����� ������. */
	private EditText passwdEditText;

	/** ����� ��� ����������� �������� ������. */
	private EditText curLoginEditText;

	/** ������ "Login". */
	private Button loginButton;
	
	private boolean after = false;

	/** 
	* ���������� ��� �������� ���������� ������ � �������� �� ��� �������������. ����� �� BlogAdapter ������� ����� � ���������� ���.
	* @param savedInstanceState ����������� ��������� Activity
	*
	* �������� �������: BlogAdapter.getLogin(String login, String password) (???)
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		curLoginEditText = (EditText) findViewById(R.id.logged_as_edit);
		//if (KP.blogAdapter.curLogin.compareTo("authorized") != 0)
			//curLogin = "smartroomuser";
		//else
			curLogin = KP.blogAdapter.getCurLogin();
		//curLogin = BlogListActivity.blogAdapter.getCurLogin();
		curLoginEditText = (EditText) findViewById(R.id.logged_as_edit);
		curLoginEditText.setText(curLogin);
		
		intent = getIntent();
		act = this;
	}

	/** 
	* ���������� ��� �������� ����. ��������� � ���� "Log out" � "Back to SmartRoom account" ��� ������.
	* @param menu ������, �������������� ����
	* @returns ������������ �������� �� ������������
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		if (KP.blogAdapter.isLoggedIn())
			getMenuInflater().inflate(R.menu.login_menu_after, menu);
		else
			getMenuInflater().inflate(R.menu.login_menu, menu);
		return true;
	}

	/** 
	* ���������� ��� ������ ������ ����. 
	* "Log out" - ��������� �������� intent � ��������� AutorizationActivity.
	* "Back to SmartRoom account" - ������������� � BlogAdapter ��� ������� ����� ����� � ������.
	* @param item ������, �������������� ����� ����
	* @returns ������������ �������� �� ������������
	*
	* Calls for: BlogAdapter.login(String login, String password)
	*/
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.back_to_sr_account:
			login = "";
			pass = "";
			new loginTask().execute();
			after = false;
			startActivity(intent);
			finish();
			break;
		case R.id.log_out:
			intent = new Intent(getBaseContext(), AuthorizationActivity.class);
			this.startActivity(intent);
			break;
		default:
			return super.onOptionsItemSelected(item);
		}
		return true;
	}
	
	/** ����������� ��� ������� �� ������ "Login". �������� ����� � ������ ������� BlogAdapter ��� ������� ����������� �� ������� ����-�������.
	* @param v ������� ������
	*
	* �������� �������: BlogAdapter.login(String login, String password)
	*/
	public void onLogin(View v) {
		loginEditText = (EditText) findViewById(R.id.login_edit);
		passwdEditText = (EditText) findViewById(R.id.password_edit);
		login = loginEditText.getText().toString();
		pass = passwdEditText.getText().toString();
		if ((login == "") || (pass == "")) {
			BlogErrDialog.fillLogPass(getBaseContext());
			return;
		}
		new loginTask().execute();
	}
	
	public class loginTask extends AsyncTask {

		@Override
		protected Object doInBackground(Object... arg0) {
			try {
				if ((login.compareTo("") == 0) && (pass.compareTo("") == 0)) {
					KP.blogAdapter.login();
					//KP.blogAdapter.curLogin = "notauthorized";
				}
				else {
					KP.blogAdapter.login(login, pass);
					//KP.blogAdapter.curLogin = "authorized";
				}
					after = true;
			}
			catch (Exception e) {
				return null;
			}
			return new Object();
		}
		
		protected void onPostExecute(Object result) {
			super.onPostExecute(result);
			if (result == null)
				BlogErrDialog.loginErr(getApplicationContext());
			else {
				BlogErrDialog.loginYes(getApplicationContext());
				act.startActivity(intent);
				act.finish();
			}
		}


	}
}

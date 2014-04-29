package petrsu.smartroom.android.blogclient;

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

	/** ����-������� ��� ����, ����� ������������ �� ������� ����-�������. */
	//private BlogAdapter blogAdapter;

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
	private TextView curLoginTextView;

	/** ������ "Login". */
	private Button loginButton;

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
	}

	/** 
	* ���������� ��� �������� ����. ��������� � ���� "Log out" � "Back to SmartRoom account" ��� ������.
	* @param menu ������, �������������� ����
	* @returns ������������ �������� �� ������������
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.blog_list, menu);
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
		return false;
		
	}
	
	/** ����������� ��� ������� �� ������ "Login". �������� ����� � ������ ������� BlogAdapter ��� ������� ����������� �� ������� ����-�������.
	* @param v ������� ������
	*
	* �������� �������: BlogAdapter.login(String login, String password)
	*/
	public void onLogin(View v) {
		
	}
}

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
	
	/** Намерение, используемое для перехода к AutorizationActivity */
	Intent intent;

	/** Введенный логин. */
	private String login;

	/** Текущий логин. */
	private String curLogin;

	/** Пароль. */
	private String pass;

	/** Поле для ввода логина. */
	private EditText loginEditText;

	/** Поле для ввода пароля. */
	private EditText passwdEditText;

	/** Метка для отображения текущего логина. */
	private EditText curLoginEditText;

	/** Кнопка "Login". */
	private Button loginButton;
	
	private boolean after = false;

	/** 
	* Вызывается при создании экземпляра класса и отвечает за его инициализацию. Берет из BlogAdapter текущий логин и отображает его.
	* @param savedInstanceState сохраненное состояние Activity
	*
	* Вызывает функции: BlogAdapter.getLogin(String login, String password) (???)
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		curLogin = BlogListActivity.blogAdapter.getCurLogin();
		curLoginEditText = (EditText) findViewById(R.id.logged_as_edit);
		curLoginEditText.setText(curLogin);
	}

	/** 
	* Вызывается при создании меню. Добавляет в меню "Log out" и "Back to SmartRoom account" как пункты.
	* @param menu объект, представляющий меню
	* @returns возвращаемое значение не используется
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		if (after)
			getMenuInflater().inflate(R.menu.login_menu_after, menu);
		else
			getMenuInflater().inflate(R.menu.login_menu, menu);
		return true;
	}

	/** 
	* Вызывается при выборе пункта меню. 
	* "Log out" - Формирует свойство intent и запускает AutorizationActivity.
	* "Back to SmartRoom account" - устанавливает в BlogAdapter как текущие общие логин и пароль.
	* @param item объект, представляющий пункт меню
	* @returns возвращаемое значение не используется
	*
	* Calls for: BlogAdapter.login(String login, String password)
	*/
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.back_to_sr_account:
			BlogListActivity.blogAdapter.login();
			break;
		case R.id.log_out:
			this.finish();
			break;
		default:
			return super.onOptionsItemSelected(item);
		}
		return true;
	}
	
	/** Срабатывает при нажатии на кнопку "Login". Передает логин и пароль объекту BlogAdapter для попытки авторизации во внешнем блог-сервисе.
	* @param v нажатая кнопка
	*
	* Вызывает функции: BlogAdapter.login(String login, String password)
	*/
	public void onLogin(View v) {
		loginEditText = (EditText) findViewById(R.id.login_edit);
		passwdEditText = (EditText) findViewById(R.id.password_edit);
		login = loginEditText.getText().toString();
		pass = passwdEditText.getText().toString();
		if ((login == "") || (pass == ""))
			BlogErrDialog.fillLogPass(getBaseContext());
		BlogListActivity.blogAdapter.login(login, pass);
		recreate();
	}
}

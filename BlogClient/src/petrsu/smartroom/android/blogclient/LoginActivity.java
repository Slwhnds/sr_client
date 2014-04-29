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

	/** Блог-адапрер для того, чтобы залогиниться на внешнем блог-сервисе. */
	//private BlogAdapter blogAdapter;

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
	private TextView curLoginTextView;

	/** Кнопка "Login". */
	private Button loginButton;

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
	}

	/** 
	* Вызывается при создании меню. Добавляет в меню "Log out" и "Back to SmartRoom account" как пункты.
	* @param menu объект, представляющий меню
	* @returns возвращаемое значение не используется
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.blog_list, menu);
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
		return false;
		
	}
	
	/** Срабатывает при нажатии на кнопку "Login". Передает логин и пароль объекту BlogAdapter для попытки авторизации во внешнем блог-сервисе.
	* @param v нажатая кнопка
	*
	* Вызывает функции: BlogAdapter.login(String login, String password)
	*/
	public void onLogin(View v) {
		
	}
}

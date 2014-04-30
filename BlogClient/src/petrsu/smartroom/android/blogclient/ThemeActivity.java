package petrsu.smartroom.android.blogclient;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThemeActivity extends Activity {
	
	/** Намерение, используемое для перехода к другим Activity */
	Intent intent;

	/** Тема для отображения. */
	//private Theme theme;

	/** Текущий блог. */
	//private Blog blog;

	/** Метка для отображения заголовка темы. */
	private TextView themeNameTextView;

	/** Метка для отображения текста темы. */
	private TextView themeTextTextView;

	/** Кнопка "View comments". */
	private Button viewCommentsButton;

	/** Кнопка "Leave a comment". */
	private Button leaveCommentButton ;

	/** 
	* Вызывается при создании экземпляра класса и отвечает за его инициализацию. Получает в запустившем Activity намерении текущий блог и тему, отображает ее.
	* @param savedInstanceState сохраненное состояние Activity
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_theme);
	}

	/** 
	* Вызывается при создании меню. Добавляет в меню "Log out" как пункт.
	* @param menu объект, представляющий меню
	* @returns возвращаемое значение не используется
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.theme, menu);
		return true;
	}
	

	/** Срабатывает при нажатии на кнопку "View comments". Формирует свойство intent и запускает CommentsListActivity для темы theme.
	* @param v нажатая кнопка
	*/
	public void onViewComments(View v) {
		
	}

	/** Срабатывает при нажатии на кнопку "Leave a comment". Формирует свойство intent и запускает  LeavingCommentActivity.
	* @param v нажатая кнопка
	*/
	public void onLeaveComment(View v) {
		
	}

	/** 
	* Вызывается при выборе пункта меню. 
	* "Log out" - Формирует свойство intent и запускает AutorizationActivity.
	* @param item объект, представляющий пункт меню
	* @returns возвращаемое значение не используется
	*/
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return false;
		
	}

}

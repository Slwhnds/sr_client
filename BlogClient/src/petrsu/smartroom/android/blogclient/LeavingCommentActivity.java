package petrsu.smartroom.android.blogclient;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LeavingCommentActivity extends Activity {
	
	/** Намерение, используемое для перехода к AutorizationActivity */
	Intent intent;

	/** Блог-адаптер для публикации комментария. */
	//BlogAdapter blogAdapter;

	/** Тема, к которой публикуется комментарий. */
	//private Theme theme;

	/** Введенный текст комментария. */
	private String commentText;

	/** Кнопка "Publish". */
	private Button publishButton;

	/** Поле для ввода текста комментария. */
	private EditText commentEditText;

	/** 
	* Вызывается при создании экземпляра класса и отвечает за его инициализацию. Запрашивает у BlogAdapter заголовок темы, к которой публикуется комментарий, и отображает его
	* @param savedInstanceState сохраненное состояние Activity
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leaving_comment);
	}


	/** 
	* Вызывается при создании меню. Добавляет в меню "Log out" как пункт.
	* @param menu объект, представляющий меню
	* @returns возвращаемое значение не используется
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.leaving_comment, menu);
		return true;
	}

	/** Срабатывает при нажатии на кнопку "Publish". 
	* @param v нажатая кнопка
	*
	* Вызывает функции: BlogAdapter.postComment(String body, Theme theme) 
	*/
	public void onPublish(View v) {
		
	}

	/** 
	* Вызывается при выборе пункта меню. 
	* "Log out" - Формирует свойство intent и запускает AuthorizationActivity.
	* @param item объект, представляющий пункт меню
	* @returns возвращаемое значение не используется
	*/
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return false;
		
	}

}

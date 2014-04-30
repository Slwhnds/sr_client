package petrsu.smartroom.android.blogclient;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;

public class CommensListActivity extends Activity {
	
	/** Намерение, используемое для перехода к другим Activity. */
	Intent intent;

	/** Блог-адаптер для получения списка комментариев. */
	//BlogAdapter blogAdapter;

	/** Тема, комментарии к которой отображаются. */
	//private Theme theme;
	 
	/** Адаптер списка комментариев. */
	private SimpleAdapter adapter;

	/** Кнопка "Leave a comment". */
	private Button leaveCommentButton;

	/** 
	* Вызывается при создании экземпляра класса и отвечает за его инициализацию. Отображает список комментариев, соответствующий теме, переданной в намерении, которое запустило CommentsListActivity.
	* @param savedInstanceState сохраненное состояние Activity
	* 
	* Вызывает функции: setUpList()
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_commens_list);
	}

	/** 
	* Вызывается при создании меню. Добавляет в меню "Log out" и "Leave a comment" как пункты и "Refresh" как иконку.
	* @param menu объект, представляющий меню
	* @returns возвращаемое значение не используется
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.commens_list, menu);
		return true;
	}
	

	/** 
	* Формирует список комментариев (подготавливает данные из theme для того чтобы поместить их в adapter).,
	* помещает их в adapter).
	* Calls for: BlogAdapter.getComments(Theme theme)
	*/
	private void setUpList() {
		
	}

	/** Срабатывает при нажатии на кнопку "Leave a comment". Формирует свойство intent и запускает  LeavingCommentActivity.
	* @param v нажатая кнопка
	*/
	public void onLeaveComment(View v) {
		
	}

	/** 
	* Вызывается при выборе пункта меню. 
	* "Leave a comment" - Формирует свойство intent и запускает LeavingCommentActivity.
	* "Log out" - Формирует свойство intent и запускает AuthorizationActivity.
	* "Refresh" - обновляет список тем.
	* @param item объект, представляющий пункт меню
	* @returns возвращаемое значение не используется
	* 
	* Вызывает функции: onCreate(Bundle savedInstanceState)
	*/
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return false;
		
	}
}

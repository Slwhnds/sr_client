package petrsu.smartroom.android.blogclient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;

public class CommensListActivity extends ListActivity {
	
	//имена атрибутов для Map
	final String COMMENT_AUTHOR = "author";
	final String COMMENT_TIME = "time";
	final String COMMENT_TEXT = "text";
	
	/** Намерение, используемое для перехода к другим Activity. */
	Intent intent;

	/** Тема, комментарии к которой отображаются. */
	private Theme theme;
	 
	/** Адаптер списка комментариев. */
	private SimpleAdapter adapter;
	
	/** Список комментариев, подготовленный к помещению в адаптер. */
	List<Map<String, ?>> list;

	/** 
	* Вызывается при создании экземпляра класса и отвечает за его инициализацию. Отображает список комментариев, соответствующий теме, переданной в намерении, которое запустило CommentsListActivity.
	* @param savedInstanceState сохраненное состояние Activity
	* 
	* Вызывает функции: setUpList()
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		theme = (Theme) getIntent().getExtras().get("theme");
		setUpList();
	}

	/** 
	* Вызывается при создании меню. Добавляет в меню "Log out" и "Leave a comment" как пункты и "Refresh" как иконку.
	* @param menu объект, представляющий меню
	* @returns возвращаемое значение не используется
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comments_list_menu, menu);
		return true;
	}
	

	/** 
	* Формирует список комментариев (подготавливает данные из theme для того чтобы поместить их в adapter).,
	* помещает их в adapter).
	* Calls for: BlogAdapter.getComments(Theme theme)
	*/
	private void setUpList() {
		ThemeComment[] items = BlogListActivity.blogAdapter.getComments(theme);
		
		list = new ArrayList<Map<String, ?>>(items.length);
        
        for(int i = 0; i < items.length; i++)
        {
            Map<String, String> map = new HashMap<String, String>();
            map.put(COMMENT_AUTHOR, items[i].getPosterName());
            map.put(COMMENT_TIME, new SimpleDateFormat("hh:mm").format(items[i].getTime()));
            map.put(COMMENT_TEXT, items[i].getText());
            list.add(map);
        }
        
        //массив имен атрибутов, из которых будут читаться данные
        String[] from = { COMMENT_AUTHOR, COMMENT_TIME, COMMENT_TEXT };
        //массив ID View-компонентов, в которые будут вставляться данные
        int[] to = { R.id.comment_author, R.id.comment_time, R.id.comment_text };
        
        adapter = new SimpleAdapter(this, list, R.layout.comment_item,
                from, to);
        setListAdapter(adapter);
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
		switch (item.getItemId()) {
		case R.id.leave_comment:
			intent = new Intent(getBaseContext(), LeavingCommentActivity.class);
			intent.putExtra("theme", theme);
		    startActivity(intent);
			break;
		case R.id.log_out:
			this.finish();
			break;
		default:
			return super.onOptionsItemSelected(item);
		}
		return true;
	}
}

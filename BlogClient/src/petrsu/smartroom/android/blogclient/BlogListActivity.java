package petrsu.smartroom.android.blogclient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import petrsu.smartroom.android.cameraclient.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.hardware.Camera;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;

public class BlogListActivity extends ListActivity {
	
	//имена атрибутов для Map
	final String THEME_SUBJECT = "name";
	
	/** KP, отвечающий за получение списка тем. */
	private Blog_KP KP;

	/** Намерение, используемое для перехода к другим Activity. */
	Intent intent;

	/** Список тем, полученный от KP. */
	String[] themes;

	/** Блог для отображения. */
	private Blog blog;

	/** Блог-адаптер для получения тем из внешнего блог-сервиса. */
	public static BlogAdapter blogAdapter;

	/** Адаптер блога. */
	private SimpleAdapter adapter;
	 
	/** Слушатель выбора из списка, отвечает за обработку нажатий. */
	private OnItemClickListener itemListener;

	/** 
	* Вызывается при создании экземпляра класса и отвечает за его инициализацию. Запрашивает у KP список доступных тем и отображает его.
	* @param savedInstanceState сохраненное состояние Activity
	*
	* Вызывает методы: Blog_KP.getThemes(), setUpList(), Blog.setThemes(String[] items, BlogAdapter adapter),
	* BlogAdapter.setSRName(String name), BlogAdapter.setLogPass(String log, String pass)
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		if (KP.getThemes(themes) < 0) {
			BlogErrDialog.loadCameraErr(getBaseContext());
			finish();
		}
		
		String login = new String(), pass = new String();
		if (KP.getLogPass(login, pass) < 0) {
			BlogErrDialog.loadLogPass(getBaseContext());
			finish();
		}
		
		blogAdapter.setLogPass(login, pass);
		blogAdapter.login(login, pass);
		blogAdapter.setSRName((String) getIntent().getExtras().get("SRName"));
		
		for (int i = 0; i < themes.length; i++) {
			String[] s = themes[i].split(" ");
			Theme t = new Theme(blogAdapter.getBlogEntry(Integer.parseInt(s[0])));
			blog.add(t);
		}
		
		setUpList();
		
		itemListener = new OnItemClickListener() {

			/** 
			* Срабатывает при выборе из списка. Формирует свойство intent и запускает ThemeActivity для выбранной темы.
			* @param parent указывает на AdapterView, в котором произошел выбор
			* @param v - выбранная позиция
			* @param position порядковый номер выбранной позиции
			* @param id идентификатор выбранного элемента
			* Calls for: Blog.getTheme(int i)
			*/
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				intent = new Intent(getBaseContext(), ThemeActivity.class);
				intent.putExtra("theme", blog.getTheme(position));
			    startActivity(intent);
			}
			
		};
	}

	/** 
	* Вызывается при создании меню. Добавляет в меню пункты "Account settings" и "Log out" как пункты, и "Refresh" как иконку.
	* @param menu объект, представляющий меню
	* @returns флаг того, что меню можно показывать
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/** 
	* Вызывается при выборе пункта меню. 
	* "Account settings" - Формирует свойство intent (с параметрами blogAdapter, blog.login, blog.pass) и запускает LoginActivity.
	* "Log out" - Формирует свойство intent и запускает AutorizationActivity.
	* "Refresh" - обновляет список тем.
	* @param item объект, представляющий пункт меню
	* @returns возвращаемое значение не используется
	*
	* Вызывает методы: onCreate(Bundle savedInstanceState)
	*/
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.account_settings:
			intent = new Intent(this, LoginActivity.class);
		    startActivity(intent);
			break;
		case R.id.log_out:
			this.finish();
			break;
		case R.id.refresh:
			this.recreate();
			break;
		default:
			return super.onOptionsItemSelected(item);
		}
		return true;
	}

	/** 
	* Формирует список тем (подготавливает данные из blog для того чтобы поместить их в adapter),
	* помещает их в adapter).
	* Calls for: Blog.getThemes()
	*/
	private void setUpList() {
		
		String[] items = Blog.getThemes();
		
		List<Map<String, ?>> list = new ArrayList<Map<String, ?>>(items.length);
        
        for(int i = 0; i < items.length; i++)
        {
            Map<String, String> map = new HashMap<String, String>();
            map.put(THEME_SUBJECT, items[i]);
            list.add(map);
        }
        
        //массив имен атрибутов, из которых будут читаться данные
        String[] from = { THEME_SUBJECT };
        //массив ID View-компонентов, в которые будут вставляться данные
        //здесь нужно подставлять id из theme_item.xml
        int[] to = { R.id. };
        
        adapter = new SimpleAdapter(this, list, R.layout.theme_item.xml,
                from, to);
        setListAdapter(adapter);
	}

}

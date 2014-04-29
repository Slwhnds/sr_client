package petrsu.smartroom.android.blogclient;

import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;

public class BlogListActivity extends Activity {
	
	/** KP, отвечающий за получение списка тем. */
	private Blog_KP KP;

	/** Намерение, используемое для перехода к другим Activity. */
	Intent intent;

	/** Список тем, полученный от KP. */
	String[] themes;

	/** Блог для отображения. */
	//private Blog blog;

	/** Блог-адаптер для получения тем из внешнего блог-сервиса. */
	//private BlogAdapter blogAdapter;

	/** Список тем, подготовленный к помещению в адаптер. */
	List<Map<String, ?>> list;

	/** Адаптер блога. */
	private SimpleAdapter adapter;
	 
	/** Слушатель выбора из списка, отвечает за обработку нажатий. */
	private OnItemClickListener itemListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
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
				
			}
			
		};
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

}

package petrsu.smartroom.android.cameraclient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import android.hardware.Camera;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;

public class CameraListActivity extends ListActivity {

	/** Список камер. */
	private List<Camera> cameras;
	
	/** KP, отвечающий за получение списка камер. */
	//private CameraService KP;

	/** Список камер, полученный от KP. */
	private String[] cameraCollection;

	/** Намерение, используемое для перехода к CameraActivity и AutorizationActivity. */
	Intent intent;

	/** Список камер, подготовленный к помещению в адаптер. */
	List<Map<String, ?>> list;

	/** Адаптер списка камер. */
	private SimpleAdapter adapter;

	/** Слушатель выбора из списка, отвечает за обработку нажатий. */
	private OnItemClickListener itemListener;

	/** 
	* Вызывается при создании экземпляра класса и отвечает за его инициализацию. Запрашивает у KP список доступных камер и отображает его.
	* @param savedInstanceState сохраненное состояние Activity
	*
	* Вызывает методы: setUpList(), Camera_KP.getCameraData(String[] cameras)
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		itemListener = new OnItemClickListener() {

			/** 
			* Срабатывает при выборе из списка. Формирует свойство intent и запускает CameraActivity для выбранной камеры.
			* @param parent указывает на AdapterView, в котором произошел выбор
			* @param v выбранная позиция
			* @param position порядковый номер выбранной позиции
			* @param id идентификатор выбранного элемента
			*/
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				
			}
			
		};
	}

	/** 
	* Вызывается при создании меню. Добавляет в меню "Log out" как пункт.
	* @param menu объект, представляющий меню
	* @returns возвращаемое значение не используется
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	/** 
	* Формирует список камер (подготавливает данные из cameras для того чтобы поместить их в adapter). 
	*/
	private void setUpList()
    {        
        List<Map<String, ?>> list = new ArrayList<Map<String, ?>>();
        ListIterator i = cameras.listIterator();
        
        while (i.hasNext())
        {
            Map<String, Camera> map = new HashMap<String, Camera>();
            //map.put("title", i.next().getIP());
            list.add(map);
        }
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

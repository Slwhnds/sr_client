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

	/** ������ �����. */
	private List<Camera> cameras;
	
	/** KP, ���������� �� ��������� ������ �����. */
	//private CameraService KP;

	/** ������ �����, ���������� �� KP. */
	private String[] cameraCollection;

	/** ���������, ������������ ��� �������� � CameraActivity � AutorizationActivity. */
	Intent intent;

	/** ������ �����, �������������� � ��������� � �������. */
	List<Map<String, ?>> list;

	/** ������� ������ �����. */
	private SimpleAdapter adapter;

	/** ��������� ������ �� ������, �������� �� ��������� �������. */
	private OnItemClickListener itemListener;

	/** 
	* ���������� ��� �������� ���������� ������ � �������� �� ��� �������������. ����������� � KP ������ ��������� ����� � ���������� ���.
	* @param savedInstanceState ����������� ��������� Activity
	*
	* �������� ������: setUpList(), Camera_KP.getCameraData(String[] cameras)
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		itemListener = new OnItemClickListener() {

			/** 
			* ����������� ��� ������ �� ������. ��������� �������� intent � ��������� CameraActivity ��� ��������� ������.
			* @param parent ��������� �� AdapterView, � ������� ��������� �����
			* @param v ��������� �������
			* @param position ���������� ����� ��������� �������
			* @param id ������������� ���������� ��������
			*/
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				
			}
			
		};
	}

	/** 
	* ���������� ��� �������� ����. ��������� � ���� "Log out" ��� �����.
	* @param menu ������, �������������� ����
	* @returns ������������ �������� �� ������������
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	/** 
	* ��������� ������ ����� (�������������� ������ �� cameras ��� ���� ����� ��������� �� � adapter). 
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
	* ���������� ��� ������ ������ ����. 
	* "Log out" - ��������� �������� intent � ��������� AutorizationActivity.
	* @param item ������, �������������� ����� ����
	* @returns ������������ �������� �� ������������
	*/
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return false;
		
	}
}

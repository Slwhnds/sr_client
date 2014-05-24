package petrsu.smartroom.android.cameraclient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;

public class CameraListActivity extends ListActivity {
	
	//����� ��������� ��� Map
	final String CAMERA_NAME = "name";

	/** ������ �����. */
	private ArrayList<Camera> cameras;
	
	/** KP, ���������� �� ��������� ������ �����. */
	private Camera_KP KP;

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
	* �������� ������: setUpList(), Camera_KP.getCameraData(String[] cameras),
	* Camera()
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if (KP.getCameraData(cameraCollection) < 0) {
			CameraErrDialog.loadCameraErr(getBaseContext());
			finish();
		}
		cameras = new ArrayList<Camera>();
		for (int i = 0; i < cameraCollection.length; i++) {
			String[] c = cameraCollection[i].split(" ");
			cameras.add(new Camera(c[0], c[1], c[2], c[3], c[4], c[5], c[6]));
		}
		
		setUpList();
		
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
				intent = new Intent(getBaseContext(), CameraActivity.class);
				intent.putExtra("camera", cameras.get(position));
			    startActivity(intent);
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
		getMenuInflater().inflate(R.menu.camera_list_menu, menu);
		return true;
	}
	

	/** 
	* ��������� ������ ����� (�������������� ������ �� cameras ��� ���� 
	* ����� ��������� �� � adapter, �������� � adapter, 
	* ������������� adapter ��� ������ listActivity.
	*/
	private void setUpList()
    {        
        List<Map<String, ?>> list = new ArrayList<Map<String, ?>>(cameras.size());
        
        for(int i = 0; i < cameras.size(); i++)
        {
            Map<String, String> map = new HashMap<String, String>();
            map.put(CAMERA_NAME, cameras.get(i).getName());
            list.add(map);
        }
        
        //������ ���� ���������, �� ������� ����� �������� ������
        String[] from = {CAMERA_NAME };
        //������ ID View-�����������, � ������� ����� ����������� ������
        int[] to = {R.id.camera_name};
        
        adapter = new SimpleAdapter(this, list, R.layout.camera_item,
                from, to);
        setListAdapter(adapter);
    }
}

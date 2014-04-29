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
	
	/** KP, ���������� �� ��������� ������ ���. */
	private Blog_KP KP;

	/** ���������, ������������ ��� �������� � ������ Activity. */
	Intent intent;

	/** ������ ���, ���������� �� KP. */
	String[] themes;

	/** ���� ��� �����������. */
	//private Blog blog;

	/** ����-������� ��� ��������� ��� �� �������� ����-�������. */
	//private BlogAdapter blogAdapter;

	/** ������ ���, �������������� � ��������� � �������. */
	List<Map<String, ?>> list;

	/** ������� �����. */
	private SimpleAdapter adapter;
	 
	/** ��������� ������ �� ������, �������� �� ��������� �������. */
	private OnItemClickListener itemListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		itemListener = new OnItemClickListener() {

			/** 
			* ����������� ��� ������ �� ������. ��������� �������� intent � ��������� ThemeActivity ��� ��������� ����.
			* @param parent ��������� �� AdapterView, � ������� ��������� �����
			* @param v - ��������� �������
			* @param position ���������� ����� ��������� �������
			* @param id ������������� ���������� ��������
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
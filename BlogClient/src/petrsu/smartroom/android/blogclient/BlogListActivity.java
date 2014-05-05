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
	
	//����� ��������� ��� Map
	final String THEME_SUBJECT = "name";
	
	/** KP, ���������� �� ��������� ������ ���. */
	private Blog_KP KP;

	/** ���������, ������������ ��� �������� � ������ Activity. */
	Intent intent;

	/** ������ ���, ���������� �� KP. */
	String[] themes;

	/** ���� ��� �����������. */
	private Blog blog;

	/** ����-������� ��� ��������� ��� �� �������� ����-�������. */
	public static BlogAdapter blogAdapter;

	/** ������� �����. */
	private SimpleAdapter adapter;
	 
	/** ��������� ������ �� ������, �������� �� ��������� �������. */
	private OnItemClickListener itemListener;

	/** 
	* ���������� ��� �������� ���������� ������ � �������� �� ��� �������������. ����������� � KP ������ ��������� ��� � ���������� ���.
	* @param savedInstanceState ����������� ��������� Activity
	*
	* �������� ������: Blog_KP.getThemes(), setUpList(), Blog.setThemes(String[] items, BlogAdapter adapter),
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
			* ����������� ��� ������ �� ������. ��������� �������� intent � ��������� ThemeActivity ��� ��������� ����.
			* @param parent ��������� �� AdapterView, � ������� ��������� �����
			* @param v - ��������� �������
			* @param position ���������� ����� ��������� �������
			* @param id ������������� ���������� ��������
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
	* ���������� ��� �������� ����. ��������� � ���� ������ "Account settings" � "Log out" ��� ������, � "Refresh" ��� ������.
	* @param menu ������, �������������� ����
	* @returns ���� ����, ��� ���� ����� ����������
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/** 
	* ���������� ��� ������ ������ ����. 
	* "Account settings" - ��������� �������� intent (� ����������� blogAdapter, blog.login, blog.pass) � ��������� LoginActivity.
	* "Log out" - ��������� �������� intent � ��������� AutorizationActivity.
	* "Refresh" - ��������� ������ ���.
	* @param item ������, �������������� ����� ����
	* @returns ������������ �������� �� ������������
	*
	* �������� ������: onCreate(Bundle savedInstanceState)
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
	* ��������� ������ ��� (�������������� ������ �� blog ��� ���� ����� ��������� �� � adapter),
	* �������� �� � adapter).
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
        
        //������ ���� ���������, �� ������� ����� �������� ������
        String[] from = { THEME_SUBJECT };
        //������ ID View-�����������, � ������� ����� ����������� ������
        //����� ����� ����������� id �� theme_item.xml
        int[] to = { R.id. };
        
        adapter = new SimpleAdapter(this, list, R.layout.theme_item.xml,
                from, to);
        setListAdapter(adapter);
	}

}

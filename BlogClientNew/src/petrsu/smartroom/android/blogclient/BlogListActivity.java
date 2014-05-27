package petrsu.smartroom.android.blogclient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import petrsu.smartroom.android.blogclient.xmlrpcclient.LJRuntimeException;

import android.os.AsyncTask;
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
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class BlogListActivity extends ListActivity implements OnItemClickListener{
	
	//����� ��������� ��� Map
	public final String THEME_SUBJECT = "name";
	
	public static BlogListActivity act;
	
	/** KP, ���������� �� ��������� ������ ���. */
	private KP KP;

	/** ���������, ������������ ��� �������� � ������ Activity. */
	Intent intent;

	/** ������ ���, ���������� �� KP. */
	String[] themes;

	/** ���� ��� �����������. */
	public static Blog blog;
	
	/** ������ ���, �������������� � ���������� � �������. */
	public List<Map<String, ?>> list;

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

		//KP.getThemes(this);
		
		act = this;
		intent = getIntent();
		
		String login;
		String pass;
		
		try {
			login = KP.getLog();
			pass = KP.getPass();
		}
		catch (Exception e) {
			BlogErrDialog.loadLogPass(getBaseContext());
			return;
		}

		try {
			KP.blogAdapter.setLogPass(login, pass);
			KP.blogAdapter.setSRName((String) getIntent().getExtras().get("SRName"));
		}
		catch (Exception e) {
			BlogErrDialog.loadLogPass(getBaseContext());
			return;
		}
		
		blog = new Blog();
		KP.blogAdapter.curLogin = "notauthorized";
		
		/*for (int i = 0; i < themes.length; i++) {
			String[] s = themes[i].split(" ");
			Theme t = null;
			try {
				t = new Theme(Integer.parseInt(s[0]), s[1], new SimpleDateFormat().parse(s[2]), 
						blogAdapter.getBlogEntry(Integer.parseInt(s[0])));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			blog.add(t);
		}*/
		
		//setUpList();
		
		//String[] testThemes = {"1 planned", "2 canceled"};
		//themes = testThemes;
		//String login = "smartRoomUser";
		//String pass = "Ochen_slojnii_parol";
		
		/*blogAdapter = new BlogAdapter();
		
		blogAdapter.setLogPass(login, pass);
		blogAdapter.setSRName((String) getIntent().getExtras().get("SRName"));*/

		new getThemesTask().execute();
		
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
		ListView lv = this.getListView();
		lv.setOnItemClickListener(itemListener);
		
	}

	/** 
	* ���������� ��� �������� ����. ��������� � ���� ������ "Account settings" � "Log out" ��� ������, � "Refresh" ��� ������.
	* @param menu ������, �������������� ����
	* @returns ���� ����, ��� ���� ����� ����������
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		if (AuthorizationActivity.isChairman)
			getMenuInflater().inflate(R.menu.blog_list_menu_chairman, menu);
		else
			getMenuInflater().inflate(R.menu.blog_list_menu, menu);
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
		case R.id.action_refresh:
			act.startActivity(intent);
			act.finish();
			break;
		case R.id.delete_blog:
			KP.deletePublishedData();
			act.startActivity(intent);
			act.finish();
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
	public void setUpList() {
		String[] items = blog.getThemeSubjects();
		//String[] items = blog.getTestThemes();
		
		if (items == null)
			return;
		
		list = new ArrayList<Map<String, ?>>(items.length);
        
        for(int i = 0; i < items.length; i++)
        {
            Map<String, String> map = new HashMap<String, String>();
            map.put(THEME_SUBJECT, items[i]);
            list.add(map);
        }
        
        //������ ���� ���������, �� ������� ����� �������� ������
        String[] from = { THEME_SUBJECT };
        //������ ID View-�����������, � ������� ����� ����������� ������
        int[] to = { R.id.theme_name };
        
        adapter = new SimpleAdapter(this, list, R.layout.theme_item,
                from, to);
        setListAdapter(adapter);
	}
	
	public class getThemesTask extends AsyncTask {

		@Override
		protected Object doInBackground(Object... arg0) {
			try {
				if (!KP.blogAdapter.isLoggedIn())
					KP.blogAdapter.login();
				KP.getThemes(act);
			}
			catch (Exception e) {
				return null;
			}
			return new Object();
		}

		protected void onPostExecute(Object result) {
			super.onPostExecute(result);
			if (result == null)
				BlogErrDialog.loadThemesErr(getApplicationContext());
			else
				setUpList();
		}

	}

	//isnt actually used :3
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}
	
	public void addThemeItemToList(String id, String status) {
		try {
			blog.add(new Theme(Integer.parseInt(id), status,
					KP.blogAdapter.getBlogEntry(Integer.parseInt(id))));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

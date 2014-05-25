package petrsu.smartroom.android.blogclient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;

public class CommentsListActivity extends ListActivity {
	
	//����� ��������� ��� Map
	public final String COMMENT_AUTHOR = "author";
	public String COMMENT_TIME = "time";
	public String COMMENT_TEXT = "text";
	
	/** ���������, ������������ ��� �������� � ������ Activity. */
	Intent intent;

	/** ����, ����������� � ������� ������������. */
	private Theme theme;
	 
	/** ������� ������ ������������. */
	private SimpleAdapter adapter;
	
	private ThemeComment[] items;
	
	/** ������ ������������, �������������� � ��������� � �������. */
	public List<Map<String, ?>> list;
	
	
	//for test
		private ArrayList<ThemeComment> comms = new ArrayList<ThemeComment>();
	
	//for test
		public void addTestComment(String[] t) {
			if (comms == null)
				comms = new ArrayList<ThemeComment>();
			ThemeComment tm = null;
			if (t == null)
				tm = null;
			else
				tm = new ThemeComment(t[0], t[1], t[2]);
			comms.add(tm);
		}
		
		//for test
		public void setNullTestComments() {
			comms = null;
		}

	//for test
	public ThemeComment[] getTestComments(){
		if (comms == null)
			return null;
		ThemeComment[] c1 = new ThemeComment[comms.size()];
		for (int i = 0; i < c1.length; i++)
			c1[i] = comms.get(i);
		
		return c1;
	}

	/** 
	* ���������� ��� �������� ���������� ������ � �������� �� ��� �������������. ���������� ������ ������������, ��������������� ����, ���������� � ���������, ������� ��������� CommentsListActivity.
	* @param savedInstanceState ����������� ��������� Activity
	* 
	* �������� �������: setUpList()
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);			
		theme = (Theme) getIntent().getExtras().get("theme");
		
		new getCommentsTask().execute();
		//setUpList();
	}

	/** 
	* ���������� ��� �������� ����. ��������� � ���� "Log out" � "Leave a comment" ��� ������ � "Refresh" ��� ������.
	* @param menu ������, �������������� ����
	* @returns ������������ �������� �� ������������
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comments_list_menu, menu);
		return true;
	}
	

	/** 
	* ��������� ������ ������������ (�������������� ������ �� theme ��� ���� ����� ��������� �� � adapter).,
	* �������� �� � adapter).
	* Calls for: BlogAdapter.getComments(Theme theme)
	*/
	public void setUpList() {
		//ThemeComment[] items = BlogListActivity.blogAdapter.getComments(theme); // is now global var
		//ThemeComment[] items = getTestComments(); 
		
		
		if (items == null){
			System.out.println("");
			return;
		}
		
		list = new ArrayList<Map<String, ?>>(items.length);
        
        for(int i = 0; i < items.length; i++)
        {
            Map<String, String> map = new HashMap<String, String>();
            map.put(COMMENT_AUTHOR, items[i].getPosterName());
            map.put(COMMENT_TIME, new SimpleDateFormat("HH:mm").format(items[i].getTime()));
            map.put(COMMENT_TEXT, items[i].getText());
            list.add(map);
        }
        
        //������ ���� ���������, �� ������� ����� �������� ������
        String[] from = { COMMENT_AUTHOR, COMMENT_TIME, COMMENT_TEXT };
        //������ ID View-�����������, � ������� ����� ����������� ������
        int[] to = { R.id.comment_author, R.id.comment_time, R.id.comment_text };
        
        adapter = new SimpleAdapter(this, list, R.layout.comment_item,
                from, to);
        setListAdapter(adapter);
	}

	/** 
	* ���������� ��� ������ ������ ����. 
	* "Leave a comment" - ��������� �������� intent � ��������� LeavingCommentActivity.
	* "Log out" - ��������� �������� intent � ��������� AuthorizationActivity.
	* "Refresh" - ��������� ������ ���.
	* @param item ������, �������������� ����� ����
	* @returns ������������ �������� �� ������������
	* 
	* �������� �������: onCreate(Bundle savedInstanceState)
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
	
	public class getCommentsTask extends AsyncTask {

		@Override
		protected Object doInBackground(Object... arg0) {
			items = BlogListActivity.blogAdapter.getComments(theme);
			if(items == null){
				Log.e("getComments returned null","getComments returned null");
			}
			return null;
		}

		protected void onPostExecute(Object result) {
			super.onPostExecute(result);
			setUpList();
		}

	}
}

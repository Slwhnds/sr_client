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
	
	//����� ��������� ��� Map
	final String COMMENT_AUTHOR = "author";
	final String COMMENT_TIME = "time";
	final String COMMENT_TEXT = "text";
	
	/** ���������, ������������ ��� �������� � ������ Activity. */
	Intent intent;

	/** ����, ����������� � ������� ������������. */
	private Theme theme;
	 
	/** ������� ������ ������������. */
	private SimpleAdapter adapter;
	
	/** ������ ������������, �������������� � ��������� � �������. */
	List<Map<String, ?>> list;

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
		setUpList();
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
}

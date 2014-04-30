package petrsu.smartroom.android.blogclient;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;

public class CommensListActivity extends Activity {
	
	/** ���������, ������������ ��� �������� � ������ Activity. */
	Intent intent;

	/** ����-������� ��� ��������� ������ ������������. */
	//BlogAdapter blogAdapter;

	/** ����, ����������� � ������� ������������. */
	//private Theme theme;
	 
	/** ������� ������ ������������. */
	private SimpleAdapter adapter;

	/** ������ "Leave a comment". */
	private Button leaveCommentButton;

	/** 
	* ���������� ��� �������� ���������� ������ � �������� �� ��� �������������. ���������� ������ ������������, ��������������� ����, ���������� � ���������, ������� ��������� CommentsListActivity.
	* @param savedInstanceState ����������� ��������� Activity
	* 
	* �������� �������: setUpList()
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_commens_list);
	}

	/** 
	* ���������� ��� �������� ����. ��������� � ���� "Log out" � "Leave a comment" ��� ������ � "Refresh" ��� ������.
	* @param menu ������, �������������� ����
	* @returns ������������ �������� �� ������������
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.commens_list, menu);
		return true;
	}
	

	/** 
	* ��������� ������ ������������ (�������������� ������ �� theme ��� ���� ����� ��������� �� � adapter).,
	* �������� �� � adapter).
	* Calls for: BlogAdapter.getComments(Theme theme)
	*/
	private void setUpList() {
		
	}

	/** ����������� ��� ������� �� ������ "Leave a comment". ��������� �������� intent � ���������  LeavingCommentActivity.
	* @param v ������� ������
	*/
	public void onLeaveComment(View v) {
		
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
		return false;
		
	}
}

package petrsu.smartroom.android.blogclient;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThemeActivity extends Activity {
	
	/** ���������, ������������ ��� �������� � ������ Activity */
	Intent intent;

	/** ���� ��� �����������. */
	//private Theme theme;

	/** ������� ����. */
	//private Blog blog;

	/** ����� ��� ����������� ��������� ����. */
	private TextView themeNameTextView;

	/** ����� ��� ����������� ������ ����. */
	private TextView themeTextTextView;

	/** ������ "View comments". */
	private Button viewCommentsButton;

	/** ������ "Leave a comment". */
	private Button leaveCommentButton ;

	/** 
	* ���������� ��� �������� ���������� ������ � �������� �� ��� �������������. �������� � ����������� Activity ��������� ������� ���� � ����, ���������� ��.
	* @param savedInstanceState ����������� ��������� Activity
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_theme);
	}

	/** 
	* ���������� ��� �������� ����. ��������� � ���� "Log out" ��� �����.
	* @param menu ������, �������������� ����
	* @returns ������������ �������� �� ������������
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.theme, menu);
		return true;
	}
	

	/** ����������� ��� ������� �� ������ "View comments". ��������� �������� intent � ��������� CommentsListActivity ��� ���� theme.
	* @param v ������� ������
	*/
	public void onViewComments(View v) {
		
	}

	/** ����������� ��� ������� �� ������ "Leave a comment". ��������� �������� intent � ���������  LeavingCommentActivity.
	* @param v ������� ������
	*/
	public void onLeaveComment(View v) {
		
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

package petrsu.smartroom.android.blogclient;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LeavingCommentActivity extends Activity {
	
	/** ���������, ������������ ��� �������� � AutorizationActivity */
	Intent intent;

	/** ����-������� ��� ���������� �����������. */
	//BlogAdapter blogAdapter;

	/** ����, � ������� ����������� �����������. */
	//private Theme theme;

	/** ��������� ����� �����������. */
	private String commentText;

	/** ������ "Publish". */
	private Button publishButton;

	/** ���� ��� ����� ������ �����������. */
	private EditText commentEditText;

	/** 
	* ���������� ��� �������� ���������� ������ � �������� �� ��� �������������. ����������� � BlogAdapter ��������� ����, � ������� ����������� �����������, � ���������� ���
	* @param savedInstanceState ����������� ��������� Activity
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leaving_comment);
	}


	/** 
	* ���������� ��� �������� ����. ��������� � ���� "Log out" ��� �����.
	* @param menu ������, �������������� ����
	* @returns ������������ �������� �� ������������
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.leaving_comment, menu);
		return true;
	}

	/** ����������� ��� ������� �� ������ "Publish". 
	* @param v ������� ������
	*
	* �������� �������: BlogAdapter.postComment(String body, Theme theme) 
	*/
	public void onPublish(View v) {
		
	}

	/** 
	* ���������� ��� ������ ������ ����. 
	* "Log out" - ��������� �������� intent � ��������� AuthorizationActivity.
	* @param item ������, �������������� ����� ����
	* @returns ������������ �������� �� ������������
	*/
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return false;
		
	}

}

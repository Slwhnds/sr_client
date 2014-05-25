package petrsu.smartroom.android.blogclient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LeavingCommentActivity extends Activity {
	
	/** ���������, ������������ ��� �������� � AutorizationActivity */
	Intent intent;

	/** ����, � ������� ����������� �����������. */
	private Theme theme;

	/** ��������� ����� �����������. */
	private String commentText;

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
		commentEditText = (EditText) findViewById(R.id.editTextLeaveComment);
		theme = (Theme) getIntent().getExtras().get("theme");
	}


	/** 
	* ���������� ��� �������� ����. ��������� � ���� "Log out" ��� �����.
	* @param menu ������, �������������� ����
	* @returns ������������ �������� �� ������������
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.leaving_comment_menu, menu);
		return true;
	}

	/** ����������� ��� ������� �� ������ "Publish". 
	* @param v ������� ������
	*
	* �������� �������: BlogAdapter.postComment(String body, Theme theme) 
	*/
	public void onPublish(View v) {
		commentText = commentEditText.getText().toString();
		if (commentText == "")
			BlogErrDialog.emptyComment(getBaseContext());
		new publishCommentTask().execute();
	}

	/** 
	* ���������� ��� ������ ������ ����. 
	* "Log out" - ��������� �������� intent � ��������� AuthorizationActivity.
	* @param item ������, �������������� ����� ����
	* @returns ������������ �������� �� ������������
	*/
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.log_out:
			this.finish();
			break;
		default:
			return super.onOptionsItemSelected(item);
		}
		return true;
	}
	
	public class publishCommentTask extends AsyncTask {

		@Override
		protected Object doInBackground(Object... arg0) {
			BlogListActivity.blogAdapter.postComment(commentText, theme);
			return null;
		}


	}

}

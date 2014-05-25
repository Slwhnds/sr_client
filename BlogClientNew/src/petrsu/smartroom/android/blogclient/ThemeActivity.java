package petrsu.smartroom.android.blogclient;

import java.text.SimpleDateFormat;

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
	private Theme theme;

	/** ����� ��� ����������� ��������� ����. */
	private TextView themeNameTextView;

	/** ����� ��� ����������� ������ ����. */
	private TextView themeTextTextView;
	
	/** ����� ��� ����������� ������� �����������. */
	private TextView speechTimeTextView;
	
	/** ����� ��� ����������� ����� ����������. */
	private TextView reporterNameTextView;
	
	/** 
	* ���������� ��� �������� ���������� ������ � �������� �� ��� �������������. �������� � ����������� Activity ��������� ������� ���� � ����, ���������� ��.
	* @param savedInstanceState ����������� ��������� Activity
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_theme);
		
		//theme = (Theme) getIntent().getExtras().get("theme");
		
		/*themeNameTextView = (TextView) findViewById(R.id.title_theme_name);
		themeNameTextView.setText(theme.getSubject());
		
		themeTextTextView = (TextView) findViewById(R.id.theme_text);
		themeTextTextView.setText(theme.getText());
		
		
		/*
		speechTimeTextView = (TextView) findViewById(R.id.speech_time);
		SimpleDateFormat sm = new SimpleDateFormat("hh:mm");
		speechTimeTextView.setText(sm.format(theme.getTime()));
		
		reporterNameTextView = (TextView) findViewById(R.id.reporter_name);*/
		//reporterNameTextView.setText(theme.getRepoter());
	}

	/** 
	* ���������� ��� �������� ����. ��������� � ���� "Log out" ��� �����.
	* @param menu ������, �������������� ����
	* @returns ������������ �������� �� ������������
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.theme_menu, menu);
		return true;
	}
	

	/** ����������� ��� ������� �� ������ "View comments". ��������� �������� intent � ��������� CommentsListActivity ��� ���� theme.
	* @param v ������� ������
	*/
	public void onViewComments(View v) {
		intent = new Intent(getBaseContext(), CommentsListActivity.class);
		intent.putExtra("theme", theme);
	    startActivity(intent);
	}

	/** ����������� ��� ������� �� ������ "Leave a comment". ��������� �������� intent � ���������  LeavingCommentActivity.
	* @param v ������� ������
	*/
	public void onLeaveComment(View v) {
		intent = new Intent(getBaseContext(), LeavingCommentActivity.class);
		intent.putExtra("theme", theme);
	    startActivity(intent);
	}

	/** 
	* ���������� ��� ������ ������ ����. 
	* "Log out" - ��������� �������� intent � ��������� AutorizationActivity.
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

}

package petrsu.smartroom.android.cameraclient;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.VideoView;

public class CameraActivity extends Activity {

	
	/** ������ ��� ���������� � ��������� �����. */
	//private Camera camera;

	/** ���������, ������������ ��� �������� � AutorizationActivity */
	Intent intent;

	/** ������ ��� ����������� �����. */
	private VideoView cameraView;

	/** ������� ��������. */
	private SeekBar panBar;

	/** ������� �������. */
	private SeekBar tiltBar;

	/** ������� ����. */
	private SeekBar zoomBar;

	/** ������ ��� �������� ��������� �������� pan-tilt-zoom */
	private int[][] borders;

	/** ��������� ������� ��������, �������� �� ��������� ��������� �������� */
	private SeekBar.OnSeekBarChangeListener seekBarListener;
	
	/** 
	* ���������� ��� �������� ���������� ������ � �������� �� ��� �������������
	* @param savedInstanceState ����������� ��������� Activity
	*
	* �������� ������: setSeekBarBorders()
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
		
		seekBarListener = 
			    new SeekBar.OnSeekBarChangeListener() {
			/**
			* ����������� ��� ��������� �������� ��������. ������ ������ ������� �� �������/������/��� �������������� ��������, �������� �������� ����������, � ��������, �� ������� ���������� ��������.
			* @param seekBar �������, �������� �������� ����������
			* @param progress ����� ��������
			* @param fromUser ���� �� ��������� �������� ������� �������������
			*
			* �������� ������: Camera.setPTZ(int P, int T, int Z)
			*/
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}
		};
	}

	/** 
	* ���������� ��� �������� ����. ��������� � ���� "Log out" ��� �����.
	* @param menu ������, �������������� ����
	* @returns ������������ �������� �� ������������
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.camera, menu);
		return true;
	}

	/**
	* ������������� ������������ �������� ��� ���������, ��������������� ��������� � �������� borders.
	* @throws NullPointerExeption
	* Calls for: Camera.getBorders()
	*/
	private void setSeekBarBorders(int[][] borders) {
		
	}

	/**
	* ������������� ������������ �������� ��� ���������, ��������������� ��������� � �������� borders.
	* @throws NullPointerExeption
	* Calls for: Camera.getCurrentPTZ()
	*/
	private void setSeekBarValues(int[][] ptz) {
		
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

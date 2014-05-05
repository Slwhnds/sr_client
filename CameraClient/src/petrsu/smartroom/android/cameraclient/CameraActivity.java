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
	private Camera camera;

	/** ������ ��� ����������� �����. */
	private VideoView cameraView;

	/** ������� ��������. */
	private SeekBar panBar;
	
	private int panMin;

	/** ������� �������. */
	private SeekBar tiltBar;
	
	private int tiltMin;

	/** ������� ����. */
	private SeekBar zoomBar;
	
	private int zoomMin;

	/** ��������� ������� ��������, �������� �� ��������� ��������� �������� */
	private SeekBar.OnSeekBarChangeListener seekBarListener;
	
	/** 
	* ���������� ��� �������� ���������� ������ � �������� �� ��� �������������
	* @param savedInstanceState ����������� ��������� Activity
	*
	* �������� ������: setSeekBarBorders(int[][] borders), setSeekBarValues(int[] values)
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
		
		camera = getIntent().getExtras().get("camera");
		
		setSeekBarBorders(camera.getBorders());
		setSeekBarValues(camera.getCurrentPTZ());
		
		cameraView = new VideoView(getBaseContext());
		cameraView.setVideoUri(camera.getURI());
		
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
				int p = panBar.getProgress() + panMin;
				int t = tiltBar.getProgress() + tiltMin;
				int z = zoomBar.getProgress() + zoomMin;
				camera.setPTZ(p, t, z);
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
	* ������������� ������������ �������� ��� ���������, ��������������� ��������� � �������� camera.
	* @throws NullPointerExeption
	*/
	private void setSeekBarBorders(int[][] borders) {
		panBar.setMax(borders[0][1] - borders[0][0]);
		panMin = borders[0][0];
		tiltBar.setMax(borders[1][1] - borders[1][0]);
		tiltMin = borders[1][0];
		zoomBar.setMax(borders[2][1] - borders[2][0]);
		zoomMin = borders[2][0];
	}

	/**
	* ������������� ������� �������� ��� ���������, ��������������� ��������� � �������� camera.
	* @throws NullPointerExeption
	*/
	private void setSeekBarValues(int[] ptz) {
		panBar.setProgress(ptz[0]);
		tiltBar.setProgress(ptz[1]);
		zoomBar.setProgress(ptz[2]);
	}
}

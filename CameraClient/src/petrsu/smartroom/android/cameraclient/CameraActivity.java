package petrsu.smartroom.android.cameraclient;

import java.io.IOException;

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
		
		camera = (Camera) getIntent().getExtras().get("camera");
		
		setSeekBarBorders(camera.getBorders());
		setSeekBarValues(camera.getCurrentPTZ());
		
		cameraView = new VideoView(getBaseContext());
		cameraView.setVideoURI(camera.getURI());
		
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
				try {
					camera.setPTZ(p, t, z);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
	* ���������� ��� �������� ����. 
	* @param menu ������, �������������� ����
	* @returns ������������ �������� �� ������������
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.camera_menu, menu);
		return true;
	}

	/**
	* ������������� ������������ �������� ��� ���������, ��������������� ��������� � �������� camera.
	* @throws NullPointerExeption
	*/
	private void setSeekBarBorders(int[][] borders) {
		if (borders == null) {
			panBar.setFocusable(false);
			tiltBar.setFocusable(false);
			zoomBar.setFocusable(false);
			return;
		}
		
		if ((borders[0][1] < 0) ||
				(borders[0][0] < 0) ||
				(borders[0][1] < borders[0][0]))
			panBar.setFocusable(false);
		else {
			panBar.setMax(borders[0][1] - borders[0][0]);
			panMin = borders[0][0];
		}
		
		if ((borders[1][1] < 0) ||
				(borders[1][0] < 0) ||
				(borders[1][1] < borders[1][0]))
			tiltBar.setFocusable(false);
		else {
			tiltBar.setMax(borders[1][1] - borders[1][0]);
			tiltMin = borders[1][0];
		}
		
		if ((borders[2][1] < 0) ||
				(borders[2][0] < 0) ||
				(borders[2][1] < borders[2][0]))
			tiltBar.setFocusable(false);
		else {
			zoomBar.setMax(borders[2][1] - borders[2][0]);
			zoomMin = borders[2][0];
		}
	}

	/**
	* ������������� ������� �������� ��� ���������, ��������������� ��������� � �������� camera.
	* @throws NullPointerExeption
	*/
	private void setSeekBarValues(int[] ptz) {
		if (ptz == null) {
			panBar.setFocusable(false);
			tiltBar.setFocusable(false);
			zoomBar.setFocusable(false);
			return;
		}
		
		if ((ptz[0] < panMin) ||
				(ptz[0] > panBar.getMax()))
			panBar.setFocusable(false);
		else
			panBar.setProgress(ptz[0] - panMin);
		
		if ((ptz[1] < tiltMin) ||
				(ptz[1] > tiltBar.getMax()))
			tiltBar.setFocusable(false);
		else
			tiltBar.setProgress(ptz[1] - tiltMin);
		
		if ((ptz[2] < zoomMin) ||
				(ptz[2] > zoomBar.getMax()))
			zoomBar.setFocusable(false);
		else
			zoomBar.setProgress(ptz[2] - zoomMin);
	}
}

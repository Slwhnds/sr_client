package petrsu.smartroom.android.cameraclient;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.VideoView;

public class CameraActivity extends Activity {

	
	/** Камера для управления и просмотра видео. */
	private Camera camera;

	/** Служит для отображения видео. */
	private VideoView cameraView;

	/** Слайдер поворота. */
	private SeekBar panBar;
	
	private int panMin;

	/** Слайдер наклона. */
	private SeekBar tiltBar;
	
	private int tiltMin;

	/** Слайдер зума. */
	private SeekBar zoomBar;
	
	private int zoomMin;

	/** Слушатель событий слайдера, отвечает за обработку изменения значений */
	private SeekBar.OnSeekBarChangeListener seekBarListener;
	
	/** 
	* Вызывается при создании экземпляра класса и отвечает за его инициализацию
	* @param savedInstanceState сохраненное состояние Activity
	*
	* Вызывает методы: setSeekBarBorders(int[][] borders), setSeekBarValues(int[] values)
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
			* Срабатывает при изменении значения слайдера. Отдает камере команду на поворот/наклон/зум соответственно слайдеру, значение которого изменилось, и величине, на которую изменилось значение.
			* @param seekBar слайдер, значение которого изменилось
			* @param progress новое значение
			* @param fromUser было ли изменение значения вызвано пользователем
			*
			* Вызывает методы: Camera.setPTZ(int P, int T, int Z)
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
	* Вызывается при создании меню. 
	* @param menu объект, представляющий меню
	* @returns возвращаемое значение не используется
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.camera_menu, menu);
		return true;
	}

	/**
	* Устанавливает максимальные значения для слайдеров, соответствующие значениям в свойстве camera.
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
	* Устанавливает текущие значения для слайдеров, соответствующие значениям в свойстве camera.
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

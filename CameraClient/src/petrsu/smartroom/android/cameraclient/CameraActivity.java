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
	//private Camera camera;

	/** Намерение, используемое для перехода к AutorizationActivity */
	Intent intent;

	/** Служит для отображения видео. */
	private VideoView cameraView;

	/** Слайдер поворота. */
	private SeekBar panBar;

	/** Слайдер наклона. */
	private SeekBar tiltBar;

	/** Слайдер зума. */
	private SeekBar zoomBar;

	/** Массив для хранения граничных значений pan-tilt-zoom */
	private int[][] borders;

	/** Слушатель событий слайдера, отвечает за обработку изменения значений */
	private SeekBar.OnSeekBarChangeListener seekBarListener;
	
	/** 
	* Вызывается при создании экземпляра класса и отвечает за его инициализацию
	* @param savedInstanceState сохраненное состояние Activity
	*
	* Вызывает методы: setSeekBarBorders()
	*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
		
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
	* Вызывается при создании меню. Добавляет в меню "Log out" как пункт.
	* @param menu объект, представляющий меню
	* @returns возвращаемое значение не используется
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.camera, menu);
		return true;
	}

	/**
	* Устанавливает максимальные значения для слайдеров, соответствующие значениям в свойстве borders.
	* @throws NullPointerExeption
	* Calls for: Camera.getBorders()
	*/
	private void setSeekBarBorders(int[][] borders) {
		
	}

	/**
	* Устанавливает максимальные значения для слайдеров, соответствующие значениям в свойстве borders.
	* @throws NullPointerExeption
	* Calls for: Camera.getCurrentPTZ()
	*/
	private void setSeekBarValues(int[][] ptz) {
		
	}

	/** 
	* Вызывается при выборе пункта меню. 
	* "Log out" - Формирует свойство intent и запускает AutorizationActivity.
	* @param item объект, представляющий пункт меню
	* @returns возвращаемое значение не используется
	*/
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return false;
		
	}

}

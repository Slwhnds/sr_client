package petrsu.smartroom.android.cameraclient;

import android.content.Context;
import android.widget.Toast;

public class CameraErrDialog {

	public CameraErrDialog() {
		// TODO Auto-generated constructor stub
	}

	public static void loadCameraErr(Context context) {
		Toast toast = Toast.makeText(context, R.string.failed_loading_cameras,
				Toast.LENGTH_SHORT);
		toast.show();
	}
	

	public static void connectionErr(Context context) {
		Toast toast = Toast.makeText(context, R.string.failed_connecton,
				Toast.LENGTH_SHORT);
		toast.show();
	}
}

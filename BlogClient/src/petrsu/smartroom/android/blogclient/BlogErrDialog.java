package petrsu.smartroom.android.blogclient;

import petrsu.smartroom.android.cameraclient.R;
import android.content.Context;
import android.widget.Toast;

public class BlogErrDialog {

	public BlogErrDialog() {
		// TODO Auto-generated constructor stub
	}

	public static void loadThemesErr(Context context) {
		Toast toast = Toast.makeText(context, R.string.failed_loading_blog,
				Toast.LENGTH_SHORT);
		toast.show();
	}
	

	public static void loadLogPass(Context context) {
		Toast toast = Toast.makeText(context, R.string.failed_loading_logpass,
				Toast.LENGTH_SHORT);
		toast.show();
	}
}

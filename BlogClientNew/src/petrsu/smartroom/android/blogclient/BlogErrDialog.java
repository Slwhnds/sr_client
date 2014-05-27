package petrsu.smartroom.android.blogclient;

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
	
	public static void fillLogPass(Context context) {
		Toast toast = Toast.makeText(context, R.string.emptyFields,
				Toast.LENGTH_SHORT);
		toast.show();
	}

	public static void emptyComment(Context context) {
		Toast toast = Toast.makeText(context, R.string.emptyComment,
				Toast.LENGTH_SHORT);
		toast.show();
	}

	public static void errComment(Context context) {
		Toast toast = Toast.makeText(context, R.string.errComment,
				Toast.LENGTH_SHORT);
		toast.show();
	}
	
	public static void errLoadComments(Context context) {
		Toast toast = Toast.makeText(context, R.string.errLoadComments,
				Toast.LENGTH_SHORT);
		toast.show();
	}
	
	public static void loginErr(Context context) {
		Toast toast = Toast.makeText(context, R.string.errLogin,
				Toast.LENGTH_SHORT);
		toast.show();
	}
	
	public static void loginYes(Context context) {
		Toast toast = Toast.makeText(context, R.string.loginYes,
				Toast.LENGTH_SHORT);
		toast.show();
	}
}

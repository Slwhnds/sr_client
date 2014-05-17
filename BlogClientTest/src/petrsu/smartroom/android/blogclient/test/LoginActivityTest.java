package petrsu.smartroom.android.blogclient.test;
import petrsu.smartroom.android.blogclient.LoginActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity> {

	LoginActivity activity;
	TextView title_theme_name;
	TextView title_login;
	TextView title_password;
	TextView title_logged_as;
	Button login_button;
	EditText password_edit;
	EditText login_edit;
	EditText logged_as_edit;
	
	public LoginActivityTest() {
		super(LoginActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		activity = (LoginActivity) getActivity();
		title_theme_name = (TextView) activity.findViewById
				(petrsu.smartroom.android.blogclient.R.id.title_theme_name);
		title_login = (TextView) activity.findViewById
				(petrsu.smartroom.android.blogclient.R.id.title_login);
		title_password = (TextView) activity.findViewById
				(petrsu.smartroom.android.blogclient.R.id.title_password);
		title_logged_as = (TextView) activity.findViewById
				(petrsu.smartroom.android.blogclient.R.id.title_logged_as);
		login_button = (Button) activity.findViewById
				(petrsu.smartroom.android.blogclient.R.id.login_button);
		password_edit = (EditText) activity.findViewById
				(petrsu.smartroom.android.blogclient.R.id.password_edit);
		login_edit = (EditText) activity.findViewById
				(petrsu.smartroom.android.blogclient.R.id.login_edit);
		logged_as_edit = (EditText) activity.findViewById
				(petrsu.smartroom.android.blogclient.R.id.logged_as_edit);
	}
	
	public void testOnCreate22_1() {
		assertNotNull(activity);
		assertNotNull(title_theme_name);
		assertNotNull(title_login);
		assertNotNull(title_password);
		assertNotNull(title_logged_as);
		assertNotNull(login_button);
		assertNotNull(password_edit);
		assertNotNull(login_edit);
		assertNotNull(logged_as_edit);
		ViewAsserts.assertOnScreen(title_theme_name.getRootView(), title_theme_name);
		ViewAsserts.assertOnScreen(title_login.getRootView(), title_login);
		ViewAsserts.assertOnScreen(title_password.getRootView(), title_password);
		ViewAsserts.assertOnScreen(title_logged_as.getRootView(), title_logged_as);
		ViewAsserts.assertOnScreen(login_button.getRootView(), login_button);
		ViewAsserts.assertOnScreen(password_edit.getRootView(), password_edit);
		ViewAsserts.assertOnScreen(login_edit.getRootView(), login_edit);
		ViewAsserts.assertOnScreen(logged_as_edit.getRootView(), logged_as_edit);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}

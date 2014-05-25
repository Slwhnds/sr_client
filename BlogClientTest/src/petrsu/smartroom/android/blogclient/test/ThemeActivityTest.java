package petrsu.smartroom.android.blogclient.test;
import petrsu.smartroom.android.blogclient.ThemeActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.Button;
import android.widget.TextView;

public class ThemeActivityTest extends ActivityInstrumentationTestCase2<ThemeActivity> {

	ThemeActivity activity;
	TextView title_theme_name;
	TextView theme_text;
	Button view_comments_button;
	Button leave_comment_button;
	
	public ThemeActivityTest() {
		super(ThemeActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		activity = (ThemeActivity) getActivity();
		title_theme_name = (TextView) activity.findViewById
				(petrsu.smartroom.android.blogclient.R.id.title_theme_name);
		theme_text = (TextView) activity.findViewById
				(petrsu.smartroom.android.blogclient.R.id.theme_text);
		view_comments_button = (Button) activity.findViewById
				(petrsu.smartroom.android.blogclient.R.id.view_comments_button);
		leave_comment_button = (Button) activity.findViewById
				(petrsu.smartroom.android.blogclient.R.id.leave_comment_button);
	}
	
	public void testOnCreate23_1() {
		assertNotNull(activity);
		assertNotNull(title_theme_name);
		assertNotNull(theme_text);
		assertNotNull(view_comments_button);
		assertNotNull(leave_comment_button);
		ViewAsserts.assertOnScreen(title_theme_name.getRootView(), title_theme_name);
		ViewAsserts.assertOnScreen(theme_text.getRootView(), theme_text);
		ViewAsserts.assertOnScreen(view_comments_button.getRootView(), view_comments_button);
		ViewAsserts.assertOnScreen(leave_comment_button.getRootView(), leave_comment_button);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}


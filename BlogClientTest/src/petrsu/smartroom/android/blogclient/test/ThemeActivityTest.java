package petrsu.smartroom.android.blogclient.test;
import petrsu.smartroom.android.blogclient.ThemeActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.Button;
import android.widget.TextView;

public class ThemeActivityTest extends ActivityInstrumentationTestCase2<ThemeActivity> {

ThemeActivity activity;
TextView title_theme_name;
TextView title_speech_time;
TextView speech_time;
TextView title_reporter;
TextView reporter_name;
TextView title_authors;
TextView authors_names;
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
title_speech_time = (TextView) activity.findViewById
(petrsu.smartroom.android.blogclient.R.id.title_speech_time);
speech_time = (TextView) activity.findViewById
(petrsu.smartroom.android.blogclient.R.id.speech_time);
title_reporter = (TextView) activity.findViewById
(petrsu.smartroom.android.blogclient.R.id.title_reporter);
reporter_name = (TextView) activity.findViewById
(petrsu.smartroom.android.blogclient.R.id.reporter_name);
title_authors = (TextView) activity.findViewById
(petrsu.smartroom.android.blogclient.R.id.title_authors);
authors_names = (TextView) activity.findViewById
(petrsu.smartroom.android.blogclient.R.id.authors_names);
theme_text = (TextView) activity.findViewById
(petrsu.smartroom.android.blogclient.R.id.theme_text);
view_comments_button = (Button) activity.findViewById
(petrsu.smartroom.android.blogclient.R.id.view_comments_button);
leave_comment_button = (Button) activity.findViewById
(petrsu.smartroom.android.blogclient.R.id.leave_comment_button);
}

public void testOnCreate23_1() {
assertNotNull(title_theme_name);
assertNotNull(title_speech_time);
assertNotNull(speech_time);
assertNotNull(title_reporter);
assertNotNull(reporter_name);
assertNotNull(title_authors);
assertNotNull(authors_names);
assertNotNull(theme_text);
assertNotNull(view_comments_button);
assertNotNull(leave_comment_button);
ViewAsserts.assertOnScreen(title_theme_name.getRootView(), title_theme_name);
ViewAsserts.assertOnScreen(title_speech_time.getRootView(), title_speech_time);
ViewAsserts.assertOnScreen(speech_time.getRootView(), speech_time);
ViewAsserts.assertOnScreen(title_reporter.getRootView(), title_reporter);
ViewAsserts.assertOnScreen(reporter_name.getRootView(), reporter_name);
ViewAsserts.assertOnScreen(title_authors.getRootView(), title_authors);
ViewAsserts.assertOnScreen(authors_names.getRootView(), authors_names);
ViewAsserts.assertOnScreen(theme_text.getRootView(), theme_text);
ViewAsserts.assertOnScreen(view_comments_button.getRootView(), view_comments_button);
ViewAsserts.assertOnScreen(leave_comment_button.getRootView(), leave_comment_button);
}

protected void tearDown() throws Exception {
super.tearDown();
}

}
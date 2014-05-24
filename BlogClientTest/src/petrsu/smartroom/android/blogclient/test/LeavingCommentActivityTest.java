package petrsu.smartroom.android.blogclient.test;
import petrsu.smartroom.android.blogclient.LeavingCommentActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;

public class LeavingCommentActivityTest extends ActivityInstrumentationTestCase2<LeavingCommentActivity> {

LeavingCommentActivity activity;
TextView title_leaving_comment;
TextView theme_title;
TextView comment_author_in_leaving_comment;
ImageView icon_author;
EditText editTextLeaveComment;
Button publish_button;

public LeavingCommentActivityTest() {
super(LeavingCommentActivity.class);
}

protected void setUp() throws Exception {
super.setUp();
activity = (LeavingCommentActivity) getActivity();
title_leaving_comment = (TextView) activity.findViewById
(petrsu.smartroom.android.blogclient.R.id.title_leaving_comment);
theme_title = (TextView) activity.findViewById
(petrsu.smartroom.android.blogclient.R.id.theme_title);
comment_author_in_leaving_comment = (TextView) activity.findViewById
(petrsu.smartroom.android.blogclient.R.id.comment_author_in_leaving_comment);
publish_button = (Button) activity.findViewById
(petrsu.smartroom.android.blogclient.R.id.publish_button);
icon_author = (ImageView) activity.findViewById
(petrsu.smartroom.android.blogclient.R.id.icon_author);
editTextLeaveComment = (EditText) activity.findViewById
(petrsu.smartroom.android.blogclient.R.id.editTextLeaveComment);
}

public void testOnCreate26_1() {
assertNotNull(activity);
assertNotNull(title_leaving_comment);
assertNotNull(theme_title);
assertNotNull(comment_author_in_leaving_comment);
assertNotNull(icon_author);
assertNotNull(publish_button);
assertNotNull(editTextLeaveComment);
ViewAsserts.assertOnScreen(title_leaving_comment.getRootView(), title_leaving_comment);
ViewAsserts.assertOnScreen(theme_title.getRootView(), theme_title);
ViewAsserts.assertOnScreen(comment_author_in_leaving_comment.getRootView(), comment_author_in_leaving_comment);
ViewAsserts.assertOnScreen(icon_author.getRootView(), icon_author);
ViewAsserts.assertOnScreen(publish_button.getRootView(), publish_button);
ViewAsserts.assertOnScreen(editTextLeaveComment.getRootView(), editTextLeaveComment);
}

protected void tearDown() throws Exception {
super.tearDown();
}

}
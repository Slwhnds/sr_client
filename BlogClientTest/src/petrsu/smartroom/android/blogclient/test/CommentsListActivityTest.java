package petrsu.smartroom.android.blogclient.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import petrsu.smartroom.android.blogclient.CommentsListActivity;
import android.test.ActivityInstrumentationTestCase2;

public class CommentsListActivityTest extends ActivityInstrumentationTestCase2<CommentsListActivity> {
	
	CommentsListActivity activity;
	String[] correctComment1 = {"comment1", "author1", "00:00"};
	String[] correctComment2 = {"comment2", "author2", "00:00"};
	String[] correctComment3 = {"comment3", "author3", "00:00"};

	public CommentsListActivityTest() {
		super(CommentsListActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		activity = (CommentsListActivity) getActivity();
	}
	
	public void testSetUpList24_1() {
		activity.addTestComment(correctComment1);
        activity.addTestComment(correctComment2);
        activity.addTestComment(correctComment3);
		
		String[][] correctComments = new String[3][3];
		correctComments[0] = correctComment1;
		correctComments[1] = correctComment2;
		correctComments[2] = correctComment3;
		List<Map<String, ?>> list = new ArrayList<Map<String, ?>>(correctComments.length);
        
        for(int i = 0; i < correctComments.length; i++)
        {
            Map<String, String> map = new HashMap<String, String>();
            map.put(activity.COMMENT_AUTHOR, correctComments[i][1]);
            map.put(activity.COMMENT_TIME, correctComments[i][2]);
            map.put(activity.COMMENT_TEXT, correctComments[i][0]);
            list.add(map);
        }
        
		activity.setUpList();
		
		assertEquals(list, activity.list);
	}
	
	public void testSetUpList24_3() {      
		activity.setNullTestComments();
        try {
        	activity.setUpList();
        	fail("NullPointerException expected");
        }
        catch(Exception exception) {
        	assertEquals("Other exception expected", NullPointerException.class, exception.getClass());
        }
	}
	
	public void testSetUpList24_4() {
           
		activity.addTestComment(correctComment1);
		activity.addTestComment(null);
		activity.addTestComment(correctComment3);
        
        try {
        	activity.setUpList();
        	fail("NullPointerException expected");
        }
        catch(Exception exception) {
        	assertEquals("Other exception expected", NullPointerException.class, exception.getClass());
        }
	}
	
	public void testOnCreate25_1() {
		assertNotNull(activity);
	   // ViewAsserts.assertOnScreen(origin, view);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}

package petrsu.smartroom.android.blogclient.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import petrsu.smartroom.android.blogclient.BlogListActivity;
import android.test.ActivityInstrumentationTestCase2;

public class BlogListActivityTest extends ActivityInstrumentationTestCase2<BlogListActivity> {
	
	BlogListActivity activity;
	String[] correctThemes = {"theme1", "theme2", "theme3"};
	String[] nullThemes = null;

	public BlogListActivityTest() {
		super(BlogListActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		activity = (BlogListActivity) getActivity();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testSetUpList20_1() {
		List<Map<String, ?>> list = new ArrayList<Map<String, ?>>(correctThemes.length);
        
        for(int i = 0; i < correctThemes.length; i++)
        {
            Map<String, String> map = new HashMap<String, String>();
            map.put(activity.THEME_SUBJECT, correctThemes[i]);
            list.add(map);
        }
        
        BlogListActivity.blog.setTestThemes(correctThemes);
		activity.setUpList();
		
		assertEquals(list, activity.list);
	}
	
	public void testSetUpList20_3() {      
        BlogListActivity.blog.setTestThemes(nullThemes);
        try {
        	activity.setUpList();
        	fail("NullPointerException expected");
        }
        catch(Exception exception) {
        	assertEquals("Чето не тот exception пришел", NullPointerException.class, exception.getClass());
        }
	}

	/*public void testOnCreate() {
		assertNotNull(activity);
	    assertNotNull(...);
	    
	    ViewAsserts.assertOnScreen(origin, view);
	}*/

}

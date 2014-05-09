package petrsu.smartroom.android.blogclient.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import petrsu.smartroom.android.blogclient.BlogListActivity;
import android.test.ActivityInstrumentationTestCase2;

public class BlogListActivityTest extends ActivityInstrumentationTestCase2 {
	
	BlogListActivity activity;
	String[] themes = {"theme1", "theme2", "theme3"};

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
	
	public void testSetUpList() {
		List<Map<String, ?>> list = new ArrayList<Map<String, ?>>(themes.length);
        
        for(int i = 0; i < themes.length; i++)
        {
            Map<String, String> map = new HashMap<String, String>();
            map.put(activity.THEME_SUBJECT, themes[i]);
            list.add(map);
        }
        
		activity.setUpList();
		
		assertEquals(list, activity.list);
	}

	/*public void testOnCreate() {
		assertNotNull(activity);
	    assertNotNull(...);
	    
	    ViewAsserts.assertOnScreen(origin, view);
	}*/

}

package petrsu.smartroom.android.blogclient.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(BlogListActivityTest.class);
		suite.addTestSuite(CommentsListActivityTest.class);
		suite.addTestSuite(LoginActivityTest.class);
		//$JUnit-END$
		return suite;
	}

}

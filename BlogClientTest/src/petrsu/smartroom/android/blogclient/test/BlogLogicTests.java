package petrsu.smartroom.android.blogclient.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class BlogLogicTests {

public static Test suite() {
TestSuite suite = new TestSuite(AllTests.class.getName());
//$JUnit-BEGIN$
suite.addTestSuite(BlogAdapterTest.class);
suite.addTestSuite(ThemeCommentTest.class);
suite.addTestSuite(ThemeTest.class);
//$JUnit-END$
return suite;
}

}
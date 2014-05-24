package petrsu.smartroom.android.blogclient.test;

import petrsu.smartroom.android.blogclient.BlogAdapter;
import petrsu.smartroom.android.blogclient.Theme;
import petrsu.smartroom.android.blogclient.ThemeComment;
import petrsu.smartroom.android.blogclient.results.BlogEntry;
import petrsu.smartroom.android.blogclient.results.Comment;
import petrsu.smartroom.android.blogclient.xmlrpcclient.ConvenientClient;
import petrsu.smartroom.android.blogclient.xmlrpcclient.LJRuntimeException;
import petrsu.smartroom.android.blogclient.xmlrpcclient.XMLRPCClientImpl;
import junit.framework.TestCase;

public class ThemeTest extends TestCase {

/**
* Àêêàóíò äëÿ òåñòîâ, çàðåãèñòðèðîâàííûé â ÆÆ
*/
String login = "smartroomuser";
String password = "Ochen_slojnii_parol";

int itemid = 2;

BlogAdapter blogAdapter;
private ConvenientClient client;

int timeout = 0;
Theme theme;
BlogEntry blogEntry;

protected void setUp() throws Exception {
super.setUp();
client = new ConvenientClient(new XMLRPCClientImpl());
client.login(login, password, timeout);

try{
blogEntry = client.getBlogEntry(itemid, timeout);


}catch(LJRuntimeException e){
fail("Failed to initialize test due to network problems");
}

}

public void testConstructor(){

theme = new Theme(blogEntry);

assertEquals("Expected IDs to be the same", blogEntry.getItemid(), theme.getID());
//assertEquals("Expected Anums to be the same", blogEntry.getAnum(), theme.getAnum());
assertEquals("Expected Bodies to be the same", blogEntry.getBody(), theme.getText());
assertEquals("Expected Subjects to be the same", blogEntry.getSubject(), theme.getSubject());
}


}
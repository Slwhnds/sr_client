package petrsu.smartroom.android.blogclient.test;

import petrsu.smartroom.android.blogclient.BlogAdapter;
import petrsu.smartroom.android.blogclient.Theme;
import petrsu.smartroom.android.blogclient.ThemeComment;
import petrsu.smartroom.android.blogclient.results.Comment;
import petrsu.smartroom.android.blogclient.xmlrpcclient.ConvenientClient;
import petrsu.smartroom.android.blogclient.xmlrpcclient.LJRuntimeException;
import petrsu.smartroom.android.blogclient.xmlrpcclient.XMLRPCClientImpl;
import junit.framework.TestCase;

public class ThemeCommentTest extends TestCase {

/**
* Àêêàóíò äëÿ òåñòîâ, çàðåãèñòðèðîâàííûé â ÆÆ
*/
String login = "smartroomuser";
String password = "Ochen_slojnii_parol";

int itemid = 2;

BlogAdapter blogAdapter;
private ConvenientClient client;

int timeout = 0;
Comment comment;
ThemeComment tcomment;
Comment[] comments;

protected void setUp() throws Exception {
super.setUp();
client = new ConvenientClient(new XMLRPCClientImpl());
client.login(login, password, timeout);

try{
Theme theme = new Theme(client.getBlogEntry(itemid, timeout));

comments = client.getComments(theme.getID(), theme.getAnum(), timeout);
if(comments.length == 0)
throw new LJRuntimeException("Error getting comments");
comment = comments[0];
}catch(LJRuntimeException e){
fail("Failed to initialize test due to network problems");
}

}

public void testConstructor(){

tcomment = new ThemeComment(comment);

assertEquals("Expected these fields to be equal", tcomment.getText(), comment.getBody());
assertEquals("Expected these fields to be equal", tcomment.getPosterName(), comment.getPostername());
assertEquals("Expected these fields to be equal", tcomment.getTime(), comment.getDate());
}


}
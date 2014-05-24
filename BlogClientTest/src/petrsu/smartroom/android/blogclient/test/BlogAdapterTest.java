package petrsu.smartroom.android.blogclient.test;

import petrsu.smartroom.android.blogclient.BlogAdapter;
import petrsu.smartroom.android.blogclient.Theme;
import petrsu.smartroom.android.blogclient.ThemeComment;
import petrsu.smartroom.android.blogclient.results.BlogEntry;
import petrsu.smartroom.android.blogclient.results.CommentPostResult;
import petrsu.smartroom.android.blogclient.results.UserData;
import petrsu.smartroom.android.blogclient.xmlrpcclient.LJRuntimeException;
import petrsu.smartroom.android.blogclient.xmlrpcclient.LJTimeoutException;
import junit.framework.TestCase;

public class BlogAdapterTest extends TestCase {

/**
* Àêêàóíò äëÿ òåñòîâ, çàðåãèñòðèðîâàííûé â ÆÆ
*/
String login = "smartRoomUser";
String password = "Ochen_slojnii_parol";
String badpass = password + "123";
String testComment = "This comment is posted by test";

/**
* Ñêîëüêî-íèáóäü êîììåíòàðèåâ äëÿ òåñòà. Ðó÷êàìè ñêîïèðîâàòü èç òåñòèðóåìîãî ïîñòà.
*/
String comments[] = {
"Ýòî êàðî÷ ïåðâûé êîììåíòàðèé",
"Âòîðîé êîììåíòàðèé."
};

Theme testTheme;
Theme nullTheme;
String badCommentBody = "";
String nullCommentBody;

/**
* ID, òåìà è òåêñò ïîñòà. Âçÿòü ðó÷êàìè èç áðàóçåðíîãî ææ.
*/
String subject = "Íàçâàíèå òåìû 1. Äîêëàä 1.";
String body = "Òóò êëàññíûé òàêîé òåêñò. Òåêñò äîêëàäà 1.";
int itemid = 2;

int baditemid = -1242345;

BlogAdapter blogAdapter;

protected void setUp() throws Exception {
super.setUp();
blogAdapter = new BlogAdapter();
blogAdapter.setLogPass(login, password);
blogAdapter.login();
testTheme = new Theme(blogAdapter.getBlogEntry(itemid));

}


public void testGetBlogEntry27_1(){
try{
blogAdapter.login();
BlogEntry result = blogAdapter.getBlogEntry(itemid);

assertEquals("Body from LiveJournal and body dont match",body, result.getBody());
assertEquals("Subject from LiveJournal and subject dont match",subject, result.getSubject().substring(0,subject.length()));
assertEquals("Itemid from LiveJournal and itemid dont match",itemid, result.getItemid());
////Thread.sleep(1000); // avoid getting banned for spamming xmlrpc calls
}catch (Exception e){
assertEquals("Other exception expected", LJRuntimeException.class, e.getClass());
}
}

public void testGetBlogEntry27_2(){
try{
blogAdapter.login();
BlogEntry result = blogAdapter.getBlogEntry(baditemid);

assertEquals("Expected result to be null", null, result);
//Thread.sleep(1000); // avoid getting banned for spamming xmlrpc calls
}catch (Exception e){
assertEquals("Other exception expected", LJTimeoutException.class, e.getClass());
}
}

public void testLogin28_1(){
try{
UserData result = blogAdapter.login(login, password);

assertEquals("Expected UserData.getFullName to be equal to login", result.getFullname().toUpperCase(), login.toUpperCase());
//Thread.sleep(1000); // avoid getting banned for spamming xmlrpc calls
}catch (Exception e){
assertEquals("Other exception expected", LJRuntimeException.class, e.getClass());
}
}


public void testLogin28_2(){
try{
UserData result = blogAdapter.login(login, badpass);

assertEquals("Expected result to be null", null, result);
//Thread.sleep(1000); // avoid getting banned for spamming xmlrpc calls
}catch (Exception e){
assertEquals("Other exception expected", LJRuntimeException.class, e.getClass());
}
}

public void testLogin28_3_1(){
try{
UserData result = blogAdapter.login(login, "");

assertEquals("Expected result to be null", null, result);
//Thread.sleep(1000); // avoid getting banned for spamming xmlrpc calls
}catch (Exception e){
assertEquals("Other exception expected", LJRuntimeException.class, e.getClass());
}
}

public void testLogin28_3_2(){
try{
UserData result = blogAdapter.login("", "");

assertEquals("Expected result to be null", null, result);
//Thread.sleep(1000); // avoid getting banned for spamming xmlrpc calls
}catch (Exception e){
assertEquals("Other exception expected", LJRuntimeException.class, e.getClass());
}
}

public void testLogin28_3_3(){
try{
UserData result = blogAdapter.login(null, null);

assertEquals("Expected result to be null", null, result);
//Thread.sleep(1000); // avoid getting banned for spamming xmlrpc calls
}catch (Exception e){
assertEquals("Other exception expected", LJRuntimeException.class, e.getClass());
}
}

public void testGetComments29_1(){
try{
blogAdapter.login();
ThemeComment[] result = blogAdapter.getComments(new Theme(blogAdapter.getBlogEntry(itemid)));
int resultsCount = result.length;
int commentsCount = comments.length;

for(int i = 0; i < resultsCount && i < commentsCount; i++){
assertEquals("Expected recieved comment to be equal to one in comments[]" + i, result[i].getText(), comments[i]);
}
//Thread.sleep(1000); // avoid getting banned for spamming xmlrpc calls
}catch (Exception e){
assertEquals("Other exception expected", LJRuntimeException.class, e.getClass());
}
}

public void testGetComments29_2(){
try{
ThemeComment[] result = blogAdapter.getComments(new Theme(blogAdapter.getBlogEntry(baditemid)));

assertEquals("Expected result to be null", null, result);
//Thread.sleep(1000); // avoid getting banned for spamming xmlrpc calls
}
catch (Exception e){
assertEquals("Other exception expected", NullPointerException.class, e.getClass());
//assertEquals("Exception isn't caused by Thread.sleep", InterruptedException.class, e.getClass());
}
}

public void testPostComment31_1(){
blogAdapter.login();

blogAdapter.postComment(testComment, testTheme);

ThemeComment[] result = blogAdapter.getComments(new Theme(blogAdapter.getBlogEntry(itemid)));
int resultsCount = result.length;

assertEquals("Last comment returned by getComments, isnt the one posted",testComment, result[resultsCount - 1].getText());

}

public void testPostComment31_3(){
blogAdapter.login();

blogAdapter.postComment(testComment, testTheme);

ThemeComment[] result = blogAdapter.getComments(new Theme(blogAdapter.getBlogEntry(itemid)));
int resultsCount = result.length;

assertEquals("Last comment returned by getComments, isnt the one posted",testComment, result[resultsCount - 1].getText());

}

public void testPostComment31_4_1(){
blogAdapter.login();

CommentPostResult result =blogAdapter.postComment(badCommentBody, testTheme);


assertEquals("Expected null for bad argument",null, result);

}

public void testPostComment31_4_2(){
blogAdapter.login();

CommentPostResult result = blogAdapter.postComment(nullCommentBody, testTheme);


assertEquals("Expected null for bad argument",null, result);

}







}
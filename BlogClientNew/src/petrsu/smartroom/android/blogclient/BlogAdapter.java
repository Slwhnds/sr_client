package petrsu.smartroom.android.blogclient;

import java.util.ArrayList;


import petrsu.smartroom.android.blogclient.xmlrpcclient.*;
import petrsu.smartroom.android.blogclient.arguments.*;
import petrsu.smartroom.android.blogclient.results.*;


public class BlogAdapter {

/** Îáúåêò êëàññà èç Java-LiveJournalAPI, ïðåäñòàâëÿþùèé óäîáíûé xmlrpc-client
*
* Âñå ïîäêëþ÷àåìûå áèáëèîòåêè íóæíû äëÿ ïîääåðæêè äàííîãî API.
*/
private ConvenientClient client;

/** Òàéì-àóò äëÿ xmlrpc-âûçîâîâ â êëàññå ConvenientClient */
private int timeout;

/** Ôëàã àóòåíòèôèêàöèè */
private boolean loggedIn;

/** Îáùèé ëîãèí äëÿ âíåøíåãî áëîã ñåðâèñà */
private String login;

/** Îáùèé ïàðîëü äëÿ âíåøíåãî áëîã ñåðâèñà */
private String pass;

/** Èìÿ ïîëüçîâàòåëÿ â SR */
private String SRName;

/** Òåêóùèé ëîãèí äëÿ âíåøíåãî áëîã ñåðâèñà */
private String curLogin;

/** Òåêóùèé ïàðîëü äëÿ âíåøíåãî áëîã ñåðâèñà */
private String curPass;

public BlogAdapter(){
client = new ConvenientClient(new XMLRPCClientImpl());
timeout = 0; // ïîêà ÷òî îòêëþ÷åí


}

/** Ïðîâåðÿåò ïðàâèëüíîñòü ïàðû ëîãèí-ïàðîëü, åñëè îíè ïîäõîäÿò, ñîõðàíÿåò â ñâîéñòâà curLogin, curPass
*
* @param login - ëîãèí äëÿ âíåøíåãî áëîã-ñåðâèñà
* @param password - ïàðîëü äëÿ âíåøíåãî áëîã-ñåðâèñà
* @return - îáúåêò êëàññà UserData, îïèñàííîãî â 4.2 Îáìåí äàííûìè ñ âíåøíèì áëîã-ñåðâèñîì
* @throws LJRuntimeException â ñëó÷àå, åñëè âîçíèêëè ïðîáëåìû ñ ñåòüþ íà ñòîðîíå êëèåíòà èëè ñåðâåðà
* Âûçûâàåò ìåòîä login() â ConvenientClient.
*/
public UserData login(String login, String password){
return client.login(login, password, timeout);

}

/** Ëîãèíèòñÿ ïîä îáùèìè ëîãèíîì è ïàðîëåì îò SR.
* @throws LJRuntimeException â ñëó÷àå, åñëè âîçíèêëè ïðîáëåìû ñ ñåòüþ íà ñòîðîíå êëèåíòà èëè ñåðâåðà
* Âûçûâàåò ìåòîä login() â ConvenientClient.
*/
public UserData login(){
return client.login(login, pass, timeout);
}

/** Âîçâðàùàåò çàïðîøåííûé ó âíåøíåãî áëîã-ñåðâèñà ïîñò
* @param itemid - èäåíòèôèêàòîð ïîñòà
* @return - îáúåêò êëàññà BlogEntry, îïèñàííîãî â 4.2 Îáìåí äàííûìè ñ âíåøíèì áëîã-ñåðâèñîì
* @throws LJRuntimeException â ñëó÷àå, åñëè âîçíèêëè ïðîáëåìû ñ ñåòüþ íà ñòîðîíå êëèåíòà èëè ñåðâåðà
* Âûçûâàåò ìåòîä getBlogEntry() â ConvenientClient.
*/
public BlogEntry getBlogEntry(int itemid){
return client.getBlogEntry(itemid, timeout);
}

/** Âîçâðàùàåò çàïðîøåííûå ó âíåøíåãî áëîã-ñåðâèñà êîììåíòàðèè
* @param theme - îáúåêò êëàññà Theme, äëÿ êîòîðîãî íóæíî ïîëó÷èòü êîììåíòàðèè
* @return - ìàññèâ îáúåêòîâ êëàññà Comment, îïèñàííîãî â 4.2 Îáìåí äàííûìè ñ âíåøíèì áëîã-ñåðâèñîì
* @throws LJRuntimeException â ñëó÷àå, åñëè âîçíèêëè ïðîáëåìû ñ ñåòüþ íà ñòîðîíå êëèåíòà èëè ñåðâåðà
* Calls for: ConvenientClient.getComments(), Theme.getID().
*/
public ThemeComment[] getComments(Theme theme){
Comment[] c = client.getComments(theme.getID(), theme.getAnum(), timeout);
ThemeComment[] c1 = new ThemeComment[c.length];
for (int i = 0; i < c.length; i++)
c1[i] = new ThemeComment(c[i]);
//return client.getComments(theme.getID(), theme.getAnum(), timeout);
return c1;
}

/** Ïóáëèêóåò êîììåíòàðèé ê ïîñòó â áëîã-ñåðâèñå
* @param body - òåêñò êîììåíòàðèÿ
* @param theme - îáúåêò êëàññà Theme, ïðåäñòàâëÿþùèé òåìó, ê êîòîðîé äîáàâëÿåòñÿ êîììåíòàðèé
* @return îáúåêò êëàññà CommentPostResult, îïèñàííîãî â 4.2 Îáìåí äàííûìè ñ âíåøíèì áëîã-ñåðâèñîì
* @throws LJRuntimeException â ñëó÷àå, åñëè âîçíèêëè ïðîáëåìû ñ ñåòüþ íà ñòîðîíå êëèåíòà èëè ñåðâåðà
* Âûçûâàåò ìåòîä addComment() â ConvenientClient.
*/
public CommentPostResult postComment(String body, Theme theme){
return client.addComment(body, theme.getID(), theme.getAnum(), timeout);
}

/** Óñòàíàâëèâàåò îáùèå ëîãèí è ïàðîëü
* @param login - îáùèé ëîãèí íà âíåøíåì áëîã-ñåðâèñå (â ôîðìàòå srLogin)
* @param pass - îáùèé ïàðîëü íà âíåøíåì áëîã-ñåðâèñå (â ôîðìàòå srPassword)
* @throws IllegalArgumentException â ñëó÷àå, åñëè õîòÿ áû îäèí èç àðãóìåíòîâ íå ñîîòâåòñòâóåò ôîðìàòó
*/
public void setLogPass(String login, String pass){
this.login = login;
this.pass = pass;
}

/** Óñòàíàâëèâàåò èìÿ ïîëüçîâàòåëÿ â SR
* @param name - èìÿ
*/
public void setSRName(String name){
if(name != null && name != "")
SRName = name;
}

/**
* Âîçâðàùàåò òåêóùèé ëîãèí íà âíåøíåì áëîã-ñåðâèñå. Åñëè ïîëüçîâàòåëü ïîëüçóåòñÿ îáùèì àêêàóíòîì SR, âîçâðàùàåò ïóñòóþ ñòðîêó.
* @return ëîãèí
*/
public String getCurLogin(){
if(login.compareTo(curLogin) == 0)
return "";
else
return curLogin;
}

}
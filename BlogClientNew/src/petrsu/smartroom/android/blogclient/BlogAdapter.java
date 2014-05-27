package petrsu.smartroom.android.blogclient;

import java.io.Serializable;
import java.util.ArrayList;


import petrsu.smartroom.android.blogclient.xmlrpcclient.*;
import petrsu.smartroom.android.blogclient.arguments.*;
import petrsu.smartroom.android.blogclient.results.*;


public class BlogAdapter implements Serializable{
	
	/** ������ ������ �� Java-LiveJournalAPI, �������������� ������� xmlrpc-client 
	*
	* ��� ������������ ���������� ����� ��� ��������� ������� API.
	*/
	private ConvenientClient client;

	/** ����-��� ��� xmlrpc-������� � ������ ConvenientClient */
	private int timeout;

	/** ���� �������������� */
	private boolean loggedIn = false;

	/** ����� ����� ��� �������� ���� ������� */
	private String login;

	/** ����� ������ ��� �������� ���� ������� */
	private String pass;
	
	/** ����� ����� ��� �������� ���� ������� */
	private String login1;

	/** ����� ������ ��� �������� ���� ������� */
	private String pass1;

	/** ��� ������������ � SR */
	private String SRName;

	/** ������� ����� ��� �������� ���� ������� */
	String curLogin = "notauthorized";

	/** ������� ������ ��� �������� ���� ������� */
	private String curPass;

	public BlogAdapter(){
		client = new ConvenientClient(new XMLRPCClientImpl());
		timeout = 0; // ���� ��� ��������
		
		
	}
	
	/**  ��������� ������������ ���� �����-������, ���� ��� ��������, ��������� � �������� curLogin, curPass 
	*
	* @param login - ����� ��� �������� ����-�������
	* @param password - ������ ��� �������� ����-�������
	* @return - ������ ������ UserData, ���������� � 4.2 ����� ������� � ������� ����-��������
	* @throws LJRuntimeException � ������, ���� �������� �������� � ����� �� ������� ������� ��� �������
	* �������� ����� login() � ConvenientClient.
	*/
	public UserData login(String login, String password){
		UserData d;
		if(login == null || login == "" || password == null || password == "")
			d = null;
		else
			d =  client.login(login, password, timeout);
		curLogin = login;
		pass1 = password;
		loggedIn = true;
		return d;
	}
	
	/** ��������� ��� ������ ������� � ������� �� SR.
	* @throws LJRuntimeException � ������, ���� �������� �������� � ����� �� ������� ������� ��� �������
	* �������� ����� login() � ConvenientClient.
	*/
	public UserData login(){
		UserData d = client.login(login, pass, timeout);
		loggedIn = false;
		return d;
	}

	/**  ���������� ����������� � �������� ����-������� ���� 
	* @param itemid - ������������� �����
	* @return - ������ ������ BlogEntry, ���������� � 4.2 ����� ������� � ������� ����-��������
	* @throws LJRuntimeException � ������, ���� �������� �������� � ����� �� ������� ������� ��� �������
	* �������� ����� getBlogEntry() � ConvenientClient.
	*/
	public BlogEntry getBlogEntry(int itemid){
		return client.getBlogEntry(itemid, timeout);
	}

	/**  ���������� ����������� � �������� ����-������� ����������� 
	* @param theme - ������ ������ Theme, ��� �������� ����� �������� �����������
	* @return - ������ �������� ������ Comment, ���������� � 4.2 ����� ������� � ������� ����-��������
	* @throws LJRuntimeException � ������, ���� �������� �������� � ����� �� ������� ������� ��� �������
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

	/**  ��������� ����������� � ����� � ����-�������
	* @param body - ����� �����������
	* @param theme - ������ ������ Theme, �������������� ����, � ������� ����������� �����������
	* @return ������ ������ CommentPostResult, ���������� � 4.2 ����� ������� � ������� ����-��������
	* @throws LJRuntimeException � ������, ���� �������� �������� � ����� �� ������� ������� ��� �������
	* �������� ����� addComment() � ConvenientClient.
	*/
	public CommentPostResult postComment(String body, Theme theme){
		if(body == null || body == "" || theme == null)
			return null;
		else {
			if(loggedIn)
				body += ("\nPosted by: " + SRName);
			return client.addComment(body, theme.getID(), theme.getAnum(), timeout);
		}
	}

	/** ������������� ����� ����� � ������
	* @param login - ����� ����� �� ������� ����-������� (� ������� srLogin)
	* @param pass - ����� ������ �� ������� ����-������� (� ������� srPassword)
	* @throws IllegalArgumentException � ������, ���� ���� �� ���� �� ���������� �� ������������� �������
	*/
	public void setLogPass(String login, String pass){
		this.login = login;
		this.pass = pass;
	}

	/** ������������� ��� ������������ � SR
	* @param name - ���
	*/
	public void setSRName(String name){
		if(name != null && name != "")
			SRName = name;
	}

	/** 
	* ���������� ������� ����� �� ������� ����-�������. ���� ������������ ���������� ����� ��������� SR, ���������� ������ ������.
	* @return �����
	*/
	public String getCurLogin(){
		if(loggedIn)
			return curLogin;
		else
			return "";
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public CharSequence getSRName() {
		return this.SRName;
	}

}

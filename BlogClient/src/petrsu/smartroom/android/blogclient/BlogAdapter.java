package petrsu.smartroom.android.blogclient;

import petrsu.smartroom.android.blogclient.xmlrpcclient.*;
import petrsu.smartroom.android.blogclient.arguments.*;
import petrsu.smartroom.android.blogclient.results.*;


public class BlogAdapter {
	
	/** ������ ������ �� Java-LiveJournalAPI, �������������� ������� xmlrpc-client 
	*
	* ��� ������������ ���������� ����� ��� ��������� ������� API.
	*/
	private ConvenientClient client;

	/** ����-��� ��� xmlrpc-������� � ������ ConvenientClient */
	private int timeout;

	/** ���� �������������� */
	private boolean loggedIn;

	/** ����� ����� ��� �������� ���� ������� */
	private String login;

	/** ����� ������ ��� �������� ���� ������� */
	private String pass;

	/** ��� ������������ � SR */
	private String SRName;

	/** ������� ����� ��� �������� ���� ������� */
	private String curLogin;

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
		return client.login(login, password, timeout);
	}
	
	/** ��������� ��� ������ ������� � ������� �� SR.
	* @throws LJRuntimeException � ������, ���� �������� �������� � ����� �� ������� ������� ��� �������
	* �������� ����� login() � ConvenientClient.
	*/
	public UserData login(){
		return client.login(login, pass, timeout);
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
	public Comment[] getComments(Theme theme){
		return client.getComments(theme.getID(), theme.getAnum(), timeout);
	}

	/**  ��������� ����������� � ����� � ����-�������
	* @param body - ����� �����������
	* @param theme - ������ ������ Theme, �������������� ����, � ������� ����������� �����������
	* @return ������ ������ CommentPostResult, ���������� � 4.2 ����� ������� � ������� ����-��������
	* @throws LJRuntimeException � ������, ���� �������� �������� � ����� �� ������� ������� ��� �������
	* �������� ����� addComment() � ConvenientClient.
	*/
	public CommentPostResult postComment(String body, Theme theme){
		return client.addComment(body, theme.getID(), theme.getAnum(), timeout);
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
		if(login.compareTo(curLogin) == 0)
			return "";
		else
			return curLogin;
	}

}

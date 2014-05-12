package petrsu.smartroom.android.cameraclient;

import java.lang.String;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import java.io.*;

public class Camera {

	/** IP ����� ������ � ������� IP (��. ���������� ��������� ������), ��������������� �������������.*/
	private String ip;

	/** ���� http ������ � ������� port (��. ���������� ��������� ������), ��������������� �������������.*/
	private String port;

	/** �������� (�������������) API, ������������� �������, � ������� API (��. ���������� ��������� ������), ��������������� �������������.*/
	private String API;

	/** ����� ������������ ��� ������������ http �������� ������ � ������� login (��. ���������� ��������� ������), ��������������� �������������.*/
	private String login;

	/** ������ ������������ ��� ������������ http �������� ������ � ������� password (��. ���������� ��������� ������), ��������������� �������������.*/
	private String pass;

	/** ������ ������� ���������� ��������, �������, ���� � ������� P-T-Z (��. ���������� ��������� ������), ��������������� ������� currentPTZ().*/
	private int PTZ[];

	/** ������ ��������� �������� ��������� ��������, �������, ���� � ������� borders(��. ���������� ��������� ������), ��������������� ������� borders().*/
	private int borders[][];

	/** ������ �����-�������� URI, ��������� ��� ������������ GET HTTP �������� (��. ����� ������� � �������). �������. ���� ����� ��������� ���������� � ����� �� ����������. 
	* ������ ������ �������� �������� API � ������ ��� �������� ������: ��������� ������� �������, ��������� �������, ��������� ������� ��������.
	*/
	private String stringAPI[] = {"/config/ptz_info.cgi","/config/ptz_pos.cgi","/config/ptz_move_rel.cgi?p=value1&t=value2&z=value3"};
	
	/**
	* ����������� ������. �������� IP, port, API, login, pass ���������������� ���������������� ����������.
	*
	* @param IP - ip ������ � ������� IP (��. ���������� ��������� ������)
	* @param port - ���� http � ������� port (��. ���������� ��������� ������)
	* @param API - ������������� ������������� ������� API � ������� API (��. ���������� ��������� ������)
	* @param login - ����� ��� �������� http � ������� login (��. ���������� ��������� ������)
	* @param pass - ������ ��� �������� http � ������� pass (��. ���������� ��������� ������)
	* @throws IlligalArgumentException - ������� ������������ ������.
	*/
	public Camera(String IP, String port, String API, String login, String pass)
	{
		this.ip = new String(IP);
		this.port = new String(port);
		this.API = new String(API);
		this.login = new String(login);
		this.pass = new String(pass);
	};

	/** 
	* �������� ������ �� ������� ���������� Apache HttpClient 4.3.3 ��� �������� ������� �� ������ � ��������� ������ �� ���. 
	* ��������� ���������� ����� � �������� �������� ������� PTZ.
	* @throws IOException ������ ��������������� ��� ���������.
	*/
	private void currentPTZ()
	{
		private String url = "http://"+IP+":"+port+stringAPI[1];
		
		public BasicAuthenticationExample() {
			super();
	    }
		// Create an instance of HttpClient.
		HttpClient client = new HttpClient();
		client.getState().setCredentials(
            new UsernamePasswordCredentials(login, pass)
        );
		// Create a method instance.
		GetMethod method = new GetMethod(url);
    
		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
    	new DefaultHttpMethodRetryHandler(3, false));

		// Execute the method.
		client.executeMethod(method);

		// Read the response body.
		byte[] responseBody = method.getResponseBody();
		// Release the connection.
		method.releaseConnection();
		
  
	};

	/** 
	* �������� ������ �� ������� ���������� Apache HttpClient 4.3.3 ��� �������� ������� �� ������ � ��������� ������ �� ���. 
	* ��������� ���������� ����� � �������� �������� ������� borders. 
	* @throws IOException ������ ��������������� ��� ���������.
	*/
	private void borders()
	{
	private String url = "http://"+IP+":"+port+stringAPI[1];
		
		public BasicAuthenticationExample() {
			super();
	    }
		// Create an instance of HttpClient.
		HttpClient client = new HttpClient();
		client.getState().setCredentials(
            new UsernamePasswordCredentials(login, pass)
        );
		// Create a method instance.
		GetMethod method = new GetMethod(url);
    
		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
    	new DefaultHttpMethodRetryHandler(3, false));

		// Execute the method.
		client.executeMethod(method);

		// Read the response body.
		byte[] responseBody = method.getResponseBody();
		// Release the connection.
		method.releaseConnection();
	};

	/** 
	* �������� ������ �� ������� ���������� Apache HttpClient 4.3.3 ��� �������� ������� �� ��������� ��������� �������, ��������, ���� ��������� �� �������� P, T, Z ��������������, �������� �����. 
	* ��������� ���������� ����� � �������� �������� ������� PTZ. 
	* @param P - �������
	* @param T - ������
	* @param Z - ���
	* @throws IOException ������ ��������������� ��� ���������.
	*/
	public void setPTZ(int P, int T, int Z)
	{
	
	private String url = "http://"+IP+":"+port+stringAPI[1];
		
		public BasicAuthenticationExample() {
			super();
	    }
		// Create an instance of HttpClient.
		HttpClient client = new HttpClient();
		client.getState().setCredentials(
            new UsernamePasswordCredentials(login, pass)
        );
		// Create a method instance.
		GetMethod method = new GetMethod(url);
    
		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
    	new DefaultHttpMethodRetryHandler(3, false));

		// Execute the method.
		client.executeMethod(method);

		// Read the response body.
		byte[] responseBody = method.getResponseBody();
		// Release the connection.
		method.releaseConnection();};

	/** 
	* ���������� ����� ������ currentPTZ(). 
	*
	* @return ������ ������� ��������� ��������, �������, ���� � ������� P-T-Z (��. ���������� ��������� ������).
	*/
	public int[] getCurrentPTZ()
	{ 
		return PTZ;
	};

	/**
	* ���������� ����� ������ borders(). 
	*  
	* @return ������ ��������� �������� ��������� ��������, �������, ���� � ������� borders (��. ���������� ��������� ������).
	*/
	public int[][] getBorders()
	{
		return borders;
	};
}
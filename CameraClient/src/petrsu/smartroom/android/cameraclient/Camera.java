package petrsu.smartroom.android.cameraclient;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import android.net.Uri;
import android.util.Base64;

public class Camera implements Serializable {

	/** IP àäðåñ êàìåðû â ôîðìàòå IP (ñì. âíóòðåííèå ñòðóêòóðû äàííûõ), óñòàíàâëèâàåòñÿ êîíñòðóêòîðîì.*/
	private String ip;
	
	private Uri uri;
	
	public String getName() {
		return name;
	}

	private String name;

	/** Ïîðò http êàìåðû â ôîðìàòå port (ñì. âíóòðåííèå ñòðóêòóðû äàííûõ), óñòàíàâëèâàåòñÿ êîíñòðóêòîðîì.*/
	private String port;

	/** Íàçâàíèå (èäåíòèôèêàòîð) API, èñïîëüçóåìîãî êàìåðîé, â ôîðìàòå API (ñì. âíóòðåííèå ñòðóêòóðû äàííûõ), óñòàíàâëèâàåòñÿ êîíñòðóêòîðîì.*/
	private String API;

	/** Ëîãèí ïîëüçîâàòåëÿ äëÿ ôîðìèðîâàíèÿ http çàïðîñîâ êàìåðå â ôîðìàòå login (ñì. âíóòðåííèå ñòðóêòóðû äàííûõ), óñòàíàâëèâàåòñÿ êîíñòðóêòîðîì.*/
	private String login;

	/** Ïàðîëü ïîëüçîâàòåëÿ äëÿ ôîðìèðîâàíèÿ http çàïðîñîâ êàìåðå â ôîðìàòå password (ñì. âíóòðåííèå ñòðóêòóðû äàííûõ), óñòàíàâëèâàåòñÿ êîíñòðóêòîðîì.*/
	private String pass;

	/** Ìàññèâ òåêóùèõ êîîðäèíàòû ïîâîðîòà, íàêëîíà, çóìà â ôîðìàòå P-T-Z (ñì. âíóòðåííèå ñòðóêòóðû äàííûõ), óñòàíàâëèâàåòñÿ ìåòîäîì currentPTZ().*/
	private int PTZ[];

	/** Ìàññèâ ãðàíè÷íûõ çíà÷åíèé êîîðäèíàò ïîâîðîòà, íàêëîíà, çóìà â ôîðìàòå borders(ñì. âíóòðåííèå ñòðóêòóðû äàííûõ), óñòàíàâëèâàåòñÿ ìåòîäîì borders().*/
	private int borders[][];

	/** Ìàññèâ ñòðîê-øàáëîíîâ URI, òðåáóåìûõ äëÿ ôîðìèðîâàíèÿ GET HTTP çàïðîñîâ (ñì. îáìåí äàííûìè ñ êàìåðîé). Êîñòûëü. Ïîëÿ áóäóò çàïîëíåíû èçíà÷àëüíî è íè÷åì íå èçìåíÿþòñÿ. 
	* Êàæäàÿ ñòðîêà ñîäåðæèò íàçâàíèå API è ñòðîêè äëÿ îñíîâíûõ êîìàíä: ïîëó÷åíèå òåêóùåé ïîçèöèè, èçìåíåíèå ïîçèöèè, ïîëó÷åíèå êðàéíèõ çíà÷åíèé.
	*/
	private String stringAPI[] = {"/config/ptz_info.cgi","/config/ptz_pos.cgi","/config/ptz_move.cgi?p=value1&t=value2&z=value3"};

	
	/**
	* Êîíñòðóêòîð êëàññà. Ñâîéñòâà IP, port, API, login, pass èíèöèàëèçèðóþòñÿ ñîîòâåòñòâóþùèìè çíà÷åíèÿìè.
	*
	* @param IP - ip êàìåðû â ôîðìàòå IP (ñì. âíóòðåííèå ñòðóêòóðû äàííûõ)
	* @param port - ïîðò http â ôîðìàòå port (ñì. âíóòðåííèå ñòðóêòóðû äàííûõ)
	* @param API - èäåíòèôèêàòîð èñïîëüçóåìîãî êàìåðîé API â ôîðìàòå API (ñì. âíóòðåííèå ñòðóêòóðû äàííûõ)
	* @param login - ëîãèí äëÿ çàïðîñîâ http â ôîðìàòå login (ñì. âíóòðåííèå ñòðóêòóðû äàííûõ)
	* @param pass - ïàðîëü äëÿ çàïðîñîâ http â ôîðìàòå pass (ñì. âíóòðåííèå ñòðóêòóðû äàííûõ)
	* @throws IlligalArgumentException - ââåäåíû íåêîððåêòíûå äàííûå.
	*/
	public Camera(String name, String IP, String Port, String uri, String API, String login, String pass)
	{
		Pattern pattern;
	    Matcher matcher;
	    final String IPADDRESS_PATTERN = 
	    		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
	    		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
	    		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
	    		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	    final String API_PATTERN = 
	    		"^[a-zA-Z0-9]{1,20}$";
	    final String LOGPASS_PATTERN = 
	    		"^[a-zA-Z0-9]{6,12}$";
	    pattern = Pattern.compile(IPADDRESS_PATTERN);
	    matcher = pattern.matcher(IP);
	    if (matcher.matches())
	    {
	    	this.ip = new String(IP);
	    } else {
	    	throw new IllegalArgumentException(IP);
	    }
	    int k = Integer.parseInt(Port);
	    if ( k > 1 || k < 65535)
	    {
	    	this.port = new String(Port);
	    }
	    pattern = Pattern.compile(API_PATTERN);
	    matcher = pattern.matcher(API);
	    if (matcher.matches())
	    {
	    	this.API = new String(API);
	    } else {
	    	throw new IllegalArgumentException(API);
	    }
	    pattern = Pattern.compile(LOGPASS_PATTERN);
	    matcher = pattern.matcher(login);
	    if (matcher.matches())
	    {
	    	this.login = new String(login);
	    } else {
	    	throw new IllegalArgumentException(login);
	    }
	    matcher = pattern.matcher(pass);
	    if (matcher.matches())
	    {
	    	this.pass = new String(pass);
	    } else {
	    	throw new IllegalArgumentException(pass);
	    }
	    
		this.name = name;
		this.uri = Uri.parse(uri);
		
	};

	/** 
	* Âûçûâàåò ìåòîäû èç âíåøíåé áèáëèîòåêè Apache HttpClient 4.3.3 äëÿ îòïðàâêè çàïðîñà íà êàìåðó è ïîëó÷åíèÿ îòâåòà îò íåå. 
	* Ðàçáèðàåò ïîëó÷åííûé îòâåò è èçìåíÿåò çíà÷åíèÿ ìàññèâà PTZ.
	* @throws IOException Îøèáêà òðàíñïîðòèðîâêè èëè ïðîòîêîëà.
	*/
	public void currentPTZ() throws IOException
	{
		Pattern p;
		Matcher m;
		PTZ = new int[3];
		String url = "http://"+ip+":"+port+stringAPI[0];
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet request = new HttpGet(url);
		String authString = login + ":" + pass;
		String authEncString = Base64.encodeToString(authString.getBytes(), Base64.DEFAULT);
		request.addHeader("Authorization", "Basic " + authEncString);
		HttpResponse response = httpclient.execute(request);
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		p = Pattern.compile("p=([0-9]+)");
		m = p.matcher(responseString);
		if (m.matches())
			PTZ[0] = Integer.parseInt(m.group(0).substring(2));
		p = Pattern.compile("t=([0-9]+))");
		m = p.matcher(responseString); 
		if (m.matches())
			PTZ[1] = Integer.parseInt(m.group(0).substring(2));
		p = Pattern.compile("z=([0-9]+))");
		m = p.matcher(responseString);
		if (m.matches())
			PTZ[2] = Integer.parseInt(m.group(0).substring(2));
				
		
	};
	/** 
	* Âûçûâàåò ìåòîäû èç âíåøíåé áèáëèîòåêè Apache HttpClient 4.3.3 äëÿ îòïðàâêè çàïðîñà íà êàìåðó è ïîëó÷åíèÿ îòâåòà îò íåå. 
	* Ðàçáèðàåò ïîëó÷åííûé îòâåò è èçìåíÿåò çíà÷åíèÿ ìàññèâà borders. 
	* @throws IOException Îøèáêà òðàíñïîðòèðîâêè èëè ïðîòîêîëà.
	*/
	public void borders() throws IOException
	{
		borders = new int[2][3];
		Pattern p;
		Matcher m;
		String url = "http://"+ip+":"+port+stringAPI[1];
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet request = new HttpGet(url);
		String authString = login + ":" + pass;
		String authEncString = Base64.encodeToString(authString.getBytes(), Base64.DEFAULT);
		request.addHeader("Authorization", "Basic " + authEncString);
		HttpResponse response = httpclient.execute(request);
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		p = Pattern.compile("pmax=([0-9]+)");
		m = p.matcher(responseString);
		if (m.matches())
			borders[0][0] = Integer.parseInt(m.group(0).substring(4));
		p = Pattern.compile("pmin=([0-9]+)");
		m = p.matcher(responseString);
		if (m.matches())
			borders[0][1] = Integer.parseInt(m.group(0).substring(4));
		p = Pattern.compile("tmax=([0-9]+)");
		m = p.matcher(responseString);
		if (m.matches())
			borders[1][0] = Integer.parseInt(m.group(0).substring(4));
		p = Pattern.compile("tmin=([0-9]+)");
		m = p.matcher(responseString);
		if (m.matches())
			borders[1][1] = Integer.parseInt(m.group(0).substring(4));
		p = Pattern.compile("zmax=([0-9]+)");
		m = p.matcher(responseString);
		if (m.matches())
			borders[2][0] = Integer.parseInt(m.group(0).substring(4));
		p = Pattern.compile("zmin=([0-9]+)");
		m = p.matcher(responseString);
		if (m.matches())
			borders[2][1] = Integer.parseInt(m.group(0).substring(4));
		
	};

	/** 
	* Âûçûâàåò ìåòîäû èç âíåøíåé áèáëèîòåêè Apache HttpClient 4.3.3 äëÿ îòïðàâêè çàïðîñà íà èçìåíåíèå êîîðäèíàò íàêëîíà, ïîâîðîòà, çóìà àáñîëþòíî íà çíà÷åíèÿ P, T, Z ñîîòâåòñòâåííî, ïîëó÷àåò îòâåò. 
	* Ðàçáèðàåò ïîëó÷åííûé îòâåò è èçìåíÿåò çíà÷åíèÿ ìàññèâà PTZ. 
	* @param P - ïîâîðîò
	* @param T - íàêëîí
	* @param Z - çóì
	* @throws IOException Îøèáêà òðàíñïîðòèðîâêè èëè ïðîòîêîëà.
	*/
	public void setPTZ(int P, int T, int Z) throws IOException
	{
		Pattern p;
		Matcher m;
		String values = stringAPI[2];
		values = values.replace("value1", String.valueOf(P));
		values = values.replace("value2", String.valueOf(T));
		values = values.replace("value3", String.valueOf(Z));
		String url = "http://"+ip+":"+port+values;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet request = new HttpGet(url);
		String authString = login + ":" + pass;
		String authEncString = Base64.encodeToString(authString.getBytes(), Base64.DEFAULT);
		request.addHeader("Authorization", "Basic " + authEncString);
		HttpResponse response = httpclient.execute(request);
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		p = Pattern.compile("p=([0-9]+)");
		m = p.matcher(responseString);
		if (m.matches())
			PTZ[0] = Integer.parseInt(m.group(0).substring(2));
		p = Pattern.compile("t=([0-9]+)");
		m = p.matcher(responseString);
		if (m.matches())
			PTZ[1] = Integer.parseInt(m.group(0).substring(2));
		p = Pattern.compile("z=([0-9]+)");
		m = p.matcher(responseString);
		if (m.matches())
			PTZ[2] = Integer.parseInt(m.group(0).substring(2));
		
	}

	/** 
	* Âûçûâàåòñÿ ïîñëå ìåòîäà currentPTZ(). 
	*
	* @return ìàññèâ òåêóùèõ êîîðäèíàò ïîâîðîòà, íàêëîíà, çóìà â ôîðìàòå P-T-Z (ñì. âíóòðåííèå ñòðóêòóðû äàííûõ).
	*/
	public int[] getCurrentPTZ()
	{ 
		return PTZ;
	};

	/**
	* Âûçûâàåòñÿ ïîñëå ìåòîäà borders(). 
	*  
	* @return ìàññèâ ãðàíè÷íûõ çíà÷åíèé êîîðäèíàò ïîâîðîòà, íàêëîíà, çóìà â ôîðìàòå borders (ñì. âíóòðåííèå ñòðóêòóðû äàííûõ).
	*/
	public int[][] getBorders()
	{
		return borders;
	}

	public Uri getURI() {
		return uri;
	};
}
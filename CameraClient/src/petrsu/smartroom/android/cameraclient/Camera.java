package petrsu.smartroom.android.cameraclient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;

public class Camera implements Parcelable {

	private static final String TAG = "fla";
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
	private int PTZX[];

	/** Ìàññèâ ãðàíè÷íûõ çíà÷åíèé êîîðäèíàò ïîâîðîòà, íàêëîíà, çóìà â ôîðìàòå borders(ñì. âíóòðåííèå ñòðóêòóðû äàííûõ), óñòàíàâëèâàåòñÿ ìåòîäîì borders().*/
	private int borders[][];
	private int bordersX[][];

	/** Ìàññèâ ñòðîê-øàáëîíîâ URI, òðåáóåìûõ äëÿ ôîðìèðîâàíèÿ GET HTTP çàïðîñîâ (ñì. îáìåí äàííûìè ñ êàìåðîé). Êîñòûëü. Ïîëÿ áóäóò çàïîëíåíû èçíà÷àëüíî è íè÷åì íå èçìåíÿþòñÿ. 
	* Êàæäàÿ ñòðîêà ñîäåðæèò íàçâàíèå API è ñòðîêè äëÿ îñíîâíûõ êîìàíä: ïîëó÷åíèå òåêóùåé ïîçèöèè, èçìåíåíèå ïîçèöèè, ïîëó÷åíèå êðàéíèõ çíà÷åíèé.
	*/
	private String stringAPI[] = {"/config/ptz_pos.cgi","/config/ptz_info.cgi","/config/ptz_move.cgi?p=value1&t=value2&z=value3"};

	
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
	    		"^[a-zA-Z0-9]{1,12}$";
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
	    try {
			borders();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		try {
			currentPTZ();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.name = name;
		this.uri = Uri.parse(uri);
		Log.d("fla","Name ="+this.name);
		
	};

	/** 
	* Âûçûâàåò ìåòîäû èç âíåøíåé áèáëèîòåêè Apache HttpClient 4.3.3 äëÿ îòïðàâêè çàïðîñà íà êàìåðó è ïîëó÷åíèÿ îòâåòà îò íåå. 
	* Ðàçáèðàåò ïîëó÷åííûé îòâåò è èçìåíÿåò çíà÷åíèÿ ìàññèâà PTZ.
	* @throws IOException Îøèáêà òðàíñïîðòèðîâêè èëè ïðîòîêîëà.
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	*/
	public void currentPTZ() throws IOException, InterruptedException, ExecutionException
	{
		Pattern p;
		Matcher m;
		PTZ = new int[3];
		PTZX = new int[3];
		String url = "http://"+ip+":"+port+stringAPI[0];
		String authString = login + ":" + pass;
		String authEncString = Base64.encodeToString(authString.getBytes(), Base64.NO_WRAP);
		CameraReq cr = new CameraReq();
		cr.execute(url,authEncString);
		String responseString =  cr.get();
		p = Pattern.compile("p=([-]?[0-9]+)");
		m = p.matcher(responseString);
		if (m.find())
			PTZ[0] = Integer.parseInt(m.group(0).substring(3));
		p = Pattern.compile("t=([-]?[0-9]+)");
		m = p.matcher(responseString); 
		if (m.find())
			PTZ[1] = Integer.parseInt(m.group(0).substring(3));
		p = Pattern.compile("z=([-]?[0-9]+)");
		m = p.matcher(responseString);
		if (m.find())
			PTZ[2] = Integer.parseInt(m.group(0).substring(3));
		PTZX[0] = PTZ[0] - borders[0][0];
		PTZX[1] = PTZ[1] - borders[1][0];
		PTZX[2] = PTZ[2] - borders[2][0];
};
	/** 
	* Âûçûâàåò ìåòîäû èç âíåøíåé áèáëèîòåêè Apache HttpClient 4.3.3 äëÿ îòïðàâêè çàïðîñà íà êàìåðó è ïîëó÷åíèÿ îòâåòà îò íåå. 
	* Ðàçáèðàåò ïîëó÷åííûé îòâåò è èçìåíÿåò çíà÷åíèÿ ìàññèâà borders. 
	* @throws IOException Îøèáêà òðàíñïîðòèðîâêè èëè ïðîòîêîëà.
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	*/
	public void borders() throws IOException, InterruptedException, ExecutionException
	{
		borders = new int[3][2];
		bordersX = new int[3][2];
		Pattern p;
		Matcher m;
		String url = "http://"+ip+":"+port+stringAPI[1];
		String authString = login + ":" + pass;
		String authEncString = Base64.encodeToString(authString.getBytes(), Base64.NO_WRAP);
		CameraReq cr = new CameraReq();
		cr.execute(url,authEncString);
		String responseString =  cr.get();
		p = Pattern.compile("pmax=([0-9]+)");
		m = p.matcher(responseString);
		if (m.find())
			borders[0][1] = Integer.parseInt(m.group(0).substring(5));
		p = Pattern.compile("pmin=([-]?[0-9]+)");
		m = p.matcher(responseString);
		if (m.find())
			borders[0][0] = Integer.parseInt(m.group(0).substring(5));
		p = Pattern.compile("tmax=([0-9]+)");
		m = p.matcher(responseString);
		if (m.find())
			borders[1][1] = Integer.parseInt(m.group(0).substring(5));
		p = Pattern.compile("tmin=([-]?[0-9]+)");
		m = p.matcher(responseString);
		if (m.find())
			borders[1][0] = Integer.parseInt(m.group(0).substring(5));
		p = Pattern.compile("zmax=([0-9]+)");
		m = p.matcher(responseString);
		if (m.find())
			borders[2][1] = Integer.parseInt(m.group(0).substring(5));
		p = Pattern.compile("zmin=([-]?[0-9]+)");
		m = p.matcher(responseString);
		if (m.find())
			borders[2][0] = Integer.parseInt(m.group(0).substring(5));
		bordersX[0][0] = borders[0][0]-borders[0][0];
		bordersX[0][1] = borders[0][1]-borders[0][0];
		bordersX[1][0] = borders[1][0]-borders[1][0];
		bordersX[1][1] = borders[1][1]-borders[1][0];
		bordersX[2][0] = borders[2][0]-borders[2][0];
		bordersX[2][1] = borders[2][1]-borders[2][0];
	};

	/** 
	* Âûçûâàåò ìåòîäû èç âíåøíåé áèáëèîòåêè Apache HttpClient 4.3.3 äëÿ îòïðàâêè çàïðîñà íà èçìåíåíèå êîîðäèíàò íàêëîíà, ïîâîðîòà, çóìà àáñîëþòíî íà çíà÷åíèÿ P, T, Z ñîîòâåòñòâåííî, ïîëó÷àåò îòâåò. 
	* Ðàçáèðàåò ïîëó÷åííûé îòâåò è èçìåíÿåò çíà÷åíèÿ ìàññèâà PTZ. 
	* @param P - ïîâîðîò
	* @param T - íàêëîí
	* @param Z - çóì
	* @throws IOException Îøèáêà òðàíñïîðòèðîâêè èëè ïðîòîêîëà.
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	*/
	public void setPTZ(int P, int T, int Z) throws IOException
	{
		Pattern p;
		Matcher m;
		String values = stringAPI[2];
		values = values.replace("value1", String.valueOf(P+borders[0][0]));
		values = values.replace("value2", String.valueOf(T+borders[1][0]));
		values = values.replace("value3", String.valueOf(Z+borders[2][0]));
		String url = "http://"+ip+":"+port+values;
		String authString = login + ":" + pass;
		String authEncString = Base64.encodeToString(authString.getBytes(), Base64.NO_WRAP);
		CameraReq cr = new CameraReq();
		cr.execute(url,authEncString);
		String responseString = null;
		try {
			responseString = cr.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p = Pattern.compile("p=([-]?[0-9]+)");
		m = p.matcher(responseString);
		if (m.find())
			PTZX[0] = Integer.parseInt(m.group(0).substring(3))-borders[0][0];
		p = Pattern.compile("t=([-]?[0-9]+)");
		m = p.matcher(responseString);
		if (m.find())
			PTZX[1] = Integer.parseInt(m.group(0).substring(3))-borders[1][0];
		p = Pattern.compile("z=([-]?[0-9]+)");
		m = p.matcher(responseString);
		if (m.find())
			PTZX[2] = Integer.parseInt(m.group(0).substring(3))-borders[2][0];
		
	}

	/** 
	* Âûçûâàåòñÿ ïîñëå ìåòîäà currentPTZ(). 
	*
	* @return ìàññèâ òåêóùèõ êîîðäèíàò ïîâîðîòà, íàêëîíà, çóìà â ôîðìàòå P-T-Z (ñì. âíóòðåííèå ñòðóêòóðû äàííûõ).
	*/
	public int[] getCurrentPTZ()
	{ 
		return PTZX;
	};

	/**
	* Âûçûâàåòñÿ ïîñëå ìåòîäà borders(). 
	*  
	* @return ìàññèâ ãðàíè÷íûõ çíà÷åíèé êîîðäèíàò ïîâîðîòà, íàêëîíà, çóìà â ôîðìàòå borders (ñì. âíóòðåííèå ñòðóêòóðû äàííûõ).
	*/
	public int[][] getBorders()
	{
		
		return bordersX;
	}

	public Uri getURI() {
		return uri;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(name); 
		dest.writeString(ip); 
		dest.writeString(port); 
		dest.writeString(uri.toString()); 
		dest.writeString(API); 
		dest.writeString(login); 
		dest.writeString(pass); 
	};
	
	public static final Parcelable.Creator<Camera> CREATOR = new Creator<Camera>() { 

			@Override
			public Camera createFromParcel(Parcel source) {
				return new Camera(source.readString(), source.readString(), source.readString(),
						source.readString(), source.readString(), source.readString(), source.readString());
			}

			@Override
			public Camera[] newArray(int size) {
				return new Camera[size];
			}
		};

	
}

class CameraReq extends AsyncTask<String, Void, String> {
	
	String responseString=null;

	@Override
    protected void onPreExecute() {
    }

	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet request = new HttpGet(params[0]);
		request.setHeader("Authorization", "Basic " + params[1]);
		//request.addHeader("Accept", "*/*");
				
		HttpResponse response = null;
		try {
			response = httpclient.execute(request);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpEntity entity = response.getEntity();
        try {
			responseString = EntityUtils.toString(entity, "UTF-8");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseString;
	}
 
}
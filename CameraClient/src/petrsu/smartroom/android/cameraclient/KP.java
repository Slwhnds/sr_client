package petrsu.smartroom.android.cameraclient;

public class KP {
	
	/**
	* @brief Function connect client to Smart Space
	*
	* @param hostname - name of Smart Space
	* @param ip - ip address
	* @param port - SIB port
	*
	* @return Returns 0 in success and -1 if failed
	*/
	public static native int connectSmartSpace(String hostname, String ip,  int port);
	
	/**
	* Gets camera data from SS.
	* @return Cameras info (properties devided with ' ')
	* @throws NullPointerExeption
	*/
	public static native int getCameraData(CameraListActivity obj);

	public KP() {
		// TODO Auto-generated constructor stub
	}
	
	
	static {
		System.loadLibrary("sslog");
	}	

}

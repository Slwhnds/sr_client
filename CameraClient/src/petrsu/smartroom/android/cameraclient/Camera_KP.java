package petrsu.smartroom.android.cameraclient;

public class Camera_KP {
	
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
	* @param cameras - Cameras info (properties devided with ' ')
	* @return Returns 0 in success and -1 if failed
	* @throws NullPointerExeption
	*/
	public native int getCameraData(String[] cameras);

	public Camera_KP() {
		// TODO Auto-generated constructor stub
	}

}

package petrsu.smartroom.android.blogclient;

public class KP {
	
	/** The connection state. */
	static int connectionState;
	
	public static BlogAdapter blogAdapter;

	public KP() {
		blogAdapter = new BlogAdapter();
	}

	/*
	 * 	Native functions prototypes
	 */
	/**
	 * Connect smart space.
	 *
	 * @param hostname the hostname
	 * @param ip the ip
	 * @param port the port
	 * @return the int
	 */
	public static native int connectSmartSpace(String hostname, String ip,  int port);
	
	/**
	 * Disconnect smart space.
	 */
	public static native void disconnectSmartSpace();
	
	/**
	* Deletes themes data from Smart Space
	* @return Returns 0 in success and -1 if failed
	*/
	public static native int deletePublishedData();
	
	/**
	 * User registration.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return the int
	 */
	public static native int  userRegistration(String userName, String password);
	
	public static native int registerGuest(String name, String phone, String email);
	
	public static native int getThemes(BlogListActivity obj);
	
	public static native String getLog();
	
	public static native String getPass();
	
	static {
		System.loadLibrary("sslog");
	}	
	
}

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.lang.Thread;

public class CameraService {
	private static String SS_IP;
	private static String SS_NAME;
	private static String CAMERA_DATA;
	private static int SS_PORT;
	
	int connectionState = 0;
	
	String[] cameras;
	
	// Native methods
	public static native int connectSmartSpace(
	    String hostname, String ip,  int port);
	/**
	* Publishs camera dadta in Smart Space
	* @param cameras strings representing camera data (properties devided with ' ')
	* @return Returns 0 in success and -1 if failed
	*/
	public static native int publishData(String[] cameras);

	/**
	* Deletes camera data from Smart Space
	* @return Returns 0 in success and -1 if failed
	*/
	public static native void deletePublishedData();
	
	// Loading SmartSlog library
	static {
	    final String dir = System.getProperty("user.dir");
	    System.load(dir + "/libsslog.so");
	}

	public static void main(String[] args) {
		startExitThread();
		      
		if(!loadConfiguration()) {
			System.out.println("Faild to read config");
		    System.exit(-1);
		}
		    
		System.out.println(CameraService.SS_NAME + " " + CameraService.SS_IP + " " + 
		      CameraService.SS_PORT);
		
		if(connectSmartSpace(CameraService.SS_NAME, CameraService.SS_IP, 
		      CameraService.SS_PORT) != 0) {
		    System.out.println("Faild to connect Smart Space.");
		    System.exit(-1);
		}
		
		CameraService c = new CameraService();
		
		if(!c.loadCameraData()) {
			System.out.println("Faild to read camera data");
		    System.exit(-1);
		}
		
		if (publishData(c.cameras) == -1) {
			deletePublishedData();
			System.out.println("Faild to publish camera data in SS");
		    System.exit(-1);
		}
	}

	public static boolean loadConfiguration() {
	    
	    Properties prop = new Properties();
	    String configPath = "/.config/SR-cameraservice/cameraserv.ini";
	    String userHome = System.getProperty("user.home");
	    File file = new File(userHome + configPath);
	    
	    try {
		prop.load(new FileInputStream(file));
		
		CameraService.SS_IP = prop.getProperty("ip");
		CameraService.SS_NAME = prop.getProperty("name");
		CameraService.SS_PORT = Integer.parseInt(prop.getProperty("port"));
		CameraService.CAMERA_DATA = prop.getProperty("cameradata");
		//System.out.println(CAMERA_DATA);
	    
	    } catch(IOException e) {
		e.printStackTrace();
		return false;
	    }
	    
	    return true;
	}
	
	public boolean loadCameraData() {
		ArrayList<String> strings = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(CameraService.CAMERA_DATA));
			
			String line;
			
			try {
				while ((line = reader.readLine()) != null) {
						strings.add(line);
				}
				cameras = new String[strings.size()];
				cameras = strings.toArray(cameras);
			}
			catch (IOException e) {
				return false;
			}
		}
		catch (FileNotFoundException e) {
			return false;
		}
		return true;
	}
	
	public static void startExitThread() {
		// Thread for correct stop of a server
		new Thread() {
		    @Override
		    public void run() {
			final BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
			System.out.println("Press 'q' to exit program.\n");
			while(true) {
			    try {
				if(reader.readLine().equals("q") ||
				    reader.readLine().equals("Q")) {
					
				    deletePublishedData();

				    System.exit(0);
				}
			    } catch (IOException e) {
				e.printStackTrace();
			    }
			}
		    }
		}.start();
	}

}

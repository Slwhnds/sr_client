import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.lang.Thread;

public class BlogService {
	private static String SS_IP;
	private static String SS_NAME;
	private static int SS_PORT;
	
	ArrayList<ThemeInfo> list;
	
	int connectionState = 0;
	
	String[] cameras;
	
	// Native methods
	public static native int connectSmartSpace(
	    String hostname, String ip,  int port);
	
	/**
	* Publishs login&pass data in Smart Space
	* 
	* @return Returns 0 in success and -1 if failed
	*/
	public static native int publishStartData(String login, String pass);
	
	public static native int publishData(String status, String id);

	/**
	* Deletes camera data from Smart Space
	* @return Returns 0 in success and -1 if failed
	*/
	public static native int deletePublishedData();
	
	/**
	 * Load timeslot list.
	 *
	 * @param obj the obj
	 * @return the int
	 */
	public static native int loadTimeslotList(BlogService obj);
	
	// Loading SmartSlog library
	static {
	    final String dir = System.getProperty("user.dir");
	    System.load(dir + "/libsslog.so");
	}

	public static void main(String[] args) {
		startExitThread();
		      
		if(!loadConfiguration())
		    System.exit(-1);
		    
		System.out.println(BlogService.SS_NAME + " " + BlogService.SS_IP + " " + 
		      BlogService.SS_PORT);
		
		if(connectSmartSpace(BlogService.SS_NAME, BlogService.SS_IP, 
		      BlogService.SS_PORT) != 0) {
		    System.out.println("Faild to connect Smart Space.");
		    System.exit(-1);
		}
		
		BlogService h = new BlogService();
		String[] g = h.getThemesFromSS();
		
		if (h.publishStartData("login", "pass") != 0) {
			System.out.println("Faild to publish start data.");
		    System.exit(-1);
		}
	}
	
public static boolean loadConfiguration() {
	    
	    Properties prop = new Properties();
	    String configPath = "/.config/SR-blogservice/blogserv.ini";
	    String userHome = System.getProperty("user.home");
	    File file = new File(userHome + configPath);
	    
	    try {
		prop.load(new FileInputStream(file));
		
		BlogService.SS_IP = prop.getProperty("ip");
		BlogService.SS_NAME = prop.getProperty("name");
		BlogService.SS_PORT = Integer.parseInt(prop.getProperty("port"));
	    
	    } catch(IOException e) {
		e.printStackTrace();
		return false;
	    }
	    
	    return true;
	}

	/**  Публикует темы во внешний блог-сервис 
	* @param themes Масив строк, представляющий список тем (в формате "заголовок статус время докладчик").
	*/
	public void publishThemes(String[] themes) {
		
	}
	
	public void setThemesInSS(String[] themes) {
		for (int i = 0; i < themes.length; i++) {
			String[] s1 = themes[i].split(" ");
			if (this.publishData(s1[0], s1[1]) != 0) {
				System.out.println("Faild to publish themes data to Smart Space.");
			    System.exit(-1);
			}
				
		}
	}
	
	public String[] getThemesFromSS() {
		list = new ArrayList<ThemeInfo>();
		loadTimeslotList(this);
		String[] s = new String[list.size()];
		for (int i = 0; i < s.length; i++) {
			s[i] = list.get(i).getAuthor() + " " + list.get(i).getText();
		}
		return s;
	}
	
	/**
	 * Adds the timeslot item to list.
	 *
	 * @param name the name
	 * @param title the title
	 */
	public void addTimeslotItemToList(final String name, final String title) {
		list.add(new ThemeInfo(name, title));
	}
	
	public class ThemeInfo {
		String text = "";
		String author = "";
		
		ThemeInfo(String text, String author) {
			this.text =  text;
			this.author = author;
		}
		
		String getText() {
			return text;
		}
		
		String getAuthor() {
			return author;
		}
		
		void setText(String text) {
			this.text =  text;
		}
		
		void setAuthor(String author) {
			this.author = author;
		}
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
				    //deletePublishedData();

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

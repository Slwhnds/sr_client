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
import java.util.Calendar;
import java.util.List;
import java.util.Date;

import arguments.*;
import results.*;
import xmlrpcclient.*;

public class BlogService {
	private static String SS_IP;
	private static String SS_NAME;
	private static int SS_PORT;
	
	private ConvenientClient client;
	
	ArrayList<ThemeInfo> list;
	
	int connectionState = 0;
	
	/** Масив строк, представляющий список тем (в формате "заголовок докладчик"). */
	private String[] themesFromSS;
	
	private String login;
	private String password;
	private Date today;
	private int timeout = 0;
	
	private String[] themes;
	
	// Native methods
	public static native int connectSmartSpace(
	    String hostname, String ip,  int port);
	
	/**
	* Publishs login&pass data in Smart Space
	* 
	* @return Returns 0 in success and -1 if failed
	*/
	public static native int publishStartData(String login, String pass);
	
	public static native int publishData(String[] themes);

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
		
		BlogService h = new BlogService();
		      
		if(!h.loadConfiguration())
		    System.exit(-1);
		    
		System.out.println(BlogService.SS_NAME + " " + BlogService.SS_IP + " " + 
		      BlogService.SS_PORT);
		
		if(connectSmartSpace(BlogService.SS_NAME, BlogService.SS_IP, 
		      BlogService.SS_PORT) != 0) {
		    System.out.println("Faild to connect Smart Space.");
		    System.exit(-1);
		}
		
		String[] g = h.getThemesFromSS();
		
		//initializing api client
		h.client = new ConvenientClient(new XMLRPCClientImpl());
		h.client.login(h.login, h.password, h.timeout);
		h.today = new Date();
		
		if (h.publishStartData(h.login, h.password) != 0) {
			System.out.println("Faild to publish start data.");
		    System.exit(-1);
		}
		
		try {
			h.publishThemes(g);
		}
		catch (Exception e) {
			System.out.println("Faild to publish themes in LJ, maybe no network.");
		    System.exit(-1);
		}
		
		if (publishData(h.themes) == -1) {
			//deletePublishedData();
			System.out.println("Faild to publish themes data in SS");
		    System.exit(-1);
		}
	}
	
	/** Публикует темы во внешний блог-сервис
	* @param themes Масив строк, представляющий список тем (в формате "заголовок статус время докладчик").
	*/
	
	// blue comments encoding is broken mb //Roman
	public void publishThemes(String[] themes) {
		if (list == null) {
			System.out.println("No themes to publish");
			return;
		}
			
		List<String> themeslist = new ArrayList<String>();
		String themeName;
		String personName;
		String themeText;
		String themeTitle;
		int res; // result of posting theme
		for(int i = 0; i < list.size(); i++){
			if (list.get(i) == null) {
				System.out.println("Bad theme number " + i);
				this.themes = new String[themeslist.size()];
				this.themes = themeslist.toArray(themes);
				return;
			}
			personName = list.get(i).getAuthor();
			//System.out.println(personName);
			themeName = list.get(i).getText();
			//System.out.println(themeName);
			themeTitle = generateThemeTitle(personName, themeName);
			themeText = generateThemeText(personName, themeName);
			if((res = publishTheme(themeTitle, themeText)) != -1){
				themeslist.add(Integer.toString(res) + " planed");
				System.out.println("Published:");
				System.out.println(personName);
				System.out.println(themeName);
			}else{
				System.out.println("Failed to post a theme" + i + ", continuing...");
			}
		}
		this.themes = new String[themeslist.size()];
		this.themes = themeslist.toArray(themes);
	}

// version working with timeslots
/*public void publishThemes() {
//assuming themes contains at 0 person name, at 1 report name, and so on...
String themeName;
String personName;
String themeText;
String themeTitle;
int res; // result of posting theme
int count = list.size();
for(int i =0; i < count; i++){
personName = list.get(i).NAME;
themeName = list.get(i).TITLE;
themeTitle = generateThemeTitle(personName, themeName);
themeText = generateThemeText(personName, themeName;)
if((res = publishTheme(themeTitle, themeText)) != -1){
themeIds.add(res);
themeStatuses.add("planed");
}else{
System.out.println("Failed to post a theme" + [i] + ", continuing...");
}
}

}*/


//It would be good to receive this text template from some sort of Config // Roman
public String generateThemeText(String personName, String themeName){
String text;
text = "Today at IT-park PetrSU " +
personName + " will speak on theme: " + themeName +
"\nAuthors: " + personName + "\nFeel free to comment and ask questions!"+
"\n\n This text if generated :)";	
return text;
}

//It would be good to receive this text template from some sort of Config // Roman
public String generateThemeTitle(String personName, String themeName){
String themeTitle;
themeTitle = themeName + " by " + personName;
return themeTitle;
}

public int publishTheme(String themeTitle, String themeText){
	PostResult result = client.addBlogEntry(today, themeText, themeTitle, timeout);
if(result != null)
return result.getItemid();
else
return -1;

}
	
public boolean loadConfiguration() {
	    
	    Properties prop = new Properties();
	    String configPath = "/.config/SR-blogservice/blogserv.ini";
	    String userHome = System.getProperty("user.home");
	    File file = new File(userHome + configPath);
	    
	    try {
		prop.load(new FileInputStream(file));
		
		BlogService.SS_IP = prop.getProperty("ip");
		BlogService.SS_NAME = prop.getProperty("name");
		BlogService.SS_PORT = Integer.parseInt(prop.getProperty("port"));
		login = prop.getProperty("login");
		password = prop.getProperty("password");
		
	    } catch(IOException e) {
		e.printStackTrace();
		return false;
	    }
	    
	    return true;
	}
	
	/*public void setThemesInSS(String[] themes) {
		for (int i = 0; i < themes.length; i++) {
			String[] s1 = themes[i].split(" ");
			if (this.publishData(s1[0], s1[1]) != 0) {
				System.out.println("Faild to publish themes data to Smart Space.");
			    System.exit(-1);
			}
				
		}
	}*/
	
	public String[] getThemesFromSS() {
		list = new ArrayList<ThemeInfo>();
		if (loadTimeslotList(this) != 0)
			System.out.println("error");
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
			System.out.println("Press 'd' to delete blog.\n");
			while(true) {
			    try {
				if(reader.readLine().equals("q") ||
				    reader.readLine().equals("Q")) {
				    System.exit(0);
				}
				if(reader.readLine().equals("d") ||
					    reader.readLine().equals("D")) {
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

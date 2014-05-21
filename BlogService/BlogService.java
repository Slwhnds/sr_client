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

import petrsu.smartroom.android.blogclient.results.BlogEntry;

import petrsu.smartroom.android.blogclient.xmlrpcclient.ConvenientClient;

public class BlogService {
	private static String SS_IP;
	private static String SS_NAME;
	private static int SS_PORT;
	
	ArrayList<ThemeInfo> list;
	
	int connectionState = 0;
	
	/** Масив строк, представляющий список тем (в формате "заголовок статус время докладчик"). */
	private String[] themesFromSS;
	
	private List<int> themeIds;
	private List<String> themeStatuses;
	private String login;
	private String password;
	private Date today;
	
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
		
		//initializing api client
		client = new ConvenientClient();
		// account for tests
		login = "SmartRoomUser";
		password = "Ochen_slojnii_parol";
		client.login(login, password, timeout);
		today = new Date();
		
		BlogService h = new BlogService();
		String[] g = h.getThemesFromSS();
		
		if (h.publishStartData("login", "pass") != 0) {
			System.out.println("Faild to publish start data.");
		    System.exit(-1);
		}
	}
	
	/** Публикует темы во внешний блог-сервис
	* @param themes Масив строк, представляющий список тем (в формате "заголовок статус время докладчик").
	*/
	
	// blue comments encoding is broken mb //Roman
	public void publishThemes(String[] themes) {
		//assuming themes contains at 0 person name, at 1 report name, and so on...
		String themeName;
		String personName;
		String themeText;
		String themeTitle;
		int res; // result of posting theme
		/*int count = themes.length;
		if(count % 2 != 0){
				System.out.println("Themes length isnt even, continuing anyway...");
		}*/
		for(int i = 0; i < list.size(); i++){
			/*if(themes[i+1] == null){ // report name exists
					i++; // next person
					continue;
			}*/
			personName = list.get(i).getAuthor();
			themeName = list.get(i).getText();
			themeTitle = generateThemeTitle(personName, themeName);
			themeText = generateThemeText(personName, themeName;)
			if((res = publishTheme(themeTitle, themeText)) != -1){
				themeIds.add(res);
				themeStatuses.add("planed");
			}else{
				System.out.println("Failed to post a theme" + [i] + ", continuing...");
			}
		}

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
text = "Today at IT-part PetrSU " +
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
BlogEntry result = client.addBlogEntry(today, themeText, themeTitle, timeout);
if(BlogEntry != null)
return BlogEntry.getItemid();
else
return -1;

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

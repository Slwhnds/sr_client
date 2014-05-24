import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.File;

public class Config {

    public static void main(String[] args) {
	
	Properties prop = new Properties();
	final String dir = System.getProperty("user.home");
	File file = new File(dir + "/.config/SR-cameraservice/cameraserv.ini");
	
	if(!file.canWrite())
	  System.out.println("Can't write");
    
	try {
	    prop.setProperty("ip", "194.85.173.9");
	    prop.setProperty("port", "10010");
	    prop.setProperty("name", "X");
	    prop.setProperty("cameradata", dir + "/.config/SR-cameraservice/cameradata.txt");
	    //System.out.println(dir + "/.config/SR-cameraservice/cameradata.txt");
	    
	    prop.store(new FileOutputStream(file), null);
    
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
package PropertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Reading_PropertiesFile {

	public static void main(String[] args) throws IOException {

		Properties p=new Properties();
	    FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//testdata//config.properties");
	    
	    p.load(file);
	    String url=p.getProperty("appurl");
	    String email=p.getProperty("email");
	    String password=p.getProperty("password");
	    String orderid=p.getProperty("orderid");
	    String customerid=p.getProperty("customerid");
	    String browser=p.getProperty("browser");
	    
	    System.out.println(url+" "+email+" "+password+" "+orderid+" "+customerid+" "+browser);
	    
	    file.close();
	}

}

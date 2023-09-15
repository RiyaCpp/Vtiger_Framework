package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class consist of Generic methods related to property file
 * @author Pranav
 *
 */
public class PropertyFileUtility 
{
	/**
	 * This method will read data from property file and return the value to the caller
	 * @param key
	 * @return
	 * @throws Throwable
	 */
 public String readdatafrompropertyfile(String key) throws Throwable
 {
	 FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	 Properties p=new Properties();
	 p.load(fis);
	 String value = p.getProperty(key);
	 return value;
 }
}

package vtiger.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consist of re usable methods related to Java
 * @author Pranav
 *
 */
public class javaUtility 
{

	/**
	 * This method will return a random number for every execution
	 */
	public int getRandomNumber()
	{
		Random r=new Random();
		return r.nextInt(1000);
	}
	
	/**
	 * This method will generate current System Date in specified format
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		String data = formatter.format(d);
		return data;
	}

}

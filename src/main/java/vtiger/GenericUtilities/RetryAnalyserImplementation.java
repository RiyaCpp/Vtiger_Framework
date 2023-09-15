package vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * this class provides implementation for IRetryAnalyser interface of TestNG
 * @author Pranav
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer
{

	int count=0;
	int retrycount=2;
	public boolean retry(ITestResult result)
	{
		while(count<retrycount)
		{
			count++;
			return true;
		}
		return false;
	}
  
}

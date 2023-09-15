package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class will provide implementation to ITestListener interface
 * @author Chaitra M
 *
 */
public class ListenersImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
      String methodname = result.getMethod().getMethodName();
	//  System.out.println(methodname+" ----- Test script execution started -----");
	  
	  //create a test in extent report
	  //test = report.createTest(methodname);
	  
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodname = result.getMethod().getMethodName();

		//test.log(Status.PASS, methodname+" ----- PASS -----");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriverUtility w = new WebDriverUtility();
		javaUtility j = new javaUtility();
		
		String methodname = result.getMethod().getMethodName();
		String screenshotName = methodname+j.getSystemDate();
		
	//	test.log(Status.FAIL, methodname+" ----- FAIL -----");
	//	test.log(Status.INFO, result.getThrowable());
		
	try {
			String path = w.captureScreenShot(BaseClass.sdriver, screenshotName);
			
			//attach the screenshot into the report 
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println(result.getThrowable());
		
		String methodname = result.getMethod().getMethodName();
		
		//test.log(Status.FAIL, methodname+" ----- SKIP -----");
		//test.log(Status.INFO, result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("----- Suite execution started -----");
		
		//Configure the extent Reports
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("C:\\Users\\prana\\eclipse-workspace\\AdvancedAutomationFramework\\ExtentReports\\"+new javaUtility().getSystemDate()+".html");
		htmlreport.config().setDocumentTitle("Vtiger Execution Report");
		htmlreport.config().setReportName("Automation Execution Report");
		htmlreport.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Edge");
		report.setSystemInfo("Base URL", "https://localhost:8888");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Riya CP");
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("----- Suite execution finished -----");
		
		//generate the report after execution
		//report.flush(); 
	}
	
	

}

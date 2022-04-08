package allTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class baseTest {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent=new ExtentReports();
	public static ExtentTest test;	

	@BeforeSuite(alwaysRun=true)
	public void BeforeSuite()
	{
		System.out.println("Setup");
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/extentReport"+timeStamp+".html");
		System.out.println("The Path is "+System.getProperty("user.dir") +"/extentReport"+timeStamp+".html");
	    extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	    extent.setSystemInfo("OS", "Mac Sierra");
	    extent.setSystemInfo("Host Name", "Test");
	    extent.setSystemInfo("Environment", "QA-Admin");
	    extent.setSystemInfo("User Name", "Tester");
	    htmlReporter.config().setDocumentTitle("Extent report");
	    htmlReporter.config().setReportName("QA Report");
	    htmlReporter.config().setTheme(Theme.DARK);
		
	 
	}
	@AfterMethod(alwaysRun=true)
	public void getResult(ITestResult result)
	{
		   
	    if(result.getStatus() == ITestResult.FAILURE)
	    {
	        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
	        test.fail(result.getThrowable());
	    }
	    else if(result.getStatus() == ITestResult.SUCCESS)
	    {
	        test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	    }
	    else
	    {
	        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
	        test.skip(result.getThrowable());
	    }
	}

	@AfterSuite(alwaysRun=true)
	public void tearDown(){
	    extent.flush();
	   }

}



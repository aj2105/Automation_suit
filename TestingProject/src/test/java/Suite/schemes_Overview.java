package Suite;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import allTest.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
public class schemes_Overview extends baseTest{
	public static WebDriver driver;
	private static final org.apache.logging.log4j.Logger Log = LogManager.getLogger(schemes_Overview.class);
	//public  ExtentHtmlReporter htmlReporter;
	//public  ExtentReports extent;
	//public  ExtentTest test;
	
	@BeforeClass
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--headless");
		options.addArguments("--window-size=1920,1200");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);
		//htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/Reports/Scheme_OverviewextentReport.html");
		//extent=new ExtentReports();
		//extent.attachReporter(htmlReporter);
	}
	@Test
	public void Schemes_Overview() throws InterruptedException {
		test=extent.createTest("ValidationSchemes_Overview");
		driver.get("https://www.ips2-qa.bynaric.net/");
		Thread.sleep(5000);
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		email.sendKeys("admin@bynaric.com");
		test.info("UserName Entered: admin@bynaric.com");
		password.sendKeys("123456");
		test.info("Password Entered: 123456");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div [class='MuiButton-label']")).click();
		Thread.sleep(5000);
		test.info("Sign in button is clicked");
		WebElement Logo = driver.findElement(By.cssSelector("div [class='brand-logo']"));
		if (!Logo.isDisplayed())
			Assert.fail("User not logged in");
		else
			test.pass("User logged in"); 
		Thread.sleep(5000);
		WebElement AssetManagement = driver.findElement(By.xpath("//span[normalize-space()='Asset Management']"));
		if (!AssetManagement.isDisplayed())
			test.fail("Asset Management not displayed");
		else
			{
			test.pass("Asset Management is displayed. Clicking on it to see the sub-items"); 
			AssetManagement.click();
			}
		Thread.sleep(5000);
		WebElement schemes = driver.findElement(By.xpath("//span[normalize-space()='Schemes']"));
		if (!schemes.isDisplayed())
			test.fail("Schemes not displayed");
		else
			{
			test.pass("Schemes is displayed. Clicking on it."); 
			schemes.click();
			}
		if (!(driver.findElement(By.cssSelector("div [id=\"kt_wrapper\"] h1"))).isDisplayed())
			test.fail("Schemes List page is not displayed");
		else
			test.pass("Schemes List page is displayed");
		Thread.sleep(1000);
		WebElement search_bar=driver.findElement(By.xpath("//input[@id='search']"));	
		if(!(search_bar).isDisplayed())
			test.fail("Search Bar is not displayed in the grid");
		else
			test.pass("Search Bar is displayed in the grid");
		if(!(driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3']//div[@class='MuiGrid-root MuiGrid-item']"))).isDisplayed())
			test.fail("Search button is not displayed in the grid");
		else
			test.pass("Search button is displayed but disabled in the grid");
		search_bar.sendKeys("az");
		Thread.sleep(4000);
		if(!(driver.findElement(By.xpath("//span[@class='MuiButton-label'][normalize-space()='Search']"))).isDisplayed())
			test.fail("Search button is not displayed in the grid");
		else
			test.pass("Search button is displayed and enabled in the grid");
		WebElement UploadComponent= driver.findElement(By.xpath("//span[normalize-space()='Upload Scheme Components']"));
		if(!(UploadComponent).isDisplayed())
			test.fail("Upload component button is not displayed in the grid");
		else
			test.pass("Upload component is displayed in the grid");
		
		Thread.sleep(3000);
		WebElement Filter= driver.findElement(By.xpath("//span[normalize-space()='Filter']"));
		if(!(Filter).isDisplayed())
			test.fail("Filter button is not displayed in the grid");
		else
			test.pass("Filter button is displayed in the grid");
		Thread.sleep(5000);
		Filter.click();
		test.info("Filter Button Clicked");
		Thread.sleep(2000);
		test.info("Validating Asset ID");
		WebElement Asset_Filter=driver.findElement(By.id("custom_id"));
		if(!(Asset_Filter.isDisplayed()))
			test.fail("Asset ID Filter is not displayed");
		else
			test.pass("Asset ID Filter is displayed");
		WebElement Scheme_Filter=driver.findElement(By.id("scheme_id"));
		if(!(Scheme_Filter.isDisplayed()))
			test.fail("Scheme Filter is not displayed");
		else
			test.pass("Scheme Filter is displayed");
		WebElement Street_Filter=driver.findElement(By.id("street"));
		if(!(Street_Filter.isDisplayed()))
			test.fail("Street Filter is not displayed");
		else
			test.pass("Street Filter is displayed");
		WebElement City_Filter=driver.findElement(By.id("city"));
		if(!(City_Filter.isDisplayed()))
			test.fail("City Filter is not displayed");
		else
			test.pass("City Filter is displayed");
		WebElement County_Filter=driver.findElement(By.id("county"));
		if(!(County_Filter.isDisplayed()))
			test.fail("County Filter is not displayed");
		else
			test.pass("County Filter is displayed");
		WebElement EirCode_Filter=driver.findElement(By.id("eircode"));
		if(!(EirCode_Filter.isDisplayed()))
			test.fail("Eircode Filter is not displayed");
		else
			test.pass("Eircode Filter is displayed");
		WebElement BuildDate_Filter=driver.findElement(By.id("build_date"));
		if(!(BuildDate_Filter.isDisplayed()))
			test.fail("Build Date Filter is not displayed");
		else
			test.pass("Build Date Filter is displayed");
		WebElement Reset_Button=driver.findElement(By.xpath("//span[normalize-space()='Reset']"));
		if(!(Reset_Button.isDisplayed()))
			test.fail("Reset Button is not displayed");
		else
			test.pass("Reset Button is displayed");
		WebElement Apply_Button=driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']//span[@class='MuiButton-label'][normalize-space()='Apply']"));
		if(!(Apply_Button.isDisplayed()))
			test.fail("Apply Button is not displayed");
		else
			test.pass("Apply Button is displayed");
		List <WebElement> grid_Headers=driver.findElements(By.cssSelector("span[ref='eText']"));
		for (WebElement Element: grid_Headers)
		{
			String Grid_headername=Element.getText();
			if(Grid_headername.equalsIgnoreCase("Asset ID"))
				test.pass("Asset ID is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Scheme"))
				test.pass("Scheme is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Street"))
				test.pass("Street is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("County"))
				test.pass("County is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("City"))
				test.pass("City is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Eircode"))
				test.pass("Eircode is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Country"))
				test.pass("Country is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Build Date"))
				test.pass("Build Date is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Manager"))
				test.pass("Manager is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Action"))
				test.pass("Action is present in the gridlist");
}
		Thread.sleep(5000);
		List <WebElement> checkbox= driver.findElements(By.cssSelector("div [ref='eCheckbox']"));
		if(checkbox.size()==20)
			test.pass("20 Rows are displayed in the grid");
		else 
			test.error("There can be more or less than 20 rows on a page");
		if(!(driver.findElement(By.cssSelector("div [class='MuiGrid-root'] div [flexdirection='row']")).isDisplayed()))
			test.fail("Pagination is not displayed");
		else
			test.pass("Pagination is displayed");
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
	        FileUtils.copyFile(screenshot, new File("ScreenShot/FullPageScreenshot.png"));
	    } catch (IOException e) {
	        Log.info(e.getMessage());
	    }

}
@BeforeTest  
public void beforeTest_Properties_Overview() throws InterruptedException {	
	Log.info("Schemes overview validation");
	
}
@AfterTest  
public void afterTest_Properties_Overview() { 
driver.quit();  
}   
@AfterSuite
public void teardown()
{
	extent.flush();
}
}

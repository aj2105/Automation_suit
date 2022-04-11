package Suite;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import allTest.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class properties_Tab extends baseTest {

	public static WebDriver driver;
	//private static org.apache.logging.log4j.Logger log = LogManager.getLogger(properties_Tab.class);
	//private static Logger log = Logger.getLogger(properties_Tab.class);
	//ExtentReports extent;
	//ExtentHtmlReporter htmlReporter;
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
	/*	System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();  */
		//extent = ExtentManager.createInstance("extent.html");*/
	    /*htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/Reports/PropertyTabValidationextentReport.html");
	    extent=new ExtentReports();
		extent.attachReporter(htmlReporter);*/
	}
	@Test
	public void testeasy_Properties_tab_Overview() throws Exception {
		test=extent.createTest("Properties Tab Validation","This script is to validate all the items present in the different tab for property item.");
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
		WebElement properties = driver.findElement(By.xpath("//span[normalize-space()='Properties']"));
		if (!properties.isDisplayed())
			test.fail("Properties not displayed");
		else
			{
			test.pass("Properties is displayed. Clicking on it to see the sub-items"); 
			properties.click();
			}
		Thread.sleep(5000);
		if (!(driver.findElement(By.cssSelector("div [id=\"kt_wrapper\"] h1"))).isDisplayed())
			test.fail("Property List page is not displayed",MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		else
			test.pass("Property List page is displayed");
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("div [name='right'] [class='MuiIconButton-label'] [class='MuiSvgIcon-root']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//body/div[@role='presentation']/div[3]/ul[1]/li[1]")).click();
		Thread.sleep(3000);
		test.info("Validating the lables present on overview tab");
		List <WebElement> labels=driver.findElements(By.cssSelector("div[aria-hidden='false'] div[class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3'] label[data-shrink='true']"));
		for(int i=0; i<labels.size(); i++)
		{
			test.pass("The label present under Property Overview are "+ labels.get(i).getText());
		}
		WebElement Information_tab= driver.findElement(By.cssSelector("div [role='tablist'] button[id*='1']"));
		Information_tab.click();
		Thread.sleep(5000);
		test.info("The Lables present in Informations tab are");
		List <WebElement> info_labels=driver.findElements(By.cssSelector("div[aria-hidden='false'] div[class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3'] label[data-shrink='true']"));
		for(int i=0; i<info_labels.size(); i++)
		{
			test.pass(info_labels.get(i).getText());
		}
		WebElement Components_tab= driver.findElement(By.cssSelector("div [role='tablist'] button[id*='2']"));
		if (!(Components_tab.isDisplayed()))
			test.fail("Component Tab is not displayed",MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		else
			Components_tab.click();
		Thread.sleep(5000);
		WebElement create_Button=driver.findElement(By.xpath("//span[normalize-space()='Create']"));
		if (!(create_Button.isDisplayed()))
			test.fail("Create Button is not displayed", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		else
			test.pass("Create Button is displayed");
		Thread.sleep(5000);
		WebElement search_Bar=driver.findElement(By.xpath("//input[@id='search']"));
		if (!(search_Bar.isDisplayed()))
			test.fail("Search Bar is not displayed",MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		else
			test.pass("Search Bar is displayed");
		Thread.sleep(3000);
		if(!(driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3']//div[@class='MuiGrid-root MuiGrid-item']"))).isDisplayed())
			test.fail("Search button is not present in the grid",MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		else
			test.pass("Search button is present but disabled in the grid");
		search_Bar.sendKeys("az");
		Thread.sleep(4000);
		if(!(driver.findElement(By.xpath("//span[@class='MuiButton-label'][normalize-space()='Search']"))).isDisplayed())
			test.fail("Search button is not present in the grid",MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		else
			test.pass("Search button is present and enabled in the grid");
		WebElement Maintenance_tab= driver.findElement(By.cssSelector("div [role='tablist'] button[id*='3']"));
		if (!(Maintenance_tab.isDisplayed()))
			test.fail("Maintenance Tab is not displayed",MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		else
			Maintenance_tab.click();
		List <WebElement> headers=driver.findElements(By.xpath("//h6[normalize-space()]"));
		test.info("The Labels present on Maintenance Tab are:");
		for(int i=0;i<headers.size();i++)
		{
			test.pass(headers.get(i).getText());
		}
		WebElement Compliance_tab= driver.findElement(By.cssSelector("div [role='tablist'] button[id*='4']"));
		if (!(Compliance_tab.isDisplayed()))
			test.fail("Compliance Tab is not displayed",MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		else
			Compliance_tab.click();
		WebElement Boiler_text=driver.findElement(By.xpath("//h6[normalize-space()='Boiler']"));
		if(!(Boiler_text).isDisplayed())
			test.fail("Boiler is not present in the grid",MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		else
			test.pass("Boiler is present in the grid");
		WebElement Certificate_text=driver.findElement(By.xpath("//h6[normalize-space()='Certificate']"));
		if(!(Certificate_text).isDisplayed())
			test.fail("`Certificate is not present in the grid",MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		else
			test.pass("Certificate is present in the grid");
		WebElement Tenants_tab= driver.findElement(By.cssSelector("div [role='tablist'] button[id*='5']"));
		Tenants_tab.click();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
	        FileUtils.copyFile(screenshot, new File("ScreenShot/FullPageScreenshot.png"));
	    } catch (IOException e) {
	        test.info(e.getMessage());
	    }
		}
	@AfterTest  
	public void afterTest_properties_Tab() { 
	driver.quit();  
	}   
	
}


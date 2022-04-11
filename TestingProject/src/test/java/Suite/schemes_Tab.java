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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import allTest.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class schemes_Tab extends baseTest{
	public static WebDriver driver;
	//private static final org.apache.logging.log4j.Logger Log = LogManager.getLogger(schemes_Tab.class);
	@BeforeClass
	public void setUp_schemes_Tab()
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
		/*System.setProperty("webdriver.chrome.driver","/Users/ayaz.husain/Downloads/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();*/
		
	}
	@Test
	public void testeasy_schemes_tab() throws InterruptedException {
		test=extent.createTest("Scheme Tab Validation","This script is to validate all the items present in the different tab for Scheme item.");
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
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("div [name='right'] [class='MuiIconButton-label'] [class='MuiSvgIcon-root']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//body/div[@role='presentation']/div[3]/ul[1]/li[1]")).click();
		Thread.sleep(6000);
		test.info("Validating the labels present on overview tab");
		List <WebElement> labels=driver.findElements(By.cssSelector("div[aria-hidden='false'] div[class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3'] label[data-shrink='true']"));
		test.info("The label present under Scheme Overview are:");
		for(int i=0; i<labels.size(); i++)
		{
			 try{
			     test.pass(labels.get(i).getText());
			     break;
			  }
			  catch(Exception e){
				  test.error(e.getMessage());
			  }
		}
			test.info("Validating Information tab");
			WebElement Information_tab= driver.findElement(By.cssSelector("div [role='tablist'] button[id*='1']"));
			Information_tab.click();
			Thread.sleep(5000);
			WebElement Scheme_details=driver.findElement(By.xpath("//h6[normalize-space()='Scheme Details']"));
			if(!(Scheme_details.isDisplayed()))
				test.fail("The Scheme details is not displayed");
			else
				test.pass("The Scheme Details is displayed");
			List <WebElement> labels1=driver.findElements(By.cssSelector("div[aria-hidden='false'] div[class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3'] label[data-shrink='true']"));
			for(int i=0; i<labels1.size(); i++)
			{
				test.info("The label present are under Scheme details are "+ labels1.get(i).getText());
			}
			WebElement Sites_details=driver.findElement(By.xpath("//h6[normalize-space()='Sites']"));
			if(!(Sites_details.isDisplayed()))
				test.fail("The Sites is not displayed");
			else
				test.pass("The Sites is displayed");
			WebElement Block_details=driver.findElement(By.xpath("//h6[normalize-space()='Blocks']"));
			if(!(Block_details.isDisplayed()))
				test.fail("The Blocks list is not displayed");
			else
				test.pass("The Blocks list is displayed");
			WebElement Properties_details=driver.findElement(By.xpath("//h6[normalize-space()='Properties']"));
			if(!(Properties_details.isDisplayed()))
				test.fail("The Properties list is not displayed");
			else
				test.pass("The Properties list is displayed");
			test.info("Validating Component tab");
			WebElement Component_tab= driver.findElement(By.cssSelector("div [role='tablist'] button[id*='2']"));
			Component_tab.click();
			Thread.sleep(6000);
			/*WebElement AddComponent_Button=driver.findElement(By.xpath("//div[@class='MuiBox-root jss32857']//span[@class='MuiButton-label'][normalize-space()='Create']"));
			if(!(AddComponent_Button.isDisplayed()))
				test.fail("The Add Component Button is not displayed");
			else
				test.pass("The Add Component Button is displayed");*/
			List <WebElement> Component_header=driver.findElements(By.cssSelector("div [aria-hidden='false'] div [ref='eHeaderViewport'] div[ref='eLabel'] span[ref='eText']"));
			test.info("The columns in the table are:");
			for(int i=0;i<Component_header.size();i++)
				test.info(Component_header.get(i).getText());
			
			test.info("Validating Manager tab");
			WebElement Manager_tab= driver.findElement(By.cssSelector("div [role='tablist'] button[id*='3']"));
			Manager_tab.click();
			WebElement 	Admin_Manager=driver.findElement(By.xpath("//h6[normalize-space()='Admin Managers']"));
			if(!(Admin_Manager.isDisplayed()))
				test.fail("The Admin Manager is not displayed");
			else
				test.pass("The Admin Manager is displayed");
			WebElement 	Manager=driver.findElement(By.xpath("//h6[normalize-space()='Managers']"));
			if(!(Manager.isDisplayed()))
				test.fail("The Manager is not displayed");
			else
				test.pass("The Manager is displayed");
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
		        FileUtils.copyFile(screenshot, new File("ScreenShot/FullPageScreenshot.png"));
		    } catch (IOException e) {
		        test.error(e.getMessage());
		    }
			
	}
	@AfterTest  
	public void afterTest_schemes_Tab() { 
	driver.quit();  
	}   
}

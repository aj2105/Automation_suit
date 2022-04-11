package Suite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import allTest.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class oilBoilerServiceProgramme_ItemOverview extends baseTest {

	public static WebDriver driver;
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
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);            
/*		System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();         */
	}
	@Test
	public void testeasy_oilBoiler_tab() throws InterruptedException {
		test=extent.createTest("Oil Boiler Service programme-Item Overview","This is to Validate all the labels in Oil Boiler item in the list");
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
		WebElement boilerService = driver.findElement(By.xpath("//span[normalize-space()='Boiler Service Programme']"));
		if (!boilerService.isDisplayed())
			test.fail("Boiler Service Programme is not displayed");
		else
		{
			test.pass("Boiler Service Programme is displayed. Clicking on it:"); 
			boilerService.click();
		}
	Thread.sleep(5000);
	WebElement OilBoiler_button= driver.findElement(By.xpath("//span[normalize-space()='Oil Boiler']"));
	OilBoiler_button.click();

/*	if(!(OilBoiler_button.isDisplayed()))
		test.fail("Oil Boiler Tab is not displayed");
	else
		{
		test.pass("Oil Boiler Tab is displayed");
		test.info("Clicking on Oil Boiler Tab");
		OilBoiler_button.click();
		}                */
	
	Thread.sleep(4000);
	test.info("Validating all the labels in an item present in Oil Boiler List View Page");
	driver.findElement(By.cssSelector("div [name='right'] [class='MuiIconButton-label'] [class='MuiSvgIcon-root']")).click();
	Thread.sleep(6000);
	driver.findElement(By.xpath("//body/div[@role='presentation']/div[3]/ul[1]/li[1]")).click();
	Thread.sleep(6000);
	List <WebElement> labels=driver.findElements(By.cssSelector("div[aria-hidden='false'] div[class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3'] label[data-shrink='true']"));
	test.info("The label present under Gas Boiler Overview are:");
	for(int i=0; i<labels.size(); i++)
	{
		 try{
		     test.pass(labels.get(i).getText());
		  }
		  catch(Exception e){
			  test.fail(e.getMessage());
		  }
	}
	WebElement certificate=driver.findElement(By.xpath("//h6[normalize-space()='Certificate']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", certificate);
	if (!certificate.isDisplayed())
		test.fail("Certificate section is not displayed");
	else
		test.pass("Certificate section is displayed"); 
	WebElement upload_button=driver.findElement(By.xpath("//span[@class='MuiButton-label'][normalize-space()='Upload']"));
	if (!upload_button.isDisplayed())
		test.fail("Upload Button is not displayed");
	else
		test.pass("Upload Button is displayed"); 
	List <WebElement> labels1=driver.findElements(By.cssSelector("div[ref='eHeaderViewport'] div[role='columnheader']"));
	for(int i=0; i<labels1.size(); i++)
	{
		 try{
		     test.pass("The label present under Certificates is: "+ labels1.get(i).getText());
		     break;
		  }
		  catch(Exception e){
			  test.fail(e.getMessage());
		  }
	}

}
	@AfterClass 
	public void afterTest_Properties_Overview() { 
	driver.quit();  
	}  
}


package Suite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class payments_Overview extends baseTest{
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
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);            
/*		System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();    */
	}
	@Test
	public void Payment_Overview() throws InterruptedException {
		test=extent.createTest("Payment Overview","This is to validate the items Payment List view Page");
		driver.get("https://www.ips2-qa.bynaric.net/");
		Thread.sleep(1000);
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		email.sendKeys("admin@bynaric.com");
		test.info("UserName Entered: admin@bynaric.com");
		password.sendKeys("123456");
		test.info("Password Entered: 123456");
		Thread.sleep(500);
		driver.findElement(By.cssSelector("div [class='MuiButton-label']")).click();
		Thread.sleep(1000);
		test.info("Sign in button is clicked");
	/*	WebElement Logo = driver.findElement(By.cssSelector("div [class='brand-logo']"));
	if (!Logo.isDisplayed())
			Assert.fail("User not logged in");
		else
			test.pass("User logged in"); 
		Thread.sleep(5000);                  */
		Thread.sleep(3000);
		WebElement Payment = driver.findElement(By.cssSelector("a[href=\"/tenant-self-service/payments\"]"));
		if (!(Payment.isDisplayed()))
			test.fail("Payment is not displayed");
		else
		{
			test.pass("Payment is displayed: Clicking on it:");
			Payment.click();
		}
		Thread.sleep(1000);
		WebElement Payment_Text=driver.findElement(By.cssSelector("h1[class*='MuiTypography-h6']"));
		if (!(Payment_Text.isDisplayed()))
			test.fail("Payment List page is not displayed");
		else
			test.pass("Payment List page is displayed");
		Thread.sleep(1000);
		List <WebElement> grid_Headers=driver.findElements(By.cssSelector("span[ref='eText']"));
		test.info("The headers present in the grid are: ");
		for (WebElement Element: grid_Headers)
		{
			test.pass(Element.getText());
		}
		if ((driver.findElement(By.cssSelector("div[class*='ag-theme-material'] div[class*='MuiBox-root']")).isDisplayed()))
			test.pass(driver.findElement(By.cssSelector("div[class*='ag-theme-material'] div[class*='MuiBox-root']")).getText());
		else
		{
		List <WebElement> checkbox= driver.findElements(By.cssSelector("div [ref='eCheckbox']"));
		if(checkbox.size()==20)
			test.pass("20 Rows are displayed in the grid");
		else 
			test.info("There are "+checkbox.size()+"rows on a page");
		}
		if(!(driver.findElement(By.cssSelector("div [class='MuiGrid-root'] div [flexdirection='row']")).isDisplayed()))
			test.fail("Pagination is not displayed");
		else
			test.pass("Pagination is displayed");
		
	}
	@AfterClass 
	public void afterTest() { 
	driver.quit();  
	}  

}

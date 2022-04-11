package Suite;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import allTest.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AssetManagement_Validation extends baseTest{
	public static WebDriver driver;
	//private static final org.apache.logging.log4j.Logger Log = LogManager.getLogger(AssetManagement_Validation.class);
	@BeforeClass
	public void setUp_AssetManagement_Validation()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
	    options.addArguments("--headless");
		options.addArguments("--window-size=1920,1200");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(7000)); 
	}
	@Test
	public void testeasy_AssetManagement_Validation() throws InterruptedException {
		test=extent.createTest(" Asset Management Validation","This script is to validate all the items present in Asset Management");
		test.info("Validation of the items in Asset Management");
		driver.get("https://www.ips2-qa.bynaric.net/");
		Thread.sleep(3000);
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		email.sendKeys("admin@bynaric.com");
		test.info("UserName Entered: admin@bynaric.com");
		password.sendKeys("123456");
		test.info("Password Entered: 123456");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div [class='MuiButton-label']")).click();
		Thread.sleep(2000);
		test.info("Sign in button is clicked");
		WebElement Logo = driver.findElement(By.cssSelector("div [class='brand-logo']"));
		Thread.sleep(1000);
		if (!Logo.isDisplayed())
			test.fail("User not logged in");
		else
			test.pass("User logged in"); 
		Thread.sleep(500);
		WebElement AssetManagement = driver.findElement(By.xpath("//span[normalize-space()='Asset Management']"));
		if (!AssetManagement.isDisplayed())
			test.fail("Asset Management not displayed");
		else
			{
			test.pass("Asset Management is displayed. Clicking on it to see the sub-items"); 
			AssetManagement.click();
			}
		Thread.sleep(500);
		WebElement schemes = driver.findElement(By.xpath("//span[normalize-space()='Schemes']"));
		if (!schemes.isDisplayed())
			test.fail("Schemes not displayed");
		else
			{
			test.pass("Schemes is displayed. Clicking on it to Validate whether the schemes-list view page is displayed or not. "); 
			schemes.click();
			}
		Thread.sleep(300);
		if (!(driver.findElement(By.cssSelector("div [id=\"kt_wrapper\"] h1"))).isDisplayed())
			test.fail("Schemes List page is not displayed");
		else
			test.pass("Schemes List page is displayed");
		WebElement Blocks = driver.findElement(By.xpath("//span[normalize-space()='Blocks']"));
		if (!Blocks.isDisplayed())
			test.fail("Blocks not displayed");
		else
			{
			test.pass("Blocks is displayed. Clicking on it to Validate whether the Blocks-list view page is displayed or not. "); 
			Blocks.click();
			}
		Thread.sleep(300);
		if (!(driver.findElement(By.cssSelector("div [id=\"kt_wrapper\"] h1"))).isDisplayed())
			test.fail("Blocks List page is not displayed");
		else
			test.pass("Blocks List page is displayed");
		WebElement properties = driver.findElement(By.xpath("//span[normalize-space()='Properties']"));
		if (!properties.isDisplayed())
			test.fail("Properties not displayed");
		else
			{
			test.pass("Properties is displayed. Clicking on it to Validate whether the Properties-list view page is displayed or not. "); 
			properties.click();
			}
		Thread.sleep(300);
		if (!(driver.findElement(By.cssSelector("div [id=\"kt_wrapper\"] h1"))).isDisplayed())
			test.fail("Properties List page is not displayed");
		else
			test.pass("Properties List page is displayed");
}
	@AfterTest  
	public void afterTest_AssetManagement_Validation() { 
	driver.quit();  
	}   
}

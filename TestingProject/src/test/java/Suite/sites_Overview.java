package Suite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import allTest.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class sites_Overview extends baseTest{
	public static WebDriver driver;
	//private static final org.apache.logging.log4j.Logger Log = LogManager.getLogger(propeties_Overview.class);
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
		/*System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();*/
	}
	@Test
	public void testeasy_Sites_Overview() throws InterruptedException {
		test=extent.createTest("Sites Overview Validation","This script is to validate all the items present on the Sites List View Page.");
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
		WebElement sites = driver.findElement(By.xpath("//span[normalize-space()='Sites']"));
		if (!sites.isDisplayed())
			test.fail("Sites not displayed");
		else
			{
			test.pass("Sites is displayed. Clicking on it."); 
			sites.click();
			}
		Thread.sleep(3000);
		if (!(driver.findElement(By.cssSelector("div [id='kt_wrapper'] h1"))).isDisplayed())
			test.fail("Sites List page is not displayed");
		else
			test.pass("Sites List page is displayed");
		Thread.sleep(1000);
		WebElement UploadComponent= driver.findElement(By.xpath("//span[normalize-space()='Upload Components']"));
		if(!(UploadComponent).isDisplayed())
			test.fail("Upload component button is not displayed in the grid");
		else
			test.pass("Upload component is displayed in the grid");
		WebElement Create_button= driver.findElement(By.xpath("//span[normalize-space()='Create']"));
		if(!(Create_button).isDisplayed())
			test.fail("Create button is not displayed in the grid");
		else
			test.pass("Create button is displayed in the grid");
		List <WebElement> grid_Headers=driver.findElements(By.cssSelector("span[ref='eText']"));
		test.info("Validating all the Column Headers: ");
		for (WebElement Element: grid_Headers)
		{
			test.pass(Element.getText());
		}
		List <WebElement> checkbox= driver.findElements(By.cssSelector("div [ref='eCheckbox']"));
		if(checkbox.size()==20)
			test.pass("20 Rows are displayed in the grid");
		else 
			test.pass("There are "+checkbox.size()+ "rows on a page");
		if(!(driver.findElement(By.cssSelector("div [class='MuiGrid-root'] div [flexdirection='row']")).isDisplayed()))
			test.fail("Pagination is not displayed");
		else
			test.pass("Pagination is displayed");
	}
	@AfterTest  
	public void afterTest_Properties_Overview() { 
	driver.quit();  
	} 
}

package Suite;

import org.testng.annotations.Test;

import allTest.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class block_Overview extends baseTest {
	public static WebDriver driver;
	private static final org.apache.logging.log4j.Logger Log = LogManager.getLogger(block_Overview.class);
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
		driver.manage().window().maximize();	   */
		
	}
	@Test
	public void testeasy_block_overview() throws InterruptedException {
		test=extent.createTest("BlockOverview Validation","This script is to validate all the items present on Block Overview Page");
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
		Thread.sleep(500);
		test.info("Sign in succesful");
	/*	WebElement Logo = driver.findElement(By.cssSelector("div [class='brand-logo']"));
		Thread.sleep(1000);
		if (!Logo.isDisplayed())
			test.fail("User not logged in");
		else
			test.pass("User logged in");     */
		Thread.sleep(2000);                 
		WebElement AssetManagement = driver.findElement(By.xpath("//span[normalize-space()='Asset Management']"));
		
		AssetManagement.click();
	/*	if (!AssetManagement.isDisplayed())
			test.fail("Asset Management not displayed");
		else
			{
			test.pass("Asset Management is displayed. Clicking on it to see the sub-items"); 
			AssetManagement.click();
			}                            */
		Thread.sleep(1000);
		WebElement blocks = driver.findElement(By.xpath("//span[normalize-space()='Blocks']"));
		if (!blocks.isDisplayed())
			test.fail("Blocks not displayed");
		else
			{
			test.pass("Blocks is displayed. Clicking on it."); 
			blocks.click();
			}
		Thread.sleep(1000);
/*		if (!(driver.findElement(By.cssSelector("div [id=\"kt_wrapper\"] h1"))).isDisplayed())
			test.fail("Block List page is not displayed");
		else
			test.pass("Block List page is displayed");
	WebElement search_bar=driver.findElement(By.xpath("//input[@id='search']"));	
	
	search_bar.sendKeys("abc");
/*	if(!(search_bar).isDisplayed())
		test.fail("Search Bar is not present in the grid");
	else
		test.pass("Search Bar is present in the grid");
	if(!(driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3']//div[@class='MuiGrid-root MuiGrid-item']"))).isDisplayed())
		test.fail("Search button is not present in the grid");
	else
		test.pass("Search button is present but disabled in the grid");
	search_bar.sendKeys("abc");
	//Thread.sleep(400);
	if(!(driver.findElement(By.xpath("//span[@class='MuiButton-label'][normalize-space()='Search']"))).isDisplayed())
		test.fail("Search button is not present in the grid");
	else
		test.pass("Search button is present and enabled in the grid");
	WebElement UploadComponent= driver.findElement(By.xpath("//span[normalize-space()='Upload Components']"));
	if(!(UploadComponent).isDisplayed())
		test.fail("Upload component button is not present in the grid");
	else
		test.pass("Upload component is present in the grid");    */ 
	Thread.sleep(3000);  	               
	WebElement Filter= driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3']//div[@class='MuiGrid-root MuiGrid-item']"));
	Filter.click();
	test.info("Filter Button Clicked");
	//span[normalize-space()='Filter']
/*	if(!(Filter).isDisplayed())
		test.fail("Filter button is not present in the grid");
	else
		test.pass("Filter button is present in the grid");          */
	//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3']//div[@class='MuiGrid-root MuiGrid-item']
	
	Thread.sleep(1000);
	System.out.println("Validating Asset ID");
	/*WebElement Asset_ID=driver.findElement(By.id("custom_id-label"));
	if(!(Asset_ID.isDisplayed()))
		Log.fail("Asset ID Filter is not displayed");
	else
		Log.info("Asset ID Filter is displayed");*/
/*	WebElement BuildDate_Filter=driver.findElement(By.id("build_date"));
	if(!(BuildDate_Filter.isDisplayed()))
		test.fail("Build Date Filter is not displayed");
	else
		test.pass("Build Date Filter is displayed");

	WebElement Block_Filter=driver.findElement(By.id("block"));
	if(!(Block_Filter.isDisplayed()))
		test.fail("Block Filter is not displayed");
	else
		test.pass("Block Filter is displayed");
	WebElement Scheme_Filter=driver.findElement(By.id("scheme_id"));
	if(!(Scheme_Filter.isDisplayed()))
		test.fail("Scheme Filter is not displayed");
	else
		test.pass("Scheme Filter is displayed");
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
	Thread.sleep(2000);
	test.info("Validating Grid list view items");
	if(!(driver.findElement(By.xpath("//span[normalize-space()='Asset ID']"))).isDisplayed())
		test.fail("Asset ID is not present in the grid");
	else
		test.pass("Asset ID is present in the grid");
	if(!(driver.findElement(By.xpath("//span[@class='ag-header-cell-text'][normalize-space()='Block']"))).isDisplayed())
		test.fail("Block is not present in the grid");
	else
		test.pass("Block is present in the grid");
	if(!(driver.findElement(By.xpath("//span[@class='ag-header-cell-text'][normalize-space()='Scheme']"))).isDisplayed())
		test.fail("Scheme is not present in the grid");
	else
		test.pass("Scheme is present in the grid");
	if(!(driver.findElement(By.xpath("//span[@class='ag-header-cell-text'][normalize-space()='Build Date']"))).isDisplayed())
		test.fail("Build Date is not present in the grid");
	else
		test.pass("Build Date is present in the grid");
	if(!(driver.findElement(By.xpath("//span[normalize-space()='Action']"))).isDisplayed())
		test.fail("Action is not present in the grid");
	else
		test.pass("Action is present in the grid");
	Thread.sleep(500);
	List <WebElement> checkbox= driver.findElements(By.cssSelector("div [ref='eCheckbox']"));
	if(checkbox.size()==20)
		test.pass("20 Rows are displayed in the grid");
	else 
		test.info("There are "+checkbox.size()+" rows on a page");
	
	if(!(driver.findElement(By.cssSelector("div [class=\"MuiGrid-root\"] div [flexdirection=\"row\"]")).isDisplayed()))
		test.fail("Pagination is not displayed");
	else
		test.pass("Pagination is displayed");              */

}
@BeforeTest  
public void beforeTest_block_Overview() throws InterruptedException {
	System.out.println("Block overview validation");
	
}
@AfterTest  
public void afterTest() {
	System.out.println("Terminating Driver");
driver.quit();  
}   
}

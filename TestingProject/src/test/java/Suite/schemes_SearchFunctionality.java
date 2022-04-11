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

public class schemes_SearchFunctionality extends baseTest {
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
		/*System.setProperty("webdriver.chrome.driver","/Users/ayaz.husain/Downloads/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();*/
	}
	@Test
	public void testeasy_schemeSearch_tab() throws InterruptedException {
		test=extent.createTest("Scheme-Global search Functionality","This is to Validate search functionlaity in the list");
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
		if (!(driver.findElement(By.cssSelector("div [id='kt_wrapper'] h1"))).isDisplayed())
			test.fail("Schemes List page is not displayed");
		else
			test.pass("Schemes List page is displayed");
		Thread.sleep(1000);
		WebElement search_bar=driver.findElement(By.id("search"));	
		if(!(search_bar).isDisplayed())
			test.fail("Search Bar is not displayed in the grid");
		else
			test.pass("Search Bar is displayed in the grid");
		WebElement search_Button=driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3']//div[@class='MuiGrid-root MuiGrid-item']"));
		if(!(search_Button).isDisplayed())
			test.fail("Search button is not displayed in the grid");
		else
			test.pass("Search button is displayed but disabled in the grid");
		test.info("Validating the global search functionality on the grid items");
		String s="200167";
		search_bar.sendKeys(s);
		WebElement search=driver.findElement(By.xpath("//span[@class='MuiButton-label'][normalize-space()='Search']"));
		if(!(search).isDisplayed())
			test.fail("Search button is not interacting");
		else
			search.click();
		Thread.sleep(5000);
		List <WebElement> result=driver.findElements(By.cssSelector("div[role='grid'] div[ref='eBodyViewport'] div[ref='centerContainer'] div[role='gridcell']"));
		int i=0;
		for(WebElement Element:result)
		{
			if(Element.getText().contains(s))
				i=i+1;
		}
		if(i==0)
		{ 
			WebElement no_records=driver.findElement(By.cssSelector("div[class*='ag-theme-material'] div[class*='MuiBox-root']"));
			if(!(no_records.isDisplayed()))
			test.fail("The result displayed is not accurate");
			else
			test.pass("No result is displayed");
		}
		else
			test.pass("The result is displayed in the grid for "+i+" time/times");
		
	}
	@AfterClass 
	public void afterTest() { 
	driver.quit();  
	}  

}
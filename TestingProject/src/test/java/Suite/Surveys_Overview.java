package Suite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import allTest.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Surveys_Overview extends baseTest{
	public static WebDriver driver;
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
		/*System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();*/
	}
	@Test
	public void Survey_Overview() throws InterruptedException {
		test=extent.createTest("Survey Overview-both Pending and completed Surveys","This is to validate the items on Surveys and Completed Surveys");
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
			test.fail("User not logged in");
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
		test.info("Validating all the items on Survey List view Page");
		WebElement surveys = driver.findElement(By.cssSelector("li[class='menu-item menu-item-submenu menu-item-open\'] a[href='/property-services/surveys/list']"));
		surveys.click();
		WebElement create_Button=driver.findElement(By.xpath("//span[normalize-space()='Create']"));
		if(!(create_Button).isDisplayed())
			test.fail("Create Button is not displayed in the grid");
		else
			test.pass("Create Button is displayed in the grid");
		WebElement kanban_Button=driver.findElement(By.xpath("//span[normalize-space()='Kanban']"));
		if(!(kanban_Button).isDisplayed())
			test.fail("Kanban Button is not displayed in the grid");
		else
			test.pass("Kanban Button is displayed in the grid");
		List <WebElement> grid_Headers=driver.findElements(By.cssSelector("span[ref='eText']"));
		test.info("The headers present in the grid are: ");
		for (WebElement Element: grid_Headers)
		{
			test.pass(Element.getText());
		}
		Thread.sleep(5000);
		List <WebElement> checkbox= driver.findElements(By.cssSelector("div [ref='eCheckbox']"));
		if(checkbox.size()==20)
			test.pass("20 Rows are displayed in the grid");
		else 
			test.info("There are "+checkbox.size()+" rows on a page");
		if(!(driver.findElement(By.cssSelector("div [class='MuiGrid-root'] div [flexdirection='row']")).isDisplayed()))
			test.fail("Pagination is not displayed");
		else
			test.pass("Pagination is displayed");
		test.info("Validating all the items on Completed Survey List view Page");
		WebElement completed_surveys=driver.findElement(By.xpath("//span[normalize-space()='Completed Surveys']"));
		if(!(completed_surveys).isDisplayed())
			test.fail("Completed Surveys is not displayed in the grid");
		else
		{ 
			test.pass("Completed Surveys is displayed in the grid. Clicking on it:");
			completed_surveys.click();
		}
		//WebElement create_Button=driver.findElement(By.xpath("//span[normalize-space()='Create']"));
		if(!(create_Button).isDisplayed())
			test.fail("Create Button is not displayed in the grid");
		else
			test.pass("Create Button is displayed in the grid");
		//WebElement kanban_Button=driver.findElement(By.xpath("//span[normalize-space()='Kanban']"));
		if(!(kanban_Button).isDisplayed())
			test.fail("Kanban Button is not displayed in the grid");
		else
			test.pass("Kanban Button is displayed in the grid");
		grid_Headers=driver.findElements(By.cssSelector("span[ref='eText']"));
		test.info("The headers present in the grid are: ");
		for (WebElement Element: grid_Headers)
		{
			test.pass(Element.getText());
		}
		Thread.sleep(5000);
		checkbox= driver.findElements(By.cssSelector("div [ref='eCheckbox']"));
		if(checkbox.size()==20)
			test.pass("20 Rows are displayed in the grid");
		else 
			test.info("There are "+checkbox.size()+" rows on a page");
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

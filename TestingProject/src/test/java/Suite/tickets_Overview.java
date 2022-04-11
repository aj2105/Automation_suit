package Suite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import allTest.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class tickets_Overview extends baseTest{
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
		/*System.setProperty("webdriver.chrome.driver","/Users/ayaz.husain/Downloads/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();*/
	}
	@Test
	public void Ticket_Overview() throws InterruptedException {
		test=extent.createTest("Ticket Overview","This is to validate the items Tenants List view Page");
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
		WebElement element= driver.findElement(By.xpath("//span[normalize-space()='Configuration']"));   
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		WebElement Tickets = driver.findElement(By.cssSelector("a[href='/case-management/ticket']"));
		if (!(Tickets.isDisplayed()))
			test.fail("Tickets is not displayed");
		else
			{
			test.pass("Tickets is displayed: Clicking on it:");
			Tickets.click();
			}
		Thread.sleep(3000);
		WebElement Tickets_Text=driver.findElement(By.cssSelector("h1[class*='MuiTypography-h6']"));
		if (!(Tickets_Text.isDisplayed()))
			test.fail("Tickets List page is not displayed");
		else
			test.pass("Tickets List page is displayed");
		Thread.sleep(1000);
		WebElement Filter= driver.findElement(By.xpath("//span[normalize-space()='Filter']"));
		if(!(Filter).isDisplayed())
			test.fail("Filter button is not displayed in the grid");
		else
			{
			test.pass("Filter button is displayed in the grid");
			Filter.click();
			}
		WebElement TicNo_Filter=driver.findElement(By.id("ticket_number"));
		if(!(TicNo_Filter.isDisplayed()))
			test.fail("Ticket No. Filter Filter is not displayed");
		else
			test.pass("Ticket No. Filter is displayed");
		WebElement TicSub_Filter=driver.findElement(By.id("ticket_subject"));
		if(!(TicSub_Filter.isDisplayed()))
			test.fail("Ticket Subject Filter Filter is not displayed");
		else
			test.pass("Ticket Subject Filter is displayed");
		WebElement req_Filter=driver.findElement(By.id("requester_name"));
		if(!(req_Filter.isDisplayed()))
			test.fail("Requester Name Filter is not displayed");
		else
			test.pass("Requester Name Filter is displayed");
		WebElement RequestOnfromDate_Filter=driver.findElement(By.id("requested_on_from"));
			if(!(RequestOnfromDate_Filter.isDisplayed()))
				test.fail("Request On From Date Filter is not displayed");
			else
				test.pass("Request On From Date Filter is displayed");
		WebElement RequestOnToDate_Filter=driver.findElement(By.id("requested_on_to"));
			if(!(RequestOnToDate_Filter.isDisplayed()))
				test.fail("Request On To Date Filter is not displayed");
			else
				test.pass("Request On To Date Filter is displayed");
		WebElement Status_Filter=driver.findElement(By.id("status"));
			if(!(Status_Filter.isDisplayed()))
				test.fail("Status Filter is not displayed");
			else
				test.pass("Status Filter is displayed");
		WebElement priority_Filter=driver.findElement(By.id("priority"));
			if(!(priority_Filter.isDisplayed()))
				test.fail("Priority Filter is not displayed");
			else
				test.pass("Priority Filter is displayed");
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
		WebElement Close_button=driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary']//span[@class='MuiButton-label']//*[name()='svg']"));
		if(!(Close_button.isDisplayed()))
			test.fail("Close Button is not displayed");
		else
		{
			test.pass("Close Button is displayed");
			Close_button.click();
		}
		Thread.sleep(2000);
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
			test.info("There are "+checkbox.size()+" rows on a page");
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

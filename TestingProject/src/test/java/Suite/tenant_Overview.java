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

public class tenant_Overview extends baseTest{
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
	public void Tenants_Overview() throws InterruptedException {
		test=extent.createTest("Tenants Overview","This is to validate the items Tenants List view Page");
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
		WebElement Tenants = driver.findElement(By.cssSelector("a[href=\"/tenant-self-service/tenants\"]"));
		if (!(Tenants.isDisplayed()))
			test.fail("Tenants is not displayed");
		else
			{
			test.pass("Tenants is displayed: Clicking on it:");
			Tenants.click();
			}
		Thread.sleep(3000);
		WebElement Tenants_Text=driver.findElement(By.cssSelector("h1[class*='MuiTypography-h6']"));
		if (!(Tenants_Text.isDisplayed()))
			test.fail("Tenants List page is not displayed");
		else
			test.pass("Tenants List page is displayed");
		Thread.sleep(1000);
		WebElement search_bar=driver.findElement(By.xpath("//input[@id='search']"));	
		if(!(search_bar).isDisplayed())
			test.fail("Search Bar is not displayed in the grid");
		else
			test.pass("Search Bar is displayed in the grid");
		if(!(driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3']//div[@class='MuiGrid-root MuiGrid-item']"))).isDisplayed())
			test.fail("Search button is not displayed in the grid");
		else
			test.pass("Search button is displayed but disabled in the grid");
		search_bar.sendKeys("az");
		//Thread.sleep(400);
		if(!(driver.findElement(By.xpath("//span[@class='MuiButton-label'][normalize-space()='Search']"))).isDisplayed())
			test.fail("Search button is not displayed in the grid");
		else
			test.pass("Search button is displayed and enabled in the grid");
		WebElement Filter= driver.findElement(By.xpath("//span[normalize-space()='Filter']"));
		if(!(Filter).isDisplayed())
			test.fail("Filter button is not present in the grid");
		else
			{
			test.pass("Filter button is present in the grid");
			Filter.click();
			}
		WebElement Name_Filter=driver.findElement(By.id("name"));
		if(!(Name_Filter.isDisplayed()))
			test.fail("Name Filter is not displayed");
		else
			test.pass("Name Filter is displayed");
		WebElement Surname_Filter=driver.findElement(By.id("surname"));
		if(!(Surname_Filter.isDisplayed()))
			test.fail("Surname Filter is not displayed");
		else
			test.pass("Surname Filter is displayed");
		WebElement DOB_Filter=driver.findElement(By.id("date_of_birth"));
		if(!(DOB_Filter.isDisplayed()))
			test.fail("Date of Birth Filter is not displayed");
		else
			test.pass("Date of Birth Filter is displayed");
		WebElement Mobile_Filter=driver.findElement(By.id("mobile"));
			if(!(Mobile_Filter.isDisplayed()))
				test.fail("Mobile Filter is not displayed");
			else
				test.pass("Mobile Filter is displayed");
		WebElement Email_Filter=driver.findElement(By.id("email"));
			if(!(Email_Filter.isDisplayed()))
				test.fail("Email Filter is not displayed");
			else
				test.pass("Email Filter is displayed");
		WebElement Subcompany_Filter=driver.findElement(By.id("sub_company"));
			if(!(Subcompany_Filter.isDisplayed()))
				test.fail("Sub-company Filter is not displayed");
			else
				test.pass("Sub-company Filter is displayed");
		WebElement occupancy_Filter=driver.findElement(By.id("occupancy"));
			if(!(occupancy_Filter.isDisplayed()))
				test.fail("Occupancy Filter is not displayed");
			else
				test.pass("Occupancy Filter is displayed");
		WebElement Resident_Type_Filter=driver.findElement(By.id("res_type"));
			if(!(Resident_Type_Filter.isDisplayed()))
				test.fail("Resident Type Filter is not displayed");
			else
				test.pass("Resident Type Filter is displayed");
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
			test.info("There can be more or less than 20 rows on a page");
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

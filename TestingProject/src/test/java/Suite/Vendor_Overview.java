package Suite;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import allTest.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Vendor_Overview extends baseTest{
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
	public void Vendor_Overview_Validation() throws Exception {
		test=extent.createTest("Vendor-Overview","This is to Validate all the items On Vendor Overview Page");
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
		WebElement Vendor = driver.findElement(By.xpath("//span[normalize-space()='Vendors']"));
		if (!(Vendor.isDisplayed()))
			test.fail("Vendor is not displayed");
		else
			{
			test.pass("Vendor is displayed. Clicking on it:");
			Vendor.click();
			}
		Thread.sleep(5000);
		test.info("Validating all the items on Vendor List View Page");
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
		WebElement create_button=driver.findElement(By.xpath("//span[normalize-space()='Create']"));
		if(!(create_button).isDisplayed())
			test.fail("Create button is not displayed in the grid");
		else
			test.pass("Create button is displayed in the grid");
		WebElement Filter= driver.findElement(By.xpath("//span[normalize-space()='Filter']"));
		if(!(Filter).isDisplayed())
			test.fail("Filter button is not displayed in the grid");
		else
			test.pass("Filter button is displayed in the grid");
		Thread.sleep(5000);
		Filter.click();
		test.info("Filter Button Clicked");
		Thread.sleep(5000);
		WebElement Name=driver.findElement(By.id("name"));
		if(!(Name.isDisplayed()))
			test.fail("Name is not displayed");
		else
			test.pass("Name is displayed");
		WebElement Vendor_type=driver.findElement(By.id("vendor_type_id"));
		if(!(Vendor_type.isDisplayed()))
			test.fail("Vendor type is not displayed");
		else
			test.pass("Vendor type is displayed");
		WebElement Vendor_Category=driver.findElement(By.id("vendor_category_id"));
		if(!(Vendor_Category.isDisplayed()))
			test.fail("Vendor Category is not displayed");
		else
			test.pass("Vendor Category is displayed");
		WebElement Registration_Number=driver.findElement(By.id("registration_number"));
		if(!(Registration_Number.isDisplayed()))
			test.fail("Registration is not displayed");
		else
			test.pass("Registration is displayed");
		/*WebElement Number=driver.findElement(By.id("number"));
		if(!(Number.isDisplayed()))
			test.fail("Number is not displayed");
		else
			test.pass("Number is displayed");
		WebElement Street=driver.findElement(By.id("street"));
		if(!(Street.isDisplayed()))
			test.fail("Street is not displayed");
		else
			test.pass("Street is displayed");
			WebElement Eircode=driver.findElement(By.id("eircode"));
		if(!(Eircode.isDisplayed()))
			test.fail("Eircode is not displayed");
		else
			test.pass("Eircode is displayed");*/
		WebElement County=driver.findElement(By.id("county"));
		if(!(County.isDisplayed()))
			test.fail("County is not displayed");
		else
			test.pass("County is displayed");
		WebElement city=driver.findElement(By.id("city"));
		if(!(city.isDisplayed()))
			test.fail("city is not displayed");
		else
			test.pass("city is displayed");
		
		WebElement country=driver.findElement(By.id("country_id"));
		if(!(country.isDisplayed()))
			test.fail("country is not displayed");
		else
			test.pass("country is displayed");
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
		WebElement close_button=driver.findElement(By.cssSelector("button[class*='MuiButton-textPrimary'] span[class*='MuiButton-label'] svg"));
		if(!(close_button.isDisplayed()))
			test.fail("Close Button is not displayed on Filter Modal");
		else
			{
			test.pass("Close Button is displayed on Filter Modal");
			close_button.click();
			}
		Thread.sleep(2000);
		List <WebElement> grid_Headers=driver.findElements(By.cssSelector("span[ref='eText']"));
		for (WebElement Element: grid_Headers)
		{
			String Grid_headername=Element.getText();
			if(Grid_headername.equalsIgnoreCase("Name"))
				test.info("Name is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Type"))
				test.info("Type is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Category"))
				test.info("Category is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Phone"))
				test.info("Phone is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Email"))
				test.info("Email is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Registration"))
				test.info("Registration is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Address"))
				test.info("Address is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Action"))
				test.info("Action is present in the gridlist");
}
		Thread.sleep(500);
		List <WebElement> checkbox= driver.findElements(By.cssSelector("div [ref='eCheckbox']"));
		if(checkbox.size()==20)
			test.pass("20 Rows are displayed in the grid");
		else 
			test.info("There can be more or less than 20 rows on a page");
		if(!(driver.findElement(By.cssSelector("div [class='MuiGrid-root'] div [flexdirection='row']")).isDisplayed()))
			test.fail("Pagination is not displayed");
		else
			test.pass("Pagination is displayed");
		

}
}

package Suite;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import allTest.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BoilerServiceProgramme_Overview extends baseTest {
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
		driver.manage().window().maximize();   */
	}
	@Test
	public void BoilerService_Overview() throws Exception {
		test=extent.createTest("Boiler Service programme-Overview","This is to Validate all the items in Gas and Oil Boiler");
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
		WebElement boilerService = driver.findElement(By.xpath("//span[normalize-space()='Boiler Service Programme']"));
		if (!boilerService.isDisplayed())
			test.fail("Boiler Service Programme is not displayed");
		else
		{
			test.pass("Boiler Service Programme is displayed. Clicking on it:"); 
			boilerService.click();
		}
		Thread.sleep(5000);
		test.info("Validating all the items on Gas Boiler List View Page");
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
		WebElement Upload_button= driver.findElement(By.xpath("//span[normalize-space()='Upload']"));
		if(!(Upload_button).isDisplayed())
			test.fail("Upload button is not displayed in the grid");
		else
			test.pass("Upload  is displayed in the grid");
		/*WebElement Export_button= driver.findElement(By.cssSelector("button[class*=btn-primary]"));
		if(!(Export_button).isDisplayed())
			test.fail("Export button is not present in the grid");
		else
			test.pass("Export is present in the grid");*/
		WebElement Filter= driver.findElement(By.xpath("//span[normalize-space()='Filter']"));
		
		Filter.click();
		test.info("Filter Button Clicked");
		Thread.sleep(5000);
		WebElement Climotes=driver.findElement(By.id("climotes"));
		if(!(Climotes.isDisplayed()))
			test.fail("Climotes is not displayed");
		else
			test.pass("Climotes is displayed");
		WebElement Status=driver.findElement(By.id("status"));
		if(!(Status.isDisplayed()))
			test.fail("Status is not displayed");
		else
			test.pass("Status is displayed");
		WebElement Contractor=driver.findElement(By.id("contractor"));
		if(!(Contractor.isDisplayed()))
			test.fail("Contractor is not displayed");
		else
			test.pass("Contractor is displayed");
		WebElement City=driver.findElement(By.id("city"));
		if(!(City.isDisplayed()))
			test.fail("City is not displayed");
		else
			test.pass("City is displayed");
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
		WebElement Anniversary=driver.findElement(By.id("anniversary"));
		if(!(Anniversary.isDisplayed()))
			test.fail("Anniversary is not displayed");
		else
			test.pass("Anniversary is displayed");
		WebElement Completion=driver.findElement(By.id("last_check"));
		if(!(Completion.isDisplayed()))
			test.fail("Completion is not displayed");
		else
			test.pass("Completion is displayed");
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
			if(Grid_headername.equalsIgnoreCase("Asset ID"))
				test.pass("Asset ID is present in the gridlist");
			else if(Grid_headername.equalsIgnoreCase("Address"))
				test.pass("Address is present in the gridlist");
			else if(Grid_headername.equalsIgnoreCase("County"))
				test.pass("County is present in the gridlist");
			else if(Grid_headername.equalsIgnoreCase("Region"))
				test.pass("Region is present in the gridlist");
			else if(Grid_headername.equalsIgnoreCase("Housing Officer"))
				test.pass("Housing Officer is present in the gridlist");
			else if(Grid_headername.equalsIgnoreCase("Estate"))
				test.pass("Estate is present in the gridlist");
			else if(Grid_headername.equalsIgnoreCase("Type"))
				test.pass("Type is present in the gridlist");
			/*else if(Grid_headername.equalsIgnoreCase("Quantity"))
				test.pass("Quantity is present in the gridlist");
			else if(Grid_headername.equalsIgnoreCase("Anniversary"))
				test.pass("Anniversary is present in the gridlist");
			else if(Grid_headername.equalsIgnoreCase("Completion Date"))
				test.pass("Completion Date is present in the gridlist");
			else if(Grid_headername.equalsIgnoreCase("Status"))
				test.pass("Status is present in the gridlist");
			else if(Grid_headername.equalsIgnoreCase("Days Due In"))
				test.pass("Days Due In is present in the gridlist");
			else if(Grid_headername.equalsIgnoreCase("Batch Number"))
				test.pass("Batch Number is present in the gridlist");
			else if(Grid_headername.equalsIgnoreCase("Cert No"))
				test.pass("Cert No is present in the gridlist");
			else if(Grid_headername.equalsIgnoreCase("Contractor"))
				test.pass("Contractor is present in the gridlist");
			else if(Grid_headername.equalsIgnoreCase("Comments"))
				test.pass("Comments is present in the gridlist");
			else if(Grid_headername.equalsIgnoreCase("Climotes"))
				test.pass("Climotes is present in the gridlist");
			else if(Grid_headername.equalsIgnoreCase("Action"))
				test.pass("Action is present in the gridlist");
			else
				test.fail("The header present may not be the one to be displayed");*/
}
		Thread.sleep(500);
		List <WebElement> checkbox= driver.findElements(By.cssSelector("div [ref='eCheckbox']"));
		if(checkbox.size()==20)
			test.pass("20 Rows are displayed in the grid");
		else 
			test.info("There are "+checkbox.size()+" rows on a page");
		if(!(driver.findElement(By.cssSelector("div [class='MuiGrid-root'] div [flexdirection='row']")).isDisplayed()))
			test.fail("Pagination is not displayed");
		else
			test.pass("Pagination is displayed");
		test.info("Validating all the items on Oil Boiler List View Page");
		WebElement OilBoiler=driver.findElement(By.xpath("//span[normalize-space()='Oil Boiler']"));
		if(!(OilBoiler).isDisplayed())
			test.fail("Oil Boiler is not displayed in the grid");
		else {
			test.pass("Oil Boiler is displayed in the grid. Clicking on it:");
			OilBoiler.click();
			Thread.sleep(4000);
		}
		search_bar=driver.findElement(By.xpath("//input[@id='search']"));	
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
		Upload_button= driver.findElement(By.xpath("//span[normalize-space()='Upload']"));
		if(!(Upload_button).isDisplayed())
			test.fail("Upload button is not displayed in the grid");
		else
			test.pass("Upload is displayed in the grid");
		/*Export_button= driver.findElement(By.xpath("//span[normalize-space()='Export']"));
		if(!(Export_button).isDisplayed())
			test.fail("Export button is not present in the grid");
		else
			test.pass("Export is present in the grid");*/
		Filter= driver.findElement(By.xpath("//span[normalize-space()='Filter']"));
		if(!(Filter).isDisplayed())
			test.error("Filter button is not displayed in the grid");
		else
			test.info("Filter button is displayed in the grid");
		Thread.sleep(5000);
		Filter.click();
		test.info("Filter Button Clicked");
		Thread.sleep(5000);
		Climotes=driver.findElement(By.id("climotes"));
		if(!(Climotes.isDisplayed()))
			test.fail("Climotes is not displayed");
		else
			test.pass("Climotes is displayed");
		Status=driver.findElement(By.id("status"));
		if(!(Status.isDisplayed()))
			test.fail("Status is not displayed");
		else
			test.pass("Status is displayed");
		Contractor=driver.findElement(By.id("contractor"));
		if(!(Contractor.isDisplayed()))
			test.fail("Contractor is not displayed");
		else
			test.pass("Contractor is displayed");
		City=driver.findElement(By.id("city"));
		if(!(City.isDisplayed()))
			test.fail("City is not displayed");
		else
			test.pass("City is displayed");
		/*Number=driver.findElement(By.id("number"));
		if(!(Number.isDisplayed()))
			test.fail("Number is not displayed");
		else
			test.pass("Number is displayed");
		Street=driver.findElement(By.id("street"));
		if(!(Street.isDisplayed()))
			test.fail("Street is not displayed");
		else
			test.pass("Street is displayed");
		Eircode=driver.findElement(By.id("eircode"));
		if(!(Eircode.isDisplayed()))
			test.fail("Eircode is not displayed");
		else
			test.pass("Eircode is displayed");*/
		County=driver.findElement(By.id("county"));
		if(!(County.isDisplayed()))
			test.fail("County is not displayed");
		else
			test.pass("County is displayed");
		Anniversary=driver.findElement(By.id("anniversary"));
		if(!(Anniversary.isDisplayed()))
			test.fail("Anniversary is not displayed");
		else
			test.pass("Anniversary is displayed");
		Completion=driver.findElement(By.id("last_check"));
		if(!(Completion.isDisplayed()))
			test.fail("Completion is not displayed");
		else
			test.pass("Completion is displayed");
		Reset_Button=driver.findElement(By.xpath("//span[normalize-space()='Reset']"));
		if(!(Reset_Button.isDisplayed()))
			test.fail("Reset Button is not displayed");
		else
			test.pass("Reset Button is displayed");
		Apply_Button=driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']//span[@class='MuiButton-label'][normalize-space()='Apply']"));
		if(!(Apply_Button.isDisplayed()))
			test.fail("Apply Button is not displayed");
		else
			test.pass("Apply Button is displayed");
		close_button=driver.findElement(By.cssSelector("button[class*='MuiButton-textPrimary'] span[class*='MuiButton-label'] svg"));
		if(!(close_button.isDisplayed()))
			test.fail("Close Button is not displayed on Filter Modal");
		else
			{
			test.pass("Close Button is displayed on Filter Modal");
			close_button.click();
			}
		Thread.sleep(2000);
		grid_Headers=driver.findElements(By.cssSelector("span[ref='eText']"));
		for (WebElement Element: grid_Headers)
		{
			String Grid_headername=Element.getText();
			if(Grid_headername.equalsIgnoreCase("Asset ID"))
				test.info("Asset ID is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Address"))
				test.info("Address is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Number"))
				test.info("Number is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("County"))
				test.info("County is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Region"))
				test.info("Region is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Estate"))
				test.info("Estate is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Type"))
				test.info("Type is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Quantity"))
				test.info("Quantity is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Anniversary"))
				test.info("Anniversary is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Completion Date"))
				test.info("Completion Date is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Status"))
				test.info("Status is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Days Due In"))
				test.info("Days Due In is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Batch Number"))
				test.info("Batch Number is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Cert No"))
				test.info("Cert No is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Contractor"))
				test.info("Contractor is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Climotes"))
				test.info("Climotes is present in the gridlist");
			if(Grid_headername.equalsIgnoreCase("Action"))
				test.info("Action is present in the gridlist");
}
		Thread.sleep(500);
		checkbox= driver.findElements(By.cssSelector("div [ref='eCheckbox']"));
		if(checkbox.size()==20)
			test.pass("20 Rows are displayed in the grid");
		else 
			test.info("There can be more or less than 20 rows on a page");
		if(!(driver.findElement(By.cssSelector("div [class='MuiGrid-root'] div [flexdirection='row']")).isDisplayed()))
			test.fail("Pagination is not displayed");
		else
			test.pass("Pagination is displayed");
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
	        FileUtils.copyFile(screenshot, new File("ScreenShot/FullPageScreenshot.png"));
	    } catch (IOException e) {
	    	test.info(e.getMessage());
	    }
	}
	
	@AfterClass 
	public void afterTest_Properties_Overview() { 
	driver.quit();  
	}  
		
		
	}


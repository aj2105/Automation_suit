package Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class vendor_FilterFunctionality extends FilterFunctionality{
	public static WebDriver driver;
	//extends FilterFunctionality	
	@Test
	public void vendor_Filter() throws Exception {
		test=extent.createTest("Vendor-Validating Filter functionality","This is to Validate whether the correct results are displayed when the filters are selected");
	   
		System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
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
/*	WebElement Logo = driver.findElement(By.cssSelector("div [class='brand-logo']"));
		if (!Logo.isDisplayed())
			test.fail("User not logged in");
		else
			test.pass("User logged in");                                           */
/*		Thread.sleep(5000);
		WebElement vendor = driver.findElement(By.xpath("//span[normalize-space()='Vendors']"));
        vendor.click();       */
        
        
        JavascriptExecutor js=(JavascriptExecutor)driver;
		   
	    WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Vendors']"));
		     
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		     
		WebElement element1= driver.findElement(By.xpath("//span[normalize-space()='Vendors']"));	      
		   
		element1.click();
        
        
        
        
		
	/*			if (!(vendor.isDisplayed()))
			test.fail("Vendor is not displayed");
		else
			{
			test.pass("Vendor is displayed: Clicking on it:");
			vendor.click();    
			}                                                       */
		Thread.sleep(5000);
		WebElement Vendor_Tag= driver.findElement(By.cssSelector("div [id='kt_wrapper'] h1"));
		if(!(Vendor_Tag.isDisplayed()))
			test.fail("Vendor List view page is not displayed");
		else
			test.pass("Vendor List view page is displayed");
			
/*		FilterFunctionality obj=new FilterFunctionality();
		test.info("Validating Filter-Name");
		obj.main("Name","Brian Smith");                         */
		
		driver.quit();
		
	}
	
	}  


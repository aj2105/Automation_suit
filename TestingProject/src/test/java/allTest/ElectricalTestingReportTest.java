package allTest;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ElectricalTestingReportTest extends baseTest{
	
public static WebDriver driver;
@BeforeMethod
public void setUp1()
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
	
/*	System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
	WebDriver driver= new ChromeDriver();  */
	
	
}
 
    @Test
	public void setUp() throws InterruptedException {
    	
    	test= extent.createTest("Electrical_Testing_report_overview_Page");
    	
    	test.info("Validation of Electrical_Testing_report");
    	
    //	System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
	//	WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(7000));
    	
        driver.get("https://www.ips2-qa.bynaric.net/auth/login");

        String expectedURL = "https://www.ips2-qa.bynaric.net/auth/login";
      		String actualURL = driver.getCurrentUrl();
      		
      		
      		
      		if(actualURL.equalsIgnoreCase(expectedURL))
      			test.pass("correct url match");
      		else
      			test.fail("wrong url match found "); 
      		
        
		
		WebElement userid= driver.findElement(By.id("email"));
		userid.sendKeys("admin@bynaric.com");
		
		WebElement password= driver.findElement(By.id("password"));
		password.sendKeys("123456");
		
		WebElement login= driver.findElement(By.xpath("//span[@class='MuiButton-label']"));
		login.click();
		
		test.info("login successful");
		
	/*	
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Electrical Testing Reports']"));
	     
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		      
		WebElement element1= driver.findElement(By.xpath("//span[normalize-space()='Electrical Testing Reports']"));	      
		   
	    element1.click();
		
		
		
		
		WebElement ETR=driver.findElement(By.xpath("//span[normalize-space()='Electrical Testing Reports']"));
		ETR.click();
		
		System.out.println(driver.getCurrentUrl());  
	    
	    
	    test.info("Validitation of Electrical_ Testing_ Report");
		
		WebElement create= driver.findElement(By.xpath("//span[normalize-space()='Create']"));
		create.click();
		test.info("validating electrical testing report");
		
		WebElement reportType= driver.findElement(By.id("report_type"));
		reportType.sendKeys("Electrical Testing Report");
		
		WebElement date= driver.findElement(By.xpath("//input[@id='anniversary']"));
		date.click();
		
		//Thread.sleep(2000);
		
		
		test.info("Electrical testing file validation successful");      */
		
		//WebElement nextCheck= driver.findElement(By.xpath(""));
		//nextCheck.click();
		
		//System.out.println("Anniversary date & Last checkin date selected");
	
		driver.quit();
    }
    
}
	


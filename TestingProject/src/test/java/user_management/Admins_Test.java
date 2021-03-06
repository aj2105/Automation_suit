package user_management;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import allTest.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Admins_Test extends baseTest {
WebDriver driver;



@BeforeMethod

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
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(7000)); 
}

	
	@Test
	public  void Admins_overview_page() throws InterruptedException {
		
        test= extent.createTest("Admins_overview_Page");
		
		test.info("Validation of User Management");
	//	System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
	//  WebDriver driver= new ChromeDriver();
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    
        driver.get("https://www.ips2-qa.bynaric.net/auth/login");
		
		
	    
		String expectedURL = "https://www.ips2-qa.bynaric.net/auth/login";
	
		String actualURL = driver.getCurrentUrl();
		driver.getCurrentUrl();
		
		
		if(actualURL.equalsIgnoreCase(expectedURL))
			test.pass("correct url matched");
		else
			test.pass("wrong url do not match");
        
		test.info("Validation of User_Management");
		
		
		
		
		WebElement userid= driver.findElement(By.id("email"));
		userid.sendKeys("admin@bynaric.com");
		
		WebElement password= driver.findElement(By.id("password"));
		password.sendKeys("123456");
		
		WebElement login= driver.findElement(By.xpath("//span[@class='MuiButton-label']"));
		login.click();
		
		test.info("login successful");
		
		  
		JavascriptExecutor js=(JavascriptExecutor)driver;
		    
	      
          
		WebElement element = driver.findElement(By.xpath("//span[normalize-space()='User Management']"));
		     
		   
		      
	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		      
	    WebElement element1= driver.findElement(By.xpath("//span[normalize-space()='User Management']"));	      
		   
	    element1.click();
		    
	    WebElement element2= driver.findElement(By.xpath("//span[normalize-space()='Admins']"));	      
			   
		element2.click();
		    
        test.info("User management_Admin_Overview_page");
        
        WebElement element3= driver.findElement(By.xpath("//span[normalize-space()='Create']"));	      
		   
		element3.click();
		test.info("create button clicked");
		
	
		
		WebElement element4= driver.findElement(By.xpath("//input[@id='first_name']"));	      
		   
		element4.sendKeys("Test_First_Name");
		
		WebElement element5= driver.findElement(By.xpath("//input[@id='last_name']"));	      
		   
		element5.sendKeys("Test_Last Name");
		
		WebElement element6= driver.findElement(By.xpath("//input[@id='email']"));	      
		   
		element6.click();
		
		WebElement element7= driver.findElement(By.xpath("//span[normalize-space()='Save']"));	      
		   
		element7.click();
		
		
		Thread.sleep(2000);
		WebElement element8= driver.findElement(By.xpath("//button[normalize-space()='Ok']"));	      
		   
		element8.click();
		
		test.info("admin_ form page validated");
		
	    driver.quit();
	}
}

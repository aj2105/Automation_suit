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

public class Employees_Test extends baseTest{
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
	public  void Employees_Overview() throws InterruptedException {
		
        test= extent.createTest("User_Management_overview_Page");
		
		test.info("Validation of user_management");
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
		    
	    WebElement element2= driver.findElement(By.xpath("//span[normalize-space()='Employees']"));	      
			   
		element2.click();
		    
        test.info("User management_Employees_Overview_page");
	    Thread.sleep(3000);
	    WebElement element3=driver.findElement(By.xpath("//span[normalize-space()='Create']"));
	    element3.click();
        test.info("Employees Create button clicked");
        
        WebElement element4=driver.findElement(By.xpath("//input[@id='first_name']"));
        element4.sendKeys("Test_Name");
        
        WebElement element5=driver.findElement(By.xpath("//input[@id='last_name']"));
        element5.sendKeys("Test_Last_Name");
        
        WebElement element6=driver.findElement(By.xpath("//input[@id='email']"));
        element6.sendKeys("Test@Testmail.com");
        
        WebElement element7=driver.findElement(By.xpath("//input[@id='user_role']"));
        element7.click();
        
        WebElement element8=driver.findElement(By.xpath("//li[@id='user_role-option-6']"));
        element8.click();
        
        
        
       // WebElement element9=driver.findElement(By.xpath("//input[@id='joining_date']"));
       // element9.click();
        
        
      //  WebElement element10=driver.findElement(By.xpath("//li[normalize-space()='Active']"));
       
        
        // WebElement element11=driver.findElement(By.xpath("//li[normalize-space()='Active']"));
        // element11.click();
        
		
		driver.quit();
	    
	}
	

}

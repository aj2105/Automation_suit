package configuration;

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

public class Complience_Item extends baseTest{
public static WebDriver driver;
	


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
	public void ComplienceItem() throws InterruptedException {
		
		
		test= extent.createTest("Complience_item_status_overview_Page");
		
		test.info("Complience_item_status_overview");
		
	//	System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
	//	WebDriver  driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(7000));
		
		
		driver.get("https://www.ips2-qa.bynaric.net/auth/login");
		
		
	    String expectedURL = "https://www.ips2-qa.bynaric.net/auth/login";
		String actualURL = driver.getCurrentUrl();
		driver.getCurrentUrl();
		
		if(actualURL.equalsIgnoreCase(expectedURL))
			test.pass("correct url matched");
		else
			test.pass("wrong url do not match");
        
		test.info("Validation complience_item");
		

		WebElement userid= driver.findElement(By.id("email"));
		userid.sendKeys("admin@bynaric.com");
		
		WebElement password= driver.findElement(By.id("password"));
		password.sendKeys("123456");
		

		WebElement login= driver.findElement(By.xpath("//span[@class='MuiButton-label']"));
		login.click();
		
		test.info("login successful");
	      
	      
	    
		JavascriptExecutor js=(JavascriptExecutor)driver;
	    
	      
          
	    WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Configuration']"));
	     
	   
	      
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	      
	    WebElement element1= driver.findElement(By.xpath("//span[normalize-space()='Configuration']"));
	   
	    element1.click();
	    
	    Thread.sleep(2000);
	    WebElement element2 = driver.findElement(By.xpath("//a[@class='menu-link menu-toggle active']//span[@class='menu-text'][normalize-space()='Components']"));
	     
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
	    element2.click();	
	    
	    Thread.sleep(2000);
	    WebElement element3 = driver.findElement(By.xpath("//span[normalize-space()='Compliance Items']"));
	     
		   
	      
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
	    element3.click();	
	    
	    driver.findElement(By.xpath("//span[normalize-space()='Create']")).click();
	    driver.findElement(By.xpath("//input[@id='name']")).sendKeys("test_name");
	    
	    driver.findElement(By.xpath("//input[@id='component']")).click();
	    
	    driver.findElement(By.xpath("//span[normalize-space()='Save']")).click();
	    
	    test.info("Complience item page validation done");
	    
	driver.quit();
	
}
}

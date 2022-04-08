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

public class Repair_CodesTest extends baseTest{
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
	public void repairCode() throws InterruptedException {
		
		test= extent.createTest("Repair_code_overviewPage");
		test.info("Validation of Repair_code_overviewPage");
		
		
//	System.setProperty("webdriver.chrome.driver", "/Users/ajay.mishra/Documents/Driver/Chromedriver");
//	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
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
	
	 @SuppressWarnings("unused")
	JavascriptExecutor js=(JavascriptExecutor)driver;
	    
	    WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Configuration']"));
	     
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	      
	    WebElement element1= driver.findElement(By.xpath("//span[normalize-space()='Configuration']"));	      
	   
	    element1.click();
	    
	    WebElement element2=driver.findElement(By.xpath("//a[@class='menu-link menu-toggle active']//span[@class='menu-text'][normalize-space()='Repairs']"));
	    element2.click();
	    
	    WebElement element3=driver.findElement(By.xpath("//span[normalize-space()='Repair Codes']"));
	    
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
	   
	    element3.click(); 
	    
	    
	    WebElement Create= driver.findElement(By.xpath("//span[normalize-space()='Create']"));
	    Create.click();
	    
	    test.info("validation of repair code form completed");
	    
	   /* WebElement SurveyName= driver.findElement(By.xpath("//input[@id='name']"));
	    SurveyName.sendKeys("Test Survey");
	    
	    WebElement Format=driver.findElement(By.xpath("//input[@id='format']"));
	    Format.sendKeys("Component Survey");
	    
	    WebElement SurveyBy= driver.findElement(By.xpath("//input[@id='survey_by']"));
	
	    SurveyBy.click(); */
	    
	    driver.quit();
	    
	   }
	
}

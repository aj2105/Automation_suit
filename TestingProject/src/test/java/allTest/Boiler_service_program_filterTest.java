package allTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Boiler_service_program_filterTest extends baseTest{
	
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
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(77777));
					
		}
	
	 
	 ExtentReports Extent;
	 ExtentHtmlReporter htmlReporter;
		
	
		@Test
		public void search() throws InterruptedException {
			
			test= extent.createTest("filter_Page");
			test.info("Validation of filter_page");
			
			
		//	System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
		//	driver= new ChromeDriver();
			
			htmlReporter = new ExtentHtmlReporter("extent.html");



	        Extent=new ExtentReports();
	        Extent.attachReporter(htmlReporter);
			
			driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
			driver.manage().window().maximize();
			
			driver.get("https://www.ips2-qa.bynaric.net/auth/login");
			
			
			  String expectedURL = "https://www.ips2-qa.bynaric.net/auth/login";
			  String actualURL = driver.getCurrentUrl();
				
				
				if(actualURL.equalsIgnoreCase(expectedURL))
					test.pass("correct url match");
				else
					test.fail("wrong url match found "); 
				
			
			test.info("URL launched");
			
			WebElement userid= driver.findElement(By.id("email"));
			userid.sendKeys("admin@bynaric.com");
			System.out.println(driver.getCurrentUrl());
			
			WebElement password= driver.findElement(By.id("password"));
			password.sendKeys("123456");
			
			driver.findElement(By.xpath("//span[@class='MuiButton-label']")).click();
			
			test.info("login successful");
			
			WebElement BSP= driver.findElement(By.xpath("//span[normalize-space()='Boiler Service Programme']"));
			
			BSP.click();
	      
			WebElement Filter=driver.findElement(By.xpath("//span[normalize-space()='Filter']"));
			Filter.click();
			
			WebElement Climotes=driver.findElement(By.id("climotes"));
			Climotes.click();
			test.info("Boiler_service_program_Filter_test");
			driver.quit();
			
}
		
	
}

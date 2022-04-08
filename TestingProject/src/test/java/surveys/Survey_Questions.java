package surveys;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import allTest.baseTest;

public class Survey_Questions extends baseTest {
	
public static WebDriver driver;


	@BeforeMethod
	public void setUp()
	{
	/*	WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--headless");
		options.addArguments("--window-size=1920,1200");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(7000));    */
		
		System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
		WebDriver driver=new ChromeDriver();
		
	}

		@Test
		public void Survey_questions() throws InterruptedException {
			
			
			test= extent.createTest("Survey questions dashboard");
			
			test.info("unit of mesurment page");
			
			
				System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
				WebDriver driver=new ChromeDriver();
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
				
				 
				JavascriptExecutor js=(JavascriptExecutor)driver;
				   
			    WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Configuration']"));
				     
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				     
				WebElement element1= driver.findElement(By.xpath("//span[normalize-space()='Configuration']"));	      
				   
				element1.click();
				Thread.sleep(2000); 
				WebElement element2= driver.findElement(By.xpath("//a[@class='menu-link menu-toggle active']//span[@class='menu-text'][normalize-space()='Surveys']"));	      
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);  
				element2.click();
				test.info("survey questions selected");
				driver.findElement(By.xpath("//span[normalize-space()='Survey Questions']")).click();
				driver.findElement(By.cssSelector("div [name='right'] [class='MuiIconButton-label'] [class='MuiSvgIcon-root']")).click();
	           
				Thread.sleep(3000);
				driver.quit();
	

}}

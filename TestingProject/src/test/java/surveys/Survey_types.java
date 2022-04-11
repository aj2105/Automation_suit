package surveys;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import allTest.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Survey_types extends baseTest{
	
	
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
		
	//	System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
	//	WebDriver driver=new ChromeDriver();
		
	}

		@Test
		public void Survey_Type() throws InterruptedException {
			
			
			test= extent.createTest("Survey type dashboard");
			
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
				test.info("survey types selected");
				driver.findElement(By.xpath("//span[normalize-space()='Survey Types']")).click();
				
				
				
				driver.findElement(By.cssSelector("div [name='right'] [class='MuiIconButton-label'] [class='MuiSvgIcon-root']")).click();
				driver.findElement(By.xpath("//body/div[@role='presentation']/div[3]/ul[1]/li[1]")).click();
	            Thread.sleep(2000);
				driver.findElement(By.xpath("//span[normalize-space()='Edit']")).click();
				
				
			
			//	driver.findElement(By.xpath("//input[@id='name']")).sendKeys("New_survey");
				
			//	format-option-1
				Thread.sleep(1000);
			
				
				driver.findElement(By.xpath("//div[7]//label[1]//span[1]//span[1]//input[1]")).click();
			    Thread.sleep(300);
			    driver.findElement(By.xpath("//div[8]//label[1]//span[1]//span[1]//input[1]")).click();
			    Thread.sleep(300);
				driver.findElement(By.xpath("//div[9]//label[1]//span[1]//span[1]//input[1]")).click();
				Thread.sleep(300);
				driver.findElement(By.xpath("//div[10]//label[1]//span[1]//span[1]//input[1]")).click();
				Thread.sleep(300);
				driver.findElement(By.xpath("//div[11]//label[1]//span[1]//span[1]//input[1]")).click();
				Thread.sleep(300);
				driver.findElement(By.xpath("//div[12]//label[1]//span[1]//span[1]//input[1]")).click();
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[normalize-space()='Create']")).click();
				driver.findElement(By.xpath("//span[normalize-space()='Create']")).click();
				
				
				
				
			//	driver.findElement(By.xpath("//input[@id='format']")).sendKeys("Component Survey");
				
			//	Select dropdown = new Select(driver. findElement(By.xpath("//input[@id='format']"))); 
			//	dropdown.in("Component Survey");
				
		/*		Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='survey_by']")).sendKeys("Property");
				//Select se = new Select(driver.findElement(By.xpath("//input[@id='survey_by']")));
				//se.selectByIndex(1);
				driver.findElement(By.xpath("//input[@id='description']")).sendKeys("Test_description");
				
				test.info(" check box clicked");
				Thread.sleep(3000);
				//div[7]//label[1]//span[1]//span[1]//input[1]
				
				
			//	driver.findElement(By.xpath("//span[normalize-space()='Clear']")).click();     */
				
				
}}

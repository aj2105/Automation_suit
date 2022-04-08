package allTest;

import java.awt.AWTException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class vendors extends baseTest{
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
	public void dashboard() throws InterruptedException, AWTException {
		
		test= extent.createTest("vendors_page");
		test.info("Validation of vendors_page ");
		
		System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.ips2-qa.bynaric.net/auth/login");
		
		
		 String expectedURL = "https://www.ips2-qa.bynaric.net/auth/login";
			String actualURL = driver.getCurrentUrl();
			
			
			
			if(actualURL.equalsIgnoreCase(expectedURL))
				test.pass("correct url match");
			else
				test.fail("wrong url match found "); 
		
		
		
		
	    driver.findElement(By.id("email")).sendKeys("admin@bynaric.com");
	    driver.findElement(By.id("password")).sendKeys("123456");
	    driver.findElement(By.xpath("//span[@class='MuiButton-label']")).click();
	    
	    

	  //  driver.findElement(By.xpath("//span[normalize-space()='Vendors']")).click();
	    
	    
	    Thread.sleep(3000);
	    
		@SuppressWarnings("unused")
		JavascriptExecutor js=(JavascriptExecutor)driver;
	    
	      
          
	    WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Vendors']"));
	     
	   
	      
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	      
	    WebElement element1= driver.findElement(By.xpath("//span[normalize-space()='Vendors']"));	      
	   
	    element1.click();
	    
	    test.info("vandors page validation");
	    
	    driver.findElement(By.xpath("//span[normalize-space()='Create']")).click();
	    
	    test.info("Vendors create button clicked");
	    
	    driver.findElement(By.id("business_name")).sendKeys("Test");
	    driver.findElement(By.id("registration_number")).sendKeys("new Resgisteration");
	    
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@id='county']")).click();
	    
	    driver.findElement(By.xpath("//input[@id='street']")).sendKeys("north circular road");
	    
	    driver.findElement(By.xpath("//input[@id='eircode']")).sendKeys("DX11Test01");
	    
	  //  driver.findElement(By.xpath("//span[normalize-space()='Select File']")).click();
	    
	    driver.findElement(By.xpath("//span[normalize-space()='Contacts']")).click();
	    
	  //  test.info("vendors form validation completed");
	    
	    
	    
	    
	    driver.findElement(By.xpath("//input[@id='business_name']")).sendKeys("Test_contact");
	   
	    
	    driver.findElement(By.id("registration_number")).sendKeys("Registeration_test");
	    driver.findElement(By.id("vendor_type")).click();
	    
	    Thread.sleep(2000);
	    driver.findElement(By.id("vendor_category")).click();
	    driver.findElement(By.id("number")).sendKeys("12345678");
	    
	    Thread.sleep(2000);
	    driver.findElement(By.id("street")).sendKeys("Test_street");
	    
	    
	    test.info("Vendors contact tab clicked");
	    
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[normalize-space()='Create']")).click();
	    
	    driver.findElement(By.id("first_name")).sendKeys("TestName");
	    driver.findElement(By.id("last_name")).sendKeys("TestLastName");
	    
	    Thread.sleep(2000);
	    driver.findElement(By.id("email")).sendKeys("Test@email.com");
	    driver.findElement(By.id("phone")).sendKeys("12345678");
	    
	    
	    test.info("Vendors create contact form validation");
	    
	    
	    
	   // driver.findElement(By.xpath("//span[normalize-space()='Select File']")).click();
	    
	    
	    
	  /*driver.findElement(By.xpath("//span[normalize-space()='Select File']")).click();*/

	   // Thread.sleep(2000);
	    
	  //a[normalize-space()='Download CSV Template']
	    
	   // WebElement file =  driver.findElement(By.xpath("a[normalize-space()='Download CSV Template']"));
    	//file.click();
	   
	    	//WebElement file =  driver.findElement(By.xpath("//span[normalize-space()='Select File']"));
	    	//file.click();
	    	
	    	//link text locator for uploading a photo..
	    	//WebElement addFile = driver.findElement(By.linkText("Upload a photo..."));
	    			//addFile.click();
	    	// Mention the own path of the file location

	    	// Add file method 
	    	//file.sendKeys("Users/ajay.mishra/Downloads/Boiler Service Program_20_01_2022, 17_29_40.csv");

	    	/*driver.findElement(By.linkText("Set new profile picture")).click();
	    	Thread.sleep(2000);

	    	if(driver.findElement(By.xpath(".//a[text()='caps.jpeg']")).isDisplayed()) {
	    	assertTrue(true, "Upload");
	    	}else {
	    	assertTrue(false, "Upload");
	    	}
	    	}*/
	    	

	    
	    
	    
	    

	    //File Need to be imported
	    //Users/ajay.mishra/
	  /* File file = new File("Users/ajay.mishra/Downloads/Boiler Service Program_20_01_2022, 17_29_40.csv");

	    StringSelection stringSelection= new StringSelection(file.getAbsolutePath());

	    //Copy to clipboard Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	    Robot robot = new Robot();
        System.out.println("Robot keyboard event Initiated");
	    // Cmd + Tab is needed since it launches a Java app and the browser looses focus

	    robot.keyPress(KeyEvent.VK_META);

	    robot.keyPress(KeyEvent.VK_TAB);

	    robot.keyRelease(KeyEvent.VK_META);

	    robot.keyRelease(KeyEvent.VK_TAB);

	    robot.delay(1000);

	    //Open Goto window

	    robot.keyPress(KeyEvent.VK_META);

	    robot.keyPress(KeyEvent.VK_SHIFT);

	    robot.keyPress(KeyEvent.VK_G);

	    robot.keyRelease(KeyEvent.VK_META);

	    robot.keyRelease(KeyEvent.VK_SHIFT);

	    robot.keyRelease(KeyEvent.VK_G);

	    //Paste the clipboard value

	    robot.keyPress(KeyEvent.VK_META);

	    robot.keyPress(KeyEvent.VK_V);

	    robot.keyRelease(KeyEvent.VK_META);

	    robot.keyRelease(KeyEvent.VK_V);

	    //Press Enter key to close the Goto window and Upload window

	    robot.keyPress(KeyEvent.VK_ENTER);

	    robot.keyRelease(KeyEvent.VK_ENTER);

	    robot.delay(1100);

	    robot.keyPress(KeyEvent.VK_ENTER);

	    robot.keyRelease(KeyEvent.VK_ENTER);

      System.out.println("File upload Action");
      System.out.println(driver.getCurrentUrl());*/
	    
	    
 //   driver.quit();
	    
	}
	
	
}
	
	  
		   
		   
		   
		   

		
		
	



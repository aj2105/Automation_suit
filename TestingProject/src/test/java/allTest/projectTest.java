package allTest;

import java.awt.AWTException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class projectTest extends baseTest {
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
	public void ips() throws InterruptedException, AWTException {
		
		test= extent.createTest("projectTest_page");
		
		test.info("Validation of projectTest");
		
	
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
			
	
	    driver.findElement(By.id("email")).sendKeys("admin@bynaric.com");
	    driver.findElement(By.id("password")).sendKeys("123456");
	    
	   
	    driver.findElement(By.xpath("//span[@class='MuiButton-label']")).click();
		test.info("URL successful");
	   
	    driver.findElement(By.xpath("//span[normalize-space()='Boiler Service Programme']")).click();
 
	//driver.findElement(By.cssSelector("div [ref='eCheckbox']")).click();
	//driver.findElement(By.xpath("//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained .btn-primary MuiButton-containedPrimary')]")).click();
	
	
	    driver.findElement(By.xpath("//span[normalize-space()='Upload']")).click();
	
	
      //  driver.findElement(By.xpath("//div[contains(@class,'MuiDropzoneArea-textContainer')]//*[name()='svg']")).click();

	



/*//Copy to clipboard Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

Robot robot = new Robot();

// Cmd + Tab is needed since it launches a Java app and the browser looses focus

robot.keyPress(KeyEvent.VK_META);

robot.keyPress(KeyEvent.VK_TAB);

robot.keyRelease(KeyEvent.VK_META);

robot.keyRelease(KeyEvent.VK_TAB);

robot.delay(500);

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

robot.delay(500);

robot.keyPress(KeyEvent.VK_ENTER);

robot.keyRelease(KeyEvent.VK_ENTER);
//System.out.println("file upload successful");
System.out.println(driver.getCurrentUrl());     */

//String fileInput = "/Users/ajay.mishra/Downloads/Boiler Service Program_12_01_2022, 09_06_14.csv";


//WebElement choseFile = driver.findElement(By.name("uploadfile"));
//choseFile.sendKeys(fileInput);



//driver.findElement(By.className("import­button")).click();

//Thread.sleep(2000);

//File Need to be imported



	
   // driver.findElement(by.)			
		//Thread.sleep(3000);
	//driver.close();   */

        driver.quit();
        
	}
	
}


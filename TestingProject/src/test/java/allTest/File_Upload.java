package allTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class File_Upload extends baseTest {
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
			public void search() throws InterruptedException, AWTException {
				
				test= extent.createTest("search_functionality_Test");
				
				test.info("Validation of search_functionality_Test");
				
				
	//			System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
	//			WebDriver driver= new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(7000));
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
				
				WebElement password= driver.findElement(By.id("password"));
				password.sendKeys("123456");
				
				driver.findElement(By.xpath("//span[@class='MuiButton-label']")).click();
				
				test.info("login successful");
				
				driver.findElement(By.xpath("//span[normalize-space()='Boiler Service Programme']")).click();
				
				driver.findElement(By.xpath("//span[normalize-space()='Upload']")).click();
				 
               
				
                Actions act = new Actions(driver);
				
				WebElement chooseFile = driver.findElement(By.xpath("//div[contains(@class,'MuiDropzoneArea-textContainer')]//*[name()='svg']"));
				act.moveToElement(chooseFile).perform();
				
		//		chooseFile.sendKeys("/Users/ajay.mishra/Downloads/template_boiler_gas_service_05_04_2022, 12_35_52.csv");  
				
				

                //File Need to be imported

                 File file = new File("/Users/ajay.mishra/Downloads");

                 StringSelection stringSelection= new StringSelection(file.getAbsolutePath());

                 //Copy to clipboard Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

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
				
	
				
	 		   
				
				
	/*		driver.findElement(By.xpath("//div[contains(@class,'MuiDropzoneArea-textContainer')]//*[name()='svg']")).click();
				
			
			driver.findElement(By.xpath("//span[normalize-space()='Upload']")).click();
			
				Actions act = new Actions(driver);
				
				WebElement chooseFile = driver.findElement(By.xpath("//div[contains(@class,'MuiDropzoneArea-textContainer')]//*[name()='svg']"));
				act.moveToElement(chooseFile).perform();
				
				chooseFile.sendKeys("/Users/ajay.mishra/Downloads/template_boiler_gas_service_05_04_2022, 12_35_52.csv");      */
				
				

               //click on the Import Button
 
				

}
	}

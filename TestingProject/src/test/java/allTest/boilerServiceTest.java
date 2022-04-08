package allTest;

import java.awt.AWTException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class boilerServiceTest extends baseTest{
	
	
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
		
		test= extent.createTest("Boiler_service_program_overview_Page");
		test.info("Validation of Boiler_service_program");
		
		
		
		//System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
		//WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(7000));
		driver.manage().window().maximize();
		
		driver.get("https://www.ips2-qa.bynaric.net/auth/login");
		
		WebElement userid= driver.findElement(By.id("email"));
		userid.sendKeys("admin@bynaric.com");
		
		WebElement password= driver.findElement(By.id("password"));
		password.sendKeys("123456");
		
		
		driver.findElement(By.xpath("//span[@class='MuiButton-label']")).click();
		
	/*	test.info("Username and Password entered");
		
		WebElement button=driver.findElement(By.xpath("//span[@class='MuiButton-label']"));
		button.click();
		
		
		if (!button.isDisplayed())
			test.error("Button not clicked");
		else
			test.info("Button clicked"); */
		

	    String expectedURL = "https://www.ips2-qa.bynaric.net/auth/login";
		String actualURL = driver.getCurrentUrl();
		
		
		
		if(actualURL.contains(expectedURL))
			test.pass("correct url match");
		else
			test.fail("wrong url match found "); 
		
		test.info("validating URL");
		
		
	    System.out.println(driver.getCurrentUrl());
		   
		WebElement BSP=driver.findElement(By.xpath("//span[normalize-space()='Boiler Service Programme']"));
		BSP.click();
		
		
		if (!BSP.isDisplayed())
			test.error("Boiler service program not clicked");
		else
			test.info("Boiler service program clicked");  
	
		WebElement checkbox=driver.findElement(By.cssSelector("div [ref='eCheckbox']"));
		checkbox.click();
		
   /*     Thread.sleep(2000);
		WebElement select = driver.findElement(By.xpath("//div[@aria-label='Press SPACE to deselect this row.']//span[@class='MuiIconButton-label']//*[name()='svg']//*[name()='path' and contains(@d,'M6 10c-1.1')]"));
		select.click();
		*/
		
		
		WebElement upload=driver.findElement(By.xpath("//span[normalize-space()='Upload']"));
		upload.click();
		test.info("validating Upload action");
	/*	
		
	    WebElement csvUpload= driver.findElement(By.xpath("//div[contains(@class,'MuiDropzoneArea-textContainer')]//*[name()='svg']"));
	    csvUpload.click();
        
	    System.out.println("csv upload clicked");
        test.info("File upload button clicked");     */
	


	
/*
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
	System.out.println("file upload successful"); 
	    
	    //driver.quit();  */
 
	
		driver.quit();
		
	}
	
}

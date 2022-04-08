package allTest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class searchFunctionTest extends baseTest {
WebDriver driver;


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
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(7000));  */
}



	@Test
	public void search() throws InterruptedException {
		
		test= extent.createTest("search_functionality_Test");
		
		test.info("Validation of search_functionality_Test");
		
		
		System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
		WebDriver driver= new ChromeDriver();
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
		
		WebElement BSP= driver.findElement(By.xpath("//span[normalize-space()='Boiler Service Programme']"));
		
		BSP.click();
		
		Thread.sleep(4000);
		
		//driver.findElement(By.xpath("//button[@aria-label='more']//span[@class='MuiIconButton-label']//*[name()='svg']")).click();
		
		
		WebElement checkbox=driver.findElement(By.cssSelector("div[class*='MuiBox-root jss'] span[class='MuiIconButton-label'] path[d*='M6 10c-1.1']"));
		checkbox.click(); 
		
		
		test.info("Check box clicked");
		
		//System.out.println("select all button clicked");
	/*    Thread.sleep(3000);
		WebElement checkbox1 =driver.findElement(By.xpath("//li[normalize-space()='Select All']"));
		checkbox1.click();
	    test.info("Check_box_clicked");
		
		System.out.println(driver.getCurrentUrl());    */
		 
		
		
		/*List<WebElement> results = driver.findElements(By.xpath("//li[normalize-space()='Select All']"));
		for (WebElement result : results){
		     List<WebElement> boxes = result.findElements(By.xpath("//li[normalize-space()='Select All']"));
		    // int numberOfBoxes =  boxes.length();*/
		
	
		
			
	
	
	
		
		
	/*	
		WebElement search2=driver.findElement(By.id("search"));
		search2.sendKeys("420");
		
		System.out.println("clicked on search bar");
		
		WebElement search3=driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3']//div[@class='MuiGrid-root MuiGrid-item']"));
	    search3.click();
		
		WebElement checkbox2=driver.findElement(By.xpath("//body/div[@role='presentation']/div[3]/ul[1]/li[2]"));
		checkbox2.click();
		
		driver.findElement(By.xpath("//span[normalize-space()='Filter']")).click();
		driver.findElement(By.id("climotes")).click();
		
		System.out.println("Climotes selected");    */
		
		driver.quit();	
	
	}

}
		



package Suite;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import allTest.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class block_Tab extends baseTest {
	public static WebDriver driver;
	private static final org.apache.logging.log4j.Logger Log = LogManager.getLogger(schemes_Tab.class);
	@BeforeClass
	public void setUp_block_Tab()
	{
    	WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--headless");
		options.addArguments("--window-size=1920,1200");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);     
	/*	System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();   */
		
	}
	@Test
	public void testeasy_block_tab() throws InterruptedException {
		test=extent.createTest("Block Tab Validation","This script is to validate all the items present in the different tab for Block item.");
		driver.get("https://www.ips2-qa.bynaric.net/");
		Thread.sleep(5000);
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		email.sendKeys("admin@bynaric.com");
		test.info("UserName Entered: admin@bynaric.com");
		password.sendKeys("123456");
		test.info("Password Entered: 123456");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div [class='MuiButton-label']")).click();
		Thread.sleep(5000);
		test.info("Sign in button is clicked");
		WebElement Logo = driver.findElement(By.cssSelector("div [class='brand-logo']"));
		if (!Logo.isDisplayed())
			test.fail("User not logged in");
		else
			test.pass("User logged in"); 
		Thread.sleep(500);
		WebElement AssetManagement = driver.findElement(By.xpath("//span[normalize-space()='Asset Management']"));
		if (!AssetManagement.isDisplayed())
			test.fail("Asset Management not displayed");
		else
			{
			test.pass("Asset Management is displayed. Clicking on it to see the sub-items"); 
			AssetManagement.click();
			}
		Thread.sleep(3000);
		WebElement blocks = driver.findElement(By.xpath("//span[normalize-space()='Blocks']"));
		if (!blocks.isDisplayed())
			test.fail("Blocks not displayed");
		else
			{
			test.pass("Blocks is displayed. Clicking on it."); 
			blocks.click();
			}
		Thread.sleep(5000);
		if (!(driver.findElement(By.cssSelector("div [id=\"kt_wrapper\"] h1"))).isDisplayed())
			test.fail("Blocks List page is not displayed");
		else
			test.pass("Blocks List page is displayed");
		Thread.sleep(5000);
		test.info("Selecting the first Item in grid and Clicking on View from the action items on the right");
		driver.findElement(By.cssSelector("div [name='right'] [class='MuiIconButton-label'] [class='MuiSvgIcon-root']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@role='presentation']/div[3]/ul[1]/li[1]")).click();
		Thread.sleep(6000);
		Log.info("Validating the lables present on overview tab");
		List <WebElement> labels=driver.findElements(By.cssSelector("div[aria-hidden='false'] div[class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3'] label[data-shrink='true']"));
		for(int i=0; i<labels.size(); i++)
		{
			try{
				test.pass("The label present under Block Overview are "+ labels.get(i).getText());
			     break;
			  }
			  catch(Exception e){
				  test.info(e.getMessage());
			  }
		}
		WebElement Information_tab= driver.findElement(By.cssSelector("div [role='tablist'] button[id*='1']"));
		if(!(Information_tab.isDisplayed()))
			test.fail("The Information tab is not displayed");
		else
			{
			test.pass("The Information tab is displayed");
			Information_tab.click();
			}
		Thread.sleep(5000);
		WebElement block_details=driver.findElement(By.xpath("//h6[normalize-space()='Block Details']"));
		if(!(block_details.isDisplayed()))
			test.fail("The Block details is not displayed");
		else
			test.pass("The Block Details is displayed");
		WebElement Properties_details=driver.findElement(By.xpath("//h6[normalize-space()='Properties']"));
		if(!(Properties_details.isDisplayed()))
			test.fail("The Properties list is not displayed");
		else
			test.pass("The Properties list is displayed");
		test.info("Validating Component tab");
		WebElement Component_tab= driver.findElement(By.cssSelector("div [role='tablist'] button[id*='2']"));
		if(!(Component_tab.isDisplayed()))
			test.fail("The Asset Component tab is not displayed");
		else
			{
			test.pass("The Asset Component tab is displayed");
			Component_tab.click();
			}
		Thread.sleep(5000);
		/*WebElement Create_Button=driver.findElement(By.cssSelector("div[class*='MuiBox-root jss9157'] span[class='MuiButton-label']"));
		if(!(Create_Button.isDisplayed()))
			System.out.println("The Create Component Button is not displayed");
		else
			System.out.println("The Create Component Button is displayed");*/
		List <WebElement> Component_header=driver.findElements(By.cssSelector("div [aria-hidden='false'] div [ref='eHeaderViewport'] div[ref='eLabel'] span[ref='eText']"));
		test.info("The columns in the table under Asset Component Tab are:");
		for(int i=0;i<Component_header.size();i++)
			test.pass(Component_header.get(i).getText());
		
	}
	@AfterTest  
	public void afterTest_block_Tab() { 
	driver.quit();  
	}   
}

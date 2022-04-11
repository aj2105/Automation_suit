package Suite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import allTest.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FilterFunctionality extends baseTest {
	public static WebDriver driver;
	
	static WebElement Filter_Button;
	static WebElement Apply_Button;
	static WebElement Scheme_Filter;
	static WebElement County_Filter;
	static WebElement City_Filter;
	static WebElement Eircode_Filter;
	static WebElement BuildDate_Filter;
	static WebElement Asset_Filter;
	static WebElement Reset_Button;
	static WebElement Cancel_Button;
	static WebElement Street_Filter;
	static WebElement Block_Filter;
	static WebElement Number_Filter; 
	static WebElement Anniversary_Filter;
	static WebElement Completion_Filter;
	static WebElement Name_Filter;         
	Actions actions;
	JavascriptExecutor jse;
    @BeforeTest
	public void setUp() throws InterruptedException
	{
	WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--headless");
		options.addArguments("--window-size=1920,1200");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);      
    /*	System.setProperty("webdriver.chrome.driver","/Users/ajay.mishra/Documents/Driver/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();   */
		
		
		driver.get("https://www.ips2-qa.bynaric.net/");
		Thread.sleep(5000);
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		email.sendKeys("admin@bynaric.com");
		//test.info("UserName Entered: admin@bynaric.com");
		password.sendKeys("123456");
	//	test.info("Password Entered: 123456");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='MuiButton-label']")).click();
		//Thread.sleep(5000);
	//	test.info("Sign in button is clicked");
    	
    	
		
		
		
		
	}
    
    public void filter(String FilterName, String FilterValue) throws InterruptedException {
    
//	public void main(String FilterName, String FilterValue) throws Exception {
		// TODO Auto-generated method stub
		        
		
		

		
    	
    	
    	
		
		
		
		Thread.sleep(4000);
		Filter_Button= driver.findElement(By.xpath("//span[normalize-space()='Filter']"));
		Apply_Button=driver.findElement(By.xpath("//button[contains(@class,'MuiButton-containedPrimary')][normalize-space()='Apply']"));
		Reset_Button=driver.findElement(By.xpath("//button[contains(@class,'MuiButton-containedPrimary')][normalize-space()='Reset']"));
		Cancel_Button=driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary']//span[@class='MuiButton-label']"));
		int i;
		if(!(Filter_Button).isDisplayed())
			test.fail("Filter button is not present in the grid");
		else
			test.pass("Filter button is present in the grid");
		switch (FilterName)
		{
		case "Asset ID":
			test.info("Clicking the Filter button to select the Filter Option and enter the Value to be Filtered");
			Filter_Button.click();
			Thread.sleep(3000);
			Asset_Filter=driver.findElement(By.id("custom_id"));
			if(!(Asset_Filter.isDisplayed()))
				test.fail("Asset ID Filter is not displayed.");
			else
				test.pass("Asset ID Filter is displayed.");
			Asset_Filter.click();
			Asset_Filter.sendKeys(FilterValue);
			test.info("The Value to be filtered is"+FilterValue);
			if(!(Apply_Button.isDisplayed()))
				test.fail("Apply Button is not displayed.");
			else
			{
				test.pass("Apply Button is displayed.");
				Apply_Button.click();
			}
			Thread.sleep(3000);
			List <WebElement> list=driver.findElements(By.cssSelector("div[role='rowgroup'] div[aria-label='Press SPACE to select this row.'] div[col-id='address.asset.custom_id']"));
			i=0;
			if(list.size()==0)
			{
				WebElement no_records=driver.findElement(By.cssSelector("div[class*='ag-theme-material'] div[class*='MuiBox-root']"));
				test.pass("There are no records displayed. The message displayed is "+no_records.getText());
			}
			else
			{
			for(WebElement Element: list)
			{ 
				if(!(Element.getText().equals(FilterValue)))
				{
					i=i+1;
					break;
				}
			}
			if(i!=0)
				test.fail("Filter for Asset ID is not displaying the correct result");
			else
				test.pass("Filter for Asset ID is displaying the correct result");
			test.info("Resetting the filter");
			
			Filter_Button.click();
			Thread.sleep(5000);
			
			if(!(Reset_Button.isDisplayed() && Cancel_Button.isDisplayed()))
				test.fail("Reset Button and Cancel Button are not displayed.");
			else
			{
				test.pass("Reset Button and Cancel Button are is displayed.");
				Reset_Button.click();
				Cancel_Button.click();
				test.pass("Filter Reset Completed");
			} }
			Thread.sleep(3000);
			break;
		case "Scheme":
			Scheme_Filter=driver.findElement(By.cssSelector("input[id*='scheme']"));
			break;
		case "Street":
			test.info("Clicking the Filter button to select the Filter Option and enter the Value to be Filtered");
			Filter_Button.click();
			Thread.sleep(3000);
			Street_Filter=driver.findElement(By.id("street"));
			if(!(Street_Filter.isDisplayed()))
				test.fail("Street Filter is not displayed in the Filter Modal");
			else
				test.pass("Street Filter is displayed in the Filter Modal");
			Street_Filter.click();
			Street_Filter.sendKeys(FilterValue);
			test.info("The Value to be filtered is"+FilterValue);
			if(!(Apply_Button.isDisplayed()))
				test.fail("Apply Button is not displayed in the Filter Modal");
			else
			{
				test.pass("Apply Button is displayed in the Filter Modal");
				Apply_Button.click();
			}
			Thread.sleep(5000);
			list=driver.findElements(By.cssSelector("div[role='rowgroup'] div[aria-label='Press SPACE to select this row.'] div[col-id='address.street']"));
			i=0;
			if(list.size()==0)
			{
				WebElement no_records=driver.findElement(By.cssSelector("div[class*='ag-theme-material'] div[class*='MuiBox-root']"));
				test.pass("There are no records displayed. The message displayed is "+no_records.getText());
			}
			else
			{
			for(WebElement Element: list)
			{ 
				if(!(Element.getText().contains(FilterValue)))
				{
					i=i+1;
					break;
				}
			}
			if(i!=0)
				test.fail("Filter for Street is not displaying the correct result");
			else
				test.pass("Filter for Street is displaying the correct result");
			test.info("Resetting the filter");
			Filter_Button.click();
			Thread.sleep(5000);
			if(!(Reset_Button.isDisplayed() && Cancel_Button.isDisplayed()))
				test.fail("Reset Button and Cancel Button are not displayed");
			else
			{
				test.pass("Reset Button and Cancel Button are is displayed.");
				Reset_Button.click();
				Cancel_Button.click();
				test.pass("Filter Reset Completed");
				
			} }
			Thread.sleep(3000);
			break;
		case "County":
			test.info("Clicking the Filter button to select the Filter Option and enter the Value to be Filtered");
			Filter_Button.click();
			Thread.sleep(3000);
			County_Filter=driver.findElement(By.id("county"));
			if(!(County_Filter.isDisplayed()))
				test.fail("Street Filter is not displayed in the Filter Modal");
			else
				test.pass("Street Filter is displayed in the Filter Modal");
			County_Filter.click();
			County_Filter.sendKeys(FilterValue);
			test.info("The Value to be filtered is"+FilterValue);
			Thread.sleep(4000);
			if(!(Apply_Button.isDisplayed()))
				test.fail("Apply Button is not displayed in the Filter Modal");
			else
			{
				test.pass("Apply Button is displayed in the Filter Modal");
				Apply_Button.click();
			}
			Thread.sleep(3000);
			list=driver.findElements(By.cssSelector("div[role='rowgroup'] div[aria-label='Press SPACE to select this row.'] div[col-id='address.street']"));
			i=0;
			if(list.size()==0)
			{
				WebElement no_records=driver.findElement(By.cssSelector("div[class*='ag-theme-material'] div[class*='MuiBox-root']"));
				test.pass("There are no records displayed. The message displayed is "+no_records.getText());
			}
			else
			{
			for(WebElement Element: list)
			{ 
				if(!(Element.getText().equals(FilterValue)))
				{
					i=i+1;
					break;
				}
			}
			if(i!=0)
				test.fail("Filter for Street is not displaying the correct result");
			else
				test.pass("Filter for Street is displaying the correct result");
			test.info("Resetting the filter");
			Filter_Button.click();
			Thread.sleep(5000);
			if(!(Reset_Button.isDisplayed() && Cancel_Button.isDisplayed()))
				test.fail("Reset Button and Cancel Button are not displayed");
			else
			{
				test.pass("Reset Button and Cancel Button are is displayed.");
				Reset_Button.click();
				Cancel_Button.click();
				test.pass("Filter Reset Completed");
				
			} }
			Thread.sleep(3000);
			break;
		case "City":
			City_Filter=driver.findElement(By.id("city"));
			break;
		case "EirCode":
			test.info("Clicking the Filter button to select the Filter Option and enter the Value to be Filtered");
			Filter_Button.click();
			Thread.sleep(3000);
			Eircode_Filter=driver.findElement(By.id("eircode"));
			if(!(Eircode_Filter.isDisplayed()))
				test.fail("EirCode Filter is not displayed in the Filter Modal");
			else
				test.pass("EirCode Filter is displayed in the Filter Modal");
			Eircode_Filter.click();
			Eircode_Filter.sendKeys(FilterValue);
			test.info("The Value to be filtered is"+FilterValue);
			Thread.sleep(4000);
			if(!(Apply_Button.isDisplayed()))
				test.fail("Apply Button is not displayed in the Filter Modal");
			else
			{
				test.pass("Apply Button is displayed in the Filter Modal");
				Apply_Button.click();
			}
			Thread.sleep(3000);
			list=driver.findElements(By.cssSelector("div[role='rowgroup'] div[aria-label='Press SPACE to select this row.'] div[col-id='address.eircode']"));
			i=0;
			if(list.size()==0)
			{
				WebElement no_records=driver.findElement(By.cssSelector("div[class*='ag-theme-material'] div[class*='MuiBox-root']"));
				test.pass("There are no records displayed. The message displayed is "+no_records.getText());
			}
			else
			{
			for(WebElement Element: list)
			{ 
				if(!(Element.getText().equals(FilterValue)))
				{
					i=i+1;
					break;
				}
			}
			if(i!=0)
				test.fail("Filter for EirCode is not displaying the correct result");
			else
				test.pass("Filter for EirCode is displaying the correct result");
			test.info("Resetting the filter");
			Filter_Button.click();
			Thread.sleep(5000);
			if(!(Reset_Button.isDisplayed() && Cancel_Button.isDisplayed()))
				test.fail("Reset Button and Cancel Button are not displayed");
			else
			{
				test.pass("Reset Button and Cancel Button are is displayed.");
				Reset_Button.click();
				Cancel_Button.click();
				test.pass("Filter Reset Completed");
				
			} }
			Thread.sleep(3000);
			break;
		case "Build Date":
			test.info("Clicking the Filter button to select the Filter Option and enter the Value to be Filtered");
			Filter_Button.click();
			Thread.sleep(5000);
			BuildDate_Filter=driver.findElement(By.id("build_date"));
			if(!(BuildDate_Filter.isDisplayed()))
				test.fail("BuildDate Filter is not displayed in the Filter Modal");
			else
				test.pass("BuildDate Filter is displayed in the Filter Modal");
			BuildDate_Filter.click();
			test.info("The Value to be filtered is"+FilterValue);
			//Eircode_Filter.sendKeys(FilterValue);
			//driver.findElement(By.xpath("//div[normalize-space()="+FilterValue+"]")).click();
			List <WebElement> buildYear=driver.findElements(By.cssSelector("div[role='none presentation'] div[role='button']"));
			for(WebElement Element: buildYear)
			{ 
				if(Element.getText().equals(FilterValue))
				{
					Element.click(); 
					test.pass("The build year "+FilterValue+" is selected");
					Thread.sleep(4000);
					break;
				}
			}		
			Thread.sleep(4000);
			if(!(Apply_Button.isDisplayed()))
				test.fail("Apply Button is not displayed in the Filter Modal");
			else
			{
				test.pass("Apply Button is displayed in the Filter Modal");
				Apply_Button.click();
			}
			Thread.sleep(3000);
			list=driver.findElements(By.cssSelector("div[role='rowgroup'] div[aria-label='Press SPACE to select this row.'] div[col-id='address.asset.build_date']"));
			i=0;
			if(list.size()==0)
			{
				WebElement no_records=driver.findElement(By.cssSelector("div[class*='ag-theme-material'] div[class*='MuiBox-root']"));
				test.pass("There are no records displayed. The message displayed is"+no_records.getText());
			}
			else
			{
			for(WebElement Element: list)
			{ 
				if(!(Element.getText().contains(FilterValue)))
				{
					i=i+1;
					break;
				}
			}
			if(i!=0)
				test.fail("Filter for BuildDate is not displaying the correct result");
			else
				test.pass("Filter for BuildDate is displaying the correct result");
			test.info("Resetting the filter");
			Filter_Button.click();
			Thread.sleep(5000);
			if(!(Reset_Button.isDisplayed() && Cancel_Button.isDisplayed()))
				test.fail("Reset Button and Cancel Button are not displayed");
			else
			{
				test.pass("Reset Button and Cancel Button are is displayed.");
				Reset_Button.click();
				Cancel_Button.click();
				test.pass("Filter Reset Completed");
				
			} }
			Thread.sleep(3000);
			break;
		case "Block":
			test.info("Clicking the Filter button to select the Filter Option and enter the Value to be Filtered");
			Filter_Button.click();
			Thread.sleep(3000);
			Block_Filter=driver.findElement(By.id("block"));
			if(!(Block_Filter.isDisplayed()))
				test.fail("Block Filter is not displayed in the Filter Modal");
			else
				test.pass("Block Filter is displayed in the Filter Modal");
			Block_Filter.click();
			Block_Filter.sendKeys(FilterValue);
			test.info("The Value to be filtered is"+FilterValue);
			Thread.sleep(4000);
			if(!(Apply_Button.isDisplayed()))
				test.fail("Apply Button is not displayed in the Filter Modal");
			else
			{
				test.pass("Apply Button is displayed in the Filter Modal");
				Apply_Button.click();
			}
			Thread.sleep(3000);
			list=driver.findElements(By.cssSelector("div[role='rowgroup'] div[aria-label='Press SPACE to select this row.'] div[col-id='address.asset.name']"));
			i=0;
			if(list.size()==0)
			{
				WebElement no_records=driver.findElement(By.cssSelector("div[class*='ag-theme-material'] div[class*='MuiBox-root']"));
				test.pass("There are no records displayed. The message displayed is "+no_records.getText());
			}
			else
			{
			for(WebElement Element: list)
			{ 
				if(!(Element.getText().contains(FilterValue)))
				{
					i=i+1;
					break;
				}
			}
			if(i!=0)
				test.fail("Filter for Block is not displaying the correct result");
			else
				test.pass("Filter for Block is displaying the correct result");
			test.info("Resetting the filter");
			Filter_Button.click();
			Thread.sleep(5000);
			if(!(Reset_Button.isDisplayed() && Cancel_Button.isDisplayed()))
				test.fail("Reset Button and Cancel Button are not displayed");
			else
			{
				test.pass("Reset Button and Cancel Button are is displayed.");
				Reset_Button.click();
				Cancel_Button.click();
				test.pass("Filter Reset Completed");
				
			} }
			Thread.sleep(3000);
			break;
		case "Property Type":
			break;
		case "Name":
			test.info("Clicking the Filter button to select the Filter Option and enter the Value to be Filtered");
			Filter_Button.click();
			Thread.sleep(3000);
			Name_Filter=driver.findElement(By.id("name"));
			if(!(Name_Filter.isDisplayed()))
				test.fail("Name Filter is not displayed in the Filter Modal");
			else
				test.pass("Name Filter is displayed in the Filter Modal");
			Name_Filter.click();
			Name_Filter.sendKeys(FilterValue);
			test.info("The Value to be filtered is"+FilterValue);
			Thread.sleep(4000);
			if(!(Apply_Button.isDisplayed()))
				test.fail("Apply Button is not displayed in the Filter Modal");
			else
			{
				test.pass("Apply Button is displayed in the Filter Modal");
				Apply_Button.click();
			}
			Thread.sleep(5000);
			list=driver.findElements(By.cssSelector("div[role='rowgroup'] div[aria-label='Press SPACE to select this row.'] div[col-id='business_name']"));
			i=0;
			if(list.size()==0)
			{
				WebElement no_records=driver.findElement(By.cssSelector("div[class*='ag-theme-material'] div[class*='MuiBox-root']"));
				test.pass("There are no records displayed. The message displayed is "+no_records.getText());
			}
			else
			{
			for(WebElement Element: list)
			{ 
				if(!(Element.getText().contains(FilterValue)))
				{
					i=i+1;
					break;
				}
			}
			if(i!=0)
				test.fail("Filter for Name is not displaying the correct result");
			else
				test.pass("Filter for Name is displaying the correct result");
			test.info("Resetting the filter");
			Filter_Button.click();
			Thread.sleep(5000);
			if(!(Reset_Button.isDisplayed() && Cancel_Button.isDisplayed()))
				test.fail("Reset Button and Cancel Button are not displayed");
			else
			{
				test.pass("Reset Button and Cancel Button are is displayed.");
				Reset_Button.click();
				Cancel_Button.click();
				test.pass("Filter Reset Completed");
				
			} }
			Thread.sleep(3000);
			break;
		case "Number":
			test.info("Clicking the Filter button to select the Filter Option and enter the Value to be Filtered");
			Filter_Button.click();
			Thread.sleep(3000);
			Number_Filter=driver.findElement(By.id("number"));
			if(!(Number_Filter.isDisplayed()))
				test.fail("Number Filter is not displayed in the Filter Modal");
			else
				test.pass("Number Filter is displayed in the Filter Modal");
			Number_Filter.click();
			Number_Filter.sendKeys(FilterValue);
			test.info("The Value to be filtered is"+FilterValue);
			Thread.sleep(4000);
			if(!(Apply_Button.isDisplayed()))
				test.fail("Apply Button is not displayed in the Filter Modal");
			else
			{
				test.pass("Apply Button is displayed in the Filter Modal");
				Apply_Button.click();
			}
			Thread.sleep(5000);
			list=driver.findElements(By.cssSelector("div[role='rowgroup'] div[aria-label='Press SPACE to select this row.'] div[col-id='address.number_1']"));
			i=0;
			if(list.size()==0)
			{
				WebElement no_records=driver.findElement(By.cssSelector("div[class*='ag-theme-material'] div[class*='MuiBox-root']"));
				test.pass("There are no records displayed. The message displayed is "+no_records.getText());
			}
			else
			{
			for(WebElement Element: list)
			{ 
				if(!(Element.getText().contains(FilterValue)))
				{
					i=i+1;
					break;
				}
			}
			if(i!=0)
				test.fail("Filter for Number is not displaying the correct result");
			else
				test.pass("Filter for Number is displaying the correct result");
			test.info("Resetting the filter");
			Filter_Button.click();
			Thread.sleep(5000);
			if(!(Reset_Button.isDisplayed() && Cancel_Button.isDisplayed()))
				test.fail("Reset Button and Cancel Button are not displayed");
			else
			{
				test.pass("Reset Button and Cancel Button are is displayed.");
				Reset_Button.click();
				Cancel_Button.click();
				test.pass("Filter Reset Completed");
				
			} }
			Thread.sleep(3000);
			break;
		case "Anniversary":
			test.info("Clicking the Filter button to select the Filter Option and enter the Value to be Filtered");
			Filter_Button.click();
			Thread.sleep(3000);
			Anniversary_Filter=driver.findElement(By.id("anniversary"));
			if(!(Anniversary_Filter.isDisplayed()))
				test.fail("Anniversary Filter is not displayed in the Filter Modal");
			else
				test.pass("Anniversary Filter is displayed in the Filter Modal");
			Anniversary_Filter.click();
			test.info("The Value to be filtered is"+" 17"+" June"+FilterValue);
			driver.findElement(By.xpath("//div[normalize-space()='"+FilterValue+"']")).click();//year clicked
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[normalize-space()='Jun']")).click();//month clicked
			Thread.sleep(3000);
			driver.findElement(By.xpath("//p[normalize-space()='17']")).click();//date clicked
			Thread.sleep(3000);
			Thread.sleep(4000);
			if(!(Apply_Button.isDisplayed()))
				test.fail("Apply Button is not displayed in the Filter Modal");
			else
			{
				test.pass("Apply Button is displayed in the Filter Modal");
				Apply_Button.click();
			}
			Thread.sleep(5000);
			//jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//span[contains(@class,'ag-header-cell-text')][normalize-space()='Anniversary']")));
			//actions = new Actions(driver);
			//actions.moveToElement(driver.findElement(By.xpath("//span[contains(@class,'ag-header-cell-text')][normalize-space()='Anniversary']"))).perform();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += 250", driver.findElement(By.xpath("//span[contains(@class,'ag-header-cell-text')][normalize-space()='County']")));
			Thread.sleep(2000);
			list=driver.findElements(By.cssSelector("div[role='rowgroup'] div[aria-label='Press SPACE to select this row.'] div[col-id='3']"));
			i=0;
			if(list.size()==0)
			{
				WebElement no_records=driver.findElement(By.cssSelector("div[class*='ag-theme-material'] div[class*='MuiBox-root']"));
				test.pass("There are no records displayed. The message displayed is "+no_records.getText());
			}
			else
			{
			for(WebElement Element: list)
			{ 
				if(!(Element.getText().contains(FilterValue)))
				{
					i=i+1;
					break;
				}
			}
			if(i!=0)
				test.fail("Filter for Anniversary is not displaying the correct result");
			else
				test.pass("Filter for Anniversary is displaying the correct result");
			test.info("Resetting the filter");
			Filter_Button.click();
			Thread.sleep(5000);
			if(!(Reset_Button.isDisplayed() && Cancel_Button.isDisplayed()))
				test.fail("Reset Button and Cancel Button are not displayed");
			else
			{
				test.pass("Reset Button and Cancel Button are is displayed.");
				Reset_Button.click();
				Cancel_Button.click();
				test.pass("Filter Reset Completed");
				
			} }
			Thread.sleep(3000);
			break;
		case "Completion":
			test.info("Clicking the Filter button to select the Filter Option and enter the Value to be Filtered");
			Filter_Button.click();
			Thread.sleep(3000);
			Completion_Filter=driver.findElement(By.id("last_check"));
			if(!(Completion_Filter.isDisplayed()))
				test.fail("Completion Filter is not displayed in the Filter Modal");
			else
				test.pass("Completion Filter is displayed in the Filter Modal");
			Completion_Filter.click();
			test.info("The Value to be filtered is"+" 12"+" January"+FilterValue);
			driver.findElement(By.xpath("//div[normalize-space()='"+FilterValue+"']")).click();//year clicked
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[normalize-space()='Jan']")).click();//month clicked
			Thread.sleep(3000);
			driver.findElement(By.xpath("//p[normalize-space()='12']")).click();//date clicked
			Thread.sleep(3000);
			Thread.sleep(4000);
			if(!(Apply_Button.isDisplayed()))
				test.fail("Apply Button is not displayed in the Filter Modal");
			else
			{
				test.pass("Apply Button is displayed in the Filter Modal");
				Apply_Button.click();
			}
			Thread.sleep(5000);
			/*Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Completion Date']"))).perform();
			Thread.sleep(2000);*/
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += 250", driver.findElement(By.xpath("//span[contains(@class,'ag-header-cell-text')][normalize-space()='County']")));
			Thread.sleep(2000);
			list=driver.findElements(By.cssSelector("div[role='rowgroup'] div[aria-label='Press SPACE to select this row.'] div[col-id*='compliance.last_check']"));
			i=0;
			if(list.size()==0)
			{
				WebElement no_records=driver.findElement(By.cssSelector("div[class*='ag-theme-material'] div[class*='MuiBox-root']"));
				test.pass("There are no records displayed. The message displayed is "+no_records.getText());
			}
			else
			{
			for(WebElement Element: list)
			{ 
				if(!(Element.getText().contains(FilterValue)))
				{
					i=i+1;
					break;
				}
			}
			if(i!=0)
				test.fail("Filter for Completion is not displaying the correct result");
			else
				test.pass("Filter for Completion is displaying the correct result");
			test.info("Resetting the filter");
			Filter_Button.click();
			Thread.sleep(5000);
			if(!(Reset_Button.isDisplayed() && Cancel_Button.isDisplayed()))
				test.fail("Reset Button and Cancel Button are not displayed");
			else
			{
				test.pass("Reset Button and Cancel Button are is displayed.");
				Reset_Button.click();
				Cancel_Button.click();
				test.pass("Filter Reset Completed");
				
			} }
			Thread.sleep(3000);
			break;
		default : 
			test.skip("The search you requested cannot be performed. Please check the Filtername again");
		}
	}

}

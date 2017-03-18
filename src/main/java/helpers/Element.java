package helpers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class Element 
{

	public static void click(Config testConfig, WebElement element, String description)
	{
		testConfig.logComment("Click on '" + description + "'");
		
		try
		{
			//Scroll Up or Down if element is not visible
			JavascriptExecutor jse = (JavascriptExecutor)testConfig.driver;
			jse.executeScript("arguments[0].scrollIntoView(false)", element);
		}
		catch(WebDriverException wde){}
		
		
		if(testConfig.enableWinum)
		{
			WebElement urlTextbox = testConfig.driverWinium.findElementByName("Address and search bar");
			int count = Helper.generateRandomNumber(1,5);
			for(int i=0; i<count; i++)
				urlTextbox.click();
		}
		
		//Then click element
		element.click();
	}
	
	
	public static void enterData(Config testConfig, WebElement element, String value, String description)
	{
		testConfig.logComment("Enter the " + description + " as '" + value + "'");
		
		if(testConfig.enableWinum)
		{
			String url = testConfig.driver.getCurrentUrl();
			WebElement urlTextbox = testConfig.driverWinium.findElementByName("Address and search bar");
			element.clear();
			urlTextbox.sendKeys(url);
			WebElement chrome = testConfig.driverWinium.findElementByClassName("Chrome_RenderWidgetHostHWND");
			chrome.click();
		}
		
		element.clear();
		element.sendKeys(value);
	}
}
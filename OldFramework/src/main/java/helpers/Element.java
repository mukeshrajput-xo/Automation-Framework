package helpers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class Element 
{

	public static void click(WebDriver driver, WebElement element, String description)
	{
		System.out.println("Click on '" + description + "'");
		
		try
		{
			//Scroll Up or Down if element is not visible
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView(false)", element);
		}
		catch(WebDriverException wde){}
		
		//Then click element
		element.click();
	}
	
	
	public static void enterData(WebDriver driver, WebElement element, String value, String description)
	{
		System.out.println("Enter the " + description + " as '" + value + "'");
		element.clear();
		element.sendKeys(value);
	}
}
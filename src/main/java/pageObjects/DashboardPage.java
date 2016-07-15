package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.Browser;

public class DashboardPage 
{

	@FindBy(css=".user-name")
	private WebElement userNameWidget;

	
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		Browser.waitForPageLoad(driver, userNameWidget);
	}
}
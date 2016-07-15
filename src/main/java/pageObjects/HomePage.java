package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.Browser;
import helpers.Element;

public class HomePage 
{

	@FindBy(css = "a.button")
	private WebElement signInButton;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		Browser.waitForPageLoad(driver, signInButton);
	}
	
	
	public LoginPage getLoginPage(WebDriver driver)
	{
		Element.click(driver, signInButton, "Sign In Button");
		return new LoginPage(driver);
	}
}
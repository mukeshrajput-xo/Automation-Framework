package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.Browser;
import helpers.Config;
import helpers.Element;

public class HomePage 
{

	@FindBy(css = "a.button")
	private WebElement signInButton;
	
	
	public HomePage(Config testConfig)
	{
		PageFactory.initElements(testConfig.driver, this);
		Browser.waitForPageLoad(testConfig.driver, signInButton);
	}
	
	
	public LoginPage getLoginPage(Config testConfig)
	{
		Element.click(testConfig.driver, signInButton, "Sign In Button");
		return new LoginPage(testConfig.driver);
	}
}
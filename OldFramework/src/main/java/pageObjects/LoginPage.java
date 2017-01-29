package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.Browser;
import helpers.Element;

public class LoginPage 
{
	@FindBy(id="user_email")
	private WebElement userNameTextBox;
	
	@FindBy(css=".btn.btn-default.button")
	private WebElement continueBtn;
	
	@FindBy(id="user_password")
	private WebElement passwordTextBox;
	
	@FindBy(id="user_submit")
	private WebElement signMeInBtn;
	
	
	public enum ExpectedLandingPageAfterLogin
	{
		HomePage, DashboardPage
	}
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		Browser.waitForPageLoad(driver, userNameTextBox);
	}
	
	public Object Login(WebDriver driver, String username, String password, ExpectedLandingPageAfterLogin expectedLandingPage)
	{

		Element.enterData(driver, userNameTextBox, username, "UserName");
		Element.click(driver, continueBtn, "Continue Button");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Element.enterData(driver, passwordTextBox, password, "Password");
		Element.click(driver, continueBtn, "Continue Button");
		
		switch(expectedLandingPage)
		{
			case HomePage:
				return this;
				
			case DashboardPage:
				return new DashboardPage(driver);
				
			default:
				return this;
		}
	}
}
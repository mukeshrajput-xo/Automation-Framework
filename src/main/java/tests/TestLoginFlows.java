package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import helpers.Browser;
import helpers.Browser.BrowserName;
import helpers.Config;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LoginPage.ExpectedLandingPageAfterLogin;

public class TestLoginFlows
{
	
	@Test
	public void testPositiveLoginFlow()
	{
		String username = "prodtest@polymathic.me";
		String password = "yourpassword";
				
		System.out.println("========>>"+System.getProperty("user.dir"));
		
		Config config = new Config();
		
		//Launch Browser and Navigate to Home page of website
		WebDriver driver = Browser.openBrowserAndNavigateToUrl(BrowserName.Firefox, "https://www.hellobar.com/");
		HomePage homePage = new HomePage(driver);
		
		//Navigate to Login Page
		LoginPage loginPage = (LoginPage) homePage.getLoginPage(driver);
		
		//Now Login and reach to Dashboard Page
		DashboardPage dashboardPage = (DashboardPage) loginPage.Login(driver, username, password, ExpectedLandingPageAfterLogin.DashboardPage);
		
		driver.quit();
	}
}

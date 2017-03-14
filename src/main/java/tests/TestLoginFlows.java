package tests;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.Test;

import helpers.Browser;
import helpers.Config;
import helpers.TestBase;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LoginPage.ExpectedLandingPageAfterLogin;

public class TestLoginFlows extends TestBase
{
	
	@Test(dataProvider="getTestConfig")
	public void testNegativeLoginFlow(Config testConfig)
	{
		String username = "test@polymathic.me";
		String password = "yourpassword";
				
		//Launch Browser and Navigate to Home page of website
		Browser.openBrowserAndNavigateToUrl(testConfig, "https://www.hellobar.com/");
		HomePage homePage = new HomePage(testConfig);
		
		//Navigate to Login Page
		LoginPage loginPage = (LoginPage) homePage.getLoginPage(testConfig);
		
		//Now Login and reach to Dashboard Page
		DashboardPage dashboardPage = (DashboardPage) loginPage.Login(testConfig, username, password, ExpectedLandingPageAfterLogin.DashboardPage);
		
		dashboardPage.verifyDashboardPage(testConfig);
	}
	
	@Test(dataProvider="getTestConfig")
	public void testPositiveLoginFlow(Config testConfig)
	{
		String username = "prodtest@polymathic.me";
		String password = "password";
				
		DesktopOptions options = DesktopOptions();
		options.setApplicationPath("C:\\Windows\\System32\\notepad.exe");

		
		//WiniumDriver driver = new WiniumDriver(options);
		
		WiniumDriverService service = new WiniumDriverService.Builder()
                .usingDriverExecutable("path_to_driver_executable")
                .usingAnyFreePort()
                .withVerbose(true)
                .withSilent(false);
                .buildDesktopService();

WiniumDriver driver = new WiniumDriver(service, options);
		
		

	}
}

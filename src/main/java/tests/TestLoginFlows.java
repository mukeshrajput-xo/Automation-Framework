package tests;

import org.testng.annotations.Test;

import helpers.Browser;
import helpers.Config;
import helpers.Helper;
import helpers.TestBase;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LoginPage.ExpectedLandingPageAfterLogin;
import pageObjects.RecordingsDashboardPage;

public class TestLoginFlows extends TestBase
{
	
	@Test(dataProvider="getTestConfig", invocationCount=5, timeOut=3600000)
	public void testSimpleLoginFlow(Config testConfig)
	{
		
		boolean production = true;
		
		String username = "dev@dev.com";
		String password = "developer";
		String url = "https://staging2.crazyegg.com:8095/";
		if(production)
		{
			username = "john@likealightbulb.com";
			password = "7ismyPassword";
			url = "https://www.crazyegg.com/";
		}
		
		//Launch Browser and Navigate to Home page of website
		Browser.openBrowserAndNavigateToUrl(testConfig, url);
		HomePage homePage = new HomePage(testConfig);
		
		//Navigate to Login Page
		LoginPage loginPage = (LoginPage) homePage.getLoginPage(testConfig);
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,25));
		
		//Now Login and reach to Dashboard Page
		DashboardPage dashboardPage = (DashboardPage) loginPage.Login(testConfig, username, password, ExpectedLandingPageAfterLogin.DashboardPage);
		dashboardPage.verifyDashboardPage(testConfig);
		
		//Play Recording
		RecordingsDashboardPage recordingsDashboardPage = dashboardPage.reachToRecordingsDashboard(testConfig);
		recordingsDashboardPage.playFirstRecording(testConfig, false);
	}
	
	@Test(dataProvider="getTestConfig", invocationCount=5, timeOut=3600000)
	public void testLoginFlowWithTableDetails(Config testConfig)
	{
		String username = "dev@dev.com";
		String password = "developer";
		
		//Launch Browser and Navigate to Home page of website
		Browser.openBrowserAndNavigateToUrl(testConfig, "https://staging2.crazyegg.com:8095/");
		HomePage homePage = new HomePage(testConfig);
		
		//Navigate to Login Page
		LoginPage loginPage = (LoginPage) homePage.getLoginPage(testConfig);
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,25));
		
		//Now Login and reach to Dashboard Page
		DashboardPage dashboardPage = (DashboardPage) loginPage.Login(testConfig, username, password, ExpectedLandingPageAfterLogin.DashboardPage);
		
		dashboardPage.verifyDashboardPage(testConfig);
		
		dashboardPage.verifyDetailsInTable(testConfig);
	}
}
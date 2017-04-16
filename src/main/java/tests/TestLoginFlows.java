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
	
	@Test(dataProvider="getTestConfig", invocationCount=1, timeOut=3600000, priority=1)
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
	
	@Test(dataProvider="getTestConfig", invocationCount=1, timeOut=3600000, priority=2)
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
		
		dashboardPage.verifyDetailsInTable(testConfig);
	}
	
	@Test(dataProvider="getTestConfig", invocationCount=1, timeOut=3600000, priority=3)
	public void testSimpleLoginFlow3(Config testConfig)
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
	
	@Test(dataProvider="getTestConfig", invocationCount=1, timeOut=3600000, priority=4)
	public void testLoginFlowWithTableDetails4(Config testConfig)
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
		
		dashboardPage.verifyDetailsInTable(testConfig);
	}
	
	@Test(dataProvider="getTestConfig", invocationCount=1, timeOut=3600000, priority=5)
	public void testSimpleLoginFlow5(Config testConfig)
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
	
	@Test(dataProvider="getTestConfig", invocationCount=1, timeOut=3600000, priority=6)
	public void testLoginFlowWithTableDetails6(Config testConfig)
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
		
		dashboardPage.verifyDetailsInTable(testConfig);
	}
	
	@Test(dataProvider="getTestConfig", invocationCount=1, timeOut=3600000, priority=7)
	public void testSimpleLoginFlow7(Config testConfig)
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
	
	@Test(dataProvider="getTestConfig", invocationCount=1, timeOut=3600000, priority=8)
	public void testLoginFlowWithTableDetails8(Config testConfig)
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
		
		dashboardPage.verifyDetailsInTable(testConfig);
	}
	
	@Test(dataProvider="getTestConfig", invocationCount=1, timeOut=3600000, priority=9)
	public void testSimpleLoginFlow9(Config testConfig)
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
	
	@Test(dataProvider="getTestConfig", invocationCount=1, timeOut=3600000, priority=10)
	public void testLoginFlowWithTableDetails10(Config testConfig)
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
		
		dashboardPage.verifyDetailsInTable(testConfig);
	}
}
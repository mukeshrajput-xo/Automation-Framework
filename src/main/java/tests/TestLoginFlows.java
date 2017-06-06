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
		
		String username = "nxgensystem473@gmail.com";
		String password = "developer";
		String url = "https://staging2.crazyegg.com:8095/";
		
		boolean isProduction = true;
		if(isProduction)
		{
			username = "john@likealightbulb.com";
			password = "7ismyPassword";
			testConfig.putRunTimeProperty("isProduction", "true");
		}
		
		//Launch Browser and Navigate to Home page of website
		Browser.openBrowserAndNavigateToUrl(testConfig, url);
		HomePage homePage = new HomePage(testConfig);
		
		//Navigate to Login Page
		LoginPage loginPage = (LoginPage) homePage.getLoginPage(testConfig);
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,25));
		
		//Now Login and reach to Dashboard Page
		DashboardPage dashboardPage = (DashboardPage) loginPage.Login(testConfig, username, password, ExpectedLandingPageAfterLogin.DashboardPage);
		
		
		//Play Recording
		RecordingsDashboardPage recordingsDashboardPage = dashboardPage.reachToRecordingsDashboard(testConfig);
		recordingsDashboardPage.playFirstRecording(testConfig, false);
	}
	
	@Test(dataProvider="getTestConfig", invocationCount=1, timeOut=3600000, priority=2)
	public void testLoginFlowWithTableDetails(Config testConfig)
	{
		String username = "nxgensystem473@gmail.com";
		String password = "developer";
		String url = "https://staging2.crazyegg.com:8095/";
		
		boolean isProduction = true;
		if(isProduction)
		{
			username = "john@likealightbulb.com";
			password = "7ismyPassword";
			testConfig.putRunTimeProperty("isProduction", "true");
		}
		
		//Launch Browser and Navigate to Home page of website
		Browser.openBrowserAndNavigateToUrl(testConfig, url);
		HomePage homePage = new HomePage(testConfig);
		
		//Navigate to Login Page
		LoginPage loginPage = (LoginPage) homePage.getLoginPage(testConfig);
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,25));
		
		//Now Login and reach to Dashboard Page
		DashboardPage dashboardPage = (DashboardPage) loginPage.Login(testConfig, username, password, ExpectedLandingPageAfterLogin.DashboardPage);
		
		dashboardPage.verifyDetailsInTable(testConfig);
	}
	
	@Test(dataProvider="getTestConfig", timeOut=3600000)
	public void testSimpleLoginFlow1(Config testConfig)
	{
		
		String username = "nxgensystem473@gmail.com";
		String password = "developer";
		String url = "https://staging2.crazyegg.com:8095/";
		
		boolean isProduction = true;
		if(isProduction)
		{
			username = "john@likealightbulb.com";
			password = "7ismyPassword";
			testConfig.putRunTimeProperty("isProduction", "true");
		}
		
		//Launch Browser and Navigate to Home page of website
		Browser.openBrowserAndNavigateToUrl(testConfig, url);
		HomePage homePage = new HomePage(testConfig);
		
		//Navigate to Login Page
		LoginPage loginPage = (LoginPage) homePage.getLoginPage(testConfig);
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,25));
		
		//Now Login and reach to Dashboard Page
		DashboardPage dashboardPage = (DashboardPage) loginPage.Login(testConfig, username, password, ExpectedLandingPageAfterLogin.DashboardPage);
		
		
		//Play Recording
		RecordingsDashboardPage recordingsDashboardPage = dashboardPage.reachToRecordingsDashboard(testConfig);
		recordingsDashboardPage.playFirstRecording(testConfig, false);
	}
	
	@Test(dataProvider="getTestConfig", timeOut=3600000)
	public void testLoginFlowWithTableDetails1(Config testConfig)
	{
		String username = "nxgensystem473@gmail.com";
		String password = "developer";
		String url = "https://staging2.crazyegg.com:8095/";
		
		boolean isProduction = true;
		if(isProduction)
		{
			username = "john@likealightbulb.com";
			password = "7ismyPassword";
			testConfig.putRunTimeProperty("isProduction", "true");
		}
		
		//Launch Browser and Navigate to Home page of website
		Browser.openBrowserAndNavigateToUrl(testConfig, url);
		HomePage homePage = new HomePage(testConfig);
		
		//Navigate to Login Page
		LoginPage loginPage = (LoginPage) homePage.getLoginPage(testConfig);
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,25));
		
		//Now Login and reach to Dashboard Page
		DashboardPage dashboardPage = (DashboardPage) loginPage.Login(testConfig, username, password, ExpectedLandingPageAfterLogin.DashboardPage);
		
		dashboardPage.verifyDetailsInTable(testConfig);
	}
	
	@Test(dataProvider="getTestConfig", timeOut=3600000)
	public void testSimpleLoginFlow2(Config testConfig)
	{
		
		String username = "nxgensystem473@gmail.com";
		String password = "developer";
		String url = "https://staging2.crazyegg.com:8095/";
		
		boolean isProduction = true;
		if(isProduction)
		{
			username = "john@likealightbulb.com";
			password = "7ismyPassword";
			testConfig.putRunTimeProperty("isProduction", "true");
		}
		
		//Launch Browser and Navigate to Home page of website
		Browser.openBrowserAndNavigateToUrl(testConfig, url);
		HomePage homePage = new HomePage(testConfig);
		
		//Navigate to Login Page
		LoginPage loginPage = (LoginPage) homePage.getLoginPage(testConfig);
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,25));
		
		//Now Login and reach to Dashboard Page
		DashboardPage dashboardPage = (DashboardPage) loginPage.Login(testConfig, username, password, ExpectedLandingPageAfterLogin.DashboardPage);
		
		
		//Play Recording
		RecordingsDashboardPage recordingsDashboardPage = dashboardPage.reachToRecordingsDashboard(testConfig);
		recordingsDashboardPage.playFirstRecording(testConfig, false);
	}
	
	@Test(dataProvider="getTestConfig", timeOut=3600000)
	public void testLoginFlowWithTableDetails2(Config testConfig)
	{
		String username = "nxgensystem473@gmail.com";
		String password = "developer";
		String url = "https://staging2.crazyegg.com:8095/";
		
		boolean isProduction = true;
		if(isProduction)
		{
			username = "john@likealightbulb.com";
			password = "7ismyPassword";
			testConfig.putRunTimeProperty("isProduction", "true");
		}
		
		//Launch Browser and Navigate to Home page of website
		Browser.openBrowserAndNavigateToUrl(testConfig, url);
		HomePage homePage = new HomePage(testConfig);
		
		//Navigate to Login Page
		LoginPage loginPage = (LoginPage) homePage.getLoginPage(testConfig);
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,25));
		
		//Now Login and reach to Dashboard Page
		DashboardPage dashboardPage = (DashboardPage) loginPage.Login(testConfig, username, password, ExpectedLandingPageAfterLogin.DashboardPage);
		
		dashboardPage.verifyDetailsInTable(testConfig);
	}
	
	@Test(dataProvider="getTestConfig", timeOut=3600000)
	public void testSimpleLoginFlow3(Config testConfig)
	{
		
		String username = "nxgensystem473@gmail.com";
		String password = "developer";
		String url = "https://staging2.crazyegg.com:8095/";
		
		boolean isProduction = true;
		if(isProduction)
		{
			username = "john@likealightbulb.com";
			password = "7ismyPassword";
			testConfig.putRunTimeProperty("isProduction", "true");
		}
		
		//Launch Browser and Navigate to Home page of website
		Browser.openBrowserAndNavigateToUrl(testConfig, url);
		HomePage homePage = new HomePage(testConfig);
		
		//Navigate to Login Page
		LoginPage loginPage = (LoginPage) homePage.getLoginPage(testConfig);
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,25));
		
		//Now Login and reach to Dashboard Page
		DashboardPage dashboardPage = (DashboardPage) loginPage.Login(testConfig, username, password, ExpectedLandingPageAfterLogin.DashboardPage);
		
		
		//Play Recording
		RecordingsDashboardPage recordingsDashboardPage = dashboardPage.reachToRecordingsDashboard(testConfig);
		recordingsDashboardPage.playFirstRecording(testConfig, false);
	}
	
	@Test(dataProvider="getTestConfig", timeOut=3600000)
	public void testLoginFlowWithTableDetails3(Config testConfig)
	{
		String username = "nxgensystem473@gmail.com";
		String password = "developer";
		String url = "https://staging2.crazyegg.com:8095/";
		
		boolean isProduction = true;
		if(isProduction)
		{
			username = "john@likealightbulb.com";
			password = "7ismyPassword";
			testConfig.putRunTimeProperty("isProduction", "true");
		}
		
		//Launch Browser and Navigate to Home page of website
		Browser.openBrowserAndNavigateToUrl(testConfig, url);
		HomePage homePage = new HomePage(testConfig);
		
		//Navigate to Login Page
		LoginPage loginPage = (LoginPage) homePage.getLoginPage(testConfig);
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,25));
		
		//Now Login and reach to Dashboard Page
		DashboardPage dashboardPage = (DashboardPage) loginPage.Login(testConfig, username, password, ExpectedLandingPageAfterLogin.DashboardPage);
		
		dashboardPage.verifyDetailsInTable(testConfig);
	}
	
	@Test(dataProvider="getTestConfig", timeOut=3600000)
	public void testSimpleLoginFlow4(Config testConfig)
	{
		
		String username = "nxgensystem473@gmail.com";
		String password = "developer";
		String url = "https://staging2.crazyegg.com:8095/";
		
		boolean isProduction = true;
		if(isProduction)
		{
			username = "john@likealightbulb.com";
			password = "7ismyPassword";
			testConfig.putRunTimeProperty("isProduction", "true");
		}
		
		//Launch Browser and Navigate to Home page of website
		Browser.openBrowserAndNavigateToUrl(testConfig, url);
		HomePage homePage = new HomePage(testConfig);
		
		//Navigate to Login Page
		LoginPage loginPage = (LoginPage) homePage.getLoginPage(testConfig);
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,25));
		
		//Now Login and reach to Dashboard Page
		DashboardPage dashboardPage = (DashboardPage) loginPage.Login(testConfig, username, password, ExpectedLandingPageAfterLogin.DashboardPage);
		
		
		//Play Recording
		RecordingsDashboardPage recordingsDashboardPage = dashboardPage.reachToRecordingsDashboard(testConfig);
		recordingsDashboardPage.playFirstRecording(testConfig, false);
	}
	
	@Test(dataProvider="getTestConfig", timeOut=3600000)
	public void testLoginFlowWithTableDetails4(Config testConfig)
	{
		String username = "nxgensystem473@gmail.com";
		String password = "developer";
		String url = "https://staging2.crazyegg.com:8095/";
		
		boolean isProduction = true;
		if(isProduction)
		{
			username = "john@likealightbulb.com";
			password = "7ismyPassword";
			testConfig.putRunTimeProperty("isProduction", "true");
		}
		
		//Launch Browser and Navigate to Home page of website
		Browser.openBrowserAndNavigateToUrl(testConfig, url);
		HomePage homePage = new HomePage(testConfig);
		
		//Navigate to Login Page
		LoginPage loginPage = (LoginPage) homePage.getLoginPage(testConfig);
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,25));
		
		//Now Login and reach to Dashboard Page
		DashboardPage dashboardPage = (DashboardPage) loginPage.Login(testConfig, username, password, ExpectedLandingPageAfterLogin.DashboardPage);
		
		dashboardPage.verifyDetailsInTable(testConfig);
	}
	
	@Test(dataProvider="getTestConfig", timeOut=3600000)
	public void testSimpleLoginFlow5(Config testConfig)
	{
		
		String username = "nxgensystem473@gmail.com";
		String password = "developer";
		String url = "https://staging2.crazyegg.com:8095/";
		
		boolean isProduction = true;
		if(isProduction)
		{
			username = "john@likealightbulb.com";
			password = "7ismyPassword";
			testConfig.putRunTimeProperty("isProduction", "true");
		}
		
		//Launch Browser and Navigate to Home page of website
		Browser.openBrowserAndNavigateToUrl(testConfig, url);
		HomePage homePage = new HomePage(testConfig);
		
		//Navigate to Login Page
		LoginPage loginPage = (LoginPage) homePage.getLoginPage(testConfig);
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,25));
		
		//Now Login and reach to Dashboard Page
		DashboardPage dashboardPage = (DashboardPage) loginPage.Login(testConfig, username, password, ExpectedLandingPageAfterLogin.DashboardPage);
		
		//Play Recording
		RecordingsDashboardPage recordingsDashboardPage = dashboardPage.reachToRecordingsDashboard(testConfig);
		recordingsDashboardPage.playFirstRecording(testConfig, false);
	}
	
	@Test(dataProvider="getTestConfig", timeOut=3600000)
	public void testLoginFlowWithTableDetails5(Config testConfig)
	{
		String username = "nxgensystem473@gmail.com";
		String password = "developer";
		String url = "https://staging2.crazyegg.com:8095/";
		
		boolean isProduction = true;
		if(isProduction)
		{
			username = "john@likealightbulb.com";
			password = "7ismyPassword";
			testConfig.putRunTimeProperty("isProduction", "true");
		}
		
		//Launch Browser and Navigate to Home page of website
		Browser.openBrowserAndNavigateToUrl(testConfig, url);
		HomePage homePage = new HomePage(testConfig);
		
		//Navigate to Login Page
		LoginPage loginPage = (LoginPage) homePage.getLoginPage(testConfig);
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,25));
		
		//Now Login and reach to Dashboard Page
		DashboardPage dashboardPage = (DashboardPage) loginPage.Login(testConfig, username, password, ExpectedLandingPageAfterLogin.DashboardPage);
		
		dashboardPage.verifyDetailsInTable(testConfig);
	}
}
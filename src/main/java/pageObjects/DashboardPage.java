package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.Browser;
import helpers.Config;
import helpers.Element;
import helpers.Element.How;
import helpers.Helper;
import helpers.TestDataReader;

public class DashboardPage 
{

	@FindBy(css=".status")
	private WebElement snapshotStatus;

	@FindBy(css=".headline")
	private WebElement mainHeading;
	
	@FindBy(css=".nav-wrap>ul>li:nth-child(3)>a")
	private WebElement recordingsTab;
	
	public DashboardPage(Config testConfig)
	{
		PageFactory.initElements(testConfig.driver, this);
		Browser.waitForPageLoad(testConfig, snapshotStatus);
	}
	
	public void verifyDashboardPage(Config testConfig)
	{
		//Helper.compareEquals(testConfig, "Main Heading on Page", "Manage your Snapshots", mainHeading.getText());
		
		Browser.wait(testConfig, Helper.generateRandomNumber(35,55));
		
		String oldUrl = testConfig.driver.getCurrentUrl();
		TestDataReader testDataReader = testConfig.getExcelSheet("RECORDINGS");
		String url = testDataReader.getData(35, "URL");
		
		Browser.openBrowserAndNavigateToUrl(testConfig, url);
		Browser.waitForPageLoad(testConfig, Element.getPageElement(testConfig, How.css, "#google-signin-button"));
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,30));
		
		WebElement username = Element.getPageElement(testConfig, How.css, "#username");
		String user = "mukesh.rajput@crossover.com";
		Element.enterData(testConfig, username, user, "Username");
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,30));
		
		WebElement loginBtn = Element.getPageElement(testConfig, How.css, "#login-submit");
		Element.click(testConfig, loginBtn, "Login Button");
		
		Browser.wait(testConfig, 10);
		
		username = Element.getPageElement(testConfig, How.css, "#password");
		String pass = "Mukesh@12345";
		Element.enterData(testConfig, username, pass, "Username");
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,30));
		
		loginBtn = Element.getPageElement(testConfig, How.css, "#login-submit");
		Element.click(testConfig, loginBtn, "Login Button");
		
		Browser.wait(testConfig, 55);
		Browser.waitForPageLoad(testConfig, Element.getPageElement(testConfig, How.css, "#create_link"));
		
		Browser.openBrowserAndNavigateToUrl(testConfig, oldUrl);
		DashboardPage dashboardPage = new DashboardPage(testConfig);
		
		Browser.wait(testConfig, Helper.generateRandomNumber(50,115));
	}
	
	public void verifyDetailsInTable(Config testConfig)
	{
		boolean isloggedIn = false;
		int lastRow = 0;
		int secondLastRow = 0;
		int thirdLastRow = 0;
		TestDataReader testDataReader = testConfig.getExcelSheet("RECORDINGS");
		
		for(int urlRow = 1; urlRow<81; urlRow++)
		{
			int row = Helper.generateRandomNumber(1,81);
			if(row == lastRow)
			{
				row = Helper.generateRandomNumber(1,81);
			}
			else if(row == secondLastRow)
			{
				row = Helper.generateRandomNumber(1,81);
			}
			else
			{
				secondLastRow = lastRow;
				lastRow = row;
			}
			
			
			String url = testDataReader.getData(row, "URL");
			Browser.openBrowserAndNavigateToUrl(testConfig, url);
			Browser.wait(testConfig, Helper.generateRandomNumber(40,50));
			
			if(testConfig.enableWinum)
			{
				WebElement notepad = testConfig.driverWinium.findElementByClassName("Edit");
				String value1 = "crazyegg.com/";
				String value2 = Helper.generateRandomAlphaNumericString(Helper.generateRandomNumber(2,7));
				
				System.out.println("Enter data : " + value1+value2);
				notepad.sendKeys(value1+value2);
			}
			
			if(url.contains("xohellobar"))
			{
				if(!isloggedIn)
				{
					verifyDashboardPage(testConfig);
					isloggedIn = true;
				}
			}
			
			if(testConfig.enableWinum)
			{
				WebElement notepad = testConfig.driverWinium.findElementByClassName("Edit");
				String value1 = "crazyegg.com/";
				String value2 = Helper.generateRandomAlphaNumericString(Helper.generateRandomNumber(2,7));
				
				System.out.println("Enter data : " + value1+value2);
				notepad.sendKeys(value1+value2);
				WebElement urlTextbox = testConfig.driverWinium.findElementByName("Address and search bar");
				for(int i=0; i<4; i++)
					urlTextbox.click();
				
				Browser.wait(testConfig, Helper.generateRandomNumber(45, 95));
				int count = Helper.generateRandomNumber(3,6);
				for(int i=0; i<count; i++)
					urlTextbox.click();
				
				Browser.wait(testConfig, Helper.generateRandomNumber(45, 95));
				Element.KeyPress(testConfig, Element.getPageElement(testConfig, How.tagName, "body"), Keys.PAGE_DOWN, "PageDown button");
				Element.KeyPress(testConfig, Element.getPageElement(testConfig, How.tagName, "body"), Keys.PAGE_DOWN, "Escape button");
				count = Helper.generateRandomNumber(3,6);
				for(int i=0; i<count; i++)
					urlTextbox.click();
				
				value2 = Helper.generateRandomAlphaNumericString(Helper.generateRandomNumber(2,7));
				System.out.println("Enter data : " + value1+value2);
				notepad.sendKeys(value1+value2);
				
				Browser.wait(testConfig, Helper.generateRandomNumber(85,110));
				value2 = Helper.generateRandomAlphaNumericString(Helper.generateRandomNumber(2,7));
				System.out.println("Enter data : " + value1+value2);
				notepad.sendKeys(value1+value2);
				urlTextbox.click();
				
				Browser.wait(testConfig, Helper.generateRandomNumber(45, 95));
				count = Helper.generateRandomNumber(3,6);
				for(int i=0; i<count; i++)
					urlTextbox.click();
				
				Browser.wait(testConfig, Helper.generateRandomNumber(45, 95));
				Element.KeyPress(testConfig, Element.getPageElement(testConfig, How.tagName, "body"), Keys.PAGE_DOWN, "PageDown button");
				Element.KeyPress(testConfig, Element.getPageElement(testConfig, How.tagName, "body"), Keys.PAGE_DOWN, "Escape button");
				count = Helper.generateRandomNumber(3,6);
				for(int i=0; i<count; i++)
					urlTextbox.click();
				
				Browser.wait(testConfig, Helper.generateRandomNumber(85,110));
				value2 = Helper.generateRandomAlphaNumericString(Helper.generateRandomNumber(2,7));
				System.out.println("Enter data : " + value1+value2);
				notepad.sendKeys(value1+value2);
				
				Browser.wait(testConfig, Helper.generateRandomNumber(45, 95));
				count = Helper.generateRandomNumber(3,6);
				for(int i=0; i<count; i++)
					urlTextbox.click();
				
				value2 = Helper.generateRandomAlphaNumericString(Helper.generateRandomNumber(2,7));
				System.out.println("Enter data : " + value1+value2);
				notepad.sendKeys(value1+value2);
				
				Browser.wait(testConfig, Helper.generateRandomNumber(45, 95));
				count = Helper.generateRandomNumber(2,4);
				for(int i=0; i<count; i++)
					urlTextbox.click();
			}
			else
			{
				Element.KeyPress(testConfig, Element.getPageElement(testConfig, How.tagName, "body"), Keys.PAGE_DOWN, "PageDown button");
				Element.KeyPress(testConfig, Element.getPageElement(testConfig, How.tagName, "body"), Keys.PAGE_DOWN, "Escape button");
			}
		}
	}
	
	public RecordingsDashboardPage reachToRecordingsDashboard(Config testConfig)
	{
		Element.click(testConfig, recordingsTab, "Recordings Tab");
		
		return new RecordingsDashboardPage(testConfig);
	}
}
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
		Helper.compareEquals(testConfig, "Main Heading on Page", "Manage your Snapshots", mainHeading.getText());
		
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
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,30));
		
		username = Element.getPageElement(testConfig, How.css, "#password");
		Element.enterData(testConfig, username, "Mukesh@12345", "Username");
		
		Browser.wait(testConfig, Helper.generateRandomNumber(15,30));
		
		loginBtn = Element.getPageElement(testConfig, How.css, "#login-submit");
		Element.click(testConfig, loginBtn, "Login Button");
		
		Browser.wait(testConfig, 60);
		Browser.waitForPageLoad(testConfig, Element.getPageElement(testConfig, How.css, "#create_link"));
		
		Browser.openBrowserAndNavigateToUrl(testConfig, oldUrl);
		DashboardPage dashboardPage = new DashboardPage(testConfig);
		
		Browser.wait(testConfig, Helper.generateRandomNumber(50,115));
	}
	
	public void verifyDetailsInTable(Config testConfig)
	{
		TestDataReader testDataReader = testConfig.getExcelSheet("RECORDINGS");
		for(int urlRow = 1; urlRow<36; urlRow++)
		{
			String url = testDataReader.getData(urlRow, "URL");
			Browser.openBrowserAndNavigateToUrl(testConfig, url);
			Browser.wait(testConfig, Helper.generateRandomNumber(115,150));
			String value = Helper.generateRandomAlphaNumericString(Helper.generateRandomNumber(2,11));
			System.out.println("Enter data : " + value);
			
			if(testConfig.enableWinum)
			{
				WebElement notepad = testConfig.driverWinium.findElementByClassName("Edit");
				System.out.println("Enter data : " + value);
				notepad.sendKeys(value);
				WebElement urlTextbox = testConfig.driverWinium.findElementByName("Address and search bar");
				urlTextbox.click();
				
				Browser.wait(testConfig, Helper.generateRandomNumber(60, 115));
				int count = Helper.generateRandomNumber(1,5);
				for(int i=0; i<count; i++)
					urlTextbox.click();
				
				Browser.wait(testConfig, Helper.generateRandomNumber(60, 115));
				Element.KeyPress(testConfig, Element.getPageElement(testConfig, How.tagName, "body"), Keys.PAGE_DOWN, "Scroll page down");
				count = Helper.generateRandomNumber(1,3);
				for(int i=0; i<count; i++)
					urlTextbox.click();
				
				Browser.wait(testConfig, Helper.generateRandomNumber(115,150));
				value = Helper.generateRandomAlphaNumericString(Helper.generateRandomNumber(2,11));
				System.out.println("Enter data : " + value);
				notepad.sendKeys(value);
				urlTextbox.click();
				
				Browser.wait(testConfig, Helper.generateRandomNumber(60, 115));
				count = Helper.generateRandomNumber(1,5);
				for(int i=0; i<count; i++)
					urlTextbox.click();
				
				Browser.wait(testConfig, Helper.generateRandomNumber(60, 115));
				Element.KeyPress(testConfig, Element.getPageElement(testConfig, How.tagName, "body"), Keys.PAGE_DOWN, "Scroll page down");
				count = Helper.generateRandomNumber(1,3);
				for(int i=0; i<count; i++)
					urlTextbox.click();
				
				Browser.wait(testConfig, Helper.generateRandomNumber(115,150));
				value = Helper.generateRandomAlphaNumericString(Helper.generateRandomNumber(2,11));
				System.out.println("Enter data : " + value);
				notepad.sendKeys(value);
				
				Browser.wait(testConfig, Helper.generateRandomNumber(60, 115));
				count = Helper.generateRandomNumber(1,5);
				for(int i=0; i<count; i++)
					urlTextbox.click();
				
				Browser.wait(testConfig, Helper.generateRandomNumber(60, 115));
				count = Helper.generateRandomNumber(1,3);
				for(int i=0; i<count; i++)
					urlTextbox.click();
				
				Browser.wait(testConfig, Helper.generateRandomNumber(60, 115));
				Element.KeyPress(testConfig, Element.getPageElement(testConfig, How.tagName, "body"), Keys.PAGE_DOWN, "Scroll page down");
				count = Helper.generateRandomNumber(1,3);
				for(int i=0; i<count; i++)
					urlTextbox.click();
				
				Browser.wait(testConfig, Helper.generateRandomNumber(115,150));
				value = Helper.generateRandomAlphaNumericString(Helper.generateRandomNumber(2,11));
				System.out.println("Enter data : " + value);
				notepad.sendKeys(value);
				urlTextbox.click();
				
				Browser.wait(testConfig, Helper.generateRandomNumber(60, 115));
				count = Helper.generateRandomNumber(1,5);
				for(int i=0; i<count; i++)
					urlTextbox.click();
			}
			else
			{
				Element.KeyPress(testConfig, Element.getPageElement(testConfig, How.tagName, "body"), Keys.PAGE_DOWN, "Scroll page down");
			}
		}
	}
	
	public RecordingsDashboardPage reachToRecordingsDashboard(Config testConfig)
	{
		Element.click(testConfig, recordingsTab, "Recordings Tab");
		
		return new RecordingsDashboardPage(testConfig);
	}
}
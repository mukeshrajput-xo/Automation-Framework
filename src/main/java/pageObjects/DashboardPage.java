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
	
	public void verifyDetailsInTable(Config testConfig)
	{
		boolean isloggedIn = false;
		boolean isGitHubLoggedIn = false;
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
			else if(row == thirdLastRow)
			{
				row = Helper.generateRandomNumber(1,81);
			}
			else
			{
				thirdLastRow = secondLastRow;
				secondLastRow = lastRow;
				lastRow = row;
			}
			
			String url = testDataReader.getData(row, "URL");
			Browser.openBrowserAndNavigateToUrl(testConfig, url);
			Browser.wait(testConfig, Helper.generateRandomNumber(40,50));
			
			if(testConfig.enableWinum)
			{
				String value1 = "crazyegg.com+";
				String value2 = Helper.generateRandomAlphaNumericString(Helper.generateRandomNumber(2,7));
				
				System.out.println("Enter data in verifyDetailsInTable1 : " + value1+value2);
				testConfig.driverWinium.findElementByClassName("Edit").sendKeys(value1+value2);
				Browser.wait(testConfig, 1);
				testConfig.driverWinium.findElementByName("Address and search bar").click();
				System.out.println("Click in verifyDetailsInTable1");
			}
			
			if(url.contains("xohellobar"))
			{
				if(!isloggedIn)
				{
					Browser.loginCrazyEggJira(testConfig);
					isloggedIn = true;
				}
			}
			
			if(url.contains("github.com"))
			{
				if(!isGitHubLoggedIn)
				{
					Browser.loginCrazyEggGitHub(testConfig);
					isGitHubLoggedIn = true;
				}
			}
			
			if(testConfig.enableWinum)
			{
				String value1 = "crazyegg.com/";
				String value2 = Helper.generateRandomAlphaNumericString(Helper.generateRandomNumber(2,7));
				
				System.out.println("Enter data in verifyDetailsInTable2 : " + value1+value2);
				testConfig.driverWinium.findElementByClassName("Edit").sendKeys(value1+value2);
				for(int i=0; i<4; i++)
				{
					Browser.wait(testConfig, 1);
					testConfig.driverWinium.findElementByName("Address and search bar").click();
					System.out.println("Click in verifyDetailsInTable2");
				}
				
				Browser.wait(testConfig, Helper.generateRandomNumber(45, 95));
				int count = Helper.generateRandomNumber(3,6);
				for(int i=0; i<count; i++)
				{
					Browser.wait(testConfig, 1);
					testConfig.driverWinium.findElementByName("Address and search bar").click();
					System.out.println("Click in verifyDetailsInTable3");
				}
				
				Browser.wait(testConfig, Helper.generateRandomNumber(45, 95));
				Element.KeyPress(testConfig, Element.getPageElement(testConfig, How.tagName, "body"), Keys.PAGE_DOWN, "PageDown button");
				Element.KeyPress(testConfig, Element.getPageElement(testConfig, How.tagName, "body"), Keys.PAGE_DOWN, "Escape button");
				count = Helper.generateRandomNumber(3,6);
				for(int i=0; i<count; i++)
				{
					Browser.wait(testConfig, 1);
					testConfig.driverWinium.findElementByName("Address and search bar").click();
					System.out.println("Click in verifyDetailsInTable4");
				}
				
				value2 = Helper.generateRandomAlphaNumericString(Helper.generateRandomNumber(2,7));
				System.out.println("Enter data in verifyDetailsInTable3 : " + value1+value2);
				testConfig.driverWinium.findElementByClassName("Edit").sendKeys(value1+value2);
				Browser.wait(testConfig, 1);
				testConfig.driverWinium.findElementByName("Address and search bar").click();
				System.out.println("Click in verifyDetailsInTable4");
				
				Browser.wait(testConfig, Helper.generateRandomNumber(85,110));
				value2 = Helper.generateRandomAlphaNumericString(Helper.generateRandomNumber(2,7));
				System.out.println("Enter data in verifyDetailsInTable4 : " + value1+value2);
				testConfig.driverWinium.findElementByClassName("Edit").sendKeys(value1+value2);
				Browser.wait(testConfig, 1);
				testConfig.driverWinium.findElementByName("Address and search bar").click();
				System.out.println("Click in verifyDetailsInTable5");
				
				Browser.wait(testConfig, Helper.generateRandomNumber(45, 95));
				count = Helper.generateRandomNumber(3,6);
				for(int i=0; i<count; i++)
				{
					Browser.wait(testConfig, 1);
					testConfig.driverWinium.findElementByName("Address and search bar").click();
					System.out.println("Click in verifyDetailsInTable6");
				}
				
				Browser.wait(testConfig, Helper.generateRandomNumber(45, 95));
				Element.KeyPress(testConfig, Element.getPageElement(testConfig, How.tagName, "body"), Keys.PAGE_DOWN, "PageDown button");
				Element.KeyPress(testConfig, Element.getPageElement(testConfig, How.tagName, "body"), Keys.PAGE_DOWN, "Escape button");
				count = Helper.generateRandomNumber(3,6);
				for(int i=0; i<count; i++)
				{
					Browser.wait(testConfig, 1);
					testConfig.driverWinium.findElementByName("Address and search bar").click();
					System.out.println("Click in verifyDetailsInTable7");
				}
				
				Browser.wait(testConfig, Helper.generateRandomNumber(85,110));
				value2 = Helper.generateRandomAlphaNumericString(Helper.generateRandomNumber(2,7));
				System.out.println("Enter data in verifyDetailsInTable4 : " + value1+value2);
				testConfig.driverWinium.findElementByClassName("Edit").sendKeys(value1+value2);
				Browser.wait(testConfig, 1);
				testConfig.driverWinium.findElementByName("Address and search bar").click();
				System.out.println("Click in verifyDetailsInTable8");
				
				Browser.wait(testConfig, Helper.generateRandomNumber(45, 95));
				count = Helper.generateRandomNumber(3,6);
				for(int i=0; i<count; i++)
				{
					Browser.wait(testConfig, 1);
					testConfig.driverWinium.findElementByName("Address and search bar").click();
					System.out.println("Click in verifyDetailsInTable9");
				}
				
				value2 = Helper.generateRandomAlphaNumericString(Helper.generateRandomNumber(2,7));
				System.out.println("Enter data in verifyDetailsInTable5 : " + value1+value2);
				testConfig.driverWinium.findElementByClassName("Edit").sendKeys(value1+value2);
				Browser.wait(testConfig, 1);
				testConfig.driverWinium.findElementByName("Address and search bar").click();
				System.out.println("Click in verifyDetailsInTable10");
				
				Browser.wait(testConfig, Helper.generateRandomNumber(45, 95));
				count = Helper.generateRandomNumber(2,4);
				for(int i=0; i<count; i++)
				{
					Browser.wait(testConfig, 1);
					testConfig.driverWinium.findElementByName("Address and search bar").click();
					System.out.println("Click in verifyDetailsInTable11");
				}
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
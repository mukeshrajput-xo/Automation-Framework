package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.Browser;
import helpers.Config;
import helpers.Element;
import helpers.Helper;

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
	}
	
	public RecordingsDashboardPage reachToRecordingsDashboard(Config testConfig)
	{
		Element.click(testConfig, recordingsTab, "Recordings Tab");
		
		return new RecordingsDashboardPage(testConfig);
	}
}
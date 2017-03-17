package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.Browser;
import helpers.Config;
import helpers.Element;
import helpers.Helper;

public class RecordingsDashboardPage 
{

	@FindBy(css=".a.wrap-all")
	private WebElement recordingStatus;

	@FindBy(css=".headline")
	private WebElement mainHeading;
	
	@FindBy(css="tbody>tr:first-child>th>a")
	private WebElement firstRecording;
	
	public RecordingsDashboardPage(Config testConfig)
	{
		PageFactory.initElements(testConfig.driver, this);
		Browser.waitForPageLoad(testConfig, recordingStatus);
	}
	
	public void verifyDashboardPage(Config testConfig)
	{
		Helper.compareEquals(testConfig, "Main Heading on Page", "Manage your recordings", mainHeading.getText());
	}
	
	public void playFirstRecording(Config testConfig, boolean skipPauses)
	{
		Element.click(testConfig, firstRecording, "First Recording");
		
		RecordingPage recordingPage = new RecordingPage(testConfig);
		recordingPage.playThisRecording(testConfig, skipPauses);
	}
	
}
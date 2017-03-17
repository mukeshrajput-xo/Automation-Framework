package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.Browser;
import helpers.Config;
import helpers.Element;
import helpers.Helper;
import helpers.TestDataReader;

public class RecordingPage 
{

	@FindBy(css=".playback-controls>a")
	private WebElement playButton;

	@FindBy(css=".btn-secondary.btn-sml.auto-play-next")
	private WebElement playNextBox;
	
	@FindBy(css=".btn-secondary.btn-sml.playback-skip-pauses")
	private WebElement skipPausesBox;
	
	@FindBy(css=".timeline-mask")
	private WebElement content;
	
	public RecordingPage(Config testConfig)
	{
		PageFactory.initElements(testConfig.driver, this);
		testConfig.driver.switchTo().frame("play");
		Browser.waitForPageLoad(testConfig, content);
	}
	

	public void playThisRecording(Config testConfig, boolean skipPauses)
	{
		Element.click(testConfig, playNextBox, "Play Next = YES");
		Browser.wait(testConfig, 1);
		
		if(skipPauses)
		{
			Element.click(testConfig, skipPausesBox, "Skip Pauses");
			Browser.wait(testConfig, 1);
		}
		
		Element.click(testConfig, playButton, "Play Recordings");
		Browser.wait(testConfig, 2);
		
		if(testConfig.enableWinum)
		{
			for(int k=0; k<50; k++)
			{

				Browser.wait(testConfig, (int)Helper.generateRandomNumber(2));
				
				String value = Helper.generateRandomAlphaNumericString(Helper.generateRandomNumber(5,20));
				System.out.println("Enter data : " + value);
				WebElement notepad = testConfig.driverWinium.findElementByClassName("Edit");
				notepad.sendKeys(value);
				
				WebElement chrome = testConfig.driverWinium.findElementByClassName("Chrome_RenderWidgetHostHWND");
				chrome.click();
				
				Browser.wait(testConfig, (int)Helper.generateRandomNumber(1));
				
				WebElement urlTextbox = testConfig.driverWinium.findElementByName("Address and search bar");
				for(int i=0; i<Helper.generateRandomNumber(1,5); i++)
					urlTextbox.click();
				
				
				String min = Helper.getCurrentTime("mm");
				int minValue = Integer.parseInt(min);
				if(minValue % 3 == 0)
				{
					String oldUrl = testConfig.driver.getCurrentUrl();
					TestDataReader testDataReader = testConfig.getExcelSheet("RECORDINGS");
					String url = testDataReader.getData(Helper.generateRandomNumber(1,35), "URL");
					
					Browser.openBrowserAndNavigateToUrl(testConfig, url);
					for(int i=0; i<Helper.generateRandomNumber(1, 5); i++)
						urlTextbox.click();
					Browser.wait(testConfig, 50);
					
					Browser.openBrowserAndNavigateToUrl(testConfig, oldUrl);
					RecordingPage recordingPage = new RecordingPage(testConfig);
					
					Element.click(testConfig, playButton, "Play Recordings");
					Browser.wait(testConfig, 2);
					
				}
			}
		}
	}
}
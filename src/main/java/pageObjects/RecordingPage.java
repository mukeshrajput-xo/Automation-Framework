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

				Browser.wait(testConfig, Helper.generateRandomNumber(50,120));
				
				String value1 = "crazyegg.com/";
				String value2 = Helper.generateRandomAlphaNumericString(Helper.generateRandomNumber(0,7));
				System.out.println("Enter data : " + value1+value2);
				WebElement notepad = testConfig.driverWinium.findElementByClassName("Edit");
				notepad.sendKeys(value1+value2);
				
				WebElement urlTextbox = testConfig.driverWinium.findElementByName("Address and search bar");
				urlTextbox.click();
				
				Browser.wait(testConfig, Helper.generateRandomNumber(5, 20));
				int count = Helper.generateRandomNumber(1,5);
				for(int i=0; i<count; i++)
					urlTextbox.click();
				
				
				String min = Helper.getCurrentTime("mm");
				int minValue = Integer.parseInt(min);
				if(minValue % 2 == 0)
				{
					String oldUrl = testConfig.driver.getCurrentUrl();
					TestDataReader testDataReader = testConfig.getExcelSheet("RECORDINGS");
					String url = testDataReader.getData(Helper.generateRandomNumber(1,81), "URL");
					
					Browser.openBrowserAndNavigateToUrl(testConfig, url);
					
					int counter = Helper.generateRandomNumber(1,5);
					for(int i=0; i<counter; i++)
						urlTextbox.click();
					Browser.wait(testConfig, Helper.generateRandomNumber(45, 100));
					
					Browser.openBrowserAndNavigateToUrl(testConfig, oldUrl);
					RecordingPage recordingPage = new RecordingPage(testConfig);
					
					Element.click(testConfig, playButton, "Play Recordings");
					Browser.wait(testConfig, 2);
					
				}
			}
		}
	}
}
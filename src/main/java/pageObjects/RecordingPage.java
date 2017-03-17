package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.Browser;
import helpers.Config;
import helpers.Element;
import helpers.Helper;

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
			for(int k=0; k<45; k++)
			{
				Browser.wait(testConfig, (int)Helper.generateRandomNumber(2));
				String url = testConfig.driver.getCurrentUrl();
				WebElement urlTextbox = testConfig.driverWinium.findElementByName("Address and search bar");
				WebElement notepad = testConfig.driverWinium.findElementByClassName("Edit");
				notepad.sendKeys(url);
				System.out.println("Enter data : "+url);
				
				WebElement chrome = testConfig.driverWinium.findElementByClassName("Chrome_RenderWidgetHostHWND");
				chrome.click();
				Browser.wait(testConfig, (int)Helper.generateRandomNumber(1));
				for(int i=0; i<Helper.generateRandomNumber(1); i++)
					urlTextbox.click();
			}
		}
	}
}
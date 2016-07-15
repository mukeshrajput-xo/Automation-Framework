package helpers;

import java.io.File;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser 
{
	
	public enum BrowserName
	{
		Firefox, Chrome, Safari, InternetExplorer
	}
	
	
	public static WebDriver openBrowserAndNavigateToUrl(BrowserName browserName, String url)
	{
		System.out.println("Launching " + browserName + " Browser...");
		
		WebDriver driver = null;
		DesiredCapabilities capabilities = null;
		String browserVersion = "";
		
		switch(browserName)
		{
			case Firefox:
				capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("version", browserVersion);
				driver = new FirefoxDriver();
				break;

			case Chrome:
				System.setProperty("webdriver.chrome.driver", "lib" + File.separator + "chromedriver");
				ChromeOptions chromeOptions = new ChromeOptions();
				//chromeOptions.addArguments("--kiosk");
				//chromeOptions.addArguments("--start-maximized");
				capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				capabilities.setCapability("version", browserVersion);
				driver = new ChromeDriver(capabilities);
				driver.manage().window().setPosition(new Point(0, 0));
				driver.manage().window().setSize(new Dimension(1280,900));
				break;
				
			case Safari:
				System.setProperty("webdriver.safari.driver", "lib" + File.separator + "SafariDriver");
				SafariOptions safariOptions = new SafariOptions();
				safariOptions.setUseCleanSession(true);
				capabilities = DesiredCapabilities.safari();
				capabilities.setCapability(SafariOptions.CAPABILITY, safariOptions);				
				capabilities.setCapability("version", browserVersion);
				driver = new SafariDriver(capabilities);
				break;
				
			case InternetExplorer:
				System.setProperty("webdriver.ie.driver", "lib" + File.separator + "IEDriverServer");
				capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability("ignoreProtectedModeSettings", true);
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				capabilities.setCapability("version", browserVersion);
				driver = new InternetExplorerDriver(capabilities);
				break;
				
			default:
				break;
		}
		driver.manage().window().maximize();
		
		System.out.println("Navigating to URL : "+url);
		driver.get(url);
		
		return driver;
	}
	
	
	public static void waitForPageLoad(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Long.parseLong("30"));
		
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch (StaleElementReferenceException e)
		{
			System.out.println("StaleElementReferenceException occured, so trying again...");
			
			try
			{
				wait.until(ExpectedConditions.visibilityOf(element));
			}
			catch (Exception exc)
			{
				System.out.println("Even after second try, element is not loaded, so exiting.");
			}
		}
		
		System.out.println("Page is successfully loaded.");
	}
}
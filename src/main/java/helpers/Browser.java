package helpers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
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
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class Browser 
{
	
	public static void openBrowserAndNavigateToUrl(Config testConfig, String url)
	{
		if(testConfig.driver == null)
			openBrowser(testConfig);
		
		testConfig.logComment("Navigating to URL : "+url);
		
		if(testConfig.enableWinum)
		{
			WebElement notepad = testConfig.driverWinium.findElementByClassName("Edit");
			notepad.sendKeys("crazyegg.com");
		}
		
		testConfig.driver.get(url);
	}
	
	
	private static void openBrowser(Config testConfig)
	{
		String browserName = testConfig.getRunTimeProperty("browser").toLowerCase().trim();
		testConfig.logComment("Launching " + browserName + " Browser...");
		
		WebDriver driver = null;
		DesiredCapabilities capabilities = null;
		String browserVersion = "";
		
		if(testConfig.enableWinum)
		{
			DesktopOptions options = new DesktopOptions();
			//options.setApplicationPath("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			options.setApplicationPath("C:\\Windows\\notepad.exe");
			try {
				testConfig.driverWinium = new WiniumDriver(new URL("http://localhost:9999"),options);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		switch(browserName)
		{
			case "firefox":
				capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("version", browserVersion);
				driver = new FirefoxDriver();
				break;

			case "chrome":
				System.setProperty("webdriver.chrome.driver", "lib" + File.separator + "chromedriver.exe");
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
				
			case "safari":
				System.setProperty("webdriver.safari.driver", "lib" + File.separator + "SafariDriver");
				SafariOptions safariOptions = new SafariOptions();
				safariOptions.setUseCleanSession(true);
				capabilities = DesiredCapabilities.safari();
				capabilities.setCapability(SafariOptions.CAPABILITY, safariOptions);				
				capabilities.setCapability("version", browserVersion);
				driver = new SafariDriver(capabilities);
				break;
				
			case "internetExplorer":
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
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		testConfig.driver = driver;
	}
	
	
	public static void wait(Config testConfig, int seconds)
	{
		int milliseconds = seconds * 1000;
		try
		{
			testConfig.logComment("Wait for '" + seconds + "' seconds");
			Thread.sleep(milliseconds);
		}
		catch (Exception e)
		{
			testConfig.logComment("=====>>Inside catch for InterruptedException");
			//e.printStackTrace();
		}
	}
	
	
	public static void waitForPageLoad(Config testConfig, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(testConfig.driver, Long.parseLong("30"));
		
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch (StaleElementReferenceException e)
		{
			testConfig.logComment("StaleElementReferenceException occured, so trying again...");
			
			try
			{
				wait.until(ExpectedConditions.visibilityOf(element));
			}
			catch (Exception exc)
			{
				testConfig.logComment("Even after second try, element is not loaded, so exiting.");
			}
		}
		
		testConfig.logComment("Page is successfully loaded.");
	}
	
	public static void takeScreenshot(Config testConfig)
	{
		File screenshotUrl = getScreenShotFile(testConfig);
		byte[] screenshot = ((TakesScreenshot)testConfig.driver).getScreenshotAs(OutputType.BYTES);
		try {
			FileUtils.writeByteArrayToFile(screenshotUrl, screenshot);
		} catch (IOException e) {
			System.out.println("=====>>Unable to take screenshot...");
			e.printStackTrace();
		}
		
		String href = convertFilePathToHtmlUrl(screenshotUrl.getPath());
		testConfig.logComment("<B>Screenshot</B>:- <a href=" + href + " target='_blank' >" + screenshotUrl.getName() + "</a>");
		testConfig.logComment("<B>Page URL</B>:- <a href=" + testConfig.driver.getCurrentUrl() + " target='_blank' >" + testConfig.driver.getCurrentUrl() + "</a>");
	}
	
	private static File getResultsDirectory(Config testConfig)
	{
		File dest = new File(testConfig.getRunTimeProperty("ResultsDir") + File.separator + "html" + File.separator );
		return dest;
	}
	
	public static File getScreenShotFile(Config testConfig)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date date = new Date();
		String screenshotName = testConfig.testcaseName + "_" + dateFormat.format(date) + ".png";
		File dest = new File(getResultsDirectory(testConfig).getPath() + File.separator + screenshotName);
		return dest;
	}

	/**
	 * This function return the URL of a file on runtime depending on LOCAL or OFFICIAL Run
	 * @param testConfig
	 * @param fileUrl
	 * @return
	 */
	public static String convertFilePathToHtmlUrl(String fileUrl)
	{
		String htmlUrl = "";
		htmlUrl = fileUrl.replace(File.separator, "/");;
		
		return htmlUrl;
	}
}
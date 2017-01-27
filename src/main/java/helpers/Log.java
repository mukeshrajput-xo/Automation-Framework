package helpers;


import org.testng.Assert;
import org.testng.Reporter;

class Log
{
	
	public static void Comment(String message, Config testConfig, String color)
	{
		logToStandard(message);
		message = "<font color='" + color + "'>" + message + "</font></br>";
		Reporter.log(message);
		testConfig.testLog = testConfig.testLog.concat(message);
	}
	
	public static void Comment(String message, Config testConfig)
	{
		Comment(message, testConfig, "Black");
	}
	
	public static void Fail(String message, Config testConfig)
	{
		PageInfo(testConfig);
		failure(message, testConfig);
	}
	
	public static void failure(String message, Config testConfig)
	{
		String tempMessage = message;
		testConfig.softAssert.fail(message);

		logToStandard(message);
		message = "<font color='Red'>" + message + "</font></br>";
		Reporter.log(message);
		testConfig.testLog = testConfig.testLog.concat(message);
		
		// Stop the execution if end execution flag is ON
		if (testConfig.endExecutionOnfailure)
			Assert.fail("=====>>Ending execution in the middle:-"+tempMessage);
	}
	
	public static void Failfinal(String message, Config testConfig)
	{
		try
		{
			PageInfo(testConfig);
		}
		catch (Exception e)
		{
			testConfig.logWarning("Unable to log page info:- ");
			e.printStackTrace();
		}
	}
	
	private static void logToStandard(String message)
	{
		System.out.println(message);
	}
	
	private static void PageInfo(Config testConfig)
	{
		if (testConfig.driver != null)
		{
			Browser.takeScreenshot(testConfig);
		}
	}
	
	public static void Pass(String message, Config testConfig)
	{
		logToStandard(message);
		message = "<font color='Green'>" + message + "</font></br>";
		Reporter.log(message);
		testConfig.testLog = testConfig.testLog.concat(message);
	}
	
	public static void Warning(String message, Config testConfig)
	{
		logToStandard(message);
		message = "<font color='Orange'>" + message + "</font></br>";
		Reporter.log(message);
		testConfig.testLog = testConfig.testLog.concat(message);
	}
	
	public static void Warning(String message, Config testConfig, boolean logPageInfo)
	{
		if (logPageInfo)
			PageInfo(testConfig);
		
		Warning(message, testConfig);
	}
}
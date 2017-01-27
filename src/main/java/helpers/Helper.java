package helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper 
{
	/**
	 * Compare two integer, double or float type values using a generic function.
	 * @param testConfig
	 * @param what
	 * @param expected
	 * @param actual
	 */
	public static <T> void compareEquals(Config testConfig, String what, T expected, T actual)
	{
		if (expected == null & actual == null)
		{
			testConfig.logPass(what, actual);
			return;
		}

		if (actual != null)
		{
			if (!actual.equals(expected))
			{
				testConfig.logFail(what, expected, actual);
			}
			else
			{
				testConfig.logPass(what, actual);
			}
		}
		else
		{
			testConfig.logFail(what, expected, actual);
		}
	}
	
	/**
	 * Compare 2 strings to check if 'expected' string is present in 'actual' string
	 * @param testConfig
	 * @param what
	 * @param expected
	 * @param actual
	 */
	public static void compareContains(Config testConfig, String what, String expected, String actual)
	{
		actual = actual.trim();
		if (actual != null)
		{
			if (!actual.contains(expected.trim()))
			{
				Pattern expectedPattern = Pattern.compile(expected.substring(0, 2));
				
				//getFirstMatchingPoint
				int findPoint = 0;
				Matcher m = expectedPattern.matcher(actual.trim());
				if (m.find())
					findPoint = m.start();
				else
					findPoint = -1;
				
				actual = actual.substring(0, findPoint) + "<br/>" + actual.substring(findPoint);
				testConfig.logFail(what, expected, actual);
			}
			else
			{
				testConfig.logPass(what, actual);
			}
		}
		else
		{
			testConfig.logFail(what, expected, actual);
		}
	}
}

package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

public class Config 
{

	Properties runTimeProperties = null;
	
	public Config()
	{
		Properties properties = null;
		
		try 
		{
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+File.separator+"Parameters"+File.separator+"config.properties");
			properties = new Properties();
			properties.load(fileInputStream);
			fileInputStream.close();
		} 
		catch (Exception e) 
		{
			logComment("Exception while reading config.properties file...");
			e.printStackTrace();
		}
		
		this.runTimeProperties = new Properties();
		Enumeration<Object> enumeration = properties.keys();
		while (enumeration.hasMoreElements())
		{
			String str = (String) enumeration.nextElement();
			putRunTimeProperty(str, (String) properties.get(str));
		}
	}
	
	
	/**
	 * Add the given key value pair in the Run Time Properties
	 * 
	 * @param key
	 * @param value
	 */
	public void putRunTimeProperty(String key, String value)
	{
		String keyName = key.toLowerCase();
		runTimeProperties.put(keyName, value);
		logComment("Putting RunTime key-" + keyName + " value:-'" + value + "'");
	}
	
	/**
	 * Get the Run Time Property value
	 * 
	 * @param key name whose value is needed
	 * @return value of the specified key
	 */
	public String getRunTimeProperty(String key)
	{
		String keyName = key.toLowerCase();
		String value = "";
		try
		{
			value = runTimeProperties.get(keyName).toString();
			logComment("Reading RunTime key-" + keyName + " value:-'" + value + "'");
		}
		catch (Exception e)
		{
			logComment("'" + key + "' not found in Run Time Properties");
			return null;
		}
		return value;
	}
	
	
	public void logComment(String comment)
	{
		System.out.println(comment);
	}
}
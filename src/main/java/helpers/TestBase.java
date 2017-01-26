package helpers;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class TestBase 
{
	
	@BeforeSuite
	public void beforeSuite()
	{
		
	}
	
	@BeforeClass
	public void beforeClass()
	{
		
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		
	}
	
	@DataProvider(name = "getTestConfig")
	public Object[][] getTestConfiguration()
	{
		Object[][] config = new Object[][] {
			   { "Cedric", new Integer(36) },
			   { "Anne", new Integer(37)},
			 };

		return config;
	}
	
}
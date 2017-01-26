package helpers;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Config {

	private void reachPropertiesFile()
	{
		try {
			FileReader fr = new FileReader(System.getProperty("user.dir"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
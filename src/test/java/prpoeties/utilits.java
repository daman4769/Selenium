package prpoeties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class utilits {

	public String getPropertiesValues(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\eclips\\com.Selenium\\src\\test\\java\\prpoeties\\resource.properties");
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
		
	}
}

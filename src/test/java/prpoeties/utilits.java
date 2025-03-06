package prpoeties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class utilits {

	public String getPropertiesValues(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\eclips\\com.Selenium\\src\\test\\java\\prpoeties\\resource.properties");
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
		
	}
	
	public void selectDropdown(WebElement element , String Value) {
		Select select  = new Select(element);
		List<WebElement> listElement = select.getOptions();
		for(WebElement options : listElement) {
			if(options.getText().equalsIgnoreCase(Value)) {
				options.click();
			}
		}
	}
		
		public void selectFromJquaryDropdown(List<WebElement> ele, String... value) {
			for(WebElement element : ele ) {
				if(element.getText().equals(value)) {
					element.click();
				}
			}
		}
	}


package sampleSeleniumProject.com.Selenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import prpoeties.utilits;


public class SampleTest extends utilits{
WebDriver driver;

@Parameters("Browser")
@Test
public void setup(String browser) throws IOException {
	
	if(browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		
	}else if (browser.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	}
	driver.get("https://careers.cognizant.com/india-en/");
	String expectedtitle =driver.getTitle();
	Assert.assertEquals(expectedtitle , "Welcome to careers at Cognizant | Cognizant Careers","Title not matching");
    driver.close();
}
}

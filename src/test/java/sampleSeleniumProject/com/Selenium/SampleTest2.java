package sampleSeleniumProject.com.Selenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

import prpoeties.utilits;
public class SampleTest2 extends utilits {
	


    WebDriver driver;
@Test
	public void ScroleTest() throws InterruptedException, IOException {
	ChromeOptions options = new ChromeOptions();
    
    // Disable webdriver detection
    options.addArguments("--disable-blink-features=AutomationControlled");
	 driver = new ChromeDriver(options);
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.get("https://www.opencart.com/index.php?route=account/register");
   Thread.sleep(5000);
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
     wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-country")));
     WebElement country = driver.findElement(By.id("input-country"));
		Select select = new Select(country);
		List<WebElement> option = select.getOptions();
		for(WebElement element : option) {
			if(element.getText().equalsIgnoreCase("India")) {
				element.click();
			}
		}
     driver.quit();
	}

@Test
public void SelectMultipleDropDown() throws IOException {
	
	if(getPropertiesValues("browser").equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	}
	else if(getPropertiesValues("browser").equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	
}
	driver.get("https://www.orangehrm.com/en/book-a-free-demo");
	WebElement Country = driver.findElement(By.id("Form_getForm_Country"));
	WebElement noofpeople = driver.findElement(By.id("Form_getForm_NoOfEmployees"));
	selectDropdown(Country, getPropertiesValues("country"));
	selectDropdown(noofpeople, "11 - 50");
}


@Test
public void SelectInBootStrapDropDown() throws IOException, InterruptedException {
	
    
	if(getPropertiesValues("browser").equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	}
	else if(getPropertiesValues("browser").equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	
}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.hdfcbank.com/");
	 Thread.sleep(5000);

  
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"drp1\"]/div[@class=\"dropdown\"][1]/a")));
	
	driver.findElement(By.xpath("//div[@class=\"drp1\"]/div[@class=\"dropdown\"][1]/a")).click();
	List<WebElement> selectProductType = driver.findElements(By.xpath("//div[@class=\"dropdown open\"]/ul/li"));
	
	for(WebElement element : selectProductType) {
		if(element.getText().equalsIgnoreCase("Social Security Schemes")) {
			element.click();
		}
	}
driver.quit();
}
@Test
public void selectDropDown() {
    
	try {
		if(getPropertiesValues("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(getPropertiesValues("browser").equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		
}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
	driver.findElement(By.id("justAnInputBox")).click();
	List<WebElement> list =  driver.findElements(By.xpath("//span[@class=\"comboTreeItemTitle\"]"));
	selectFromJquaryDropdown(list,"choice 2 2");
}
}

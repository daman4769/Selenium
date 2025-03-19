package sampleSeleniumProject.com.Selenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
	driver.close();
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
	driver.close();
}

@Test
public void seletInDynamicDropDown() throws InterruptedException {
	
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
	driver.get("https://www.youtube.com/watch?v=vfFlZTo9ds0");
	driver.findElement(By.xpath("//input[@name=\"search_query\"]")).sendKeys("selenium");
	List<WebElement> list = driver.findElements(By.cssSelector(".ytSuggestionComponentText"));
	Thread.sleep(3000);
for(WebElement ele : list) {
	System.out.println(ele.getDomAttribute("aria-label"));
	if(ele.getDomAttribute("aria-label").equalsIgnoreCase("selenium with python")) {
		
		ele.click();
		break;
	}
}



	
}
@Test
public void webhandels() throws IOException {
	if(getPropertiesValues("browser").equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	}
	else if(getPropertiesValues("browser").equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	}
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.findElement(By.xpath("//div[@class=\"orangehrm-copyright-wrapper\"]/p[2]/a")).click();
	
	Set<String> windowsID = driver.getWindowHandles();
	Iterator<String> it = windowsID.iterator();
	String ParentWindow = it.next();
	String childWindow = it.next();
	System.out.println(driver.getTitle());
	driver.switchTo().window(ParentWindow);
	System.out.println(driver.getTitle());
	driver.switchTo().window(childWindow);
	
	System.out.println(driver.getTitle());
	
	
}
@Test
public void checkURLConnection()  {
	driver = new ChromeDriver();
	try {
        driver.get("https://www.amazon.in");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + links.size());

        for (WebElement link : links) {
            String urlStr = link.getDomAttribute("href");

            if (urlStr == null || urlStr.isEmpty()) {
                System.out.println("Empty link found.");
                continue;
            }

            // Check if URL is relative, if so, append base URL
           if (!urlStr.startsWith("http")) {
                urlStr = "https://www.amazon.in" + urlStr;
           }

            try {
                URL url = new URL(urlStr);
                HttpURLConnection httpConnect = (HttpURLConnection) url.openConnection();
                httpConnect.setRequestMethod("HEAD");
                httpConnect.connect();

                int responseCode = httpConnect.getResponseCode();
                if (responseCode >= 400) {
                    System.out.println(responseCode + " - " + urlStr + " is an invalid link");
                } else {
                    System.out.println(responseCode + " - " + urlStr + " is a valid link");
                }
            } catch (IOException e) {
                System.out.println("Error checking URL: " + urlStr);
                e.printStackTrace();
            }
        }
    } finally {
        driver.quit(); // Ensure the driver closes after execution
    }
		
	}


@Test
public void alert() {
	driver = new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	System.out.println("onClickJsAlert");
	driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();
	driver.switchTo().alert().accept();
	WebElement result  = driver.findElement(By.id("result"));
	
	if(result.getText().equals("You successfully clicked an alert")) {
		System.out.println("User successfully accepted the alert1");
	}
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.xpath("//button[@onclick=\"jsConfirm()\"]"))));
	
	System.out.println("Alert Accept and decline");
	driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
	driver.switchTo().alert().accept();
	
	
	if(result.getText().equals("You clicked: Ok")) {
		System.out.println("User successfully accepted the alert 2");
	}
	
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.xpath("//button[@onclick=\"jsConfirm()\"]"))));
	driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();	
    driver.switchTo().alert().dismiss();
	
	
	if(result.getText().equals("You clicked: Cancel")) {
		System.out.println("User declined");
	}
	System.out.println("click send key and select");
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.xpath("//button[@onclick=\"jsPrompt()\"]"))));
	driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();
	driver.switchTo().alert().sendKeys("Aman");
	driver.switchTo().alert().accept();
	
	if(result.getText().equals("You entered: Aman")) {
		System.out.println("User sent the data and click selected ok");
	}
	
	
}
@Test
public void basicAouth() {
	driver = new ChromeDriver();
	driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	//content
	Wait<WebDriver> myWait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(30))
			.pollingEvery(Duration.ofSeconds(3))
			.ignoring(NoSuchElementException.class);
	WebElement text  = myWait.until(new Function<WebDriver, WebElement>(){
		public WebElement apply(WebDriver driver) {
			return driver.findElement(By.id("content"));
		}
	});
	System.out.print(text.getText());
}
@Test
public void webTabel() {
	driver = new ChromeDriver();
	driver.get("https://cosmocode.io/automation-practice-webtable/");
	List<WebElement> rows = driver.findElements(By.xpath("//tr"));
	List<WebElement> columns = driver.findElements(By.xpath("//tr[1]/td"));
	int rowcount = rows.size();
	int si = driver.findElements(By.xpath("//tr")).size();
	int columncount = columns.size();
	System.out.println("No. of Ros: "+rowcount + "    No. of Columns: "+columncount);
	
	for(int i = 1 ; i <= rowcount ; i++) {
		String country = driver.findElement(By.xpath("//tr["+i+"]/td[2]")).getText();
		if(country.equalsIgnoreCase("India")) {
			System.out.println(driver.findElement(By.xpath("//tr["+i+"]/td[3]")).getText());
		}
	}
}
@Test
public void bookMyshow() throws InterruptedException {
	
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://www.redbus.in/");

	//Select source
	WebElement from = driver.findElement(By.id("src"));
	from.sendKeys("Ranchi");
	Thread.sleep(2000);
	from.sendKeys(Keys.ENTER);
	//Verify 
	Assert.assertEquals(driver.findElement(By.xpath("//label[@for=\"src\"]/following-sibling::div/text")).getText(), "Ranchi");
	
	//Select Dest
	WebElement too = driver.findElement(By.id("dest"));
	too.sendKeys("Delhi");
	Thread.sleep(2000);
	too.sendKeys(Keys.ENTER);
	//Verify 
	Assert.assertEquals(driver.findElement(By.xpath("//label[@for=\"dest\"]/following-sibling::div/text")).getText(), "Delhi");
	
	 driver.findElement(By.id("onwardCal")).click(); // Click on Date Picker
     Thread.sleep(2000); // Wait for calendar to open
     String month = "June";
     
     String monthExpected = "";
     while(!month.equals(monthExpected)){
    	 String month_year = driver.findElement(By.xpath("//div[@class=\"DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr\"]/div[2]")).getText();
    	 String[] arr = month_year.split(" ");
    	 monthExpected = arr[0];
    	 System.out.println(monthExpected);
    	 
    	 
    	 List<WebElement> holidayElements = driver.findElements(By.className("holiday_count"));
         if (!holidayElements.isEmpty()) {
             System.out.println("Number of holidays: " + holidayElements.get(0).getText());
         } else {
             System.out.println("No holidays found.");
         }
    	
    	 
    	 List<WebElement> elements  = driver.findElements(By.cssSelector(".DayTiles__CalendarDaysSpan-sc-1xum02u-1.bwoYtA"));
    	 for(WebElement ele : elements) {
    	 	System.out.print(ele.getText()+" ");
    	 }
    	 
    	 driver.findElement(By.xpath("//div[@class=\"DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr\"]/div[3]")).click();
    	 
     }


	Thread.sleep(5000);
	

	
}
@Test
public void keyBordAction() throws InterruptedException {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://text-compare.com/");
	driver.findElement(By.id("inputText1")).sendKeys("hi all");
	Actions action  = new Actions(driver);
	action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
	action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
	action.sendKeys(Keys.TAB).perform();
	action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
	Thread.sleep(5000);
	
}
@Test()
public void takeSS() throws IOException {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.redbus.in/");

	TakesScreenshot ts= (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File trg = new File("D:\\eclips\\com.Selenium\\screenshot\\homePage.png");
	FileUtils.copyFile(src,trg);
	}
	


@AfterMethod
public void tearDown() {
	driver.close();
}
	
}



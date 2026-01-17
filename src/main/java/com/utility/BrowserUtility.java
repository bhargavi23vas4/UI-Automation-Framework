package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public class BrowserUtility {
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	private static  ThreadLocal<WebDriver> driver =new ThreadLocal<WebDriver>(); //instance Variables
	
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();
	}


	public BrowserUtility(WebDriver driver) {  //	constructor job is to initialize instance variable
		super();
		this.driver.set(driver);    //initialize the instance variable driver!!
		wait=new WebDriverWait(driver,Duration.ofSeconds(30L));
	}
	
	public BrowserUtility(String browserName) {  
		logger.info("Launching Browser for"+browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
//			driver=new ChromeDriver();
			driver.set(new ChromeDriver());
			wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			driver.set(new InternetExplorerDriver());
			wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
			wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
		}
		else {
			System.err.print("Invalid browser name.... please select Chrome or Edge");
		}
	}
	

	
	
	public BrowserUtility(Browser browserName) { 
		logger.info("Launching Browser for"+browserName);
		if(browserName==Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
		}
		else if(browserName==Browser.EDGE) {
			driver.set(new EdgeDriver());
			wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
		}
		else if(browserName==Browser.IE) {
			driver.set(new InternetExplorerDriver());
			wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
		}
		else if(browserName==Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
		}
		
	}
	
	
	
	
	
	
	public BrowserUtility(Browser browserName,boolean isHeadless) { 
		logger.info("Launching Browser for"+browserName);
		if(browserName==Browser.CHROME) {
			if(isHeadless) {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--headless");//headless
			options.addArguments("--window-size=1920,1080");
			driver.set(new ChromeDriver(options));
			wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
			}
			else {
				driver.set(new ChromeDriver());
				wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
			}
		}
		else if(browserName==Browser.EDGE) {
			if(isHeadless) {
				EdgeOptions options=new EdgeOptions();
				options.addArguments("--headless");//headless
				options.addArguments("disable-gpu");
			driver.set(new EdgeDriver(options));
			wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
			}
			else {
				driver.set(new EdgeDriver());
				wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
			}
		}
		else if(browserName==Browser.IE) {
			if(isHeadless) {
				InternetExplorerOptions options=new InternetExplorerOptions();
				options.addCommandSwitches("--headless");//headless
				driver.set(new InternetExplorerDriver(options));
				wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
			}
		   else{
			driver.set(new InternetExplorerDriver());
			wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
		}
		}
		else if(browserName==Browser.FIREFOX) {		 
			if(isHeadless) {
				FirefoxOptions options=new FirefoxOptions ();
				options.addArguments("--headless");//headless
				driver.set(new FirefoxDriver(options));
				wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
			}
		else{
			driver.set(new FirefoxDriver());
			wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
			 }
		}
		
	}
	
	

	
public void goToWebsite(String url) {
	logger.info("Visting the website "+url);
	driver.get().get(url);

}

public void maximizeWindow() {
	logger.info("Maximizing the browser window");
	driver.get().manage().window().maximize();
}

public void clickOn(By locator) {
	logger.info("Finding the element with locator "+locator);
//	WebElement element= driver.get().findElement(locator);//Find the Element
	WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
	logger.info("Element found and now performing click");
	element.click();
}


public void clickOnCheckBox(By locator) {
	logger.info("Finding the element with locator "+locator);
//	WebElement element= driver.get().findElement(locator);//Find the Element
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	logger.info("Element found and now performing click");
	element.click();
}


public void clickOn(WebElement element) {

	logger.info("Element found and now performing click");
	element.click();
}

public void enterText(By locator,String textToEnter) {
	logger.info("Finding the element with locator "+locator);
//	WebElement element=driver.get().findElement(locator);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	logger.info("Element found and now entring text "+ textToEnter);
	element.sendKeys(textToEnter);
	
}

public void enterSpecialKey(By locator,Keys keyToEnter) {
	logger.info("Finding the element with locator "+locator);
//	WebElement element=driver.get().findElement(locator);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	logger.info("Element found and now entring special key "+ keyToEnter);
	element.sendKeys(keyToEnter);
	
}
public String getVisibleText(By locator) {
	logger.info("Finding the element with locator "+locator);
	WebElement element=driver.get().findElement(locator);
	logger.info("Element found and now returning visible text "+ element.getText());
	return element.getText();

}


public List<String> getAllVisibleText(By locator) {
	logger.info("Finding the element with locator "+locator);
	List<WebElement> elementList=driver.get().findElements(locator);
	logger.info("Elements found and now printing the list of ekementstext ");
	List<String> visibleTextList=new ArrayList<String>();
	for(WebElement e: elementList)
	{
		visibleTextList.add(getVisibleText(e));
	}
   return visibleTextList;
}


public List<WebElement> getAllElements(By locator) {
	logger.info("Finding the element with locator "+locator);
	List<WebElement> elementList=driver.get().findElements(locator);
	logger.info("Elements found and now printing the list of ekementstext ");	
   return elementList;
}

public String getVisibleText(WebElement element) {
	
	logger.info("Returning visible text "+ element.getText());
	return element.getText();

}


public String takeScreenshot(String name) {
	TakesScreenshot screenshot=(TakesScreenshot)driver.get();
	Date date=new Date();
	SimpleDateFormat format=new SimpleDateFormat("HH-mm-ss");
	String timestamp=format.format(date);
	
	File screenshotData=screenshot.getScreenshotAs(OutputType.FILE);
//	String path=System.getProperty("user.dir")+"//screenshots//"+name+"-"+
//			timestamp+ ".png";
	String path="./screenshots/"+name+"-"+
			timestamp+ ".png";
	File screenshotFile=new File(path);
	try {
		FileUtils.copyFile(screenshotData, screenshotFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return path;
}




public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
	logger.info("findElement with the locator "+ dropDownLocator);
	WebElement element=driver.get().findElement(dropDownLocator);
	Select select= new Select(element);
	select.selectByVisibleText(optionToSelect);
	logger.info("selecting option"+ optionToSelect);
	
}


public void clearText(By textBoxLocator) {
	logger.info("find Element with the locator "+ textBoxLocator);
	
//	WebElement element=driver.get().findElement(textBoxLocator);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));
	element.clear();
	
}


public void quit() {
	driver.get().quit();
}




}

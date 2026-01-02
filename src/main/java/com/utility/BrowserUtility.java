package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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

import com.constants.Browser;

public class BrowserUtility {
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	private static  ThreadLocal<WebDriver> driver =new ThreadLocal<WebDriver>(); //instance Variables
	
	

	public WebDriver getDriver() {
		return driver.get();
	}


	public BrowserUtility(WebDriver driver) {  //	constructor job is to initialize instance variable
		super();
		this.driver.set(driver);    //initialize the instance variable driver!!
	}
	
	public BrowserUtility(String browserName) {  
		logger.info("Launching Browser for"+browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
//			driver=new ChromeDriver();
			driver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			driver.set(new InternetExplorerDriver());
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
		}
		else {
			System.err.print("Invalid browser name.... please select Chrome or Edge");
		}
	}
	
	
	
	public BrowserUtility(Browser browserName) { 
		logger.info("Launching Browser for"+browserName);
		if(browserName==Browser.CHROME) {
			driver.set(new ChromeDriver());
		}
		else if(browserName==Browser.EDGE) {
			driver.set(new EdgeDriver());
		}
		else if(browserName==Browser.IE) {
			driver.set(new InternetExplorerDriver());
		}
		else if(browserName==Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}
		
	}
	
	
	
	
	
	public BrowserUtility(Browser browserName,boolean isHeadless) { 
		logger.info("Launching Browser for"+browserName);
		if(browserName==Browser.CHROME) {
			if(isHeadless) {
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--Window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			}else {
				driver.set(new ChromeDriver());
			}
			
		}
		else if(browserName==Browser.EDGE) {
			if(isHeadless) {
				EdgeOptions options=new EdgeOptions();
				options.addArguments("--headless");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			}else {
			driver.set(new EdgeDriver());
		}}
		else if(browserName==Browser.IE) {
			if(isHeadless) {
				InternetExplorerOptions options=new InternetExplorerOptions();
				options.addCommandSwitches("--headless");
				driver.set(new InternetExplorerDriver(options));
			}else {
			driver.set(new InternetExplorerDriver());
		}}
		else if(browserName==Browser.FIREFOX) {
			if(isHeadless) {
				FirefoxOptions options=new FirefoxOptions();
				options.addArguments("--headless");
				driver.set(new FirefoxDriver(options));
			}else {
			driver.set(new FirefoxDriver());
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
	WebElement element= driver.get().findElement(locator);//Find the Element
	logger.info("Element found and now performing click");
	element.click();
}

public void enterText(By locator,String textToEnter) {
	logger.info("Finding the element with locator "+locator);
	WebElement element=driver.get().findElement(locator);
	logger.info("Element found and now entring text "+ textToEnter);
	element.sendKeys(textToEnter);
	
}


public String getVisibleText(By locator) {
	logger.info("Finding the element with locator "+locator);
	WebElement element=driver.get().findElement(locator);
	logger.info("Element found and now returning visible text "+ element.getText());
	return element.getText();

}


public String takeScreenshot(String name) {
	TakesScreenshot screenshot=(TakesScreenshot)driver.get();
	Date date=new Date();
	SimpleDateFormat format=new SimpleDateFormat("HH-mm-ss");
	String timestamp=format.format(date);
	
	File screenshotData=screenshot.getScreenshotAs(OutputType.FILE);
	String path=System.getProperty("user.dir")+"//screenshots//"+name+"-"+
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

public void quit() {
	driver.get().quit();
}

}

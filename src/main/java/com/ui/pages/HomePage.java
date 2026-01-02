package com.ui.pages;

import static com.constants.Env.QA;
import static com.utility.JSONUtility.readJson;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility {
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	private static final By SIGN_IN_LINK_LOCATOR=By.xpath("//a[contains(text(),'Sign in')]"); //class variable
	
  

	
	public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName, isHeadless);// super key word job-  To call the parent class constructor from Child class constructor
   goToWebsite(readJson(QA).getUrl());
		
	}

	

	public HomePage(WebDriver driver) {
		super(driver);
		 goToWebsite(readJson(QA).getUrl());
	}



	public LoginPage goToLoginPage() { // --->Page functions
		logger.info("trying to perform click on sign in page");
	clickOn(SIGN_IN_LINK_LOCATOR);
	LoginPage loginPage=new LoginPage(getDriver());
	return loginPage;
		
	}
}

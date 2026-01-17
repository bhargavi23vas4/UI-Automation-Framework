package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {

	private static final By USER_NAME_LOCATOR=By.xpath("//a[@title='View my customer account']/span");
	private static final By SEARCH_BOX_LOCATOR =By.xpath("//input[@placeholder='Search']");
	private static final By SEARCH_SUBMIT=By.name("submit_search");
	private static final By ADD_ADDRESS_LOCATOR=By.xpath("//span[contains(text(),'Add my first address')]");
	
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}

	public String getUserName() {
		return getVisibleText(USER_NAME_LOCATOR);
		
	}
	
	public SearchResultPage searchForAProduct(String productName) {
//		clickOn(SEARCH_BOX_LOCATOR);
		enterText(SEARCH_BOX_LOCATOR, productName);
		enterSpecialKey(SEARCH_BOX_LOCATOR, Keys.ENTER);
//		clickOn(SEARCH_SUBMIT);
		SearchResultPage  searchResultPage=new SearchResultPage(getDriver()); 
		return searchResultPage;
		
	}
	
	public AddressPage goToAdressPage() {
		clickOn(ADD_ADDRESS_LOCATOR);
		AddressPage addressPage=new AddressPage(getDriver());
		return addressPage;
		
	}
	
}

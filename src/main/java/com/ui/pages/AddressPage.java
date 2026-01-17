package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPojo;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {
	
	
	private static final By COMPANY_TEXT_BOX_LOCATOR=By.id("company");
	private static final By ADDRESS1_TEXT_BOX_LOCATOR=By.id("address1");
	private static final By ADDRESS2_TEXT_BOX_LOCATOR=By.id("address2");
	private static final By CITY_TEXT_BOX_LOCATOR=By.id("city");
	private static final By STATE_SELECT_DROPDOWN_LOCATOR=By.id("id_state");
	private static final By ZIP_OR_POSTAL_CODE_TEXT_BOX_LOCATOR=By.id("postcode");
	private static final By COUNTRY_SELECT_DROPDOWN_LOCATOR=By.id("id_country");
	private static final By HOME_PHONE_TEXT_BOX_LOCATOR=By.id("phone");
	private static final By MOBILE_NUMBER_TEXT_BOX_LOCATOR=By.id("phone_mobile");
	private static final By ADDITIONAL_INFORMATION_TEXT_AREA_LOCATOR=By.id("other");
	private static final By ADDRESS_ALIAS_TEXT_BOX_LOCATOR=By.id("alias");
	private static final By SAVE_ADDRESS_LOCATOR=By.id("submitAddress");
	private static final By ADDRESS_HEADING=By.tagName("h3");
	

	public AddressPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	public String saveAddress(AddressPojo addresssPojo) {
		enterText(COMPANY_TEXT_BOX_LOCATOR, addresssPojo.getCompany());
		enterText(ADDRESS1_TEXT_BOX_LOCATOR, addresssPojo.getAddress1());
		enterText(ADDRESS2_TEXT_BOX_LOCATOR, addresssPojo.getAddress2());
		enterText(CITY_TEXT_BOX_LOCATOR, addresssPojo.getCity());
		enterText(ZIP_OR_POSTAL_CODE_TEXT_BOX_LOCATOR, addresssPojo.getZipOrPostalCode());
		enterText(HOME_PHONE_TEXT_BOX_LOCATOR, addresssPojo.getHomePhone());
		enterText(MOBILE_NUMBER_TEXT_BOX_LOCATOR, addresssPojo.getMobilePhone());
		enterText(ADDITIONAL_INFORMATION_TEXT_AREA_LOCATOR, addresssPojo.getAdditionalInfo());
		clearText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR);
		enterText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR, addresssPojo.getAddressAlias());
		selectFromDropDown(STATE_SELECT_DROPDOWN_LOCATOR,addresssPojo.getState());
//		selectFromDropDown(COUNTRY_SELECT_DROPDOWN_LOCATOR,"");
		clickOn(SAVE_ADDRESS_LOCATOR);
		String newAddress=getVisibleText(ADDRESS_HEADING);
		
		return newAddress;
	}

}

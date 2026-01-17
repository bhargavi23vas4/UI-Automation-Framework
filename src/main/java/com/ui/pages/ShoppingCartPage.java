package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartPage extends BrowserUtility {
	private static final By PRODUCT_ADDED_TO_CART_HEADER_TEXT=By.xpath("//div[contains(@class,'layer_cart_product ')]//h2//i");
	private static final By PROCEED_CHECKOUT_BUTTON_LOCATOR=By.xpath("//p[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']");
	
	

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
//	public String getHeaderTextAFterAddingToCart() {
//		return getVisibleText(PRODUCT_ADDED_TO_CART_HEADER_TEXT);
//		
//	}
	
	
	public ConfirmAddressPage goToConfirmAddressPage() {
		clickOn(PROCEED_CHECKOUT_BUTTON_LOCATOR);
		return new ConfirmAddressPage(getDriver());
	}
	

}

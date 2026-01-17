package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {
	private SearchResultPage searchResultPage;
	
	private static final String SEARCH_TERM="Printed Summer Dress";
	
	@BeforeMethod(description="User logs in to the application and searches for a product")
	public void setup() {
		searchResultPage=homePage.goToLoginPage().doLoginWith("migoti4686@mucate.com", "Gurijala123").searchForAProduct(SEARCH_TERM);
		
	}
	
	
	
	
	@Test(description="Verify if logged in user is able to buy a dress", groups= {"e2e","smoke","sanity"})
	public void checkoutTest() {
		String actualtext=searchResultPage.clickOnTheProductAtIndex(2).changeSize(L).addProductToCart()
				.proceedToCheckOut().goToConfirmAddressPage().goToShipmentPage().goToPaymentPage().makePaymentByWire();
		System.out.println(actualtext);
		Assert.assertEquals(actualtext,"Your order on My Shop is complete.");
		
		
		
	}

}

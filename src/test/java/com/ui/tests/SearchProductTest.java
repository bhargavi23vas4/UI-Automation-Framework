package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners(com.ui.listeners.TestListener.class)
public class SearchProductTest extends TestBase {
	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM= "Printed Summer Dress";
	
	@BeforeMethod(description="valid user logs into the application")
	public void setup() {
		
		myAccountPage=homePage.goToLoginPage().doLoginWith("migoti4686@mucate.com", "Gurijala123");
	}
	
	@Test(description="verify if the logged in user is able tosearch for a product and correct products are displayed", groups= {"e2e","sanity"} )
	public void verifyProductSearchTest() {	
	boolean actualResult=myAccountPage.searchForAProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
	Assert.assertEquals(actualResult, true);
	
	}
	
	

}

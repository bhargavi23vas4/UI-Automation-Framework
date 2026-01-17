package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPojo;
import com.utility.FakeAddressUtility;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class AddNewFirstAddressTest extends TestBase {
	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	private AddressPojo addressPojo;
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	@BeforeMethod
	public void setup() {
		 myAccountPage=homePage.goToLoginPage().doLoginWith("migoti4686@mucate.com", "Gurijala123");
		addressPojo=FakeAddressUtility.getFakeAddress();
//		 addressPojo=new AddressPojo("XYZ", "123", "1234", "CITY", "98765", "1234567897", "1234567897", "random", "office address", "California");
		 
	}
	
	
	
	@Test(description="Add new address")
	public void addNewAddress() {
		String newAddress=myAccountPage.goToAdressPage().saveAddress(addressPojo);
	
	Assert.assertEquals(newAddress, addressPojo.getAddressAlias().toUpperCase());
	}
	
	
	

}

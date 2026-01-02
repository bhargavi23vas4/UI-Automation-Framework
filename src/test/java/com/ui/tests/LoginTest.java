package com.ui.tests;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase {

	Logger logger=LoggerUtility.getLogger(this.getClass());

//	
	
//	@BeforeMethod(description="load the homepage of the website")
//	public void setUp() {
//		logger.info("load the homepage of the website");
//		 homePage=new HomePage(CHROME);
//	}
//	
	

	@Test(description="verify with the valid user is able to login to the application", groups= {"e2e","sanity"}, 
			dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestDataProvider")
	public void loginTest(User user) {
		
	assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Bhargavi G");
	
	}
	

//	@Test(description="verify with the valid user is able to login to the application", groups= {"e2e","sanity"}, 
//			dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestCSVDataProvider")
//	public void loginCSVTest(User user) {
//		logger.info("started my login Excel Test");
//	assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Bhargavi G");
//	logger.info("login test completed");
//	}
//	
//	@Test(description="verify with the valid user is able to login to the application", groups= {"e2e","sanity"}, 
//			dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,
//			dataProvider="LoginTestExcelDataProvider",retryAnalyzer=com.ui.listeners.MyRetryAnalyzer.class)
//	public void loginExcelTest(User user) {
////		Logger logger=LoggerUtility.getLogger(this.getClass());
//		logger.info("started my login Excel Test");
//	assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Bhargavi G");
//	logger.info("login test completed");
//	}


}

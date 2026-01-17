package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	
	protected HomePage homePage;
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	private boolean isLambdaTest;
	
	
	@Parameters({"browser","isLambdaTest","isHeadless"})
	@BeforeMethod(description="load the homepage of the website")
	public void setup(
			@Optional("chrome") String browser,
			@Optional("false") boolean isLambdaTest,
			@Optional("false") boolean isHeadless,ITestResult result) {
		this.isLambdaTest=isLambdaTest;
		WebDriver lambdaDriver;
		if(isLambdaTest) {
			
//			lambdaDriver=LambdaTestUtility.initializeLambdaTestSession("chrome",result.getMethod().getMethodName() );
			lambdaDriver=LambdaTestUtility.initializeLambdaTestSession(browser,result.getMethod().getMethodName() );
			homePage=new HomePage(lambdaDriver);
		
		}else {
//			Running the test on local machine
		logger.info("load the homepage of the website");
		 homePage=new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
//		 homePage=new HomePage(Browser.CHROME,isHeadless);
		}
		

		}
	
	
	public BrowserUtility getInstance() {  ///vvvvimp
		return homePage;
	}
	
	@AfterMethod(description="Tear down the browser")
	public void tearDown() {
		
		if(isLambdaTest) {
			LambdaTestUtility.quitSession();  //quit/close the browser session on lambda test
		}
		else {
		homePage.quit();//local
		}
	
	}

}

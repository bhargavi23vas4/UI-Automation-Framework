package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTestOld {

	public static void main(String[] args) {

	WebDriver wdriver=new ChromeDriver();//Launch a Browser window!! Browser Session is created!!

	BrowserUtility browserUtility=new BrowserUtility(wdriver);
	browserUtility.goToWebsite("http://www.automationpractice.pl/index.php");
	browserUtility.maximizeWindow();

	

	By signInLinkLocator=By.xpath("//a[contains(text(),'Sign in')]");
	browserUtility.clickOn(signInLinkLocator);
	
	By emailTextBoxLocator=By.id("email");
	browserUtility.enterText(emailTextBoxLocator, "migoti4686@mucate.com");
	
	By passwordTextBoxLocator=By.id("passwd");
	browserUtility.enterText(passwordTextBoxLocator, "Gurijala123");
    
	By submitLoginButtonLocator=By.id("SubmitLogin");
	browserUtility.clickOn(submitLoginButtonLocator);
	
	}

}

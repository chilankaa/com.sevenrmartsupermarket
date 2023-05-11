package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;


public class LoginTest extends Base{
	LoginPage loginPage;
	HomePage homepage;
	
	@Test
	public void verifyUserLogin() {
		loginPage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginPage.login();
		String expectedProfileName="admin";
		String actualProfileName=homepage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}
	@Test
	public void verifyErrorMessageOnInvalidUserLogin() {
		loginPage=new LoginPage(driver);
		loginPage.login("admi","ad");
		boolean status=loginPage.isErrorMessageDisplayed();
		Assert.assertTrue(status);
	}
	@Test
	public void verifySignInButton() {
		loginPage=new LoginPage(driver);
		String expectedLoginButtonText="Sign In";
		boolean status=loginPage.isLoginButtonTextAsExpected(expectedLoginButtonText);
		Assert.assertTrue(status);
	}
}

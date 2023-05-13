package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class HomeTest extends Base {
	LoginPage loginpage;
	HomePage homepage;

	@Test
	public void verifyPushNotification() {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.login();
		homepage.clickOnPushNotification("test","Sending values for testing...");
		Assert.assertTrue(homepage.isSuccessAlertPresent());
	}
}

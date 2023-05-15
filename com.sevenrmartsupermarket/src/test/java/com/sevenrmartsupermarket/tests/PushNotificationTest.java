package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotificationPage;

public class PushNotificationTest extends Base {
	LoginPage loginpage;
	PushNotificationPage pushNotificationPage;

	@Test
	public void verifyPushNotification() {
		loginpage = new LoginPage(driver);
		pushNotificationPage = new PushNotificationPage(driver);
		loginpage.login();
		pushNotificationPage.clickOnPushNotification("test", "Sending values for testing...");
		Assert.assertTrue(pushNotificationPage.isSuccessAlertPresent());
	}
}

package com.sevenrmartsupermarket.tests;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotificationPage;
import com.sevenrmartsupermarket.utilities.ExcelUtility;

public class PushNotificationTest extends Base {
	LoginPage loginpage;
	PushNotificationPage pushNotificationPage;
	ExcelUtility excelUtility;

	@Test(groups = "smoke")
	public void verifyPushNotification() throws IOException {
		loginpage = new LoginPage(driver);
		pushNotificationPage = new PushNotificationPage(driver);
		excelUtility=new ExcelUtility();
		loginpage.login();
//		pushNotificationPage.clickOnPushNotification("test", "Sending values for testing...");
		pushNotificationPage.clickOnPushNotification(excelUtility.getExcel(1, 0),excelUtility.getExcel(1, 1));
		Assert.assertTrue(pushNotificationPage.isSuccessAlertPresent());
	}
}

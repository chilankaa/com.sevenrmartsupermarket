package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.FakerClass;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUsersTest extends Base {
	LoginPage loginPage;
	AdminUsersPage adminUserPage;
	FakerClass fakerClass;
	

	@Test(groups = "bug retest")
	public void verifyNewUserAdd() {
		loginPage = new LoginPage(driver);
		adminUserPage=new AdminUsersPage(driver);
		fakerClass=new FakerClass();
		loginPage.login();
		adminUserPage.clickOnAdminUser();
//		String userName="Siya"+ GeneralUtility.getTimeStammp();
		String userName=fakerClass.getRandomFirstName();
		Assert.assertTrue(adminUserPage.addNewUser(userName, "*****", "Partner"));
	}
}

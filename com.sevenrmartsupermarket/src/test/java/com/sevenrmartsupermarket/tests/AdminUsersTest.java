package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUsersTest extends Base {
	LoginPage loginPage;
	AdminUsersPage adminUserPage;
	

	@Test(groups = "bug retest")
	public void verifyNewUserAdd() {
		loginPage = new LoginPage(driver);
		adminUserPage=new AdminUsersPage(driver);
		loginPage.login();
		adminUserPage.clickOnAdminUser();
		String userName="Siya"+ GeneralUtility.getTimeStammp();
		
	}
}

package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageUsersPage;

public class ManageUsersTest extends Base {
	LoginPage loginpage;
	ManageUsersPage manageuserspage;

	@Test(groups = {"smoke","bug retest"})
	public void verifyStatusChangingButton() {
		loginpage = new LoginPage(driver);
		manageuserspage=new ManageUsersPage(driver);
		loginpage.login();
		manageuserspage.clickOnManageUsers();
		boolean status=manageuserspage.deactivateUser("Abhiramkrishnakumarsreenatest d");
		Assert.assertTrue(status);
	}
	@Test(groups = "regression")
	public void verifySearchUser() {
		loginpage = new LoginPage(driver);
		manageuserspage=new ManageUsersPage(driver);
		loginpage.login();
		manageuserspage.clickOnManageUsers();
		boolean status=manageuserspage.isSearchUserFound("Anandhu Prakash");
		Assert.assertTrue(status);
	}

}

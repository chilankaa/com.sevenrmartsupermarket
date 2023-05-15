package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageUsersPage;

public class ManageUsersTest extends Base {
	LoginPage loginpage;
	ManageUsersPage manageuserspage;

	@Test
	public void verifyStatusChangingButton() {
		loginpage = new LoginPage(driver);
		manageuserspage=new ManageUsersPage(driver);
		loginpage.login();
		manageuserspage.clickOnManageUsers();
		manageuserspage.deactivateUser("Abhiramkrishnakumarsreenatest d");
	}

}

package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageExpenseDropDownPage;

public class ManageExpenseDropDownTest extends Base {
	LoginPage loginPge;
	ManageExpenseDropDownPage manageExpenseDropdownPage;

	@Test
	public void visibilityOfCategory1() {
		loginPge = new LoginPage(driver);
		manageExpenseDropdownPage = new ManageExpenseDropDownPage(driver);
		loginPge.login();
		manageExpenseDropdownPage.clickOnManageExpenseDropdown();
		Assert.assertTrue(manageExpenseDropdownPage.displayOfExpenseCategoryElement());
	}
	@Test
	public void visibilityOfCategory2() {
		loginPge = new LoginPage(driver);
		manageExpenseDropdownPage = new ManageExpenseDropDownPage(driver);
		loginPge.login();
		manageExpenseDropdownPage.clickOnManageExpenseDropdown();
		Assert.assertTrue(manageExpenseDropdownPage.displayOfManageExpensecategory());
	}
	@Test
	public void visibilityOfCategory3() {
		loginPge = new LoginPage(driver);
		manageExpenseDropdownPage = new ManageExpenseDropDownPage(driver);
		loginPge.login();
		manageExpenseDropdownPage.clickOnManageExpenseDropdown();
		Assert.assertTrue(manageExpenseDropdownPage.displayOfECreateMerchantElement());
	}
}

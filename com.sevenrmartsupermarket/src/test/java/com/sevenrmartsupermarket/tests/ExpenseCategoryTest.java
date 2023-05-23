package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.ExpenseCategoryPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageExpenseDropDownPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ExpenseCategoryTest extends Base {
	LoginPage loginPge;
	ManageExpenseDropDownPage manageExpenseDropdownPage;
	ExpenseCategoryPage expenseCategoryPage;

	@Test
	public void verifyEditFunctionalityByBackspace() {
		loginPge = new LoginPage(driver);
		manageExpenseDropdownPage=new ManageExpenseDropDownPage(driver);
		expenseCategoryPage = new ExpenseCategoryPage(driver);
		loginPge.login();
		manageExpenseDropdownPage.clickOnManageExpenseDropdown();
		expenseCategoryPage.clickOnExpenseCategory();
		expenseCategoryPage.editDataBackspace("mysample0.569000137641104");
	}
	@Test
	public void verifyEditFunctionalityByAddingTimestamp() {
		loginPge = new LoginPage(driver);
		manageExpenseDropdownPage=new ManageExpenseDropDownPage(driver);
		expenseCategoryPage = new ExpenseCategoryPage(driver);
		loginPge.login();
		manageExpenseDropdownPage.clickOnManageExpenseDropdown();
		expenseCategoryPage.clickOnExpenseCategory();	
		boolean status=expenseCategoryPage.editDataTimestamp("sampleVMpN"+GeneralUtility.getTimeStammp());
		Assert.assertTrue(status);
	}
}

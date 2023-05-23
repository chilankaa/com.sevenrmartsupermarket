package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageExpenseDropDownPage {
	WebDriver driver;
	@FindBy(xpath = "//p[contains(text(),'Manage Expense')]//i[@class='fas fa-angle-left right']")
	WebElement manageExpenseDropdownElement;
	@FindBy(xpath = "//p[text()='Expense Category']")
	WebElement expenseCategoryElement;
	@FindBy(xpath = "//p[text()='Manage Expense']")
	WebElement manageExpenseCategory;
	@FindBy(xpath = "//p[text()='Create Merchant']")
	WebElement createMerchantElement;

	public ManageExpenseDropDownPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageExpenseDropdown() {
		manageExpenseDropdownElement.click();
	}

	public boolean displayOfExpenseCategoryElement() {
		expenseCategoryElement.click();
		GeneralUtility generalUtility=new GeneralUtility(driver);
		return generalUtility.is_Displayed(expenseCategoryElement);
		
	}
	public boolean displayOfManageExpensecategory() {
		manageExpenseCategory.click();
		GeneralUtility generalUtility=new GeneralUtility(driver);
		return generalUtility.is_Displayed(manageExpenseCategory);
		
	}
	public boolean displayOfECreateMerchantElement() {
		createMerchantElement.click();
		GeneralUtility generalUtility=new GeneralUtility(driver);
		return generalUtility.is_Displayed(createMerchantElement);
		
	}
}

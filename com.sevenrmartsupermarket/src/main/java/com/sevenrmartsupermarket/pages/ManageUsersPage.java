package com.sevenrmartsupermarket.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageUsersPage {
	WebDriver driver;
	@FindBy(xpath = "//p[text()='Manage Users']")
	WebElement manageUsers;
	@FindBy(xpath = "//table//tbody//tr//td[1]")
	List<WebElement> nameElements;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchUserElement;
	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement nameInSearchElement;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	WebElement searchingElement;
	@FindBy(xpath = "//table//tbody//tr[1]//td[1]")
	WebElement searchedName;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement statusChangingAlert;

	public ManageUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageUsers() {
		manageUsers.click();
	}

	public void clickOnSearch() {
		searchUserElement.click();
	}

	public boolean deactivateUser(String userName) {
		GeneralUtility generalutility = new GeneralUtility(driver);
		List<String> names = generalutility.getTextofElements(nameElements);
		int i = 0;
		for (i = 0; i < names.size(); i++) {
			if (names.get(i).equals(userName)) {
				i++;
				break;
			}
		}
		WebElement element = driver.findElement(By.xpath("//table//tbody//tr[" + i + "]//td[6]//i[1]"));
		PageUtility pageUtility = new PageUtility(driver);
		pageUtility.scrollAndClick(element);
		return generalutility.is_Displayed(statusChangingAlert);
	}

	public void searchUserByName(String name) {
		clickOnSearch();
		nameInSearchElement.sendKeys(name);
		searchingElement.click();
	}

	public boolean isSearchUserFound(String userName) {
		searchUserByName(userName);
		return userName.equals(searchedName.getText());
	}
}

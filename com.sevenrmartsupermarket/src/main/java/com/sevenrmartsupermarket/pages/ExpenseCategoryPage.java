package com.sevenrmartsupermarket.pages;

import java.awt.Desktop.Action;
import java.util.List;

import org.bouncycastle.pqc.jcajce.provider.lms.LMSSignatureSpi.generic;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ExpenseCategoryPage {
	WebDriver driver;

	@FindBy(xpath = "//p[text()='Expense Category']")
	WebElement expenseCategoryElement;
	@FindBy(xpath = "//table//tbody//tr//td[1]")
	List<WebElement> titleElements;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertElement;

	public ExpenseCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnExpenseCategory() {

		expenseCategoryElement.click();
	}

	public boolean editDataBackspace(String titleData) {
		GeneralUtility generalUtility = new GeneralUtility(driver);
		PageUtility pageUtility=new PageUtility(driver);
		clickOnExpenseCategory();
		List<String> titles = generalUtility.getTextofElements(titleElements);
		int i = 0;
		for (i = 0; i < titles.size(); i++) {
			if (titles.get(i).equals(titleData)) {
				i++;
				break;
			}
		}
		WebElement editData = driver
				.findElement(By.xpath("//table//tbody//tr[" + i + "]//td[2]//i[@class='fas fa-edit']"));
		pageUtility.scrollAndClick(editData);
		
		WebElement editTitle = driver.findElement(By.xpath("//input[@class='form-control' and @name='name']"));
		editTitle.sendKeys(Keys.BACK_SPACE);
		WebElement updateTitle = driver.findElement(By.xpath("//button[@type='submit' and @name='Update']"));
		updateTitle.click();
		return isUpdateAlertDisplayed();
	}
	public boolean editDataTimestamp(String titleData) {
		GeneralUtility generalUtility = new GeneralUtility(driver);
		PageUtility pageUtility=new PageUtility(driver);
		clickOnExpenseCategory();
		List<String> titles = generalUtility.getTextofElements(titleElements);
		int i = 0;
		for (i = 0; i < titles.size(); i++) {
			if (titles.get(i).equals(titleData)) {
				i++;
				break;
			}
		}
		WebElement editData = driver
				.findElement(By.xpath("//table//tbody//tr[" + i + "]//td[2]//i[@class='fas fa-edit']"));
		pageUtility.scrollAndClick(editData);
		
		WebElement editTitle = driver.findElement(By.xpath("//input[@class='form-control' and @name='name']"));
		editTitle.clear();
		editTitle.sendKeys(titleData);
		WebElement updateTitle = driver.findElement(By.xpath("//button[@type='submit' and @name='Update']"));
		updateTitle.click();
		return isUpdateAlertDisplayed();
	}
	public boolean isUpdateAlertDisplayed() {
		GeneralUtility generalUtility=new GeneralUtility(driver);
		return generalUtility.is_Displayed(alertElement);
	}
}

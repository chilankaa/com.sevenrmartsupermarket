package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class HomePage {
	WebDriver driver;
	GeneralUtility generalUtility;
	@FindBy(xpath = "//a[@class='d-block']")
	WebElement profileElement;
	@FindBy(xpath = "//p[text()='Push Notifications']")
	WebElement pushNotification;
	@FindBy(xpath = "//input[@placeholder='Enter Title']")
	WebElement enterTitle;
	@FindBy(xpath = "//input[@placeholder='Enter Description']")
	WebElement enterDescription;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement send;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement notficationSuccessAlert;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.getTextOfElement(profileElement);
	}

	public void clickOnPushNotification(String title, String description) {
		pushNotification.click();
		enterTitle(title);
		enterDescription(description);
		clickOnSend();
	}

	public void enterTitle(String title) {
		enterTitle.sendKeys(title);
	}

	public void enterDescription(String description) {
		enterDescription.sendKeys(description);
	}

	public void clickOnSend() {
		send.click();
	}

	public boolean isSuccessAlertPresent() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.is_Displayed(notficationSuccessAlert);

	}
}

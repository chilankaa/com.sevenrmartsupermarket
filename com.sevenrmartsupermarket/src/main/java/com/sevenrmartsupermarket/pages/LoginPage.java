package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginPage {
	WebDriver driver;
	Properties properties = new Properties();

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement userNameElement;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordElement;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signInButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream fileInput = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fileInput);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUserName(String userName) {
		userNameElement.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordElement.sendKeys(password);
	}

	public void clickOnSignInButton() {
		signInButton.click();
	}

	public void login() {
		String userNameValue = properties.getProperty("userName");
		String passwordValue = properties.getProperty("password");
		enterUserName(userNameValue);
		enterPassword(passwordValue);
		clickOnSignInButton();
	}

	public void login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}

	public boolean isErrorMessageDisplayed() {
		GeneralUtility generalUtility = new GeneralUtility(driver);
		return generalUtility.is_Displayed(errorMessage);
	}
	public boolean isLoginButtonTextAsExpected(String expected) {
		GeneralUtility generalUtility = new GeneralUtility(driver);
		return generalUtility.is_TextAsExpected(signInButton, expected);
	}
}

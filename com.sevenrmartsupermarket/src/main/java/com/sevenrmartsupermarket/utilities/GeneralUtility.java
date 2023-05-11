package com.sevenrmartsupermarket.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralUtility {
	WebDriver driver;

	public GeneralUtility(WebDriver driver) {
		this.driver = driver;
	}

	public String getTextOfElement(WebElement element) {
		return element.getText();
	}

	public boolean is_Selected(WebElement element) {
		return element.isSelected();
	}
	public boolean is_Displayed(WebElement element) {
		return element.isDisplayed();
	}
	public boolean is_TextAsExpected(WebElement element,String expectedText) {
		String text=element.getText();
		return text.equals(expectedText);
	}
}

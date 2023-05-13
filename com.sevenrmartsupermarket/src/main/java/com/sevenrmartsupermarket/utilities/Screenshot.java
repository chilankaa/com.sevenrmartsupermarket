package com.sevenrmartsupermarket.utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	TakesScreenshot takeScreenShot;

	public void takeScreenShot(WebDriver driver, String imageName) {
		try {
			takeScreenShot = (TakesScreenshot) driver;
			String path = System.getProperty("user.dir") + "//screenshots//" + imageName + ".png";
			File file = takeScreenShot.getScreenshotAs(OutputType.FILE);// here taking screenshot
			File destination = new File(path);
			FileHandler.copy(file, destination);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}

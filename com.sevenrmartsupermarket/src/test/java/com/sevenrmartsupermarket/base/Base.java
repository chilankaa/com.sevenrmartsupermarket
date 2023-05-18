package com.sevenrmartsupermarket.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.Screenshot;
import com.sevenrmartsupermarket.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	Properties properties = new Properties();
	Screenshot screenshot = new Screenshot();

	public Base() {
		try {
			FileInputStream fileInput = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fileInput);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initialise(String browser, String url) {
		if (browser.equals("chrome")) {
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(co);
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
	}

	@BeforeMethod(alwaysRun = true, enabled = true)
	public void launchBrowser() {
		String browserValue = properties.getProperty("browser");
		String urlValue = properties.getProperty("url");
		initialise(browserValue, urlValue);

	}

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true, enabled = false)
	public void launchBrowser(String browserValue) {
		String urlValue = properties.getProperty("url");
		initialise(browserValue, urlValue);
	}

	@AfterMethod(alwaysRun = true)
	public void terminateBrowser(ITestResult iTestResult) {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			screenshot.takeScreenShot(driver, iTestResult.getName());
		}
//		driver.quit();
	}
}

package com.gammax.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static com.gammax.constants.FrameworkConstants.BROWSER_CHROME;
import static com.gammax.constants.FrameworkConstants.BROWSER_FIREFOX;
import static com.gammax.constants.FrameworkConstants.BROWSER_SAFARI;
import static com.gammax.constants.FrameworkConstants.BROWSER_EDGE;

public class DriverFactory {

	public static WebDriver initializeDriver(String browser) {
		WebDriver driver;

		switch (browser) {

		case BROWSER_CHROME: {
			System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver_mac_arm64/chromedriver");
			driver = new ChromeDriver();
			break;
		}
		case BROWSER_FIREFOX: {
			driver = new FirefoxDriver();
			break;
		}
		case BROWSER_SAFARI: {
			driver = new SafariDriver();
			break;
		}
		case BROWSER_EDGE: {
			driver = new EdgeDriver();
			break;
		}
		default:
			throw new IllegalStateException("INVALID BROWSER: " + browser);
		}
		driver.manage().window().maximize();

		return driver;
	}
}

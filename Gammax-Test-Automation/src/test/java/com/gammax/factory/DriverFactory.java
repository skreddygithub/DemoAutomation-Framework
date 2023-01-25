package com.gammax.factory;

import com.gammax.constants.FrameworkConstants;
import com.gammax.hooks.MyHooks;
import com.gammax.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;

import static com.gammax.constants.FrameworkConstants.BROWSER_CHROME;
import static com.gammax.constants.FrameworkConstants.BROWSER_FIREFOX;
import static com.gammax.constants.FrameworkConstants.BROWSER_SAFARI;
import static com.gammax.constants.FrameworkConstants.BROWSER_EDGE;

public class DriverFactory {
	public static WebDriver driver;

	public static void initializeDriver(String browser) {
		switch (browser) {

		case BROWSER_CHROME: {
			System.out.println(System.getProperty("user.dir"));
//			ChromeOptions opt = new ChromeOptions();
//			opt.addExtensions(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extension_10_24_1_0.crx"));
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
		driver.get(ConfigLoader.getInstance().getBaseUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.IMPLICIT_WAIT));
		Assert.assertTrue(MyHooks.driver.getTitle().contains("Gammax"));
	}

	public static void quitDriver(){
		driver.quit();
	}
}

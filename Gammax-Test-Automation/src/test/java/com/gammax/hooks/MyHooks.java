
package com.gammax.hooks;

import com.gammax.factory.DriverFactory;
import com.gammax.utils.ConfigLoader;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.gammax.constants.FrameworkConstants.*;

public class MyHooks {

	public static WebDriver driver;

	@Before
	public void before(Scenario scenario) {

		System.out.println("BEFORE:" + "SCENARIO NAME: " + scenario.getName());
		driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER, BROWSER_CHROME));
		driver.get(ConfigLoader.getInstance().getBaseUrl());
		this.driver = driver;
	}

	@After
	public void after(Scenario scenario) {
		System.out.println("AFTER:" + "SCENARIO NAME: " + scenario.getName());

		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}

		driver.quit();
	}
}

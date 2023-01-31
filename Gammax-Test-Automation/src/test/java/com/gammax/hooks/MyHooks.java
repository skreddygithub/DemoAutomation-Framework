
package com.gammax.hooks;

import com.gammax.factory.DriverFactory;
import io.cucumber.java.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static com.gammax.constants.FrameworkConstants.*;

public class MyHooks extends DriverFactory{

	static Logger log= Logger.getLogger(MyHooks.class);
	public static Scenario scenario;
	@Before
	public void before(Scenario scenario) throws Exception{
		this.scenario = scenario;
		System.out.println("BEFORE:" + "SCENARIO NAME: " + scenario.getName());
		DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER, BROWSER_CHROME));
	}

	@After
	public void after(Scenario scenario) throws InterruptedException {
		System.out.println("AFTER:" + "SCENARIO NAME: " + scenario.getName());

		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		Thread.sleep(5000);
		DriverFactory.quitDriver();
	}
}

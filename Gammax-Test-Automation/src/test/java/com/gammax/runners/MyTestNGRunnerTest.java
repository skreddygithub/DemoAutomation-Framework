
package com.gammax.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		glue = {"com.gammax.stepdefinitions","com.gammax.hooks"},
		features = "src/test/resources/features")
public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests {

}

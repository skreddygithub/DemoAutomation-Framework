
package com.gammax.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
		plugin = { 
				"html:target/cucumber/cucumber.html" ,
				"me.jvt.cucumber.report.PrettyReports:target/cucumber/"
		},
		 glue = {"com.gammax.stepdefinitions","com.gammax.hooks"},
		features = "src/test/resources/features")
public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests {


}

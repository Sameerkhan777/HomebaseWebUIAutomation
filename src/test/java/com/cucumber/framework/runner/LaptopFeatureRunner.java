
package com.cucumber.framework.runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefile/Laptops.feature" }, glue = {
		"classpath:com.cucumber.framework.stepdefinition",
		"classpath:com.cucumber.framework.helper" }, plugin = { "pretty",
		"json:target/LaptopFeatureRunner.json" })
public class LaptopFeatureRunner extends AbstractTestNGCucumberTests {
}

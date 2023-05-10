package com.shop.frontend;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", plugin = {"pretty", "html:target/cucumber-reports", "json:target/Cucumber.json", "junit:target/cucumber.xml"})
//@CucumberOptions(features = "src/test/resources")
public class RunCucumberTest {
}
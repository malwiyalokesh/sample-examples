package com.sample.sample.cucumber;

/**
 * Created by Lokesh on 30-07-2017.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = "pretty", features = "src/test/resources/cucumber")
public class CucumberTest {

}

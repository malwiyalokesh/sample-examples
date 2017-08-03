package com.sample.sample.cucumber;

import com.sample.sample.SampleApplication;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;

/**
 * Created by Lokesh on 30-07-2017.
 */
@SpringBootTest(classes = SampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class CucumberTestSteps {

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> response;

    @Given("I call GET on (.*)")
    public void iCallGetOn(String url) {
        this.response = this.restTemplate.getForEntity(url, String.class, new HashMap<>());
    }

    @Then("^the response status is (\\d+)$")
    public void theResponseStatusIs(int status) throws Throwable {
        Assert.assertEquals(status, response.getStatusCode().value());
    }

    @And("^the response body must contain (.*) with (.*)$")
    public void theResponseBodyMustContainFieldWithValue(String field, String value) throws Throwable {
        //Assert.assertTrue(response.getBody().contains(field));
        Assert.assertEquals(value, response.getBody());
    }
}

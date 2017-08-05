package com.sample.sample.cucumber;

import com.sample.sample.model.Book;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lokesh on 04-08-2017.
 */
public class BooksStepDefs extends BaseStepDefs {

    private ResponseEntity<Book[]> response;

    @Given("^User calls GET on /books$")
    public void user_calls_GET_on_books() throws Throwable {
        response = testRestTemplate
                .getForEntity("/books" , Book[].class, (Map<String, ?>) new HashMap<String,Object>());
    }

    @Then("^the response status is (\\d+)$")
    public void theResponseStatusIs(int status) throws Throwable {
        Assert.assertEquals(status, response.getStatusCode().value());
    }

    @Then("^the number of books returned is (\\d+)$")
    public void the_number_of_books_returned_is(int arg1) throws Throwable {

        //Assert.assertEquals(response.getStatusCode(), HttpStatus.OK));
        Assert.assertEquals(3,response.getBody().length);
    }
}

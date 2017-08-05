package com.sample.sample.cucumber;

import com.sample.sample.SampleApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Lokesh on 04-08-2017.
 */
@ContextConfiguration
@SpringBootTest(classes = SampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class BaseStepDefs {

    @Autowired
    protected TestRestTemplate testRestTemplate;
}

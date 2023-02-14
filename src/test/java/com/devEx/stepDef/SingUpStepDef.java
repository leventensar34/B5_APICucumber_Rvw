package com.devEx.stepDef;


import com.devEx.request.DevExRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import static org.junit.Assert.*;


public class SingUpStepDef {

    Response response;

    @Given("User creates a POST request with {string} and {string} and {string} and {string} and {string} and {string}")
    public void user_creates_a_post_request_with_and_and_and_and_and(String email, String password, String name, String google, String facebook, String github) {
        response= DevExRequest.registerNewUser(email, password, name, google, facebook, github);
        response.prettyPrint();
    }

    @Then("Verify that body contains {string}")
    public void verify_that_body_contains(String token) {
       assertTrue(response.body().asString().contains(token));

    }

    @Then("Verify that status code should be {int}")
    public void verifyThatStatusCodeShouldBe(int expectedStatusCode) {
        assertEquals(expectedStatusCode,response.statusCode());
    }
}

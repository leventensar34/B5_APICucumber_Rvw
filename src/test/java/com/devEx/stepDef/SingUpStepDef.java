package com.devEx.stepDef;


import com.devEx.pages.LoginPage;
import com.devEx.request.DevExRequest;
import com.devEx.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import static org.junit.Assert.*;


public class SingUpStepDef {

    Response response;
    String token;

    int id;

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

    @And("Compiler gets the token")
    public void compilerGetsTheToken() {
         token=response.path("token");
        ConfigurationReader.set("newUserToken",token);
    }


    @Given("User creates a POST request and send the token with {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void userCreatesAPOSTRequestAndSendTheTokenWith(String company,String website,String location,String status,String skills,
                                                           String githubusername,String youtube,String twitter,String facebook,String linkedln,String instagram) {

        response=DevExRequest.postSaveProfile(company, website, location, status, skills, githubusername, youtube, twitter, facebook, linkedln, instagram);
    }

    @Then("Verify that name {string} andemail as {string}")
    public void verifyThatNameAndemailAs(String expectedName, String expectedEmail) {
        assertEquals(expectedName,response.path("user.name"));
        assertEquals(expectedEmail,response.path("user.email"));
    }

    @Given("User creates a POST request for add an experience with {string} {string} {string} {string} {string} {string} {string}")
    public void userCreatesAPOSTRequestForAddAnExperienceWith(String title,String company,String location,String from,String to,String current,String description) {

        response=DevExRequest.postExperience(title, company, location, from, to, current, description);
    }

    @And("Compiler gets the experience id")
    public void compilerGetsTheExperienceId() {
         id=response.path("experience.id[0]");
    }

    @And("User creates GET request to get experience with id")
    public void userCreatesGETRequestToGetExperienceWithId() {
        response=DevExRequest.getExperience(id);
    }

    @And("User is on the dashboard page")
    public void userIsOnTheDashboardPage() throws InterruptedException {

        new LoginPage().setup();
    }

    @Then("Verify that UI experience and API experience must be matched on company as {string}")
    public void verifyThatUIExperienceAndAPIExperienceMustBeMatchedOnCompanyAs(String expectedCompany) {
        //Experience From UI
        String actualCompanyFromUI=new LoginPage().getNewCompany(expectedCompany);

        //Experience From API
        String actualCompanyFromAPI=response.path("company");

        //Comparison of API and UI
        assertEquals(actualCompanyFromAPI,actualCompanyFromUI);
    }
}

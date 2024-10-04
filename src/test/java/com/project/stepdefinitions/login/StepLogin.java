package com.project.stepdefinitions.login;
import java.io.IOException;

import org.testng.Assert;

import com.project.pages.LoginPage;
import com.project.utils.DriverManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;;

public class StepLogin {

    LoginPage loginPage = new LoginPage(DriverManager.getDriver());


    @When("I launch the url")
    public void launchUrl() throws IOException{
        DriverManager.getDriver().get(DriverManager.getConfigProperty("url"));
    }

    @When("the user enters credentials")
        public void inputCredentials() {
            loginPage.inputCredentials("mindtrackers", "raghavgupta12345");

        }
    @When("the user clicks the login button")
        public void clickOnLoginButton() {
            loginPage.clickLoginButton();
        }


    @Then("the user should see the home page")
    public void theUserShouldSeeTheHomePage() {
        // Validation logic for successful login
        Assert.assertEquals(loginPage.verifyPageTitle(), "HackerRank");
    }

}

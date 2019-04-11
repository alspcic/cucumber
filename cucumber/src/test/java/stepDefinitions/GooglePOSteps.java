package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.AgePage;
import pages_sample.AgeSubmittedPage;
import pages_sample.GooglePage;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GooglePOSteps {
    private WebDriver driver;
    static GooglePage googlePage;
    static AgeSubmittedPage ageSubmittedPage;

    public GooglePOSteps() {
        this.driver = Hooks.driver;
        googlePage= PageFactory.initElements(Hooks.driver, GooglePage.class);
    }
    @When("^I am on Google homepage using PO$")
    public void iAmOnGoogleHomepage() throws Throwable {
        driver.get(googlePage.getPageUrl());
    }

    @Then("^I verify lucky button text using PO$")
    public void iVerifyLuckyButtonText() throws Throwable {

    }
    @And("^I found something using PO$")
    public void iFoundSomething() throws Throwable {
        googlePage.verifySearchResult();
    }

    @And("^I enter some text in searchbox using PO$")
    public void iEnterSomeTextInSearchbox() throws Throwable {
        googlePage.enterSomeText();
    }
}

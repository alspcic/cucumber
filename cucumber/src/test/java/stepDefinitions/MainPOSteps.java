package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.EnterNewPersonPage;
import pages_sample.GooglePage;
import pages_sample.KristinaPage;
import pages_sample.PeopleWithJobPage;

import java.util.List;
import java.util.Map;

public class MainPOSteps {
    private WebDriver driver;
    static GooglePage googlePage;
    static KristinaPage kristinaPage;
    static PeopleWithJobPage peopleWithJobPage;
    static EnterNewPersonPage enterNewPersonPage;

    public MainPOSteps() {
        this.driver = Hooks.driver;
        googlePage = PageFactory.initElements(Hooks.driver, GooglePage.class);
        kristinaPage = PageFactory.initElements(Hooks.driver, KristinaPage.class);
        peopleWithJobPage = PageFactory.initElements(Hooks.driver, PeopleWithJobPage.class);
        enterNewPersonPage = PageFactory.initElements(Hooks.driver, EnterNewPersonPage.class);
    }

    /***
     *  below are steps definition for Google web site
     * */

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


    /***
     *  below are steps definition for Kristina web site
     * */

    @Given("^I am on (enter a number|people with jobs) page using PO$")
    public void openKristinaPage(String menuItem) {
        driver.get(kristinaPage.getKristinaPageUrl(menuItem));
    }

    @When("^I enter \"([^\"]*)\" using PO$")
    public void iEnterNumber(String number) throws Throwable {
        kristinaPage.enterNumber(number);
    }


    @Then("^I see warning message: \"([^\"]*)\" using PO$")
    public void iSeeWarningMessage(String text) throws Throwable {
        kristinaPage.checkAllert(text);
    }

    @Then("^I check (valid|invalid) \"([^\"]*)\" using PO$")
    public void iCheckNumber(String statement, int number) throws Throwable {
        kristinaPage.numberValidation(statement, number);
    }




}
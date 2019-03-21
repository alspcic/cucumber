package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages_sample.*;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class TaskSteps {
    private WebDriver driver;
    static GoogleObjects googleObjects;

    public TaskSteps() {
        this.driver = Hooks.driver;
        googleObjects = PageFactory.initElements(Hooks.driver, GoogleObjects.class);
    }


    @When("^I am on Google homepage$")
    public void iAmOnGoogleHomepage() {
        driver.get("https://www.google.com/?hl=en");
    }

    @Then("^I verify lucky button text$")
    public void iVerifyLuckyButtonText() {
        assertEquals("I'm Feeling Lucky",
                googleObjects.luckybtn.getAttribute("value"));
    }

    @And("^I verify google search button text$")
    public void iVerifyGoogleSearchButton() {
        assertEquals("Google Search",
                googleObjects.searchbtn.getAttribute("value"));
    }

    @And("^I see Google image$")
    public void iSeeGoogleImage() {
        googleObjects.googlelogo.isDisplayed();
    }

    @And("^I enter some text in searchbox$")
    public void iEnterSomeTextInSearchbox() {
        googleObjects.searchinput.sendKeys("how to give up alcohol");
        googleObjects.searchbtn.click();
    }

    //=========== Root Square Task Steps ==========//


    @Given("^I go to square root calculation page$")
    public void iGoToSquareRootCalculationPage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @And("^I enter number: \"([^\"]*)\"$")
    public void iEnterNumber(String number) throws Throwable {
        googleObjects.inputnumber.sendKeys(number);
        throw new PendingException();
    }

    @And("^ I click the button$")
    public void iClickTheButton() {
        googleObjects.submitbtn.click();

    }

    @And("^I verify error: \"([^\"]*)\"$")
    public void iVerifyError(String arg0) throws Throwable {

        throw new PendingException();
    }


}



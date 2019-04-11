package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages_sample.GooglePage;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class hendSteps {
    private WebDriver driver;
    static GooglePage googlePage;

    public hendSteps() {
        this.driver = Hooks.driver;
        googlePage = PageFactory.initElements(Hooks.driver,GooglePage.class);
    }

    @Given("^I am on google page$")
    public void iAmOnGooglePage() throws Throwable {
       // driver.get("https://www.google.com");
        driver.get(googlePage.getPageUrl());
    }

    @When("^I verify Google search button text$")
    public void iVerifyGoogleSearchButtonText() throws Throwable {
//        assertEquals("Google meklēšana",
//                driver.findElement(By.name("btnK")).getAttribute("value"));
        googlePage.checkGoogleButtonText();
    }

    @And("^I verify google lucky button text$")
    public void iVerifyGoogleLuckyButtonText() throws Throwable {
//        assertEquals("Es ticu veiksmei!",
//                driver.findElement(By.name("btnI")).getAttribute("value"));
        googlePage.checkFeelingButtonText();
    }

    @Then("^I should see google image$")
    public void iShouldSeeGoogleImage() throws Throwable {
//        assertNotNull("image exists" ,
////                driver.findElement(By.id("hplogo")));
        googlePage.checkGoogleImageExists();
    }

    @Given("^I am on enter number page$")
    public void iAmOnEnterNumberPage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter age : \"([^\"]*)\"$")
    public void iEnterAge(String age) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(age);
    }

    @And("^click submit button$")
    public void clickSubmitButton() {
        driver.findElement(By.tagName("button")).click();
    }

    @Then("^I see a message: \"([^\"]*)\"$")
    public void iSeeAMessage(String message) throws Throwable {
       assertEquals( message ,driver.findElement(By.id("ch1_error")).getText());
    }
}

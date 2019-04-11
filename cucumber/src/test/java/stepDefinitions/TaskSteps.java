package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TaskSteps {
    private WebDriver driver;

    public TaskSteps() {
        this.driver = Hooks.driver;
    }

    @When("^I am on Google homepage$")
    public void iAmOnGoogleHomepage() {
        driver.get("https://www.google.com");
    }


    @Then("^I verify lucky button text$")
    public void iVerifyLuckyButtonText() {
        assertEquals("Es ticu veiksmei!", driver.findElement(By.name("btnI")).getAttribute("value"));

    }

    @And("^I enter some text in searchbox$")
    public void iEnterSomeTextInSearchbox() {
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("Lucky");

    }

    @And("^I found something$")
    public void iFoundSomething() {
        driver.findElement(By.name("btnK")).click();
        assertTrue(driver.findElement(By.id("resultStats")).getText().contains("Aptuveni 1 040 000 000 rezultāti "));
    }

    @Given("^I am on number page$")
    public void iAmOnNumberPage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");

    }

    @When("^I enter number: \"([^\"]*)\"$")
    public void iEnterNumber(String number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);

    }

    @And("^I click submit number$")
    public void iClickSubmitNumber() {
        driver.findElement(By.cssSelector(".w3-btn.w3-orange.w3-margin")).click();

    }

    @Then("^I see error message: \"([^\"]*)\"$")
    public void iSeeErrorMessage(String errorMessage) throws Throwable {
        assertEquals(errorMessage, driver.findElement(By.id("ch1_error")).getText());
    }
}

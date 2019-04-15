package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.NumberPage;

import static org.junit.Assert.*;

public class NumbersSteps {

    private WebDriver driver;
    private NumberPage page;

    public NumbersSteps() {
        this.driver = Hooks.driver;
        page = PageFactory.initElements(Hooks.driver, NumberPage.class);
    }

    @When("^I am on the numbers page$")
    public void iAmOnTheNumbersPage() {
        driver.get(page.getPageUrl());
    }

    @Then("^I see the number header$")
    public void iSeeTheNumberHeader() {
        assertTrue(page.checkNumberHeaderIsPresented());
    }

    @And("^I see text field for numbers$")
    public void iSeeTextFieldForNumbers() {
        assertTrue(page.checkInputFieldIsPresented());
    }

    @When("^I enter number (\\d+)$")
    public void iEnterNumberNumber(String number) {
        page.enterNumber(number);
    }

    @And("^I click button Submit$")
    public void iClickButtonSubmit() {
        page.clickSubmitButton();
    }

    @Then("^I see error message ([^\"]*)$")
    public void iSeeErrorMessageMessage(String message) {
        assertEquals(message, page.getErrorMessageText());
    }
}

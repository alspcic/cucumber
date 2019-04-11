package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages_sample.GooglePage;

public class GooglePOSteps {
    private WebDriver driver;
    static GooglePage googlePage;

    public GooglePOSteps() {
        this.driver = Hooks.driver;
        googlePage = PageFactory.initElements(Hooks.driver, GooglePage.class);

    }

    @When("^I am on Google homepage PO$")
    public void iAmOnGoogleHomepagePO() {
        driver.get(googlePage.getPageUrl());
    }

    @Then("^I verify lucky button text PO$")
    public void iVerifyLuckyButtonTextPO() {
        googlePage.checkButtonText("Es ticu veiksmei!");
    }

    @And("^I enter some \"([^\"]*)\" in searchbox PO$")
    public void iEnterSomeInSearchboxPO(String searchName) throws Throwable {
       googlePage.enterSearchText(searchName);
    }

    @And("^I found something PO$")
    public void iFoundSomethingPO() {
        googlePage.clickSearchBtn();
        googlePage.checkResultText("Aptuveni 1 040 000 000 rezultāti");
    }


}

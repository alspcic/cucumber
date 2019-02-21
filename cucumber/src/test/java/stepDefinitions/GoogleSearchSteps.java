package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import util.CommonUtil;

public class GoogleSearchSteps extends CommonUtil {

    @Given("^I am on Google page$")
    public void iAmOnGooglePage() {
        driver.get("https://www.google.com/");
    }

    @When("^I verify Google search button text$")
    public void iVerifyGoogleSearchButtonText() {
        Assert.assertTrue(googleMainPage.googleSearchBtn.isDisplayed());
    }

    @And("^I verify Google lucky button text$")
    public void iVerifyGoogleLuckyButtonText() {
        Assert.assertTrue(googleMainPage.googleLuckyBtn.isDisplayed());
    }

    @And("^I should see google image$")
    public void iShouldSeeGoogleImage() {
        Assert.assertTrue(googleMainPage.googleLogo.isDisplayed());


    }
}
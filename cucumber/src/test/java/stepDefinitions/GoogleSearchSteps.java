package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import util.BaseUtil;

public class GoogleSearchSteps extends BaseUtil {

    @Given("^I am on google PO page$")
    public void iAmOnGooglePage() {
        driver.get("https://www.google.com/");
    }


    @When("^I check google PO Search button text$")
    public void iCheckGooglePOSearchButtonText() {



    }
}
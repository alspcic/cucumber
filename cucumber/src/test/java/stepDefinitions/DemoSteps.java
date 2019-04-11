package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class DemoSteps {

    private WebDriver driver;


    public DemoSteps() {
        this.driver = Hooks.driver;
    }

    @When("^I verify Google Search button text$")
    public void iVerifyGoogleSearchButtonText() throws Throwable {
    }

    @And("^I verify google lucky button text$")
    public void iVerifyGoogleLuckyButtonText() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^i verify alert message$")
    public void iVerifyAlertMessage() throws Throwable {
        driver.switchTo().alert().getText();
    }
}

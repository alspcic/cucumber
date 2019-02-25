package stepDefinitions;

import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.GoogleMainPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoogleSteps {
    private static final String URL_GOOGLE_MAIN_PAGE = "https://www.google.com/";
    private static GoogleMainPage googleMainPage;
    private WebDriver driver;

    public GoogleSteps() {
        this.driver = Hooks.driver;
        googleMainPage = PageFactory.initElements(Hooks.driver, GoogleMainPage.class);
    }

    @When("^I am on the Google home page$")
    public void iAmOnTheGoogleHomePage() throws Throwable {
        driver.get(URL_GOOGLE_MAIN_PAGE);
    }

    @When("^I verify Search button text$")
    public void iVerifySearchButtonText() throws Throwable {
        assertEquals("Google meklēšana",
                googleMainPage.searchButtonText.getAttribute("value"));
    }

    @When("^I verify Lucky button text$")
    public void iVerifyLuckyButtonText() throws Throwable {
        assertEquals("Es ticu veiksmei!",
                googleMainPage.luckyButtonText.getAttribute("value"));
    }

    @When("^I verify Google picture presence$")
    public void iVerifyGooglePicturePresence() {
        assertTrue(googleMainPage.logo.isDisplayed());
    }
}

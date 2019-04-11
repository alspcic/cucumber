package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.AgeSubmittedPage;
import pages_sample.Task1PageObjectClass;

import static org.junit.Assert.assertEquals;

public class Task1Steps {
    private WebDriver driver;
    public static Task1PageObjectClass task1PageObjectClass;

    public Task1Steps() {
        this.driver = Hooks.driver;
        task1PageObjectClass = PageFactory.initElements(Hooks.driver, Task1PageObjectClass.class);
    }

    @When("^I navigate to '(.*)' page$")
    public void iNavigateToPage(String webPage) throws Throwable {
        driver.get(webPage);
    }

    @Then("^I see '(.*)' on the page$")
    public void iSeeGoogleSearchButtonOnThePage(String element) throws Throwable  {

        switch (element)
        {
            case "Google Search button":
                task1PageObjectClass.searchButton.isDisplayed();
                //task1PageObjectClass.isElementDisplayedSearch();
                assertEquals("Google meklēšana", task1PageObjectClass.searchButton.getAttribute("value"));
                break;

            case "Google Lucky button":
                task1PageObjectClass.luckyButton.isDisplayed();
                //task1PageObjectClass.isElementDisplayedLucky();
                assertEquals("Es ticu veiksmei!", task1PageObjectClass.luckyButton.getAttribute("value"));
                break;

            case "Google image":
                task1PageObjectClass.googleImage.isDisplayed();
                break;
        }
    }
}

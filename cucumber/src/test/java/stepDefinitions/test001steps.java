package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.GoogleSearchPage;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class test001steps {

    private WebDriver driver;
    static GoogleSearchPage gsp;

    public test001steps() {
        this.driver = Hooks.driver;
        gsp = PageFactory.initElements(Hooks.driver, GoogleSearchPage.class);
    }

    @When("^I am on Google homepage$")
    public void iAmOnGoogleHomepage() throws Throwable {
        driver.get("https://www.google.com/");
    }

    @Then("^I verify lucky button text$")
    public void iVerifyLuckyButtonText() throws Throwable {
        assertEquals("Es ticu veiksmei!", gsp.buttonIamHappy.getAttribute("value"));
    }

    @And("^I enter some text in searchbox$")
    public void iEnterSomeTextInSearchbox() throws Throwable {
            gsp.EnterSearcThext("search something");
    }

    @And("^I click search$")
    public void iClickSearch() throws Throwable {
        sleep(2000);
        gsp.ClickHappyButton();
    }

    @And("^I found something$")
    public void iFoundSomething() throws Throwable  {
        sleep(4000);
        assertTrue(gsp.resultStatus.isDisplayed());
        //assertTrue(gsp.resultStatus.getAttribute("innerText").toString().contains("Aptuveni 2"));
    }

    @Given("^I (?:am on|open) number page$")
    public void iAmOnNumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number: \"([^\"]*)\"$")
    public void iEnterNumber(String number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);
    }

    @And("^I click submit number$")
    public void iClickSubmitNumber() throws Throwable {
        driver.findElement(By.tagName("Button")).click();
    }

    @Then("^I see message about number: \"([^\"]*)\"$")
    public void iSeeMessageAboutNumber(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }

    @Then("^I see alert about number: \"([^\"]*)\"$")
    public void iSeeAlertAboutNumber(String message) throws Throwable {
        String aaa = driver.switchTo().alert().getText();
        assertEquals(message, aaa);
    }
}

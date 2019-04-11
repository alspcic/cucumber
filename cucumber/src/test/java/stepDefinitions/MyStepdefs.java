package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class MyStepdefs {

    private WebDriver driver;

    public MyStepdefs() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the google page$")
    public void iAmOnTheGooglePage() {
        driver.get("https://www.google.com");
    }

    @When("^I verify Google search button text$")
    public void iVerifyGoogleSearchButtonText() throws Throwable {
        assertEquals("Google meklēšana",
                driver.findElement(By.name("btnK")).getAttribute("value"));
    }

    @Given("^I am on enter number page$")
    public void iAmOnEnterNumberPage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }


    @And("^I click submit button$")
    public void iClickSubmitButton() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
    }


    @And("^I enter my number: (\\d+)$")
    public void iEnterMyNumberNumber(int number) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(number));
    }


    @And("^I verify lucky button$")
    public void iVerifyLuckyButton() {
        assertEquals("Es ticu veiksmei!",
                driver.findElement(By.name("btnI")).getAttribute("value"));
    }

    @Then("^I can see a Google image$")
    public void iCanSeeAGoogleImage() {
        int width = driver.findElement(By.tagName("img")).getSize().getWidth();
        int hight = driver.findElement(By.tagName("img")).getSize().getHeight();

        System.out.println(width + ">>>" + hight);
    }




    @And("^I enter my number: \"([^\"]*)\"$")
    public void iEnterMyNumber(int number) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(number));
    }



    //@Then("^I see error message: <message>$")
    //public void iSeeErrorMessageMessage() {

    //  assertEquals("message",
    //          driver.findElement(By.id("ch1_error")).getText());
   // }
    @Then("^I see error message: \"([^\"]*)\"$")
    public void iSeeErrorMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }




    }

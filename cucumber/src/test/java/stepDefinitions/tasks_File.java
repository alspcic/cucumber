package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages_sample.AgePage;
import pages_sample.AgeSubmittedPage;

import static org.junit.Assert.*;


public class tasks_File {
    private WebDriver driver;
    static AgePage agePage;
    static AgeSubmittedPage ageSubmittedPage;

    public tasks_File() {
        this.driver = Hooks.driver;
    }

    @When("^I am on Google homepage$")
    public void iAmOnGoogleHomepage() throws Throwable {
        driver.get("https://google.com");
    }

    @Then("^I verify lucky button text$")
    public void iVerifyLuckyButtonText() throws Throwable {
        assertEquals("Es ticu veiksmei!",
                driver.findElement(By.name("btnI")).getAttribute("value"));
    }

    @And("^I enter some text in searchbox$")
    public void iEnterSomeTextInSearchbox() throws Throwable {
        String someText = "some text";
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys(someText);
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
    }

    @And("^I found something$")
    public void iFoundSomething() throws Throwable {
        int empty = 0;
        int size = driver.findElements(By.className("srg")).size();
        assertNotEquals(size, empty);
    }

    @Given("^I am on enter a number page$")
    public void iAmOnEnterANumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter \"([^\"]*)\"$")
    public void iEnterNumber(String number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);

    }

    @And("^I click submit button$")
    public void iClickSubmitButton() throws Throwable {
        driver.findElement(By.cssSelector("[class = 'w3-btn w3-orange w3-margin']")).click();
    }

    @Then("^I see warning message: \"([^\"]*)\"$")
    public void iSeeWarningMessage(String text) throws Throwable {
        assertEquals(text, driver.findElement(By.id("ch1_error")).getText());

    }

    @Then("^I check (valid|invalid) \"([^\"]*)\"$")
    public void iCheckNumber(String statement, int number) throws Throwable {
        boolean condition = false;
        switch (statement) {
            case "invalid":
                if (number >= 101 || number <= 49)
                    condition = true;
                assertEquals(true, condition);
                break;
            case "valid":
                if (number <= 50 || number <= 100)
                    condition = true;
                assertEquals(true, condition);
                break;
            default:
                System.out.println("Check 'iEnterNumber' method");
        }
    }


    @Then("^I check sqrt value for \"([^\"]*)\"$")
    public void iCheckSqrtValueFor(int sqrt) throws Throwable {
        String alert[] = driver.switchTo().alert().getText().split(" ");
        String alertSqrt = alert[5];
        String refSqrt = String.valueOf(String.format("%.2f", Math.sqrt(sqrt)));
        assertTrue(refSqrt.equals(alertSqrt));
    }

}

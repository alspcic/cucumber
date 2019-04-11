package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sample2Steps {
    private WebDriver driver;

    public Sample2Steps()
    {
        this.driver = Hooks.driver;
    }


    @Given("^I am on number entered page$")
    public void iAmOnNumberEnteredPage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I see header page$")
    public void iSeeHeaderPage() {
        Assert.assertEquals("Enter a number", driver.findElement(By.cssSelector("h2")).getText());
    }

    @And("^I enter the number: \"([^\"]*)\"$")
    public void iEnterTheNumber(int number){
        driver.findElement(By.id("number")).sendKeys(String.valueOf(number));
    }

    @And("^I click button Submit$")
    public void iClickButtonSubmit() {
        driver.findElement(By.cssSelector("Submit")).click();
    }

}


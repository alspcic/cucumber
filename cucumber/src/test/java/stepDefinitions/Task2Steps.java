package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages_sample.Task1PageObjectClass;
import pages_sample.Task2PageObject;

import javax.naming.Context;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Task2Steps {
    private WebDriver driver;
    public static Task2PageObject task2PageObject;

    public Task2Steps() {
        this.driver = Hooks.driver;
        task2PageObject = PageFactory.initElements(Hooks.driver, Task2PageObject.class);
    }

    @Given("^I navigate to the \'([^\"]*)\' page$")
    public void iNavigateToThePage(String webPage) throws Throwable {
        driver.get(webPage);
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @And("^I see '(.*)' on the Krisinec page$")
    public void iSeePageTitleOnTheKrisinecPage(String element) {
        WebElement elementUi = null;

        switch (element)
        {
            case "This is a home page":
                elementUi = task2PageObject.pageTitle;
                break;

            case "Tasks":
                elementUi = task2PageObject.taskToolbar;
                break;

            case "Enter a number":
                elementUi = task2PageObject.enterNumberTitle;
                break;

            case "Submit":
                elementUi = task2PageObject.submitButton;
                break;
        }

        elementUi.isDisplayed();
        assertEquals(element, elementUi.getText());
    }

    @When("^I click on '(.*)' on the Krisinec page$")
    public void iClickOnTaskToolbarOnTheKrisinecPage(String element) {
        WebElement elementUi = null;

        switch (element)
        {
            case "Tasks":
                elementUi = task2PageObject.taskToolbar;
                break;

            case "Submit":
                elementUi = task2PageObject.submitButton;
                break;
        }

        elementUi.isDisplayed();
        elementUi.click();
    }

    @And("^I select '(.*)' option from the '(.*)' menu on the Krisinec page$")
    public void iSelectEnterANumberOptionFromTheTaskToolbarMenuOnTheKrisinecPage(String option, String elementMenu) {

        WebElement elementUi = null;

        switch (elementMenu)
        {
            case "Task toolbar":
                elementUi = driver.findElement(By.xpath("//a[text()='" + option + "']"));
                break;
        }

        elementUi.click();
    }

    @Then("^I see '(.*)' error on the Krisinec page$")
    public void iSeeErrorExpectedErrorOnTheKrisinecPage(String expectedError) {
        WebElement elementUi = task2PageObject.enterNumberErrorContainer;
        String actualError = elementUi.getText();

        elementUi.isDisplayed();
        assertEquals(expectedError, actualError);
    }

    @When("^I enter '(.*)' on the Krisinec page$")
    public void iEnterTextEnteredOnTheKrisinecPage(String textToEnter) {
        WebElement elementUi = task2PageObject.enterNumberTextField;

        elementUi.isDisplayed();
        elementUi.clear();
        elementUi.sendKeys(textToEnter);
    }

    @Then("^I do not see error on the Krisinec page$")
    public void iDoNotSeeErrorOnTheKrisinecPage() {
        assertFalse(task2PageObject.enterNumberErrorContainer.isDisplayed());
    }

    @Then("^I see correctly calculated square root for entered '(.*)' on the Krisinec page$")
    public void iSeeCorrectlyCalculatedSquareRootOnTheKrisinecPage(String number) throws InterruptedException {
        Thread.sleep(1000);

        String alertText = driver.switchTo().alert().getText();

        String root = String.format("%.2f", Math.sqrt(Double.parseDouble(number)));
        String message = "Square root of " + number + " is " + root;
        assertEquals(message, alertText);
    }
}

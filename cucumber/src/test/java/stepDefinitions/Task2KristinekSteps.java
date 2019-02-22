package stepDefinitions;

import Pages.Kristinek.KristinekMainPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.BaseUtil;

public class Task2KristinekSteps extends BaseUtil {


    public int number;
    public String forCompare;

    @Given("^I go to \"([^\"]*)\"$")
    public void iGoTo(String tff) {
        driver.get("https://"+tff);
    }


    @And("^I enter number: (.*)$")
    public void iEnterNumber(int arg0) {
        kristinekMainPage.numberInputField.sendKeys(String.valueOf(arg0));
        number = arg0;
    }

    @And("^I click the button$")
    public void iClickTheButton() {
        kristinekMainPage.submitBtn.click();
    }


    @And("^I verify error \"([^\"]*)\"$")
    public void iVerifyError(String arg0) {
        String Actualtext = kristinekMainPage.errorMsg.getText();
        Assert.assertEquals(arg0, Actualtext);
    }



    @And("^I check this number according to the rules$")
    public void iCheckThisNumberAccordingToTheRules() {
        if ((number >= 50) && (number <= 100)) {
            double sqrt = Math.sqrt(number);
            String formatted = String.format("%4.2f", sqrt);
            forCompare = ("Square root of " + number
                    + " is " + formatted);
            System.out.println("| Number " + number + " is in range from 50 to 100");
        } else {
            throw new RuntimeException("| Number " + number + " is not in range from 50 to 100");
        }
    }

    @Then("^I see popup message$")
    public void iSeePopupMessage() {
        String alert = driver.switchTo().alert().getText();
        System.out.println("| Alert message is : " + alert + " |");
        Assert.assertTrue(alert.equals(forCompare));

    }

    @And("^Pause$")
    public void pause() {
       iPause();
    }
}
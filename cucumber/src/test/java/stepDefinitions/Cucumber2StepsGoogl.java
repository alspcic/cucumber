package stepDefinitions;

import Pages.Google.PO2Google;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Cucumber2StepsGoogl {
        private WebDriver driver;
    static PO2Google PO2Google;

    public Cucumber2StepsGoogl() {
        this.driver = Hooks.driver;
        PO2Google = PageFactory.initElements(Hooks.driver, PO2Google.class);
    }


    @Given("^I am on googl page$")
    public void iAmOnGooglPage() {
        driver.get("https://www.google.com/");
    }

    @When("^I check googl Search button text$")
    public void iCheckGooglSearchButtonText() {
        PO2Google.iVerifyText();
    }

    @And("^I check google lucky button text$")
    public void iCheckGoogleLuckyButtonText() {
        String Actual = driver.findElement(By.cssSelector(".FPdoLc [name=btnI]")).getAttribute("value");
        Assert.assertEquals("Es ticu veiksmei!",Actual);
    }


    @And("^I should see googl image$")
    public void iShouldSeeGooglImage() {
        Assert.assertTrue(driver.findElement(By.id("hplogo")).isDisplayed());
    }
}


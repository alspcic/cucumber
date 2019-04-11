package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.GoogleHomePage;

import static org.junit.Assert.*;

public class GoogleSteps {
    private WebDriver driver;
    static GoogleHomePage googlePage;

    public GoogleSteps() {
        this.driver = Hooks.driver;
        googlePage = PageFactory.initElements(Hooks.driver, GoogleHomePage.class);
    }

    @When("^I am on Google homepage$")
    public void iAmOnGoogleHomepage() {
//        driver.get("https://www.google.com/");
        driver.get(googlePage.getPageUrl());
    }

    @Then("^I verify lucky button text$")
    public void iVerifyLuckyButtonText() {
        assertEquals("Es ticu veiksmei!", googlePage.getLuckyButtonText());
//        assertEquals("Es ticu veiksmei!",
//            driver.findElement(By.xpath("//div[contains(@class, 'FPdoLc')]//input[@name='btnI']")).getAttribute("value"));
    }

    @And("^I enter some text in searchbox$")
    public void iEnterSomeTextInSearchbox() {
        googlePage.enterSearchText("Any text");
    }

    @And("^I found something$")
    public void iFoundSomething() {
        driver.findElement(By.xpath("//div[contains(@class, 'VlcLAe')]//input[@name='btnK']")).click();
        //googlePage.clickSubmitButton();
    }
}

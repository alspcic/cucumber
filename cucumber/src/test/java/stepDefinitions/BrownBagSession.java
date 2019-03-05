package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class BrownBagSession {
    private WebDriver driver;

    public BrownBagSession() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on Google page$")
    public void iAmOnGooglePage() {
        driver.get("https://www.google.com/?hl=lv");
    }

    @When("^I verify search button text$")
    public void iVerifySearchButtonText() {
        //<input value="Google meklēšana" aria-label="Google meklēšana" name="btnK" type="submit">
        assertEquals("Google meklēšana", driver.findElement(By.name("btnK")).getAttribute("aria-label"));
    }

    @And("^I verify lucky button text$")
    public void iVerifyLuckyButtonText() {
        //<input value="Es ticu veiksmei!" aria-label="Es ticu veiksmei!" name="btnI" type="submit" jsaction="sf.lck">
        assertEquals("Es ticu veiksmei!", driver.findElement(By.name("btnI")).getAttribute("aria-label"));
    }

    @And("^I should see google image$")
    public void iShouldSeeGoogleImage() {
        //id="hplogo"
        assertNotNull(driver.findElements(By.id("hplogo")));
    }
}

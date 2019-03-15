package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class MySteps {
    private WebDriver driver;

    public MySteps() {this.driver = Hooks.driver;}

    @Given("^I am on Google page$")
    public void iAmOnGooglePage() {
        driver.get("https://www.google.com");
    }

    @And("^I verify Google Search button text$")
    public void iVerifyGoogleSearchButtonText() {
        assertEquals("Google meklēšana",driver.findElement(By.xpath("//*[@name='btnK']")).getAttribute("value"));
    }

    @And("^I verify Google Lucky button text$")
    public void iVerifyGoogleLuckyButtonText() {
        assertEquals("Es ticu veiksmei!",driver.findElement(By.xpath("//*[@name='btnI']")).getAttribute("value"));
    }

    @And("^I see Google image$")
    public void iSeeGoogleImage() {
        assertEquals("", driver.findElement(By.id("hplogo")).getText());
    }

    @When("^I enter text: \"([^\"]*)\"$")
    public void iEnterText(String TextToEnter) {
        driver.findElement(By.className("gLFyf")).sendKeys(TextToEnter);
    }

    @And("^I click enter$")
    public void iClickEnter() {
        driver.findElement(By.xpath("//*[@name='btnK'][1]")).click();
    }

    @Then("^I should see: \"([^\"]*)\"$")
    public void iShouldSee(String arg0) {
        assertEquals(arg0, driver.findElement(By.className("LC20lb")).getText());
    }

    @Given("^I go to Task Webpage$")
    public void iGoToTaskPage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        assertEquals("https://kristinek.github.io/site/tasks/enter_a_number", driver.getCurrentUrl());
    }

    @When("^I enter number: \"(.*)\"$")
    public void iEnterNumberNumber(String arg0) {
        String number = String.valueOf(arg0);
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);
    }

    @And("^I click the button$")
    public void iClickTheButton() {
        driver.findElement(By.xpath("//*[@type='button']")).click();
    }

    private boolean alertIsPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 1);
            return wait.until(ExpectedConditions.alertIsPresent()) != null;
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Then("^I verify message: \"(.*)\"$")
    public void iVerifyMessageMessage(String text) {
        if (alertIsPresent()) {
            Alert alert = driver.switchTo().alert();
            assertEquals(text, alert.getText());
            alert.accept();
        } else {
            assertEquals(text, driver.findElement(By.id("ch1_error")).getText());
        }
    }

    @Given("^I go to Task Create People page$")
    public void i_go_to_Task_Create_People_page() {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }

    @Given("^I reset the person list$")
    public void i_reset_the_person_list() {
        driver.findElement(By.xpath("//*[contains(text(),'Reset List')]")).click();
    }

    @Given("^I click add person button$")
    public void i_click_add_person_button() {
        driver.findElement(By.xpath("//*[contains(text(),'Add person')]")).click();
    }

    @When("^I enter new person info:$")
    public void I_enter_new_person_info(Map<String, String> valuesToEnter) {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
        }
    }

    @When("^I click add button$")
    public void i_click_add_button() {
        driver.findElement(By.id("modal_button")).click();
    }

    @Then("^I see a person added to the list: \"([^\"]*)\"$")
    public void i_see_a_person_added_to_the_list(String name) {
        assertEquals(name, driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]")).getText());
    }
}

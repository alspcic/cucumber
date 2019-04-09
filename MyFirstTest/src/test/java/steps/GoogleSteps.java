package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleSteps {

WebDriver driver = new ChromeDriver();

    @Given("^I open google page$")
    public void iOpenGooglePage() {
 driver.get("http://google.com");
 driver.manage().window().maximize();}


    @When("^I enter to search feild \"([^\"]*)\"$")
    public void iEnterToSearchFeild(String vkcom) {
        driver.findElement(By.name("q")).sendKeys(vkcom);
    }


    @Then("^I press search button$")
    public void iPressSearchButton() {
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.quit();
    }
}





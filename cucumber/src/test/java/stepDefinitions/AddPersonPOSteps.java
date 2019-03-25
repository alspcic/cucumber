package stepDefinitions;



import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.AddPersonPage;

import java.util.List;

public class AddPersonPOSteps {
    private WebDriver driver;
    static AddPersonPage addPersonPage;

    public AddPersonPOSteps(){
        this.driver=Hooks.driver;
        addPersonPage= PageFactory.initElements(Hooks.driver,AddPersonPage.class);
    }

    @And("^I enter the name: \"([^\"]*)\" and surname: \"([^\"]*)\"$")
    public void iEnterTheNameAndSurname(String name, String surname) throws Throwable {
        addPersonPage.enterName(name);
        addPersonPage.enterSurname(surname);
    }

    @And("^I enter the job: \"([^\"]*)\" and date of birth: \"([^\"]*)\"$")
    public void iEnterTheJobAndDateOfBirth(String job, String dob) throws Throwable {
        addPersonPage.enterJob(job);
        addPersonPage.enterDOBValue(dob);
    }

    @Then("^I select the gender \"([^\"]*)\"$")
    public void iSelectTheGender(String genderVal) throws Throwable {
        addPersonPage.selectGender(genderVal);
    }

    @And("^I select specific languages$")
    public void iSelectSpecificLanguages(List<String> langValues) throws Throwable {
        for(String values:langValues){
            driver.findElement(By.id(values)).click();
        }
    }

    @When("^I click on add button$")
    public void iClickOnAddButton() throws Throwable {
      addPersonPage.clickAddBtn();
    }
}

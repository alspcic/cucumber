package stepDefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.AddPeoplePage;
import pages_sample.ListOfPeoplePage;

import java.util.Map;


public class PeoplePOSteps {
    private WebDriver driver;
    static ListOfPeoplePage listOfPeoplePage;
    static AddPeoplePage addPeoplePage;

    public PeoplePOSteps() {
        this.driver = Hooks.driver;
        addPeoplePage = PageFactory.initElements(Hooks.driver, AddPeoplePage.class);
        listOfPeoplePage = PageFactory.initElements(Hooks.driver, ListOfPeoplePage.class);

    }
    @Given("^I am on people page$")
    public void iAmOnPeoplePage() {
        driver.get(listOfPeoplePage.getPageUrl());
    }


    @When("^I click add new person$")
    public void iClickAddNewPerson() {
        listOfPeoplePage.clickAddBtn();
    }

    @And("^I fill all fields and languages:$")
    public void iFillAllFieldsAndLanguages(Map<String, String> valuesToEnter) throws InterruptedException {
        addPeoplePage.enterName("Peter");
        addPeoplePage.enterSurname("Tester");
        addPeoplePage.enterJob("Carpenter");
        addPeoplePage.enterDOB("04/04/1975");
        addPeoplePage.clearEnglish(driver);
        addPeoplePage.clickLanguages(valuesToEnter.get("language1"));
        addPeoplePage.clickLanguages(valuesToEnter.get("language2"));
        addPeoplePage.chooseGender(valuesToEnter.get("gender"));
        addPeoplePage.chooseEmploymentStatus("Employee");
    }

    @And("^I save user$")
    public void iSaveUser() {
        addPeoplePage.clickAddPeople();

    }

    @Then("^I verify that amount of user is now 4")
    public void iVerifyThatAmountOfUserIsNow() {
        listOfPeoplePage.checkFourthPerson();
    }

    @And("^I delete last created user$")
    public void iDeleteLastCreatedUser() {
        listOfPeoplePage.deletePeople();

    }
}

package stepDefinitions;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.PeopleListPage;

import static org.junit.Assert.*;

public class PeopleListPOSteps {

    private WebDriver driver;
    static PeopleListPage peopleListPage;

    public PeopleListPOSteps(){
        this.driver=Hooks.driver;
        peopleListPage= PageFactory.initElements(Hooks.driver,PeopleListPage.class);
    }

    @Given("^User is on the person list page$")
    public void userIsOnThePersonListPage() throws Throwable {
        driver.get(peopleListPage.getPeopleListPageUrl());
        peopleListPage.checkListOfPeopleDisplayed();
    }

    @Then("^I click on add person button$")
    public void iClickOnAddPersonButton() throws Throwable {
        peopleListPage.clickAddNewPersonBtn();
    }

    @Then("^I see the newly added user \"([^\"]*)\" in the list$")
    public void iSeeTheNewlyAddedUserInTheList(String name) throws Throwable {
      assertTrue(peopleListPage.isPersonAdded(name));
    }
}

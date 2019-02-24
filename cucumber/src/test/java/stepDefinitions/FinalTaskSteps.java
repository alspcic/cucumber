package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages_sample.AddPersonPage;
import pages_sample.PeopleWithJobsPage;


import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FinalTaskSteps {
    private WebDriver driver;
    static PeopleWithJobsPage peopleWithJobsPage;
    static AddPersonPage addPersonPage;

    public FinalTaskSteps() {
        this.driver = Hooks.driver;
        peopleWithJobsPage = PageFactory.initElements(Hooks.driver, PeopleWithJobsPage.class);
        addPersonPage = PageFactory.initElements(Hooks.driver, AddPersonPage.class);

    }

    @Given("^I am on List of People page$")
    public void iAmOnListOfPeoplePage() throws Throwable {
        driver.get(peopleWithJobsPage.getPageUrl());
    }

    @When("^I click Reset List$")
    public void iClickResetList() throws Throwable {
        peopleWithJobsPage.clickResetList();
    }

    @And("^I click Add person button$")
    public void iClickAddPerson() throws Throwable {
        peopleWithJobsPage.clickAddPerson();
    }

    @And("^I enter name in name field: \"([^\"]*)\"$")
    public void iEnterNameInNameField(String name) throws Throwable {
        addPersonPage.nameField(name);
    }

    @When("^I enter surname in surname field: \"([^\"]*)\"$")
    public void iEnterSurnameInSurnameField(String surname) throws Throwable {
        addPersonPage.surnameField(surname);
    }

    @And("^I enter job in field: \"([^\"]*)\"$")
    public void iEnterJobInField(String job) throws Throwable {
        addPersonPage.jobField(job);
    }

    @When("^I enter date of birth: \"([^\"]*)\"$")
    public void iEnterDateOfBirth(String dob) throws Throwable {
        addPersonPage.dObField(dob);
    }

    @When("^I click on languages checkboxes:$")
    public void iClickOnLanguagesCheckboxes(List<String> languages) throws Throwable {
        for (String language : languages) {
            addPersonPage.clickLanguageCheckbox(language);
        }
    }

    @And("^I select \"([^\"]*)\"$")
    public void iSelectGender(String gender) throws Throwable {
        addPersonPage.selectGender(gender);
    }

    @And("^I select employee status \"([^\"]*)\"$")
    public void iSelectEmployeeStatus(String status) throws Throwable {
        addPersonPage.employeeStatus(status);
    }

    @And("^I click Add button$")
    public void iClickAddButton() throws Throwable {
        addPersonPage.addButton();
    }

    @Then("^A new person \"([^\"]*)\" \"([^\"]*)\" with job \"([^\"]*)\" and status \"([^\"]*)\" of gender \"([^\"]*)\" which is born \"([^\"]*)\" is added$")
    public void aNewPersonWithNameIsAdded(
            String name,
            String surname,
            String job,
            String status,
            String gender,
            String dob
    ) throws Throwable {
        assertEquals(name, peopleWithJobsPage.name());
        assertEquals(surname, peopleWithJobsPage.surname());
        assertEquals(job, peopleWithJobsPage.job());
        assertEquals(status, peopleWithJobsPage.status());
        assertEquals(gender, peopleWithJobsPage.gender());
        assertEquals(dob, peopleWithJobsPage.dob());
    }
}

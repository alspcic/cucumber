package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages_sample.addNewPage;
import pages_sample.overviewPage;

import java.util.Map;

import java.util.List;

import static org.junit.Assert.*;

public class secondHomeworkSteps {
    private WebDriver driver;
    static overviewPage OverviewPage;
    static addNewPage AddNewPage;

    public secondHomeworkSteps() {
        this.driver = Hooks.driver;
        OverviewPage = PageFactory.initElements(Hooks.driver, overviewPage.class);
        AddNewPage = PageFactory.initElements(Hooks.driver, addNewPage.class);
    }

    @Given("^I am on overview page$")
    public void iAmOnOverviewPage() throws Throwable {
        driver.get(OverviewPage.getPageUrl());
    }

    @When("^I press Reset List button$")
    public void iPressResetListButton() throws Throwable {
        OverviewPage.resetList();
    }

    @And("^I press Add Person button$")
    public void iPressAddPersonButton() throws Throwable {
        OverviewPage.addNewPerson();
    }

    @And("^I enter parameters:$")
    public void iEnterParameters(Map<String, String> parametersToEnter) throws Throwable {
        AddNewPage.nameField(parametersToEnter.get("name"));
        AddNewPage.surnameField(parametersToEnter.get("surname"));
        AddNewPage.jobField(parametersToEnter.get("job"));
        AddNewPage.dateOfBirthField(parametersToEnter.get("dateOfBirth"));
    }

    @And("^I select multiple languages:$")
    public void iSelectMultipleLanguages(List<String> languages) {
        for (String language : languages) {
            AddNewPage.selectLanguage(language);
        }
    }

    @And("^I choose value for gender: \"([^\"]*)\"$")
    public void iChooseValueForGender(String gender) throws Throwable {
        AddNewPage.selectGender(gender);
        //throw new PendingException();
    }

    @And("^I choose value for status: \"([^\"]*)\"$")
    public void iChooseValueForStatus(String employeeStatus) throws Throwable {
        AddNewPage.chooseStatus(employeeStatus);
        //throw new PendingException();
    }

    @And("^I click on a Add button$")
    public void iClickOnAAddButton() {
        AddNewPage.addButton();
    }

    @Then("^I validate \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iValidate(
            String name,
            String surname,
            String job,
            String dateOfBirth,
            String employeeStatus
    ) throws Throwable {
        assertEquals(name, OverviewPage.getName());
        assertEquals(surname, OverviewPage.getSurname());
        assertEquals(job, OverviewPage.getJob());
        assertEquals(dateOfBirth, OverviewPage.getDateOfBirth());
        assertEquals(employeeStatus, OverviewPage.getEmployeeStatus());

//        throw new PendingException();
    }
}

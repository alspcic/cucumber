package stepDefinitions;

//import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.addNewPage;
import pages_sample.overviewPage;
import java.util.List;
import static org.junit.Assert.*;

public class homeworkSteps {
    private WebDriver driver;
    static overviewPage OverviewPage;
    static addNewPage AddNewPage;

    public homeworkSteps() {
        this.driver = Hooks.driver;
        OverviewPage = PageFactory.initElements(Hooks.driver, overviewPage.class);
        AddNewPage = PageFactory.initElements(Hooks.driver, addNewPage.class);
    }

    @Given("^I am on the overview page$")
    public void iAmOnTheOverviewPage() throws Throwable {
        driver.get(OverviewPage.getPageUrl());
    }

    @When("^I press on Reset List button$")
    public void iPressOnResetListButton() throws Throwable {
        OverviewPage.resetList();
    }

    @And("^I press on Add Person button$")
    public void iPressOnAddPersonButton() throws Throwable {
        OverviewPage.addNewPerson();
    }

    @And("^I enter persons name: \"([^\"]*)\"$")
    public void iEnterPersonsName(String name) throws Throwable {
        AddNewPage.nameField(name);
        // throw new PendingException();
    }

    @And("^I enter persons surname: \"([^\"]*)\"$")
    public void iEnterPersonsSurname(String surname) throws Throwable {
        AddNewPage.surnameField(surname);
        // throw new PendingException();
    }

    @And("^I enter persons job: \"([^\"]*)\"$")
    public void iEnterPersonsJob(String job) throws Throwable {
        AddNewPage.jobField(job);
        // throw new PendingException();
    }

    @And("^I enter persons date of birth: \"([^\"]*)\"$")
    public void iEnterPersonsDateOfBirth(String dateOfBirth) throws Throwable {
        AddNewPage.dateOfBirthField(dateOfBirth);
        // throw new PendingException();
    }

    @And("^I select languages:$")
    public void iSelectLanguages(List<String> languages) {
        for (String language : languages) {
            AddNewPage.selectLanguage(language);
        }
    }

    @And("^I select gender: \"([^\"]*)\"$")
    public void iSelectGender(String gender) throws Throwable {
        AddNewPage.selectGender(gender);
        // throw new PendingException();
    }

    @And("^I choose status: \"([^\"]*)\"$")
    public void iChooseStatus(String employeeStatus) throws Throwable {
        AddNewPage.chooseStatus(employeeStatus);
        // throw new PendingException();
    }

    @And("^I click on Add button$")
    public void iClickOnAddButton() {
        AddNewPage.addButton();
    }

//    @Then("^I validate the person added \"([^\"]*)\" \"([^\"]*)\" Job: \"([^\"]*)\" Date of birth: \"([^\"]*)\" Knows languages: \"([^\"]*)\" Gender: \"([^\"]*)\" Employee status: \"([^\"]*)\"$")
//    public void iValidateThePersonAddedJobDateOfBirthKnowsLanguagesGenderEmployeeStatus(
//            String name,
//            String surname,
//            String job,
//            String dateOfBirth,
//            String language,
//            String gender,
//            String employeeStatus
//    ) throws Throwable {
//        assertEquals(name, OverviewPage.getName());
//        assertEquals(surname, OverviewPage.getSurname());
//        assertEquals(job, OverviewPage.getJob());
//        assertEquals(language, OverviewPage.getLanguage());
//        assertEquals(dateOfBirth, OverviewPage.getDateOfBirth());
//        assertEquals(gender, OverviewPage.getGender());
//        assertEquals(employeeStatus, OverviewPage.getEmployeeStatus());
////        throw new PendingException();
//    }

//    @Then("^I validate the person added \"([^\"]*)\" \"([^\"]*)\" Job: \"([^\"]*)\" Date of birth: \"([^\"]*)\" Gender: \"([^\"]*)\" Employee status: \"([^\"]*)\"$")
//    public void iValidateThePersonAddedJobDateOfBirthKnowsLanguagesGenderEmployeeStatus(
//            String name,
//            String surname,
//            String job,
//            String dateOfBirth,
//            String gender,
//            String employeeStatus
//    ) throws Throwable {
//        assertEquals(name, OverviewPage.getName());
//        assertEquals(surname, OverviewPage.getSurname());
//        assertEquals(job, OverviewPage.getJob());
//        assertEquals(dateOfBirth, OverviewPage.getDateOfBirth());
//        assertEquals(gender, OverviewPage.getGender());
//        assertEquals(employeeStatus, OverviewPage.getEmployeeStatus());
////        throw new PendingException();
//    }

    @Then("^I validate the person added \"([^\"]*)\" \"([^\"]*)\" Job: \"([^\"]*)\" Date of birth: \"([^\"]*)\" Employee status: \"([^\"]*)\"$")
    public void iValidateThePersonAddedJobDateOfBirthKnowsLanguagesGenderEmployeeStatus(
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

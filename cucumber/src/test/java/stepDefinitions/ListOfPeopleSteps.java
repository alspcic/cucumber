package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages_sample.ListOfPeople;

import java.util.ArrayList;
import java.util.List;


public class ListOfPeopleSteps {

    private static final String URL_PEOPLE_WITH_JOBS = "https://kristinek.github.io/site/tasks/list_of_people";

    private static ListOfPeople listOfPeople;
    private WebDriver driver;

    public ListOfPeopleSteps() {
        this.driver = Hooks.driver;
        listOfPeople = PageFactory.initElements(Hooks.driver, ListOfPeople.class);
    }

    // NAVIGATION

    @Given("^I am on the People with jobs page$")
    public void iAmOnTheAddPersonPage() {
        driver.get(URL_PEOPLE_WITH_JOBS);
    }

    // CLICK

    @When("^I click Add person button$")
    public void iClickAddPersonButton() {
        listOfPeople.addPersonButton.click();
    }

    @When("^I click Reset list button$")
    public void iClickResetListButton() {
        listOfPeople.resetListButton.click();
    }

    @When("^I click Add button$")
    public void iClickAddButton() {
        listOfPeople.addButton.click();
    }

    @When("^I click Cancel button$")
    public void iClickCancelButton() {
        listOfPeople.cancelButton.click();
    }

    // ENTER VALUES

    @When("^I enter \"(.*)\" value in the \"(.*)\" field$")
    public void iEnterName(String value, String field) throws InterruptedException {
        switch (field) {
            case "name":
                listOfPeople.nameField.sendKeys(value);
                break;
            case "surname":
                listOfPeople.surnameField.sendKeys(value);
                break;
            case "job":
                listOfPeople.jobField.sendKeys(value);
                break;
            case "date of birth":
                listOfPeople.dobField.sendKeys(value);
                listOfPeople.outOfField.click();
                break;
            case "gender":
                Thread.sleep(300);
                String gender = value.toLowerCase();
                if (gender.equals("male")) {
                    listOfPeople.radioMale.click();
                } else if (gender.equals("female")) {
                    listOfPeople.radioFemale.click();
                } else {
                    System.out.println("Select correct gender");
                }
                break;
            case "status":
                Select dropdown = new Select(listOfPeople.statusDropdown);
                dropdown.selectByVisibleText(value);
                break;
            default:
                throw new IllegalStateException("Functionality for " + field + "is not implemented");
        }
    }

    @And("^I enter languages:$")
    public void iEnterLanguages(DataTable dataTable) {

        List<List<String>> data = dataTable.raw();
        List<String> languages = new ArrayList<>();

        for (int i = 1; i <= data.size(); i++) {
            int j = i - 1;
            String language = data.get(j).get(0);
            languages.add(language);
        }

        for (int i = 1; i <= languages.size(); i++) {
            if (languages.contains("English")) {
                if (!listOfPeople.checkboxEnglish.isSelected()) {
                    listOfPeople.checkboxEnglish.click();
                }
            }
            if (languages.contains("French")) {
                if (!listOfPeople.checkboxFrench.isSelected()) {
                    listOfPeople.checkboxFrench.click();
                }
            }

            if (languages.contains("Spanish")) {
                if (!listOfPeople.checkboxSpanish.isSelected()) {
                    listOfPeople.checkboxSpanish.click();
                }
            }
        }
    }

    @Then("^I see new person is added with corresponding data$")
    public void iSeePerson1IsAddedWithCorrespondingData(DataTable dataTable) {

        List<List<String>> data = dataTable.raw();
        Assert.assertEquals("Wrong data", data.get(0).get(1), listOfPeople.person4Name.getText());
        Assert.assertEquals("Wrong data", data.get(1).get(1), listOfPeople.person4Surname.getText());

        Assert.assertEquals("Wrong data", data.get(2).get(1), listOfPeople.person4Job.getText());
        Assert.assertEquals("Wrong data", data.get(3).get(1), listOfPeople.person4DateOfBirth.getText());
        Assert.assertEquals("Wrong data", data.get(4).get(1).toLowerCase(), listOfPeople.person4Gender.getText());
        Assert.assertEquals("Wrong data", data.get(5).get(1).toLowerCase(), listOfPeople.person4Status.getText());

        Assert.assertEquals("Wrong data", data.get(6).get(1), listOfPeople.person4Language.getText());
    }
}

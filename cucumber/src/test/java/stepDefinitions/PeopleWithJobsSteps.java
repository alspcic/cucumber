package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages_sample.AddNewPersonPage;
import pages_sample.PeopleWithJobsPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PeopleWithJobsSteps {

    private WebDriver driver;
    private PeopleWithJobsPage jobsPage;
    private AddNewPersonPage addPage;

    public PeopleWithJobsSteps() {
        this.driver = Hooks.driver;
        jobsPage = PageFactory.initElements(Hooks.driver, PeopleWithJobsPage.class);
        addPage = PageFactory.initElements(Hooks.driver, AddNewPersonPage.class);
    }

    @When("^I navigate to People with jobs page$")
    public void iNavigateToPeopleWithJobsPage() {
        driver.get(jobsPage.getPageUrl());
    }


    @Then("^I see People with jobs page is loaded$")
    public void iSeePeopleWithJobsPageIsLoaded() {
        assertTrue(jobsPage.pageIsLoaded());
    }

    @And("^I see <([^\"]*)> button$")
    public void iSeeAddPersonButton(String buttonName) {
        switch (buttonName) {
            case "Add person":
                assertTrue(jobsPage.topAddButtonIsDisplayed());
                break;

            case "Reset List":
                assertTrue(jobsPage.topResetButtonIsDisplayed());
                break;

            case "Add":
                assertTrue(addPage.addButtonIsDisplayed());
                break;

            case "Clear all fields":
                assertTrue(addPage.clearAllFieldsButtonIsDisplayed());
                break;

            case "Cancel":
                assertTrue(addPage.canselButtonIsDisplayed());
                break;

            default:
                fail("The button is not defined");
        }
    }

    @And("^I see <(\\d+)> persons on the page list$")
    public void iSeePersonsOnThePageList(int personAmount) {
        assertEquals(personAmount, jobsPage.personNumberInTheList());
    }

    @When("^I click button <([^\"]*)>$")
    public void iClickButtonAddPerson(String buttonName) {
        switch (buttonName) {
            case "Add person":
                jobsPage.topAddButtonClick();
                break;

            case "Add":
                addPage.addButtonClick();
                break;

            default:
                fail("The button is not defined");
        }
    }

    @Then("^I see Adding new person page$")
    public void iSeeAddingNewPersonPage() {
        assertTrue(addPage.pageIsLoaded());
    }

    @And("^I see titles:$")
    public void iSeeTitles(List<String> titles) {
        List<String> ava = new ArrayList<String>() {
        };
        for (WebElement a : driver.findElements(By.xpath("//p/label[not (@class)]"))) {
            ava.add(a.getText());
        }

        assertEquals(titles.size(), ava.size());

        for (String e : titles) {
            assertTrue(ava.contains(e));
        }
    }

    @And("^I check values:$")
    public void iCheckValues(List<String> elementName) {
        addPage.focusOut();
        for (String e : elementName) {
            if (!driver.findElement(By.id(e)).isSelected()) {
                driver.findElement(By.id(e)).click();
            }
        }
    }

    @And("^I see values for person number <(\\d+)>$")
    public void iSeeValuesForPersonNumber(int personNumber, Map<String, String> valuesToCheck) {
        for (Map.Entry<String, String> e : valuesToCheck.entrySet()) {
            assertEquals(e.getValue(), driver.findElement(By.xpath("//ul/div[" + personNumber + "]//span[@class='" + e.getKey() + "']")).getText());
        }
    }

    @When("^I click button delete for person <(\\d+)>$")
    public void iClickButtonDeleteForPerson(int personNumber) {
        jobsPage.deletePersonFromList(personNumber);
    }

    @And("^I choose <([^\"]*)> value from <Employee status> dropdown$")
    public void iChooseInternValueFromEmployeeStatusDropdown(String value) {
        addPage.selectValueInEmployeeDropdown(value);
    }
}

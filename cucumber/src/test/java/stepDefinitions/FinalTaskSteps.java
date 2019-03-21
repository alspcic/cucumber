package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages_sample.*;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class FinalTaskSteps {
    private WebDriver driver;
    static FinalTaskObjects finalTaskObj;

    public FinalTaskSteps() {

        this.driver = Hooks.driver;
        finalTaskObj = PageFactory.initElements(Hooks.driver, FinalTaskObjects.class);
    }


    @Given("^Go to task page$")
    public void goToTaskPage() {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }

    @And("^I reset person list$")
    public void iResetPersonList() {
        finalTaskObj.ResetButton.click();
    }

    @And("^I click Add Person button$")
    public void iClickAddPersonButton() {
        finalTaskObj.AddPersonButton.click();
    }

    @And("^I input new persons name: \"([^\"]*)\"$")
    public void iInputNewPersonsName(String name) {
        finalTaskObj.inputname.clear();
        finalTaskObj.inputname.sendKeys(name);
    }

    @And("^I input new persons surname: \"([^\"]*)\"$")
    public void iInputNewPersonsSurname(String surname) {
        finalTaskObj.inputsurname.clear();
        finalTaskObj.inputsurname.sendKeys(surname);
    }

    @And("^I input new persons job: \"([^\"]*)\"$")
    public void iInputNewPersonsJob(String job) {
        finalTaskObj.inputjob.clear();
        finalTaskObj.inputjob.sendKeys(job);
    }

    @And("^I input new persons date of birth \"([^\"]*)\"$")
    public void iInputNewPersonsDateOfBirth(String date) {
        finalTaskObj.inputbirthdate.clear();
        finalTaskObj.inputbirthdate.sendKeys(date);
    }

    @And("^I select new persons language:$")
    public void iSelectNewPersonsLanguage(Map<String, String> values) {
        for (Map.Entry<String, String> lang : values.entrySet()) {
            finalTaskObj.selectLanguage(lang.getKey());
        }
    }

    @And("^I select persons gender: \"([^\"]*)\"$")
    public void iSelectPersonsGender(String gender) {
        switch (gender) {
            case "male":
                finalTaskObj.RbtnMale.click();
                break;
            case "female":
                finalTaskObj.RbtnFemale.click();
                break;
        }
    }

    @And("^I select persons status: \"([^\"]*)\"$")
    public void iSelectPersonsStatus(String status) {
        (new Select(finalTaskObj.DrpdwnStatus)).selectByValue(status);
    }

    @And("^I click Add button$")
    public void iClickAddButton() {
        finalTaskObj.AddPersonBtn.click();

    }

    @And("^I verify that new people are in the list:$")
    public void iVerifyThatNewPeopleAreInTheList(DataTable dt) throws InterruptedException {
        Thread.sleep(500);
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i).get("name"), finalTaskObj.getName());
            assertEquals(list.get(i).get("surname"), finalTaskObj.getSurname());
            assertEquals(list.get(i).get("job"), finalTaskObj.getJob());
            assertEquals(list.get(i).get("date of birth"), finalTaskObj.getDob());
            assertEquals(list.get(i).get("gender"), finalTaskObj.getGender());
            assertEquals(list.get(i).get("status"), finalTaskObj.getStatus());

        }
    }
}



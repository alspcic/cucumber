package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import util.CommonUtil;
import util.Log;

import java.util.List;

public class PeopleWithJobsSteps extends CommonUtil {
    @And("^I choose language :$")
    public void iChooseLanguage(List<String> values) throws InterruptedException {
        for (String value : values)
            selectCheckbox(peopleWithJobs.englishChbx);
            selectCheckbox(peopleWithJobs.spanishChbx);
            Thread.sleep(10000);
    }

    @When("^I click Reset List button$")
    public void iClickResetListButton() {
        peopleWithJobs.resetBtn.get(0).click();
    }

    @And("^I click Add Person button$")
    public void iClickAddPersonButton() {
        peopleWithJobs.addPersonBtn.get(0).click();
    }

    @Then("^I see Add new person form$")
    public void iSeeAddNewPersonForm() {
        Assert.assertTrue(peopleWithJobs.clearAllFieldsBtn.isDisplayed());
//        peopleWithJobs.clearAllFieldsBtn.click();
    }


    @When("^I fill Name from \"([^\"]*)\"$")
    public void iFillNameFrom(String tff){
        peopleWithJobs.nameField.sendKeys(tff);
    }

    @And("^I fill Surname from \"([^\"]*)\"$")
    public void iFillSurnameFrom(String tff){
        peopleWithJobs.surnameField.sendKeys(tff);
    }

    @And("^I fill Job from \"([^\"]*)\"$")
    public void iFillJobFrom(String tff){
        peopleWithJobs.jobField.sendKeys(tff);
    }

    @And("^I fill Date of birth from \"([^\"]*)\"$")
    public void iFillDateOfBirthFrom(String tff){
        peopleWithJobs.dateOfBirthField.sendKeys(tff);
    }

    @And("^I pick Gender from \"([^\"]*)\"$")
    public void iPickGenderFrom(String tff){
     if (tff.equalsIgnoreCase("male")){
         peopleWithJobs.maleRadio.click();
     }else {
         peopleWithJobs.femaleRadio.click();
     }
    }

    @And("^I click Add button$")
    public void iClickAddButton() {
        peopleWithJobs.addBtn.click();
    }
}

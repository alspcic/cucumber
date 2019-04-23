package stepDefinitions;

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
import pages_sample.AddPersonPage;
import pages_sample.PeopleListPage;
import static org.junit.Assert.*;
import java.util.List;

public class lastTaskSteps {

    private WebDriver driver;
    static PeopleListPage peopleListPage ;
    static AddPersonPage addPersonPage;

    public lastTaskSteps() {

        this.driver = Hooks.driver;
        peopleListPage = PageFactory.initElements(Hooks.driver, PeopleListPage.class);
        addPersonPage = PageFactory.initElements(Hooks.driver, AddPersonPage.class);
    }

    @Given("^I am on People list page$")
    public void iAmOnPeoplelistPage() throws Throwable {
        driver.get(peopleListPage.getPageURL());
    }


    @When("^I click on add new Person button$")
    public void iClickOnAddNewPersonButton() {
        peopleListPage.addPersonButton.click();
    }


    @And("^I select languages :$")
    public void iSelectLanguages(List<String> values) {
        for (String value : values) {
            if ( value == "English")
                addPersonPage.englishLangCheckbox.click();
            else if (value == "Spanish")
                addPersonPage.spanishLangCheckbox.click();
            else if (value =="French")
                addPersonPage.frenchLangCheckbox.click();
        }
    }

    @And("^I select Gender:$")
    public void iSelectGender(List<String> values) {
        for (String value : values) {
            if ( value == "male")
                addPersonPage.maleRadiobox.click();
            else if (value == "female")
                addPersonPage.femaleRadiobox.click();

        }
    }

    @And("^I click on Add button$")
    public void iClickOnAddButton() {
        addPersonPage.buttons.findElements(By.cssSelector("button:first-of-type")).get(0).click();
    }

    @And("^I select Employee Status:$")
    public void iSelectEmployeeStatus(List<String> values) {
        Select selectedValue = new Select( addPersonPage.statusCombobox);
        for (String value : values) {
         selectedValue.selectByVisibleText(value);
        }
    }

    @When("^I delete last user added$")
    public void iDeleteLastUserAdded() {
        List<WebElement> list =  peopleListPage.personsList.findElements(By.tagName("li"));
        Integer i = list.size()-1;
        list.get(i).findElements(By.cssSelector("#person"+i+" > span.w3-closebtn.closebtn.w3-padding.w3-margin-right.w3-medium")).get(0).click();
    }

    @When("^I enter Name : \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
      addPersonPage.enterPersonName(name);
    }

    @And("^I enter Surname : \"([^\"]*)\"$")
    public void iEnterSurname(String surName) throws Throwable {
        addPersonPage.enterPersonSurName(surName);
    }

    @And("^I enter Job : \"([^\"]*)\"$")
    public void iEnterJob(String job) throws Throwable {
       addPersonPage.enterPersonJob(job);
    }

    @And("^Date Of Birth: \"([^\"]*)\"$")
    public void dateOfBirth(String dob) throws Throwable {
        addPersonPage.enterPersonDOB(dob);
    }

    @And("^Number of users is now : \"([^\"]*)\"$")
    public void numberOfUsersIsNow(String count) throws Throwable {
        List<WebElement> list = peopleListPage.personsList.findElements(By.tagName("li"));
        Integer listCount = list.size();
        assertEquals( count, listCount.toString());
    }

    @Then("^it is no longer on page with name :\"([^\"]*)\"$")
    public void itIsNoLongerOnPageWithName(String name) throws Throwable {
        List<WebElement> list =  peopleListPage.personsList.findElements(By.tagName("li"));
        Integer i = list.size()-1;
        WebElement lastPerson = list.get(i).findElements(By.xpath("//*[@id=\"person"+i+"\"]/div/span[1]")).get(0);
        assertNotEquals(name,lastPerson.getText());
    }
}

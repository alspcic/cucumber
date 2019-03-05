package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.EnterNewPerson;
import pages_sample.PeoplePage;

import java.util.HashMap;

import static org.junit.Assert.*;

public class PeopleStepdefs {
    private WebDriver driver;
    static PeoplePage peoplePage;
    static EnterNewPerson enterNewPerson;
    private final String peoplePageUrl = "https://kristinek.github.io/site/tasks/list_of_people";
    private final String enterNewPersonUrl = "https://kristinek.github.io/site/tasks/enter_a_new_person.html";
    private int peopleCount ;

    public PeopleStepdefs() {
        this.driver = Hooks.driver;
        peoplePage = PageFactory.initElements(Hooks.driver, PeoplePage.class);
        enterNewPerson = PageFactory.initElements(Hooks.driver, EnterNewPerson.class);
    }

    @Given("^I am on the people page$")
    public void iAmOnThePeoplePage() {
        driver.get(peoplePageUrl);
        peopleCount = peoplePage.peopleCount();
    }

    @When("^I press ADD PERSON button$")
    public void iPressADDPERSONButton() {
        peoplePage.addPerson();
    }

    @Then("^I am on the enter_a_new_person page$")
    public void iAmOnTheEnter_a_new_personPage() {
        assertEquals( enterNewPersonUrl, driver.getCurrentUrl());
    }

    @When("^I enter name \"([^\"]*)\"$")
    public void iEnterNameString( String s ) throws Throwable {
        enterNewPerson.namePersonEnter(s);
    }

    @And("^I enter surname \"([^\"]*)\"$")
    public void iEnterSurname(String s) throws Throwable {
        enterNewPerson.surnamePersonEnter(s);
    }

    @And("^I enter job \"([^\"]*)\"$")
    public void iEnterJob(String s) throws Throwable {
        enterNewPerson.jobPersonEnter(s);
    }

    @And("^I enter dob \"([^\"]*)\"$")
    public void iEnterDob(String s) throws Throwable {
        enterNewPerson.dobPersonEnter(s);
    }

//(\\d+)$")
    @And("^I enter english: \"([^\"]*)\"$")
    public void iEnterEnglish(int n) throws Throwable {
        enterNewPerson.english(n);
    }
    @And("^I enter french: \"([^\"]*)\"$")
    public void iEnterFrench(int n) throws Throwable {
        enterNewPerson.french(n);
    }
    @And("^I enter spanish: \"([^\"]*)\"$")
    public void iEnterSpanish(int n) throws Throwable {
        enterNewPerson.spanish(n);
    }

    @And("^I enter gender: \"([^\"]*)\"$")
    public void iEnterGender(String s) throws Throwable {
        enterNewPerson.gender(s);
    }

    @And("^I enter employee status: \"([^\"]*)\"$")
    public void iEnterEmployeeStatus(String s) throws Throwable {
        enterNewPerson.optionChose(s);
    }

    @And("^I press ADD button$")
    public void iPressADDButton() {
        enterNewPerson.addButton();
                }

    @Then("^List becomes longer to one$")
    public void listBecomesLongerToOne() {
    assertEquals( 1, ( peoplePage.peopleCount() - peopleCount));
    peopleCount++;
    }

    @And("^The last person name is \"([^\"]*)\"$")
    public void theLastPesonNameIs(String s) throws Throwable {
        assertEquals(s, peoplePage.lastPersonName());
    }

    @And("^The last person surname is \"([^\"]*)\"$")
    public void theLastPersonSurnameIs(String s) throws Throwable {
        assertEquals(s, peoplePage.lastPersonSurname());
    }

    @And("^The last person job is \"([^\"]*)\"$")
    public void theLastPersonJobIs(String s) throws Throwable {
        assertEquals(s, peoplePage.lastPersonJob());
    }

    @And("^The last person date of birth is \"([^\"]*)\"$")
    public void theLastPersonLanguageIs(String s) throws Throwable {
        assertEquals(s, peoplePage.lastPersonDob());
    }

    @And("^The last person language is \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void theLastPersonLanguageIs(String english, String french, String spanish) throws Throwable {
        english=english.trim();
        french=french.trim();
        spanish=spanish.trim();

        if (english == "1")
            assertTrue(peoplePage.lastPersonLanguage().contains("english"));
        else
            assertFalse(peoplePage.lastPersonLanguage().contains("english"));

        if (french == "1")
            assertTrue(peoplePage.lastPersonLanguage().contains("french"));
        else
            assertFalse(peoplePage.lastPersonLanguage().contains("french"));

        if (spanish == "1")
            assertTrue(peoplePage.lastPersonLanguage().contains("spanish"));
        else
            assertFalse(peoplePage.lastPersonLanguage().contains("spanish"));
    }

    @And("^The last person gender is \"([^\"]*)\"$")
    public void theLastPersonGenderIs(String s) throws Throwable {
        assertEquals(s, peoplePage.lastPersonGender());
    }

    @And("^The last person status is \"([^\"]*)\"$")
    public void theLastPersonStatusIs(String s) throws Throwable {
        assertEquals(s, peoplePage.lastPersonStatus());
    }

}

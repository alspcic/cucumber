package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.PeopleWithJobsPage;
import pages_sample.PeopleWithJobsPersonAddPage;
import java.util.List;
import java.util.Map;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class PeopleWithJobsSteps{
    private WebDriver driver;

    public static PeopleWithJobsPage pwj;
    public static PeopleWithJobsPersonAddPage pwjadd;

    public PeopleWithJobsSteps() {
        this.driver = Hooks.driver;
        pwj = PageFactory.initElements(Hooks.driver, PeopleWithJobsPage.class);
        pwjadd = PageFactory.initElements(Hooks.driver, PeopleWithJobsPersonAddPage.class);
    }

    @When("^I am on the People with jobs list page$")
    public void iAmOnPeopleListPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }

    @Then("^I click button ([^\"]*) Add person on PeopleList$")
    public void IClickButtonAddPersonOn(int loc)throws Throwable{
        pwj.ClickButtonAdd(loc);
        sleep(2000);
    }

    @When("^I enter person data on PersonAddPage:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            sleep(2000);
            switch(e.getKey().toLowerCase()){
                case "name":
                    pwjadd.personName.clear();
                    pwjadd.personName.sendKeys(e.getValue());
                    break;

                case "surname":
                    pwjadd.personSurname.clear();
                    pwjadd.personSurname.sendKeys(e.getValue());
                    break;

                case "job":
                    pwjadd.personJob.clear();
                    pwjadd.personJob.sendKeys(e.getValue());
                    break;

                case "dateofbirth":
                    pwjadd.personDateOfBirth.clear();
                    pwjadd.personDateOfBirth.sendKeys(e.getValue());
                    break;

                case "gender":
                    switch(e.getValue().toLowerCase()) {
                        case "female":
                            pwjadd.radioFemale.click();
                            break;

                        case "male":
                            pwjadd.radioMale.click();
                            break;

                        default:
                            assertTrue(false);
                    }
                    break;

                case "status":
                    pwjadd.SelectEmployeeStatus(e.getValue());
                    break;

                default:
                    assertTrue(false);
                    break;
            }
        }
    }

    @When("^I check languages on PersonAddPage:$")
    public void iCheckLanguages(List<String> values) throws Throwable {
        for (String value : values) {
            sleep(2000);
            switch(value.toLowerCase()) {
                case "english":
                    if(!pwjadd.checkboxEnglish.isSelected()){
                        pwjadd.checkboxEnglish.click();
                    }
                    break;

                case "french":
                    if(!pwjadd.checkboxFrench.isSelected()){
                        pwjadd.checkboxFrench.click();
                    }
                    break;
                case "spanish":
                    if(!pwjadd.checkboxSpanish.isSelected()){
                        pwjadd.checkboxSpanish.click();
                    }
                    break;

                default:
                    assertTrue(false);
            }
        }
    }

    @Then("^I click Add button on PersonAddPage$")
    public void IClickButtonAddPersonOn() throws Throwable{
        sleep(2000);
        pwjadd.buttonAddPersonTolist.click();
    }

    @When("^I see ([^\"]*) persons in the list on PeopleList$")
    public void ICheckPersonCountOn(int count) throws Throwable{
        sleep(2000);
        pwj.CheckPersonCount(count);
    }

    @When("^I delete person: \"([^\"]*)\" on PeopleList$")
    public void IDeletePerson(String person) throws Throwable{
        sleep(2000);
        pwj.DeletePerson(person);
    }
}
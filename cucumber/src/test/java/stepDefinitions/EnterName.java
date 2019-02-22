package stepDefinitions;

import Pages.Kristinek.KristinekMainPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.AgePage;
import util.BaseUtil;

import java.security.Key;
import java.util.List;

public class EnterName extends BaseUtil {
    WebDriver driver;
    static KristinekMainPage mainPage;

    public EnterName() {
        this.driver = BaseUtil.driver;
        mainPage = PageFactory.initElements(BaseUtil.driver, KristinekMainPage.class);
    }

    @And("^I click the add person button$")
    public void iClickTheAddPersonButton() {
        kristinekMainPage.addPersonBtn.get(0).click();
    }

    @And("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String arg0) {
        kristinekMainPage.nameField.sendKeys(String.valueOf(arg0));
    }

    @And("^I enter surname: \"([^\"]*)\"$")
    public void iEnterSurname(String arg0) {
        kristinekMainPage.surnameField.sendKeys(String.valueOf(arg0));
    }

    @And("^I enter date of birth: \"([^\"]*)\"$")
    public void iEnterDateOfBirthDate(String arg0) {
        kristinekMainPage.dataField.sendKeys(String.valueOf(arg0));
    }

    @When("^I chose language:$")
    public void iChoseLanguage(List<String> values) throws Throwable {
        for (String value : values)
            if (!driver.findElement(By.id("english")).isSelected()) {
                driver.findElement(By.id("english")).click();
            }
        if (!driver.findElement(By.id("spanish")).isSelected()) {
            driver.findElement(By.id("spanish")).click();
        }
    }

    @And("^I click the radiobutton$")
    public void iClickTheRadiobutton() {
        driver.findElement(By.id("female")).click();
//        mainPage.getErrorMsgText();
    }

    @And("^I click the Add button$")
    public void iClickTheAddButton() {
        driver.findElement(By.id("modal_button")).click();
        //  driver.findElements(By.cssSelector("")).size();
    }


    @And("^I should see page List of people$")
    public void iShouldSeePageListOfPeople() {
        //Assert.assertTrue(driver.getCurrentUrl().equals('https://kristinek.github.io/site/tasks/list_of_people.html'));
        System.out.println("|  " + driver.getCurrentUrl() + " |");
    }

    @And("^I click the reset button$")
    public void iClickTheResetButton() {
        kristinekMainPage.resetBtn.get(0).click();
    }


    @And("^I verify new added persons in list$")
    public void iVerifyNewAddedPersonsInList() {
        Assert.assertTrue(driver.findElement(By.id("person2")).isDisplayed());
    }


}

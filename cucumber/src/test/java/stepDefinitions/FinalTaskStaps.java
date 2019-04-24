package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages_sample.AddNewPersonPage;
import pages_sample.PeopleListPage;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FinalTaskStaps {
    private WebDriver driver;
    public static PeopleListPage peopleListPage;
    public static AddNewPersonPage addNewPersonPage;

    public FinalTaskStaps() {
        this.driver = Hooks.driver;
        peopleListPage = PageFactory.initElements(Hooks.driver, PeopleListPage.class);
        addNewPersonPage = PageFactory.initElements(Hooks.driver, AddNewPersonPage.class);
    }

    @Then("^I see '(.*)' on the People list page$")
    public void iSeePeopleWithJobsOnThePeopleListPage(String element) throws InterruptedException {
        Thread.sleep(1000);
        WebElement elementUi = null;

        switch (element)
        {
            case "People with jobs":
                elementUi = peopleListPage.pageTitle;
                break;
        }

        elementUi.isDisplayed();
        assertEquals(element, elementUi.getText());
    }

    @And("^I see following buttons on the People list page$")
    public void iSeeFollowingButtonsOnThePeopleListPage(List<String> values) throws Throwable {
        WebElement elementUi = null;

        for (String value : values) {
            elementUi = driver.findElement(By.xpath("//button[text()='" + value + "']"));
            elementUi.isDisplayed();
            assertEquals(value, elementUi.getText());
        }
    }

    @And("^I see following elements on the People list page$")
    public void iSeeFollowingElementsOnThePeopleListPage(List<String> values) throws Throwable {
        WebElement elementUi = null;

        for (String value : values) {
            switch (value)
            {
                case "List of people":
                    elementUi = peopleListPage.peopleList;
                    break;

                case "Edit icon button":
                    elementUi = peopleListPage.editIconButton.get(0);
                    break;

                case "Delete icon button":
                    elementUi = peopleListPage.deleteIconButton.get(0);
                    break;
            }

            elementUi.isDisplayed();
        }
    }

    @And("^I see copyright text \"([^\"]*)\" on the People list page$")
    public void iSeeCopyrightTextOnThePeopleListPage(String expectedText) throws Throwable {
        WebElement elementUi = peopleListPage.copyRightText;
        String actualText = elementUi.getText();

        elementUi.isDisplayed();
        assertEquals(expectedText, actualText);
    }

    @When("^I click on '(.*)' on the People list page$")
    public void iClickOnAddPersonOnThePeopleListPage(String button) {
        WebElement elementUi = null;

        elementUi = driver.findElement(By.xpath("//button[text()='" + button + "']"));
        elementUi.click();
    }

    @Then("^I see '(.*)' on the Adding new person page$")
    public void iSeePeopleWithJobsOnTheAddingNewPersonPage(String element) throws InterruptedException {
        Thread.sleep(1000);
        WebElement elementUi = null;

        switch (element)
        {
            case "People with jobs":
                elementUi = peopleListPage.pageTitle;
                break;
        }

        elementUi.isDisplayed();
        assertEquals(element, elementUi.getText());
    }

    @And("^I see following buttons on the Adding new person page$")
    public void iSeeFollowingButtonsOnTheAddingNewPersonPage(List<String> values) throws Throwable {
        WebElement elementUi = null;

        for (String value : values) {
            elementUi = driver.findElement(By.xpath("//button[text()='" + value + "']"));
            elementUi.isDisplayed();
            assertEquals(value, elementUi.getText());
        }
    }

    @And("^I see following elements on the Adding new person page$")
    public void iSeeFollowingElementsOnTheAddingNewPersonPage(List<String> values) throws Throwable {
        WebElement elementUi = null;

        for (String value : values) {
            switch (value)
            {
                case "Name text field":
                    elementUi = addNewPersonPage.nameTextField;
                    break;

                case "Surname text field":
                    elementUi = addNewPersonPage.surnameTextField;
                    break;

                case "Job text field":
                    elementUi = addNewPersonPage.jobTextField;
                    break;

                case "Date of birth text field":
                    elementUi = addNewPersonPage.birtDateTextField;
                    break;

                case "English checkbox":
                    elementUi = addNewPersonPage.englishCheckbox;
                    break;

                case "French checkbox":
                    elementUi = addNewPersonPage.frenchCheckbox;
                    break;

                case "Spanish checkbox":
                    elementUi = addNewPersonPage.spanishCheckbox;
                    break;

                case "Male radio button":
                    elementUi = addNewPersonPage.maleRadioButton;
                    break;

                case "Female radio button":
                    elementUi = addNewPersonPage.femaleRadioButton;
                    break;

                case "Employee dropdown":
                    elementUi = addNewPersonPage.employeeDropdown;
                    break;
            }

            elementUi.isDisplayed();
        }
    }

    @And("^I see following labels on the Adding new person page$")
    public void iSeeFollowingLabelsOnTheAddingNewPersonPage(List<String> values) throws Throwable {
        WebElement elementUi = null;

        for (String value : values) {
            elementUi = driver.findElement(By.xpath("//label[text()='" + value + "']"));
            elementUi.isDisplayed();
            assertEquals(value, elementUi.getText());
        }
    }

    @And("^I see (\\d+) person in the list on the People list page$")
    public void iSeePersonInTheListOnThePeopleListPage(int expectedCount) throws InterruptedException {
        List<WebElement> table = peopleListPage.peopleListTable;

        int actualCount = table.size();

        assertEquals(expectedCount, actualCount);
    }

    @When("^I fill following fields on the Adding new person page$")
    public void iFillFollowingFieldsOnTheAddingNewPersonPage(List<Table> entries) throws Throwable {
        WebElement elementUi = null;

        for (Table entry : entries) {
            switch (entry.field)
            {
                case "Name text field":
                    elementUi = addNewPersonPage.nameTextField;
                    break;
                case "Surname text field":
                    elementUi = addNewPersonPage.surnameTextField;
                    break;
                case "Job text field":
                    elementUi = addNewPersonPage.jobTextField;
                    break;
                case "Date of birth text field":
                    elementUi = addNewPersonPage.birtDateTextField;
                    break;
            }

            elementUi.click();
            elementUi.clear();
            elementUi.sendKeys(entry.value);
        }
    }

    @And("^I click on '(.*)' on the Adding new person page$")
    public void iClickOnAddOnTheAddingNewPersonPage(String element) throws InterruptedException {
        WebElement elementUi = null;

        elementUi = driver.findElement(By.xpath("//button[text()='" + element + "']"));
        elementUi.click();

        Thread.sleep(1000);
    }

    @And("^I select following language on the Adding new person page$")
    public void iSelectFollowingLanguageOnTheAddingNewPersonPage(List<String> options) throws InterruptedException {
        WebElement elementUi = null;

        for (String option : options)
        {
            switch (option)
            {
                case "English checkbox":
                    elementUi = addNewPersonPage.englishCheckbox;
                    break;

                case "French checkbox":
                    elementUi = addNewPersonPage.frenchCheckbox;
                    break;
            }

            Thread.sleep(500);
            if (elementUi.isSelected() == false)
            {
                elementUi.click();
            }
        }
    }

    @And("^I select '(.*)' gender on the Adding new person page$")
    public void iSelectFemaleGenderOnTheAddingNewPersonPage(String option) {
        WebElement elementUi = null;

        elementUi = driver.findElement(By.cssSelector("[id='" + option + "']"));
        elementUi.click();
    }

    @And("^I select option '(.*)' from '(.*)' dropdown on the Adding new person page$")
    public void iSelectOptionContractorFromEmployeeStatusDropdownOnTheAddingNewPersonPage(String option, String dropdown) {
        switch (dropdown)
        {
            case "Employee status":
                Select elementUi = new Select(addNewPersonPage.employeeDropdown);
                elementUi.selectByValue(option);
                break;
        }
    }

    @And("^I click on (\\d+) delete icon button from the list on the People list page$")
    public void iClickOnDeleteIconButtonFromTheListOnThePeopleListPage(int index) throws InterruptedException {
        Thread.sleep(1000);

        WebElement elementUi = peopleListPage.deleteIconButton.get(index - 1);
        elementUi.click();

        Thread.sleep(1000);
    }


    /*
    HELPER STEPS
     */
    public class Table {
        String field;
        String value;
    }
}

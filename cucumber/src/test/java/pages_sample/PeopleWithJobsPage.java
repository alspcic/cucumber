package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PeopleWithJobsPage {
    @FindBy(how = How.CSS, using = ".w3-container button:nth-of-type(2)")
    private WebElement resetList;
    @FindBy(how = How.CSS, using = ".w3-container button:nth-of-type(1)")
    private WebElement addPerson;
    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .name")
    private WebElement name;
    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .surname")
    private WebElement surname;
    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .job")
    private WebElement job;
    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .dob")
    private WebElement dob;
    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .gender")
    private WebElement gender;
    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .status")
    private WebElement status;


    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people";
    }

    public void clickResetList() {
        resetList.click();
    }

    public void clickAddPerson() {
        addPerson.click();
    }

    public String name() {
        return name.getText();
    }

    public String surname() {
        return surname.getText();
    }

    public String job() {
        return job.getText();
    }

    public String dob() {
        return dob.getText();
    }

    public String gender() {
        return gender.getText();
    }

    public String status() {
        return status.getText();
    }
}


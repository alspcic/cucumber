package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class overviewPage {
    @FindBy(how = How.CSS, using = ".w3-container button:nth-of-type(2)")
    private WebElement resetButton;
    @FindBy(how = How.CSS, using = ".w3-container button:nth-of-type(1)")
    private WebElement addNewButton;
    @FindBy(how = How.CSS, using = ".w3-container button:nth-of-type(1)")
    private WebElement resetList;
    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .name")
    private WebElement name;
    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .surname")
    private WebElement surname;
    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .job")
    private WebElement job;
    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .dob")
    private WebElement dateOfBirth;
    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .gender")
    private WebElement gender;
    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .language")
    private WebElement language;
    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .status")
    private WebElement employeeStatus;

    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people.html";
    }

    public void resetList() {
        resetButton.click();
    }

    public void addNewPerson() {
        addNewButton.click();
    }

    public String getName() {
        return name.getText();
    }

    public String getSurname() {
        return surname.getText();
    }

    public String getJob() {
        return job.getText();
    }

    public String getDateOfBirth() {
        return dateOfBirth.getText();
    }

    public String getGender() {
        return gender.getText();
    }

    public String getLanguage() {
        return language.getText();
    }

    public String getEmployeeStatus() {
        return employeeStatus.getText();
    }
}

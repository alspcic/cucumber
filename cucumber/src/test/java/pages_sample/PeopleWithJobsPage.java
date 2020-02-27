package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class PeopleWithJobsPage {

    @FindBy(how = How.ID, using = "header")
    private WebElement pageHeader;

    @FindBy(how = How.CSS, using = ".w3-container button:nth-of-type(1)")
    private WebElement addPersonBtn;

    @FindBy(how = How.CSS, using = ".w3-container button:nth-of-type(2)")
    private WebElement resetListBtn;

    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .name")
    private WebElement name;

    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .surname")
    private WebElement surname;

    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .job")
    private WebElement job;

    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .dob")
    private WebElement dob;

    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .language")
    private WebElement language;

    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .gender")
    private WebElement gender;

    @FindBy(how = How.CSS, using = "#listOfPeople div:nth-of-type(4) .status")
    private WebElement status;



    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people";
    }

    public void clickResetList(){
        resetListBtn.click();
    }

    public void clickAddPerson(){
        addPersonBtn.click();
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

    public String getDob() {
        return dob.getText();
    }

    public String getLanguage() {
        return language.getText();
    }

    public String getGender() {
        return gender.getText();
    }

    public String getStatus() {
        return status.getText();
    }
}

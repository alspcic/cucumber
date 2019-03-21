package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;

public class FinalTaskObjects {




    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Add person')]")
    public WebElement AddPersonButton;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Reset List')]")
    public WebElement ResetButton;

    @FindBy(how = How.ID, using = "name")
    public WebElement inputname;

    @FindBy(how = How.ID, using = "surname")
    public WebElement inputsurname;

    @FindBy(how = How.ID, using = "job")
    public WebElement inputjob;

    @FindBy(how = How.ID, using = "dob")
    public WebElement inputbirthdate;

    @FindBy(how = How.ID, using = "english")
    public WebElement ckbxEnglish;

    @FindBy(how = How.ID, using = "french")
    public WebElement ckbxFrench;

    @FindBy(how = How.ID, using = "spanish")
    public WebElement ckbxSpanish;

    @FindBy(how = How.ID, using = "male")
    public WebElement RbtnMale;

    @FindBy(how = How.ID, using = "female")
    public WebElement RbtnFemale;

    @FindBy(how = How.ID, using = "status")
    public WebElement DrpdwnStatus;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Add')]")
    public WebElement AddPersonBtn;


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



    public void selectLanguage(String language) {
        switch (language) {
            case "English":
                ckbxEnglish.click();
                break;
            case "French":
                ckbxFrench.click();
                break;
            case "Spanish":
                ckbxSpanish.click();
                break;
            default:
                break;
        }
    }





    @FindBy(how = How.XPATH, using = "//*[@name='btnK']")
    public WebElement searchbtn;

    @FindBy(how = How.ID, using = "hplogo")
    public WebElement googlelogo;


}

package pages_sample;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class AddPersonPage {
    @FindBy(how = How.ID, using = "name")
    private WebElement nameField;
    @FindBy(how = How.ID, using = "surname")
    private WebElement surnameField;
    @FindBy(how = How.ID, using = "job")
    private WebElement jobField;
    @FindBy(how = How.ID, using = "dob")
    private WebElement dObField;
    @FindBy(how = How.ID, using = "french")
    private WebElement frenchLanguage;
    @FindBy(how = How.ID, using = "spanish")
    private WebElement spanishLanguage;
    @FindBy(how = How.ID, using = "english")
    private WebElement englishLanguage;
    @FindBy(how = How.ID, using = "female")
    private WebElement femaleGender;
    @FindBy(how = How.ID, using = "male")
    private WebElement maleGender;
    @FindBy(how = How.ID, using = "status")
    private WebElement employeeStatus;
    @FindBy(how = How.CSS, using = ".w3-btn-group button:nth-of-type(1)")
    private WebElement addButton;


    public void nameField(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void surnameField(String surname) {
        surnameField.clear();
        surnameField.sendKeys(surname);
    }

    public void jobField(String job) {
        jobField.clear();
        jobField.sendKeys(job);
    }

    public void dObField(String dob) {
        dObField.clear();
        dObField.sendKeys(dob);
    }

    public void clickLanguageCheckbox(String language) {
        if(language.equals("french")){
            frenchLanguage.click();
        }

        if(language.equals("spanish")){
            spanishLanguage.click();
        }

        if(language.equals("english")){
            englishLanguage.click();
        }
    }

    public void selectGender(String gender) {
        if(gender.equals("female")){
            femaleGender.click();
        }

        if(gender.equals("male")){
            maleGender.click();
        }
    }

    public void employeeStatus(String value) {
        (new Select(employeeStatus)).selectByValue(value);
    }

    public void addButton() {
        addButton.click();
    }
}

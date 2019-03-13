package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class addNewPage {
    @FindBy(how = How.ID, using = "name")
    private WebElement nameField;
    @FindBy(how = How.ID, using = "surname")
    private WebElement surnameField;
    @FindBy(how = How.ID, using = "job")
    private WebElement jobField;
    @FindBy(how = How.ID, using = "dob")
    private WebElement dateOfBirthField;
    @FindBy(how = How.ID, using = "english")
    private WebElement englishCheckbox;
    @FindBy(how = How.ID, using = "french")
    private WebElement frenchCheckbox;
    @FindBy(how = How.ID, using = "spanish")
    private WebElement spanishCheckbox;
    @FindBy(how = How.ID, using = "male")
    private WebElement maleRadiobutton;
    @FindBy(how = How.ID, using = "female")
    private WebElement femaleRadiobutton;
    @FindBy(how = How.ID, using = "status")
    private WebElement employeeStatusField;
    @FindBy(how = How.CSS, using = ".w3-btn-group button:nth-of-type(1)")
    private WebElement addButton;

    public void nameField (String name) {
        nameField.clear ();
        nameField.sendKeys (name);
    }

    public void surnameField (String surname) {
        surnameField.clear ();
        surnameField.sendKeys (surname);
    }

    public void jobField (String job) {
        jobField.clear ();
        jobField.sendKeys (job);
    }

    public void dateOfBirthField (String dateOfBirth) {
        dateOfBirthField.clear ();
        dateOfBirthField.sendKeys (dateOfBirth);
    }

    public void selectLanguage (String language){
        if(language.equals("english")){
            englishCheckbox.isSelected();
        }

        if(language.equals("french")){
            frenchCheckbox.isSelected();
        }

        if(language.equals("spanish")){
            spanishCheckbox.isSelected();
        }
    }

    public void selectGender (String gender){
        if(gender.equals("male")){
            maleRadiobutton.isSelected();
        }

        if(gender.equals("female")){
            femaleRadiobutton.isSelected();
        }
    }

    public void chooseStatus (String employeeStatus){
        (new Select(employeeStatusField)).selectByValue(employeeStatus);
    }

    public void addButton () {
        addButton.click ();
    }
}

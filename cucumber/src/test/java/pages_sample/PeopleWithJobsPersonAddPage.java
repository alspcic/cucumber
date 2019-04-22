package pages_sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class PeopleWithJobsPersonAddPage {
    private WebDriver driver;

    @FindBy(how = How.CLASS_NAME, using = "h2")
    public WebElement pageHeader;

    @FindBy(how = How.CSS, using = "button[onClick=\'openModalForAddPerson()\']")
    public WebElement buttonClearAllFields;

    @FindBy(how = How.CSS, using = "button[onClick=\'addPersonToList()\']")
    public WebElement buttonAddPersonTolist;

    @FindBy(how = How.CSS, using = "button[onClick=\'window.history.back()\']")
    public WebElement buttonACancel;

    @FindBy(how = How.ID, using = "name")
    public WebElement personName;

    @FindBy(how = How.ID, using = "surname")
    public WebElement personSurname;

    @FindBy(how = How.ID, using = "job")
    public WebElement personJob;

    @FindBy(how = How.ID, using = "dob")
    public WebElement personDateOfBirth;

    @FindBy(how = How.ID, using = "english")
    public WebElement checkboxEnglish;

    @FindBy(how = How.CSS, using = "label[for=\'lang_eng\']")
    public WebElement checkboxEnglishLabel;

    @FindBy(how = How.ID, using = "french")
    public WebElement checkboxFrench;

    @FindBy(how = How.CSS, using = "label[for=\'lang_fr\']")
    public WebElement checkboxFrenchLabel;

    @FindBy(how = How.ID, using = "spanish")
    public WebElement checkboxSpanish;

    @FindBy(how = How.CSS, using = "label[for=\'lang_sp\']")
    public WebElement checkboxSpanishLabel;

    @FindBy(how = How.ID, using = "male")
    public WebElement radioMale;

    @FindBy(how = How.ID, using = "female")
    public WebElement radioFemale;

    @FindBy(how = How.ID, using = "status")
    public WebElement dropdwonStatus;

    public void SelectEmployeeStatus(String status){
        Select dropdown = new Select(dropdwonStatus);
        dropdown.selectByVisibleText(status);
    }
}

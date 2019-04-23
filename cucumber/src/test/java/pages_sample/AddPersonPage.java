package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AddPersonPage {
    @FindBy(how = How.ID, using = "name")
    private WebElement personNameText;
    @FindBy(how = How.ID, using = "surname")
    private WebElement personSurNameText;
    @FindBy(how = How.ID, using = "job")
    private WebElement personJobText;
    @FindBy(how = How.ID, using = "dob")
    private WebElement personDOFCalender;
    @FindBy(how = How.ID, using = "english")
    public WebElement englishLangCheckbox;
    @FindBy(how = How.ID, using = "french")
    public WebElement frenchLangCheckbox;
    @FindBy(how = How.ID, using = "spanish")
    public WebElement spanishLangCheckbox;

    @FindBy(how = How.ID, using = "male")
    public WebElement maleRadiobox;
    @FindBy(how = How.ID, using = "female")
    public WebElement femaleRadiobox;


    @FindBy(how = How.ID, using = "status")
    public WebElement statusCombobox;
    @FindBy(how =  How.XPATH, using = "//*[@id=\"addEditPerson\"]/div")
    public WebElement buttons;


    public String getPageURL()
    {
        return "https://kristinek.github.io/site/tasks/enter_a_new_person.html";
    }


    public void enterPersonName(String name) {
        personNameText.clear();
        personNameText.sendKeys(name);
    }

    public void enterPersonSurName(String surname) {
        personSurNameText.clear();
        personSurNameText.sendKeys(surname);
    }

    public void enterPersonJob(String job) {
        personJobText.clear();
        personJobText.sendKeys(job);
    }

    public void enterPersonDOB(String dob) {
        personDOFCalender.clear();
        personDOFCalender.sendKeys(dob);
    }

}

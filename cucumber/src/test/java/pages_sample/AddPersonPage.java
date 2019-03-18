package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.junit.Assert.*;


import java.util.List;

public class AddPersonPage {

    @FindBy(how= How.ID,using = "addPersonBtn")
    private WebElement clearAllFieldsBtn;

    @FindBy(how=How.ID,using="name")
    private WebElement nameField;

    @FindBy(how=How.ID,using="surname")
    private WebElement surnameField;

    @FindBy(how=How.ID,using="job")
    private WebElement jobField;

    @FindBy(how=How.ID,using="dob")
    private WebElement dobField;

    @FindBy(how=How.CLASS_NAME,using=".w3-radio")
    private List<WebElement> genderRadioBtn;

    @FindBy(how=How.CLASS_NAME,using=".w3-check")
    private List<WebElement> languageChecks;

    @FindBy(how=How.XPATH,using= "//button[@onclick='addPersonToList()']")
    private WebElement addBtn;

    public void clearAllFields(){
        assertTrue("Clear all button not displayed",clearAllFieldsBtn.isDisplayed());
        clearAllFieldsBtn.click();
    }

    public void enterName(String name){
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void enterSurname(String surname){
        surnameField.sendKeys(surname);
    }

    public void enterJob(String jobTitle){
        jobField.sendKeys(jobTitle);
    }

    public void enterDOBValue(String dob){
        dobField.clear();
        dobField.sendKeys(dob);
    }

    public void clickAddBtn(){
        addBtn.click();
    }

    public void selectGender(String value){
        for(int i=0;i<this.genderRadioBtn.size();i++){
            if(genderRadioBtn.get(i).getAttribute("id").equals(value)){
                genderRadioBtn.get(i).click();
            }
        }
    }



}

package pages_sample;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddPersonPage {

    @FindBy(how = How.ID, using = "header")
    private WebElement pageHeader;

    @FindBy(how = How.ID, using = "addPersonBtn")
    private WebElement clearAllBtn;

    @FindBy(how = How.ID, using = "name")
    private WebElement nameFld;

    @FindBy(how = How.ID, using = "surname")
    private WebElement surnameFld;

    @FindBy(how = How.ID, using = "job")
    private WebElement jobFld;

    @FindBy(how = How.ID, using = "dob")
    private WebElement dobFld;

    @FindBy(how = How.ID, using = "english")
    private WebElement englishLng;

    @FindBy(how = How.ID, using = "french")
    private WebElement frenchLng;

    @FindBy(how = How.ID, using = "spanish")
    private WebElement spanishhLng;

    @FindBy(how = How.ID, using = "male")
    private WebElement maleRbx;

    @FindBy(how = How.ID, using = "female")
    private WebElement femaleRbx;

    @FindBy(how = How.ID, using = "status")
    private WebElement statusLov;

    //@FindBy(how = How.CSS, using = ".w3-container button:nth-of-type(1)")
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Add')]")
    private WebElement addPersonBtn;

    public void inputName(String name){
        nameFld.clear();
        nameFld.sendKeys(name);
    }

    public void inputSurname(String surname){
        surnameFld.clear();
        surnameFld.sendKeys(surname);
    }

    public void inputJob(String job){
        jobFld.clear();
        jobFld.sendKeys(job);
    }

    public void inputDob(String dob){
        dobFld.clear();
        dobFld.sendKeys(dob);
    }

    public void selectLanguage(String language){
        switch (language){
            case "English":
                englishLng.click();
                break;
            case "French":
                frenchLng.click();
                break;
            case  "Spanish":
                spanishhLng.click();
                break;
            default:
                break;
        }
    }

    public void selectGender(String gender){
        if( gender.equals("male")){
            maleRbx.click();
        }
        else {femaleRbx.click();}
    }

    public void selectStatus(String status){
        (new Select(statusLov)).selectByValue(status);
    }

    public  void clickAddBtn(){
        addPersonBtn.click();
    }






}

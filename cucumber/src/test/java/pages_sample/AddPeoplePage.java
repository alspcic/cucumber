package pages_sample;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddPeoplePage {


    @FindBy(how = How.ID, using = "name")
    private WebElement nameField;

    @FindBy(how = How.ID, using = "surname")
    private WebElement surnameField;

    @FindBy(how = How.ID, using = "job")
    private WebElement jobField;

    @FindBy(how = How.ID, using = "dob")
    private WebElement dobField;

    @FindBy(how = How.CSS, using = "#ui-datepicker-div")
    private WebElement calendar;

    @FindBy(how = How.ID, using = "english")
    private WebElement englishCheck;

    @FindBy(how = How.ID, using = "french")
    private WebElement frenchCheck;

    @FindBy(how = How.ID, using = "spanish")
    private WebElement spanishhCheck;

    @FindBy(how = How.ID, using = "male")
    private WebElement maleBtn;

    @FindBy(how = How.ID, using = "female")
    private WebElement femaleBtn;

    @FindBy(how = How.ID, using = "status")
    private WebElement statusField;

    @FindBy(how = How.ID, using = "status")
    private WebElement jobType;

    @FindBy(how = How.ID, using = "modal_button")
    private WebElement addBtn;

    public void enterName(String name) {
        nameField.sendKeys(name);
    }

    public void enterSurname(String surname) {
        surnameField.sendKeys(surname);
    }

    public void enterJob(String job) {
        jobField.sendKeys(job);
    }

    public void enterDOB(String DOB) {
        dobField.clear();
        dobField.sendKeys(DOB);
        calendar.click();

    }

    public void clearEnglish(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.invisibilityOf(calendar));
        englishCheck.click();


    }


    public void clickLanguages(String language) {
        switch (language) {
            case "English": {
                englishCheck.click();
                break;
            }
            case "Spanish": {
                spanishhCheck.click();
                break;
            }
            case "French": {
                frenchCheck.click();
                break;
            }
            default:
                throw new RuntimeException("No Language is found for some case");

        }
    }

    public void chooseGender(String gender) {
        if (gender.equals("male"))
            maleBtn.click();
        else if (gender.equals("female"))
            femaleBtn.click();
    }

    public void chooseEmploymentStatus(String employment) {
        Select drop = new Select(jobType);
        drop.selectByVisibleText(employment);

    }

    public void clickAddPeople() {
        addBtn.click();
    }
}

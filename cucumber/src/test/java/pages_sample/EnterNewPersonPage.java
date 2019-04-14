package pages_sample;

import cucumber.api.DataTable;
import helpers.HelperBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class EnterNewPersonPage extends HelperBase {
    public EnterNewPersonPage(WebDriver wd) {
        super(wd);
    }
    JavascriptExecutor jse = (JavascriptExecutor) wd;
    Actions actions = new Actions(wd);

    @FindBy(how = How.CSS, using = "#addPersonBtn:nth-child(1)")
    private WebElement addPersonUpperButton;

    @FindBy(how = How.CSS, using = "#addPersonBtn:nth-child(2)")
    private WebElement CancelListButton;

    @FindBy(how = How.ID, using = "name")
    private WebElement nameInput;

    @FindBy(how = How.ID, using = "surname")
    private WebElement surnameInput;

    @FindBy(how = How.ID, using = "job")
    private WebElement jobInput;

    @FindBy(how = How.ID, using = "dob")
    private WebElement dobInput;


    @FindBy(how = How.XPATH, using = "//*[@id=\"modal_button\"][1]")
    private WebElement addPersonButton;

    @FindBy(how = How.ID,  using = "status")
    private WebElement employeeStatusDropdown ;

    public void clickOnAddPersonButton() {
        actions.moveToElement(addPersonButton).click().perform();
    }

    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterSurname(String surname) {
        surnameInput.clear();
        surnameInput.sendKeys(surname);
    }

    public void enterJob(String job) {
        jobInput.clear();
        jobInput.sendKeys(job);
    }

    public void enterDob(String dob) {
        dobInput.clear();
        dobInput.sendKeys(dob);
        dobInput.sendKeys(Keys.RETURN);
    }

    public void clearLanguages() {

        jse.executeScript("$('#english').click();");
    }
    public void enterLanguage(String language) {
        clearLanguages();
        jse.executeScript(String.format("$('#%s').click();", language));

    }

    public void enterGender(String gender) {
        jse.executeScript(String.format("$('#%s').click();", gender));
    }

    public void enterEmployeeStatus(String employee_status) {
        Select dropdown = new Select(employeeStatusDropdown);
        dropdown.selectByValue(employee_status);
    }

    public void enteringUserInfo(DataTable table) {
        List<Map<String, String>> list = table.asMaps(String.class, String.class);
        enterName(list.get(0).get("Name"));
        enterSurname(list.get(0).get("Surname"));
        enterJob(list.get(0).get("Job"));
        enterDob(list.get(0).get("DOB"));
        enterLanguage(list.get(0).get("Language"));
        enterGender(list.get(0).get("Gender"));
        enterEmployeeStatus(list.get(0).get("Employee_Status"));
    }
}

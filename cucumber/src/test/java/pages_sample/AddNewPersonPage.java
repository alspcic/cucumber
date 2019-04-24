package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddNewPersonPage {

    @FindBy(how = How.CSS, using = ".w3-container h2")
    public WebElement pageTitle;

    @FindBy(how = How.ID, using = "name")
    public WebElement nameTextField;

    @FindBy(how = How.ID, using = "surname")
    public WebElement surnameTextField;

    @FindBy(how = How.ID, using = "job")
    public WebElement jobTextField;

    @FindBy(how = How.ID, using = "dob")
    public WebElement birtDateTextField;

    @FindBy(how = How.ID, using = "english")
    public WebElement englishCheckbox;

    @FindBy(how = How.ID, using = "french")
    public WebElement frenchCheckbox;

    @FindBy(how = How.ID, using = "spanish")
    public WebElement spanishCheckbox;

    @FindBy(how = How.ID, using = "male")
    public WebElement maleRadioButton;

    @FindBy(how = How.ID, using = "female")
    public WebElement femaleRadioButton;

    @FindBy(how = How.ID, using = "status")
    public WebElement employeeDropdown;
}

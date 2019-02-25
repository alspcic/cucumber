package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListOfPeople {

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/h2")
    public WebElement outOfField;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Add person')]")
    public WebElement addPersonButton;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Reset List')]")
    public WebElement resetListButton;

    @FindBy(how = How.ID, using = "name")
    public WebElement nameField;

    @FindBy(how = How.ID, using = "surname")
    public WebElement surnameField;

    @FindBy(how = How.ID, using = "job")
    public WebElement jobField;

    @FindBy(how = How.ID, using = "dob")
    public WebElement dobField;

    @FindBy(how = How.ID, using = "english")
    public WebElement checkboxEnglish;

    @FindBy(how = How.ID, using = "french")
    public WebElement checkboxFrench;

    @FindBy(how = How.ID, using = "spanish")
    public WebElement checkboxSpanish;

    @FindBy(how = How.ID, using = "male")
    public WebElement radioMale;

    @FindBy(how = How.ID, using = "female")
    public WebElement radioFemale;

    @FindBy(how = How.ID, using = "status")
    public WebElement statusDropdown;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Add')]")
    public WebElement addButton;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Cancel')]")
    public WebElement cancelButton;

    // NEWLY ADDED PERSON:
    @FindBy(how = How.XPATH, using = "//*[@id=\"person3\"]")
    public WebElement person4;

    // NEW PERSON #1
    @FindBy(how = How.XPATH, using = "//*[@id=\"person3\"]/div/span[1]")
    public WebElement person4Name;

    @FindBy(how = How.XPATH, using = "//*[@id=\"person3\"]/div/span[2]")
    public WebElement person4Surname;

    @FindBy(how = How.XPATH, using = "//*[@id=\"person3\"]/span[3]")
    public WebElement person4Job;

    @FindBy(how = How.XPATH, using = "//*[@id=\"person3\"]/span[4]")
    public WebElement person4DateOfBirth;

    @FindBy(how = How.XPATH, using = "//*[@id=\"person3\"]/span[5]")
    public WebElement person4Language;

    @FindBy(how = How.XPATH, using = "//*[@id=\"person3\"]/span[6]")
    public WebElement person4Gender;

    @FindBy(how = How.XPATH, using = "//*[@id=\"person3\"]/span[7]")
    public WebElement person4Status;

}


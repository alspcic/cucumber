package Pages.Kristinek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KristinekMainPage {

    public KristinekMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[id='numb']")
    public WebElement numberInputField;
    @FindBy(css = "[type='button']")
    public WebElement submitBtn;
    @FindBy(css = "[id='ch1_error']")
    public WebElement errorMsg;
    @FindBy(css = "[id='name']")
    public WebElement nameField;
    @FindBy(css = "[id='surname']")
    public WebElement surnameField;
    @FindBy(css = "[id='dob']")
    public WebElement dataField;
    @FindBy(css = "[onclick='resetListOfPeople()']")
    public List<WebElement> resetBtn;
    @FindBy(css = "[id='person3']")
//    public WebElement addedPerson;
//    @FindBy(css = "")
    public WebElement pageListOfPeople;
    @FindBy(css = "[onclick='openModalForAddPerson()']")
    public List<WebElement> addPersonBtn;


    public String getErrorMsgText() {
        return errorMsg.getText();
    }
}


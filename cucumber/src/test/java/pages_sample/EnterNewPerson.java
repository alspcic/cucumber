package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class EnterNewPerson {

    @FindBy(how = How.ID, using = "addEditPerson")
    private WebElement addEditPerson;

    @FindBy(how = How.ID, using = "name")
    private WebElement namePerson;
    @FindBy(how = How.ID, using = "surname")
    private WebElement surnamePerson;
    @FindBy(how = How.ID, using = "job")
    private WebElement jobPerson;
    @FindBy(how = How.ID, using = "dob")
    private WebElement dobPerson;
    //english, french, spanish language
    @FindBy(how = How.ID, using = "english")
    private WebElement english;
    @FindBy(how = How.ID, using = "french")
    private WebElement french;
    @FindBy(how = How.ID, using = "spanish")
    private WebElement spanish;
    @FindBy(how = How.ID, using = "male")
    private WebElement male;
    @FindBy(how = How.ID, using = "female")
    private WebElement female;
    @FindBy(how = How.TAG_NAME, using = "option")
    private List<WebElement> option;
    @FindBy(how = How.ID, using = "modal_button")
    private List<WebElement> modal_button;

    public void namePersonEnter(String s) {
        namePerson.sendKeys(s);
    }

    public void surnamePersonEnter(String s) {
        surnamePerson.sendKeys(s);
    }

    public void jobPersonEnter(String s) {
        jobPerson.sendKeys(s);
    }

    public void dobPersonEnter(String s) {
        dobPerson.click();
        dobPerson.sendKeys(s);
    }

    public void english(int n) {
        if ((english.isSelected() && n != 1) || (!english.isSelected() && n == 1)) {
            english.click();
        }
    }

    public void french(int n) {
        if ((french.isSelected() && n != 1) || (!french.isSelected() && n == 1)) {
            french.click();
        }
    }

    public void spanish(int n) {
        if ((spanish.isSelected() && n != 1) || (!spanish.isSelected() && n == 1)) {
            spanish.click();
        }
    }

    public void gender(String s) {
        if (s.trim().contentEquals("male") && !male.isSelected()) male.click();
        else female.click();
    }

    public void optionChose(String s) {
        for (WebElement item : option) {
            if (item.getText().toUpperCase().contentEquals(s.toUpperCase())) {
                item.click();
                break;
            }
        }
    }

    public void addButton() {
        for (WebElement item : modal_button) {
            if (item.getText().toUpperCase().contentEquals("ADD")) {
                item.click();
                break;
            }
        }
    }
}
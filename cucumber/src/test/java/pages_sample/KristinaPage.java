package pages_sample;

import helpers.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;

public class KristinaPage extends HelperBase {
    public KristinaPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(how = How.ID, using = "numb")
    private WebElement buttonEnterNumber;

    @FindBy(how = How.ID, using = "ch1_error")
    private WebElement warningText;

    @FindBy(how = How.CSS, using = "[class = 'w3-btn w3-orange w3-margin']")
    private WebElement submitButton;

    @FindBy(how = How.CSS, using = "#addPersonBtn:nth-child(1)")
    private WebElement addAnewPersonButton;


  public String baseUrl = "https://kristinek.github.io/site";

    public String getKristinaPageUrl(String menuItem) {
//        String baseUrl = "";
        switch (menuItem) {
            case "enter a number":
                baseUrl = baseUrl + "/tasks/enter_a_number";
                break;
            case "people with jobs":
                baseUrl = baseUrl + "/tasks/list_of_people.html";
                break;
            case "adding person":
                baseUrl = baseUrl + "/tasks/enter_a_new_person.html";
                break;
            default:
                System.out.println("Check 'getKristinaPageUrl' parameters");
        }
        return baseUrl;
    }

    public void enterNumber(String number) {
        buttonEnterNumber.clear();
        buttonEnterNumber.sendKeys(number);
    }

    public void clickButton(String nameButton) {
        switch (nameButton) {
            case "submit":
                submitButton.click();
                break;
            case "add a new":
                wd.findElement(By.cssSelector("#addPersonBtn:first-child")).click();
//                addAnewPersonButton.click();
                break;
            default:
                System.out.println("Check 'iEnterNumber' method");
        }

    }

    public void checkAllert(String text) {
        assertEquals(text, warningText.getText());
    }

    public void numberValidation(String statement, int number) {

        boolean condition = false;
        switch (statement) {
            case "invalid":
                if (number >= 101 || number <= 49)
                    condition = true;
                assertEquals(true, condition);
                break;
            case "valid":
                if (number <= 50 || number <= 100)
                    condition = true;
                assertEquals(true, condition);
                break;
            default:
                System.out.println("Check 'iEnterNumber' method");
        }
    }
}

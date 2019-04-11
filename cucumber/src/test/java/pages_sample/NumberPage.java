package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NumberPage {
    @FindBy(how = How.XPATH, using = "//div[@class='w3-container w3-amber']")
    private WebElement numberHeader;
    @FindBy(how = How.XPATH, using = "//input[@id='numb']")
    private WebElement inputField;
    @FindBy(how = How.XPATH, using = "//button[@type='button']")
    private WebElement submitButton;
    @FindBy(how = How.XPATH, using = "//p[@id='ch1_error']")
    private WebElement errorMessge;

    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/enter_a_number";
    }

    public boolean checkNumberHeaderIsPresented() {
        return numberHeader.isDisplayed();
    }

    public boolean checkInputFieldIsPresented() {
        return inputField.isDisplayed();
    }

    public void enterNumber(String number) {
        inputField.sendKeys(number);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getErrorMessageText() {
        return errorMessge.getText();
    }
}

package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddNewPersonPage {
    @FindBy(how = How.XPATH, using = "//h2")
    private WebElement pageHeader;
    @FindBy(how = How.XPATH, using = "//button[@onclick='openModalForAddPerson()']")
    private WebElement clearAllFieldsButton;
    @FindBy(how = How.XPATH, using = "//button[@onclick='addPersonToList()']")
    private WebElement addButton;
    @FindBy(how = How.XPATH, using = "//button[@onclick='window.history.back()']")
    private WebElement cancelButton;
    @FindBy(how = How.XPATH, using = "//select[@name='option']")
    private WebElement employeeDropdown;

    public boolean pageIsLoaded() {
        return (pageHeader.isDisplayed() && addButton.isDisplayed());
    }

    public boolean clearAllFieldsButtonIsDisplayed() {
        return clearAllFieldsButton.isDisplayed();
    }

    public boolean addButtonIsDisplayed() {
        return addButton.isDisplayed();
    }

    public boolean canselButtonIsDisplayed() {
        return cancelButton.isDisplayed();
    }

    public void clearAllFieldsButtonClick() {
        clearAllFieldsButton.click();
    }

    public void addButtonClick() {
        addButton.click();
    }

    public void cancelButtonClick() {
        cancelButton.click();
    }

    public void selectValueInEmployeeDropdown(String value) {
        employeeDropdown.click();
        employeeDropdown.findElement(By.xpath("//option[@value='" + value.toLowerCase() + "']")).click();
    }

    public void focusOut() {
        pageHeader.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Task2PageObject {

    @FindBy(how = How.ID, using = "h1")
    public WebElement pageTitle;

    @FindBy(how = How.CSS, using = ".w3-dropdown-hover:nth-child(3)")
    public WebElement taskToolbar;

    @FindBy(how = How.XPATH, using = "//a[text()='Enter a number']")
    public WebElement enterNumberToolbar;

    @FindBy(how = How.CSS, using = ".w3-container.w3-amber h2")
    public WebElement enterNumberTitle;

    @FindBy(how = How.CSS, using = "#numb ~button")
    public WebElement submitButton;

    @FindBy(how = How.ID, using = "numb")
    public WebElement enterNumberTextField;

    @FindBy(how = How.ID, using = "ch1_error")
    public WebElement enterNumberErrorContainer;
}

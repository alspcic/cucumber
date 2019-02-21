package Pages.Kristinek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

}


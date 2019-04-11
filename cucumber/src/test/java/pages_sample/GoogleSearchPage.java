package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.junit.Assert.assertEquals;

public class GoogleSearchPage {
    @FindBy(how = How.NAME, using = "btnI")
    public WebElement buttonIamHappy;

    @FindBy(how = How.NAME, using = "q")
    public WebElement searhTextBox;

    @FindBy(how = How.CSS, using = ".aajZCb [name = \"btnK\"]")
    public WebElement buttonGo;

    @FindBy(how = How.ID, using = "resultStats")
    public WebElement resultStatus;

    public void ClickHappyButton() {
        buttonGo.click();
    }

    public void EnterSearcThext(String text) {
        searhTextBox.sendKeys(text);
    }

}





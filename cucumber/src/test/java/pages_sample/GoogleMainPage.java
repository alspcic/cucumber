package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleMainPage {

    @FindBy(how = How.NAME, using = "btnK")
    public WebElement searchButtonText;

    @FindBy(how = How.NAME, using = "btnI")
    public WebElement luckyButtonText;

    @FindBy(how = How.ID, using = "hplogo")
    public WebElement logo;
}

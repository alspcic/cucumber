package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import javax.naming.Name;

public class Task1PageObjectClass {

    @FindBy(how = How.NAME, using = "btnK")
    public WebElement searchButton;

    @FindBy(how = How.NAME, using = "btnI")
    public WebElement luckyButton;

    @FindBy(how = How.ID, using = "hplogo")
    public WebElement googleImage;

    //public void isElementDisplayedSearch() {
    //    searchButton.isDisplayed();
    //}
//
    //public void isElementDisplayedLucky() {
    //    luckyButton.isDisplayed();
    //}
}

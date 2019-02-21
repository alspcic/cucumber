package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class googlePage {
    @FindBy(how = How.CSS, using = "input[name='btnK'][type='submit']")
    private WebElement searchButton;
    @FindBy(how = How.CSS, using = "input[name='btnI'][type='submit']")
    private WebElement luckyButton;
    @FindBy(how = How.ID, using = "hplogo")
    private WebElement googleLogo;
    @FindBy(how = How.NAME, using = "q")
    private WebElement searchField;

    public String getPageUrl() {
        return "https://google.com";
    }

    public void enterSearch(String name) {
        searchField.clear();
        searchField.sendKeys(name);
    }

    public void checkTextSearch(String value) {
        assertEquals(searchButton.getAttribute("value"), value);
        assertTrue(searchButton.isDisplayed());
    }

    public void clickTextLucky(String secondValue) {
        assertEquals(luckyButton.getAttribute("value"), secondValue);
        assertTrue(luckyButton.isDisplayed());
    }

    public void checkLogo() {
        assertTrue(googleLogo.isDisplayed());
    }
}

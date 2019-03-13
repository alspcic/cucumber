package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.junit.Assert.*;


public class googlePage {
    @FindBy(how = How.CSS, using = "input[name='btnK'][type='submit']") //css
    private WebElement searchButton;
    @FindBy(how = How.CSS, using = "input[name='btnI'][type='submit']") //css
    private WebElement luckyButton;
    @FindBy(how = How.ID, using = "hplogo") //id
    private WebElement googleImage;
    @FindBy(how = How.NAME, using = "q") //name
    private WebElement searchField;

    public String getPageUrl() {
        return "https://www.google.com";
    }

    public void checkSearchButton(String searchText) {
        assertEquals(searchButton.getText(), searchText);
        assertTrue(searchButton.isDisplayed());
    }

    public void checkLuckyButton(String luckyText) {
        assertEquals(luckyButton.getText(), luckyText);
        assertTrue(luckyButton.isDisplayed());
    }

    public void checkGoogleLogo () {
        assertTrue(googleImage.isDisplayed());
    }

    public void searchField (String name) { //name
        searchField.clear();
        searchField.sendKeys(name);
    }

}

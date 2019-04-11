package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GooglePage {
    @FindBy(how = How.NAME, using = "btnI")
    private WebElement luckyBtn;

    @FindBy(how = How.NAME, using = "btnK")
    private WebElement searchBtn;

    @FindBy(how = How.NAME, using = "q")
    private WebElement searchBox;

    @FindBy(how = How.ID, using = "resultStats")
    private WebElement resultField;

    public String getPageUrl() {
        return "https://www.google.com";
    }

    public void checkButtonText(String messageText) {
        assertEquals(messageText, luckyBtn.getAttribute("value"));

    }
    public void enterSearchText(String searchText) {
        searchBox.clear();
        searchBox.sendKeys(searchText);}

        public void clickSearchBtn() {
        searchBtn.click();

    }

    public void checkResultText(String resultText) {
        assertTrue(resultField.getText().contains(resultText));

    }
}

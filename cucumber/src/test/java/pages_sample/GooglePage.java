package pages_sample;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GooglePage {
    @FindBy(how = How.ID, using = "btnI") // By.id("btnI")
    private WebElement buttonSearch; // WebElement nameInput = driver.findElement(By.id("btnI"));

    @FindBy(how = How.NAME, using = "q") // By.name("q")
    private WebElement searchInput;

    @FindBy(how = How.CLASS_NAME, using = "srg") // By.name("q")
    List<WebElement> searchResults;

    @FindBy(how = How.CLASS_NAME, using = "srg") // By.name("q")
    private WebElement result;



    public String getPageUrl() {
        return "https://google.com";
    }

    public void verifyLuckyButton() throws Throwable {
        String defaultText = "Es ticu veiksmei!";
        String text = buttonSearch.getAttribute("value");
        assertEquals(defaultText, text);
    }

    public void enterSomeText() throws Throwable {
        String someText = "some text";
        searchInput.clear();
        searchInput.sendKeys(someText);
        searchInput.sendKeys(Keys.RETURN);
    }

    public void verifySearchResult() throws Throwable {
        int empty = 0;
        int size = searchResults.size();
        assertNotEquals(size, empty);
    }

}

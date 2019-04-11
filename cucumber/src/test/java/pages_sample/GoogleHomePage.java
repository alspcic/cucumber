package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleHomePage {

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'FPdoLc')]//input[@name='btnI']")
    private WebElement luckyButton; // WebElement nameInput = driver.findElement(By.id("name"));
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'FPdoLc')]//input[@name='btnK']")
    private WebElement searchButton; // WebElement nameInput = driver.findElement(By.id("name"));
    @FindBy(how = How.NAME, using = "q")
    private WebElement searchBox; // WebElement nameInput = driver.findElement(By.id("name"));

    public String getPageUrl() {
        return "https://www.google.com";
    }

    public void clickSubmitButton() {
        searchButton.click();
    }

    public void enterSearchText(String text) {
        searchBox.clear();
        searchBox.sendKeys(text);
    }

    public String getLuckyButtonText() {
        return luckyButton.getAttribute("value");
//        return luckyButton.getText();
    }
}

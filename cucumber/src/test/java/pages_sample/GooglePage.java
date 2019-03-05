package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GooglePage {
//    id="hplogo"
@FindBy(how = How.ID, using = "hplogo") // By.id("name")
private WebElement nameInput; // WebElement nameInput = driver.findElement(By.id("name"));
}

package Pages.Google;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PO2Google {
    @FindBy(how = How.CSS, using = ".FPdoLc [name=btnK]") // By.css("")
    private WebElement Srchbtn; // WebElement nameInput = driver.findElement(By.css(""));
    @FindBy(how = How.CSS, using = ".FPdoLc [name=btnI]") // By.css("")
    private WebElement Luckybtn;
    @FindBy(how = How.ID, using = "hplogo")
    private WebElement logo;
    @FindBy(how = How.CLASS_NAME, using = "error") // By.className("error)
    private WebElement errorText;

    public void iVerifyText() {
        String Actual = Srchbtn.getAttribute("value");
        Assert.assertEquals("Google meklēšana",Actual);

    }
}


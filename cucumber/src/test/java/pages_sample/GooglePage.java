package pages_sample;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;

public class GooglePage {
    @FindBy(how = How.NAME, using = "btnK")
    private WebElement searchButton;
    @FindBy(how = How.NAME, using = "btnI")
    private WebElement feelingButton;
    @FindBy(how = How.ID, using = "hplogo")
    private WebElement googleImage;

public String getPageUrl()
{
    return "https://www.google.com";
}

    public void checkGoogleButtonText()
    {
        assertEquals("Google meklēšana",
                searchButton.getAttribute("value"));
    }

    public void checkFeelingButtonText()
    {
        assertEquals("Es ticu veiksmei!",
                feelingButton.getAttribute("value"));
    }

    public void checkGoogleImageExists()
    {
        assertNotNull("image exists" ,
                googleImage);
    }
}

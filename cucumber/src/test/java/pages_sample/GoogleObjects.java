package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;

public class GoogleObjects {
    @FindBy(how = How.XPATH, using = "//*[@name='btnI']")
    public WebElement luckybtn;

    @FindBy(how = How.XPATH, using = "//*[@name='btnK']")
    public WebElement searchbtn;

    @FindBy(how = How.ID, using = "hplogo")
    public WebElement googlelogo;

    @FindBy(how = How.XPATH, using = "//input[contains(@title, 'Search')]")
    public WebElement searchinput;


  //========== Square Root Task Objects ================//

    @FindBy(how = How.ID, using = "numb")
    public WebElement inputnumber;

    @FindBy(how = How.XPATH, using = "//button[contains(@text = 'Submit')]")
    public WebElement submitbtn;


}

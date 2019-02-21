package Pages.Google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {
    public GoogleMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[class='FPdoLc VlcLAe'] [name='btnK']")
    public WebElement googleSearchBtn;
    @FindBy(css = "[class='FPdoLc VlcLAe'] [name='btnI']")
    public WebElement googleLuckyBtn;
    @FindBy(css = "[id='hplogo']")
    public WebElement googleLogo;
}

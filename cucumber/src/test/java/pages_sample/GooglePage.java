package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GooglePage {

    @FindBy(how = How.NAME, using = "btnK")
    private WebElement searchBtn;

    @FindBy(how = How.NAME, using = "q")
    private WebElement inputField;

    @FindBy(how = How.NAME, name = "btnI")
    private WebElement luckyBtn;

    @FindBy(how = How.ID, name = "resultStats")
    private WebElement resultStatus;

    @FindBy(how = How.ID, name = "hplogo")
    private WebElement googleLogo;

    public String getPageURL() {return "https://www.google.com/";}

    public void inputValue(String value){
        inputField.clear();
        inputField.sendKeys(value);
    }

    public void clickSearchBtn(){
        searchBtn.click();
    }

    public boolean gooleLogoDisplayed(){
       return googleLogo.isDisplayed();
    }

    public String getResultstatus(){
       return resultStatus.getText();
    }

    public String getSearchBtnTitle(){
        return searchBtn.getAttribute("value");
    }

    public String getLuckyBtnTitle(){
        return luckyBtn.getAttribute("value");
    }




}

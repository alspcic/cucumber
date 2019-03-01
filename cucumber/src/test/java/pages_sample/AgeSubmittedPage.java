package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;

public class AgeSubmittedPage {
    @FindBy(how = How.CSS, using = "#message")
    private WebElement message;
    @FindBy(how = How.TAG_NAME, using = "button")
    private WebElement backButton;

    public void clickBackButton() {
        backButton.click();
    }

    public void checkMessageText(String messageText) {
        assertEquals(message.getText(), messageText);

    }

    @FindBy(xpath = "//div[2]//button[1]")
    public WebElement addNewUserButton;
    public WebElement addUserButton(){
        return addNewUserButton;
    }


    @FindBy(xpath = "//h2[contains(text(),'People with jobs')]")
    WebElement pageTitle;
    public  WebElement PageTitleVerification(){
        return  pageTitle;
    }

   @FindBy(xpath = "//div[@id='addEditPerson']//p[1]//input[1]")
    WebElement name;
    public WebElement firstName(){
        return  name;
    }

    @FindBy(css = "#surname")
    WebElement surname;
    public WebElement Surname(){
        return surname;
    }

    @FindBy(css = "#job")
    WebElement job;
    public WebElement job(){
        return job;
    }


    @FindBy (css = "input[id ='dob']" )
    WebElement dateOfBirth;
    public WebElement dateofBirth(){
        return dateOfBirth;
    }

    //!driver.findElement(By.className("ui-datepicker-year"))
    @FindBy (className = "ui-datepicker-year" )
    WebElement year;
    public WebElement year(){
        return year;
    }


    @FindBy (className = "ui-icon-circle-triangle-w" )
    WebElement goback;
    public WebElement goBack(){
        return goback;
    }


    @FindBy (className = "ui-datepicker-month" )
    WebElement month;
    public WebElement month(){
        return month;
    }


//    @FindBy (className =  "ui-state-default" )
//    WebElement day;
//    public WebElement day(){
//        return day;
//    }

    @FindBy(id = "spanish")
    WebElement languSpanish;
    public WebElement languSpanish()
    {
        return languSpanish;
    }

    //
    @FindBy(css = "input[id='male']")
    WebElement genderMale;
    public WebElement genderMale()
    {
        return genderMale;
    }


    @FindBy(css = "select[id='status']")
    WebElement position;
    public WebElement position()
    {
        return position;
    }

    @FindBy(xpath = "//button[contains(text(),'Add')]")
    WebElement addUser;
    public WebElement addUser()
    {
        return addUser;
    }
}
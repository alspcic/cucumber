package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertTrue;

public class ListOfPeoplePage {
    @FindBy(how = How.ID, using = "addPersonBtn")
    private WebElement addPersonBtn;

    @FindBy(how = How.CSS, using = "#person3 > span.w3-closebtn.closebtn.w3-padding.w3-margin-right.w3-medium")
    private WebElement deleteBtn;

    @FindBy(how = How.ID, using = "person3")
    private WebElement fourthPerson;

    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people";
    }

    public void clickAddBtn(){
        addPersonBtn.click();
    }

    public void checkFourthPerson(){
        assertTrue(fourthPerson.isDisplayed());
    }



    public void deletePeople(){
        deleteBtn.click();
    }

}

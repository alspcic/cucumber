package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;
import static org.junit.Assert.*;

public class PeopleListPage {
    @FindBy(how= How.XPATH,using = "//button[@onclick='openModalForAddPerson()']")
    private WebElement addPersonBtn;

    @FindBy(how=How.CSS,using = ".w3-card-4#listOfPeople")
    private WebElement listOfPeople;

    @FindBy(how=How.CSS,using = ".name")
    private List<WebElement> peopleNameList;

    public String getPeopleListPageUrl(){
        return "https://kristinek.github.io/site/tasks/list_of_people";
    }

    public void checkListOfPeopleDisplayed(){
        assertTrue("The page is not displayed",listOfPeople.isDisplayed());
    }

    public void clickAddNewPersonBtn(){
        addPersonBtn.click();
    }

    public boolean isPersonAdded(String name){
        for(int i=0;i<peopleNameList.size();i++){
            if(peopleNameList.get(i).getText().equals(name)){
                return true;
            }
        }
        return false;
    }


}

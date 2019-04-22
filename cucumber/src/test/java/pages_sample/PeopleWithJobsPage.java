package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PeopleWithJobsPage{
    private WebDriver driver;

    @FindBy(how = How.ID, using = "header")
    public WebElement pageHeader;

    @FindBy(how = How.CSS, using = "button[onClick=\'openModalForAddPerson()\']")
    private List<WebElement> buttonAdd;

    @FindBy(how = How.CSS,using = "button[onClick=\'resetListOfPeople()\']")
    private List<WebElement> buttonReset;


    @FindBy(how = How.ID, using = "listOfPeople")
    private WebElement listOfPeople;

    public void ClickButtonAdd(int loc){
        buttonAdd.get(loc).click();
    }

    public void ClickButtonReset(int loc){
        buttonReset.get(loc).click();
    }

    public void CheckPersonCount(int count){
        List<WebElement> people = listOfPeople.findElements(By.className("w3-padding-16"));
        assertTrue(people.size() == count);
    }

    public void EditPerson(String name){
        List<WebElement> people = listOfPeople.findElements(By.className("w3-xlarge"));
        for(int i=0; i < people.size() ; i++){
            if(people.get(i).getAttribute("innerText").equals(name)){
                people.get(i).findElement(By.cssSelector(".w3-closebtn.editbtn.w3-padding.w3-margin-right.w3-medium")).click();
            }
        }
    }

    public void DeletePerson(String name){
    List<WebElement> people = listOfPeople.findElements(By.className("w3-padding-16"));
        for(int i=0; i < people.size(); i++){
            if(people.get(i).findElement(By.className("w3-xlarge ")).getAttribute("innerText").equals(name)){
                people.get(i).findElement(By.cssSelector(".w3-closebtn.closebtn.w3-padding.w3-margin-right.w3-medium")).click();
            }
        }
    }
}

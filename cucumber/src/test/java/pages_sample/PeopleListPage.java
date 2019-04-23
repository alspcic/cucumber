package pages_sample;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PeopleListPage {
    @FindBy(how = How.CSS, using = "button:first-of-type")
    public WebElement addPersonButton;


    @FindBy(how = How.ID, using = "listOfPeople")
    public WebElement personsList;



    public String getPageURL()
    {
        return "https://kristinek.github.io/site/tasks/list_of_people";
    }

}

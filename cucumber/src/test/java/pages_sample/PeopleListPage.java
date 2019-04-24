package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class PeopleListPage {

    @FindBy(how = How.CSS, using = ".w3-container h2")
    public WebElement pageTitle;

    @FindBy(how = How.CSS, using = ".w3-container #listOfPeople")
    public WebElement peopleList;

    @FindBy(how = How.CSS, using = ".w3-container #listOfPeople div div")
    public List<WebElement> peopleListTable;

    @FindBy(how = How.CSS, using = ".fa.fa-pencil")
    public List<WebElement> editIconButton;

    @FindBy(how = How.CSS, using = ".w3-closebtn.closebtn")
    public List<WebElement> deleteIconButton;

    @FindBy(how = How.CLASS_NAME, using = "copyrights")
    public WebElement copyRightText;
}

package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class PeoplePage {

    @FindBy(how = How.CLASS_NAME, using = "w3-padding-16") //w3-padding-16
    private List<WebElement> people;

    @FindBy(how = How.ID, using = "addPersonBtn")
    private WebElement addButton;

    public int peopleCount() {
        return people.size();
    }

    public void addPerson() {
        addButton.click();
    }

    public String lastPersonName() {
        return people.get(people.size()-1).findElement(By.className("name")).getText();
    }

    public String lastPersonSurname() {
        return people.get(people.size()-1).findElement(By.className("surname")).getText();
    }

    public String lastPersonJob() {
        return people.get(people.size()-1).findElement(By.className("job")).getText();
    }

    public String lastPersonDob() {
        return people.get(people.size()-1).findElement(By.className("dob")).getText();
    }

    public String lastPersonLanguage() {
        return people.get(people.size()-1).findElement(By.className("language")).getText();
    }

    public String lastPersonGender() {
        return people.get(people.size()-1).findElement(By.className("gender")).getText();
    }

    public String lastPersonStatus() {
        return people.get(people.size()-1).findElement(By.className("status")).getText();
    }
}

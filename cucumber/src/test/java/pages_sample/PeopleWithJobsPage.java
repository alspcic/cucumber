package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class PeopleWithJobsPage {
    @FindBy(how = How.XPATH, using = "//h2")
    private WebElement pageHeader;
    @FindBy(how = How.XPATH, using = "//button[@onclick='openModalForAddPerson()']")
    private List<WebElement> addButtons;
    @FindBy(how = How.XPATH, using = "//button[@onclick='resetListOfPeople()']")
    private List<WebElement> resetButtons;
    @FindBy(how = How.XPATH, using = "//span[contains(@onclick, 'deletePerson')]")
    private List<WebElement> deleteButtons;
    @FindBy(how = How.XPATH, using = "//ul/div")
    private List<WebElement> personCards;

    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people";
    }

    public boolean pageIsLoaded() {
        return (pageHeader.isDisplayed() && addButtons.get(0).isDisplayed());
    }

    public boolean topAddButtonIsDisplayed() {
        return addButtons.get(0).isDisplayed();
    }

    public boolean topResetButtonIsDisplayed() {
        return resetButtons.get(0).isDisplayed();
    }

    public void topAddButtonClick() {
        addButtons.get(0).click();
    }

    public void topResetButtonClick() {
        resetButtons.get(0).click();
    }

    public void deletePersonFromList(int personNumber) {
        deleteButtons.get(personNumber-1).click();
    }

    public int personNumberInTheList() {
        return personCards.size();
    }
}

package Pages.Kristinek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ElementObject;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PeopleWithJobs {
    
    
        public PeopleWithJobs (WebDriver driver) { PageFactory.initElements(driver, this); }
        
        @FindBy(css = "[onclick='resetListOfPeople()']")
        public List<WebElement> resetBtn;
        @FindBy(css = "[onclick='openModalForAddPerson()']")
        public List<WebElement> addPersonBtn;
        @FindBy(css = "[onclick='openModalForAddPerson()']")
        public WebElement clearAllFieldsBtn;
        @FindBy(css = "[id='name']")
        public WebElement nameField;
        @FindBy(css = "[id='surname']")
        public WebElement surnameField;
        @FindBy(css = "[id='job']")
        public WebElement jobField;
        @FindBy(css = "[id='dob']")
        public WebElement dateOfBirthField;
        @FindBy(css = "[onclick='addPersonToList()']")
        public WebElement addBtn;
        @FindBy(css = "[onclick='window.history.back()']")
        public WebElement cancelBtn;
        

        @FindBy(css = "[id='english']")
        public WebElement englishChbx;
        @FindBy(css = "[id='french']")
        public WebElement frenchChbx;
        @FindBy(css = "[id='spanish']")
        public WebElement spanishChbx;

        @FindBy(css = "[id='male']")
        public WebElement maleRadio;
        @FindBy(css = "[id='male']")
        public WebElement femaleRadio;
}

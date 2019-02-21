//package stepDefinitions;
//
//import cucumber.api.PendingException;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
//
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.Assert.*;
//
//public class SampleSteps {
//    private WebDriver driver;
//
//    public SampleSteps() {
//        this.driver = Hooks.driver;
//    }
//
//    @Given("^I am on the home page$")
//    public void iAmOnTheHomePage() throws Throwable {
//        driver.get("https://kristinek.github.io/site");
//    }
//
//    @Then("^I should see home page header$")
//    public void iShouldSeeHomePageHeader() throws Throwable {
//        assertEquals("This is a home page",
//                driver.findElement(By.cssSelector("h1")).getText());
//    }
//
//    @And("^I should see home page description$")
//    public void iShouldSeeHomePageDescription() throws Throwable {
//        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
//                driver.findElement(By.cssSelector("p")).getText());
//    }
//
//    @When("^I enter name: \"([^\"]*)\"$")
//    public void iEnterName(String name) throws Throwable {
//        driver.findElement(By.id("name")).clear();
//        driver.findElement(By.id("name")).sendKeys(name);
//    }
//
//    @And("^I enter age: (\\d+)$")
//    public void iEnterAge(int age) throws Throwable {
//        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
//    }
//
//    @Given("^I (?:am on|open) age page$")
//    public void iAmOnAgePage() throws Throwable {
//        driver.get("https://kristinek.github.io/site/examples/age");
//    }
//
//    @And("^I click submit age$")
//    public void iClickSubmitAge() throws Throwable {
//        driver.findElement(By.id("submit")).click();
//    }
//
//    @Then("^I see message: \"([^\"]*)\"$")
//    public void iSeeMessage(String message) throws Throwable {
//        assertEquals(message, driver.findElement(By.id("message")).getText());
//    }
//
//    @When("^I enter values:$")
//    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
//        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
//            driver.findElement(By.id(e.getKey())).clear();
//            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
//            System.out.println("key is " + e.getKey());
//            System.out.println("value is " + e.getValue());
//        }
//    }
//
//    @And("^I should see menu$")
//    public void iShouldSeeMenu() throws Throwable {
//        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
//    }
//
//    @And("^I click the result checkbox button$")
//    public void iClickTheResultCheckboxButton() throws Throwable {
//        driver.findElement(By.id("result_button_checkbox")).click();
//    }
//
//    @When("^I clicked on checkboxes:$")
//    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
//        for (String value : values) {
//            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
//        }
//    }
//
//    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
//    public void messageForCheckboxesIsSeen(String message) throws Throwable {
//        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
//    }
//
//    @Given("^I am on action page$")
//    public void iAmOnActionPage() {
//        driver.get("https://kristinek.github.io/site/examples/actions");
//    }
//
//    @And("^none of the checkboxes are selected$")
//    public void noneOfTheCheckboxesAreSelected() {
//        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("[type='checkbox']"));
//        for (WebElement checkbox : allCheckboxes) {
//            assertFalse(checkbox.isSelected());
//        }
//    }
//
//    @When("^I select option 1 checkbox$")
//    public void iSelectOption1Checkbox() {
//        driver.findElement(By.id("vfb-6-0")).click();
//    }
//
//    @Then("^I see that option 1 checkbox is selected$")
//    public void iSeeThatOption1CheckboxIsSelected() {
//        assertTrue(driver.findElement(By.id("vfb-6-0")).isSelected());
//    }
//
//    @And("^none of the radio buttons are selected$")
//    public void noneOfTheRadioButtonsAreSelected() {
//        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("[type='radio']"));
//        for (WebElement checkbox : allCheckboxes) {
//            assertFalse(checkbox.isSelected());
//        }
//
//    }
//
//    @When("^I select option 1 radio button$")
//    public void iSelectOption1RadioButton() {
//        driver.findElement(By.id("vfb-7-1")).click();
//    }
//
//    @Then("^I see that option 1 radio button is selected$")
//    public void iSeeThatOption1RadioButtonIsSelected() {
//        assertTrue(driver.findElement(By.id("vfb-7-1")).isSelected());
//    }
//
//    @And("^I see \"([^\"]*)\" is selected in dropdown$")
//    public void iSeeIsSelectedInDropdown(String exectedText) throws Throwable {
//        assertEquals(exectedText,
//                new Select(driver.findElement(By.id("vfb-12"))).getFirstSelectedOption().getText());
//    }
//
//    @When("^I select \"([^\"]*)\" by text$")
//    public void iSelectByText(String visibleText) throws Throwable {
//        new Select(driver.findElement(By.id("vfb-12"))).selectByVisibleText(visibleText);
//    }
//
//    @When("^I select \"Option 1\" by index$")
//    public void iSelectByIndex() throws Throwable {
//        new Select(driver.findElement(By.id("vfb-12"))).selectByIndex(1);
//    }
//
//    @When("^I select \"Option 1\" by value$")
//    public void iSelectByValue() throws Throwable {
//        new Select(driver.findElement(By.id("vfb-12"))).selectByValue("value1");
//    }
//}

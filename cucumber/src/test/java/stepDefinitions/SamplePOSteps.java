package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages_sample.AgePage;
import pages_sample.AgeSubmittedPage;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class SamplePOSteps {
    private WebDriver driver;
    static AgePage agePage;
    static AgeSubmittedPage ageSubmittedPage;
    int rowCOunt;
    WebElement table;



    public SamplePOSteps() {
        this.driver = Hooks.driver;
        agePage = PageFactory.initElements(Hooks.driver, AgePage.class);
        ageSubmittedPage = PageFactory.initElements(Hooks.driver, AgeSubmittedPage.class);


    }


    @Given("^i am on the page$")
    public void i_am_on_the_page() throws Throwable {
        driver.get(" https://kristinek.github.io/site/tasks/list_of_people");

        driver.manage().window().maximize();
          table = driver.findElement(By.cssSelector("ul[id='listOfPeople']"));
        rowCOunt = table.findElements(By.className("w3-padding-16")).size();
    }

    @When("^i click on Add person$")
    public void iClickOnAddPerson() throws Throwable {

       ageSubmittedPage.addNewUserButton.click();

    }

    @Then("^another webpage open with title People with jobs$")
    public void another_webpage_open_with_title_People_with_jobs() throws Throwable {

     String value =  ageSubmittedPage.PageTitleVerification().getText();
      assertEquals( "People with jobs", value);
    }

    @When("^I enter Names$")
    public void iEnterNames() throws Throwable {
        ageSubmittedPage.firstName().sendKeys("Jhon");
    }
    @When("^I enter surname$")
    public void i_enter_surname() throws Throwable {
        ageSubmittedPage.Surname().sendKeys("Alex");
    }

    @When("^I enter job$")
    public void i_enter_job() throws Throwable {
         ageSubmittedPage.job().sendKeys("Tester");
         // Name, Surname and job can also be done through scenario outline

    }

    @When("^i select date of birth$")
    public void i_select_date_of_birth() throws Throwable {

      // suppose i want to select date of birth 01 December 1994
        // if you know better way than this kindly share with me.
       String names= ageSubmittedPage.dateofBirth().getAttribute("type");


        WebElement dof = ageSubmittedPage.dateofBirth();
        dof.click();

        while(!ageSubmittedPage.year().getText().contains("1994")){    //here it is also possible to check year is smaller or greater than by default year on calender,and according to it system click on next or previous button for year seletion. FYI

            ageSubmittedPage.goBack().click();

        }
        while(!ageSubmittedPage.month().getText().contains("December")){
            ageSubmittedPage.goBack().click();
        }

        List<WebElement> days =  driver.findElements(By.className("ui-state-default"));
        int numberDays = driver.findElements(By.className("ui-state-default")).size();
        for(int i  = 0; i<numberDays;i++){
            String nameDays = driver.findElements(By.className("ui-state-default")).get(i).getText();
            if(nameDays.equalsIgnoreCase("1")){
                driver.findElements(By.className("ui-state-default")).get(i).click();
                break;
            }
        }


    }

    @When("^i chose check box (\\d+) and (\\d+)$")
    public void i_chose_check_box_and(int arg1, int arg2) throws Throwable {
        ageSubmittedPage.languSpanish().click();
    }
    @When("^i select gender as male$")
    public void i_select_gender_as_male() throws Throwable {
        ageSubmittedPage.genderMale().click();
    }
    @When("^i select employee status from the drop down list$")
    public void i_select_employee_status_from_the_drop_down_list() throws Throwable {

        Select dropdown = new Select(ageSubmittedPage.position());
        dropdown.selectByVisibleText("Intern");
    }
    @When("^i click on Add button$")
    public void i_click_on_Add_button() throws Throwable {
        ageSubmittedPage.addUser().click();
    }
    @Then("^the record of employee add successfully and return me to main page$")
    public void the_record_of_employee_add_successfully_and_return_me_to_main_page() throws Throwable {
        table = driver.findElement(By.cssSelector("ul[id='listOfPeople']"));
     int countAgain =   table.findElements(By.className("w3-padding-16")).size();
     if(countAgain > rowCOunt){
         System.out.println("Employee added sucessfully");
         //here it is also possible to verify added user by name or any other attribute, once it is verify that user added successfully.
     }


    }

    @Given("^i am on a required page$")public void i_am_on_a_required_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        driver.manage().window().maximize();
    }
    @When("^i enter number in between (\\d+) and (\\d+)$")
    public void iEnterNumberInBetweenAnd(int arg0, int arg1) throws Throwable {
        driver.findElement(By.cssSelector("#numb")).sendKeys("59");
       // Thread.sleep(2000); it is always good to use implicit or explicit driver.wait
    }

    @When("^click on Submit button$")
    public void click_on_Submit_button() throws Throwable {
        driver.findElement(By.className("w3-btn")).click();

    }

    @Then("^find out square root of it$")
    public void findOutSquareRootOfIt() throws Throwable {
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


    }

    @Given("^i am a correct page$")
    public void iAmACorrectPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        driver.manage().window().maximize();
    }

    @When("^i enter number below (\\d+)$")
    public void iEnterNumberBelow(int arg0) throws Throwable {
        driver.findElement(By.cssSelector("#numb")).sendKeys("48");

    }

    @When("^click on submit button$")
    public void click_on_submit_button() throws Throwable {
        driver.findElement(By.className("w3-btn")).click();

    }

    @Then("^i see error message$")
    public void i_see_error_message() throws Throwable {
        String actualvalue = driver.findElement(By.id("ch1_error")).getText();
        assertEquals("Number is too small",actualvalue);
    }


    @Given("^i am on corret page$")
    public void iAmOnCorretPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        driver.manage().window().maximize();
    }
    @When("^i enter number above (\\d+)$")
    public void i_enter_number_above(int arg1) throws Throwable {
        driver.findElement(By.cssSelector("#numb")).clear();

        driver.findElement(By.cssSelector("#numb")).sendKeys("101");

    }

    @When("^click on submit buttonn$")
    public void click_on_submit_buttonn() throws Throwable {
        driver.findElement(By.className("w3-btn")).click();

    }

    @Then("^i see error messages$")
    public void i_see_error_messages() throws Throwable {
        String actualvalue = driver.findElement(By.id("ch1_error")).getText();
        assertEquals("Number is too big",actualvalue);
    }




    @Given("^i am on the google page$")
    public void iAmOnTheGooglePage() throws Throwable {

        driver.get("https://www.google.com/");
    }

    @When("^I verify google search button$")
    public void iVerifyGoogleSearchButton() throws Throwable {


       assertTrue(driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']/center/input[1]")).isDisplayed());

    }

    @And("^I verify google lucky button text$")
    public void iVerifyGoogleLuckyButtonText() throws Throwable {

        String actualvalue = driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']/center/input[1]")).getAttribute("value");
        assertEquals(driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']/center/input[1]")).getAttribute("value"),actualvalue);

    }

    @And("^i should see google image$")
    public void iShouldSeeGoogleImage() throws Throwable {
        assertTrue(driver.findElement(By.id("hplogo")).isDisplayed());
    }

    @Then("^I enter \"([^\"]*)\" text in search field$")
    public void iEnterTextInSearchField(String value) throws Throwable {

       WebElement sendvalue= driver.findElement(By.xpath("//div[@class='a4bIc']/input"));
       sendvalue.sendKeys(value);

       sendvalue.sendKeys(Keys.TAB);



    }

    @And("^press Google search button$")
    public void pressGoogleSearchButton() throws Throwable {


        driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']/center/input[1]")).click();

    }




    @When("^I enter name: \"([^\"]*)\" using PO$")
    public void iEnterName(String name) throws Throwable {
        agePage.enterName(name);
    }

    @And("^I enter age: (\\d+) using PO$")
    public void iEnterAge(int age) throws Throwable {
        agePage.enterAge(age);
    }

    @Given("^I (?:am on|open) age page using PO$")
    public void iAmOnAgePage() throws Throwable {
        driver.get(agePage.getPageUrl());
    }

    @And("^I click submit age using PO$")
    public void iClickSubmitAge() throws Throwable {
        agePage.clickSubmit();
    }

    @Then("^I see message: \"(.*)\" using PO$")
    public void iSeeMessage(String message) throws Throwable {
        ageSubmittedPage.checkMessageText(message);
    }

    @When("^I enter values using PO:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        agePage.enterName(valuesToEnter.get("name"));
        agePage.enterAge(valuesToEnter.get("age"));
    }

    @When("^I enter values:$")
    public void iEnterValues() throws Throwable {

        throw new PendingException();
    }


}

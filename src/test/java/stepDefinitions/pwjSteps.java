package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages_sample.pwjHomePage;
import pages_sample.addAPersonPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import cucumber.api.java.en.Given;



public class pwjSteps {


    private WebDriver driver;
    static pwjHomePage pwjhomepage;
    static addAPersonPage addapersonpage;


    public pwjSteps() {
      this.driver = Hooks.driver;
      pwjhomepage = PageFactory.initElements(Hooks.driver,  pwjHomePage.class);
      addapersonpage = PageFactory.initElements(Hooks.driver,  addAPersonPage.class);
    }


  @Given("^I am on the pwj homepage$")
  public void i_am_on_the_pwj_homepage() throws Throwable {
    driver.get("https://kristinek.github.io/site/tasks/list_of_people");
  }

  @And("^I click Reset List button$")
  public void i_click_reset_list_button() throws Throwable {
    pwjhomepage.clickOnResetListBtn();
  }

  @When("^I click on Add person button$")
  public void i_click_on_add_person_button() throws Throwable {
    pwjhomepage.clickOnAddPersonBtn();
    }


  @Then("^I am on the add a person page$")
  public void i_am_on_the_add_a_person_page() throws Throwable {
    addapersonpage.checkClearAllFieldsBtnText();
  }

  @Then("^I enter: \"([^\"]*)\"$")
  public void i_enter(String name) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    addapersonpage.enterName(name);
  }

  @Then("^I enter surname: \"([^\"]*)\"$")
  public void i_enter_surname(String surname) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    addapersonpage.enterSurname(surname);
  }

  @Then("^I enter job: \"([^\"]*)\"$")
  public void i_enter_job(String job) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    addapersonpage.enterJob(job);
  }

  @Then("^I choose birthday: \"([^\"]*)\"$")
  public void i_choose_birthday(String dateofbirth) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    addapersonpage.enterDob(dateofbirth);
  }

  @Then("^I choose know languages:$")
  public void i_choose_know_languages(Map<String , String> datamap) throws Throwable {
        String firstlang = datamap.get("languOne");
        String secondlang = datamap.get("languTwo");
    System.out.println("###you choose first language as:### " +firstlang );
    System.out.println("###you choose second language as:###" +secondlang);
    addapersonpage.clickAndChooseLanguages1(firstlang);
    addapersonpage.clickAndChooseLanguages2(secondlang);
  }

  @And("^I choose gender$")
  public void i_choose_gender() throws Throwable {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement abc = wait.until(ExpectedConditions.elementToBeClickable(addapersonpage.maleRadiobtn));
    abc.click();
  }

  @And("^Employees status$")
  public void employees_status() throws Throwable {
    Select dropdown = new Select((addapersonpage.dropdownForEmploymentStatus));
    dropdown.selectByVisibleText("Contractor");
  }

  @When("^I click Add button$")
  public void i_click_add_button() throws Throwable {
    addapersonpage.clickOnAddBtn();
  }

  @Then("^I am on the pwj homepagee$")
  public void i_am_on_the_pwj_homepagee() throws Throwable {
    pwjhomepage.assertHomePage();
  }

  @And("^number of line bigger than three$")
  public void number_of_line_bigger_than_three() throws Throwable {
    pwjhomepage.checkFourthPersonExist();
  }

  @Then("^I see new Name added to list: \"([^\"]*)\"$")
  public void i_see_new_Name_added_to_list(String name) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    pwjhomepage.assretFourthPersonName(name);
  }


}




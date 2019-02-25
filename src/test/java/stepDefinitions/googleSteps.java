package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.googlePage;

public class googleSteps {
  private WebDriver driver;
  static googlePage googlepage;


  public googleSteps() {
    this.driver = Hooks.driver;
    googlepage = PageFactory.initElements(Hooks.driver, googlePage.class);
  }


  @When("^I am on the google homepage$")
  public void i_am_on_the_google_homepage() throws Throwable {
    driver.get(googlepage.getgoogleUrl());
  }

  @Then("^I should see Google Search in the button$")
  public void i_should_see_google_search_in_the_button() throws Throwable {
    googlepage.verifyGoogleSearchBtn();
  }

  @Then("^I should see I'm Feeling Lucky in the button$")
  public void i_should_see_im_feeling_lucky_in_the_button() throws Throwable {
    googlepage.verifyFellingLuckyBtn();
  }

  @And("^I should see google image visible$")
  public void i_should_see_google_image_visible() throws Throwable {
    googlepage.verifyGoogleLogo();
  }

  }



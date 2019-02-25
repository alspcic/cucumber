package pages_sample;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.junit.Assert.*;


public class googlePage {


  @FindBy(how = How.NAME, using = "btnI") //fellingluck
  public WebElement luckBtn;
  @FindBy(how = How.NAME, using = "btnK") // Google Search
  public WebElement searchBtn;
  @FindBy(how = How.ID, using = "hplogo") // Google logo
  public WebElement googleLogo;


  public void verifyGoogleLogo() {
    boolean a = googleLogo.isDisplayed();
   if(a==true)
      System.out.println("test successful");
    else {
      System.out.println("test failed");
      Assert.fail();
    }
  }


  public void verifyFellingLuckyBtn() {
    String a = luckBtn.getAttribute("value");
    assertEquals(a,"Es ticu veiksmei!");
  }


  public void verifyGoogleSearchBtn() {
    String a = searchBtn.getAttribute("value");
    assertEquals(a,"Google meklēšana");
  }


  public String getgoogleUrl() {
    return "https://www.google.com/";
  }






}

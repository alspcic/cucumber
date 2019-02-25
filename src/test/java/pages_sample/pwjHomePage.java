package pages_sample;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class pwjHomePage {



  @FindBy(how = How.XPATH, using = "(//button)[1]")
  public WebElement addPersonBtn;

  @FindBy(how = How.ID, using = "person3")
  public WebElement checkFourthPerson;

  @FindBy(how = How.XPATH, using = "(//button)[2]")
  public WebElement resetListBtn;

  @FindBy(how = How.XPATH, using = "//*[@id=\"person3\"]/div/span[1]")
  public WebElement checkFourthPersonName;


  public void assretFourthPersonName(String name){
    String expected1= checkFourthPersonName.getText();
    Assert.assertEquals(expected1,name);
  }

  public void checkFourthPersonExist(){
    if(checkFourthPerson.isDisplayed()==true)
      System.out.println("###Fourth Person Listed###");
    else
      Assert.fail();
  }

  public void clickOnAddPersonBtn(){

    addPersonBtn.click();
  }

  public void assertHomePage(){
    String expected1= addPersonBtn.getText();
    String actual1 = "Add person";
    Assert.assertEquals(expected1,actual1);
  }

  public addAPersonPage clickOnResetListBtn(){
    resetListBtn.click();
    return new addAPersonPage();
  }


  }

package pages_sample;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class addAPersonPage {


  @FindBy(how = How.XPATH, using = "(//button)[1]")
  public WebElement clearAllFieldsBtn;

  @FindBy(how = How.ID, using = "name")
  public WebElement nameField;

  @FindBy(how = How.ID, using = "surname")
  public WebElement surnameField;

  @FindBy(how = How.ID, using = "job")
  public WebElement jobField;

  @FindBy(how = How.ID, using = "dob")
  public WebElement birthdayField;

  @FindBy(how = How.ID, using = "english")
  public WebElement checkBXenglishField;

  @FindBy(how = How.ID, using = "french")
  public WebElement checkBXfrenchField;

  @FindBy(how = How.ID, using = "spanish")
  public WebElement checkBXspanishField;

  @FindBy(how = How.ID, using = "male")
  public WebElement maleRadiobtn;

  @FindBy(how = How.ID, using = "female")
  public WebElement femaleRadiobtn;

  @FindBy(how = How.ID, using = "status")
  public WebElement dropdownForEmploymentStatus;

  @FindBy(how = How.XPATH, using = "(//button)[2]")
  public WebElement addBtn;


  public void enterName(String name) {
    nameField.sendKeys(name);
  }

  public void enterSurname(String surname) {
    surnameField.sendKeys(surname);
  }

  public void enterJob(String job) {
    jobField.sendKeys(job);
  }

  public void enterDob(String dateofbirth) {
    birthdayField.sendKeys(dateofbirth);
    jobField.click();
  }

  public void checkClearAllFieldsBtnText() {
    String expected1= clearAllFieldsBtn.getText();
    String actual1 = "Clear all fields";
    Assert.assertEquals(expected1,actual1);
  }

  public void clickAndChooseLanguages1(String firstlang) {

    if(firstlang.equals("English")){
        if(checkBXenglishField.isSelected()==true)
          System.out.println("###Dont need to click to english once more###");
        else
          checkBXenglishField.click();
    }
    else if (firstlang.equals("Spanish")){
        if(checkBXspanishField.isEnabled()==true && checkBXspanishField.isSelected()==false)
          checkBXspanishField.click();
        else
          System.out.println("###Dont need to click to spanish once more###");
    }
    else if(firstlang.equals("French")){
        if(checkBXfrenchField.isEnabled()==true  && checkBXfrenchField.isSelected()==false)
          checkBXfrenchField.click();
        else
          System.out.println("###Dont need to click to french once more###");
    }
    else
        //Assert.fail();
      System.out.println("###Something went Wrong###");
    }

  public void clickAndChooseLanguages2(String secondlang) {

    if(secondlang.equals("English")){
      if(checkBXenglishField.isSelected()==true)
        System.out.println("###Dont need to click to english once more###");
      else
        checkBXenglishField.click();
    }
    else if (secondlang.equals("Spanish")){
      if(checkBXspanishField.isEnabled()==true && checkBXspanishField.isSelected()==false)
        checkBXspanishField.click();
      else
        System.out.println("###Dont need to click to spanish once more###");
    }
    else if(secondlang.equals("French")){
      if(checkBXfrenchField.isEnabled()==true  && checkBXfrenchField.isSelected()==false)
        checkBXfrenchField.click();
      else
        System.out.println("###Dont need to click to french once more###");
    }
    else
      //Assert.fail();
      System.out.println("###Something went Wrong###");
  }

  public void chooseGenderMale() {
    maleRadiobtn.click();
  }

  public void chooseGenderFemale() {
    femaleRadiobtn.click();
  }

  public pwjHomePage clickOnAddBtn() {
    addBtn.click();
    return new pwjHomePage();
  }




}



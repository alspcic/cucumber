package util;

import Pages.Google.GoogleMainPage;
import Pages.Kristinek.KristinekMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseUtil {

    int timeOut = 60;

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;

    public static GoogleMainPage googleMainPage;
    public static KristinekMainPage kristinekMainPage;

    public void initiialSetup(WebDriver driver){
        BaseUtil.driver = driver;
        actions = new Actions(driver);
        initializeComponentsObjects();
        wait = new WebDriverWait(driver,timeOut);
    }

    public void initializeComponentsObjects(){
        googleMainPage = new GoogleMainPage(driver);
        kristinekMainPage= new KristinekMainPage(driver);
    }

    public void iPause(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("pause"))));
    }
}

package stepDefinitions;

import com.sun.javafx.PlatformUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import util.BaseUtil;
import util.DriverFactory;

import java.net.MalformedURLException;
import java.util.Locale;

import static org.junit.Assert.fail;

public class Hooks {
    public static WebDriver driver;
    BaseUtil setupObj = new BaseUtil();

    public Hooks(DriverFactory driver){
        this.driver = driver.getDriver();
    }

    @Before
    public void openBrowser() {
        driver = DriverFactory.initialize();
        setupObj.initiialSetup(driver);
    }

    @After
    public void shutDown() {
        DriverFactory.destroyDriver();
    }
}


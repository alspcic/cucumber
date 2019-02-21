package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import util.CommonUtil;
import util.DriverFactory;
import util.ScreenShot;

import static org.junit.Assert.fail;

public class Hooks {
    WebDriver driver;
    CommonUtil setupObj = new CommonUtil();

    public Hooks(DriverFactory driver){
        this.driver = driver.getDriver();
    }

    @Before
    public void openBrowser(Scenario scenario) {
//        driver = DriverFactory.initialize();
        driver = DriverFactory.initialize(scenario.getName());
        setupObj.initiialSetup(driver,scenario);
    }

    @After
    public void shutDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenShot.saveScreenshot(driver, scenario.getName());
        }
        DriverFactory.destroyDriver();
    }
}


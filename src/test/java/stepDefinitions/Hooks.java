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

import java.net.MalformedURLException;
import java.util.Locale;

import static org.junit.Assert.fail;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void openBrowser() throws Exception {
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\lib\\" + "chromedriver.exe");
        } else if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/lib/" + "chromedriverMac");
        } else if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/lib/" + "chromedriverLinux");
        } else {
            fail("Chrome driver for our OS is not in our libs please add it.");
        }
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        driver.quit();
    }
}

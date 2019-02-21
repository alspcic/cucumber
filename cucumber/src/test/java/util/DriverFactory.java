package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class DriverFactory {
    private static WebDriver driver = null;

    public static WebDriver initialize(String groupsFromScenario) {
        if (driver == null) {
            createNewDriverInstance(groupsFromScenario);
        }
        return driver;
    }

    private static void createNewDriverInstance(final String groupsFromScenario) {
        if (FrameworkProperties.get("browser").equalsIgnoreCase("Chrome")) {
            if (FrameworkProperties.get("headless").equalsIgnoreCase("true")) {
                System.setProperty("webdriver.chrome.driver", "cucumber"+File.separator+"lib" + File.separator + "chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--start-maximized");
                try {
                    driver = new ChromeDriver(options);
                } catch (Exception a) {
                    a.printStackTrace();
                }
            }else {
                System.setProperty("webdriver.chrome.driver", "cucumber"+File.separator+"lib" + File.separator + "chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                try {
                    driver = new ChromeDriver(options);
                } catch (Exception a) {
                    a.printStackTrace();
                }
            }
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void destroyDriver() {
        driver.quit();
        driver = null;
    }
}

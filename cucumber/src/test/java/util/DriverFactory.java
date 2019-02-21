package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class DriverFactory {
    private static WebDriver driver = null;

    public static WebDriver initialize() {
        if (driver == null) {
            createNewDriverInstance();
        }
        return driver;
    }

    private static void createNewDriverInstance() {
        System.setProperty("webdriver.chrome.driver", "lib" + File.separator + "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        try {
            driver = new ChromeDriver(options);
        } catch (Exception a) {
            a.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public  static void destroyDriver(){
        driver.quit();
        driver=null;
    }
}

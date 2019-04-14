package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class HelperBase {
        protected WebDriver wd;

        public HelperBase(WebDriver wd) {
            this.wd = wd;
        }

        protected void click(By locator) {
            wd.findElement(locator).click();
        }

        protected void type(By locator, String text) {
            click(locator);
            if (text != null) {
                String existingText = wd.findElement(locator).getAttribute("value");
                if (!text.equals(existingText)) {
                    wd.findElement(locator).clear();
                    wd.findElement(locator).sendKeys(text);
                }
            }

        }
}

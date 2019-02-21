package util;

import Pages.Google.GoogleMainPage;
import Pages.Kristinek.KristinekMainPage;
import cucumber.api.Scenario;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.fail;

public class CommonUtil {

    int timeOut = 60;
    public static int runNo = 1;

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;
    public static GoogleMainPage googleMainPage;
    public static KristinekMainPage kristinekMainPage;
    public static Scenario scenario;
    public static String scenarioName;
    public static StringBuilder errorMsg = new StringBuilder();

    public void initiialSetup(WebDriver driver,Scenario scenario){
        CommonUtil.driver = driver;
        CommonUtil.scenario = scenario;
        actions = new Actions(driver);
        initializeComponentsObjects();
        wait = new WebDriverWait(driver,timeOut);
    }

    public void initializeComponentsObjects(){
        googleMainPage = new GoogleMainPage(driver);
        kristinekMainPage= new KristinekMainPage(driver);
    }

    /**
     * Method to check if element is present on the page or not.
     *
     * @param element
     * @return elementPresent
     */
    public boolean isElementPresent(WebElement element) {
        boolean elementPresent = false;
        try {
            if (element.isDisplayed()) {
                elementPresent = true;
            }
        } catch (Exception e) {
            elementPresent = false;
            System.out.println(" ");
            System.out.println("Element Is Not Present");
            System.out.println(" ");
        }
        return elementPresent;
    }

    /**
     * Method to check if list size matching to Number
     *
     * @param elements
     * @param i
     * @return
     */
    public boolean isListSizeEqualsTo(List<WebElement> elements, int i) {
        boolean listSize = false;
        try {
            if (elements.size() == i) {
                listSize = true;
            }
        } catch (Exception e) {
            listSize = false;
            System.out.println(" ");
            System.out.println(" List Size Does Not Matches");
            System.out.println(" ");
        }
        return listSize;
    }

    /**
     * Method to wait with the given condition and fails the test case if element is
     * not found. Instead of throwing error, this method fails the test case with
     * message and element locator.
     *
     * @param element
     */
    public void waitUntilElementClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            fail("The element is not found on page: " + element);
        }

    }

    /**
     * Thread sleep
     *
     * @param sleepTime in milliseconds
     */
    public void setSleep(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (Exception e) {

        }
    }

    /**
     * Method to wait with the given condition and fails the test case if element is not found.
     * Instead of throwing error, this method fails the test case with message and element locator.
     *
     * @param element
     */
    public void waitUntilElementVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            fail("The element is not found on page: " + element);
        }
    }

    /**
     * Method that will wait until element visible and then clicks on it
     *
     * @param element
     */
    public void waitAndClick(WebElement element) {
        waitUntilElementVisible(element);
        element.click();
    }

    /**
     * Waits until all elements present on the web page that match the locator are visible.
     * Instead of throwing error, this method fails the test case with message and element locator.
     *
     * @param elements list of WebElements
     */
    public void waitUntilVisibilityOfAllElements(List<WebElement> elements) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (Exception e) {
            fail("All elements are not visible");
        }
    }


    /**
     * Method to wait with the given condition and fails the test case if element is
     * not found. Instead of throwing error, this method fails the test case with
     * message and element locator.
     *
     * @param element
     */
    public void waitUntilTextPresent(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e) {
            fail("The element is not found on page: " + element);
        }
    }

    /**
     * Method to wait with the given condition and fails the test case if element is
     * not found. Instead of throwing error, this method fails the test case with
     * message and element locator.
     *
     * @param element
     */
    public void waitUntilFrameAvailable(WebElement element) {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        } catch (Exception e) {
            fail("The frame is not found on page: " + element);
        }
    }

    /**
     * Method to wait with the given condition and fails the test case if element is
     * not found. Instead of throwing error, this method fails the test case with
     * message and element locator.
     *
     * @param frame
     */
    public void waitUntilFrameAvailable(int frame) {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
        } catch (Exception e) {
            fail("The frame is not found on page: " + frame);
        }
    }

    /**
     * Method to scroll down the page till the WebElement
     *
     * @param element
     */
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToPageTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
    }

    /**
     * Clicks an element with JavaScript Workaround method in case if 'Element is
     * not currently visible' error is encountered via Selenium's WebElement#click()
     *
     * @param element element to click
     */

    public void clickElementWithJavaScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var evt = document.createEvent('MouseEvents');"
                + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
                + "arguments[0].dispatchEvent(evt);", element);
    }

    /**
     * Clicks the link element with matching visible text
     *
     * @param linkText text in link to be clicked
     */
    public void clickLink(String linkText) {

        waitUntilElementVisible(driver.findElement(By.linkText(linkText)));
        WebElement linkByText = driver.findElement(By.linkText(linkText));
        scrollToElement(linkByText);
        linkByText.click();
    }

    /**
     * Delete all cookies for the current session
     */
    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    /**
     * get current window handle
     */
    public String getWindow() {
        return driver.getWindowHandle();
    }

    /**
     * get list of open windows
     */
    public Set<String> getWindows() {
        return driver.getWindowHandles();
    }

    /**
     * switch to window based on handle
     */
    public void switchWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    /**
     * browser back navigation action
     */
    public void back() {

        driver.navigate().back();
    }

    /**
     * browser forward navigation action
     */
    public void forward() {

        driver.navigate().forward();
    }

    /**
     * browser page refresh action
     */
    public void refresh() {

        driver.navigate().refresh();
    }

    /**
     * Method to check if page is loaded completely
     *
     * @param loopCount
     */
    public void checkPageIsReady(int loopCount) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            return;
        }
        for (int i = 0; i < loopCount; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }

    public String getNewTab() {
        String currentWindowTitle = driver.getTitle();
        String tabName = null;
        Set tabs = driver.getWindowHandles();
        List<String> tabList = new ArrayList<String>(tabs);
        for (String tab : tabList) {
            driver.switchTo().window(tab);
            if (!driver.getTitle().equals(currentWindowTitle)) {
                tabName = tab;
                break;
            }
        }
        return tabName;
    }


    /*********************
     * Verification Methods below (Soft Assertion)
     ****************************/

    /**
     * Verify methods similar to <b>AssertTrue</b>
     *
     * @param errMsg
     * @param condition
     */
    public static void verifyTrue(String errMsg, boolean condition) {
        try {
            Assert.assertTrue(condition);
        } catch (AssertionError e) {
            scenarioName = scenario.getName();
            errorMsg.append("\n" + scenarioName + " : " + errMsg);
        }
    }

    /**
     * Verify methods similar to <b>AssertFalse</b>
     *
     * @param errMsg
     * @param condition
     */
    public static void verifyFalse(String errMsg, boolean condition) {
        try {
            Assert.assertFalse(condition);
        } catch (AssertionError e) {
            scenarioName = scenario.getName();
            errorMsg.append("\n" + scenarioName + " : " + errMsg);
        }
    }

    /**
     * Verify methods similar to <b>AssertEqual</b>
     *
     * @param errMsg
     * @param expectedObj
     * @param actualObj
     */
    public static void verifyEqual(String errMsg, Object expectedObj, Object actualObj) {
        try {
            Assert.assertEquals(errMsg, expectedObj, actualObj);
        } catch (AssertionError e) {

            scenarioName = scenario.getName();
            errorMsg.append("\n" + scenarioName + " : " + errMsg);
        }
    }

    public static void assertVerify() {
        if (errorMsg.length() != 0) {
            fail(errorMsg.toString());
        }

    }

    /**
     * Check if PDF is open in new tab when privacyPolicy link is clicked.
     * This method opens the PDF, verifies it and then closes the tab.
     *
     * @return True or False
     */
    public boolean isPDFOpenInNewTab() {
        Set tabs = driver.getWindowHandles();
        List<String> tabList = new ArrayList<String>(tabs);
        driver.switchTo().window(tabList.get(tabList.size() - 1));
        setSleep(2000);
        String pdfName = driver.findElement(By.tagName("embed")).getAttribute("type");
        driver.findElement(By.tagName("html")).sendKeys(Keys.CONTROL, "w");
        driver.switchTo().window(tabList.get(0));
        if (pdfName.equals("application/pdf")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Pick Random Element from List<WebElement>
     *
     * @param elements
     */
    public void selectRandomListElement(List<WebElement> elements) {
        Random rand = new Random();
        int randomProduct = rand.nextInt(elements.size());
        elements.get(randomProduct).click();
    }

    public void selectExactListElement(List<WebElement> elements, String number) {
        int m = Integer.parseInt(number);
        int i = m - 1;
        elements.get(i);
    }



    /**
     * Find element from List<WebElement> and pick first by Text param
     *
     * @param webElements
     * @param text
     * @return
     */
    public WebElement findElementByTextInList(List<WebElement> webElements, String text) {
        return webElements
                .stream()
                .filter(webElement -> Objects.equals(webElement.getText(), text))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No WebElement found containing " + text));
    }

    /**
     * Method for getting text of all elements from List
     *
     * @param webElements
     * @return List of all elements in List<WebElement>
     */
    public List<String> getLabelsList(List<WebElement> webElements) {
        List<String> labelsList = new ArrayList<>();
        for (WebElement webElement : webElements) {
            labelsList.add(webElement.getText());
        }
        return labelsList;
    }

    /**
     * Waits until more than "number" of "LOCATORS!!!!!"(By.css,By.xpath....)
     *
     * @param locator
     * @param number
     */
    public void waitUntilMoreThanElementVisible(By locator, int number) {
        try {
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, number));
        } catch (Exception e) {
            fail("There is less than " + number + " elements");
        }
    }

    public void waitUntilElementIsNotEmpty(WebElement element, String Text) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(element, Text));
        } catch (Exception e) {
            fail("Seach result is empty");
        }
    }


    public void elementSizeToInt(List<WebElement> elements) {
        int count = elements.size();
        int i = 0;
        while (i < count) {
            i++;
        }
    }

    public void setAttribute(String tff, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + tff + "';", element);
    }


    /**
     * Method for selecting checkbox
     *
     * @param element
     */
    public void selectCheckbox(WebElement element) {
        if (element.getAttribute("data-qa").contains("checked")) {
            System.out.println(" ");
            System.out.println("| " + element.getText() + " already selected |");
        } else {
            element.click();
        }
    }

    /**
     * @param text
     * @param element
     * @param tff                - Text from Feature
     * @param elementFromFeature - eff
     */
    public void setDateAttribute(String text, WebElement element,
                                 String tff, String elementFromFeature) {
        if (elementFromFeature.equalsIgnoreCase(text)) {
            setAttribute(tff, element);
        }
    }


    public void compareTwoStrings(String one, String two) {
        if (one.matches(two)) {
            System.out.println(" ");
            System.out.println("| Text matches |");
        } else {
            System.out.println(" ");
            System.out.println("| Text does not match |");
        }
    }


    public void clearAndSendInput(String tff, WebElement element) {
        waitUntilElementVisible(element);

        if (tff.equalsIgnoreCase("clear")) {
            element.click();
            element.sendKeys(Keys.END);
            while (element.getAttribute("value").length() > 0) {
                element.sendKeys(Keys.BACK_SPACE);
            }
            element.sendKeys(Keys.ENTER);
        } else {
            element.click();
            element.sendKeys(Keys.END);
            while (element.getAttribute("value").length() > 0) {
                element.sendKeys(Keys.BACK_SPACE);
            }
            element.sendKeys(tff + Keys.ENTER);
        }
    }

//    public void setValue(ElementObject elementObject, String value) {
//        String elementType = elementObject.elementType;
//        switch (elementType){
//            case "Dropdown":
//                clearAndSend(value, elementObject.element);
//                break;
//            case "Input":
//                clearAndSendInput(value, elementObject.element);
//                break;
//            case "Checkbox":
//                selectCheckbox(elementObject.element);
//                break;
//        }
//    }
}

package com.automationExercise.utilities;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowserUtils {

    /**
     * Pauses execution for the specified number of seconds
     *
     * @param seconds
     */
    public static void sleep(int seconds) {
        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Switches to a window that contains the expected URL, and verifies the title
     *
     * @param expectedInURL   part of the URL expected to be present in the window
     * @param expectedInTitle part of the title expected in the window
     */
    public static void switchWindowAndVerify(String expectedInURL, String expectedInTitle) {
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        for (String each : allWindowHandles) {
            Driver.getDriver().switchTo().window(each);
            if (Driver.getDriver().getCurrentUrl().contains(expectedInURL)) {
                break;
            }
        }
        // Verify the title contains the expected value
        assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle),
                "Title does not contain expected text!");
    }

    /**
     * Verifies if the page title matches the expected title
     *
     * @param expectedTitle the expected title of the page
     */


    /**
     * Attempts to click on the provided element until the given time runs out
     *
     * @param element the WebElement to click on
     * @param timeout maximum time to attempt the click
     */
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                sleep(1);
            }
        }
    }

    /**
     * Executes the given JavaScript command on the provided web element
     *
     * @param element the WebElement to run the script on
     * @param command the JavaScript command to execute
     */
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command, element);
    }

    /**
     * Executes the given JavaScript command
     *
     * @param command the JavaScript command to execute
     */
    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command);
    }

    /**
     * Clicks on an element using JavaScript, retrying if it fails
     *
     * @param by       the locator for the element
     * @param attempts number of attempts to try
     */
    public static void clickWithWait(By by, int attempts) {
        int counter = 0;
        while (counter < attempts) {
            try {
                clickWithJS(Driver.getDriver().findElement(by));
                break;
            } catch (WebDriverException e) {
                e.printStackTrace();
                ++counter;
                sleep(1);
            }
        }
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element the WebElement to click on
     */
    public static void clickWithJS(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();", element);
    }

    public static void verifyTitle(String expectedTitle) {
        Assertions.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }


    /**
     * Waits for an element to be present in the DOM for a given time
     *
     * @param by   locator for the element
     * @param time maximum time to wait
     */
    public static void waitForPresenceOfElement(By by, long time) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public static void verifyTitleContains(String expectedInTitle) {
        Assertions.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    /*
    This method accepts WebElement target,
    and waits for that WebElement not to be displayed on the page
     */
    public static void waitForInvisibilityOf(WebElement target) {
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    /*
    This method accepts String title,
    and waits for that Title to contain given String value.
     */
    public static void waitForTitleContains(String title) {
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.titleContains(title));
    }

    /**
     * This method accepts a dropdown element and returns a List<String> that contains all options values as String.
     *
     * @param dropdownElement
     * @return actualMonth_as_STRING
     */
    public static List<String> dropdownOptions_as_STRING(WebElement dropdownElement) {

        Select month = new Select(dropdownElement);
        //Storing all the ACTUAL options into a List of WebElements
        List<WebElement> actualMonth_as_WEBELEMENT = month.getOptions();

        //Creating an EMPTY list of String to store ACTUAL <option> as String
        List<String> actualMonth_as_STRING = new ArrayList<>();

        //Looping through the List<WebElement>, getting all options' texts, and storing them into List<String>
        for (WebElement each : actualMonth_as_WEBELEMENT) {

            actualMonth_as_STRING.add(each.getText());

        }

        return actualMonth_as_STRING;

    }

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue) {
        for (WebElement each : radioButtons) {
            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                each.click();
            }
        }
    }

    /**
     * This method will accept a String as expected value and verify actual URL CONTAINS the value.
     *
     * @param expectedInURL
     */
    public static void verifyURLContains(String expectedInURL) {
        Assertions.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }

    /**
     * Switches to new window by the exact title. Returns to original window if target title not found
     *
     * @param targetTitle
     */
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    /**
     * Moves the mouse to given element
     *
     * @param element on which to hover
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * return a list of string from a list of elements
     *
     * @param list of webelements
     * @return list of string
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    /**
     * Extracts text from list of elements matching the provided locator into new List<String>
     *
     * @param locator
     * @return list of strings
     */
    public static List<String> getElementsText(By locator) {

        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();

        for (WebElement el : elems) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for the provided element to be visible on the page
     *
     * @param element
     * @param time
     * @return
     */
    public static WebElement waitForVisibility(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for element matching the locator to be visible on the page
     *
     * @param locator
     * @param time
     * @return
     */
    public static WebElement waitForVisibility(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for provided element to be clickable
     *
     * @param element
     * @param time
     * @return
     */
    public static WebElement waitForClickablility(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for element matching the locator to be clickable
     *
     * @param locator
     * @param time
     * @return
     */
    public static WebElement waitForClickablility(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param time
     */
    public static void waitForPageToLoad(long time) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    /**
     * Verifies whether the element matching the provided locator is displayed on page
     *
     * @param by
     * @throws AssertionError if the element matching the provided locator is not found or not displayed
     */
    public static void verifyElementDisplayed(By by) {
        try {
            assertTrue(Driver.getDriver().findElement(by).isDisplayed(), "Element not visible: " + by);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assertions.fail("Element not found: " + by);

        }
    }

    /**
     * Verifies whether the element matching the provided locator is NOT displayed on page
     *
     * @param by
     * @throws AssertionError the element matching the provided locator is displayed
     */
    public static void verifyElementNotDisplayed(By by) {
        try {
            assertFalse(Driver.getDriver().findElement(by).isDisplayed(), "Element should not be visible: " + by);
        } catch (NoSuchElementException e) {
            e.printStackTrace();

        }
    }


    /**
     * Verifies whether the element is displayed on page
     *
     * @param element
     * @throws AssertionError if the element is not found or not displayed
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            assertTrue(element.isDisplayed(), "Element not visible: " + element);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assertions.fail("Element not found: " + element);

        }
    }


    /**
     * Waits for element to be not stale
     *
     * @param element
     */
    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if (y == 1)
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (WebDriverException we) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }


    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Performs double click action on an element
     *
     * @param element
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    /**
     * Changes the HTML attribute of a Web Element to the given value using JavaScript
     *
     * @param element
     * @param attributeName
     * @param attributeValue
     */
    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }

    /**
     * Highlighs an element by changing its background and border color
     *
     * @param element
     */
    public static void highlight(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        waitFor(1);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    /**
     * Checks or unchecks given checkbox
     *
     * @param element
     * @param check
     */
    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }


}

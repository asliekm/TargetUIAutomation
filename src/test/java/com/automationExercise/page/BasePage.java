package com.automationExercise.page;

import com.automationExercise.utilities.ConfigurationReader;
import com.automationExercise.utilities.Driver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

@Slf4j
public abstract class BasePage {
    public static final WebDriver driver = Driver.getDriver();
    // Define a default wait time and polling interval
    private static final long DEFAULT_WAIT_DURATION = 5000; // 5 seconds
    private static final long DEFAULT_POLLING_INTERVAL = 1000; // 1 second

    public static final Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofMillis(DEFAULT_WAIT_DURATION))
            .pollingEvery(Duration.ofMillis(DEFAULT_POLLING_INTERVAL))
            .ignoring(NoSuchElementException.class);

    @FindBy(xpath = "//*[@class='sc-58ad44c0-3 kwbrXj h-margin-r-x3']")
    public WebElement homePageSigninButton;

    @FindBy(xpath = "//*[@class='sc-e851bd29-0 sc-7d77c0d1-0 dmfVmE cRBlGM']")
    public WebElement homePageTargetIcon;

    @FindBy(css = ".h-margin-r-x1")
    public WebElement searchResultWithNumber;

    @FindBy(css = ".h-margin-r-x2")
    public WebElement searchResultWithName;

    @FindBy(css = "@web/SearchInputMobile")
    public WebElement searchSign;

    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

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

    public void clickLink(String text) {

        Driver.getDriver().findElement(By.linkText(text)).click();

    }

    public void login() {
        // ENV VARIABLE ?

//        String username = System.getenv("USERNAME");
//        System.out.println("username = " + username);
//        String password = System.getenv("PASSWORD");
//        System.out.println("password = " + password);


        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");


        //usernameEl.sendKeys(username);
        //passwordEl.sendKeys(password);
        homePageSigninButton.click();


    }

    public void waitAndClick(WebElement element) {
        long start = System.currentTimeMillis();
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        log.info("Clicked in {}ms", System.currentTimeMillis() - start);
    }


}




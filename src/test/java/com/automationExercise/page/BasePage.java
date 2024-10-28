package com.automationExercise.page;

import com.automationExercise.utilities.ConfigurationReader;
import com.automationExercise.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[1]")
    private WebElement homePage;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[2]")
    public WebElement productPage;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[3]")
    private WebElement cart;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[4]")
    public WebElement loginButton;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[5]")
    public WebElement testcase;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[6]")
    public WebElement apitesting;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[7]")
    public WebElement videoTutorials;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[8]")
    public WebElement contactUs;
    @FindBy(xpath = "//div[@class='single-widget']//h2")
    public WebElement subscription;

    @FindBy(xpath = "//a[@id='scrollUp']")
    public WebElement scrollUp;

    @FindBy(xpath = "//p[.='Consent']")
    public WebElement Confirm;// error


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
        loginButton.click();



    }

}




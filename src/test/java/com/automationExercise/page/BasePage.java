package com.automationExercise.page;

import com.automationExercise.utilities.ConfigurationReader;
import com.automationExercise.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    @FindBy(xpath = "//*[@class='sc-58ad44c0-3 kwbrXj h-margin-r-x3']")
    public WebElement homePageSigninButton;

    @FindBy(xpath = "//*[@class='sc-e851bd29-0 sc-7d77c0d1-0 dmfVmE cRBlGM']")
    public WebElement homePageTargetIcon;

    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);
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

}




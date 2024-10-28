package com.automationExercise.page;

import com.automationExercise.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

        public LoginPage() {

                PageFactory.initElements(Driver.getDriver(), this);
        }
        @FindBy(xpath = "/html/body/section/div/div/div[1]/div[1]/h2")
        public WebElement loginToYouraccount;
        @FindBy(xpath="//input[@data-qa='login-email']")
        public WebElement emailField;
        @FindBy(xpath="//input[@data-qa='login-password']")
        public WebElement passwordField;
        @FindBy(xpath="//button[@data-qa='login-button']")
        public WebElement signlogin;
        @FindBy(xpath="  //ul[@class='nav navbar-nav']//li[10]")
        public WebElement loggedName;




}


package com.automationExercise.page;

import com.automationExercise.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public RegisterPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='sc-ddc722c0-0 sc-3d5333d1-0 jKTcnK hhYRAp h-whiteSpace-normal h-margin-b-tight']")
    public WebElement createAccountButton;

    @FindBy(xpath = "//*[@id='createAccount']")
    public WebElement registerPageCreateAccountButton;

    @FindBy(xpath = "//*[@class='sc-fe064f5c-0 WObnm']")
    public WebElement registerCreateYourTargetAccountScript;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement emailField;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordAlani;

    @FindBy(xpath = "//span[text()='Verification code sent']")
    public WebElement verificationCodeSentYazisi;

    @FindBy(xpath = "//*[@*='sc-f86dede5-4 gseCQf h-bg-grayLightest']")
    public WebElement birthdaySaleScript;

    @FindBy(xpath = "(//*[@class='sc-ca119107-0 eEYQaN'])[1]")
    public WebElement signUpWithPasskeyButton;

    @FindBy(xpath = "(//*[@name='auth-factor'])[2]")
    public WebElement signUpWithPasswordButton;

    @FindBy(xpath= "(//input[@id='password'])[2]")
    public WebElement createPassword;

    @FindBy(id = "username--ErrorMessage")
    public WebElement pleaseEnterYourEmailMessage;

    @FindBy(xpath = "//*[@data-test='authAlertDisplay']")
    public WebElement alreadyExistEmailErrorMessage;

    @FindBy(xpath = "//*[@name='firstnamecreateaccount']")
    public WebElement firstNameField;

    @FindBy(xpath = "//*[@name='lastnamecreateaccount']")
    public WebElement lastNameField;

    @FindBy(id = "password--ErrorMessage")
    public WebElement pleaseEnteraValidPassordMessage;

    @FindBy(xpath = "//*[@name='passwordcreateaccount']")
    public WebElement createPasswordField;

}

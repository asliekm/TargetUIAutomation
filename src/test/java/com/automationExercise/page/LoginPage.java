package com.automationExercise.page;

import com.automationExercise.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {


    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }


   // @FindBy(xpath = "(//input[@name='searchTerm'])[1]")
   // public WebElement homePageSearchbox;

  //  @FindBy(xpath = "//*[@class='h-margin-r-x1']")
   // public List<WebElement> bulunanUrunElementleriList;


    @FindBy(xpath = "//*[@class='sc-58ad44c0-3 kwbrXj h-margin-r-x3']")
    public WebElement homePageSigninButton;

    // //*[@class='sc-58ad44c0-3 kwbrXj h-margin-r-x3']


    @FindBy(xpath = "//*[@class='sc-859e7637-0 hHZPQy']")
    public WebElement barSignInButton;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement emailField;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@*='sc-ddc722c0-0 sc-f1230b39-0 sc-ea08e237-4 bsiKgd doBYzz bveVWO']")
    public WebElement signInWithPasswordButton;


    @FindBy(xpath = "(//*[@class='sc-859e7637-0 hHZPQy'])[1]")
    public WebElement myTargetButtonInBar;

    @FindBy(xpath = "//*[@class='sc-55a9f08c-0 ccRcBB']")
    public WebElement errorMessageWeCantFindYourAccount;

    @FindBy(id = "username--ErrorMessage")
    public WebElement errorMessagePleaseEnterAnEmailorPhoneNumber;

    @FindBy(id = "password--ErrorMessage")
    public WebElement errorMessagePleaseEnteraValidPassword;



    @FindBy(xpath = "//span[text()='Verification code sent']")
    public WebElement verificationCodeSentScript;

    @FindBy(xpath = "(//*[@*='sc-859e7637-0 hHZPQy'])[2]")
    public WebElement createAccountButton;


   @FindBy(xpath = "//*[@*='sc-f86dede5-4 gseCQf h-bg-grayLightest']")
   public WebElement birthdaySaleScript;


   @FindBy(xpath = "(//*[@class='sc-e851bd29-0 sc-859e7637-1 kMNBhI kVBpoo'])[15]")
   public  WebElement signOutButton;





}

package com.automationExercise.steps;

import com.automationExercise.page.BasePage;
import com.automationExercise.page.LoginPage;
import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.ConfigurationReader;
import com.automationExercise.utilities.Driver;
import io.cucumber.java.en.*;
import org.apache.commons.collections.ExtendedProperties;
import org.junit.Assert;


public class LoginStepDef extends BasePage {

    LoginPage loginPage = new LoginPage();

    @Given("the user goes to Sign In Page")
    public void theUserGoesToSignInPage() {

        loginPage.homePageSigninButton.click();

        loginPage.barSignInButton.click();

    }



    @Given("the user enters {string}")
    public void theUserEnters(String aValidUsername) {

        loginPage.emailField.sendKeys(ConfigurationReader.getProperty("validUsername"));

    }


    @Then("the user enters a valid password")
    public void the_user_enters_a_valid_password() {

        loginPage.passwordField.sendKeys(ConfigurationReader.getProperty("validPassword"));

    }

    @Given("the user enters an invalid username")
    public void theUserEntersAnInvalidUsername() {

        loginPage.emailField.sendKeys(ConfigurationReader.getProperty("invalidUsername"));

    }

    @And("the user enters an invalid password")
    public void theUserEntersAnInvalidPassword() {

        loginPage.emailField.sendKeys(ConfigurationReader.getProperty("invalidPassword"));

    }


    @Then("the user clicks on {string} button")
    public void the_user_clicks_on_button(String string) {

        loginPage.signInWithPasswordButton.click();

    }
    @And("the user should be able to see My Target Button on the Sign In Bar")
    public void the_user_should_be_able_to_see_My_Target_Button_In_Bar()  {

        loginPage.homePageSigninButton.click();

        Assert.assertTrue(loginPage.myTargetButtonInBar.isDisplayed());

    }


    @And("the user enters a blank password")
    public void theUserEntersABlankPassword() {


        loginPage.passwordField.sendKeys(ConfigurationReader.getProperty("blankPassword"));

    }

    @Then("error message should be displayed saying {string}")
    public void errorMessageShouldBeDisplayedSaying(String arg0) {

        Assert.assertTrue(loginPage.errorMessageWeCantFindYourAccount.isDisplayed());

        //  Assert.assertTrue(loginPage.errorMessagePleaseEnterAnEmailorPhoneNumber.isDisplayed());

        //  Assert.assertTrue(loginPage.errorMessagePleaseEnteraValidPassword.isDisplayed());

    }

    @Then("the error message should be displayed saying {string}")
    public void theErrorMessageShouldBeDisplayedSaying(String arg0) {

        Assert.assertTrue(loginPage.errorMessagePleaseEnterAnEmailorPhoneNumber.isDisplayed());

    }

    @Then("th error message should be displayed saying {string}")
    public void thErrorMessageShouldBeDisplayedSaying(String arg0) {

        Assert.assertTrue(loginPage.errorMessagePleaseEnteraValidPassword.isDisplayed());

    }

    @Given("the user enters an empty username")
    public void theUserEntersAnEmptyUsername() {

        loginPage.emailField.sendKeys(ConfigurationReader.getProperty("emptyUsername"));

    }

    @And("the user enters an empty password")
    public void theUserEntersAnEmptyPassword() {

        loginPage.passwordField.sendKeys(ConfigurationReader.getProperty("emptyPassword"));

    }



}

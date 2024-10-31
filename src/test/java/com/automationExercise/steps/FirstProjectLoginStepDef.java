package com.automationExercise.steps;

import com.automationExercise.page.BasePage;
import com.automationExercise.page.LoginPage;
import com.automationExercise.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstProjectLoginStepDef extends BasePage {

 LoginPage loginpage = new LoginPage();
    @Given("thw user able to click login button")
    public void thw_user_able_to_click_login_button() {
        Confirm.click();
        loginButton.click();

    }
    @Then("the user able to see Login to your account")
    public void the_user_able_to_see_login_to_your_account() {
        //BrowserUtils.waitForVisibility(loginpage.);
        //System.out.println("login page.loginToYouraccount.getText() = " + loginpage.loginToYouraccount.getText());



    }

    @When("the user write  username and password  then click login button")
    public void theUserWriteUsernameAndPasswordThenClickLoginButton() {
        loginpage.emailField.click();
        loginpage.emailField.sendKeys(ConfigurationReader.getProperty("username"));
        loginpage.passwordField.click();
//        loginpage.passwordField.sendKeys(ConfigurationReader.getProperty("password"));
//        loginpage.signlogin.click();
    }


    @And("the user verify that logged in as username is visible")
    public void theUserVerifyThatLoggedInAsUsernameIsVisible() {
//        BrowserUtils.waitForVisibility(loginpage.loggedName,100);
//        System.out.println("loginpage.loggedName.getText() = " + loginpage.loggedName.getText());

    }
}

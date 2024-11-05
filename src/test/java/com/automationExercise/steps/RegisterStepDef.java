package com.automationExercise.steps;

import com.automationExercise.utilities.Driver;
import com.github.javafaker.Faker;
import com.automationExercise.page.BasePage;
import com.automationExercise.page.LoginPage;
import com.automationExercise.page.RegisterPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;

public class RegisterStepDef extends BasePage {

    LoginPage loginPage = new LoginPage();

    RegisterPage registerPage = new RegisterPage();

    @Given("User goes to Create an Account Page")
    public void user_goes_to_create_an_account_page() {

        loginPage.homePageSigninButton.click();
        registerPage.createAccountButton.click();
        Assert.assertTrue(registerPage.registerCreateYourTargetAccountScript.isDisplayed());

    }


    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String string) {

        registerPage.createAccountButton.click();

    }



    @Then("the user should be successfully registered")
    public void the_user_should_be_successfully_registered() {

        boolean isVerificationCodeVisible = false;
        boolean isBirthdaySaleVisible = false;

        // Check the first element with try-catch
        try {
            isVerificationCodeVisible = registerPage.verificationCodeSentYazisi.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Verification code element not found.");
        }

        // Check the second element with try-catch
        try {
            isBirthdaySaleVisible = registerPage.birthdaySaleScript.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Birthday sale element not found.");
        }

        // Assert is successful if any one of the elements is visible
        Assert.assertTrue("User was not successfully registered.", isVerificationCodeVisible || isBirthdaySaleVisible);
    }


    @And("the user fills out the registration form \\(by using sign up with passkey option)")
    public void theUserFillsOutTheRegistrationFormByUsingSignUpWithPasskeyOption()  {

        Faker faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = "12AbSDADADSADS**sasasa" ;

        Actions actions = new Actions(Driver.getDriver());

        actions.sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

    }

    @And("the user fills out the registration form \\(by using sign up with password option)")
    public void theUserFillsOutTheRegistrationFormByUsingSignUpWithPasswordOption() {

        Faker faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = "12AbSDADADSADS**sasasa" ;

        Actions actions = new Actions(Driver.getDriver());

        actions.sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .moveToElement(registerPage.signUpWithPasswordButton).click().build()
                .perform();

                registerPage.createPasswordField.sendKeys(fakePassword);
                registerPage.registerPageCreateAccountButton.click();

    }

    @And("the user fills out the registration form with an invalid email")
    public void theUserFillsOutTheRegistrationFormWithAnInvalidEmail()  {

        Faker faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = "12AbSDADADSADS**sasasa" ;
        String invalidEmail = "invalidemail@mail" ;

        Actions actions = new Actions(Driver.getDriver());

        actions.sendKeys(invalidEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

    }

    @And("the error message should be displayed as {string}")
    public void theErrorMessageShouldBeDisplayedAs(String arg0) {

        Assert.assertTrue(registerPage.pleaseEnterYourEmailMessage.isDisplayed());

    }

    @And("the user fills out the registration form with an already registered email")
    public void theUserFillsOutTheRegistrationFormWithAnAlreadyRegisteredEmail() {

        Faker faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = "12AbSDADADSADS**sasasa" ;
        String invalidEmail = "invalidemail@mail" ;
        String registeredEmail = "ugur.yamaan@gmail.com";

        Actions actions = new Actions(Driver.getDriver());

        actions.sendKeys(registeredEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

    }

    @And("the user fills out the registration form with weak password")
    public void theUserFillsOutTheRegistrationFormWithWeakPassword() {

        registerPage.emailField.sendKeys("letstry123@gmail.com");
        registerPage.firstNameField.sendKeys("master");
        registerPage.lastNameField.sendKeys("tester");
        registerPage.signUpWithPasswordButton.click();
        registerPage.signUpWithPasswordButton.sendKeys("weakpassword");
        registerPage.registerPageCreateAccountButton.click();

    }

    @And("the error message should be displayed with {string}")
    public void theErrorMessageShouldBeDisplayedWith(String arg0) {

        Assert.assertTrue(registerPage.alreadyExistEmailErrorMessage.isDisplayed());


    }

    @And("the error message should be displayed w {string}")
    public void theErrorMessageShouldBeDisplayedW(String arg0) {

        Assert.assertTrue(registerPage.pleaseEnteraValidPassordMessage.isDisplayed());
    }

    @And("the user fills out the registration form")
    public void theUserFillsOutTheRegistrationForm()  {


    }

    @Given("the user enters a valid email in the email field")
    public void the_user_enters_a_valid_email_in_the_email_field() {


    }
    @Given("the user enters a valid first name")
    public void the_user_enters_a_valid_first_name() {


    }
    @Given("the user enters a valid last name")
    public void the_user_enters_a_valid_last_name() {


    }
    @When("the user enters a valid password in the password field")
    public void the_user_enters_a_valid_password_in_the_password_field() {

    }

    @Then("the user should be redirected to the welcome page")
    public void the_user_should_be_redirected_to_the_welcome_page() {

    }

}

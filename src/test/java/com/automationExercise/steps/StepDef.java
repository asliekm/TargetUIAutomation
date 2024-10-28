package com.automationExercise.steps;

import com.automationExercise.utilities.Driver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class StepDef {


    WebDriver driver = Driver.getDriver(); // Get the WebDriver instance

    @Given("the user is on the Otto homepage")
    public void the_user_is_on_the_Otto_homepage() {
       // driver.get("https://www.otto.de/"); // Navigate to the Otto homepage
    }

}

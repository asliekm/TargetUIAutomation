package com.automationExercise.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = "com.automationExercise.steps", // Package with your step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // Reporting options
        monochrome = false,// Enables readable output in console
        tags= "@register"
)
public class CukesRunner {
    // This class will remain empty. It is used as a glue between Cucumber and JUnit.
}

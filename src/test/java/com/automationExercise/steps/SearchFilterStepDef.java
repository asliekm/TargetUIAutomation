package com.automationExercise.steps;

import com.automationExercise.page.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchFilterStepDef extends BasePage {


    @When("clicks on the search button")
    public void clicks_on_the_search_button() {
        searchSign.click();

    }

    @Then("the search results should display more than {int} results")
    public void the_search_results_should_display_more_than_results(Integer int1) {

    }

    @Then("the search results should contain the keyword {string}")
    public void the_search_results_should_contain_the_keyword(String string) {

    }

    @When("the user enters {string} in the search bar")
    public void theUserEntersInTheSearchBar(String searchText) {

    }
}

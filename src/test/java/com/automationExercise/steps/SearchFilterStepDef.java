package com.automationExercise.steps;

import com.automationExercise.page.BasePage;
import com.automationExercise.page.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;

@Getter
@Setter
@Slf4j
public class SearchFilterStepDef extends BasePage {
    SearchPage searchPage = new SearchPage();

    String resultText;

    @When("clicks on the search button")
    public void clicks_on_the_search_button() {
        waitAndClick(searchButton);

    }

    @Then("the search results should display more than {int} results")
    public void the_search_results_should_display_more_than_results(Integer expectedResult) {
        resultText = searchPage.searchResultWithNumber
                .getText()
                .replace(",", "");

        int resultCount = Integer.parseInt(resultText.replaceAll("\\D", ""));
        Assertions.assertTrue(resultCount > expectedResult,
                "Search results should be more than " + expectedResult + ", but found: " + resultCount);

    }

    @Then("the search results should contain the keyword {string}")
    public void the_search_results_should_contain_the_keyword(String expectedText) {
        resultText = searchPage.searchResultWithName.getText();
        Assertions.assertTrue(resultText.contains(expectedText), "Text does not contain" + expectedText + ".");

    }

    @When("the user enters {string} in the search bar")
    public void theUserEntersInTheSearchBar(String searchText) {
        searchBox.sendKeys(searchText);
    }
}

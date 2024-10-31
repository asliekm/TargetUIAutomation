package com.automationExercise.steps;

import com.automationExercise.page.ProductPage;
import com.automationExercise.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class FirstProjectSearchProStepDef {
    ProductPage product= new ProductPage();

    @Then("the user should be able to enter the {string} in the search box and click the search button")
    public void theUserShouldBeAbleToEnterTheInTheSearchBoxAndClickTheSearchButton(String searchstring) {
        product.searchBox.click();
        product.searchBox.sendKeys(searchstring);
        product.buttonsearchBox.click();

    }

    @Then("the user verifies that {string} is visible")
    public void theUserVerifiesThatIsVisible(String searchitem) {
        //BrowserUtils.scrollToElement(product.productItemsVisible);
        System.out.println("product.productInfo.getText().contains(searchitem) = " + product.productInfo.getText());
        Assert.assertTrue(product.productInfo.getText().contains(searchitem));

        System.out.println("searchitem = " + searchitem);
        // burda rs kismi geliyor y eni scrend
        
        
    }

    @And("all products related to the search are visible")
    public void allProductsRelatedToTheSearchAreVisible() {
        BrowserUtils.scrollToElement(product.allproductvisible);
        Assert.assertTrue(product.productInfo.isEnabled());

    }


}

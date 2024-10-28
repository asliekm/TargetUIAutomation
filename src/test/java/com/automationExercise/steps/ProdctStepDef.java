package com.automationExercise.steps;

import com.automationExercise.page.BasePage;
import com.automationExercise.page.ProductPage;
import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class ProdctStepDef extends BasePage {
    ProductPage product = new ProductPage();
    //Actions actions = new Actions(Driver.getDriver());



    @Given("the user able to click product button then verify all items and all product visible")
    public void theUserAbleToClickProductButtonThenVerifyAllItemsAndAllProductVisible() {
        productPage.click();
        System.out.println("allItemsVisible  = " + product.productItemsVisible.isDisplayed());
        //Assert.assertEquals();
        System.out.println("all products is visible = " + product.allItemsVisible.isDisplayed());
    }
    @Then("the user able to click on View Product of first product")
    public void theUserAbleToClickOnViewProductOfFirstProduct() {
        BrowserUtils.scrollToElement(product.firstViewProd);
        product.firstViewProd.click();


    }



    @Then("the user should access to product detail page")
    public void theUserShouldAccessToProductDetailPage() {
//        Driver.getDriver().getTitle();
//        BrowserUtils.verifyTitle("Automation Exercise - Product Details");
      Assert.assertEquals("Automation Exercise - Product Details", Driver.getDriver().getTitle());

    }


    @And("the user should verify product name, category, price, availability, condition, brand are visible")
    public void theUserShouldVerifyProductNameCategoryPriceAvailabilityConditionBrandAreVisible() {
       // System.out.println("product name = " + product.productname.getText());
        Assert.assertEquals("Blue Top",product.productname.getText());
        //System.out.println("category = " + product.category.getText());
        Assert.assertTrue(product.category.getText().contains("Women > Tops"));
        Assert.assertTrue(product.avaiblty.getText().contains("In Stock"));
        //System.out.println("availability = " + product.avaiblty.getText());
       // Assert.assertTrue(product.category.getText().contains("New"));
       // System.out.println("condition = " + product.condition.getText());
        //System.out.println("brand = " + product.brand.getText());
        Assert.assertTrue(product.brand.getText().contains("Polo"));


    }


}

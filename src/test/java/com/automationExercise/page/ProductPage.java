package com.automationExercise.page;

import com.automationExercise.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public ProductPage
            () {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='features_items']")
    public WebElement productItemsVisible;
    @FindBy(xpath = " //div[@class=\"features_items\"]")
    public WebElement allItemsVisible;
    @FindBy(xpath = "//a[@href=\"/product_details/1\"]")
    public WebElement firstViewProd;


    //h2[.="Blue Top"]
    @FindBy(xpath = "//h2[.=\"Blue Top\"]")
    public WebElement productname;
    //p[.="Category: Women > Tops"]
    @FindBy(xpath = " //div[@class='product-information']//p[1]")
    public WebElement category;
    @FindBy(xpath = "//div[@class='product-information']//p[2]")
    public WebElement avaiblty;
    @FindBy(xpath = "//div[@class='product-information']//p[3]")
    public WebElement condition;
    @FindBy(xpath = "//div[@class='product-information']//p[4]")
    public WebElement brand;


    @FindBy(xpath = "//input[@type=\"text\"]")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement buttonsearchBox;
    @FindBy(xpath="//div[@class=\"productinfo text-center\"]")
    public WebElement productInfo;

    //div[@class="features_items"]
    @FindBy(xpath="//div[@class=\"productinfo text-center\"]")
    public WebElement allproductvisible;



}

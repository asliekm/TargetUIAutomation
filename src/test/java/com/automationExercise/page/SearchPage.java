package com.automationExercise.page;

import com.automationExercise.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage{
    public SearchPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy( css =".h-margin-r-x1" )
    public WebElement searchResultWithNumber;

    @FindBy( css =".h-margin-r-x2" )
    public  WebElement searchResultWithName;
}

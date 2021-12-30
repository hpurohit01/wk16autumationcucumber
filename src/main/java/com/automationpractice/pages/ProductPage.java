package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Utility {

    private static final Logger log = LogManager.getLogger(ProductPage.class.getName());

    public ProductPage() {
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[@name='Submit']")
    WebElement addToCartButton;

    @FindBy(css = "a[title='Proceed to checkout'] span")
    WebElement proceedToCheckoutButton;

    public void clickOnAddToCartButton(){
        doClickOnElement(addToCartButton);
        log.info("clicking on ad to cart button: '"+addToCartButton.toString()+"'");
    }

    public void clickOnProceedToCheckoutButton(){
        doClickOnElement(proceedToCheckoutButton);
        log.info("clicking on proceeed to checkout button: '"+proceedToCheckoutButton.toString()+"'");
    }


}

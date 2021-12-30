package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class MyAccountPage extends Utility {


    private static final Logger log = LogManager.getLogger(MyAccountPage.class.getName());

    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='nav']//div[@class='row']//div[1]//a//span")
    WebElement accountNameText;

    @FindBy(xpath = "//div[@class='row addresses-lists']//a")
    List<WebElement> listAddresses;

    @FindBy(xpath = "//ul[@class='last_item item box']//li[4]//span")
    WebElement address1;

    public void verifyAddress1(String expectedText) {
        boolean matched = address1.getText().contains(expectedText);
        Assert.assertTrue(matched);
        log.info("verifying address1: " + address1.getText());
    }

    public void clickOnMyAddresses() {
        for (WebElement e : listAddresses) {
            if (e.getAttribute("title").equals("Addresses")) {
                e.click();
                break;
            }
        }
    }

    public void verifyAccountNameText(String accountName) {
        boolean actual = accountNameText.getText().contains(accountName);
        log.info("verifying account name text: " + accountNameText.getText() + "'");
        Assert.assertTrue(actual);
    }

}

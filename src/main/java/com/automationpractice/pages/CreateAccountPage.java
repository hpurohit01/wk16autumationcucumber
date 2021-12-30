package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CreateAccountPage extends Utility {

    private static final Logger log = LogManager.getLogger(CreateAccountPage.class.getName());

    public CreateAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(css = "#customer_firstname")
    WebElement firstNameLocator;
    @CacheLookup
    @FindBy(css = "#customer_lastname")
    WebElement lastNameLocator;
    @CacheLookup
    @FindBy(css = "#passwd")
    WebElement passwordLocator;
    @CacheLookup
    @FindBy(css = "#address1")
    WebElement addressLocator;
    @CacheLookup
    @FindBy(css = "#city")
    WebElement cityLocator;
    @CacheLookup
    @FindBy(xpath = "//select[@id='id_state']")   //dropdown
    WebElement stateLocator;
    @CacheLookup
    @FindBy(css = "#postcode")
    WebElement postcodeLocator;
    @CacheLookup
    @FindBy(css = "#id_country")    //dropdown
    WebElement countryLocator;
    @CacheLookup
    @FindBy(css = "#phone_mobile")
    WebElement phoneNumberLocator;
    @CacheLookup
    @FindBy(css = "button[id='submitAccount'] span")
    WebElement registerButtonLocator;
    @CacheLookup
    @FindBy(xpath = "//h3[normalize-space()='Create an account']")
    WebElement createAccountText;
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='My account']")
    WebElement myAccountTextHeading;

    @FindBy(xpath = "//div[@class='alert alert-danger']//p")
    WebElement errorHeadingText;

    @CacheLookup
    @FindBy(xpath = "//form[@id='account-creation_form']//input | //form[@id='account-creation_form']//select")
    List<WebElement> oneXpathForFrom;

    /**
     * if (Objects.equals(e.getAttribute("id"), "company")) {
     * doSendTextToElement(e, company);
     * if (e.getAttribute("id") == "address1") {
     * doSendTextToElement(e, address);
     * if (e.getAttribute("id") == "address2") {
     * doSendTextToElement(e, addLine2);
     * if (e.getAttribute("id") == "city") {
     * doSendTextToElement(e, city);
     * if (e.getAttribute("id") == "postcode") {
     * doSendTextToElement(e, postal);
     * if (e.getAttribute("id") == "phone_mobile") {
     * doSendTextToElement(e, mobile);
     */

    //, String company, String address, String addLine2, String city, String postal, String mobile
    public void fillInFormWithOneXpath(String first, String last, String pass, String day, String month, String year,
                                       String company, String add1, String add2, String city, String state, String postal,
                                       String country, String mobile) {

        for (WebElement e : oneXpathForFrom) {

            switch (e.getAttribute("id")) {

                // case "id_gender1": //input // Mr.
                // case "id_gender2": //input // Mrs.

                case "customer_firstname": //input
                    doSendTextToElement(e, first);
                    break;
                case "customer_lastname": // input
                    doSendTextToElement(e, last);
                    break;
                case "passwd": //input
                    doSendTextToElement(e, pass);
                    break;
                case "days": // select
                    doSelectByValueFromDropDown(e, day);
                    break;
                case "months": //select
                    doSelectByValueFromDropDown(e, month);
                    break;
                case "years": //select
                    doSelectByValueFromDropDown(e, year);
                    break;
                case "newsletter": // checkbox
                    doClickOnElement(e);
                    break;
                case "optin": // checkbox
                    doClickOnElement(e);
                    break;
                case "company": // input
                    doSendTextToElement(e, company);
                    break;
                case "address1": // input
                    doSendTextToElement(e, add1);
                    break;
                case "address2": // input
                    doSendTextToElement(e, add2);
                    break;
                case "city": // input
                    doSendTextToElement(e, city);
                    break;
                case "id_state": // select
                    doSelectByVisibleTextFromDropDown(e, state);
                    break;
                case "postcode": // input
                    doSendTextToElement(e, postal);
                    break;
                case "id_country": // select
                    doSelectByVisibleTextFromDropDown(e, country);
                    break;
                case "phone_mobile": // input
                    doSendTextToElement(e, mobile);
                    break;
            }
        }
    }

    public void verifyErrorMessageDisplayed(String expectedText) {
        String actual = errorHeadingText.getText();
        boolean verifyError = actual.contains(expectedText);
        log.info("verifying error message: '" + errorHeadingText.getText() + "'");
        Assert.assertTrue(verifyError);
    }


    public void enterYourFirstName(String name) {

        doSendTextToElement(firstNameLocator, name);
        log.info("Entering First Name : '" + name + "'");
    }

    public void enterYourLastName(String surname) {
        doSendTextToElement(lastNameLocator, surname);
        log.info("Entering Last Name: '" + surname + "'");
    }

    public void enterYourPassword(String pass) {

        doSendTextToElement(passwordLocator, pass);
        log.info("Entering Password : '" + pass + "'");
    }

    public void enterYourAddress(String add) {

        doSendTextToElement(addressLocator, add);
        log.info("Entering address : '" + add + "'");
    }

    public void enterYourCity(String city) {
        doSendTextToElement(cityLocator, city);
        log.info("Entering city: '" + city + "'");
    }

    public void selectYourState(String st) {
        doSelectByValueFromDropDown(stateLocator, st);
        log.info("Entering State: '" + st + "'");
    }

    public void enterYourPhoneNumber(String phone) {
        doSendTextToElement(phoneNumberLocator, phone);
        log.info("Entering Phone number: '" + phone + "'");
    }

    public void enterYourPostalCode(String postal) {
        doSendTextToElement(postcodeLocator, postal);
        log.info("Entering postcode: '" + postal + "'");
    }

    public void selectYourCountry(String country) {
        doSelectByValueFromDropDown(countryLocator, country);
        log.info("Entering Country: '" + country + "'");
    }

    public void clickOnRegisterButton() {
        doClickOnElement(registerButtonLocator);
        log.info("click on register button");
    }
}
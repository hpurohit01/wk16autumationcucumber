package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignInPage extends Utility {
    private static final Logger log = LogManager.getLogger(SignInPage.class.getName());

    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    static String generatedEmail;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement createAccountButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='email_create']")
    WebElement emailAddressToCreateAccount;

    @CacheLookup
    @FindBy(xpath = "//form[@id='login_form']//input | //form[@id='login_form']//button")
    List<WebElement> loginFormUsingOrWithMultipleTags;


    @FindBy(xpath = "//form[@id='login_form']//input")
    List<WebElement> loginForm;

    @FindBy(css = "button[id='SubmitLogin'] span")
    WebElement siginButton;

    public void fillInEmailToCreateAccount() {
        String randomString = getRandomString(5);
        String email = "www." + randomString + "@gmail.com";
        SignInPage.generatedEmail = email;
        System.out.println("+++++++++++++++email when randomaly created= " + email);
        doSendTextToElement(emailAddressToCreateAccount, email);
        log.info("fill in email: '" + email + "'");
    }

    public void clickOnCreateAccountButton() {
        doClickOnElement(createAccountButton);
        log.info("clicking on create account button: " + createAccountButton.getText() + "'");
    }

    public void signInWithEmailAndPassword(String password) {

        // this switch case worked
        for (WebElement e : loginForm) {
            switch (e.getAttribute("id")) {
                case "email":
                    doSendTextToElement(e, SignInPage.generatedEmail);
                    break;
                case "passwd":
                    doSendTextToElement(e, password);
                    break;


            }
        }
        doClickOnElement(siginButton);

        // below code worked
     /*   for (WebElement e : loginForm) {
            if (e.getAttribute("id").equals("email")) {
                doSendTextToElement(e, SignInPage.generatedEmail);
            }
            if (e.getAttribute("id").equals("passwd")) {
                doSendTextToElement(e, password);
            }
        }*/

    }
}

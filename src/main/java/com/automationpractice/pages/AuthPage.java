package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class AuthPage extends Utility {
    private static final Logger log = LogManager.getLogger(AuthPage.class.getName());

    public AuthPage() {
        PageFactory.initElements(driver, this);
    }

}

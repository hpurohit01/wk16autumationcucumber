package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class CommonPage extends Utility {
    private static final Logger log = LogManager.getLogger(CommonPage.class.getName());

    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

}

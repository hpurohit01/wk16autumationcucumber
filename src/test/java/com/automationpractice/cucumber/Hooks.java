package com.automationpractice.cucumber;

import com.automationpractice.propertyreader.PropertyReader;
import com.automationpractice.utility.Utility;
import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

public class Hooks extends Utility {

        @Before
        public void setUp(){
            selectBrowser(PropertyReader.getInstance().getProperty("browser"));

        }

        @After
        public void tearDown(Scenario scenario) {
            if (scenario.isFailed()) {
                String screenshotPath = Utility.getScreenshot(driver, scenario.getName().replace(" ", "_"));
                try {
                    Reporter.addScreenCaptureFromPath(screenshotPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            closeBrowser();
        }
    }




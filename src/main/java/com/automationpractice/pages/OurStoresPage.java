package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OurStoresPage extends Utility {

    private static final Logger log = LogManager.getLogger(OurStoresPage.class.getName());

    public OurStoresPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement okButton;

    //@CacheLookup
    @FindBy(css = "#map")
    WebElement mapArea;

    @FindBy(xpath = "//div[@id='map']")
    WebElement mapAreaByXpath;

    public void clickOKFromAlert() {
        if (okButton.isDisplayed()) {
            doClickOnElement(okButton);
        }
    }

    public void getXandYpoints() {
        //       WebElement ele= driver.findElement(By.xpath("x-path"));
        Point point = mapArea.getLocation();
        int xcord = point.getX();
        int ycord = point.getY();
        System.out.println("x=" + xcord + " and y=" + ycord);
    }

    // below method to drag map to targeted location on y positive axis.
    public void dragMapToTarget() {
        Actions builder = new Actions(driver);
        Action drag1 = builder.moveToElement(mapArea, 10, -10)
                .clickAndHold()
                .moveToElement(mapArea, 10, -100)
                .release(mapArea)
                .build();
        drag1.perform();
        Action drag2 = builder.moveToElement(mapArea)
                .clickAndHold()
                .moveToElement(mapArea, 10, -100)
                .release(mapArea)
                .build();
        drag2.perform();
        Action drag3 = builder.moveToElement(mapArea)
                .clickAndHold()
                .moveToElement(mapArea, 10, -100)
                .release(mapArea)
                .build();
        drag3.perform();
        Action drag4 = builder.moveToElement(mapArea)
                .clickAndHold()
                .moveToElement(mapArea, 10, -100)
                .release(mapArea)
                .build();
        drag4.perform();
        Action drag5 = builder.moveToElement(mapArea)
                .clickAndHold()
                .moveToElement(mapArea, 10, -100)
                .release(mapArea)
                .build();
        drag5.perform();
        Action drag6 = builder.moveToElement(mapArea)
                .clickAndHold()
                .moveToElement(mapArea, 10, -100)
                .release(mapArea)
                .build();
        drag6.perform();
        Action drag7 = builder.moveToElement(mapArea)
                .clickAndHold()
                .moveToElement(mapArea, 10, -100)
                .release(mapArea)
                .build();
        drag7.perform();
        log.info("Dragging map to targeted location.");
    }
}
package com.gammax.listeners;

import com.gammax.factory.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EventListener implements WebDriverEventListener {
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd HH:mm:ss");
    String timeStamp = sdf.format(Calendar.getInstance().getTime());

    static Logger log= Logger.getLogger(EventListener.class);

    public void beforeNavigateTo(String url, WebDriver driver) {
        log.info(timeStamp +" : Before navigating to: '" + url + "'");
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        log.info(timeStamp +" : Navigated to:'" + url + "'");
    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver) {
        log.info(timeStamp + " : Value of the:" + element.toString() + " before any changes made");
    }

    public void afterChangeValueOf(WebElement element, WebDriver driver) {
        log.info(timeStamp + " : Element value changed to: " + element.toString());
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        log.info(timeStamp + " : Trying to click on: " + element.toString());
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        log.info(timeStamp + " : Clicked on: " + element.toString());
    }

    public void beforeNavigateBack(WebDriver driver) {
        log.info(timeStamp + "Navigating back to previous page");
    }

    public void afterNavigateBack(WebDriver driver) {
        log.info(timeStamp + "Navigated back to previous page");
    }

    public void beforeNavigateForward(WebDriver driver) {
        log.info(timeStamp + "Navigating forward to next page");
    }

    public void afterNavigateForward(WebDriver driver) {
        log.info(timeStamp + "Navigated forward to next page");
    }

    public void onException(Throwable error, WebDriver driver) {
        log.info(timeStamp + "Exception occured: " + error);
    }


    public void beforeFindBy(By by, WebElement element, WebDriver driver) {

        if (element == null) {
            log.info(timeStamp + "Just before finding element: " + by.toString() + " on browser: " + driver.toString() );

        } else {
            log.info(timeStamp + "Just before finding element: " + by.toString() + " inside " + element.toString() + " Web element on browser: " + driver.toString() );
        }

    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        log.info(timeStamp +"Found Element By : " + by.toString());
    }

    /*
     * non overridden methods of WebListener class
     */
    public void beforeScript(String script, WebDriver driver) {
    }

    public void afterScript(String script, WebDriver driver) {
    }

    public void beforeAlertAccept(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterAlertAccept(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterAlertDismiss(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeAlertDismiss(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeNavigateRefresh(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterNavigateRefresh(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        // TODO Auto-generated method stub

    }

    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        // TODO Auto-generated method stub

    }

    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        // TODO Auto-generated method stub

    }

    public void afterGetText(WebElement element, WebDriver driver, String text) {
        // TODO Auto-generated method stub

    }

    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        // TODO Auto-generated method stub

    }

    public void beforeGetText(WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        // TODO Auto-generated method stub

    }
}

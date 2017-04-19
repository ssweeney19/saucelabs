package com.celtictestingexperts.Tests;

        import com.celtictestingexperts.Pages.BasePage;
        import org.openqa.selenium.By;
        import org.openqa.selenium.InvalidElementStateException;
        import org.openqa.selenium.WebDriver;

        import java.lang.reflect.Method;
        import java.net.MalformedURLException;
        import java.rmi.UnexpectedException;


/**
 * Created by ssweeney on 4/19/2017.
 */
public class BasePageTest extends TestBase{

    private By theActiveLinkLocator = By.linkText("i am a link");
    private By yourCommentsSpanLocator = By.id("your_comments");
    private By commentsTextAreaInputLocator = By.id("comments");
    private By submitButtonLocator = By.id("submit");

    @org.testng.annotations.Test(dataProvider = "hardCodedBrowsers")
    public void verifyWaitForElements(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        BasePage page = new BasePage(driver);
        page.visitPage();
        page.waitForElementToBePresent(theActiveLinkLocator);
        page.waitForElementToBePresent(yourCommentsSpanLocator);
        page.waitForElementToBePresent(commentsTextAreaInputLocator );
        page.waitForElementToBePresent(submitButtonLocator);

    }

    @org.testng.annotations.Test(dataProvider = "hardCodedBrowsers")
    public void verifyClickOnElement(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        BasePage page = new BasePage(driver);
        page.visitPage();
        page.clickOnElement(theActiveLinkLocator);
    }

    @org.testng.annotations.Test(dataProvider = "hardCodedBrowsers")
    public void verifySendKeysElement(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        BasePage page = new BasePage(driver);
        page.visitPage();
        page.sendKeysElement(theActiveLinkLocator);
        page.sendKeysElement(submitButtonLocator);
    }
}

package com.celtictestingexperts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ssweeney on 4/19/2017.
 */
public class BasePage extends GuineaPigPage {

    //waitForElementToBePresent(locator)

    protected WebDriver driver;

    private static String url = "https://saucelabs-sample-test-frameworks.github.io/training-test-page";
    public final int wait = 10;

    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public String waitForElementToBePresent(By locator)
    {
        WebDriverWait waituntil = new WebDriverWait(driver, wait);
        WebElement waitOnVisibleElement = waituntil .until(
                ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public void clickOnElement(By locator)
    {
        WebDriverWait waituntil = new WebDriverWait(driver, wait);
        WebElement waitOnVisibleElement = waituntil .until(
                ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public void sendKeysElement(By locator)
    {
        WebDriverWait waituntil = new WebDriverWait(driver, wait);
        WebElement waitOnVisibleElement = waituntil .until(
                ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys();
    }

//sendKeys(locator)
}

package com.yourcompany.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class GuineaPigPage {

    protected WebDriver driver;

    private By theActiveLinkLocator = By.linkText("i am a link");
    private By yourCommentsSpanLocator = By.id("your_comments");
    private By commentsTextAreaInputLocator = By.id("comments");
    private By submitButtonLocator = By.id("submit");

    private static String url = "https://saucelabs-sample-test-frameworks.github.io/training-test-page";

    public GuineaPigPage(WebDriver driver) {
        this.driver = driver;
//        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        driver.get(url);
    }

    public void followLink() {
        driver.findElement(theActiveLinkLocator).click();
    }

    public void submitComment(String text) {
        driver.findElement(commentsTextAreaInputLocator).sendKeys(text);
        driver.findElement(submitButtonLocator).click();
    }

    public String getSubmittedCommentText() {
        return driver.findElement(yourCommentsSpanLocator).getText();
    }

    public boolean isOnPage() {
        String title = "I am a page title - Sauce Labs";
        return driver.getTitle() == title;
    }

}

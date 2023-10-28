package com.code.pages;

import com.code.base.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends Page {

    public SignInPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button")
    WebElement signInButton;

    public void doLogin(String username,String password){
        waitForElementToBePresent(userNameField);
//        log.debug("Username Field located : " +userNameField);
        userNameField.sendKeys(username);
       // log.debug("Typing User Name On : "+userNameField);
        passwordField.sendKeys(password);
     //   log.debug("Typing Password On : "+ passwordField);
        signInButton.click();
     //   log.debug("Clicking " +signInButton);

    }
}

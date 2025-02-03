package com.amazon.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractComponent {

    @FindBy(id = "nav-link-accountList")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@type='email' or @name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='submit' and @aria-labelledby='continue-announce']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@type='password' or @name='password']")
    private WebElement passwordField;

    @FindBy(id = "signInSubmit")
    private WebElement signInSubmitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        clickElement(signInButton);
        waitForElementToBeVisible(emailField);
        emailField.sendKeys(email);
        clickElement(continueButton);
        waitForElementToBeVisible(passwordField);
        passwordField.sendKeys(password);
        clickElement(signInSubmitButton);
    }
}


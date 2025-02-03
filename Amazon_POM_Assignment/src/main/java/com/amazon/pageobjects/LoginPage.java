package com.amazon.pageobjects;


import com.amazon.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractComponent {

    @FindBy(id = Constants.SIGN_IN_BUTTON)
    private WebElement signInButton;

    @FindBy(xpath = Constants.EMAIL_FIELD)
    private WebElement emailField;

    @FindBy(xpath = Constants.CONTINUE_BUTTON)
    private WebElement continueButton;

    @FindBy(xpath = Constants.PASSWORD_FIELD)
    private WebElement passwordField;

    @FindBy(id = Constants.SIGN_IN_SUBMIT_BUTTON)
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


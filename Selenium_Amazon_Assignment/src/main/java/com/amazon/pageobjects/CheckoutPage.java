package com.amazon.pageobjects;


import com.amazon.util.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Checkout Page - Manages checkout and adding new delivery address
public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @FindBy(id = Constants.CART_BUTTON)
    private WebElement cartButton;

    @FindBy(name = Constants.PROCEED_TO_CHECKOUT)
    private WebElement proceedToCheckout;

    @FindBy(xpath = Constants.ADD_NEW_ADDRESS)
    private WebElement addNewAddress;

    @FindBy(id = Constants.ADDRESS_FULL_NAME)
    private WebElement fullName;

    @FindBy(id = Constants.ADDRESS_PHONE)
    private WebElement phoneNumber;

    @FindBy(id = Constants.ADDRESS_POSTAL_CODE)
    private WebElement postalCode;

    @FindBy(id = Constants.ADDRESS_LINE1)
    private WebElement addressLine1;

    @FindBy(id = Constants.ADDRESS_LINE2)
    private WebElement addressLine2;

    @FindBy(id = Constants.ADDRESS_CITY)
    private WebElement city;

    @FindBy(id = Constants.STATE_DROPDOWN)
    private WebElement stateDropdown;

    @FindBy(xpath = Constants.USE_THIS_ADDRESS_BUTTON)
    private WebElement useThisAddressButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void proceedToCheckout() {
        cartButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout)).click();
    }

    public void addNewAddress(String name, String phone, String zip, String address1, String address2, String cityName, String state) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(addNewAddress)).click();
        wait.until(ExpectedConditions.visibilityOf(fullName)).sendKeys(name);
        phoneNumber.sendKeys(phone);
        postalCode.sendKeys(zip);
        addressLine1.sendKeys(address1);
        addressLine2.sendKeys(address2);
        city.sendKeys(cityName);
        new Select(stateDropdown).selectByVisibleText(state);
        Thread.sleep(3000);
        js.executeScript("arguments[0].click();", useThisAddressButton);
    }
}


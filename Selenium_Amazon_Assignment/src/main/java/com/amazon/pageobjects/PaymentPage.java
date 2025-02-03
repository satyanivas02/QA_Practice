package com.amazon.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage extends AbstractComponent {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @FindBy(xpath = "//input[@value='SelectableAddCreditCard']")
    private WebElement cardOption;

    @FindBy(className = "apx-add-pm-trigger-common-image")
    private WebElement addCardImage;

    @FindBy(className = "pmts-account-Number")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//input[@name='ppw-accountHolderName']")
    private WebElement nicknameInput;

    @FindBy(xpath = "//select[@name='ppw-expirationDate_month']")
    private WebElement monthDropdown;

    @FindBy(xpath = "//select[@name='ppw-expirationDate_year']")
    private WebElement yearDropdown;

    @FindBy(xpath = "//input[@name='ppw-widgetEvent:AddCreditCardEvent']")
    private WebElement saveCardButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void addPaymentOption(String cardNumber, String cardHolder, String expMonth, String expYear) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(cardOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addCardImage));
        js.executeScript("arguments[0].click();", addCardImage);

        Thread.sleep(3000);

        try {
            WebElement iframe = driver.findElement(By.tagName("iframe"));
            driver.switchTo().frame(iframe);
        } catch (NoSuchElementException e) {
            System.out.println("No iframe found, continuing normally...");
        }

        wait.until(ExpectedConditions.visibilityOf(cardNumberInput)).sendKeys(cardNumber);
        nicknameInput.sendKeys(cardHolder);

        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByValue(expMonth);

        Select selectYear = new Select(yearDropdown);
        selectYear.selectByValue(expYear);

        js.executeScript("arguments[0].click();", saveCardButton);
        driver.switchTo().defaultContent();
        System.out.println("New payment option added successfully!");
    }
}

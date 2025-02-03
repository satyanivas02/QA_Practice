package com.amazon.pageobjects;

import com.amazon.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DealsPage extends AbstractComponent {

    @FindBy(css = Constants.THIRD_DEAL)
    WebElement thirdDeal;

    @FindBy(xpath = Constants.ADD_TO_CART_BUTTON)
    WebElement addToCartButton;

    @FindBy(id = Constants.CLOSE_CART_POPUP)
    WebElement closeCartPopup;

    public DealsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addThirdDealToCart() throws InterruptedException {
        thirdDeal.click();
        addToCartButton.click();
        Thread.sleep(4000);
        closeCartPopup.click();
    }
}
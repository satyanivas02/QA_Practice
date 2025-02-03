package com.amazon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DealsPage extends AbstractComponent {

    @FindBy(css = ".GridItem-module__container_PW2gdkwTj1GQzdwJjejN:nth-of-type(3)")
    WebElement thirdDeal;

    @FindBy(xpath = "(//input[@id='add-to-cart-button'])[2]")
    WebElement addToCartButton;

    @FindBy(id = "attach-close_sideSheet-link")
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
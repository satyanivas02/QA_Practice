package com.amazon.pageobjects;

import com.amazon.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage extends AbstractComponent {
    private WebDriverWait wait;

    @FindBy(linkText = Constants.TODAYS_DEALS_LINK)
    private WebElement todaysDealsLink;

    @FindBy(id = Constants.SEARCH_BOX)
    private WebElement searchBox;

    @FindBy(id = Constants.SEARCH_BUTTON)
    private WebElement searchButton;

    @FindBy(id = Constants.CART_BUTTON)
    private WebElement cartButton;

    @FindBy(id = Constants.ORDERS_BUTTON)
    private WebElement ordersButton;

    public HomePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void goToTodaysDeals() {
        todaysDealsLink.click();
    }

    public void searchForItem(String item) {
        searchBox.clear();
        searchBox.sendKeys(item);
        searchBox.submit();
    }

    public void searchProduct(String productName) {
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchButton.click();
    }

    public void openCart() {
        cartButton.click();
    }

    public void goToOrders() {
        ordersButton.click();
    }
}

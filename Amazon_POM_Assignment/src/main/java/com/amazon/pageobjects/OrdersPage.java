package com.amazon.pageobjects;

import com.amazon.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Orders Page - Handles order history interactions
public class OrdersPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = Constants.ORDERS_TAB)
    private WebElement ordersTab;

    @FindBy(id = Constants.TIME_FILTER_DROPDOWN)
    private WebElement timeFilterDropdown;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void goToOrdersPage() {
        ordersTab.click();
    }

    public void filterPastOneYearOrders(String year) {
        WebElement filter = wait.until(ExpectedConditions.elementToBeClickable(timeFilterDropdown));
        Select select = new Select(filter);
        select.selectByVisibleText(year);
    }
}

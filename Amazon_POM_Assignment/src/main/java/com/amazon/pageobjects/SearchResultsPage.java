package com.amazon.pageobjects;


import com.amazon.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = Constants.GET_IT_BY_TOMORROW_CHECKBOX)
    private WebElement getItByTomorrowCheckbox;

    @FindBy(xpath = Constants.FIRST_ITEM_DELIVERY_DATE)
    private WebElement firstItemDeliveryDate;

    @FindBy(xpath = Constants.PRODUCT_PRICES)
    private List<WebElement> productPrices;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void selectGetItByTomorrow() {
        wait.until(ExpectedConditions.elementToBeClickable(getItByTomorrowCheckbox)).click();
    }

    public String getFirstItemDeliveryDate() {
        return wait.until(ExpectedConditions.visibilityOf(firstItemDeliveryDate)).getText();
    }
}


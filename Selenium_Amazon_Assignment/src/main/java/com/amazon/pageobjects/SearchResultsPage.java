package com.amazon.pageobjects;


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

    @FindBy(xpath = "//span[contains(text(), 'Get It by Tomorrow')]")
    private WebElement getItByTomorrowCheckbox;

    @FindBy(xpath = "(//div[@class='a-row a-size-base a-color-secondary s-align-children-center'])[1]")
    private WebElement firstItemDeliveryDate;

    @FindBy(xpath = "//span[@class='a-price']")
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


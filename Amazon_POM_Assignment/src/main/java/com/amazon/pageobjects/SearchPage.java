package com.amazon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SearchPage extends AbstractComponent {

    @FindBy(css = ".s-main-slot .s-result-item")
    List<WebElement> searchResults;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void getLastDisplayedMobileDetails() {
        scrollToBottom();
        if (searchResults.size() > 1) {
            WebElement lastItem = searchResults.get(searchResults.size() - 6);
            System.out.println("Last displayed item: " + lastItem.getText());
        } else {
            System.out.println("Not enough items in the list.");
        }
    }
}

package com.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage extends AbstractComponent {

    @FindBy(id = "nav-hamburger-menu")
    WebElement menu;

    @FindBy(linkText = "Mobiles, Computers")
    WebElement mobilesComputers;

    public NavigationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToMobilesAndBack() throws InterruptedException {
        menu.click();
        mobilesComputers.click();
        Thread.sleep(2000);
        driver.navigate().back();
    }
}


package com.amazon.pageobjects;

import com.amazon.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage extends AbstractComponent {

    @FindBy(id = Constants.MENU)
    WebElement menu;

    @FindBy(linkText = Constants.MOBILES_COMPUTERS)
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


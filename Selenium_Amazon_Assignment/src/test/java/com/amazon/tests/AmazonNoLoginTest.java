package com.amazon.tests;


import com.amazon.pageobjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class AmazonNoLoginTest {
    WebDriver driver;
    HomePage homePage;
    DealsPage dealsPage;
    SearchPage searchPage;
    NavigationPage navigationPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        dealsPage = new DealsPage(driver);
        searchPage = new SearchPage(driver);
        navigationPage = new NavigationPage(driver);
    }

    @Test(priority = 1)
    public void openAmazon() throws InterruptedException {
        driver.get("https://www.amazon.in/");
        Thread.sleep(10000);
    }

    @Test(priority = 2)
    public void clickTodaysDeals() {
        homePage.goToTodaysDeals();
    }

    @Test(priority = 3)
    public void addThirdDealToCart() throws InterruptedException {
        dealsPage.addThirdDealToCart();
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    public void searchMobiles() {
        homePage.searchForItem("Mobiles");
    }

    @Test(priority = 5)
    public void getLastDisplayedMobileDetails() throws InterruptedException{
        searchPage.getLastDisplayedMobileDetails();
        Thread.sleep(3000);
    }

    @Test(priority = 6)
    public void navigateUsingLeftMenu() throws InterruptedException {
        navigationPage.navigateToMobilesAndBack();
    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
}


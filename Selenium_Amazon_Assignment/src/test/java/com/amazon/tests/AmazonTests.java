package com.amazon.tests;

import com.amazon.pageobjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonTests {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    OrdersPage ordersPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        ordersPage = new OrdersPage(driver);
        checkoutPage = new CheckoutPage(driver);
        paymentPage = new PaymentPage(driver);

        driver.get("https://www.amazon.in/");
        loginPage.login("someonexyzgo@gmail.com", "Supraja@17");
    }

    @Test(priority = 1)
    public void searchAndSelectPrimeDelivery() {
        homePage.searchProduct("Smartphone");
        searchResultsPage.selectGetItByTomorrow();
        String deliveryDate = searchResultsPage.getFirstItemDeliveryDate();
        System.out.println("Delivery Date: " + deliveryDate);
    }

    @Test(priority = 2)
    public void checkDeliveryStatus() {
        homePage.openCart();
    }

    @Test(priority = 3)
    public void checkPastOneYearOrders() {
        homePage.goToOrders();
        ordersPage.filterPastOneYearOrders("2024");
    }

    @Test(priority = 4)
    public void addNewDeliveryAddress() throws InterruptedException {
        homePage.openCart();
        checkoutPage.proceedToCheckout();
        checkoutPage.addNewAddress("Satyanivas Miryala", "7396439668", "500074", "5-5-804/1", "LB Nagar", "Hyderabad", "TELANGANA");
    }

    @Test(priority = 5)
    public void addPaymentOption() throws InterruptedException {
        paymentPage.addPaymentOption("4111111111111111", "Satya", "5", "2025");
    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
}

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
//
//import static jdk.internal.classfile.impl.DirectCodeBuilder.build;

public class MouseInteractionsDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");

// To use any actions we have to create Action class object

        Actions actions = new Actions(driver);

// Roves to specific elements

        actions.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']")))
                .build()
                .perform();

// noves to search and types in capital letters and selects the text

        actions.moveToElement(driver.findElement(By.cssSelector(("input[id='twotabsearchtextbox']"))))
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("nvidia gpu")
                .doubleClick()
                .build()
                .perform();

// right click (context click)

        actions.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']")))
                .contextClick()
                .build()
                .perform();
    }
}


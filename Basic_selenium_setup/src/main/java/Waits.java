import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // Comment the existing explicit wait to use Fluent Wait
        // WebDriverWait w = new WebDriverWait(driver, 5);

        // Fluent Wait Example
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10)) // Max wait time
                .pollingEvery(Duration.ofSeconds(2)) // Check every 2 seconds
                .ignoring(NoSuchElementException.class); // Ignore this exception while waiting

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);

        addItems(driver, itemsNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        // Replace explicit wait with Fluent Wait
        WebElement promoCodeInput = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        promoCodeInput.sendKeys("rahulshettyacademy");

        driver.findElement(By.cssSelector("button.promoBtn")).click();

        WebElement promoMessage = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(promoMessage.getText());
    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) {
        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {
            // Extract vegetable name
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

            // Convert array into list for easy search
            List itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName)) {
                j++;
                // Add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
    }
}


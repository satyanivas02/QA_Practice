import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        //through index-first we need to know the no.of frames
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        //driver.switchTo().frame(0);
        //switching through webelement and as well as index
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        //driver.findElement(By.id("draggable")).click();
        Actions a = new Actions(driver);

        WebElement src = driver.findElement(By.id("draggable"));
        WebElement tar = driver.findElement(By.id("droppable"));
        a.dragAndDrop(src,tar).build().perform();
        driver.switchTo().defaultContent();

    }
}

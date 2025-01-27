import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleIntro {


    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriverManager.firefoxdriver().setup();
        //WebDriver driver = new FirefoxDriver();
//        WebDriverManager.edgedriver().setup();
//        WebDriver driver = new EdgeDriver();
        driver.get("https://tinyurl.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
        //driver.quit();
    }
}

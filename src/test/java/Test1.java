import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.time.Duration;

public class Test1 {
    WebDriver chrome;
    WebDriverWait wait;

    @BeforeEach
    public void setup(){
        ClassLoader classLoader = new Test1().getClass().getClassLoader();
        String os = System.getProperty("os.name");
        if((os.indexOf("win") >= 0)){
            System.setProperty("webdriver.chrome.driver", classLoader.getResource("drivers/windows/chromedriver.exe").getPath());
        }else if(os.indexOf("mac") >= 0){
            System.setProperty("webdriver.chrome.driver", classLoader.getResource("drivers/mac/chromedriver").getPath());
        }else if(os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") > 0 ){
            System.setProperty("webdriver.chrome.driver", classLoader.getResource("drivers/linux/chromedriver").getPath());
        }
        chrome = new ChromeDriver();
        wait = new WebDriverWait(chrome, Duration.ofSeconds(10));
    }

    @Test
    public void searchCheese(){
        try {
            chrome.get("https://google.com");
            chrome.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
            WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3")));
            assertEquals("Cheese — Wikipédia",firstResult.getAttribute("textContent"));
        } finally {
            chrome.quit();
        }
    }

}

package seminars.five;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {
    @Test
    void testSearchSelenium() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com");

        WebElement webElement = webDriver.findElement(By.name("q"));
        webElement.sendKeys("Selenium");
        webElement.submit();

        List<WebElement> res = webDriver.findElements(By.cssSelector("div"));

        boolean faund = false;
        for (WebElement element : res) {
            if (element.getText().contains("selenium.dev")) {
                faund = true;
                break;
            }
        }

        assertTrue(faund);
        webDriver.quit();
    }
}

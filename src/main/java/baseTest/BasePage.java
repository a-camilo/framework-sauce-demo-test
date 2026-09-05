package baseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends BaseTest {
    WebElement webElement;

    public WebElement clicar(By by) {
        webElement = driver.findElement(by);
        while (!webElement.isDisplayed()) {
            esperar(10);
        }
        webElement.click();
        return webElement;
    }

    public WebElement clicar(String s) {
        webElement = driver.findElement(By.xpath(s));
        while (!webElement.isDisplayed()) {
            esperar(10);
        }
        webElement.click();
        return webElement;
    }

    public WebElement escrever(By by, String escrever) {
        webElement = driver.findElement(by);
        while (!webElement.isEnabled()) {
            esperar(10);
        }
        webElement.sendKeys(escrever);
        return webElement;
    }

    public void esperar(int second) {
        new WebDriverWait(driver, Duration.ofSeconds(second))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }
}

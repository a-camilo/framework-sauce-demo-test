package utils;

import baseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaiterUtils extends BaseTest {

    public static void waits(By by) {
        int sec = 10;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        while (sec > 10) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
    }

    public static void checkTitle(String titleStartsWith) {

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedCondition<Boolean>) d -> d.getTitle().toLowerCase().startsWith(titleStartsWith));
    }

}

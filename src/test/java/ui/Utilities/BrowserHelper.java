package ui.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserHelper {

//for shorter reusage. wait unitl el is visible or clickable
    public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element, int timeToWaitInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSeconds));

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitUntilClickableAndClickElement(WebDriver driver,WebElement element, int timeToWaitInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSeconds));
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        clickableElement.click();

        return clickableElement;
    }
}

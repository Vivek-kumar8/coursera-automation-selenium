package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtil {

    public static WebElement waitForVisibility(WebDriver driver, By locator, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    /**
     * Wait until all elements located by the locator are visible
     * and then return the list of WebElements
     */
    public static List<WebElement> waitForAllElementsVisible(
            WebDriver driver, By locator, int timeInSeconds) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static WebElement waitForClickable(WebDriver driver, By locator, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void click(WebDriver driver, By locator, int timeInSeconds) {
        waitForClickable(driver, locator, timeInSeconds).click();
    }

    public static void sendKeys(WebDriver driver, By locator, String text, int timeInSeconds) {
        WebElement element = waitForVisibility(driver, locator, timeInSeconds);
        element.clear();
        element.sendKeys(text);
    }
}
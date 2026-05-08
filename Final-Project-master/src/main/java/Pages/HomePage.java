package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Handles Coursera Home page actions
 */
public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // XPaths (unchanged)
    By searchInputBox = By.xpath("//input[@id='search-autocomplete-input']");
    By searchButton = By.xpath("//button[@aria-label='Search']//*[name()='svg']");

    /**
     * Search course using search box
     */
    public void searchCourse(String courseName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputBox))
                .sendKeys(courseName);

        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
}
package Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * This class is responsible for creating and returning the WebDriver
 * based on the browser name provided.
 */
public class ConfigureDriver {

    /**
     * This method returns the WebDriver object
     * based on the browser name (chrome, firefox, edge)
     */
    public static WebDriver Driver(String browserName) {

        WebDriver driver;

        // Choose browser based on input
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        else {
            throw new RuntimeException("Invalid browser name: " + browserName);
        }

        // Global page load timeout
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        return driver;
    }
}
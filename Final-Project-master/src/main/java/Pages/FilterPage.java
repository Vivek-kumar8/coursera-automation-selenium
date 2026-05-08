package Pages;

import Utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Handles language and level filters
 */
public class FilterPage {

    WebDriver driver;
    WebDriverWait wait;

    public FilterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Language Filter
    By languageDropdown = By.xpath(" //*[@data-testid='filter-dropdown-language']");
    By languageCheckbox = By.xpath("//*[@class='cds-checkboxAndRadio-label']//input");
    By languageViewButton = By.xpath("//*[@class='cds-149 cds-button-disableElevation cds-button-primary css-jqo50y']/span");

    // Level Filter
    By levelDropdown = By.xpath("//button[@data-testid='filter-dropdown-productDifficultyLevel']");
    By levelCheckbox = By.xpath("//*[@class='cds-checkboxAndRadio-label']//input[1]");
    By levelViewButton = By.xpath("//*[@class='cds-149 cds-button-disableElevation cds-button-primary css-jqo50y']/span");



    /**
     * Select first available language
     */
    public void selectFirstLanguage() {

        WaitUtil.click(driver,  languageDropdown,20);
        List<WebElement> languages = driver.findElements(languageCheckbox);
        languages.get(0).click();
        WaitUtil.click(driver,languageViewButton,20);
    }


    /**
     * Select first level (Beginner)
     */
    public void selectBeginnerLevel() {
//        wait.until(ExpectedConditions.elementToBeClickable(levelDropdown)).click();
        WaitUtil.click(driver,levelDropdown,20);
        List<WebElement> levels = driver.findElements(levelCheckbox);
        levels.get(0).click();
        WaitUtil.click(driver,levelViewButton,20);
    }

}

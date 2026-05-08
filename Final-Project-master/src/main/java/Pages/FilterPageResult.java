package Pages;

import Utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * This Page class handles Language and Level filter results
 * using centralized explicit waits (WaitUtil)
 */
public class FilterPageResult {

    WebDriver driver;

    // ------------ LANGUAGE FILTER LOCATORS ------------

    By languageDropDown =
            By.xpath(" //*[@data-testid='filter-dropdown-language']");

    By languageElements =
            By.xpath("//*[@class='cds-checkboxAndRadio-labelContent css-tvqrra']/span");

    By languageViewClose =
            By.xpath("//*[@class='cds-149 cds-button-disableElevation cds-button-primary css-jqo50y']/span");

    // ------------ LEVEL FILTER LOCATORS ------------

    By levelDropDown =
            By.xpath("//button[@data-testid='filter-dropdown-productDifficultyLevel']");

    By levelElements =
            By.xpath("//*[@class='cds-checkboxAndRadio-labelText']/span/span");

    By levelViewClose =
            By.xpath("//*[@class='cds-149 cds-button-disableElevation cds-button-primary css-jqo50y']/span");

    // Constructor
    public FilterPageResult(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Open Language filter, print all languages, then close filter
     */
    public void findLanguageList() throws InterruptedException {

        // Open Language dropdown
        WaitUtil.click(driver, languageDropDown, 20);

        // Wait for ALL language elements
        List<WebElement> languageList = WaitUtil.waitForAllElementsVisible(driver, languageElements, 50);

        System.out.println("List of languages");

        Thread.sleep(2000);
        for (WebElement lang : languageList) {

            String text = lang.getText();   // Example: "English (4,219)"

            String language = text.split("\\(")[0].trim();
            String count = "(" + text.split("\\(")[1];

            System.out.print(language+ " : " + count);
            System.out.println();
        }


        // Close/Apply Language filter
        WaitUtil.click(driver, languageViewClose, 50);
    }

    /**
     * Open Level filter, print all levels, then close filter
     */
    public void findLevelList() throws InterruptedException {

        // Open Level dropdown
        WaitUtil.click(driver, levelDropDown, 50);

        // Wait for ALL level elements
        List<WebElement> levelList =
                WaitUtil.waitForAllElementsVisible(driver, levelElements, 50);

        System.out.println("List of levels \n");
        Thread.sleep(2000);
        for (WebElement levelElement : levelList) {

            String text = levelElement.getText(); // e.g. "Beginner (4,219)"

            String level = text.split("\\(")[0].trim();
            String count = "(" + text.split("\\(")[1];

            System.out.println(level+" : " + count);
            System.out.println();

        }
        // Close/Apply Level filter
        WaitUtil.click(driver, levelViewClose, 50);
    }
}
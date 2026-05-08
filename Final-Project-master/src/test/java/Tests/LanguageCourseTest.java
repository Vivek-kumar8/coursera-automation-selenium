package Tests;

import Config.BaseTest;
import Pages.FilterPage;
import Pages.FilterPageResult;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LanguageCourseTest extends BaseTest {

    @Test
    public void verifyLanguageAndLevels() throws InterruptedException {

        test = extent.createTest("Language Learning Filter Test");
        WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(20));

        HomePage home = new HomePage(driver);
        FilterPageResult filter = new FilterPageResult(driver);

        home.searchCourse("Language Learning");
        test.pass("Searched Language Learning");
        //Language
        Thread.sleep(5000);

        filter.findLanguageList();
        test.pass("Language selected");

        //Level
        Thread.sleep(5000);
        filter.findLevelList();
        test.pass("Beginner level selected");
    }
}
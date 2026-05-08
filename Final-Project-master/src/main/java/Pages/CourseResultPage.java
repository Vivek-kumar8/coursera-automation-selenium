package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Handles course results page
 */
public class CourseResultPage {

    WebDriver driver;

    public CourseResultPage(WebDriver driver) {
        this.driver = driver;
    }

    By courseCards = By.xpath("//*[@class=\"cds-ProductCard-content\"]");

    /**
     * Print first 2 course details
     */



    public void printTopTwoCourses() throws InterruptedException {
        List<WebElement> courses = driver.findElements(courseCards);

        for (int i = 0; i < 2; i++) {
            String input = courses.get(i).getText();
            extractDetails(input);

        }
    }

    public static void extractDetails(String input) throws InterruptedException {

        String[] lines = input.split("\n");

        String courseName = "";
        String rating = "";
        String duration = "";

        //  Course name = second line
        if (lines.length > 1) {
            courseName = lines[1]
                    .replace("&amp;", "&")
                    .trim();
        }
     Thread.sleep(3000);
        // Find rating and duration
        for (String line : lines) {
            if (line.contains("★")) {

                // Rating → from ★ to first ·
                rating = line.substring(0, line.indexOf("·")).trim();

                // Duration → after last ·
                duration = line.substring(line.lastIndexOf("·") + 1).trim();
                break;
            }
        }
        System.out.println("Course Name: "+courseName);
        System.out.println("Rating: "+rating);
        System.out.println("Duration: "+duration);
        System.out.println();
    }
}































package Config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Base class for all TestNG test classes
 */
public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void setUp() {
        extent = ExtentManager.getReportInstance();
        driver = ConfigureDriver.Driver("chrome");
        Reporter.log("Driver is instantiated");

        driver.manage().window().maximize();
        driver.get("https://www.coursera.org/");
    }

    @AfterMethod
    public void tearDown() {
        Reporter.log("Driver closed browser");
        driver.quit();
        extent.flush();
    }
}
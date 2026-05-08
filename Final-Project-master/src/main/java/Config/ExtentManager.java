package Config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * Creates and configures Extent Report
 */
public class ExtentManager {

    public static ExtentReports getReportInstance() {

        ExtentSparkReporter reporter =
                new ExtentSparkReporter("test-output/ExtentReport.html");

        reporter.config().setReportName("Coursera Automation Report");
        reporter.config().setDocumentTitle("Test Execution Report");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);

        return extent;
    }
}
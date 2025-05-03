package TestNGAnnotations;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = "test-output/reports/ExtentReport.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setDocumentTitle("Automation Report");
            reporter.config().setReportName("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}
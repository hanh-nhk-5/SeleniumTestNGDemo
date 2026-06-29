package hanh.example.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportsUtil {
    public static ExtentReports getExtentRerport(){
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/reports/" + timestamp + ".html");
        reporter.config().setReportName("ExtentReports");
        reporter.config().setDocumentTitle("Test Result");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Creator", "Hanh Nguyen");
        return extent;
    }
}

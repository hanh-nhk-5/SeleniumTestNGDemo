package hanh.example.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import hanh.example.testComponents.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Listeners implements ITestListener {
    ExtentReports extentReport = ExtentReportsUtil.getExtentRerport();
    ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReport.createTest(result.getMethod().getMethodName());
        testThreadLocal.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if(result.getParameters().length > 0)
            testThreadLocal.get().info("Info: " + result.getParameters()[0].toString());

        testThreadLocal.get().log(Status.PASS, "Test passed");
        try {
            WebDriver driver = DriverManager.getDriver();
            String imgPath = getScreenShot(driver, result.getMethod().getMethodName());
            testThreadLocal.get().addScreenCaptureFromPath(imgPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if(result.getParameters().length > 0)
            testThreadLocal.get().info("Info: " + result.getParameters()[0].toString());

        testThreadLocal.get().fail(result.getThrowable());

        try {
            WebDriver driver = DriverManager.getDriver();
            String imgPath = getScreenShot(driver, result.getMethod().getMethodName());
            testThreadLocal.get().addScreenCaptureFromPath(imgPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if(result.getParameters().length > 0)
            testThreadLocal.get().info("Info: " + result.getParameters()[0].toString());
        testThreadLocal.get().skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReport.flush();
    }

    public String getScreenShot(WebDriver driver, String testName) throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String relativePath = "target/reports/screenshots/" + testName + "_" + timestamp + ".png";

        TakesScreenshot ts = (TakesScreenshot)driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(relativePath));

        // ExtentReports resolves image paths relative to the report HTML in target/reports/
        return "screenshots/" + testName + "_" + timestamp + ".png";
    }
}

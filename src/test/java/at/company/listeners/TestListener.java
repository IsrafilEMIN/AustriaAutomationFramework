package at.company.listeners;

import at.company.driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    // 1. Triggered when any @Test method starts
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    // 2. Triggered when any @Test method passes
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    // 3. Triggered when any @Test method fails
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());

        // Call the method to attach screenshot to Allure Report
        saveScreenshot(result.getName());
    }

    // 4. Helper method to take screenshot and attach to Allure
    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] saveScreenshot(String testName) {
        // We get the driver from our ThreadLocal Manager
        // We cast it to 'TakesScreenshot' to capture the image
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    // Other Interface methods we can leave empty for now
    @Override
    public void onTestSkipped(ITestResult result) {}

    @Override
    public void onStart(ITestContext context) {}

    @Override
    public void onFinish(ITestContext context) {}
}

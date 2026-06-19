package utils;

import base.DriverFactory;
import base.SeleniumTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener
        implements ITestListener {

    @Attachment(
            value = "{screenshotName}",
            type = "image/png")

    public byte[] captureScreenshot(String screenshotName) {

        return ((TakesScreenshot)
                DriverFactory.getDriver())
                .getScreenshotAs(
                        OutputType.BYTES);
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        if (DriverFactory.getDriver() != null) {

            captureScreenshot(
                    "Failure_" + result.getName());

            System.out.println(
                    "Screenshot attached to Allure report");
        }
    }

    @Override
    public void onTestStart(
            ITestResult result) {}

    @Override
    public void onTestSuccess(
            ITestResult result) {
        if (DriverFactory.getDriver() != null) {

            captureScreenshot("Success_" + result.getName());
            System.out.println(
                    "Success Screenshot attached");
        }
    }

    @Override
    public void onTestSkipped(
            ITestResult result) {

    }

    @Override
    public void onFinish(
            ITestContext context) {}
}
package utils;

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
            value = "Failure Screenshot",
            type = "image/png")

    public byte[] captureScreenshot() {

        return ((TakesScreenshot)
                SeleniumTest.driver)
                .getScreenshotAs(
                        OutputType.BYTES);
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        captureScreenshot();

        System.out.println(
                "Screenshot attached to Allure report");
    }

    @Override
    public void onTestStart(
            ITestResult result) {}

    @Override
    public void onTestSuccess(
            ITestResult result) {}

    @Override
    public void onTestSkipped(
            ITestResult result) {}

    @Override
    public void onFinish(
            ITestContext context) {}
}
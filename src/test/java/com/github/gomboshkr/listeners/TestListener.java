package com.github.gomboshkr.listeners;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.github.gomboshkr.tests.BaseTest;
import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author Kristian Gombosh
 */
@Log4j
public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info(String.format("Starting test %s", iTestResult.getTestName()));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info(String.format("Successfully finish test %s", iTestResult.getTestName()));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        createAttachment();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Attachment(value = "ScreenshotAttachment", type = "image/png")
    public byte[] createAttachment() {
        byte[] imageInByte = null;
        try {
            final BufferedImage image = ImageIO.read(((TakesScreenshot) BaseTest.DRIVER).getScreenshotAs(OutputType.FILE));
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            baos.flush();
            imageInByte = baos.toByteArray();
            baos.close();
        } catch (IOException e) {
            log.info("Exception log", e);
        }
        return imageInByte;
    }
}

package com.andersenlab.autotests.core.utils.testrail;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.andersenlab.autotests.core.utils.testrail.TestRailManager.testrailRunIdIsPresent;

/**
 * Used for uploading test results to testrail
 */
public class TestRailListener implements ITestListener {

    private String trimThrowableMessage(ITestResult result) {
        Pattern pattern = Pattern.compile("(Screenshot.+\\n)");
        Matcher matcher = pattern.matcher(result.getThrowable().getMessage());
        if (matcher.find()) {
            return result.getThrowable().getMessage().replace(matcher.group(), "");
        } else {
            return result.getThrowable().getMessage();
        }
    }

    private File makeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getAndCheckWebDriver()).getScreenshotAs(OutputType.FILE);
    }

    @Override
    public void onTestStart(ITestResult result) {
        if (testrailRunIdIsPresent)
            new TestRailHelper(result.getMethod()).setInProgressStatus();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (testrailRunIdIsPresent)
            new TestRailHelper(result.getMethod()).setPassedStatus();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (testrailRunIdIsPresent) {
            new TestRailHelper(result.getMethod()).setFailedStatus(trimThrowableMessage(result), makeScreenshot());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}

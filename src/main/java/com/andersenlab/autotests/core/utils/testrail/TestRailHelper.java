package com.andersenlab.autotests.core.utils.testrail;

import com.andersenlab.autotests.core.configs.SelenideConfiguration;
import io.qameta.allure.TmsLink;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestNGMethod;

import java.lang.reflect.Method;

@Slf4j
public class TestRailHelper {
    private TestRailApi testRailHelper;
    private String issue;
    private String runId;

    TestRailHelper(ITestNGMethod method) {
        testRailHelper = new TestRailApi();
        issue = getCaseIdFromTmsLink(method.getConstructorOrMethod().getMethod());
        runId = TestRailManager.testRunId;
    }

    private String getConfig() {
        return System.lineSeparator() + "Resolution: " + SelenideConfiguration.getResolution() + ", Proxy: "
                + SelenideConfiguration.getCountry() + " " + System.lineSeparator();
    }

    private String getCaseIdFromTmsLink(Method method) {
        if (method.isAnnotationPresent(TmsLink.class)) {
            return method.getAnnotation(TmsLink.class).value();
        } else {
            return null;
        }
    }

    public void setInProgressStatus() {
        testRailHelper.addResultWithComment(TestRailStatus.IN_PROGRESS,
                TestRailStatus.IN_PROGRESS.getComment(), runId, issue);
    }

    public void setPassedStatus() {
        testRailHelper.addResultWithComment(TestRailStatus.PASSED,
                TestRailStatus.PASSED.getComment() + getConfig(), runId, issue);
    }

    public void setFailedStatus() {
        testRailHelper.addResultWithComment(TestRailStatus.FAILED,
                TestRailStatus.FAILED.getComment() + getConfig(), runId, issue);
    }

    public void setFailedStatus(String errorMessage) {
        testRailHelper.addResultWithComment(TestRailStatus.FAILED,
                TestRailStatus.FAILED.getComment() + getConfig() + errorMessage, runId, issue);
    }

    public void setFailedStatus(String errorMessage, Object attachment) {
        testRailHelper.addResultWithCommentAndAttachment(TestRailStatus.FAILED,
                TestRailStatus.FAILED.getComment() + getConfig() + errorMessage, runId, issue, attachment);
    }
}

package com.andersenlab.autotests.core.utils.testrail;


import java.util.Arrays;
import java.util.List;

class TestRailManager {
    static final String testRunId = System.getProperty("testRail.runId");
    static final boolean testrailRunIdIsPresent = (testRunId != null && !testRunId.equals("0"));
    private static final boolean testsIdArePresent = (System.getProperty("testRail.testsId") != null &&
            !System.getProperty("testRail.testsId").equals("0") && !System.getProperty("testRail.testsId").equals("none"));
    static List<String> casesToRun = getCaseIdsToRun();

    private static List<String> getCaseIdsToRun() {
        if (testrailRunIdIsPresent || testsIdArePresent) {
            if (testrailRunIdIsPresent && !testsIdArePresent)
                return new TestRailApi().getTestCaseIdsFromTestRun(testRunId);
            else
                return Arrays.asList(System.getProperty("testRail.testsId").split(","));
        } else {
            return null;
        }
    }
}

package com.andersenlab.autotests.core.utils.testrail;

import io.qameta.allure.TmsLink;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Used for launching only selected tests
 */
public class TestSkipper implements IAnnotationTransformer {

    private String getCaseIdFromTmsLink(Method method) {
        if (method.isAnnotationPresent(TmsLink.class)) {
            return method.getAnnotation(TmsLink.class).value();
        } else {
            return null;
        }
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        boolean found = false;
        if (TestRailManager.casesToRun != null) {
            for (String temp : TestRailManager.casesToRun) {
                if (temp.equals(getCaseIdFromTmsLink(testMethod))) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                annotation.setEnabled(false);
            }
        }
    }
}

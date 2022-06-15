package com.andersenlab.autotests.site.techstack;

import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.page.techstack.calculators.CalculatorsFindDevelopers;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.*;

import java.lang.reflect.InvocationTargetException;

@Epic("Site")
@Listeners(SelenideListener.class)
public class CalculatorFindDevelopersTest {

    private CalculatorsFindDevelopers calculatorFD;

    @Parameters({"pageMethod"})
    @BeforeClass(alwaysRun = true)
    private void beforeClass(String pageMethod)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        calculatorFD = new CalculatorsFindDevelopers();
        Warp.testGetMethod(pageMethod);
    }

    @AfterClass(alwaysRun = true)
    private void afterClass() {
        Selenide.closeWebDriver();
    }


    @TmsLink("")
    @Test(description = "")
    public void calculatorTest (){
        calculatorFD.checkBusinessIndustryBlock();
        calculatorFD.checkYourDevelopmentTeamBlock();
        calculatorFD.checkAdditionalServicesBlock();
        calculatorFD.checkGetPriceButton();
        calculatorFD.checkSendFormBlock();
    }
}

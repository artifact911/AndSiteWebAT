package com.andersenlab.autotests.site;

import com.andersenlab.autotests.core.configs.SelenideConfiguration;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.Resolution;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.logic.Navigation;
import com.andersenlab.autotests.ui.locators.site.HeaderBlock;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Feature("Header")
@Listeners(SelenideListener.class)
public class HeaderPhoneTests {

    @AfterMethod()
    public void afterMethod() {
        Selenide.closeWebDriver();
    }

    @TmsLink("4790956")
    @Test
    public void phoneDesktopFr() {
        SelenideConfiguration.configure(Resolution.DESKTOP, Country.FR);
        Navigation.openHomeDev();
        Assertions.elementShouldBeVisible(HeaderBlock.headerTopBlock);
        Assertions.elementShouldBeVisible(HeaderBlock.headerBottomBlock);
        Assertions.elementShouldHaveText(HeaderBlock.phoneNumber, "+33 6 76 86 35 07");
   //   Assertions.elementShouldHaveHref(HeaderBlock.phoneNumber, "tel:+33676863507");
    }

    @TmsLink("4794371")
    @Test
    public void phoneDesktopDe() {
        SelenideConfiguration.configure(Resolution.DESKTOP, Country.DE);
        Navigation.openHomeDev();
        Assertions.elementShouldBeVisible(HeaderBlock.headerTopBlock);
        Assertions.elementShouldBeVisible(HeaderBlock.headerBottomBlock);
        Assertions.elementShouldHaveText(HeaderBlock.phoneNumber, "+49 (0) 30 59008 3687");
   //   Assertions.elementShouldHaveHref(HeaderBlock.phoneNumber, "tel:+49017665376937");
    }

}

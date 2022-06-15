package com.andersenlab.autotests;

import com.andersenlab.autotests.core.configs.SelenideConfiguration;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.Resolution;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.ui.locators.site.HeaderBlock;
import com.andersenlab.autotests.site.logic.Navigation;
import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.core.utils.PropertiesReader;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

@Epic("Self Test")
@Listeners(SelenideListener.class)
public class SelfTest {

    @AfterMethod
    public void afterMethod() {
        Selenide.closeWebDriver();
    }

    @Test(priority = -10)
    public void selenoidTest() {
        SelenideConfiguration.configure(Resolution.DESKTOP);
        Selenide.open(PropertiesReader.get("application.url"));
        Selenide.refresh();
    }

    @Test(priority = -9)
    public void proxyTestFR() {
        SelenideConfiguration.configure(Resolution.DESKTOP, Country.FR);
        Selenide.open("https://tools.keycdn.com/geo");
        $x("//dt[text()='Country']//following-sibling::*").shouldHave(Condition.text("France"));
    }

    @Test(priority = -9)
    public void proxyTestUS() {
        SelenideConfiguration.configure(Resolution.DESKTOP, Country.US);
        Selenide.open("https://tools.keycdn.com/geo");
        $x("//dt[text()='Country']//following-sibling::*").shouldHave(Condition.text("United States"));
    }

    @Test(priority = -9)
    public void proxyTestUA() {
        SelenideConfiguration.configure(Resolution.DESKTOP, Country.UA);
        Selenide.open("https://tools.keycdn.com/geo");
        $x("//dt[text()='Country']//following-sibling::*").shouldHave(Condition.text("Ukraine"));
    }

    @Test(priority = -9)
    public void proxyTestBY() {
        SelenideConfiguration.configure(Resolution.DESKTOP, Country.BY);
        Selenide.open("https://tools.keycdn.com/geo");
        $x("//dt[text()='Country']//following-sibling::*").shouldHave(Condition.text("Belarus"));
    }

    @Test(priority = -9)
    public void proxyTestRU() {
        SelenideConfiguration.configure(Resolution.DESKTOP, Country.RU);
        Selenide.open("https://tools.keycdn.com/geo");
        $x("//dt[text()='Country']//following-sibling::*").shouldHave(Condition.text("Russia"));
    }

    @Test(priority = -9)
    public void proxyTestDE() {
        SelenideConfiguration.configure(Resolution.DESKTOP, Country.DE);
        Selenide.open("https://tools.keycdn.com/geo");
        $x("//dt[text()='Country']//following-sibling::*").shouldHave(Condition.text("Germany"));
    }

    @Test(priority = -8)
    public void proxyAccessTestFR() {
        SelenideConfiguration.configure(Resolution.DESKTOP, Country.FR);
        Navigation.openHomeDev();
        Assertions.elementShouldBeVisible(HeaderBlock.headerTopBlock);
    }

    @Test(priority = -8)
    public void proxyAccessTestUS() {
        SelenideConfiguration.configure(Resolution.DESKTOP, Country.US);
        Navigation.openHomeDev();
        Assertions.elementShouldBeVisible(HeaderBlock.headerTopBlock);
    }

    @Test(priority = -8)
    public void proxyAccessTestUA() {
        SelenideConfiguration.configure(Resolution.DESKTOP, Country.UA);
        Navigation.openHomeDev();
        Assertions.elementShouldBeVisible(HeaderBlock.headerTopBlock);
    }

    @Test(priority = -8)
    public void proxyAccessTestBY() {
        SelenideConfiguration.configure(Resolution.DESKTOP, Country.BY);
        Navigation.openHomeDev();
        Assertions.elementShouldBeVisible(HeaderBlock.headerTopBlock);
    }

    @Test(priority = -8)
    public void proxyAccessTestRU() {
        SelenideConfiguration.configure(Resolution.DESKTOP, Country.RU);
        Navigation.openHomeDev();
        Assertions.elementShouldBeVisible(HeaderBlock.headerTopBlock);
    }

    @Test(priority = -8)
    public void proxyAccessTestDE() {
        SelenideConfiguration.configure(Resolution.DESKTOP, Country.DE);
        Navigation.openHomeDev();
        Assertions.elementShouldBeVisible(HeaderBlock.headerTopBlock);
    }

    @Test(priority = -7)
    public void resolutionTestMobile() {
        SelenideConfiguration.configure(Resolution.MOBILE);
        Selenide.open("http://google.com");
        Assertions.assertViewportSize("(375, 812)");
    }

    @Test(priority = -7)
    public void resolutionTestTablet() {
        SelenideConfiguration.configure(Resolution.TABLET);
        Selenide.open("http://google.com");
        Assertions.assertBrowserSize("(768, 1024)");
    }

    @Test(priority = -7)
    public void resolutionTestDesktop() {
        SelenideConfiguration.configure(Resolution.DESKTOP);
        Selenide.open("http://google.com");
        Assertions.assertBrowserSize("(1920, 1080)");
    }
}

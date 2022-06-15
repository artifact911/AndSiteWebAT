package com.andersenlab.autotests.core.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

/**
 * Default assertions to use with selenide
 */
public class Assertions {

    @Step("Assert: element should have href value")
    public static void elementShouldHaveHref(By locator, String hrefValue) {
        $(locator).shouldHave(Condition.attribute("href", hrefValue));
    }

    @Step("Assert: element should have text")
    public static void elementShouldHaveText(By locator, String text) {
        $(locator).shouldHave(Condition.text(text));
    }

    @Step("Assert: element should have exact text")
    public static void elementShouldHaveExactText(By locator, String text) {
        $(locator).shouldHave(Condition.exactText(text));
    }

    @Step("Assert: viewport size")
    public static void assertViewportSize(String expected) {
        String js = "return ('('+Math.max(document.documentElement.clientWidth, window.innerWidth || 0) +', '" +
                "+ Math.max(document.documentElement.clientHeight, window.innerHeight || 0 ) +')');";
        Assert.assertEquals(Selenide.executeJavaScript(js), expected);
    }

    @Step("Assert: browser size")
    public static void assertBrowserSize(String expected) {
        Assert.assertEquals(WebDriverRunner.driver().getWebDriver().manage().window().getSize().toString(), expected);
    }

    @Step("Assert: element is visible")
    public static void elementShouldBeVisible(By locator) {
        $(locator).shouldBe(Condition.visible);
    }

    @Step("Assert: url is contains")
    public static void assertCurrentUrlContains(String urlContains) {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertTrue(currentUrl.contains(urlContains), currentUrl + " does not contains " + urlContains);
    }

    @Step("Assert: element is not visible")
    public static void elementShouldNotBeVisible(By locator) {
        $(locator).shouldNot(Condition.visible);
    }

    @Step("Assert: mouse become a pointer after hovering")
    public static void mouseIsPointer(By locator) {
        Assert.assertTrue($(locator).hover().getCssValue("cursor").equalsIgnoreCase("pointer"));
    }

    @Step("Assert: mouse becomes a pointer after hovering")
    public static void mouseIsPointer(SelenideElement e) {
        Assert.assertTrue(e.hover().getCssValue("cursor").equalsIgnoreCase("pointer"));
    }

    @Step("Assert: mouse not becomes a pointer after hovering")
    public static void mouseIsNotPointer(SelenideElement e) {
        Assert.assertFalse(e.hover().getCssValue("cursor").equalsIgnoreCase("pointer"));
    }
}

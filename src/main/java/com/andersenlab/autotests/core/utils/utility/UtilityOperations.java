package com.andersenlab.autotests.core.utils.utility;


import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ex.ElementNotFound;
import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;

import static com.andersenlab.autotests.core.utils.utility.UtilityLocators.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

@Getter
public class UtilityOperations {


    public void acceptCookies() {
        try {
            $(acceptCookiesButton).click();
        } catch (ElementNotFound e) {
            refresh();
            $(acceptCookiesButton).shouldBe(Condition.visible).click();
        }
    }

    public boolean checkLoadSite() {
        return ($(headerTopBlock)
                .shouldBe(Condition.visible).isDisplayed()
                & $(headerBottomBlock)
                .shouldBe(Condition.visible).isDisplayed());
    }

    public String getPseudoElementContent(String locator) {
        String result = Selenide.executeJavaScript("return window.getComputedStyle(document.querySelector('" + locator + "'),':after').getPropertyValue('content');");
        return result.substring(1, result.length() - 1);
    }

    public void jsExecutorClick(String locator) {
        Selenide.executeJavaScript("return (document.querySelector('" + locator + "')).click()");
    }

}

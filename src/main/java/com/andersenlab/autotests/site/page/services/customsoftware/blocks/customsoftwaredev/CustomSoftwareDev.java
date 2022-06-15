package com.andersenlab.autotests.site.page.services.customsoftware.blocks.customsoftwaredev;

import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.Assert;

public class CustomSoftwareDev implements CustomSoftwareDevLocators {
    private CustomSoftwareDevElements el = new CustomSoftwareDevElements();

    @Step
    public void displayingElements() {
        Warp.scrollToElement(el.getHeader());
        Assert.assertEquals(el.getHeader().getAttribute("innerText"), TEXT_HEADER);
        el.getHeader().should(Condition.visible);
        Assert.assertEquals(el.getDescription().getAttribute("innerText"), TEXT_DESCRIPTION);
        el.getDescription().should(Condition.visible);

        Assert.assertEquals(el.getHeaderArticle1().getAttribute("innerText"), TEXT_HEADER_ARTICLE1);
        el.getHeaderArticle1().should(Condition.visible);
        Assert.assertEquals(el.getHeaderArticle2().getAttribute("innerText"), TEXT_HEADER_ARTICLE2);
        el.getHeaderArticle2().should(Condition.visible);
        Assert.assertEquals(el.getHeaderArticle3().getAttribute("innerText"), TEXT_HEADER_ARTICLE3);
        el.getHeaderArticle3().should(Condition.visible);

        Assert.assertEquals(el.getArticle1().getAttribute("innerText"), TEXT_ARTICLE1);
        el.getArticle1().should(Condition.visible);
        Assert.assertEquals(el.getArticle2().getAttribute("innerText"), TEXT_ARTICLE2);
        el.getArticle2().should(Condition.visible);
        Assert.assertEquals(el.getArticle3().getAttribute("innerText"), TEXT_ARTICLE3);
        el.getArticle3().should(Condition.visible);
    }
}

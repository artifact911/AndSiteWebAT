package com.andersenlab.autotests.site.page.services.salesforce.blocks.techexpertise;

import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

public class TechExpertise implements TechExpertiseLocators {
    private TechExpertiseElements el = new TechExpertiseElements();

    @Step
    public void displayingElements() {
        Warp.scrollToElement(el.getTitle());
        Assert.assertEquals(el.getTitle().getAttribute("innerText"), TEXT_TITLE);
        el.getTitle().should(Condition.visible);
//        Assert.assertEquals(el.getSubtitle().getAttribute("innerText"), TEXT_SUBTITLE);
//        el.getSubtitle().should(Condition.visible);

        Assert.assertEquals(el.getArticles().size(), ARTS_QUANTITY);
        boolean allVisible = true;
        for (SelenideElement certificate : el.getArticles()) {
            if (!certificate.isDisplayed()) {
                allVisible = false;
                break;
            }

        }
        Assert.assertTrue(allVisible);
    }
}

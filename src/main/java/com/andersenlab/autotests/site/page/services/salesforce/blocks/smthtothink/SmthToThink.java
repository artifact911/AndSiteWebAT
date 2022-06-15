package com.andersenlab.autotests.site.page.services.salesforce.blocks.smthtothink;

import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.Getter;
import org.testng.Assert;

@Getter
public class SmthToThink implements SmthToThinkLocators{
    private SmthToThinkElements el = new SmthToThinkElements();

    @Step
    public void displayingElements() {
        Assert.assertEquals(el.getTitle().getAttribute("innerText"), TEXT_TITLE);
        el.getTitle().should(Condition.visible);
        Assert.assertEquals(el.getSubtitle().getAttribute("innerText"), TEXT_SUBTITLE);
        el.getSubtitle().should(Condition.visible);
        Assert.assertTrue(Warp.isElementPresent(VC));
        Assert.assertTrue(Warp.checkLinkPart(el.getVc(), VC_HREF));
        Assertions.mouseIsPointer(el.getVc());
    }
}

package com.andersenlab.autotests.site.page.services.augmentation.contactus;

import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.form.commonforms.FormData;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.consultation.ConsultationElements;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.consultation.ConsultationLocators;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.Assert;

public class ContactUs implements ConsultationLocators, FormData {
    private ConsultationElements el = new ConsultationElements();

    @Step
    public void displayingElements(){
        Warp.scrollToElement(el.getCaptcha());
        Assert.assertEquals(el.getTitle().getText(), textTitle());
        Assert.assertEquals(el.getSubTitle().getText(), textSubTitle());
        Assert.assertEquals(el.getInputName().getAttribute("placeholder"), "Name");
        Assert.assertEquals(el.getInputMail().getAttribute("placeholder"), "Corporate E-mail");
        Assert.assertEquals(el.getInputComment().getAttribute("placeholder"), "Comments");
        Assert.assertEquals(el.getCheckBoxProtectText().getText(), TEXT_CHECKBOX);
        el.getCheckBoxProtectI().shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
        Assertions.elementShouldHaveExactText(HINT_CHECKBOX, TEXT_HINT_CHECKBOX);
        el.getButtonCloseHintCheckBox().click();
        el.getButtonSend().shouldBe(Condition.visible);
        el.getCaptcha().shouldBe(Condition.visible);
        Assertions.mouseIsPointer(LINK_PRIVACY_POLICY);
        Assertions.mouseIsPointer(LINK_TERMS);
        Assertions.mouseIsPointer(BUTTON_SEND);
        el.getLinkPrivacy().click();
        Warp.checkLinkNewTab(el.getLinkPrivacy(), PRIVACY_POLICY_HREF);
        el.getLinkTerms().click();
        Warp.checkLinkNewTab(el.getLinkTerms(), TERMS_HREF);
    }
}

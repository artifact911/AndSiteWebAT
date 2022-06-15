package com.andersenlab.autotests.site.page.services.customsoftware.blocks.consultation;

import com.andersenlab.autotests.site.form.commonforms.FormData;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.Assert;

public class Consultation implements ConsultationLocators, FormData {
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
        el.getCheckBoxProtectI().click();
        Assert.assertEquals(el.getHintCheckBoxText().getText(), TEXT_HINT_CHECKBOX);
        el.getButtonCloseHintCheckBox().click();
        el.getButtonSend().shouldBe(Condition.visible);
        el.getCaptcha().shouldBe(Condition.visible);
        Warp.checkLinkNewTab(el.getLinkPrivacy(), PRIVACY_POLICY_HREF);
        Warp.checkLinkNewTab(el.getLinkTerms(), TERMS_HREF);
    }
}

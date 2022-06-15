package com.andersenlab.autotests.site.logic;

import com.andersenlab.autotests.core.configs.constants.CSSProperties;
import com.andersenlab.autotests.core.configs.constants.Google;
import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.form.popup.requestform.RequestForm;
import com.andersenlab.autotests.site.form.popup.requestform.RequestFormElements;
import com.andersenlab.autotests.site.form.popup.requestform.RequestFormLocators;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RequestFormCheck {


    private final RequestForm requestForm;
    private final RequestFormElements elements = new RequestFormElements();

    public RequestFormCheck(String title){
        this.requestForm = new RequestForm(title);
    }

    @Step
    public void checkLinks(){
        requestForm.doBefore();
        requestForm.checkTitle();
        Assert.assertEquals(elements.getLinkMail().getCssValue("text-decoration"), CSSProperties.TextDecoration.BLACK_UNDERLINE.getCode());
        Assert.assertEquals(elements.getLinkMail().hover().getCssValue("animation"), CSSProperties.Animation.DEFAULT.getCode());
        Assertions.mouseIsPointer(elements.getLinkMail());
        Assert.assertEquals(elements.getLinkPhone().getCssValue("text-decoration"), CSSProperties.TextDecoration.BLACK_UNDERLINE.getCode());
        Assert.assertEquals(elements.getLinkPhone().hover().getCssValue("animation"), CSSProperties.Animation.DEFAULT.getCode());
        Assertions.mouseIsPointer(elements.getLinkPhone());
        requestForm.linkPhoneMail();
    }

    @Step
    public void checkForm(){
        Assert.assertEquals(elements.getButtonSendReq().getCssValue("text-decoration"), CSSProperties.TextDecoration.BLACK_UNDERLINE.getCode());
        Assert.assertEquals(elements.getButtonSendReq().hover().getCssValue("animation"), CSSProperties.Animation.DEFAULT.getCode());
        Assertions.mouseIsPointer(elements.getButtonSendReq());
        Assert.assertEquals(elements.getCheckBoxProtectI().getCssValue("text-decoration"), CSSProperties.TextDecoration.BLUE_UNDERLINE.getCode());
        Assert.assertEquals(elements.getCheckBoxProtectI().hover().getCssValue("animation"), CSSProperties.Animation.DEFAULT.getCode());
        Assertions.mouseIsPointer(elements.getCheckBoxProtectI());
        elements.getCheckBoxProtectI().click();
        Assert.assertTrue(elements.getCheckBoxProtectIPopup().isDisplayed());
        Assert.assertEquals(elements.getCheckBoxProtectIPopup().getText(), RequestFormLocators.TEXT_CHECKBOX_TO_PROTECT_I);
        elements.getButtonCloseCheckBoxProtectIPopup().click();
        Assert.assertFalse(elements.getCheckBoxProtectIPopup().isDisplayed());
        String element = "document.getElementsByClassName('forms-module--ndaCheckbox--33MxF')[2].getElementsByClassName('checkbox-module--box--1Irit')[0]";
        Assert.assertEquals(executeJavaScript("return window.getComputedStyle("+element+", ':before').getPropertyValue('background-color');"), CSSProperties.Color.INVISIBLE.getCode());
        elements.getCheckBoxProtect().click();
        Assert.assertEquals(executeJavaScript("return window.getComputedStyle("+element+", ':before').getPropertyValue('background-color');"), CSSProperties.Color.YELLOW_RGB.getCode());
        elements.getCheckBoxProtect().click();
        Assert.assertEquals(elements.getCheckBoxSpan().getCssValue("text-decoration"), CSSProperties.TextDecoration.BLACK_UNDERLINE.getCode());
    }

    @Step
    public void checkReCAPTCHA(){
        Assert.assertEquals($(RequestFormLocators.LINK_PRIVACY_POLICY).getCssValue("text-decoration"), CSSProperties.TextDecoration.BLACK_UNDERLINE.getCode());
        Assert.assertEquals($(RequestFormLocators.LINK_PRIVACY_POLICY).hover().getCssValue("animation"), CSSProperties.Animation.DEFAULT.getCode());
        Assertions.mouseIsPointer($(RequestFormLocators.LINK_PRIVACY_POLICY));
        Assert.assertEquals($(RequestFormLocators.LINK_TERMS).getCssValue("text-decoration"), CSSProperties.TextDecoration.BLACK_UNDERLINE.getCode());
        Assert.assertEquals($(RequestFormLocators.LINK_TERMS).hover().getCssValue("animation"), CSSProperties.Animation.DEFAULT.getCode());
        Assertions.mouseIsPointer($(RequestFormLocators.LINK_TERMS));
        Assert.assertEquals($(RequestFormLocators.LINK_PRIVACY_POLICY).getAttribute("href"), Google.expectedPrivacyLink);
        Assert.assertEquals($(RequestFormLocators.LINK_TERMS).getAttribute("href"), Google.expectedTermsLink);
    }
}

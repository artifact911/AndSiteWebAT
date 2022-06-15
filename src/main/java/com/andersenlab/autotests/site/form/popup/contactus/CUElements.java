package com.andersenlab.autotests.site.form.popup.contactus;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class CUElements implements CULocators {
    //top
    private SelenideElement Title = $(TITLE);
    private SelenideElement ButtonClose = $(BUTTON_CLOSE);
    //left
    private SelenideElement LinkSkype = $(LINK_SKYPE);
    private SelenideElement LinkWhatsApp = $(LINK_WHATSAPP);
    private SelenideElement LinkTelegram = $(LINK_TELEGRAM);
    private SelenideElement LinkLinked = $(LINK_LINKED);
    private SelenideElement LinkFb = $(LINK_FB);
    private SelenideElement TitleHQ = $(TITLE_HQ);
    private SelenideElement AddressHQ = $(ADDRESS_HQ);
    private SelenideElement TitleRO = $(TITLE_RO);
    private SelenideElement AddressRO = $(ADDRESS_RO);
    private SelenideElement LinkPhone = $(LINK_PHONE);
    private SelenideElement LinkPhoneSvg = $(LINK_PHONE_SVG);
    private SelenideElement LinkMail = $(LINK_MAIL);
    private SelenideElement LinkMailSvg = $(LINK_MAIL_SVG);
    //right
    private SelenideElement ButtonSend = $(BUTTON_SEND);
    private SelenideElement InputName = $(INPUT_NAME);
    private SelenideElement InputMail = $(INPUT_MAIL);
    private SelenideElement InputPhone = $(INPUT_PHONE);
    private SelenideElement InputComment = $(INPUT_COMMENT);
    private SelenideElement CheckBoxProtect = $(CHECKBOX_TO_PROTECT);
    private SelenideElement CheckBoxProtectI = $(CHECKBOX_TO_PROTECT_I);
    private SelenideElement CheckBoxProtectIPopup = $(CHECKBOX_TO_PROTECT_I_POPUP);
    private SelenideElement ButtonCloseCheckBoxProtectIPopup = $(BUTTON_CLOSE_CHECKBOX_TO_PROTECT_I_POPUP);
    private SelenideElement HintMailCooper = $(HINT_MAIL_COOPER);
    private SelenideElement AskPhone = $(ASK_PHONE);
    private SelenideElement AskMail = $(ASK_MAIL);
    //bottom
    private SelenideElement Captcha = $(CAPTCHA);
    private SelenideElement LinkPrivacyPolicy = $(LINK_PRIVACY_POLICY);
    private SelenideElement LinkTerms = $(LINK_TERMS);
    //success
//    private SelenideElement WindowSuccess = $(WINDOW_SUCCESS);
    private SelenideElement ButtonCloseSuccessWindow = $(BUTTON_CLOSE_SUCCESS_WINDOW);
    private SelenideElement TitleSuccessWindow = $(TITLE_SUCCESS);
}

package com.andersenlab.autotests.site.page.services.customsoftware.blocks.consultation;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ConsultationElements implements ConsultationLocators {
    private SelenideElement Title = $(TITLE);
    private SelenideElement SubTitle = $(SUBTITLE);
    private SelenideElement InputName = $(INPUT_NAME);
    private SelenideElement InputMail = $(INPUT_EMAIL);
    private SelenideElement InputPhone = $(INPUT_PHONE);
    private SelenideElement InputComment = $(INPUT_COMMENT);
    private SelenideElement ButtonSend = $(BUTTON_SEND);
    private SelenideElement CheckBoxProtect = $(CHECKBOX_TO_PROTECT);
    private SelenideElement CheckBoxProtectText = $(CHECKBOX_TO_PROTECT_TEXT);
    private SelenideElement CheckBoxProtectI = $(CHECKBOX_TO_PROTECT_I);
    private SelenideElement HintCheckBoxText = $(HINT_CHECKBOX);
    private SelenideElement ButtonCloseHintCheckBox = $(BUTTON_CLOSE_HINT_CHECKBOX);
    private SelenideElement LinkPrivacy = $(LINK_PRIVACY_POLICY);
    private SelenideElement LinkTerms = $(LINK_TERMS);
    private SelenideElement Captcha = $(CAPTCHA);
    private SelenideElement HintMail = $(HINT_MAIL_COOPER);
    private SelenideElement AskPhone = $(ASK_PHONE);
    private SelenideElement AskMail = $(ASK_MAIL);
    private SelenideElement WindowSuccess = $(WINDOW_SUCCESS);
    private SelenideElement ButtonCloseSuccess = $(BUTTON_CLOSE_SUCCESS_WINDOW);
    private SelenideElement TitleSuccess = $(TITLE_SUCCESS);
}

package com.andersenlab.autotests.site.form.popup.calculator;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class CalcFormElements implements CalcFormLocators {
    private SelenideElement ButtonCloseReqWindow = $(BUTTON_CLOSE_REQ_WINDOW);
    private SelenideElement LinkPhone = $(LINK_PHONE);
    private SelenideElement LinkMail = $(LINK_MAIL);
    private SelenideElement InputName = $(INPUT_NAME);
    private SelenideElement InputMail = $(INPUT_MAIL);
    private SelenideElement InputPhone = $(INPUT_PHONE);
    private SelenideElement InputComment = $(INPUT_COMMENT);
    private SelenideElement CheckBoxProtect = $(CHECKBOX_TO_PROTECT);
    private SelenideElement CheckBoxProtectI = $(CHECKBOX_TO_PROTECT_I);
    private SelenideElement CheckBoxProtectIPopup = $(CHECKBOX_TO_PROTECT_I_POPUP);
    private SelenideElement ButtonCloseCheckBoxProtectIPopup = $(BUTTON_CLOSE_CHECKBOX_TO_PROTECT_I_POPUP);
    private SelenideElement ButtonSendReq = $(BUTTON_SEND);

    private SelenideElement WindowReq = $(WINDOW_REQ);

    private SelenideElement HintMailCooper = $(HINT_MAIL_COOPER);
    private SelenideElement AskPhone = $(ASK_PHONE);
    private SelenideElement AskMail = $(ASK_MAIL);
    private SelenideElement TitleWindowReq = $(TITLE_REQ);
}

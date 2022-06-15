package com.andersenlab.autotests.site.form.requestform;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class RequestFormElements implements RequestFormLocators {
    private final SelenideElement ButtonCloseReqWindow = $(BUTTON_CLOSE_REQ);
    private final SelenideElement LinkPhone = $(LINK_PHONE);
    private final SelenideElement LinkMail = $(LINK_MAIL);
    private final SelenideElement InputName = $(INPUT_NAME);
    private final SelenideElement InputMail = $(INPUT_MAIL);
    private final SelenideElement InputPhone = $(INPUT_PHONE);
    private final SelenideElement InputComment = $(INPUT_COMMENT);
    private final SelenideElement CheckBoxProtect = $(CHECKBOX_TO_PROTECT);
    private final SelenideElement CheckBoxSpan = $(CHECKBOX_TO_PROTECT_SPAN);
    private final SelenideElement CheckBoxProtectI = $(CHECKBOX_TO_PROTECT_I);
    private final SelenideElement CheckBoxProtectIPopup = $(CHECKBOX_TO_PROTECT_I_POPUP);
    private final SelenideElement ButtonCloseCheckBoxProtectIPopup = $(BUTTON_CLOSE_CHECKBOX_TO_PROTECT_I_POPUP);
    private final SelenideElement ButtonSendReq = $(BUTTON_SEND);

//    private SelenideElement WindowReq = $(WINDOW_REQ);

    private final SelenideElement HintMailCooper = $(HINT_MAIL_COOPER);
    private final SelenideElement AskPhone = $(ASK_PHONE);
    private final SelenideElement AskMail = $(ASK_MAIL);
    private final SelenideElement TitleWindowReq = $(TITLE_REQ);
}

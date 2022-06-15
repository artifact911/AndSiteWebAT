package com.andersenlab.autotests.site.form.ourprojectsblock;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class CaseConsultationFormElements implements CaseConsultationFormLocators{
    private final SelenideElement ButtonSendReq = $(BUTTON_SEND_REQ);
    private final SelenideElement InputName = $(INPUT_NAME);
    private final SelenideElement InputMail = $(INPUT_MAIL);
    private final SelenideElement InputPhone = $(INPUT_PHONE);
    private final SelenideElement InputComment = $(INPUT_COMMENT);
    private final SelenideElement CheckBoxProtect = $(CHECKBOX_TO_PROTECT);
    private final SelenideElement CheckBoxText = $(CHECKBOX_TO_PROTECT_TEXT);
    private final SelenideElement HintTextForNDA = $(NDA_HINT_TEXT);
    private final SelenideElement HintForNDA = $(NDA_OPEN_HINT);
    private final SelenideElement CloseHintForNDA = $(NDA_CLOSE_BTN);
    private final SelenideElement Title = $(TITLE);
    private final SelenideElement Subtitle = $(SUBTITLE);
    private final SelenideElement HintMailCooper = $(HINT_MAIL_COOPER);
    private final SelenideElement AskPhone = $(ASK_PHONE);
    private final SelenideElement AskMail = $(ASK_MAIL);

    private final String inputNamePlaceholder = "Name";
    private final String inputMailPlaceholder = "Corporate E-mail";
    private final String inputPhoneMask = "+";
    private final String inputPhonePlaceholder = "Phone";
    private final String inputCommentsPlaceholder = "Comments";
    private final String NDACheckbox = "I want to protect my data by signing an";
    private final String NDAPopupInfo = "Before we discuss any details about your project you can request to sign a Non Disclosure Agreement";
}

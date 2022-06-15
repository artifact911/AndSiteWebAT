package com.andersenlab.autotests.site.form.popup.requestmeeting;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class RequestMeetingElements implements RequestMeetingLocators {
    private SelenideElement ButtonCloseReqWindow = $(BUTTON_CLOSE_REQ);
    private SelenideElement LinkPhone = $(LINK_PHONE);
    private SelenideElement linkPhoneSVG = $(LINK_PHONE_SVG);
    private SelenideElement LinkMail = $(LINK_MAIL);
    private SelenideElement linkMailSVG = $(LINK_MAIL_SVG);
    private SelenideElement InputName = $(INPUT_NAME);

    private SelenideElement InputMail = $(INPUT_MAIL_PHONE);
    private SelenideElement InputPhone = $(INPUT_MAIL_PHONE);

    private SelenideElement InputComment = $(INPUT_COMMENT);
    private SelenideElement ButtonSend = $(BUTTON_SEND);

//    private SelenideElement WindowSuccess = $(WINDOW_SUCCESS);
//    private SelenideElement ButtonCloseSuccessWindow = $(BUTTON_CLOSE_SUCCESS_WINDOW);
    private SelenideElement captcha = $(CAPTCHA);
    private SelenideElement TitleWindowReq = $(TITLE_REQ);
    private SelenideElement LinkPrivacyPolicy = $(LINK_PRIVACY_POLICY);
    private SelenideElement LinkTerms = $(LINK_TERMS);
    private SelenideElement AskMailPhone = $(ASK_MAIL_PHONE);
 






}

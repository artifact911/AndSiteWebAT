package com.andersenlab.autotests.site.form.contactusfooterus;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class CUFooterElementsUs implements CUFooterLocatorsUs {
    //top
    private SelenideElement Title = $(TITLE);
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
    //centre
    private SelenideElement CityKyiv = $(CITY_KYIV);
    private SelenideElement CityKyivPointer = $(CITY_KYIV_POINTER);

    //right
    private SelenideElement ButtonSend = $(BUTTON_SEND);
    private SelenideElement InputName = $(INPUT_NAME);
    private SelenideElement InputMail = $(INPUT_MAIL);
    private SelenideElement InputPhone = $(INPUT_PHONE);
    private SelenideElement InputComment = $(INPUT_COMMENT);

    private SelenideElement AskPhone = $(ASK_PHONE);
    private SelenideElement AskMail = $(ASK_MAIL);
    //bottom
    private SelenideElement Copyright = $(COPYRIGHT);
    private SelenideElement LinkPrivacyPolicyAndersen = $(LINK_PRIVACY_POLICY_ANDERSEN);
    private SelenideElement Captcha = $(CAPTCHA);

    private SelenideElement LinkPrivacyPolicy = $(LINK_PRIVACY_POLICY);
    private SelenideElement LinkTerms = $(LINK_TERMS);
    //success
    private SelenideElement WindowSuccess = $(WINDOW_SUCCESS);
    private SelenideElement ButtonCloseSuccessWindow = $(BUTTON_CLOSE_SUCCESS_WINDOW);
    private SelenideElement TitleSuccessWindow = $(TITLE_SUCCESS);
    //gallery
    private SelenideElement WindowGallery = $(WINDOW_GALLERY);
    private SelenideElement ButtonCloseGallery = $(BUTTON_CLOSE_WINDOW_GALLERY);
    private SelenideElement TitleGallery = $(TITLE_WINDOW_GALLERY);
    private SelenideElement PhotoMainGallery = $(PHOTO_WINDOW_GALLERY);
    private SelenideElement PhotoPrev1Gallery = $(PHOTO_PREVIEW_1_WINDOW_GALLERY);
    private SelenideElement PhotoPrev2Gallery = $(PHOTO_PREVIEW_2_WINDOW_GALLERY);
    private SelenideElement ButtonNextGallery = $(BUTTON_NEXT_PHOTO_WINDOW_GALLERY);
    private SelenideElement ButtonPrevGallery = $(BUTTON_PREV_PHOTO_WINDOW_GALLERY);
    private SelenideElement OrdinalGallery = $(ORDINAL_PHOTO_WINDOW_GALLERY);
}

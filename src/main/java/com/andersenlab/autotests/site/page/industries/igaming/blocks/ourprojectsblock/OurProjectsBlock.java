package com.andersenlab.autotests.site.page.industries.igaming.blocks.ourprojectsblock;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OurProjectsBlock {
    protected OurProjectsLocators locators = new OurProjectsLocators();
    protected ProjectArticlesLocators articles = new ProjectArticlesLocators();
    protected ProjectPopupLocators popup = new ProjectPopupLocators();
    protected ContactUsFormLocators form = new ContactUsFormLocators();

    @Getter protected SelenideElement title = $(locators.getTITLE());
    @Getter protected SelenideElement subtitle = $(locators.getSUBTITLE());
    @Getter protected SelenideElement showMore = $(locators.getSHOW_MORE());

    @Getter protected ElementsCollection articleTitles = $$(articles.getTITLE());
    @Getter protected ElementsCollection articleSubtitles = $$(articles.getSUBTITLE());
    @Getter protected ElementsCollection articleCardButtons = $$(articles.getCARD_BUTTON());
    @Getter protected ElementsCollection articleCardImages = $$(articles.getCARD_IMAGE());

    @Getter private final SelenideElement popupTitle = $(popup.getTITLE());
    @Getter private final ElementsCollection popupSections = $$(popup.getSECTION_TITLE());
    @Getter private final ElementsCollection popupImages = $$(popup.getIMAGE());
    @Getter private final ElementsCollection popupSEO = $$(popup.getSTRING());
    @Getter private final SelenideElement popupConcept = $$(popup.getSECTION_TITLE()).get(0);
    @Getter private final SelenideElement popupAbout = $$(popup.getSECTION_TITLE()).get(1);
    @Getter private final SelenideElement popupFunctionality = $$(popup.getSECTION_TITLE()).get(2);
    @Getter private final SelenideElement popupSolution = $$(popup.getSECTION_TITLE()).get(3);
    @Getter private final SelenideElement popupResults = $$(popup.getSECTION_TITLE()).get(4);
    @Getter private final SelenideElement popupContactUs = $(popup.getCONTACT_US());
    @Getter private final SelenideElement popupClose = $(popup.getCLOSE_BTN());

    @Getter private final SelenideElement formTitle = $(form.getTITLE());
    @Getter private final SelenideElement formNDAtext = $(form.getNDA_CHECKBOX());
    @Getter private final SelenideElement formNDAinfoButton = $(form.getNDA_I_BTN());
    @Getter private final SelenideElement formNDAinfo = $(form.getNDA_POPUP());
    @Getter private final SelenideElement formNDAclose = $(form.getNDA_POPUP_CLOSE());
    @Getter private final SelenideElement formRecaptcha = $(form.getRECAPTCHA_TEXT());
    @Getter private final SelenideElement formPrivacyLink = $(form.getPRIVACY());
    @Getter private final SelenideElement formTermsLink = $(form.getTERMS());

    public static final String expectedTitle = "Contact us to learn more and receive a free consultation";
    public static final String expectedNDAText = "I want to protect my data by signing an NDA.";
    public static final String expectedNDAPopupInfo = "Before we discuss any details about your project you can request to sign a Non Disclosure Agreement";
}



package com.andersenlab.autotests.site.industries.realestate;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.CTABlockData;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.FeaturesIndexBlockData;
import com.andersenlab.autotests.core.configs.constants.MultipleCardsWithTextData.RealEstateBenefits;
import com.andersenlab.autotests.core.configs.constants.MultipleCardsWithTextData.RealEstateWhatWeSuggest;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.CallToAction;
import com.andersenlab.autotests.site.form.consultation.ConsultationForm;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.FreeConsultationBlock;
import com.andersenlab.autotests.site.page.industries.realestate.blocks.BenefitsOfCustomSoftware;
import com.andersenlab.autotests.site.page.industries.realestate.blocks.QuickFacts;
import com.andersenlab.autotests.site.page.industries.realestate.blocks.WhatWeSuggest;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex.FeaturesIndex;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Epic("Site")
@Listeners(SelenideListener.class)
public class RealEstatePageTest extends BaseTest2 {
    private final Pages page = Pages.REAL_ESTATE;
    private final Country country = Country.BY;
    private final String title = "Let’s talk business";
    private final String subtitle = "Up to 30% of real estate agents use Word, Outlook, and Excel for business management. Order Real Estate Software Development from our company and become head and shoulders above your competitors.";
    private final ConsultationForm consultationForm = new ConsultationForm(title, subtitle);


    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
        consultationForm.setConditions(page, country);
    }

    @TmsLink("5294856")
    @Test(description = "[D] [T] [M] Отображение заголовка")
    public void displayingIntro(){
        Intro intro = new Intro();
        intro.displayingTitle(country);
        intro.displayingPhone(country);
    }

    @TmsLink("5325936") //todo rework!!!
    @Test(description = "[D][T][M] Отображение и функциональность блока с буллитами 'Transforming the analog real estate business into a digital one'")
    public void displayingSoftDev(){
        FeaturesIndex index = new FeaturesIndex(FeaturesIndexBlockData.Left.REAL_ESTATE.getData(), FeaturesIndexBlockData.Right.REAL_ESTATE.getData());

        index.checkImg();
        index.checkTitle();
        index.checkSubtitle();
        index.checkBtn();
        index.checkArticles();
    }

    @TmsLink("5325956")
    @Test(description = "[D][T][M] Отображение блока 'Quick fact'")
    public void displayingQuickFacts(){
        QuickFacts block = new QuickFacts();
        block.checkTitle();
        block.checkTexts();
}

    @TmsLink("5325969")
    @Test(description = "[D][T][M] Отображение блока 'Check out the benefits of custom real estate software by Andersen'")
    public void displayingBenefits(){
        String title = RealEstateBenefits.HEADER.getTitle();
        String subtitle = RealEstateBenefits.HEADER.getMessage();
        List<List<String>> articles = Arrays.asList(
                Arrays.asList(RealEstateBenefits.FIRST.getTitle(),
                        RealEstateBenefits.FIRST.getMessage(),
                        RealEstateBenefits.FIRST.getImageLink()),
                Arrays.asList(RealEstateBenefits.SECOND.getTitle(),
                        RealEstateBenefits.SECOND.getMessage(),
                        RealEstateBenefits.SECOND.getImageLink())
        );
        BenefitsOfCustomSoftware block = new BenefitsOfCustomSoftware(title, subtitle, articles);
        block.checkTitle();
        block.checkSubtitle();
        block.checkCards();
    }

    @TmsLink("5325977")
    @Test(description = "[D][T][M] Отображение и функциональность блока 'Are you ready to order your custom real estate software?'")
    public void displayingFreeQuoteBlock(){
        CallToAction block = new CallToAction(CTABlockData.Page.REAL_ESTATE.getExpected());

        block.checkTitle();
        block.checkBtn();
    }

    @TmsLink("5325981")
    @Test(description = "[D][T][M] Отображение блока 'What we suggest'")
    public void displayingWhatWeSuggest(){
        String title = RealEstateWhatWeSuggest.HEADER.getTitle();
        String subtitle = RealEstateWhatWeSuggest.HEADER.getMessage();
        List<List<String>> articles = Arrays.asList(
                Arrays.asList(RealEstateWhatWeSuggest.FIRST.getTitle(),
                        RealEstateWhatWeSuggest.FIRST.getMessage(),
                        RealEstateWhatWeSuggest.FIRST.getImageLink()),
                Arrays.asList(RealEstateWhatWeSuggest.SECOND.getTitle(),
                        RealEstateWhatWeSuggest.SECOND.getMessage(),
                        RealEstateWhatWeSuggest.SECOND.getImageLink()),
                Arrays.asList(RealEstateWhatWeSuggest.THIRD.getTitle(),
                        RealEstateWhatWeSuggest.THIRD.getMessage(),
                        RealEstateWhatWeSuggest.THIRD.getImageLink()),
                Arrays.asList(RealEstateWhatWeSuggest.FOURTH.getTitle(),
                        RealEstateWhatWeSuggest.FOURTH.getMessage(),
                        RealEstateWhatWeSuggest.FOURTH.getImageLink()),
                Arrays.asList(RealEstateWhatWeSuggest.FIFTH.getTitle(),
                        RealEstateWhatWeSuggest.FIFTH.getMessage(),
                        RealEstateWhatWeSuggest.FIFTH.getImageLink()),
                Arrays.asList(RealEstateWhatWeSuggest.SIXTH.getTitle(),
                        RealEstateWhatWeSuggest.SIXTH.getMessage(),
                        RealEstateWhatWeSuggest.SIXTH.getImageLink())
        );
        WhatWeSuggest block = new WhatWeSuggest(title, subtitle, articles);
        block.checkTitle();
        block.checkSubtitle();
        block.checkCards();
    }

    @TmsLink("5325983")
    @Test(description = "[D][T][M] Отображение блока 'Let’s talk business'")
    public void displayingLetsTalkBlock(){
        consultationForm.checkTitle();
        consultationForm.checkSubtitle();
        consultationForm.checkForm();
    }

    @TmsLink("5325994")
    @Test(description = "Функционал блока 'Let’s talk business'")
    public void checkLetsTalkBlock(){
        consultationForm.checkFormFields();
        consultationForm.checkCAPTCHALinks();
    }

    @TmsLink("5383093")
    @Test(description = "[D] [T] [M] Отображение и функциональность блока 'Whether you are in the early stage...'")
    public void displayingScheduleYourFree(){
        String title = "Whether you are in the early stage or have an ongoing project, our professional"+
                " Real Estate architects are always ready to consult and guide you within the development process."+
                " Schedule a free online consultation with our specialists.";
        String formTitle = "Request consultation";
        String popupTitle = "Solution Architecture";
        FreeConsultationBlock freeConsultationBlock = new FreeConsultationBlock();
        freeConsultationBlock.checkBlock(title);
        freeConsultationBlock.checkPopupForm(formTitle);
        freeConsultationBlock.checkPopupInfo(popupTitle);
    }

    @TmsLink("5678818")
    @Test(description = "[EN] Отображение и функциональность контактной формы в блоке с буллетами, где текст кнопки 'Request consultation'", priority = 100, groups = "Checking the main form for leads")
    public void checkMainFormForLeads(){
        MainFormForLeads mainFormForLeads = new MainFormForLeads();
        mainFormForLeads.scrollToButtonAndCheckTitle(mainFormForLeads.getButtonInMainModule(), "Request consultation");
        mainFormForLeads.checkEmailField();
        mainFormForLeads.checkPhoneField();
        mainFormForLeads.checkNda();
        mainFormForLeads.sendFormAndCheckSuccessfulModalWindow();
    }

    @TmsLink("5803694")
    @Test(description = "Проверить наличие блоков", priority = 110, groups = "Checking the blocks")
    public void checkBlocks(){
        CheckingThePresenceOfBlocks checkingThePresenceOfBlocks = new CheckingThePresenceOfBlocks();
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIntro());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getArchitect());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFeature());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIndustryRecognition());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getPageInterlinking());
    }
}

package com.andersenlab.autotests.site.industries.retail;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.*;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.consultation.ConsultationForm;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.form.ourprojectsblock.CaseCheck;
import com.andersenlab.autotests.site.logic.OurProjectsCheck;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.CustomerReviewsDataIGamingPlatform;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.FreeConsultationBlock;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.WhatWeDoBlock;
import com.andersenlab.autotests.site.page.industries.retail.CustomSoftwareDevelopmentBlock;
import com.andersenlab.autotests.site.page.industries.retail.CustomerReviewsDataRetail;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviews;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex.FeaturesIndex;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Widgets;
import com.andersenlab.autotests.site.utility.Warp;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

@Epic("Site")
@Listeners(SelenideListener.class)
public class RetailPageTest extends BaseTest2 {
    private final Pages page = Pages.RETAIL;
    private final Country country = Country.BY;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
    }

    @TmsLink("5325934")
    @Test(description = "проверка метаданных- title, meta", priority = 10)
    public void checkMetaData(){
        String title = "Retail Software Development | Andersen";
        String description = "Team of our engineers provides custom retail software development to the retail business. Years of experience and functional knowledge of industry allows to find best solutions.";
        Assert.assertEquals(Warp.tabTitle(), title);
        Assert.assertEquals($(By.xpath("//meta[@name='description']")).getAttribute("content"), description);
    }

    @TmsLink("5310226")
    @Test(description = "Отображение хедера", priority = 20)
    public void displayingIntro(){
        Intro b = new Intro(new Widgets[]{Widgets.CLUTCH, Widgets.CLUTCH_STARED});
        b.displayingTitle(country);
        b.displayingPhone(country);
    }

    @TmsLink("5310307")
    @Test(description = "Отображение и функциональность блока 'Fuel your business with the robust retail software built by a trusted development house'", priority = 30)
    public void displayingSoftDev(){
        FeaturesIndex index = new FeaturesIndex(FeaturesIndexBlockData.Left.RETAIL.getData(), FeaturesIndexBlockData.Right.RETAIL.getData());

        index.checkImg();
        index.checkTitle();
        index.checkBtn();
        index.checkArticles();
    }

    @TmsLink("5310228")
    @Test(description = "Отображение и функциональность блока 'Custom software development for retail'", priority = 40)
    public void displayingCustomSoftDev(){
        String title = MultipleCardsWithTextData.RetailCustomSoftDev.HEADER.getData().get(0);
        String subtitle = MultipleCardsWithTextData.RetailCustomSoftDev.HEADER.getData().get(1);
        List<List<String>> cards = Arrays.asList(
                MultipleCardsWithTextData.RetailCustomSoftDev.FIRST.getData(),
                MultipleCardsWithTextData.RetailCustomSoftDev.SECOND.getData(),
                MultipleCardsWithTextData.RetailCustomSoftDev.THIRD.getData()
        );
        CustomSoftwareDevelopmentBlock customSoftDev = new CustomSoftwareDevelopmentBlock();
        customSoftDev.checkTitle(title, subtitle);
        customSoftDev.checkArticles(cards);
    }

    @TmsLink("5338201")
    @Test(description = "Отображение блока 'Our projects'", priority = 50)
    public void displayingProjectExamples(){
        String title = OurProjectsBlockData.Retail.RETAIL.getData().get(0);
        String subtitle = OurProjectsBlockData.Retail.RETAIL.getData().get(1);
        List<List<String>> cards = Arrays.asList(
                OurProjectsBlockData.Retail.EXIGO.getData(),
                OurProjectsBlockData.Retail.MEDIA_MARKT.getData(),
                OurProjectsBlockData.Retail.SALE_GROUP.getData()
        );
        OurProjectsCheck check = new OurProjectsCheck();
        check.checkTitleAndSubtitle(title, subtitle);
        check.checkCaseCards(cards);
    }

    @TmsLink("5338195")
    @Test(description = "Отображение кейса 'Exigo'", priority = 60)
    public void displayingExigo(){
        int caseIndex = 0;
        List<String> caseSectionsTitles = Arrays.asList(
                CasesModel.SectionTitles.CONCEPT.getText(),
                CasesModel.SectionTitles.ABOUT.getText(),
                CasesModel.SectionTitles.FUNCTIONALITY.getText(),
                CasesModel.SectionTitles.RESULTS.getText(),
                CasesModel.SectionTitles.CONTACT_US.getText());
        CaseCheck caseCheck = new CaseCheck();
        caseCheck.titlesCheck(caseIndex, caseSectionsTitles);
    }

    @TmsLink("5338196")
    @Test(description = "Отображение кейса 'Media Markt'", priority = 70)
    public void displayingMediaMarkt(){
        int caseIndex = 1;
        List<String> caseSectionsTitles = Arrays.asList(
                CasesModel.SectionTitles.CONCEPT.getText(),
                CasesModel.SectionTitles.ABOUT.getText(),
                CasesModel.SectionTitles.FUNCTIONALITY.getText(),
                CasesModel.SectionTitles.RESULTS.getText(),
                CasesModel.SectionTitles.CONTACT_US.getText());
        CaseCheck caseCheck = new CaseCheck();
        caseCheck.titlesCheck(caseIndex, caseSectionsTitles);
    }

    @TmsLink("5338209")
    @Test(description = "Отображение кейса 'Sale Group'", priority = 80)
    public void displayingSaleGroup(){
        int caseIndex = 2;
        List<String> caseSectionsTitles = Arrays.asList(
                CasesModel.SectionTitles.CONCEPT.getText(),
                CasesModel.SectionTitles.ABOUT.getText(),
                CasesModel.SectionTitles.FUNCTIONALITY.getText(),
                CasesModel.SectionTitles.SOLUTION.getText(),
                CasesModel.SectionTitles.RESULTS.getText(),
                CasesModel.SectionTitles.CONTACT_US.getText());
        CaseCheck caseCheck = new CaseCheck();
        caseCheck.titlesCheck(caseIndex, caseSectionsTitles);
    }

    //todo написать новый блок под эту хрень
    @TmsLink("5310441")
    @Test(description = "Отображение блока 'Contact us for a free Retail consultation'", priority = 90)
    public void displayingConsultationBlock(){
        ConsultationForm consultationForm = new ConsultationForm("Contact us for a free Retail consultation");
        consultationForm.checkTitle();
        consultationForm.checkForm();
    }

    @TmsLink("5383373")
    @Test(description = "Отображение и функциональность блока 'Whether you are in the early stage...'", priority = 100)
    public void displayingScheduleYourFree(){
        String title = "Whether you are in the early stage or have an ongoing project,"+
                " our professional Retail architects are always ready to consult and guide you within the development process."+
                " Schedule a free online consultation with our specialists.";
        String formTitle = "Request consultation";
        String popupTitle = "Solution Architecture";
        FreeConsultationBlock freeConsultationBlock = new FreeConsultationBlock();
        freeConsultationBlock.checkBlock(title);
        freeConsultationBlock.checkPopupForm(formTitle);
        freeConsultationBlock.checkPopupInfo(popupTitle);
    }

    @TmsLink("5366469")
    @Test(description = "Отображение и функциональность блока 'Testimonials'", priority = 110)
    public void displayingFunctionCustomerReviews(){
        CustomerReviews b = new CustomerReviews(new CustomerReviewsDataRetail());
        b.displayingElements();
    }

    @TmsLink("5374184")
    @Test(description = "Отображение блока 'What we do'", priority = 120)
    public void displayingWhatWeDo(){
        WhatWeDoBlock whatWeDo = new WhatWeDoBlock();
        whatWeDo.checkWhatWeDoTitle();
        whatWeDo.checkWhatWeDoArticles();
    }

    @TmsLink("5678818")
    @Test(description = "[EN] Отображение и функциональность контактной формы в блоке с буллетами, где текст кнопки 'Request consultation'", priority = 130, groups = "Checking the main form for leads")
    public void checkMainFormForLeads(){
        MainFormForLeads mainFormForLeads = new MainFormForLeads();
        mainFormForLeads.scrollToButtonAndCheckTitle(mainFormForLeads.getButtonInMainModule(), "Request consultation");
        mainFormForLeads.checkEmailField();
        mainFormForLeads.checkPhoneField();
        mainFormForLeads.checkNda();
        mainFormForLeads.sendFormAndCheckSuccessfulModalWindow();
    }

    @TmsLink("5803694")
    @Test(description = "Проверить наличие блоков", priority = 140, groups = "Checking the blocks")
    public void checkBlocks(){
        CheckingThePresenceOfBlocks checkingThePresenceOfBlocks = new CheckingThePresenceOfBlocks();
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIntro());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getArchitect());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFeature());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIndustryRecognition());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getProjects());
    }
}

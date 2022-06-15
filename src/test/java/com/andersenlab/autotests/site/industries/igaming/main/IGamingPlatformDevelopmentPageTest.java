package com.andersenlab.autotests.site.industries.igaming.main;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.constants.CSSProperties.Color;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.FeaturesIndexBlockData;
import com.andersenlab.autotests.core.configs.constants.OurProjectsBlockData;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.core.configs.constants.CasesModel;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.form.ourprojectsblock.CaseCheck;
import com.andersenlab.autotests.site.logic.OurProjectsCheck;
import com.andersenlab.autotests.site.logic.RequestFormCheck;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.*;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviews;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex.FeaturesIndex;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Widgets;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.cv.CvBlock;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Epic("Site")
@Listeners(SelenideListener.class)
public class IGamingPlatformDevelopmentPageTest extends BaseTest2 {
    private final Pages page = Pages.CUSTOM_IGAMING_SOFTWARE_DEVELOPMENT;
    private final Country country = Country.BY;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
    }

    @TmsLink("5309509")
    @Test(description = "Отображение хедера", priority = 10)
    public void displayingIntro(){
        Intro intro = new Intro(new Widgets[]{Widgets.CLUTCH, Widgets.PECB_MS_ISO_9001, Widgets.PECB_MS_ISO_27001});
        intro.displayingElements(country);
    }

    @TmsLink("5309510")
    @Test(description = "Отображение и функциональность блока 'Call your iGaming ideas into play with an expert in-house team of software developers'", priority = 20)
    public void displayingSoftDev(){
        FeaturesIndex index = new FeaturesIndex(FeaturesIndexBlockData.Left.IGAMING.getData(), FeaturesIndexBlockData.Right.IGAMING.getData());

        index.checkImg();
        index.checkTitle();
        index.checkBtn();
        index.checkArticles();
    }

    @TmsLink("5309511")
    @Test(description = " Отображение и функциональность модального окна формы 'Request consultation'", priority = 30)
    public void displayingRequestConsultationPopUp(){
        RequestFormCheck requestFormCheck = new RequestFormCheck("Request consultation");
        requestFormCheck.checkLinks();
        requestFormCheck.checkForm();
        requestFormCheck.checkReCAPTCHA();
    }

    @TmsLink("5309512")
    @Test(description = "Отображение и функциональность блока 'iGaming software development services'", priority = 40)
    public void displayingSoftDevServices(){
        SoftwareDevelopment softDev = new SoftwareDevelopment();
        String linkToBettingSoftDev = "https://stage.andersenlab.com/industries/gambling/betting";
        String linkToIgamingPlatform = "https://stage.andersenlab.com/industries/gambling/igaming";
        Assert.assertTrue(softDev.getTitle().isDisplayed());
        Assert.assertEquals(softDev.getLinksSeeMore().first().getCssValue("color"), Color.BLACK_LINK.getCode());
        Assert.assertEquals(softDev.getLinksSeeMore().first().hover().getCssValue("color"), Color.YELLOW.getCode());
        Assert.assertEquals(softDev.getLinksSeeMore().first().getAttribute("href"), linkToIgamingPlatform);
        Assert.assertEquals(softDev.getLinksSeeMore().last().getAttribute("href"), linkToBettingSoftDev);
    }

    @TmsLink("5309513")
    @Test(description = "Отображение блока 'What we do'", priority = 50)
    public void displayingWhatWeDo(){
        WhatWeDoBlock whatWeDo = new WhatWeDoBlock();
        whatWeDo.checkWhatWeDoTitle();
        whatWeDo.checkWhatWeDoCards();
    }

    @TmsLink("5276648")
    @Test(description = "Отображение блока 'Our engineers", priority = 60)
    public void displayingCVBlock(){
        CvBlock cvBlock = new CvBlock();
        cvBlock.displayingElementsAndFunction();
    }

    @TmsLink("5309515")
    @Test(description = "Отображение блока 'Our projects'", priority = 70)
    public void displayingProjectExamples(){
        String title = OurProjectsBlockData.Igaming.IGAMING.getData().get(0);
        String subtitle = OurProjectsBlockData.Igaming.IGAMING.getData().get(1);
        List<List<String>> cards = Arrays.asList(
                OurProjectsBlockData.Igaming.RUSH_CASINO.getData(),
                OurProjectsBlockData.Igaming.SOCIAL_CASINO.getData(),
                OurProjectsBlockData.Igaming.MB.getData(),
                OurProjectsBlockData.Igaming.BET_LAKES.getData()
        );
        OurProjectsCheck check = new OurProjectsCheck();
        check.checkTitleAndSubtitle(title, subtitle);
        check.checkCaseCards(cards);
    }

    @TmsLink("5309516")
    @Test(description = "Отображение кейса 'Rush Casino'", priority = 80)
    public void displayingRushCasino(){
        int caseIndex = 0;
        List<String> caseSectionsTitles = Arrays.asList(CasesModel.SectionTitles.CONCEPT.getText(), CasesModel.SectionTitles.ABOUT.getText(),
                CasesModel.SectionTitles.FUNCTIONALITY.getText(), CasesModel.SectionTitles.SOLUTION.getText(),
                CasesModel.SectionTitles.RESULTS.getText(), CasesModel.SectionTitles.CONTACT_US.getText());
        CaseCheck caseCheck = new CaseCheck();
        caseCheck.titlesCheck(caseIndex, caseSectionsTitles);
    }

    @TmsLink("5309517")
    @Test(description = "Отображение кейса 'Social Casino'", priority = 90)
    public void displayingSocialCasino(){
        int caseIndex = 1;
        List<String> caseSectionsTitles = Arrays.asList(CasesModel.SectionTitles.CONCEPT.getText(), CasesModel.SectionTitles.ABOUT.getText(),
                CasesModel.SectionTitles.FUNCTIONALITY.getText(), CasesModel.SectionTitles.SOLUTION.getText(),
                CasesModel.SectionTitles.RESULTS.getText(), CasesModel.SectionTitles.CONTACT_US.getText());
        CaseCheck caseCheck = new CaseCheck();
        caseCheck.titlesCheck(caseIndex, caseSectionsTitles);
    }

    @TmsLink("5309518")
    @Test(description = "Отображение кейса 'MB'", priority = 100)
    public void displayingMB(){
        int caseIndex = 2;
        List<String> caseSectionsTitles = Arrays.asList(CasesModel.SectionTitles.CONCEPT.getText(), CasesModel.SectionTitles.ABOUT.getText(),
                CasesModel.SectionTitles.FUNCTIONALITY.getText(), CasesModel.SectionTitles.SOLUTION.getText(),
                CasesModel.SectionTitles.RESULTS.getText(), CasesModel.SectionTitles.CONTACT_US.getText());
        CaseCheck caseCheck = new CaseCheck();
        caseCheck.titlesCheck(caseIndex, caseSectionsTitles);
    }

    @TmsLink("5310201")
    @Test(description = "Отображение кейса 'BetLakes'", priority = 110)
    public void displayingBetLakes(){
        int caseIndex = 3;
        List<String> caseSectionsTitles = Arrays.asList(CasesModel.SectionTitles.CONCEPT.getText(), CasesModel.SectionTitles.ABOUT.getText(),
                CasesModel.SectionTitles.FUNCTIONALITY.getText(), CasesModel.SectionTitles.SOLUTION.getText(),
                CasesModel.SectionTitles.RESULTS.getText(), CasesModel.SectionTitles.CONTACT_US.getText());
        CaseCheck caseCheck = new CaseCheck();
        caseCheck.titlesCheck(caseIndex, caseSectionsTitles);
    }

    @TmsLink("5366471")
    @TmsLink("5324224")
    @Test(description = "Отображение и функциональность блока 'Testimonials'", priority = 120) //todo пофиксить список отзывов
    public void displayingFunctionCustomerReviews(){
        CustomerReviews reviews = new CustomerReviews(new CustomerReviewsDataIGaming());
        reviews.displayingElements();
    }

    @TmsLink("5383097")
    @Test(description = "Отображение и функциональность блока 'Whether you are in the early stage...'", priority = 130)
    public void displayingScheduleYourFree(){
        String title = "Whether you are in the early stage or have an ongoing project, our professional iGaming "+
                "architects are always ready to consult and guide you within the development process. "+
                "Schedule a free online consultation with our specialists.";
        String formTitle = "Request consultation";
        String popupTitle = "Solution Architecture";
        FreeConsultationBlock freeConsultationBlock = new FreeConsultationBlock();
        freeConsultationBlock.checkBlock(title);
        freeConsultationBlock.checkPopupForm(formTitle);
        freeConsultationBlock.checkPopupInfo(popupTitle);
    }

    @TmsLink("5678818")
    @Test(description = "[EN] Отображение и функциональность контактной формы в блоке с буллетами, где текст кнопки 'Request consultation'", priority = 140, groups = "Checking the main form for leads")
    public void checkMainFormForLeads(){
        MainFormForLeads mainFormForLeads = new MainFormForLeads();
        mainFormForLeads.scrollToButtonAndCheckTitle(mainFormForLeads.getButtonInMainModule(), "Request consultation");
        mainFormForLeads.checkEmailField();
        mainFormForLeads.checkPhoneField();
        mainFormForLeads.checkNda();
        mainFormForLeads.sendFormAndCheckSuccessfulModalWindow();
    }

    @TmsLink("5803694")
    @Test(description = "Проверить наличие блоков", priority = 150, groups = "Checking the blocks")
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

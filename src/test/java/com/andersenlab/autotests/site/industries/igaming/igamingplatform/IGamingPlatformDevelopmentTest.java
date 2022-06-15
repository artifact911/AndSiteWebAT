package com.andersenlab.autotests.site.industries.igaming.igamingplatform;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.FeaturesIndexBlockData;
import com.andersenlab.autotests.core.configs.constants.OurProjectsBlockData;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.core.configs.constants.CasesModel;
import com.andersenlab.autotests.core.configs.constants.CSSProperties;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.form.ourprojectsblock.CaseCheck;
import com.andersenlab.autotests.site.logic.OurProjectsCheck;
import com.andersenlab.autotests.site.logic.RequestFormCheck;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.CustomerReviewsDataIGamingPlatform;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.SoftwareDevelopment;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.WhatWeDoBlock;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviews;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex.FeaturesIndex;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Widgets;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.cv.CvBlock;
import com.andersenlab.autotests.site.utility.Warp;
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
public class IGamingPlatformDevelopmentTest extends BaseTest2 {

    private final Pages page = Pages.IGAMING_PLATFORM_DEVELOPMENT;
    private final Country country = Country.BY;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
    }

    @TmsLink("5309521")
    @Test(description = "Отображение хедера", priority = 10)
    public void displayingIntro(){
        Intro intro = new Intro(new Widgets[]{Widgets.CLUTCH, Widgets.PECB_MS_ISO_9001, Widgets.PECB_MS_ISO_27001});
        intro.displayingElements(country);
    }

    @TmsLink("5309522")
    @Test(description = "Отображение блока 'Build your iGaming Platform from scratch or boost an already existing solution with an in-house team of experts.'", priority = 20)
    public void displayingSoftDev(){
        FeaturesIndex index = new FeaturesIndex(FeaturesIndexBlockData.Left.IGAMING_PLATFORM.getData(), FeaturesIndexBlockData.Right.IGAMING_PLATFORM.getData());

        index.checkImg();
        index.checkTitle();
        index.checkBtn();
        index.checkArticles();
    }

    @TmsLink("5324107")
    @Test(description = "Отображение и функциональность модального окна формы 'Request consultation'", priority = 30)
    public void displayingRequestConsultationPopUp(){
        RequestFormCheck requestFormCheck = new RequestFormCheck("Request consultation");
        requestFormCheck.checkLinks();
        requestFormCheck.checkForm();
        requestFormCheck.checkReCAPTCHA();
    }

    @TmsLink("5309524")
    @Test(description = "Отображение блока 'What we do'", priority = 40)
    public void displayingWhatWeDo(){
        //1. Перейти к блоку "What we do"
        WhatWeDoBlock whatWeDo = new WhatWeDoBlock();
        Assert.assertEquals(whatWeDo.getTitle().getText(), "What we do");
        //2. Кликнуть на кнопку "See more" в каждой карточке где эта кнопка есть
        for (int i=0; i<whatWeDo.getSeeMore().size(); i++){
            Assert.assertFalse(whatWeDo.getPopupTitle().isDisplayed());
            whatWeDo.getSeeMore().get(i).click();
            Warp.delay(1);
            Assert.assertTrue(whatWeDo.getPopupTitle().isDisplayed());
            whatWeDo.getPopupCloseBtn().click();
            Warp.delay(1);
            Assert.assertFalse(whatWeDo.getPopupTitle().isDisplayed());
        }
    }

    @TmsLink("5324111")
    @Test(description = "Отображение блока 'Our engineers", priority = 50)
    public void displayingCVBlock(){
        CvBlock cvBlock = new CvBlock();
        cvBlock.displayingElementsAndFunction();
    }

    @TmsLink("5309526")
    @Test(description = "Отображение блока 'More iGaming software development services'", priority = 60)
    public void displayingSoftDevServices(){
        String linkToIgamingMain = "https://stage.andersenlab.com/industries/gambling";
        String linkToBettingSoftDev = "https://stage.andersenlab.com/industries/gambling/betting";
        SoftwareDevelopment softDev = new SoftwareDevelopment();
        Assert.assertTrue(softDev.getTitle().isDisplayed());
        Assert.assertEquals(softDev.getLinksSeeMore().first().getCssValue("color"), CSSProperties.Color.BLACK_LINK.getCode());
        Assert.assertEquals(softDev.getLinksSeeMore().first().hover().getCssValue("color"), CSSProperties.Color.YELLOW.getCode());
        //Кликнуть на кнопку-ссылку "See more" в карточке "Sports Betting"
        Assert.assertEquals(softDev.getLinksSeeMore().first().getAttribute("href"), linkToBettingSoftDev);
        //Кликнуть на кнопку-ссылку "Return to iGaming page"
        Assert.assertEquals(softDev.getLinksSeeMore().last().getAttribute("href"), linkToIgamingMain);
    }

    @TmsLink("5324215")
    @Test(description = "Отображение блока 'Our projects'", priority = 70)
    public void displayingProjectExamples(){
        String title = OurProjectsBlockData.Igaming.IGAMING_PLATFORM_DEVELOPMENT.getData().get(0);
        String subtitle = OurProjectsBlockData.Igaming.IGAMING_PLATFORM_DEVELOPMENT.getData().get(1);
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

    @TmsLink("5324216")
    @Test(description = "Отображение кейса 'Rush Casino'", priority = 80)
    public void displayingRushCasino(){
        int caseIndex = 0;
        List<String> caseSectionsTitles = Arrays.asList(CasesModel.SectionTitles.CONCEPT.getText(), CasesModel.SectionTitles.ABOUT.getText(),
                CasesModel.SectionTitles.FUNCTIONALITY.getText(), CasesModel.SectionTitles.SOLUTION.getText(),
                CasesModel.SectionTitles.RESULTS.getText(), CasesModel.SectionTitles.CONTACT_US.getText());
        CaseCheck caseCheck = new CaseCheck();
        caseCheck.titlesCheck(caseIndex, caseSectionsTitles);
    }

    @TmsLink("5324217")
    @Test(description = "Отображение кейса 'Social Casino'", priority = 90)
    public void displayingSocialCasino(){
        int caseIndex = 1;
        List<String> caseSectionsTitles = Arrays.asList(CasesModel.SectionTitles.CONCEPT.getText(), CasesModel.SectionTitles.ABOUT.getText(),
                CasesModel.SectionTitles.FUNCTIONALITY.getText(), CasesModel.SectionTitles.SOLUTION.getText(),
                CasesModel.SectionTitles.RESULTS.getText(), CasesModel.SectionTitles.CONTACT_US.getText());
        CaseCheck caseCheck = new CaseCheck();
        caseCheck.titlesCheck(caseIndex, caseSectionsTitles);
    }

    @TmsLink("5324218")
    @Test(description = "Отображение кейса 'MB'", priority = 100)
    public void displayingMB(){
        int caseIndex = 2;
        List<String> caseSectionsTitles = Arrays.asList(CasesModel.SectionTitles.CONCEPT.getText(), CasesModel.SectionTitles.ABOUT.getText(),
                CasesModel.SectionTitles.FUNCTIONALITY.getText(), CasesModel.SectionTitles.SOLUTION.getText(),
                CasesModel.SectionTitles.RESULTS.getText(), CasesModel.SectionTitles.CONTACT_US.getText());
        CaseCheck caseCheck = new CaseCheck();
        caseCheck.titlesCheck(caseIndex, caseSectionsTitles);
    }

    @TmsLink("5324219")
    @Test(description = "Отображение кейса 'BetLakes'", priority = 110)
    public void displayingBetLakes(){
        int caseIndex = 3;
        List<String> caseSectionsTitles = Arrays.asList(CasesModel.SectionTitles.CONCEPT.getText(), CasesModel.SectionTitles.ABOUT.getText(),
                CasesModel.SectionTitles.FUNCTIONALITY.getText(), CasesModel.SectionTitles.SOLUTION.getText(),
                CasesModel.SectionTitles.RESULTS.getText(), CasesModel.SectionTitles.CONTACT_US.getText());
        CaseCheck caseCheck = new CaseCheck();
        caseCheck.titlesCheck(caseIndex, caseSectionsTitles);
    }

    @TmsLink("5390827")
    @TmsLink("5366537")
    @Test(description = "Отображение и функциональность блока 'Testimonials'", priority = 130)
    public void displayingFunctionCustomerReviews(){
        CustomerReviews reviews = new CustomerReviews(new CustomerReviewsDataIGamingPlatform());
        reviews.displayingElements();
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
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFeature());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIndustryRecognition());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getProjects());
    }
}

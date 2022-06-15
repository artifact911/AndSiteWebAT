package com.andersenlab.autotests.site.industries.videoandentertainment;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.CasesModel.SEOOptimization;
import com.andersenlab.autotests.core.configs.constants.CompanyOfExpertsData.Clouds;
import com.andersenlab.autotests.core.configs.constants.CostCalcData;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.FeaturesIndexBlockData;
import com.andersenlab.autotests.core.configs.constants.OurProjectsBlockData;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.form.ourprojectsblock.CaseCheck;
import com.andersenlab.autotests.core.configs.constants.CasesModel.ImageLinks;
import com.andersenlab.autotests.site.logic.OurProjectsCheck;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.CustomerReviewsDataIGamingPlatform;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.WhatWeDoBlock;
import com.andersenlab.autotests.site.page.industries.videoandentertainment.blocks.CompanyOfExperts;
import com.andersenlab.autotests.site.page.industries.videoandentertainment.blocks.CustomerReviewsDataVideoAndEntertainment;
import com.andersenlab.autotests.site.page.industries.videoandentertainment.blocks.costcalc.DesktopCostCalc;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviews;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex.FeaturesIndex;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Widgets;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.cv.CvBlock;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Epic("Site")
@Listeners(SelenideListener.class)
public class MediaEntertainmentDesktopPageTest extends BaseTest2 {
    private final Pages page = Pages.MEDIA_AND_ENTERTAINMENT;
    private final Country country = Country.BY;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
    }

    @BeforeMethod(alwaysRun = true)
    @Override
    protected void beforeMethod(){
        super.beforeMethod();
    }

    @TmsLink("5294855")
    @Test(description = "[D][T][M] Отображение хедера страницы", priority = 10)
    public void displayingIntro(){
        Intro intro = new Intro(new Widgets[]{});
        intro.displayingElements(country);
    }

    @TmsLink("5286577")
    @Test(description = "[D] [T] [M] Отображение и функциональность блока с буллитами 'Get the most from the digital transformation in Multimedia and Entertainment in your business'", priority = 20)
    public void displayingSoftDev(){
        FeaturesIndex index = new FeaturesIndex(FeaturesIndexBlockData.Left.VIDEOENTERTAINMENT.getData(), FeaturesIndexBlockData.Right.VIDEOENTERTAINMENT.getData());

        index.checkImg();
        index.checkTitle();
        index.checkBtn();
        index.checkArticles();
    }

    @TmsLink("5329746")
    @Test(description = "[D] [T] [M] Отображение и функциональность блока 'Our projects'", priority = 30)
    public void displayingOurProjects(){
        String title = OurProjectsBlockData.VideoEntertainment.VIDEO_ENTERTAINMENT.getData().get(0);
        String subtitle = OurProjectsBlockData.VideoEntertainment.VIDEO_ENTERTAINMENT.getData().get(1);
        List<List<String>> cards = Arrays.asList(
                OurProjectsBlockData.VideoEntertainment.ORIGAMI.getData(),
                OurProjectsBlockData.VideoEntertainment.CINEMEYE.getData(),
                OurProjectsBlockData.VideoEntertainment.MERCEDES_ME.getData(),
                OurProjectsBlockData.VideoEntertainment.GLOBE_CHANNEL.getData(),
                OurProjectsBlockData.VideoEntertainment.SAMSUNG.getData(),
                OurProjectsBlockData.VideoEntertainment.WINNERS.getData()
        );
        OurProjectsCheck check = new OurProjectsCheck();
        check.checkTitleAndSubtitle(title, subtitle);
        check.checkCaseCards(cards);
    }

    @TmsLink("5329795")
    @Test(description = "[D] [T] [M] Отображение кейса 'Origami'", priority = 40)
    public void displayingCaseOrigami(){
        CaseCheck caseCheck = new CaseCheck(0, ImageLinks.ORIGAMI.getLinks());
        caseCheck.imagesCheck();
    }

    @TmsLink("5330133")
    @Test(description = "[D] [T] [M] Отображение кейса 'Cinemeye'", priority = 50)
    public void displayingCaseCinemeye(){
        CaseCheck caseCheck = new CaseCheck(1, ImageLinks.CINEMEYE.getLinks());
        caseCheck.imagesCheck();
    }

    @TmsLink("5330134")
    @Test(description = "[D] [T] [M] Отображение кейса 'Mercedes ME'", priority = 60)
    public void displayingCaseMercedesME(){
        CaseCheck caseCheck = new CaseCheck(2, ImageLinks.MERCEDES_ME.getLinks());
        caseCheck.imagesCheck();
    }

    @TmsLink("5366896")
    @Test(description = "[D] [T] [M] Отображение кейса 'Globe channel'", priority = 70)
    public void displayingCaseGlobeChannel(){
        CaseCheck caseCheck = new CaseCheck(3, ImageLinks.GLOBE_CHANNEL.getLinks());
        caseCheck.imagesCheck();
    }

    @TmsLink("5366927")
    @Test(description = "[D] [T] [M] Отображение кейса 'Samsung'", priority = 80)
    public void displayingCaseSamsung(){
        CaseCheck caseCheck = new CaseCheck(4, ImageLinks.SAMSUNG.getLinks());
        caseCheck.imagesCheck();
    }

    @TmsLink("5366959")
    @Test(description = "[D] [T] [M] Отображение кейса 'Winners'", priority = 90)
    public void displayingCaseWinners(){
        CaseCheck caseCheck = new CaseCheck(5, ImageLinks.WINNERS.getLinks());
        caseCheck.imagesCheck();
    }

    @TmsLink("5331901")
    @Test(description = "SEO оптимизация: добавление индексируемого текста для кейсов в блоке 'Our projects'", priority = 100)
    public void checkSEOOptimizationForCases(){
        CaseCheck caseCheck = new CaseCheck();
        List<List<String>> hidden = Arrays.asList(
                SEOOptimization.ORIGAMI.getHiddenText(),
                SEOOptimization.CINEMEYE.getHiddenText(),
                SEOOptimization.MERCEDES_ME.getHiddenText(),
                SEOOptimization.GLOBE_CHANNEL.getHiddenText(),
                SEOOptimization.SAMSUNG.getHiddenText(),
                SEOOptimization.WINNERS.getHiddenText());
        caseCheck.checkIndexedTextInCases(hidden);
    }

    @TmsLink("5341959")
    @Test(description = "[D][T][M] Отображение блока с сертификатами", priority = 110)
    public void displayingCertificatesBlock(){
        List<List<String>> certificates = Arrays.asList(
                Clouds.ORACLE.getEl(),
                Clouds.AZURE.getEl(),
                Clouds.SALESFORCE.getEl(),
                Clouds.RED_HAT.getEl(),
                Clouds.ALIBABA.getEl(),
                Clouds.AWS.getEl(),
                Clouds.GOOGLE.getEl(),
                Clouds.DIGITAL_OCEAN.getEl());
        CompanyOfExperts experts = new CompanyOfExperts(Clouds.TITLE.getEl(), certificates);
        experts.checkTitle();
        experts.checkSubtitle();
        experts.checkCertificates();
    }

    @TmsLink("5346697")
    @Test(description = "[D] Отображение блока с калькулятором 'Your price calculator'", priority = 120)
    public void displayingDesktopCalcBlock(){
        DesktopCostCalc block = new DesktopCostCalc(CostCalcData.Page.VIDEO_ENTERTAINMENT.getData(), country);
        block.checkDesktopCalc();
    }

    @TmsLink("5366464")
    @Test(description = "[D] [T] [M] Отображение и функциональность блока Testimonials", priority = 130)
    public void displayingTestimonials(){
        CustomerReviews reviews = new CustomerReviews(new CustomerReviewsDataVideoAndEntertainment());
        reviews.displayingElements();
    }

    @TmsLink("5374181")
    @Test(description = "Отображение и функциональность блока 'What we do'", priority = 140)
    public void displayingWhatWeDo(){
        WhatWeDoBlock whatWeDo = new WhatWeDoBlock();
        whatWeDo.checkWhatWeDoTitle();
        whatWeDo.checkWhatWeDoCards();
    }

    @TmsLink("5396921")
    @Test(description = "[D][T][M] Отображение и функциональность блока 'Team of experts'", priority = 150)
    public void displayingTeamOfExpertsBlock(){
        CvBlock b = new CvBlock();
        b.displayingElementsAndFunction();
    }

    @TmsLink("5678818")
    @Test(description = "[EN] Отображение и функциональность контактной формы в блоке с буллетами, где текст кнопки 'Request consultation'", priority = 160, groups = "Checking the main form for leads")
    public void checkMainFormForLeads(){
        MainFormForLeads mainFormForLeads = new MainFormForLeads();
        mainFormForLeads.scrollToButtonAndCheckTitle(mainFormForLeads.getButtonInMainModule(), "Request consultation");
        mainFormForLeads.checkEmailField();
        mainFormForLeads.checkPhoneField();
        mainFormForLeads.checkNda();
        mainFormForLeads.sendFormAndCheckSuccessfulModalWindow();
    }

    @TmsLink("5803694")
    @Test(description = "Проверить наличие блоков", priority = 170, groups = "Checking the blocks")
    public void checkBlocks(){
        CheckingThePresenceOfBlocks checkingThePresenceOfBlocks = new CheckingThePresenceOfBlocks();
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIntro());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCalculator());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCallToActionWithPhoto());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCollaborationModel());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFeature());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGreetingCard());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getProjects());
    }
}

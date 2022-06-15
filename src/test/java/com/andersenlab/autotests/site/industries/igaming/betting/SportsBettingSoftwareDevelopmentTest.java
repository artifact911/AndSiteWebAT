package com.andersenlab.autotests.site.industries.igaming.betting;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.FeaturesIndexBlockData;
import com.andersenlab.autotests.core.configs.constants.OurProjectsBlockData;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.core.configs.constants.CasesModel.SectionTitles;
import com.andersenlab.autotests.core.configs.constants.CSSProperties;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.form.ourprojectsblock.CaseCheck;
import com.andersenlab.autotests.site.logic.OurProjectsCheck;
import com.andersenlab.autotests.site.logic.RequestFormCheck;
import com.andersenlab.autotests.site.logic.WhatWeDoGridCheck;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.CustomerReviewsDataIGaming;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.SoftwareDevelopment;
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
public class SportsBettingSoftwareDevelopmentTest extends BaseTest2{
    private final Pages page = Pages.BETTING;
    private final Country country = Country.BY;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
    }

    @TmsLink("5309497")
    @Test(description = "Отображение хедера", priority = 10)
    public void displayingIntro(){
        Intro intro = new Intro(new Widgets[]{Widgets.CLUTCH, Widgets.PECB_MS_ISO_9001, Widgets.PECB_MS_ISO_27001});
        intro.displayingElements(country);
    }

    @TmsLink("5309498")
    @Test(description = "Отображение блока 'Build your iGaming Platform from scratch or boost an already existing solution with an in-house team of experts.'", priority = 20)
    public void displayingSoftDev(){
        FeaturesIndex index = new FeaturesIndex(FeaturesIndexBlockData.Left.IGAMING_BETTING.getData(), FeaturesIndexBlockData.Right.IGAMING_BETTING.getData());

        index.checkImg();
        index.checkTitle();
        index.checkBtn();
        index.checkArticles();
    }

    @TmsLink("5309499")
    @Test(description = "Отображение и функциональность модального окна формы 'Request consultation'", priority = 30)
    public void displayingRequestConsultationPopUp(){
        RequestFormCheck requestFormCheck = new RequestFormCheck("Request consultation");
        requestFormCheck.checkLinks();
        requestFormCheck.checkForm();
        requestFormCheck.checkReCAPTCHA();
    }

    @TmsLink("5309500")
    @Test(description = "Отображение блока 'Our Sports Betting Services'", priority = 40)
    public void displayingOurSportsBettingServices(){
        WhatWeDoGridCheck check = new WhatWeDoGridCheck();
        String title = "Our Sports Betting Services";
        String subtitle = "Our experts with their years of software expertise in the gambling industry will get you over the finish line "+
                "with custom sports betting software solutions, providing industry specific programming, up-to-date functionalities,"+
                " and streamlined, end-to-end software development.";
        List<String> buttonsTitles = Arrays.asList("Sports Betting Software Solutions",
                "Online Betting Software",
                "Pari-Mutuel Betting Software Services",
                "UI/UX Design",
                "Additional Features and Integrations",
                "Maintenance and Technical support");
        List<String> articlesTitles = Arrays.asList("White label and turnkey with customization",
                "Features that deliver the best online gaming experience",
                "All bets of a particular type are together in one pool",
                "Unique design and user friendly interface",
                "Real time support and assistance for players",
                "Avoid your business IT systems to break down");
        List<String> articles = Arrays.asList(
                "We experts design and develop custom white label sports and race betting software with multi-channel capabilities across desktops, web, mobile and program support for all bet types, including parlays, moneyline, spread, total (over / under), head-to-head, and in-play. Our developers provide sportsbook software integration that includes real-time bet tickers with integrations to 3rd party live sports and racing video feeds, and secure integrations with 3rd party payment entities to accept credit, debit, gift, and loyalty cards, and ACH transactions.",
                "We create fully interactive and personalized user portals with payment gateway integration with custom wallet development. We also program back office management systems with features for player/agent management, risk management, and more.",
                "Our developers can create custom pari-mutuel betting software and odds calculators, as well as original data aggregation applications for accurate historic data, with real-time tracking of statistics and odds.",
                "Our design team is focused on creating exclusive layouts that will make your gambling project stand out among the myriad of banal gambling resources, developed on the average templates.",
                "Software solutions simplify communication between the players and you. Help them in real-time to solve emerging issues and avoid issues by creating detailed how-to guides. Push-notifications is the best way to inform players about upcoming events and special offers.",
                "We perform regular checks on the supported system to ensure that it continues to function optimally. As updates are released, we advise clients when patching is required and undertake the work required to update the supported systems.");
        check.checkTitleAndSubtitle(title, subtitle);
        check.checkArticlesGrid(buttonsTitles, articlesTitles, articles);
    }

    @TmsLink("5309501")
    @Test(description = "Отображение блока 'Our engineers", priority = 50)
    public void displayingCVBlock(){
        CvBlock cvBlock = new CvBlock();
        cvBlock.displayingElementsAndFunction();
    }

    @TmsLink("5309502")
    @Test(description = "Отображение блока 'More iGaming software development services'", priority = 60)
    public void displayingSoftDevServices(){
        String linkToIgamingMain = "https://stage.andersenlab.com/industries/gambling";
        String linkToIgamingPlatform = "https://stage.andersenlab.com/industries/gambling/igaming";
        SoftwareDevelopment softDev = new SoftwareDevelopment();
        Assert.assertTrue(softDev.getTitle().isDisplayed());
        Assert.assertEquals(softDev.getLinksSeeMore().first().getCssValue("color"), CSSProperties.Color.BLACK_LINK.getCode());
        Assert.assertEquals(softDev.getLinksSeeMore().first().hover().getCssValue("color"), CSSProperties.Color.YELLOW.getCode());
        //Кликнуть на кнопку-ссылку "See more" в карточке "Sports Betting"
        Assert.assertEquals(softDev.getLinksSeeMore().first().getAttribute("href"), linkToIgamingPlatform);
        //Кликнуть на кнопку-ссылку "Return to iGaming page"
        Assert.assertEquals(softDev.getLinksSeeMore().last().getAttribute("href"), linkToIgamingMain);
    }

    @TmsLink("5309503")
    @Test(description = "Отображение блока 'Our projects'", priority = 70)
    public void displayingProjectExamples(){
        String title = OurProjectsBlockData.Igaming.BETTING.getData().get(0);
        String subtitle = OurProjectsBlockData.Igaming.BETTING.getData().get(1);
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

    @TmsLink("5309504")
    @Test(description = "Отображение кейса 'Rush Casino'", priority = 80)
    public void displayingRushCasino(){
        int caseIndex = 0;
        List<String> caseSectionsTitles = Arrays.asList(SectionTitles.CONCEPT.getText(), SectionTitles.ABOUT.getText(),
                SectionTitles.FUNCTIONALITY.getText(), SectionTitles.SOLUTION.getText(),
                SectionTitles.RESULTS.getText(), SectionTitles.CONTACT_US.getText());
        CaseCheck caseCheck = new CaseCheck();
        caseCheck.titlesCheck(caseIndex, caseSectionsTitles);
    }

    @TmsLink("5309505")
    @Test(description = "Отображение кейса 'Social Casino'", priority = 90)
    public void displayingSocialCasino(){
        int caseIndex = 1;
        List<String> caseSectionsTitles = Arrays.asList(SectionTitles.CONCEPT.getText(), SectionTitles.ABOUT.getText(),
                SectionTitles.FUNCTIONALITY.getText(), SectionTitles.SOLUTION.getText(),
                SectionTitles.RESULTS.getText(), SectionTitles.CONTACT_US.getText());
        CaseCheck caseCheck = new CaseCheck();
        caseCheck.titlesCheck(caseIndex, caseSectionsTitles);
    }

    @TmsLink("5309506")
    @Test(description = "Отображение кейса 'MB'", priority = 100)
    public void displayingMB(){
        int caseIndex = 2;
        List<String> caseSectionsTitles = Arrays.asList(SectionTitles.CONCEPT.getText(), SectionTitles.ABOUT.getText(),
                SectionTitles.FUNCTIONALITY.getText(), SectionTitles.SOLUTION.getText(),
                SectionTitles.RESULTS.getText(), SectionTitles.CONTACT_US.getText());
        CaseCheck caseCheck = new CaseCheck();
        caseCheck.titlesCheck(caseIndex, caseSectionsTitles);
    }

    @TmsLink("5387526")
    @Test(description = "Отображение кейса 'BetLakes'", priority = 110)
    public void displayingBetLakes(){
        int caseIndex = 3;
        List<String> caseSectionsTitles = Arrays.asList(SectionTitles.CONCEPT.getText(), SectionTitles.ABOUT.getText(),
                SectionTitles.FUNCTIONALITY.getText(), SectionTitles.SOLUTION.getText(),
                SectionTitles.RESULTS.getText(), SectionTitles.CONTACT_US.getText());
        CaseCheck caseCheck = new CaseCheck();
        caseCheck.titlesCheck(caseIndex, caseSectionsTitles);
    }

    @TmsLink("5366538")
    @Test(description = "Отображение и функциональность блока 'Testimonials'", priority = 130)
    public void displayingFunctionCustomerReviews(){
        CustomerReviews reviews = new CustomerReviews(new CustomerReviewsDataIGaming());
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
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getOurResume());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getProjects());
    }
}

package com.andersenlab.autotests.site.services.mobiledevelopment;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.form.popup.requestform.RequestForm;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.businessdomains.BusinessDomains;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.consultation.Consultation;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviews;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Widgets;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.page.Page;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.projectmap.ProjectMap;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.softdevreach.SoftDevReach;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.PageTextsMobileDevelopment;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.CustomerReviewsDataMobileDevelopment;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.developmentservices.DevelopmentServices;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.featuresindex.FeaturesIndex;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.cv.CvBlock;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.projectexamples.ProjectExamples;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.rocketspeedlaunch.RocketSpeedLaunch;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.techexpertise.TechExpertise;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.technologycarousel.TechnologyCarousel;
import com.andersenlab.autotests.site.utility.Warp;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Listeners(SelenideListener.class)
public class MobileDevelopmentPageTest extends BaseTest2 {

    private Pages page = Pages.MOBILE_DEV;
    private Country country = Country.UA;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
    }

    @TmsLink("5245605")
    @Test(description = "Отображение заголовка", priority = 10)
    public void displayingHeader() {
        Intro b = new Intro(new Widgets[]{});
        b.displayingElements(country);
    }

    @TmsLink("5245606")
    @Test(description = "Отображение и функциональность блока 'Get your own bespoke mobile application with our in-house team of experts'", priority = 20)
    public void displayingFeaturesIndex() {
        FeaturesIndex b = new FeaturesIndex();
        b.displayingElementsAndFunction();
    }

    @TmsLink("5245607")
    @Test(description = "Отображение и функциональность блока 'Andersen Mobile Tech Expertise'", priority = 30)
    public void displayingMobileTechExpertise() {
        TechExpertise b = new TechExpertise("//h2[contains(text(), 'Andersen Mobile Tech Expertise')]//..//..//..");
        b.displayingElementsAndFunction();
    }

    @TmsLink("5245608")
    @Test(description = "Отображение и функциональность блока 'Mobile App Development Services'", priority = 40)
    public void displayingMobileAppDevelopment() {
        DevelopmentServices b = new DevelopmentServices();
        b.displayingElementsAndFunction();
    }

    @TmsLink("5245609")
    @Test(description = "Отображение и функциональность блока 'Schedule a free consultation...'", priority = 50)
    public void displayingBeItACustomer() {
        SoftDevReach b = new SoftDevReach(new RequestForm("Get a free quote"));
        b.displayingElements();
    }

    @TmsLink("5245673")
    @Test(description = "Отображение и функциональность блока 'Our engineers'", priority = 60)
    public void displayingOurEngineers() {
        CvBlock b = new CvBlock();
        b.displayingElementsAndFunction();
    }

    @TmsLink("5245611")
    @Test(description = "Отображение и функциональность блока 'Not just buzzwords here'", priority = 70)
    public void displayingTechnologyCarousel() {
        TechnologyCarousel b = new TechnologyCarousel();
        b.displayingElementsAndFunction(true);
    }

    @TmsLink("5245612")
    @Test(description = "Отображение и функциональность блока 'Rocket-speed Launch with Top-notch Mobile App Developers'", priority = 80)
    public void displayingRocketSpeedLaunch() {
        RocketSpeedLaunch b = new RocketSpeedLaunch();
        b.displayingElementsAndFunction();
    }

    @TmsLink("5245613")
    @Test(description = "Отображение и функциональность блока 'Project examples'", priority = 90)
    public void displayingProjectExamples() {
        ProjectExamples b = new ProjectExamples("//h2[contains(text(), 'Project examples')]//..//..");
        b.displayingElementsAndFunction();
    }

    @TmsLink("5245614")
    @Test(description = "Отображение и функциональность блока 'Real Time Projects Map'", priority = 100)
    public void displayingProjectMap() {
        ProjectMap b = new ProjectMap();
        b.checkMapWithFilters();
    }

    @TmsLink("5245615")
    @Test(description = "Отображение и функциональность блока 'Customer reviews'", priority = 120)
    public void displayingCustomerReviews() {
        CustomerReviews b = new CustomerReviews(new CustomerReviewsDataMobileDevelopment());
        b.displayingElements();
    }

    @TmsLink("5245617")
    @Test(description = "Отображение и функциональность блока 'Comprehensive expertise after 818 projects delivered'", priority = 140)
    public void displayingComprehensiveExpertise() {
        BusinessDomains b = new BusinessDomains();
        b.displayingElements();
    }

    @TmsLink("5245618")
    @Test(description = "Отображение и функциональность блока 'Contact us for a free consultation on Mobile Development'", priority = 150)
    public void displayingFreeConsultation() {
        Consultation b = new Consultation();
        b.displayingElements();
    }

    @TmsLink("5245619")
    @Test(description = "Title и Description страницы", priority = 160)
    public void displayingMobileDevelopmentPage() {
        Page b = new Page(new PageTextsMobileDevelopment());
        b.displayingTitle();
    }

    @TmsLink("5678817")
    @Test(description = "[EN] Отображение и функциональность контактной формы в блоке с буллетами, где текст кнопки 'Request specialist'", priority = 170, groups = "Checking the main form for leads")
    public void checkMainFormForLeads(){
        MainFormForLeads mainFormForLeads = new MainFormForLeads();
        mainFormForLeads.scrollToButtonAndCheckTitle(mainFormForLeads.getButtonInMainModule(), "Request specialists");
        mainFormForLeads.checkEmailField();
        mainFormForLeads.checkPhoneField();
        mainFormForLeads.checkNda();
        mainFormForLeads.sendFormAndCheckSuccessfulModalWindow();
    }

    @TmsLink("5803694")
    @Test(description = "Проверить наличие блоков", priority = 180, groups = "Checking the blocks")
    public void checkBlocks(){
        CheckingThePresenceOfBlocks checkingThePresenceOfBlocks = new CheckingThePresenceOfBlocks();
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIntro());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCalculator());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCallToActionWithPhoto());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCustomSolutions());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFeature());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIndustryRecognition());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getProjects());
    }
}
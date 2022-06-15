package com.andersenlab.autotests.site.services.businessanalysts;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.form.popup.requestform.RequestForm;
import com.andersenlab.autotests.site.page.services.businessanalysts.PageTextsBA;
import com.andersenlab.autotests.site.page.services.businessanalysts.blocks.CustomerReviewsDataBA;
import com.andersenlab.autotests.site.page.services.businessanalysts.blocks.ThePDP;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.companyofexpert.CompanyOfExperts;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.businessdomains.BusinessDomains;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.consultation.Consultation;
import com.andersenlab.autotests.site.page.services.businessanalysts.blocks.CostCalc;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviews;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex.FeaturesIndex;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Widgets;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.page.Page;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.projectmap.ProjectMap;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.softdevreach.SoftDevReach;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.cv.CvBlock;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.projectexamples.ProjectExamples;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.techexpertise.TechExpertise;
import com.andersenlab.autotests.site.utility.Warp;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Listeners(SelenideListener.class)
public class BaPageTest extends BaseTest2 {

    private Pages page = Pages.BA;
    private Country country = Country.UA;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
    }

    @TmsLink("5307821")
    @Test(description = "Отображение хедера", priority = 10)
    public void displayingIntro() {
        Intro b = new Intro(new Widgets[]{});
        b.displayingElements(country);
    }

    @TmsLink("5307822")
    @Test(description = "Отображение и функционал блока с буллитами 'Reduce risks and project costs adding even more value...'", priority = 20)
    public void displayingFeaturesIndex() {
        FeaturesIndex b = new FeaturesIndex();
        b.displayingElementsAndFunction("Request consultation");
    }

    @TmsLink("5307823")
    @Test(description = "Отображение блока 'Company of experts'", priority = 30)
    public void displayingCompanyOfExperts() {
        CompanyOfExperts b = new CompanyOfExperts();
        b.displayingElements(10);
    }

    @TmsLink("5307824")
    @Test(description = "Отображение и функциональность блока 'There are 3 groups of typical problems a Business Analyst solves'", priority = 40)
    public void displayingTreeProblems() {
        TechExpertise b = new TechExpertise("(//section[contains(@class, 'what-we-do')])[1]");
        b.displayingElementsAndFunction();
    }

    @TmsLink("5307825")
    @Test(description = "Отображение и функционал блока 'Found your problem?..'", priority = 50)
    public void displayingSoftDevReach() {
        SoftDevReach b = new SoftDevReach(new RequestForm("Contact us"));
        b.displayingElements();
    }

    @TmsLink("5307826")
    @Test(description = "Отображение и функциональность блока 'Our Services'", priority = 60)
    public void displayingOurServices() {
        TechExpertise b = new TechExpertise("(//section[contains(@class, 'what-we-do')])[2]");
        b.displayingElementsAndFunction();
    }

    @TmsLink("5307827")
    @Test(description = "Отображение и функциональность блока 'Cost Calculator'", priority = 70)
    public void displayingFunctionCostCalculator() {
        CostCalc b = new CostCalc();
        b.indicateTheProblem();
        b.selectSpecialist();
        b.domain();
        b.durationOfProject();
        b.popup();
    }

    @TmsLink("5307828")
    @Test(description = "Отображение и функциональность блока 'Our projects'", priority = 80)
    public void displayingCaseStudies() {
        ProjectExamples b = new ProjectExamples("//section[@id='concepts-list']");
        b.noShowMore();
        b.displayingElementsAndFunction();
    }

    @TmsLink("5307829")
    @Test(description = "Отображение и функциональность блока 'Value BA adds to a project'", priority = 90)
    public void displayingValueBA() {
        Assert.fail("MOT IMPLEMENTED");
    }

    @TmsLink("5307830")
    @Test(description = "Отображение и функциональность блока 'Our engineers'", priority = 100)
    public void displayingOurEngineers() {
        CvBlock b = new CvBlock();
        b.displayingElementsAndFunction();
    }

    @TmsLink("")
    @Test(description = "Отображение и функциональность блока 'Real Time Projects Map'", priority = 105)
    public void displayingProjectMap() {
        ProjectMap b = new ProjectMap();
        b.checkMapWithFilters();
    }

    @TmsLink("5307831")
    @Test(description = "Отображение и функциональность блока 'XXX projects successfully completed'", priority = 110)
    public void displayingFunctionComprehensiveExpertise() {
        BusinessDomains b = new BusinessDomains();
        b.displayingElements();
    }

    @TmsLink("5307832")
    @Test(description = "Отображение и функциональность блока 'Something to think about'", priority = 120)
    public void displayingProjectExamples() {
        ProjectExamples b = new ProjectExamples("//section[contains(@class, 'article-card')]");
        b.noShowMore();
        b.displayingElementsAndFunction();
    }

    @TmsLink("5307833")
    @Test(description = "Статья 'The project discovery phase: strengths and opportunities'", priority = 130)
    public void displayingArt() {
         new ThePDP().displayingElements();
    }

    @TmsLink("5307834")
    @Test(description = "Отображение блока и функционал блока 'Customer reviews'", priority = 140)
    public void displayingFunctionCustomerReviews() {
        CustomerReviews b = new CustomerReviews(new CustomerReviewsDataBA());
        b.displayingElements();
    }

    @TmsLink("5307836")
    @Test(description = "Отображение и функциональность блока 'Schedule Your Free Consultation'", priority = 150)
    public void displayingScheduleYourFree() {
        Consultation b = new Consultation();
        b.displayingElements();
    }

    @TmsLink("")
    @Test(description = "Title и Description страницы", priority = 160)
    public void displayingTitle() {
        Page b = new Page(new PageTextsBA());
        b.displayingTitle();
    }

    @TmsLink("5678818")
    @Test(description = "[EN] Отображение и функциональность контактной формы в блоке с буллетами, где текст кнопки 'Request consultation'", priority = 170, groups = "Checking the main form for leads")
    public void checkMainFormForLeads(){
        MainFormForLeads mainFormForLeads = new MainFormForLeads();
        mainFormForLeads.scrollToButtonAndCheckTitle(mainFormForLeads.getButtonInMainModule(), "Request consultation");
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
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCompanyOfExperts());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCustomSolutions());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFeature());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGreetingCard());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getProjects());
    }
}

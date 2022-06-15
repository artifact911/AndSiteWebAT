package com.andersenlab.autotests.site.services.qa;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.form.popup.requestform.RequestForm;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.consultation.Consultation;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviews;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex.FeaturesIndex;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Widgets;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.page.Page;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.projectmap.ProjectMap;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.cv.CvBlock;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.techexpertise.TechExpertise;
import com.andersenlab.autotests.site.page.services.qa.PageTextsQa;
import com.andersenlab.autotests.site.page.services.qa.blocks.CustomerReviewsDataQA;
import com.andersenlab.autotests.site.page.services.qa.blocks.Interlinking;
import com.andersenlab.autotests.site.page.services.qa.blocks.SoftDevReachPlusLink;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.projectexamples.ProjectExamples;
import com.andersenlab.autotests.site.page.services.salesforce.blocks.improve.Improve;
import com.andersenlab.autotests.site.utility.Warp;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Listeners(SelenideListener.class)
public class QaPageTest extends BaseTest2 {

    private Pages page = Pages.QA;
    private Country country = Country.UA;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
    }

    @TmsLink("5292369")
    @Test(description = "Отображение заголовка", priority = 10)
    public void displayingHeader() {
        Intro b = new Intro(new Widgets[]{Widgets.CLUTCH_CLICKABLE, Widgets.ISTQB});
        b.displayingElements(country);
    }

    @TmsLink("5292370")
    @Test(description = "Отображение и функциональность блока 'Upgrade the quality of your software...'", priority = 20)
    public void displayingFeaturesIndex() {
        FeaturesIndex b = new FeaturesIndex();
        b.displayingElementsAndFunction("Request consultation");
    }

    @TmsLink("5292371")
    @Test(description = "Отображение и функциональность блока 'Find your problem?...'", priority = 30)
    public void displayingTreeProblems() {
        TechExpertise b = new TechExpertise("//section[contains(@class, 'development-services')]");
        b.displayingElementsAndFunction();
    }

    @TmsLink("5292372")
    @Test(description = "Отображение и функциональность блока 'Find your problem?...'", priority = 40)
    public void displayingMobileTechExpertise() {
        SoftDevReachPlusLink b = new SoftDevReachPlusLink(new RequestForm("Contact us"));
        b.displayingElements();
    }

    @TmsLink("5292373")
    @Test(description = "Отображение и функциональность блока 'Case Studies'", priority = 50)
    public void displayingCaseStudies() {
        Assert.fail("NOT DESCRIBED");
        //https://vmmreg32.testrail.net/index.php?/cases/view/5292373
        ProjectExamples b = new ProjectExamples("//section[@id='concepts-list']");
        b.displayingElementsAndFunction();
    }

    @TmsLink("5292376")
    @Test(description = "Отображение 'Our Services'", priority = 60)
    public void displayingWhatWeDo() {
        Improve b = new Improve("//section[contains(@class, 'what-we-do')]", 9);
        b.displayingElements();
    }

    @TmsLink("5292377")
    @Test(description = "Отображение и функциональность блока 'Real Time Projects Map'", priority = 70)
    public void displayingProjectMap() {
        ProjectMap b = new ProjectMap();
        b.checkMapWithFilters();
    }

    @TmsLink("5292378")
    @Test(description = "Отображение и функциональность блока 'The Andersen QA...'", priority = 80)
    public void displayingTheAndersenQA() {
        Interlinking b = new Interlinking("//section[contains(@class, 'interlinking')]","https://stage.andersenlab.com/services/quality-assurance-services/andersen-qa-community");
        b.displayingElements();
    }

    @TmsLink("5292379")
    @Test(description = "Отображение и функциональность блока 'CV Examples'", priority = 90)
    public void displayingCvExamples() {
        CvBlock b = new CvBlock();
        b.displayingElementsAndFunction();
    }

    @TmsLink("5292383")
    @Test(description = "Отображение и функциональность блока 'Something to think about'", priority = 90)
    public void displayingProjectExamples() {
        ProjectExamples b = new ProjectExamples("//section[contains(@class, 'article-card')]");
        b.displayingElementsAndFunction();
    }

    @TmsLink("5292385")
    @Test(description = "Отображение и функциональность блока 'Customer reviews'", priority = 100)
    public void displayingCustomerReviews() {
        CustomerReviews b = new CustomerReviews(new CustomerReviewsDataQA());
        b.displayingElements();
    }

    @TmsLink("5292386")
    @Test(description = "Отображение и функциональность блока 'Schedule Your Free Consultation'", priority = 110)
    public void displayingFreeConsultation() {
        Consultation b = new Consultation();
        b.displayingElements();
    }

    @TmsLink("")//почему для других стр есть такой тест а для этой нет?
    @Test(description = "Title и Description страницы", priority = 120)
    public void displayingMobileDevelopmentPage() {
        Page b = new Page(new PageTextsQa());
        b.displayingTitle();
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
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getAdditionalInfo());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCalculator());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFeature());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGreetingCard());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIndustryRecognition());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getOurResume());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getPageInterlinking());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getProjects());
    }
}

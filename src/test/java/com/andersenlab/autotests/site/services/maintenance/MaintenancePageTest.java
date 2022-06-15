package com.andersenlab.autotests.site.services.maintenance;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.companyofexpert.CompanyOfExperts;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.businessdomains.BusinessDomains;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.consultation.Consultation;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviews;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex.FeaturesIndex;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Widgets;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.page.Page;
import com.andersenlab.autotests.site.page.services.maintenance.PageTextsMaintenance;
import com.andersenlab.autotests.site.page.services.maintenance.blocks.CostCalc;
import com.andersenlab.autotests.site.page.services.maintenance.blocks.CustomerReviewsDataMaintenance;
import com.andersenlab.autotests.site.page.services.maintenance.blocks.FinancialServices;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.cv.CvBlock;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.projectexamples.ProjectExamples;
import com.andersenlab.autotests.site.page.services.salesforce.blocks.improve.Improve;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Listeners(SelenideListener.class)
public class MaintenancePageTest extends BaseTest2 {

    private Pages page = Pages.MAINTENANCE;
    private Country country = Country.NOT_SPECIFIED;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, country);
    }

    @TmsLink("5253027")
    @Test(description = "Отображение заголовка", priority = 10)
    public void displayingHeader() {
        Intro b = new Intro(new Widgets[]{});
        b.displayingElements(country);
    }

    @TmsLink("5253028")
    @Test(description = "Отображение и функциональность блока 'Achieve smooth operation of your company..'", priority = 20)
    public void displayingFeaturesIndex() {
        FeaturesIndex b = new FeaturesIndex();
        b.displayingElementsAndFunction("Request consultation");
    }

    @TmsLink("5253030")
    @Test(description = "Отображение блока 'Company of experts'", priority = 30)
    public void displayingCompanyOfExperts() {
        CompanyOfExperts b = new CompanyOfExperts();
        b.displayingElements(6);
    }

    @TmsLink("5253031")
    @Test(description = "Отображение и функциональность блока 'Pricing of software maintenance & support services'", priority = 40)
    public void displayingWhatYouGet() {
        FinancialServices b = new FinancialServices();
        b.displayingElementsAndFunction();
    }

    @TmsLink("5253032")
    @Test(description = "Отображение 'What we do'", priority = 60)
    public void displayingWhatWeDo() {
        Improve b = new Improve("//section[contains(@class, 'what-we-do')]", 4);
        b.displayingElements();
    }

    @TmsLink("5253033")
    @Test(description = "Отображение и функциональность блока 'Team of experts'", priority = 50)
    public void displayingCvExamples() {
        CvBlock b = new CvBlock();
        b.displayingElementsAndFunction();
    }

    @TmsLink("5253034")
    @Test(description = "Отображение и функциональность блока 'Pricing of software maintenance & support services'", priority = 40)
    public void displayingFunctionCostCalculator() {
        CostCalc b = new CostCalc();
        b.volume();
        b.level();
        b.schedule();
        b.popup();
    }

    @TmsLink("5253035")
    @Test(description = "Отображение и функциональность блока 'Take a Look at Our Maintenance & Support Cases'", priority = 50)
    public void displayingCaseStudies() {
        ProjectExamples b = new ProjectExamples("//section[@id='concepts-list']");
        b.displayingElementsAndFunction();
    }

    @TmsLink("5253042")
    @Test(description = "Отображение и функциональность блока 'Comprehensive expertise after 818 projects delivered'", priority = 140)
    public void displayingComprehensiveExpertise() {
        BusinessDomains b = new BusinessDomains();
        b.displayingElements();
    }

    @TmsLink("5253043")
    @Test(description = "Отображение и функциональность блока 'Customer reviews'", priority = 100)
    public void displayingCustomerReviews() {
        CustomerReviews b = new CustomerReviews(new CustomerReviewsDataMaintenance());
        b.displayingElements();
    }

    @TmsLink("5253044")
    @Test(description = "Отображение и функциональность блока 'Schedule Your Free Consultation'", priority = 110)
    public void displayingFreeConsultation() {
        Consultation b = new Consultation();
        b.displayingElements();
    }

    @TmsLink("")//почему для других стр есть такой тест а для этой нет? TODO добавить номер, когда появится
    @Test(description = "Title и Description страницы", priority = 120)
    public void displayingPage() {
        Page b = new Page(new PageTextsMaintenance());
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
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getArchitect());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCalculator());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCompanyOfExperts());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCustomSolutions());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFeature());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getPageInterlinking());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getProjects());
    }
}

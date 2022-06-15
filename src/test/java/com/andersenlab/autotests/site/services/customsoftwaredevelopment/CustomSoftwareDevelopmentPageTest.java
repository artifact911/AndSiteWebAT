package com.andersenlab.autotests.site.services.customsoftwaredevelopment;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.popup.contactus.ContactUsPopUp;
import com.andersenlab.autotests.site.page.services.customsoftware.PageTextsCustomSoftware;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.companyofexpert.CompanyOfExperts;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.businessdomains.BusinessDomains;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.consultation.Consultation;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.CostCalc;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviews;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsDataCustomSoftware;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customsoftwaredev.CustomSoftwareDev;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex.FeaturesIndex;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Widgets;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.page.Page;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.projectmap.ProjectMap;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.softdevreach.SoftDevReach;
import com.andersenlab.autotests.site.page.services.salesforce.blocks.improve.Improve;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Listeners(SelenideListener.class)
public class CustomSoftwareDevelopmentPageTest extends BaseTest2 {

    private Pages page = Pages.CUSTOM_SOFTWARE;
    private Country country = Country.UA;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
    }


    @TmsLink("5245580")
    @Test(description = "Отображение хедера", priority = 10)
    public void displayingIntro() {
        Intro b = new Intro(new Widgets[]{Widgets.CLUTCH});
        b.displayingElements(country);
    }

    @TmsLink("5245581")
    @Test(description = "Отображение и функционал блока с буллитами 'Turn your idea into life...'", priority = 20)
    public void displayingFeaturesIndex() {
        FeaturesIndex b = new FeaturesIndex();
        b.displayingElementsAndFunction("Request specialists");
    }

    @TmsLink("5245582")
    @Test(description = "Отображение блока 'Company of experts'", priority = 30)
    public void displayingCompanyOfExperts() {
        CompanyOfExperts b = new CompanyOfExperts();
        b.displayingElements(16);
    }

    @TmsLink("5245583")
    @Test(description = "Отображение блока 'Custom software development'", priority = 40)
    public void displayingCustomSoftwareDev() {
        CustomSoftwareDev b = new CustomSoftwareDev();
        b.displayingElements();
    }

    @TmsLink("5245584")
    @Test(description = "Отображение и функционал блока 'Functional, secure and interactive...'", priority = 50)
    public void displayingSoftDevReach() {
        SoftDevReach b = new SoftDevReach(new ContactUsPopUp());
        b.displayingElements();
    }

    @TmsLink("5245585")
    @Test(description = "Отображение 'What we do:'", priority = 60)
    public void displayingWhatWeDo() {
        Improve b = new Improve("//section[contains(@class, 'container-module--container--K6XQB')]", 6);
        b.displayingElements();
    }

    @TmsLink("5245586")
    @Test(description = "Отображение и функциональность блока 'Cost Calculator'", priority = 70)
    public void displayingFunctionCostCalculator() {
        CostCalc b = new CostCalc();
        b.setDevDir();
        b.domain();
        b.setProCons();
        b.setTimeBar();
        b.popup();
    }

    @TmsLink("5245587")
    @Test(description = "Отображение и функциональность блока 'Real Time Projects Map'", priority = 80)
    public void displayingFunctionProjectMap() {
        ProjectMap b = new ProjectMap();
        b.checkMapWithFilters();
    }

    @TmsLink("5245588")
    @Test(description = "Отображение и функциональность блока 'Comprehensive expertise after 818 projects delivered'", priority = 90)
    public void displayingFunctionComprehensiveExpertise() {
        BusinessDomains b = new BusinessDomains();
        b.displayingElements();
    }

    @TmsLink("5245589")
    @Test(description = "Отображение блока и функционал блока 'Customer reviews'", priority = 100)
    public void displayingFunctionCustomerReviews() {
        CustomerReviews b = new CustomerReviews(new CustomerReviewsDataCustomSoftware());
        b.displayingElements();
    }

    @TmsLink("5245591")
    @Test(description = "Отображение и функциональность блока 'Schedule Your Free Consultation'", priority = 110)
    public void displayingScheduleYourFree() {
        Consultation b = new Consultation();
        b.displayingElements();
    }

    @TmsLink("5245592")
    @Test(description = "Title и Description страницы", priority = 120)
    public void displayingTitle() {
        Page b = new Page(new PageTextsCustomSoftware());
        b.displayingTitle();
    }

    @TmsLink("5803694")
    @Test(description = "Проверить наличие блоков", priority = 130, groups = "Checking the blocks")
    public void checkBlocks(){
        CheckingThePresenceOfBlocks checkingThePresenceOfBlocks = new CheckingThePresenceOfBlocks();
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIntro());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getArchitect());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCalculator());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCompanyOfExperts());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCustomSolutions());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFeature());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
    }
}

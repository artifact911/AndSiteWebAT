package com.andersenlab.autotests.site.services.salesforce;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.form.popup.requestform.RequestForm;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.businessdomains.BusinessDomains;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.consultation.Consultation;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviews;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex.FeaturesIndex;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Widgets;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.page.Page;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.cv.CvBlock;
import com.andersenlab.autotests.site.page.services.salesforce.PageTextsSalesForce;
import com.andersenlab.autotests.site.page.services.salesforce.blocks.CustomerReviewsDataSalesForce;
import com.andersenlab.autotests.site.page.services.salesforce.blocks.costcalculator.CostCalc;
import com.andersenlab.autotests.site.page.services.salesforce.blocks.improve.Improve;
import com.andersenlab.autotests.site.page.services.salesforce.blocks.projectexamples.ProjectExamples;
import com.andersenlab.autotests.site.page.services.salesforce.blocks.smthtothink.SmthToThink;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.softdevreach.SoftDevReach;
import com.andersenlab.autotests.site.page.services.salesforce.blocks.techexpertise.TechExpertise;
import com.andersenlab.autotests.site.page.services.salesforce.blocks.typicalreqsalesforce.TypicalReqSale;
import com.andersenlab.autotests.site.utility.Warp;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Listeners(SelenideListener.class)
public class SalesForcePageTest extends BaseTest2 {

    private Pages page = Pages.SALES_FORCE;
    private Country country = Country.NOT_SPECIFIED;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, country);
    }


    @TmsLink("5252395")
    @Test(description = "Отображение хедера", priority = 10)
    public void displayingIntro() {
        Intro b = new Intro(new Widgets[]{Widgets.PARTNER});
        b.displayingElements(country);
    }

    @TmsLink("5252396")
    @Test(description = "Отображение и функциональность блока 'Get the most from your CRM with an in-house Salesforce certified partner'", priority = 20)
    public void displayingGetTheMost() {
        FeaturesIndex b = new FeaturesIndex();
        b.displayingElementsAndFunction("Get a quote");
    }

    @TmsLink("5252397")
    @Test(description = "Отображение и функциональность блока 'There are three groups of typical requests related to Salesforce'", priority = 30)
    public void displayingCustomSoftwareDev() {
        TypicalReqSale b = new TypicalReqSale();
        b.displayingElements();
    }

    @TmsLink("5252398")
    @Test(description = "Отображение и функционал блока 'Did you find your issue...'", priority = 40)
    public void displayingSoftDevReach() {
        SoftDevReach b = new SoftDevReach(new RequestForm("Contact us"));
        b.displayingElements();
    }

    @TmsLink("5252399")
    @Test(description = "Отображение блока 'Salesforce Technical Expertise'", priority = 50)
    public void displayingTechExpertise() {
        TechExpertise b = new TechExpertise();
        b.displayingElements();
    }

    @TmsLink("5252400")
    @Test(description = "Отображение блока 'Something to think about'", priority = 55)
    public void displayingSmthToThink() {
        SmthToThink b = new SmthToThink();
        b.displayingElements();
    }

    @TmsLink("5252401")
    @Test(description = "Отображение блока 'Your calculator for Salesforce services'", priority = 60)
    public void displayingCostCalc() {
        Warp.delay(2);
        CostCalc b = new CostCalc();
        b.request();
        b.purpose();
        b.domain();
        b.popup();
    }

    @TmsLink("5252402")
    @Test(description = "Отображение и функциональность блока 'Project examples'", priority = 70)
    public void displayingProjectExamples() {
        ProjectExamples b = new ProjectExamples();
        b.displayingElementsAndFunction();
    }

    @TmsLink("5252403")
    @Test(description = "Отображение и функциональность блока 'CV examples'", priority = 80)
    public void displayingCvExamples() {
        CvBlock b = new CvBlock();
        b.displayingElementsAndFunction();
    }

    @TmsLink("5252404")
    @Test(description = "Отображение и функциональность блока 'Comprehensive expertise after X projects delivered'", priority = 90)
    public void displayingFunctionComprehensiveExpertise() {
        BusinessDomains b = new BusinessDomains();
        b.displayingElements();
    }

    @TmsLink("5252405")
    @Test(description = "Отображение 'Improve your business-to-customer collaboration'", priority = 100)
    public void displayingWhatWeDo() {
        Improve b = new Improve("//section[@id='improve-your-business-to-customer-collaboration']", 6);
        b.displayingElements();
    }

    @TmsLink("5252406")
    @Test(description = "Отображение и функциональность блока 'Customer reviews'", priority = 110)
    public void displayingCustomerReviews() {
        CustomerReviews b = new CustomerReviews(new CustomerReviewsDataSalesForce());
        b.displayingElements();
    }

    @TmsLink("5252407")
    @Test(description = "Отображение и функциональность блока 'Schedule Your Free Consultation '", priority = 120)
    public void displayingScheduleYourFree() {
        Consultation b = new Consultation();
        b.displayingElements();
    }

    @TmsLink("5245592")
    @Test(description = "Title и Description страницы", priority = 130)
    public void displayingTitle() {
        Page b = new Page(new PageTextsSalesForce());
        b.displayingTitle();
    }
}

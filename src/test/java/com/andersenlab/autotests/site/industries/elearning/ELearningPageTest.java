package com.andersenlab.autotests.site.industries.elearning;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.CostCalcData;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.form.popup.requestform.RequestForm;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.FreeConsultationBlock;
import com.andersenlab.autotests.site.page.industries.videoandentertainment.blocks.costcalc.DesktopCostCalc;
import com.andersenlab.autotests.site.page.industries.elearning.CustomerReviewsDataELearning;
import com.andersenlab.autotests.site.page.industries.elearning.PageTextsELearning;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.consultation.Consultation;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviews;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex.FeaturesIndex;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Widgets;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.page.Page;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.softdevreach.SoftDevReach;
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
public class ELearningPageTest extends BaseTest2 {

    private final Pages page = Pages.E_LEARNING;
    private final Country country = Country.BY;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
    }


    @TmsLink("5288198")
    @Test(description = "Отображение хедера", priority = 10)
    public void displayingIntro() {
        Intro block = new Intro(new Widgets[]{});
        block.displayingElements(country);
    }

    @TmsLink("5288203")
    @Test(description = "Отображение и функционал блока с буллитами 'Succeed in eLearning'", priority = 20)
    public void displayingFeaturesIndex() {
        FeaturesIndex block = new FeaturesIndex();
        block.displayingElementsAndFunction("Request consultation");
    }

    @TmsLink("5288233")
    @Test(description = "Отображение блока 'Take full advantage of eLearning Software Development Services'", priority = 30)
    public void displaying() {
        Improve block = new Improve("//h2[contains(text(), 'Take full advantage of eLearning Software Development Services')]//..//..", 3);
        block.displayingElements();
    }

    @TmsLink("5288237")
    @Test(description = "Отображение и функционал блока 'Request a professional consultation'", priority = 50)
    public void displayingSoftDevReach() {
        SoftDevReach block = new SoftDevReach(new RequestForm("Contact us"));
        block.displayingElements();
    }

    @TmsLink("5288315")
    @Test(description = "Отображение 'What we do'", priority = 60)
    public void displayingWhatWeDo() {
        Improve block = new Improve("//h2[contains(text(), 'What we do')]//..//..", 6);
        block.displayingElements();
    }

    @TmsLink("5288253")
    @Test(description = "Отображение и функциональность блока 'Get a quote for your eLearning solution'", priority = 70)
    public void displayingFunctionCostCalculator() {
        DesktopCostCalc block = new DesktopCostCalc(CostCalcData.Page.ELEARNING.getData(), country);
        block.checkDesktopCalc();
    }


    @TmsLink("5383082")
    @Test(description = "Отображение и функциональность блока 'Whether you are in the early stage...'", priority = 90)
    public void displayingFreeConsultation() {
    String title = "Whether you are in the early stage or have an ongoing project, our professional eLearning "+
        "architects are always ready to consult and guide you within the development process. "+
        "Schedule a free online consultation with our specialists.";
    String formTitle = "Request consultation";
    String popupTitle = "Solution Architecture";
    FreeConsultationBlock freeConsultationBlock = new FreeConsultationBlock();
    freeConsultationBlock.checkBlock(title);
    freeConsultationBlock.checkPopupForm(formTitle);
    freeConsultationBlock.checkPopupInfo(popupTitle);
    }

    @TmsLink("5294161")
    @Test(description = "Отображение и функциональность блока 'Team of experts'", priority = 50)
    public void displayingCvExamples() {
        CvBlock b = new CvBlock();
        b.displayingElementsAndFunction();
    }

    @TmsLink("5366459")
    @Test(description = "Отображение блока и функционал блока 'Testimonials'", priority = 100)
    public void displayingFunctionCustomerReviews() {
        CustomerReviews b = new CustomerReviews(new CustomerReviewsDataELearning());
        b.displayingElements();
    }

    @TmsLink("5288239")
    @Test(description = "Отображение и функциональность блока 'Contact us for a free consultation'", priority = 110)
    public void displayingScheduleYourFree() {
        Consultation b = new Consultation();
        b.displayingElements();
    }

    @TmsLink("5288318")
    @Test(description = "Title и Description страницы", priority = 120)
    public void displayingTitle() {
        Page b = new Page(new PageTextsELearning());
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
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCallToAction());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFeature());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIndustryRecognition());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getProjects());
    }
}


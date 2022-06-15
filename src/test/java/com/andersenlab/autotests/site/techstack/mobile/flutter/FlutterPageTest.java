package com.andersenlab.autotests.site.techstack.mobile.flutter;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.FreeConsultationBlock;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.businessdomains.BusinessDomains;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.consultation.Consultation;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviews;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex.FeaturesIndex;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Widgets;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.page.Page;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.projectmap.ProjectMap;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.cv.CvBlock;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.technologycarousel.TechnologyCarousel;
import com.andersenlab.autotests.site.page.techstack.mobile.flutter.PageTextsFlutter;
import com.andersenlab.autotests.site.page.techstack.mobile.flutter.blocks.CostCalc;
import com.andersenlab.autotests.site.page.techstack.mobile.flutter.blocks.CustomerReviewsDataFlutter;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Listeners(SelenideListener.class)
public class FlutterPageTest extends BaseTest2 {
    private final Pages page = Pages.FLUTTER;
    private final Country country = Country.BY;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
    } //прокси временно отключен, т.к. через прокси кидает 403


    @TmsLink("5292424")
    @Test(description = "Отображение и функциональность блока 'Work With Top Flutter Developers'", priority = 10)
    public void displayingIntro() {
        Intro b = new Intro(new Widgets[]{Widgets.CLUTCH, Widgets.CLUTCH_STARED});
        b.displayingElements(country);
    }

    @TmsLink("5292425")
    @Test(description = "Отображение и функционал блока с буллитами 'Get your Flutter specialists...'", priority = 20)
    public void displayingFeaturesIndex() {
        FeaturesIndex b = new FeaturesIndex();
        b.displayingElementsAndFunction("Request specialists");
    }

    @TmsLink("5450066")
    @Test(description = "Отображение и функциональность блока 'Versatile technologies we work with'", priority = 30)
    public void displayingTechnologyCarousel() {
        TechnologyCarousel b = new TechnologyCarousel();
        b.displayingElementsAndFunction(true);
    }

    @TmsLink("5385359")
    @Test(description = "[D][T][M] Отображение и функциональность блока 'Whether you are in the early stage...'", priority = 35)
    public void checkCallToAction(){
        String title = "Whether you are in the early stage or have an ongoing project, our professional architects are always ready to consult and guide you within the development process. Schedule a free online consultation with our specialists.";
        String formTitle = "Request consultation";
        String popupTitle = "Solution Architecture";
        FreeConsultationBlock freeConsultationBlock = new FreeConsultationBlock();
        freeConsultationBlock.checkBlock(title);
        freeConsultationBlock.checkPopupForm(formTitle);
        freeConsultationBlock.checkPopupInfo(popupTitle);
    }

    @TmsLink("5292453")
    @Test(description = "Отображение и функциональность блока 'Know the real price of the project'", priority = 40)
    public void displayingFunctionCostCalculator() {
        //fixme Кнопка закрытия попапа блокируется айфреймом чата
        //fixme временно закоменчен popup.close() в behaviourBlock
        CostCalc b = new CostCalc();
        b.setTop();
        b.setOther();
        b.domain();
        b.setAddServ();
        b.popup();
    }

    @TmsLink("5292426")
    @Test(description = "Отображение и функциональность блока 'Our engineers'", priority = 50, enabled = true)//функционал CV (пока) отсутствует
    public void displayingCvExamples() {
        CvBlock b = new CvBlock();
        b.displayingElementsAndFunction();
    }

    @TmsLink("5394206")
    @Test(description = "Отображение и функциональность блока 'Real Time Projects Map'", priority = 60)
    public void displayingProjectMap() {
        ProjectMap b = new ProjectMap();
        b.checkMapWithFilters();
    }

    @TmsLink("5292430")
    @Test(description = "Отображение и функциональность блока 'Expert custom solutions with over X projects delivered'", priority = 70)
    public void displayingComprehensiveExpertise() {
        BusinessDomains b = new BusinessDomains();
        b.displayingElements();
    }

    @TmsLink("5366598")
    @Test(description = "Отображение блока и функционал блока 'Testimonials'", priority = 80, enabled = true) //блок testimonials отсутствует
    public void displayingFunctionCustomerReviews() {
        CustomerReviews b = new CustomerReviews(new CustomerReviewsDataFlutter());
        b.displayingElements();
    }

    @TmsLink("5292431")
    @Test(description = "Отображение и функциональность блока 'Contact us for a free consultation'", priority = 90)
    public void displayingScheduleYourFree() {
        Consultation b = new Consultation();
        b.displayingElements();
    }

    @TmsLink("")
    @Test(description = "Title и Description страницы", priority = 100)
    public void displayingTitle() {
        Page b = new Page(new PageTextsFlutter());
        b.displayingTitle();
    }

    @TmsLink("5678817")
    @Test(description = "[EN] Отображение и функциональность контактной формы в блоке с буллетами, где текст кнопки 'Request specialist'", priority = 110, groups = "Checking the main form for leads")
    public void checkMainFormForLeads(){
        MainFormForLeads mainFormForLeads = new MainFormForLeads();
        mainFormForLeads.scrollToButtonAndCheckTitle(mainFormForLeads.getButtonInMainModule(), "Request specialists");
        mainFormForLeads.checkEmailField();
        mainFormForLeads.checkPhoneField();
        mainFormForLeads.checkNda();
        mainFormForLeads.sendFormAndCheckSuccessfulModalWindow();
    }

    @TmsLink("5803694")
    @Test(description = "Проверить наличие блоков", priority = 120, groups = "Checking the blocks")
    public void checkBlocks(){
        CheckingThePresenceOfBlocks checkingThePresenceOfBlocks = new CheckingThePresenceOfBlocks();
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIntro());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getArchitect());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCalculator());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCustomSolutions());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIndustryRecognition());
    }
}

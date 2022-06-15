package com.andersenlab.autotests.site.industries.logistics;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.FeaturesIndexBlockData;
import com.andersenlab.autotests.core.configs.constants.GreetingsBlockData.Page;
import com.andersenlab.autotests.core.configs.constants.OurProjectsBlockData;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.consultation.ConsultationForm;
import com.andersenlab.autotests.core.configs.constants.CasesModel;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.form.ourprojectsblock.CaseCheck;
import com.andersenlab.autotests.site.logic.OurProjectsCheck;
import com.andersenlab.autotests.site.page.company.greetings.GreetingsOperations;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.CustomerReviewsDataIGamingPlatform;
import com.andersenlab.autotests.site.page.industries.logistics.CustomerReviewsDataLogistics;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviews;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex.FeaturesIndex;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Widgets;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Epic("Site")
@Listeners(SelenideListener.class)
public class LogisticsPageTest extends BaseTest2 {
    private final Pages page = Pages.LOGISTICS;
    private final Country country = Country.BY;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
    }

    @TmsLink("5374578")
    @Test(description = "отображение хедера")
    public void displayingIntro(){
        Intro intro = new Intro(new Widgets[]{Widgets.ISO_9001, Widgets.ISO_27001, Widgets.GDPR});
        intro.displayingElements(country);
    }

    @TmsLink("5374580")
    @Test(description = "отображение и функционал блока с буллитами")
    public void displayingSoftDev(){
        FeaturesIndex index = new FeaturesIndex(FeaturesIndexBlockData.Left.LOGISTICS.getData(), FeaturesIndexBlockData.Right.LOGISTICS.getData());

        index.checkImg();
        index.checkTitle();
        index.checkBtn();
        index.checkArticles();
    }

    @TmsLink("5374583")
    @Test(description = "Отображение и функционал блока 'Nice to meet you'")
    public void displayingGreeting(){
        GreetingsOperations steps = new GreetingsOperations();
        steps.checkGreetingBlock(
                Page.LOGISTICS.getStr().get("title"),
                Page.LOGISTICS.getStr().get("name"),
                Page.LOGISTICS.getStr().get("linkedin"),
                Page.LOGISTICS.getStr().get("position"),
                Page.LOGISTICS.getStr().get("message"));
        steps.checkVideoPopup();
    }

    @TmsLink("5396963")
    @Test(description = "Отображение и функциональность блока с кейсами 'Our projects'")
    public void displayingProjectExamples(){
        String title = OurProjectsBlockData.Logistics.LOGISTICS.getData().get(0);
        String subtitle = OurProjectsBlockData.Logistics.LOGISTICS.getData().get(1);
        List<List<String>> cards = Arrays.asList(
                OurProjectsBlockData.Logistics.TRANSPOREON.getData(),
                OurProjectsBlockData.Logistics.NEXXIOT.getData(),
                OurProjectsBlockData.Logistics.OURCNC.getData());
        OurProjectsCheck check = new OurProjectsCheck();
        check.checkTitleAndSubtitle(title, subtitle);
        check.checkCaseCards(cards);
    }

    @TmsLink("5396967")
    @Test(description = "Отображение кейса 'Transporeon'")
    public void displayingTransporeon(){
        int caseIndex = 0;
        List<String> caseSectionsTitles = Arrays.asList(CasesModel.SectionTitles.CONCEPT.getText(), CasesModel.SectionTitles.ABOUT.getText(),
                CasesModel.SectionTitles.FUNCTIONALITY.getText(), CasesModel.SectionTitles.SOLUTION.getText(),
                CasesModel.SectionTitles.RESULTS.getText(), CasesModel.SectionTitles.CONTACT_US.getText());
        CaseCheck caseCheck = new CaseCheck();
        caseCheck.titlesCheck(caseIndex, caseSectionsTitles);
    }

    @TmsLink("5396965")
    @Test(description = "Отображение кейса 'Nexxiot'")
    public void displayingNexxiot(){
        int caseIndex = 1;
        List<String> caseSectionsTitles = Arrays.asList(CasesModel.SectionTitles.CONCEPT.getText(), CasesModel.SectionTitles.ABOUT.getText(),
                CasesModel.SectionTitles.FUNCTIONALITY.getText(), CasesModel.SectionTitles.SOLUTION.getText(),
                CasesModel.SectionTitles.RESULTS.getText(), CasesModel.SectionTitles.CONTACT_US.getText());
        CaseCheck caseCheck = new CaseCheck();
        caseCheck.titlesCheck(caseIndex, caseSectionsTitles);
    }

    @TmsLink("5396966")
    @Test(description = "Отображение кейса 'OurCNC'")
    public void displayingOurCNC(){
        int caseIndex = 2;
        List<String> caseSectionsTitles = Arrays.asList(CasesModel.SectionTitles.CONCEPT.getText(), CasesModel.SectionTitles.ABOUT.getText(),
                CasesModel.SectionTitles.FUNCTIONALITY.getText(), CasesModel.SectionTitles.SOLUTION.getText(),
                CasesModel.SectionTitles.RESULTS.getText(), CasesModel.SectionTitles.CONTACT_US.getText());
        CaseCheck caseCheck = new CaseCheck();
        caseCheck.titlesCheck(caseIndex, caseSectionsTitles);
    }

    @TmsLink("5374589")
    @Test(description = "Отображение и функционал блока 'Cost calculator'")
    public void displayingCostCalc(){
        //calc doesn't exist on this page
    }

    @TmsLink("5374599")
    @Test(description = "Отображение и функционал блока 'Contact us for a free consultation'")
    public void displayingContactUsForm(){
        String title = "Contact us for a free consultation";
        String subtitle = "Need a hand with Logistics development? Fill out the form below to improve your business.";
        ConsultationForm consultationForm = new ConsultationForm(title, subtitle);
        consultationForm.checkTitle();
        consultationForm.checkForm();
    }

    @TmsLink("5390829")
    @Test(description = "Отображение и функциональность блока 'Testimonials'")
    public void displayingFunctionCustomerReviews(){
        CustomerReviews reviews = new CustomerReviews(new CustomerReviewsDataLogistics());
        reviews.displayingElements();
    }

    @TmsLink("5678818")
    @Test(description = "[EN] Отображение и функциональность контактной формы в блоке с буллетами, где текст кнопки 'Request consultation'", priority = 100, groups = "Checking the main form for leads")
    public void checkMainFormForLeads(){
        MainFormForLeads mainFormForLeads = new MainFormForLeads();
        mainFormForLeads.scrollToButtonAndCheckTitle(mainFormForLeads.getButtonInMainModule(), "Request consultation");
        mainFormForLeads.checkEmailField();
        mainFormForLeads.checkPhoneField();
        mainFormForLeads.checkNda();
        mainFormForLeads.sendFormAndCheckSuccessfulModalWindow();
    }

    @TmsLink("5803694")
    @Test(description = "Проверить наличие блоков", priority = 110, groups = "Checking the blocks")
    public void checkBlocks(){
        CheckingThePresenceOfBlocks checkingThePresenceOfBlocks = new CheckingThePresenceOfBlocks();
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIntro());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCalculator());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getConsultancyServices());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFaq());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFeature());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGreetingCard());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIndustryRecognition());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getListPageInterlinking());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getProjects());
    }
}

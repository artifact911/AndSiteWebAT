package com.andersenlab.autotests.site.industries.healthcare;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.AdvisoryBlockData;
import com.andersenlab.autotests.core.configs.constants.BlockWithLinksToSubpagesData;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.DifferenceBlockData;
import com.andersenlab.autotests.core.configs.constants.FeaturesIndexBlockData.Left;
import com.andersenlab.autotests.core.configs.constants.FeaturesIndexBlockData.Right;
import com.andersenlab.autotests.core.configs.constants.GreetingsBlockData;
import com.andersenlab.autotests.core.configs.constants.MultipleCardsWithTextData.HealthcareWhyCustomersChooseAndersen;
import com.andersenlab.autotests.core.configs.constants.OurProjectsBlockData;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.consultation.ConsultationForm;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.logic.OurProjectsCheck;
import com.andersenlab.autotests.site.logic.SomethingToThinkAbout;
import com.andersenlab.autotests.site.page.company.greetings.GreetingsOperations;
import com.andersenlab.autotests.site.page.industries.healthcare.blocks.AdvisoryBlock;
import com.andersenlab.autotests.site.page.industries.healthcare.blocks.BlockWithLinksToSubpages;
import com.andersenlab.autotests.site.page.industries.healthcare.blocks.customerreviews.CustomerReviewsDataHealthcareMain;
import com.andersenlab.autotests.site.page.industries.healthcare.blocks.SomethingToThinkAboutBlock;
import com.andersenlab.autotests.site.page.industries.healthcare.blocks.WhyCustomersChooseAndersen;
import com.andersenlab.autotests.site.page.industries.healthcare.blocks.differencemodule.DifferenceBlock;
import com.andersenlab.autotests.site.page.industries.healthcare.blocks.heading.BlockWithLinksToServices;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.FreeConsultationBlock;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviews;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex.FeaturesIndex;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Widgets;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.projectmap.ProjectMap;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Epic("Site")
@Listeners(SelenideListener.class)
public class HealthcarePageTest extends BaseTest2 {
    private final Pages page = Pages.HEALTHCARE;
    private final Country country = Country.BY;
    private final ConsultationForm consultationForm = new ConsultationForm();

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
        consultationForm.setConditions(page, country);
    }

    @TmsLink("5294849")
    @Test(description = "[D][T][M] Отображение хедера страницы", priority = 10)
    public void checkIntro(){
        Intro b = new Intro(new Widgets[]{});
        b.displayingTitle(country);
        b.displayingPhone(country);
    }

    @TmsLink("5352195")
    @Test(description = "[D][T][M] Отображение блока с буллетами", priority = 20)
    public void checkFeatureModule(){
        FeaturesIndex index = new FeaturesIndex(Left.HEALTHCARE.getData(), Right.HEALTHCARE.getData());

        index.checkImg();
        index.checkTitle();
        index.checkBtn();
        index.checkArticles();
    }

    @TmsLink("5296320")
    @Test(description = "[D][T][M] Отображение и функциональность блока 'Nice to meet you'", priority = 30)
    public void checkGreetingsCard(){
        GreetingsOperations steps = new GreetingsOperations();
        steps.checkGreetingBlock(
                GreetingsBlockData.Page.HEALTHCARE.getStr().get("title"),
                GreetingsBlockData.Page.HEALTHCARE.getStr().get("name"),
                GreetingsBlockData.Page.HEALTHCARE.getStr().get("linkedin"),
                GreetingsBlockData.Page.HEALTHCARE.getStr().get("position"),
                GreetingsBlockData.Page.HEALTHCARE.getStr().get("message"));
        steps.checkVideoPopup();
        steps.checkForbesLink(GreetingsBlockData.Page.HEALTHCARE.getStr().get("forbes"));
    }

    @TmsLink("5286616")
    @Test(description = "[D][T][M] Отображение блока 'Healthcare IT Services'", priority = 40)
    public void checkHealthcareITServices(){
        List<String> texts = BlockWithLinksToSubpagesData.Healthcare.HEALTHCARE_IT_SERVICES.getData();
        List<List<String>> cards = Arrays.asList(
                BlockWithLinksToSubpagesData.Healthcare.EMR_CARD.getData(),
                BlockWithLinksToSubpagesData.Healthcare.DA_AND_IOMT.getData(),
                BlockWithLinksToSubpagesData.Healthcare.CUSTOM_SOFT_DEV.getData(),
                BlockWithLinksToSubpagesData.Healthcare.TELEHEATH.getData()
        );
        BlockWithLinksToSubpages block = new BlockWithLinksToSubpages(texts, cards);
        block.checkMainPageBlock();
    }

    @TmsLink("5337857")
    @Test(description = "[D][T][M] Отображение блока 'Advisory board'", priority = 50)
    public void checkConsultants(){
        AdvisoryBlock block = new AdvisoryBlock();
        List<List<String>> experts = Arrays.asList(
          AdvisoryBlockData.Healthcare.FIRST.getData(),
          AdvisoryBlockData.Healthcare.SECOND.getData(),
          AdvisoryBlockData.Healthcare.THIRD.getData());
        block.checkBlock(AdvisoryBlockData.Healthcare.BLOCK.getData());
        block.checkAdvisory(experts);
    }

    @TmsLink("5424854")
    @Test(description = "[D][T][M] Отображение блока 'why customers choose andersen'", priority = 60)
    public void checkCustomersChooseBlock(){
        String title = HealthcareWhyCustomersChooseAndersen.HEADER.getData().get(0);
        String subtitle = HealthcareWhyCustomersChooseAndersen.HEADER.getData().get(1);
        List<List<String>> articles = Arrays.asList(
                HealthcareWhyCustomersChooseAndersen.FIRST.getData(),
                HealthcareWhyCustomersChooseAndersen.SECOND.getData(),
                HealthcareWhyCustomersChooseAndersen.THIRD.getData(),
                HealthcareWhyCustomersChooseAndersen.FOURTH.getData(),
                HealthcareWhyCustomersChooseAndersen.FIFTH.getData(),
                HealthcareWhyCustomersChooseAndersen.SIXTH.getData()
        );
        WhyCustomersChooseAndersen block = new WhyCustomersChooseAndersen(title, subtitle, articles);

        block.checkTitle();
        block.checkSubtitle();
        block.checkCards();
    }

    @TmsLink("5352290")
    @Test(description = "[D][T][M] Отображение блока 'Our projects'", priority = 70)
    public void checkOurProjects(){
        String title = OurProjectsBlockData.Healthcare.OUR_PROJECTS.getData().get(0);
        String subtitle = OurProjectsBlockData.Healthcare.OUR_PROJECTS.getData().get(1);
        List<List<String>> cards = Arrays.asList(
                OurProjectsBlockData.Healthcare.JOHNSON_JOHNSON.getData(),
                OurProjectsBlockData.Healthcare.META.getData(),
                OurProjectsBlockData.Healthcare.UNIVERSKIN.getData(),
                OurProjectsBlockData.Healthcare.TIGERCCONNECT.getData(),
                OurProjectsBlockData.Healthcare.EMFIT.getData(),
                OurProjectsBlockData.Healthcare.BLAZE_NOW.getData(),
                OurProjectsBlockData.Healthcare.TELEMDECINE.getData(),
                OurProjectsBlockData.Healthcare.DOCTOR_PLUS.getData(),
                OurProjectsBlockData.Healthcare.ONLINE_CLINIC.getData(),
                OurProjectsBlockData.Healthcare.AI_COVID.getData()
        );
        OurProjectsCheck check = new OurProjectsCheck();
        check.checkTitleAndSubtitle(title, subtitle);
        check.checkCaseCards(cards);
    }

    @TmsLink("5424855")
    @Test(description = "[D][T][M] Отображение блока 'andersen's difference'", priority = 80)
    public void checkAndersensDifference(){
        DifferenceBlock block = new DifferenceBlock(
                DifferenceBlockData.Healthcare.HEADER.getData(),
                DifferenceBlockData.Healthcare.CARDS.getData(),
                DifferenceBlockData.Healthcare.LIST.getData());
        block.checkTitle();
        block.checkCards();
        block.checkList();
    }

    @TmsLink("5341589")
    @Test(description = "[D][T][M] Отображение и функционал блока 'Something to think about'", priority = 90)
    public void checkArticlesBlock(){
        String title = OurProjectsBlockData.Healthcare.SMTHNG_TO_THINK.getData().get(0);
        String subtitle = OurProjectsBlockData.Healthcare.SMTHNG_TO_THINK.getData().get(1);
        List<List<String>> cards = Arrays.asList(
                OurProjectsBlockData.Healthcare.BENEFITS_OF_IoT.getData(),
                OurProjectsBlockData.Healthcare.PROSPECTS_FOR_DEVELOPMENT_OF_TELEMEDICINE.getData(),
                OurProjectsBlockData.Healthcare.INFLUENCE_OF_COVID_AT_IT.getData(),
                OurProjectsBlockData.Healthcare.ROLE_OF_CONNECTED_DEVICES.getData(),
                OurProjectsBlockData.Healthcare.TELEMDEDICINE_2dot0.getData()
        );
        Warp.delay(2);
        SomethingToThinkAbout check = new SomethingToThinkAbout(new SomethingToThinkAboutBlock());
        check.checkTitleAndSubtitle(title, subtitle);
        check.checkCaseCards(cards);
        check.checkCardLinks(cards);
    }

    @TmsLink("5366463")
    @Test(description = "[D][T][M] Отображение и функциональность блока 'Testimonials'", priority = 110)
    public void checkTestimonials(){
        CustomerReviews reviews = new CustomerReviews(new CustomerReviewsDataHealthcareMain());
        reviews.displayingElements();
    }

    @TmsLink("5296025")
    @Test(description = "[D][T][M] Отображение и функциональность блока 'Check out our consultancy services'", priority = 130)
    public void checkOurServices(){
        List<String> texts = BlockWithLinksToSubpagesData.Healthcare.CONSULTANCY_SERVICES.getData();
        List<List<String>> cards = Arrays.asList(
                BlockWithLinksToSubpagesData.Healthcare.BUSINESS_RECONSTRUCTION.getData(),
                BlockWithLinksToSubpagesData.Healthcare.IT_SECURITY.getData(),
                BlockWithLinksToSubpagesData.Healthcare.CI_CD_PRACTICES.getData(),
                BlockWithLinksToSubpagesData.Healthcare.DESIGN.getData(),
                BlockWithLinksToSubpagesData.Healthcare.AQA.getData(),
                BlockWithLinksToSubpagesData.Healthcare.BIG_DATA_AND_DA.getData()
        );
        BlockWithLinksToServices block = new BlockWithLinksToServices(texts, cards);
        block.checkMainPageBlock();
    }

    @TmsLink("5424858")
    @Test(description = "[D][T][M] Отображение блока 'CTA contact us for a free Healthcare IT consultation.'", priority = 140)
    public void checkContactUs(){
        String title = "Contact us for a free Healthcare IT consultation";
        String subtitle = "Need a hand with custom medical software development? Fill out the form below to discuss the opportunities for Digital Transformation of your Healthcare business.";
        ConsultationForm consultationForm = new ConsultationForm(title, subtitle);
        consultationForm.checkTitle();
        consultationForm.checkForm();
    }

    @TmsLink("5383092")
    @Test(description = "[D][T][M] Отображение и функциональность блока 'Whether you are in the early stage...'", priority = 150)
    public void checkCallToAction(){
        String title = "Whether you are in the early stage or have an ongoing project, our professional Healthcare architects are always ready to consult and guide you within the development process. Schedule a free online consultation with our specialists.";
        String formTitle = "Request consultation";
        String popupTitle = "Solution Architecture";
        FreeConsultationBlock freeConsultationBlock = new FreeConsultationBlock();
        freeConsultationBlock.checkBlock(title);
        freeConsultationBlock.checkPopupForm(formTitle);
        freeConsultationBlock.checkPopupInfo(popupTitle);
    }

    @TmsLink("5383000")
    @Test(description = "[D] Отображение и функциональность блока 'Real Time Projects Map'", priority = 160)
    public void checkRealTimeMap(){
        ProjectMap block = new ProjectMap();
        block.checkMapWithoutFilters();
    }

    @TmsLink("5678818")
    @Test(description = "[EN] Отображение и функциональность контактной формы в блоке с буллетами, где текст кнопки 'Request consultation'", priority = 170, groups = "Checking the main form for leads")
    public void checkMainFormForLeads(){
        MainFormForLeads mainFormForLeads = new MainFormForLeads();
        mainFormForLeads.scrollToButtonAndCheckTitle(mainFormForLeads.getButtonInIntroModule(), "Request consultation");
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
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getAdditionalInfo());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getArchitect());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCompanyOfExperts());
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

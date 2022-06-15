package com.andersenlab.autotests.site.industries.healthcare;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.BlockWithLinksToSubpagesData;
import com.andersenlab.autotests.core.configs.constants.CTABlockData;
import com.andersenlab.autotests.core.configs.constants.CompanyOfExpertsData;
import com.andersenlab.autotests.core.configs.constants.CostCalcData;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.FeaturesIndexBlockData;
import com.andersenlab.autotests.core.configs.constants.OurProjectsBlockData;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.CallToAction;
import com.andersenlab.autotests.site.form.consultation.ConsultationForm;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.logic.OurProjectsCheck;
import com.andersenlab.autotests.site.page.industries.healthcare.blocks.BlockWithLinksToSubpages;
import com.andersenlab.autotests.site.page.industries.healthcare.blocks.customerreviews.CustomerReviewsDataHealthcareTeleheath;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.WhatWeDoBlock;
import com.andersenlab.autotests.site.page.industries.videoandentertainment.blocks.CompanyOfExperts;
import com.andersenlab.autotests.site.page.industries.videoandentertainment.blocks.costcalc.DesktopCostCalc;
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
public class TeleheathSolutionsTest extends BaseTest2 {
    private final Pages page = Pages.TELEHEATH_SOLUTIONS;
    private final Country country = Country.BY;

    private final String title = "Contact us for a free Healthcare IT consultation";
    private final String subtitle = "Need a hand with custom telehealth application development? Fill out the form below to discuss the opportunities for Digital Transformation of your Healthcare business.";
    private final ConsultationForm consultationForm = new ConsultationForm(title, subtitle);

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
        consultationForm.setConditions(page, country);
    }

    @TmsLink("5280400")
    @Test(description = "[D] [T] [M] Отображение хедера страницы", priority = 10)
    public void checkIntro(){
        Intro b = new Intro(new Widgets[]{});
        b.displayingElements(country);
    }

    @TmsLink("5280395")
    @Test(description = "[D] [T] [M] Отображение и функциональность блока с буллитами 'Get advantage of using custom Telemedicine software...'", priority = 10)
    public void checkFeatureModule(){
        FeaturesIndex index = new FeaturesIndex(FeaturesIndexBlockData.Left.TELEHEATH.getData(), FeaturesIndexBlockData.Right.TELEHEATH.getData());

        index.checkImg();
        index.checkTitle();
        index.checkBtn();
        index.checkArticles();
    }

    @TmsLink("5305199")
    @Test(description = "[D] [T] [M] Отображение блока 'Company of experts'", priority = 10)
    public void checkCompanyOfExperts(){
        List<List<String>> certificates = Arrays.asList(
                CompanyOfExpertsData.HealthcareExperts.HIPAA.getEl(),
                CompanyOfExpertsData.HealthcareExperts.CLUTCH_TOP_STAFF.getEl(),
                CompanyOfExpertsData.HealthcareExperts.CLUTCH_TOP_SOFT_DEV.getEl(),
                CompanyOfExpertsData.HealthcareExperts.ISO_9001.getEl(),
                CompanyOfExpertsData.HealthcareExperts.ISO_IEC_27001.getEl(),
                CompanyOfExpertsData.HealthcareExperts.CLUTCH_TOP_1000.getEl()
        );
        CompanyOfExperts experts = new CompanyOfExperts(CompanyOfExpertsData.HealthcareExperts.TITLE.getEl(), certificates);
        experts.checkTitle();
        experts.checkSubtitle();
        experts.checkLogos();
    }

    @TmsLink("5276392")
    @Test(description = "[D] [T] [M] Отображение блока 'What we do'", priority = 10)
    public void checkWhatWeDo(){
        WhatWeDoBlock whatWeDo = new WhatWeDoBlock();
        whatWeDo.checkWhatWeDoTitle();
        whatWeDo.checkWhatWeDoArticles();
    }

    @TmsLink("5280442")
    @Test(description = "[D][T][M] Отображение и функциональность блока 'Request a professional consultation...'", priority = 10)
    public void checkCallToAction(){
        CallToAction block = new CallToAction(CTABlockData.Page.TELEHEATH.getExpected());
        block.checkTitle();
        block.checkBtn();
    }

    @TmsLink("5280444")
    @Test(description = "[D][T][M] Отображение и функциональность блока 'Contact us for a free Healthcare IT consultation'", priority = 10)
    public void checkContactUs(){
        consultationForm.checkTitle();
        consultationForm.checkSubtitle();
        consultationForm.checkForm();
        consultationForm.checkCAPTCHALinks();
    }

    @TmsLink("5412439")
    @Test(description = "[D][T][M] Отображение и функциональность блока 'Our projects'", priority = 10)
    public void checkOurProjects(){
        String title = OurProjectsBlockData.Healthcare.OUR_PROJECTS.getData().get(0);
        String subtitle = OurProjectsBlockData.Healthcare.OUR_PROJECTS.getData().get(1);
        List<List<String>> cards = Arrays.asList(
                OurProjectsBlockData.Healthcare.TELEMDECINE.getData(),
                OurProjectsBlockData.Healthcare.DOCTOR_PLUS.getData(),
                OurProjectsBlockData.Healthcare.ONLINE_CLINIC.getData()
        );
        OurProjectsCheck check = new OurProjectsCheck();
        check.checkTitleAndSubtitle(title, subtitle);
        check.checkCaseCards(cards);
    }

    @TmsLink("5280445")
    @Test(description = "[D][T] Отображение и функциональность блока 'Your price calculator'", priority = 10)
    public void checkDesktopCostCalc(){
        DesktopCostCalc block = new DesktopCostCalc(CostCalcData.Page.TELEHEATH.getData(), country);
        block.checkDesktopCalc();
    }

    @TmsLink("5286627")
    @Test(description = "[D] [T] [M] Отображение блока 'More Healthcare IT Services'", priority = 10)
    public void checkHealthcareITServices(){
        List<String> texts = BlockWithLinksToSubpagesData.Healthcare.MORE_SERVICES.getData();
        List<List<String>> cards = Arrays.asList(
                BlockWithLinksToSubpagesData.Healthcare.EMR_CARD.getData(),
                BlockWithLinksToSubpagesData.Healthcare.DA_AND_IOMT.getData(),
                BlockWithLinksToSubpagesData.Healthcare.CUSTOM_SOFT_DEV.getData(),
                BlockWithLinksToSubpagesData.Healthcare.SOFT_SOL.getData()
                );
        List<String> link = BlockWithLinksToSubpagesData.Healthcare.LINK_TO_MAIN.getData();
        BlockWithLinksToSubpages block = new BlockWithLinksToSubpages(texts, cards, link);
        block.checkSubpageBlock();
    }

    @TmsLink("5366532")
    @Test(description = "[D] [T] [M] Отображение и функциональность блока 'Testimonials'", priority = 10)
    public void checkTestimonials(){
        CustomerReviews reviews = new CustomerReviews(new CustomerReviewsDataHealthcareTeleheath());
        reviews.displayingElements();
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
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCalculator());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCallToAction());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCompanyOfExperts());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFeature());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getListPageInterlinking());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getProjects());
    }
}

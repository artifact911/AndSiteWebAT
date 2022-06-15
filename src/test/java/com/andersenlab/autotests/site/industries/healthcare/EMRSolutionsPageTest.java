package com.andersenlab.autotests.site.industries.healthcare;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.BlockWithLinksToSubpagesData;
import com.andersenlab.autotests.core.configs.constants.CTABlockData;
import com.andersenlab.autotests.core.configs.constants.CompanyOfExpertsData.HealthcareExperts;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.OurProjectsBlockData;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.CallToAction;
import com.andersenlab.autotests.site.form.consultation.ConsultationForm;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.logic.OurProjectsCheck;
import com.andersenlab.autotests.site.page.industries.healthcare.blocks.BlockWithLinksToSubpages;
import com.andersenlab.autotests.site.page.industries.healthcare.blocks.customerreviews.CustomerReviewsDataHealthcareEMR;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.WhatWeDoBlock;
import com.andersenlab.autotests.site.page.industries.videoandentertainment.blocks.CompanyOfExperts;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviews;
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
public class EMRSolutionsPageTest extends BaseTest2 {
    private final Pages page = Pages.EMR_SOLUTIONS;
    private final Country country = Country.BY;
    private final ConsultationForm consultationForm = new ConsultationForm();

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
        consultationForm.setConditions(page, country);
    }

    @TmsLink("5280435")
    @Test(description = "[D][T][M] Отображение хедера страницы", priority = 10)
    public void checkIntro(){
        Intro b = new Intro(new Widgets[]{});
        b.displayingTitle(country);
        b.displayingPhone(country);
    }

    @TmsLink("5305192")
    @Test(description = "[D][T][M] Отображение блока 'Company of experts'", priority = 20)
    public void checkCompanyOfExperts(){
        List<List<String>> certificates = Arrays.asList(
                HealthcareExperts.HIPAA.getEl(),
                HealthcareExperts.CLUTCH_TOP_STAFF.getEl(),
                HealthcareExperts.CLUTCH_TOP_SOFT_DEV.getEl(),
                HealthcareExperts.ISO_9001.getEl(),
                HealthcareExperts.ISO_IEC_27001.getEl(),
                HealthcareExperts.CLUTCH_TOP_1000.getEl()
                );
        CompanyOfExperts experts = new CompanyOfExperts(HealthcareExperts.TITLE.getEl(), certificates);
        experts.checkTitle();
        experts.checkSubtitle();
        experts.checkLogos();
    }

    @TmsLink("5276376")
    @Test(description = "[D] [T] [M] Отображение блока 'What we do'", priority = 30)
    public void checkWhatWeDo(){
        WhatWeDoBlock whatWeDo = new WhatWeDoBlock();
        whatWeDo.checkWhatWeDoTitle();
        whatWeDo.checkWhatWeDoCards();
    }

    @TmsLink("5286584")
    @Test(description = "[D][T][M] Отображение и функционал блок 'Request a professional...'", priority = 40)
    public void checkCallToAction(){
        CallToAction block = new CallToAction(CTABlockData.Page.EMR.getExpected());
        block.checkTitle();
        block.checkBtn();
    }

    @TmsLink("5286623")
    @Test(description = "[D] [T] [M] Отображение блока 'More Healthcare IT Services'", priority = 50)
    public void checkHealthcareITServices(){
        List<String> texts = BlockWithLinksToSubpagesData.Healthcare.MORE_SERVICES.getData();
        List<List<String>> cards = Arrays.asList(
                BlockWithLinksToSubpagesData.Healthcare.DA_AND_IOMT.getData(),
                BlockWithLinksToSubpagesData.Healthcare.CUSTOM_SOFT_DEV.getData(),
                BlockWithLinksToSubpagesData.Healthcare.TELEHEATH.getData(),
                BlockWithLinksToSubpagesData.Healthcare.SOFT_SOL.getData()
        );
        List<String> link = BlockWithLinksToSubpagesData.Healthcare.LINK_TO_MAIN.getData();
        BlockWithLinksToSubpages block = new BlockWithLinksToSubpages(texts, cards, link);
        block.checkSubpageBlock();
    }

    @TmsLink("5366529")
    @Test(description = "[D] [T] [M] Отображение и функциональность блока 'Testimonials'", priority = 60)
    public void checkTestimonials(){
        CustomerReviews reviews = new CustomerReviews(new CustomerReviewsDataHealthcareEMR());
        reviews.displayingElements();
    }

    @TmsLink("5430364")
    @Test(description = "[D][T][M] Отображение блока 'Our projects'", priority = 70)
    public void checkOurProjects(){
        String title = OurProjectsBlockData.Healthcare.OUR_PROJECTS.getData().get(0);
        String subtitle = OurProjectsBlockData.Healthcare.OUR_PROJECTS.getData().get(1);
        List<List<String>> cards = Arrays.asList(
                OurProjectsBlockData.Healthcare.META.getData(),
                OurProjectsBlockData.Healthcare.JOHNSON_JOHNSON.getData(),
                OurProjectsBlockData.Healthcare.ONLINE_CLINIC.getData()
        );
        OurProjectsCheck check = new OurProjectsCheck();
        check.checkTitleAndSubtitle(title, subtitle);
        check.checkCaseCards(cards);
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
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCallToAction());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCompanyOfExperts());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFeature());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getListPageInterlinking());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getProjects());
    }
}

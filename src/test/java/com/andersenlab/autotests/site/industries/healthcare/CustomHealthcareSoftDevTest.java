package com.andersenlab.autotests.site.industries.healthcare;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.BlockWithLinksToSubpagesData;
import com.andersenlab.autotests.core.configs.constants.CTABlockData;
import com.andersenlab.autotests.core.configs.constants.CompanyOfExpertsData;
import com.andersenlab.autotests.core.configs.constants.CostCalcData;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.FeaturesIndexBlockData;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.form.CallToAction;
import com.andersenlab.autotests.site.form.consultation.ConsultationForm;
import com.andersenlab.autotests.site.page.industries.healthcare.blocks.BlockWithLinksToSubpages;
import com.andersenlab.autotests.site.page.industries.healthcare.blocks.customerreviews.CustomerReviewsDataHealthcareSoftDev;
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
public class CustomHealthcareSoftDevTest extends BaseTest2 {
    private final Pages page = Pages.CUSTOM_MEDICAL_SOFTWARE;
    private final Country country = Country.BY;
    private final ConsultationForm consultationForm = new ConsultationForm();

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
        consultationForm.setConditions(page, country);
    }

    @TmsLink("5286604")
    @Test(description = "[D] [T] [M] Отображение хедера страницы", priority = 10)
    public void checkIntro(){
        Intro b = new Intro(new Widgets[]{});
        b.displayingTitle(country);
        b.displayingPhone(country);
    }

    @TmsLink("5286606")
    @Test(description = "[D] [T] [M] Отображение и функциональность блока с буллитами 'Drive digital transformation of your business with a complete range of Custom Healthcare Software'", priority = 10)
    public void checkFeatureModule(){
        FeaturesIndex index = new FeaturesIndex(FeaturesIndexBlockData.Left.HEALTHCARE_SOFT_DEV.getData(), FeaturesIndexBlockData.Right.HEALTHCARE_SOFT_DEV.getData());

        index.checkImg();
        index.checkTitle();
        index.checkBtn();
        index.checkArticles();
    }

    @TmsLink("5305197")
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

    @TmsLink("5286628")
    @Test(description = "[D] [T] [M] Отображение блока 'More Healthcare IT Services'", priority = 10)
    public void checkHealthcareITServices(){
        List<String> texts = BlockWithLinksToSubpagesData.Healthcare.MORE_SERVICES.getData();
        List<List<String>> cards = Arrays.asList(
                BlockWithLinksToSubpagesData.Healthcare.EMR_CARD.getData(),
                BlockWithLinksToSubpagesData.Healthcare.DA_AND_IOMT.getData(),
                BlockWithLinksToSubpagesData.Healthcare.TELEHEATH.getData(),
                BlockWithLinksToSubpagesData.Healthcare.SOFT_SOL.getData()
        );
        List<String> link = BlockWithLinksToSubpagesData.Healthcare.LINK_TO_MAIN.getData();
        BlockWithLinksToSubpages block = new BlockWithLinksToSubpages(texts, cards, link);
        block.checkSubpageBlock();
    }

    @TmsLink("5299255")
    @Test(description = "[D] [T] [M] Отображение блока 'What we do'", priority = 10)
    public void checkWhatWeDo(){
        WhatWeDoBlock whatWeDo = new WhatWeDoBlock();
        whatWeDo.checkWhatWeDoTitle();
        whatWeDo.checkWhatWeDoCards();
    }

    @TmsLink("5293748")
    @Test(description = "[D][T][M] Отображение блока 'Request a professional....'", priority = 10)
    public void checkCallToAction(){
        CallToAction block = new CallToAction(CTABlockData.Page.HC_SOFT_DEV.getExpected());
        block.checkTitle();
        block.checkBtn();
    }

    @TmsLink("5294105")
    @Test(description = "[D][T] Отображение и функциональность блока 'Your price calculator'", priority = 10)
    public void checkDesktopCostCalc(){
        DesktopCostCalc block = new DesktopCostCalc(CostCalcData.Page.HEALTHCARE_SOFT_DEV.getData(), country);
        block.checkDesktopCalc();
    }

    @TmsLink("5366531")
    @Test(description = "[D] [T] [M] Отображение и функциональность блока 'Testimonials'", priority = 10)
    public void checkTestimonials(){
        CustomerReviews reviews = new CustomerReviews(new CustomerReviewsDataHealthcareSoftDev());
        reviews.displayingElements();
    }
}

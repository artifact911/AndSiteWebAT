package com.andersenlab.autotests.site.industries.telecom;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.CTABlockData;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.FeaturesIndexBlockData;
import com.andersenlab.autotests.core.configs.constants.MultipleCardsWithTextData.TelecomReliableSolutions;
import com.andersenlab.autotests.core.configs.constants.MultipleCardsWithTextData.TelecomWhyAndersen;
import com.andersenlab.autotests.core.configs.constants.MultipleCardsWithTextData.TelecomServices;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.CallToAction;
import com.andersenlab.autotests.site.form.consultation.ConsultationForm;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.CustomerReviewsDataIGamingPlatform;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.WhatWeDoBlock;
import com.andersenlab.autotests.site.page.industries.telecom.PageTextsTelecom;
import com.andersenlab.autotests.site.page.industries.telecom.blocks.CustomerReviewsDataTelecom;
import com.andersenlab.autotests.site.page.industries.telecom.blocks.OurServices;
import com.andersenlab.autotests.site.page.industries.telecom.blocks.ReliableSolutions;
import com.andersenlab.autotests.site.page.industries.telecom.blocks.WhyAnderson;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviews;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex.FeaturesIndex;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.page.Page;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Epic("Site")
@Listeners(SelenideListener.class)
public class TelecomPageTest extends BaseTest2 {
    private final Pages page = Pages.TELECOM;
    private final Country country = Country.BY;
    private final ConsultationForm consultationForm = new ConsultationForm("Contact us for a free Telecom IT consultation");

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
        consultationForm.setConditions(page, country);
    }

    @TmsLink("5326150")
    @Test(description = "Отображение заголовка")
    public void displayingIntro(){
        Intro intro = new Intro();
        intro.displayingTitle(country);
    }

    @TmsLink("5326151")
    @Test(description = "[D] [T] [M] Отображение и функциональность блока 'Get innovative custom Telecom software to propel your digital transformation'")
    public void displayingSoftDev(){
        FeaturesIndex index = new FeaturesIndex(FeaturesIndexBlockData.Left.TELECOM.getData(), FeaturesIndexBlockData.Right.TELECOM.getData());

        index.checkImg();
        index.checkTitle();
        index.checkSubtitle();
        index.checkBtn();
        index.checkArticles();
    }

    @TmsLink("5326154")
    @Test(description = "[D] [T] [M] Отображение блока 'Our telecom software development services'")
    public void displayingOurServices(){
        String title = TelecomServices.HEADER.getTitle();
        String subtitle = TelecomServices.HEADER.getMessage();
        List<List<String>> articles = Arrays.asList(
                Arrays.asList(TelecomServices.FIRST.getTitle(),
                        TelecomServices.FIRST.getMessage(),
                        TelecomServices.FIRST.getImageLink()),
                Arrays.asList(TelecomServices.SECOND.getTitle(),
                        TelecomServices.SECOND.getMessage(),
                        TelecomServices.SECOND.getImageLink()),
                Arrays.asList(TelecomServices.THIRD.getTitle(),
                        TelecomServices.THIRD.getMessage(),
                        TelecomServices.THIRD.getImageLink())
        );
        OurServices block = new OurServices(title, subtitle, articles);
        block.checkTitle();
        block.checkCards();
    }

    @TmsLink("5326150")
    @Test(description = "[D] [T] [M] Title и Description страницы")
    public void checkMetaData(){
        Page page = new Page(new PageTextsTelecom());
        page.displayingTitle();
    }

    @TmsLink("5455397")
    @Test(description = "Отображение блока 'What we do'")
    public void displayingWhatWeDo(){
        WhatWeDoBlock whatWeDo = new WhatWeDoBlock();
        whatWeDo.checkWhatWeDoTitle();
        whatWeDo.checkWhatWeDoArticles();
    }

    @TmsLink("5455395")
    @Test(description = "[D][T][M] Отображение и функциональность блока 'Contact us for a free Telecom IT consultation'")
    public void checkContactUsForm(){
        consultationForm.checkTitle();
        consultationForm.checkForm();
        consultationForm.checkCAPTCHALinks();
    }

    @TmsLink("5455398")
    @Test(description = "[D][T][M] Отображение и функциональность блока Testimonials", priority = 70)
    public void checkTestimonials(){
        CustomerReviews reviews = new CustomerReviews(new CustomerReviewsDataTelecom());
        reviews.displayingElements();
    }

    @TmsLink("5678818")
    @Test(description = "[EN] Отображение и функциональность контактной формы в блоке с буллетами, где текст кнопки 'Request consultation'", priority = 80, groups = "Checking the main form for leads")
    public void checkMainFormForLeads(){
        MainFormForLeads mainFormForLeads = new MainFormForLeads();
        mainFormForLeads.scrollToButtonAndCheckTitle(mainFormForLeads.getButtonInMainModule(), "Request consultation");
        mainFormForLeads.checkEmailField();
        mainFormForLeads.checkPhoneField();
        mainFormForLeads.checkNda();
        mainFormForLeads.sendFormAndCheckSuccessfulModalWindow();
    }

    @TmsLink("5803694")
    @Test(description = "Проверить наличие блоков", priority = 90, groups = "Checking the blocks")
    public void checkBlocks(){
        CheckingThePresenceOfBlocks checkingThePresenceOfBlocks = new CheckingThePresenceOfBlocks();
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIntro());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getArchitect());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFeature());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIndustryRecognition());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getPageInterlinking());
    }
}

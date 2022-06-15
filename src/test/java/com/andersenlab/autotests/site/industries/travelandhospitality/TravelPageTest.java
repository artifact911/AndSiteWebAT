package com.andersenlab.autotests.site.industries.travelandhospitality;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.FeaturesIndexBlockData;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.logic.RequestFormCheck;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.CustomerReviewsDataIGamingPlatform;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.FreeConsultationBlock;
import com.andersenlab.autotests.site.page.industries.travelandhospitality.blocks.heading.CustomerReviewsDataTravelAndHospitality;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviews;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex.FeaturesIndex;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Widgets;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Listeners(SelenideListener.class)
public class TravelPageTest extends BaseTest2 {
    private final Pages page = Pages.TRAVEL_AND_HOSPITALITY;
    private final Country country = Country.BY;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
    }

    @TmsLink("5294847")
    @Test(description = "[D][T][M] Отображение хедера страницы", priority = 10)
    public void checkIntro(){
        Intro intro = new Intro(new Widgets[]{});
        intro.displayingElements(country);
    }

    @TmsLink("5338125")
    @Test(description = "[D][T][M] Отображение и функциональность блока с буллитами", priority = 20)
    public void checkFeatureModule(){
        FeaturesIndex index = new FeaturesIndex(FeaturesIndexBlockData.Left.TRAVEL_AND_HOSPITALITY.getData(),
                FeaturesIndexBlockData.Right.TRAVEL_AND_HOSPITALITY.getData());

        index.checkImg();
        index.checkTitle();
        index.checkBtn();
        index.checkArticles();
    }

    @TmsLink("5381756")
    @Test(description = "[D][T][M] Отображение поп-апа 'Request consultation'", priority = 30)
    public void checkRequestConsultationPopup(){
        RequestFormCheck form = new RequestFormCheck("Request consultation");
        form.checkLinks();
        form.checkForm();
        form.checkReCAPTCHA();
    }

    @TmsLink("5383089")
    @Test(description = "[D][T][M] Отображение и функциональность блока", priority = 50)
    public void checkCTAblock(){
        String title = "Whether you are in the early stage or have an ongoing project, our professional Travel & Hospitality Solution Architects are always ready to consult and guide you within the development process. Schedule a free online consultation with a specialist.";
        String formTitle = "Request consultation";
        String popupTitle = "Solution Architecture";
        FreeConsultationBlock freeConsultationBlock = new FreeConsultationBlock();
        freeConsultationBlock.checkBlock(title);
        freeConsultationBlock.checkPopupForm(formTitle);
        freeConsultationBlock.checkPopupInfo(popupTitle);
    }

    @TmsLink("5366460")
    @Test(description = "[D][T][M] Отображение и функциональность блока Testimonials", priority = 70)
    public void checkTestimonials(){
        CustomerReviews reviews = new CustomerReviews(new CustomerReviewsDataTravelAndHospitality());
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
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getProjects());
    }
}

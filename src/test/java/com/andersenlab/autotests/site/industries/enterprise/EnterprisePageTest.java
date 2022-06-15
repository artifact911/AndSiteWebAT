package com.andersenlab.autotests.site.industries.enterprise;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.CTABlockData;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.FeaturesIndexBlockData;
import com.andersenlab.autotests.core.configs.constants.MultipleCardsWithTextData.EnterpriseCompetitorsChoose;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.CallToAction;
import com.andersenlab.autotests.site.form.consultation.ConsultationForm;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.page.industries.enterprise.PageTextsEnterprise;
import com.andersenlab.autotests.site.page.industries.enterprise.blocks.CompetitorsChoose;
import com.andersenlab.autotests.site.page.industries.enterprise.blocks.InfoMessage;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.FreeConsultationBlock;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.WhatWeDoBlock;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex.FeaturesIndex;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import com.andersenlab.autotests.site.page.services.salesforce.blocks.improve.Improve;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Epic("site")
@Listeners(SelenideListener.class)
public class EnterprisePageTest extends BaseTest2 {
    private final Pages page = Pages.ENTERPRISE;
    private final Country country = Country.BY;
    private final ConsultationForm consultationForm = new ConsultationForm();

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
        consultationForm.setConditions(page, country);
    }

    @TmsLink("5326217")
    @Test(description = "[D] [T] [M] Отображение блока 'Custom Enterprise Software Development Services'")
    public void displayingIntro(){
        Intro intro = new Intro();
        intro.displayingPhone(country);
        intro.displayingTitle(country);
    }

    @TmsLink("5326218")
    @Test(description = "[D] [T] [M] Отображение и функциональность блока с буллитами 'Be on the wave of innovation, transform ..'")
    public void displayingSoftDev(){
        FeaturesIndex index = new FeaturesIndex(FeaturesIndexBlockData.Left.ENTERPRISE.getData(), FeaturesIndexBlockData.Right.ENTERPRISE.getData());

        index.checkImg();
        index.checkTitle();
        index.checkBtn();
        index.checkArticles();
    }

    @TmsLink("5326220")
    @Test(description = "[D] [T] [M] Отображение и функциональность блока 'Enterprise software development services'")
    public void displayingReachOut(){
        Improve block = new Improve("//h2[contains(text(), 'Enterprise software development services')]//..//..", 3);
        block.displayingElements();
    }

    @TmsLink("5374182")
    @Test(description = "Отображение и функциональность блока 'What we do'")
    public void displayingWhatWeDo(){
        WhatWeDoBlock whatWeDo = new WhatWeDoBlock();
        whatWeDo.checkWhatWeDoTitle();
        whatWeDo.checkWhatWeDoCards();
    }

    @TmsLink("5326224")
    @Test(description = "Отображение заголовка вкладки")
    public void checkMetaData(){
        com.andersenlab.autotests.site.page.services.customsoftware.blocks.page.Page page = new com.andersenlab.autotests.site.page.services.customsoftware.blocks.page.Page(new PageTextsEnterprise());
        page.displayingTitle();
    }

    @TmsLink("5331900")
    @Test(description = "[D][T][M] Отображение и функциональность блока 'Let’s talk business'")
    public void displayingContactUsForm(){
        String title = "Contact us for a free consultation on Enterprise software development";
        ConsultationForm consultationForm = new ConsultationForm(title);
        consultationForm.checkTitle();
        consultationForm.checkForm();
    }

    @TmsLink("5383099")
    @Test(description = "[D] [T] [M] Отображение и функциональность блока 'Whether you are in the early stage...'")
    public void displayingScheduleYourFree(){
        String title = "Whether you are in the early stage or have an ongoing project, our professional Enterprise "+
                "architects are always ready to consult and guide you within the development process. "+
                "Schedule a free online consultation with our specialists.";
        String formTitle = "Request consultation";
        String popupTitle = "Solution Architecture";
        FreeConsultationBlock freeConsultationBlock = new FreeConsultationBlock();
        freeConsultationBlock.checkBlock(title);
        freeConsultationBlock.checkPopupForm(formTitle);
        freeConsultationBlock.checkPopupInfo(popupTitle);
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
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getArchitect());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFeature());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIndustryRecognition());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getPageInterlinking());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getProjects());
    }
}

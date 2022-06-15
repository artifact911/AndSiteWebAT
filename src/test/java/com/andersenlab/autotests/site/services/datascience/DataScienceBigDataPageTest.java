package com.andersenlab.autotests.site.services.datascience;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Listeners(SelenideListener.class)
public class DataScienceBigDataPageTest extends BaseTest2 {

    private final Pages page = Pages.DATA_SCIENCE;
    private final Country country = Country.NOT_SPECIFIED;

    private MainFormForLeads mainFormForLeads;
    private CheckingThePresenceOfBlocks checkingThePresenceOfBlocks;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, country);
        mainFormForLeads = new MainFormForLeads();
        checkingThePresenceOfBlocks = new CheckingThePresenceOfBlocks();
    }

    @TmsLink("5678914")
    @Test(description = "[EN] Отображение и функциональность контактной формы в блоке с буллетами, где текст кнопки 'Get a quote'", priority = 10, groups = "Checking the main form for leads")
    public void checkMainFormForLeads(){
        mainFormForLeads.scrollToButtonAndCheckTitle(mainFormForLeads.getButtonInMainModule(), "Get a quote");
        mainFormForLeads.checkEmailField();
        mainFormForLeads.checkPhoneField();
        mainFormForLeads.checkNda();
        mainFormForLeads.sendFormAndCheckSuccessfulModalWindow();
    }

    @TmsLink("5803694")
    @Test(description = "Проверить наличие блоков", priority = 20, groups = "Checking the blocks")
    public void checkBlocks(){
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIntro());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getArchitect());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCustomSolutions());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFeature());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIndustryRecognition());
    }
}

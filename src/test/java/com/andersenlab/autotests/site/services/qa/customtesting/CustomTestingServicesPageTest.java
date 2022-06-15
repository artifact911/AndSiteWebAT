package com.andersenlab.autotests.site.services.qa.customtesting;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.gmail.ReadEmail;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.page.services.qa.calculatorqa.CalculatorQA;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;

@Epic("Site")
@Listeners(SelenideListener.class)
public class CustomTestingServicesPageTest extends BaseTest2 {

    private final Pages page = Pages.CUSTOM_TESTING_SERVICES;
    private final Country country = Country.NOT_SPECIFIED;

    private MainFormForLeads mainFormForLeads;
    private CalculatorQA calcQA;
    private ReadEmail readEmail;
    private CheckingThePresenceOfBlocks checkingThePresenceOfBlocks;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, country);
        mainFormForLeads = new MainFormForLeads();
        calcQA = new CalculatorQA();
        readEmail = new ReadEmail();
        checkingThePresenceOfBlocks = new CheckingThePresenceOfBlocks();
    }

    @TmsLink("5678915")
    @Test(description = "[EN] Отображение и функциональность контактной формы в блоке с буллетами, где текст кнопки 'Get free consultation'", priority = 10, groups = "Checking the main form for leads")
    public void checkMainFormForLeads() {
        mainFormForLeads.scrollToButtonAndCheckTitle(mainFormForLeads.getButtonInMainModule(), "Get free consultation");
        mainFormForLeads.checkEmailField();
        mainFormForLeads.checkPhoneField();
        mainFormForLeads.checkNda();
        mainFormForLeads.sendFormAndCheckSuccessfulModalWindow();
    }

    @TmsLink("5375642 & 5375645 & 5375647")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (позитивный кейс)" +
            "Запись БД включен чекбокс NDA" + "Отправка обратной связи на почту",
            groups = "Calculators group")
    public void checkCalcQAModalWindowPositiveNonCorporate() throws SQLException, MessagingException, IOException {
        calcQA.preparationForModalWindow();
        calcQA.checkPositiveEmailNonCorporate();
        readEmail.readGoogleEmail();
        calcQA.ndaCheckDBPositive();
    }

    @TmsLink("5375642 & 5375646 & 5375647")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (позитивный кейс)" +
            "Запись БД чекбокс NDA не включен" + "Отправка обратной связи на почту",
            groups = "Calculators group")
    public void checkQAModalWindowPositiveCorporate() throws SQLException, MessagingException, IOException {
        calcQA.preparationForModalWindow();
        calcQA.checkPositiveEmailCorporate();
        readEmail.readGoogleEmail();
        calcQA.ndaCheckDBNegative();
    }

    @TmsLink("5375643")
    @Test(description = "Валидация поля Corporate E-mail (негативный кейс)",
            groups = "Calculators group")
    public void checkCalcQAModalWindowNegative() {
        calcQA.preparationForModalWindow();
        calcQA.checkNegativeEmailWithoutCreds();
        calcQA.preparationForModalWindow();
        calcQA.checkNegativeEmailWithCreds();
    }

    @TmsLink("5375644")
    @Test(description = "Валидация поля Phone и отправка сообщения",
            groups = "Calculators group")
    public void checkNegativePhone() {
        calcQA.preparationForModalWindow();
        calcQA.checkLongNegativePhone();
    }

    @TmsLink("5803694")
    @Test(description = "Проверить наличие блоков", groups = "Checking the blocks")
    public void checkBlocks(){
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIntro());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCalculator());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFeature());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIndustryRecognition());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getPageInterlinking());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getProjects());
    }
}

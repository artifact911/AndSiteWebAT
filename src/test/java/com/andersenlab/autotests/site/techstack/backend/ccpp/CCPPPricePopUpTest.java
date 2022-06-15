package com.andersenlab.autotests.site.techstack.backend.ccpp;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.form.popup.calculator.CalcForm;
import com.andersenlab.autotests.site.form.successwindow.SuccessRich;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Listeners(SelenideListener.class)
public class CCPPPricePopUpTest extends BaseTest2 {

    private final Country country = Country.BY;
    private final Pages page = Pages.C_CPP;
    private final CalcForm calcForm = new CalcForm("Please, leave your contact details to receive the quote", new SuccessRich(country));

    @BeforeClass
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
        calcForm.setConditions(page, country);
    }

    @BeforeMethod(alwaysRun = true)
    @Override
    protected void beforeMethod() {
        super.beforeMethod();
        calcForm.doBefore();
    }

    @TmsLink("")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (позитивный кейс)", priority = 10)
    public void inputMailValidationPositive() {
        calcForm.inputMailValidationPositive();
    }

    @TmsLink("")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (негативный кейс)", priority = 30)
    public void inputMailValidationNegative() {
        calcForm.inputMailValidationNegative();
    }

    @TmsLink("")
    @Test(description = "Валидация поля 'Phone' и отправка сообщения", priority = 20)
    public void inputPhoneValidationAndSend() {
        calcForm.inputPhoneValidationAndSend();
    }

    @TmsLink("")//TODO переделать тесты с БД(не через UI)
    @Test(description = "Запись БД включен чекбокс NDA", enabled=false,  priority = 50, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordCheckedNda() {
        calcForm.dbRecordCheckedNda();
    }

    @TmsLink("")
    @Test(description = "Запись БД чекбокс NDA не включен", enabled=false, priority = 60, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordUncheckedNda() {
        calcForm.dbRecordUncheckedNda();
    }

    @TmsLink("")
    @Test(description = "Отправка обратной связи на почту", enabled=false, priority = 70, dependsOnMethods = "inputMailValidationPositive")
    public void emailSent() {
        calcForm.emailSent();
    }

}

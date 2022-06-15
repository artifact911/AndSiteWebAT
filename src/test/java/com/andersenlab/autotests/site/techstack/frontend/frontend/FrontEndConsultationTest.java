package com.andersenlab.autotests.site.techstack.frontend.frontend;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.form.consultation.ConsultationForm;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Listeners(SelenideListener.class)
public class FrontEndConsultationTest extends BaseTest2 {
    private final ConsultationForm consultationForm = new ConsultationForm();
    private final Country country = Country.US;
    private final Pages page = Pages.FRONTEND;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
        consultationForm.setConditions(page, country);
    }

    @TmsLink("5274201")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (позитивный кейс)", priority = 10)
    public void inputMailValidationPositive() {
        consultationForm.inputMailValidationPositive();
    }

    @TmsLink("5274202")
    @Test(description = "Валидация поля Corporate E-mail (негативный кейс)", priority = 20)
    public void inputMailValidationNegative() {
        consultationForm.inputMailValidationNegative();
    }

    @TmsLink("5274203")
    @Test(description = "Валидация поля 'Phone' и отправка сообщения", priority = 30)
    public void inputPhoneValidationAndSend() {
        consultationForm.inputPhoneValidationAndSend();
    }

    @TmsLink("5274204")//TODO переделать тесты с БД(не через UI)
    @Test(description = "Запись БД включен чекбокс NDA", enabled=false,  priority = 40, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordCheckedNda() {
        consultationForm.dbRecordCheckedNda();
    }

    @TmsLink("5274205")
    @Test(description = "Запись БД чекбокс NDA не включен", enabled=false, priority = 50, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordUncheckedNda() {
        consultationForm.dbRecordUncheckedNda();
    }

    @TmsLink("5274206")
    @Test(description = "Отправка обратной связи на почту", enabled=false, priority = 60, dependsOnMethods = "inputMailValidationPositive")
    public void emailSent() {
        consultationForm.emailSent();
    }
}

package com.andersenlab.autotests.site.techstack.mobile.ios;

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
public class IosConsultationTest extends BaseTest2 {
    private final ConsultationForm consultationForm = new ConsultationForm();
    private final Country country = Country.NOT_SPECIFIED;
    private final Pages page = Pages.IOS;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, country);
        consultationForm.setConditions(page, country);
    }

    @TmsLink("")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (позитивный кейс)", priority = 10)
    public void inputMailValidationPositive() {
        consultationForm.inputMailValidationPositive();
    }

    @TmsLink("")
    @Test(description = "Валидация поля Corporate E-mail (негативный кейс)", priority = 20)
    public void inputMailValidationNegative() {
        consultationForm.inputMailValidationNegative();
    }

    @TmsLink("")
    @Test(description = "Валидация поля 'Phone' и отправка сообщения", priority = 30)
    public void inputPhoneValidationAndSend() {
        consultationForm.inputPhoneValidationAndSend();
    }

    @TmsLink("")
    @Test(description = "Запись БД включен чекбокс NDA", enabled=false,  priority = 40, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordCheckedNda() {
        consultationForm.dbRecordCheckedNda();
    }

    @TmsLink("")
    @Test(description = "Запись БД чекбокс NDA не включен", enabled=false, priority = 50, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordUncheckedNda() {
        consultationForm.dbRecordUncheckedNda();
    }

    @TmsLink("")
    @Test(description = "Отправка обратной связи на почту", enabled=false, priority = 60, dependsOnMethods = "inputMailValidationPositive")
    public void emailSent() {
        consultationForm.emailSent();
    }
}

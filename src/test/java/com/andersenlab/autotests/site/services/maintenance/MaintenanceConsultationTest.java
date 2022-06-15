package com.andersenlab.autotests.site.services.maintenance;

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
public class MaintenanceConsultationTest extends BaseTest2 {
    private ConsultationForm rf = new ConsultationForm("Get free IT Support consultation");

    private Country country = Country.NOT_SPECIFIED;
    private Pages page = Pages.MAINTENANCE;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, country);
        rf.setConditions(page, country);
    }

    @TmsLink("5253077")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (позитивный кейс)", priority = 10)
    public void inputMailValidationPositive() {
        rf.inputMailValidationPositive();
    }

    @TmsLink("5253078")
    @Test(description = "Валидация поля Corporate E-mail (негативный кейс)", priority = 20)
    public void inputMailValidationNegative() {
        rf.inputMailValidationNegative();
    }

    @TmsLink("5253079")
    @Test(description = "Валидация поля 'Phone' и отправка сообщения", priority = 30)
    public void inputPhoneValidationAndSend() {
        rf.inputPhoneValidationAndSend();
    }

    @TmsLink("5253080")
    @Test(description = "Запись БД включен чекбокс NDA", enabled=false,  priority = 40, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordCheckedNda() {
        rf.dbRecordCheckedNda();
    }

    @TmsLink("5253081")
    @Test(description = "Запись БД чекбокс NDA не включен", enabled=false, priority = 50, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordUncheckedNda() {
        rf.dbRecordUncheckedNda();
    }

    @TmsLink("5253082")
    @Test(description = "Отправка обратной связи на почту", enabled=false, priority = 60, dependsOnMethods = "inputMailValidationPositive")
    public void emailSent() {
        rf.emailSent();
    }
}

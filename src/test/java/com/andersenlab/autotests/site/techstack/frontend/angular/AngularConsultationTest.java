package com.andersenlab.autotests.site.techstack.frontend.angular;

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
public class AngularConsultationTest extends BaseTest2 {
    private final ConsultationForm requestForm = new ConsultationForm();
    private final Country country = Country.NOT_SPECIFIED;
    private final Pages page = Pages.ANGULAR;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, country);
        requestForm.setConditions(page, country);
    }

    @TmsLink("5274213")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (позитивный кейс)", priority = 10)
    public void inputMailValidationPositive() {
        requestForm.inputMailValidationPositive();
    }

    @TmsLink("5274214")
    @Test(description = "Валидация поля Corporate E-mail (негативный кейс)", priority = 20)
    public void inputMailValidationNegative() {
        requestForm.inputMailValidationNegative();
    }

    @TmsLink("5274215")
    @Test(description = "Валидация поля 'Phone' и отправка сообщения", priority = 30)
    public void inputPhoneValidationAndSend() {
        requestForm.inputPhoneValidationAndSend();
    }

    @TmsLink("5274216")//TODO переделать тесты с БД(не через UI)
    @Test(description = "Запись БД включен чекбокс NDA", enabled=false,  priority = 40, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordCheckedNda() {
        requestForm.dbRecordCheckedNda();
    }

    @TmsLink("5274217")
    @Test(description = "Запись БД чекбокс NDA не включен", enabled=false, priority = 50, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordUncheckedNda() {
        requestForm.dbRecordUncheckedNda();
    }

    @TmsLink("5274218")
    @Test(description = "Отправка обратной связи на почту", enabled=false, priority = 60, dependsOnMethods = "inputMailValidationPositive")
    public void emailSent() {
        requestForm.emailSent();
    }
}

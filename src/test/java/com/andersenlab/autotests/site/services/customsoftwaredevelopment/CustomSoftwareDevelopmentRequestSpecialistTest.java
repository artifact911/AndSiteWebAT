package com.andersenlab.autotests.site.services.customsoftwaredevelopment;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.form.popup.requestform.RequestForm;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex.FeaturesIndex;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Listeners(SelenideListener.class)
public class CustomSoftwareDevelopmentRequestSpecialistTest extends BaseTest2 {
    private RequestForm rf = new RequestForm("Request specialists");

    private Country country = Country.UA;
    private Pages page = Pages.CUSTOM_SOFTWARE;

    @BeforeClass
    @Override
    protected void beforeClass() {
        prepare(page, country);
        rf.setConditions(page, country);
    }

    @BeforeMethod(alwaysRun = true)
    @Override
    protected void beforeMethod() {
        super.beforeMethod();
        doBefore();
    }

    private void doBefore() {
        (new FeaturesIndex()).getButtonReq().click();
    }

    @TmsLink("5245620")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (позитивный кейс)", priority = 10)
    public void inputMailValidationPositive() {
        rf.inputMailValidationPositive();
    }

    @TmsLink("5245621")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (негативный кейс)", priority = 30)
    public void inputMailValidationNegative() {
        rf.inputMailValidationNegative();
    }

    @TmsLink("5245622")
    @Test(description = "Валидация поля 'Phone' и отправка сообщения", priority = 20)
    public void inputPhoneValidationAndSend() {
        rf.inputPhoneValidationAndSend();
    }

    @TmsLink("5245623")
    @Test(description = "Запись БД включен чекбокс NDA", enabled=false,  priority = 50, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordCheckedNda() {
        rf.dbRecordCheckedNda();
    }

    @TmsLink("5245624")
    @Test(description = "Запись БД чекбокс NDA не включен", enabled=false, priority = 60, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordUncheckedNda() {
        rf.dbRecordUncheckedNda();
    }

    @TmsLink("5245625")
    @Test(description = "Отправка обратной связи на почту", enabled=false, priority = 70, dependsOnMethods = "inputMailValidationPositive")
    public void emailSent() {
        rf.emailSent();
    }

    @TmsLink("5245626")
    @Test(description = "Переход по ссылкам поп-апа", priority = 40)
    public void linkPhoneMail() {
        rf.linkPhoneMail();
    }
}

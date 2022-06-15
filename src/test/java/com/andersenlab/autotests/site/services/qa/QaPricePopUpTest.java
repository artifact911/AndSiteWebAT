package com.andersenlab.autotests.site.services.qa;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.form.popup.calculator.CalcForm;
import com.andersenlab.autotests.site.form.successwindow.SuccessRich;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.cv.CvBlock;
import com.andersenlab.autotests.site.page.services.salesforce.blocks.improve.Improve;
import com.andersenlab.autotests.site.utility.Warp;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Listeners(SelenideListener.class)
public class QaPricePopUpTest extends BaseTest2 {

    private Country country = Country.NOT_SPECIFIED;
    private Pages page = Pages.QA;

    private CalcForm rf = new CalcForm("Please, leave your contact details to receive the quote", new SuccessRich(country));

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
        rf.doBefore();
    }

    @TmsLink("5246308")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (позитивный кейс)", priority = 10)
    public void inputMailValidationPositive() {
        rf.inputMailValidationPositive();
    }

    @TmsLink("5246309")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (негативный кейс)", priority = 30)
    public void inputMailValidationNegative() {
        rf.inputMailValidationNegative();
    }

    @TmsLink("5246310")
    @Test(description = "Валидация поля 'Phone' и отправка сообщения", priority = 20)
    public void inputPhoneValidationAndSend() {
        rf.inputPhoneValidationAndSend();
    }

    @TmsLink("5246311")
    @Test(description = "Запись БД включен чекбокс NDA", enabled=false,  priority = 50, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordCheckedNda() {
        rf.dbRecordCheckedNda();
    }

    @TmsLink("5246312")
    @Test(description = "Запись БД чекбокс NDA не включен", enabled=false, priority = 60, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordUncheckedNda() {
        rf.dbRecordUncheckedNda();
    }

    @TmsLink("5246313")
    @Test(description = "Отправка обратной связи на почту", enabled=false, priority = 70, dependsOnMethods = "inputMailValidationPositive")
    public void emailSent() {
        rf.emailSent();
    }

}

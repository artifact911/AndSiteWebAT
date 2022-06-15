package com.andersenlab.autotests.site.industries.enterprise;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.form.popup.requestform.RequestForm;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.*;

@Epic("site")
@Listeners(SelenideListener.class)
public class EnterpriseCallToActionPopupTest extends BaseTest2{
    private final Pages page = Pages.ENTERPRISE;
    private final Country country = Country.UA;
    private final RequestForm requestForm = new RequestForm("Reach out");

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
        requestForm.setConditions(page, country);
    }

    @BeforeMethod(alwaysRun = true)
    @Override
    protected void beforeMethod(){
        super.beforeMethod();
        requestForm.doBefore();
    }

    @TmsLink("5331915")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (позитивный кейс)", priority = 10)
    public void inputMailValidationPositive() {
        requestForm.inputMailValidationPositive();
    }

    @TmsLink("5331916")
    @Test(description = "Валидация поля Corporate E-mail (негативный кейс)", priority = 20)
    public void inputMailValidationNegative() {
        requestForm.inputMailValidationNegative();
    }

    @TmsLink("5331917")
    @Test(description = "Валидация поля 'Phone' и отправка сообщения", priority = 30)
    public void inputPhoneValidationAndSend() {
        requestForm.inputPhoneValidationAndSend();
    }

    @TmsLink("5331918")
    @Ignore
    @Test(description = "Запись БД включен чекбокс NDA", enabled=false,  priority = 40, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordCheckedNda() {
        requestForm.dbRecordCheckedNda();
    }

    @TmsLink("5331919")
    @Ignore
    @Test(description = "Запись БД чекбокс NDA не включен", enabled=false, priority = 50, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordUncheckedNda() {
        requestForm.dbRecordUncheckedNda();
    }

    @TmsLink("5331920")
    @Ignore
    @Test(description = "Отправка обратной связи на почту", enabled=false, priority = 60, dependsOnMethods = "inputMailValidationPositive")
    public void emailSent() {
        requestForm.emailSent();
    }
}

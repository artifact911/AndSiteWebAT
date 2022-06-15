package com.andersenlab.autotests.site.industries.realestate;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.form.popup.requestform.RequestForm;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.*;

/**"Pop-up "Get a free quote"*/
@Epic("Site")
@Listeners(SelenideListener.class)
public class RealEstateCallToActionPopupTest extends BaseTest2 {
    private final Pages page = Pages.REAL_ESTATE;
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

    @TmsLink("5326077")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (позитивный кейс)", priority = 10)
    public void inputMailValidationPositive() {
        requestForm.inputMailValidationPositive();
    }

    @TmsLink("5326078")
    @Test(description = "Валидация поля Corporate E-mail (негативный кейс)", priority = 20)
    public void inputMailValidationNegative() {
        requestForm.inputMailValidationNegative();
    }

    @TmsLink("5326079")
    @Test(description = "Валидация поля 'Phone' и отправка сообщения", priority = 30)
    public void inputPhoneValidationAndSend() {
        requestForm.inputPhoneValidationAndSend();
    }

    @TmsLink("5326080")//TODO переделать тесты с БД(не через UI)
    @Ignore
    @Test(description = "Запись БД включен чекбокс NDA", enabled=false,  priority = 40, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordCheckedNda() {
        requestForm.dbRecordCheckedNda();
    }

    @TmsLink("5326081")
    @Ignore
    @Test(description = "Запись БД чекбокс NDA не включен", enabled=false, priority = 50, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordUncheckedNda() {
        requestForm.dbRecordUncheckedNda();
    }

    @TmsLink("5326082")
    @Ignore
    @Test(description = "Отправка обратной связи на почту", enabled=false, priority = 60, dependsOnMethods = "inputMailValidationPositive")
    public void emailSent() {
        requestForm.emailSent();
    }
}

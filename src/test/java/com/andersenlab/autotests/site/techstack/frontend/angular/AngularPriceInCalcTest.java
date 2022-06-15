package com.andersenlab.autotests.site.techstack.frontend.angular;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.form.popup.calculator.CalcForm;
import com.andersenlab.autotests.site.form.successwindow.SuccessRich;
import com.andersenlab.autotests.site.page.techstack.frontend.angular.blocks.CostCalc;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.*;

@Epic("Site")
@Listeners(SelenideListener.class)
public class AngularPriceInCalcTest extends BaseTest2 {

    private final Country country = Country.UA;
    private final Pages page = Pages.ANGULAR;
    private final CostCalc calc = new CostCalc();
    private final CalcForm calcForm = new CalcForm("Please, leave your contact details to receive the quote", new SuccessRich(country));

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
        calcForm.setConditions(page, country);
    }

    @BeforeMethod(alwaysRun = true)
    @Override
    protected void beforeMethod(){
        calc.preparePopup();
    }

    @TmsLink("5274220")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (позитивный кейс)", priority = 20) //Селенид выхватывает блоки БНП/Тинькофф/Мого вместо Мерседеса/ИнтерактивТВ/Медиамаркта
    public void inputMailValidationPositive(){
        calcForm.inputMailValidationPositive();
    }

    @TmsLink("5274221")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (негативный кейс)", priority = 10)
    public void inputMailValidationNegative(){
        calcForm.inputMailValidationNegative();
    }

    @TmsLink("5274222")
    @Test(description = "Валидация поля Phone и отправка сообщения", priority = 30)
    public void inputPhoneValidationAndSend(){
        calcForm.inputPhoneValidationAndSend();
    }

    @TmsLink("5274223")//TODO переделать тесты с БД(не через UI)
    @Test(description = "Запись БД включен чекбокс NDA", enabled=false,  priority = 40)
    public void dbRecordCheckedNda(){
        calcForm.dbRecordCheckedNda();
    }

    @TmsLink("5274224")
    @Test(description = "Запись БД чекбокс NDA не включен", enabled=false, priority = 50)
    public void dbRecordUncheckedNda(){
        calcForm.dbRecordUncheckedNda();
    }

    @TmsLink("5274225")
    @Test(description = "Отправка обратной связи на почту", enabled=false, priority = 60)
    public void emailSent(){
        calcForm.emailSent();
    }

}

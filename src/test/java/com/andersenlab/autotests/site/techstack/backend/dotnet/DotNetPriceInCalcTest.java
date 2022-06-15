package com.andersenlab.autotests.site.techstack.backend.dotnet;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.form.popup.calculator.CalcForm;
import com.andersenlab.autotests.site.form.successwindow.SuccessRich;
import com.andersenlab.autotests.site.page.techstack.backend.dotnet.blocks.CostCalc;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Listeners(SelenideListener.class)
public class DotNetPriceInCalcTest extends BaseTest2 {
    private final Country country = Country.BY;
    private final Pages page = Pages.DOT_NET;
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

    @TmsLink("")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (позитивный кейс)", priority = 20) //Селенид выхватывает блоки БНП/Тинькофф/Мого вместо Мерседеса/ИнтерактивТВ/Медиамаркта
    public void inputMailValidationPositive(){
        calcForm.inputMailValidationPositive();
    }

    @TmsLink("")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (негативный кейс)", priority = 10)
    public void inputMailValidationNegative(){
        calcForm.inputMailValidationNegative();
    }

    @TmsLink("")
    @Test(description = "Валидация поля Phone и отправка сообщения", priority = 30)
    public void inputPhoneValidationAndSend(){
        calcForm.inputPhoneValidationAndSend();
    }

    @TmsLink("")//TODO переделать тесты с БД(не через UI)
    @Test(description = "Запись БД включен чекбокс NDA", enabled=false,  priority = 40 ,dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordCheckedNda(){
        calcForm.dbRecordCheckedNda();
    }

    @TmsLink("")
    @Test(description = "Запись БД чекбокс NDA не включен", enabled=false, priority = 50, dependsOnMethods = "inputPhoneValidationAndSend" )
    public void dbRecordUncheckedNda(){
        calcForm.dbRecordUncheckedNda();
    }

    @TmsLink("")
    @Test(description = "Отправка обратной связи на почту", enabled=false, priority = 60 , dependsOnMethods = "inputMailValidationPositive")
    public void emailSent(){
        calcForm.emailSent();
    }

}

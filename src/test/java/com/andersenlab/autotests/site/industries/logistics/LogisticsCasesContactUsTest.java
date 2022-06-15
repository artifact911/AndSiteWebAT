package com.andersenlab.autotests.site.industries.logistics;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.form.ourprojectsblock.CaseCheck;
import com.andersenlab.autotests.site.form.ourprojectsblock.CaseConcultationForm;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.ourprojectsblock.OurProjectsBlock;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**Форма обратной связи "Contact us..." в кейсах*/
@Epic("Site")
@Listeners(SelenideListener.class)
public class LogisticsCasesContactUsTest extends BaseTest2 {
    private final Pages page = Pages.LOGISTICS;
    private final Country country = Country.UA;
    private final int index = 0; //from 0 to 2
    private final CaseCheck caseCheck = new CaseCheck(index);
    private final CaseConcultationForm consultationForm = new CaseConcultationForm(OurProjectsBlock.expectedTitle, index);

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, Country.NOT_SPECIFIED);
        consultationForm.setConditions(page, country);
    }

    @TmsLink("5307217")
    @Test(description = "Отображение и функционал блока обратной связи 'Contact us...'", priority = 10)
    public void displayingFeedbackForm(){
        caseCheck.feedBackFormCheck();
    }

    @TmsLink("5307217")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (позитивный кейс)", priority = 20) //Селенид выхватывает блоки БНП/Тинькофф/Мого вместо Мерседеса/ИнтерактивТВ/Медиамаркта
    public void inputMailValidationPositive(){
        consultationForm.inputMailValidationPositive();
    }

    @TmsLink("5307218")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (негативный кейс)", priority = 30)
    public void inputMailValidationNegative(){
        consultationForm.inputMailValidationNegative();
    }

    @TmsLink("5307219")
    @Test(description = "Валидация поля Phone и отправка сообщения", priority = 40)
    public void inputPhoneValidationAndSend(){
        consultationForm.inputPhoneValidationAndSend();
    }

    @TmsLink("5307220")
    @Ignore
    @Test(description = "Запись БД включен чекбокс NDA", enabled=false,  priority = 50 ,dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordCheckedNda(){
        consultationForm.dbRecordCheckedNda();
    }

    @TmsLink("5307221")
    @Ignore
    @Test(description = "Запись БД чекбокс NDA не включен", enabled=false, priority = 60, dependsOnMethods = "inputPhoneValidationAndSend" )
    public void dbRecordUncheckedNda(){
        consultationForm.dbRecordUncheckedNda();
    }

    @TmsLink("5307222")
    @Ignore
    @Test(description = "Отправка обратной связи на почту", enabled=false, priority = 70 , dependsOnMethods = "inputMailValidationPositive")
    public void emailSent(){
        consultationForm.emailSent();
    }


}

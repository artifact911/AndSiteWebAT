package com.andersenlab.autotests.site.form;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.form.contactusfooter.ContactUsFooter;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Listeners(SelenideListener.class)
public class CustomSoftwareDevelopmentContactUsFooterTest extends BaseTest2 {
    private ContactUsFooter pu = new ContactUsFooter();

    private String CURRENT_URL;
    private String uniqNameForDbTest = null;
    private Country country = Country.US;
    private Pages page = Pages.CUSTOM_SOFTWARE;


    @BeforeMethod
    @Override
    protected void beforeMethod() {
        super.beforeMethod();
        pu.precondition();
    }

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page , country);
        CURRENT_URL = Warp.currentURL();
    }

    @TmsLink("5250522")
    @Test(description = "Отображение элементов футера [ALL]", priority = 20)
    public void displayingElements() {
        pu.displayAll();
    }

    @TmsLink("5250523")
    @Test(description = "Отображение и функционал кнопок мессенджеров и соц. сетей в футере", priority = 30)
    public void linksDisplayingFunction() {
        pu.hoverPointer();
        pu.sendButtonHovered();
        pu.linkCheck();
        pu.linkPhoneMail(country);
    }

    @TmsLink("5250524")
    @Test(description = "Отображение и функциональность поп-апа галереи", priority = 40)
    public void galleryDisplaying() {
        pu.galleryK();
        Selenide.refresh();
        pu.galleryV();
    }

    @TmsLink("5250525")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (позитивный кейс)", priority = 10)
    public void inputMailValidationPositive() {
        pu.enterNotCooperateMail();
        pu.enterValidPhone();
        uniqNameForDbTest = pu.makeUniqName();
        pu.enterName(uniqNameForDbTest);
        pu.checkTheBoxNda();
        pu.sendRequest();
        pu.checkSuccessWindow();
        pu.closeSuccessWindow(CURRENT_URL);
        pu.enterCooperateMail();
        pu.sendRequest();
        pu.checkSuccessWindow();
    }

    @TmsLink("5250526")
    @Test(description = "Валидация поля Corporate E-mail (негативный кейс)", priority = 50)
    public void inputMailValidationNegative() {
        pu.emptyInputRequest();
        pu.enterInvalidMail();
    }

    @TmsLink("5250527")
    @Test(description = "Валидация поля 'Phone' и отправка сообщения", priority = 60)
    public void inputPhoneValidationAndSend() {
        pu.enterValidPhone();
        pu.sendRequest();
        pu.closeSuccessWindow(CURRENT_URL);
        pu.enterInvalidPhone();
    }

    @TmsLink("5250528")//TODO переделать тесты с БД(не через UI)
    @Test(description = "Запись БД включен чекбокс NDA", enabled=false,  priority = 80, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecordingCheckedBox() {
        pu.recordIsPresentDb(uniqNameForDbTest);
    }

}

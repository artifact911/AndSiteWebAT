package com.andersenlab.autotests.site.form;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.form.popup.requestmeeting.RequestMeeting;
import com.andersenlab.autotests.site.utility.Warp;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.andersenlab.autotests.core.configs.basetest.Pages.HOMEPAGE;

@Epic("Site")
@Listeners(SelenideListener.class)
public class HomePageRequestMeetingTest extends BaseTest2 {
    private RequestMeeting rf = new RequestMeeting();

    private Country country = Country.NOT_SPECIFIED;
    private Pages page = HOMEPAGE;

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

    void doBefore() {
        Warp.clickSimple("//button[@id='trips-list__link_select']");
    }

    @TmsLink("4969937")
    @Test(description = "Отображение попапа 'Request a meeting'", priority = 50)
    public void requestMeetingPopUpDisplaying() {
        rf.requestMeetingPopUpDisplaying();
    }

    @TmsLink("4969938")
    @TmsLink("4973369")
    @Test(description = "Отображение и функционал ссылки контактного номера телефона в модальном окне 'Request a meeting'", priority = 20)
    public void linkPhoneMail() {
        rf.linkPhoneMail();
    }

    @TmsLink("4969939")
    @Test(description = "Валидация полей формы 'Request a meeting'", priority = 40)
    public void requestMeetingFieldsValidation() {
        rf.requestMeetingFieldsValidation();
    }

    @TmsLink("4969940")
    @Test(description = "Отправка сообщения в модальном окне 'Request a meeting'", priority = 10)
    public void requestMeetingSendMessage() {
        rf.requestMeetingSendMessage();
    }

    @TmsLink("4969941")
    @Test(description = "Запись данных в БД", priority = 70, dependsOnMethods = "requestMeetingSendMessage")
    public void dbRecord() {
        rf.dbRecord();
    }

    @TmsLink("4977404")
    @Test(description = "Закрытие модального окна 'Request a meeting'", priority = 60)
    public void requestMeetingClosingWindow() {
        rf.requestMeetingClosingWindow();
    }
}

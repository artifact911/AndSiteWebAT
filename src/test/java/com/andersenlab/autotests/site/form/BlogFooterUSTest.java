package com.andersenlab.autotests.site.form;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.form.contactusfooterus.ContactUsFooterUs;
import com.andersenlab.autotests.site.utility.Warp;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Listeners(SelenideListener.class)
public class BlogFooterUSTest extends BaseTest2 {
    private ContactUsFooterUs contactUsFooterUs = new ContactUsFooterUs();

    private String CURRENT_URL;
    private String uniqNameForDbTest = null;
    private Country country = Country.US;
    private Pages page = Pages.BLOG;


    @BeforeMethod
    @Override
    protected void beforeMethod() {
        super.beforeMethod();
        contactUsFooterUs.precondition();
    }

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page , country);
        CURRENT_URL = Warp.currentURL();
    }

    @TmsLink("5293477")
    @Test(description = "Отображение элементов футера [ALL]", priority = 20)
    public void displayingElements() {
        contactUsFooterUs.displayAll();
    }

    @TmsLink("5293478")
    @TmsLink("5293480")
    @Test(description = "Отображение и функционал кнопок мессенджеров и соц. сетей в футере + Privacy Policy", priority = 30)
    public void linksDisplayingFunction() {
        contactUsFooterUs.hoverPointer();
        contactUsFooterUs.sendButtonHovered();
        contactUsFooterUs.linkCheck();
        contactUsFooterUs.linkPhoneMail(country);
    }

    @TmsLink("5293479")
    @Test(description = "Отображение и функциональность поп-апа галереи", priority = 40)
    public void galleryDisplaying() {
        contactUsFooterUs.galleryKyiv();
    }

    @TmsLink("5293481")
    @Test(description = "Валидация поля Corporate E-mail и отправка сообщения (позитивный кейс)", priority = 10)
    public void inputMailValidationPositive() {
        contactUsFooterUs.enterNotCooperateMail();
        contactUsFooterUs.enterValidPhone();
        uniqNameForDbTest = contactUsFooterUs.makeUniqName();
        contactUsFooterUs.enterName(uniqNameForDbTest);
        contactUsFooterUs.sendRequest();
        contactUsFooterUs.checkSuccessWindow();
        contactUsFooterUs.closeSuccessWindow(CURRENT_URL);
        contactUsFooterUs.enterCooperateMail();
        contactUsFooterUs.sendRequest();
        contactUsFooterUs.checkSuccessWindow();
    }

    @TmsLink("5293482")
    @Test(description = "Валидация поля Corporate E-mail (негативный кейс)", priority = 50)
    public void inputMailValidationNegative() {
        contactUsFooterUs.emptyInputRequest();
        contactUsFooterUs.enterInvalidMail();
    }

    @TmsLink("5293483")
    @TmsLink("5293484")
    @Test(description = "Валидация поля 'Phone' и отправка сообщения + негативный кейс", priority = 60)
    public void inputPhoneValidationAndSend() {
        contactUsFooterUs.enterValidPhone();
        contactUsFooterUs.sendRequest();
        contactUsFooterUs.closeSuccessWindow(CURRENT_URL);
        contactUsFooterUs.enterInvalidPhone();
    }

    @TmsLink("5293485")
    @Test(description = "Запись БД", priority = 90, dependsOnMethods = "inputMailValidationPositive")
    public void dbRecording() {
        contactUsFooterUs.recordIsPresentDb(uniqNameForDbTest);
    }

    @TmsLink("5293486")
    @Test(description = "Отправка обратной связи на почту ", priority = 80, enabled = false)
    public void mailSend() {
        Assert.fail("MOT IMPLEMENTED");
    }

}

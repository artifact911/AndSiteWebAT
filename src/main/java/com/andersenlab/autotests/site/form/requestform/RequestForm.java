package com.andersenlab.autotests.site.form.requestform;

import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.db.webdb.Db;
import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.form.commonforms.FormData;
import com.andersenlab.autotests.site.form.commonforms.FormPopUp;
import com.andersenlab.autotests.site.form.spam.Spamable;
import com.andersenlab.autotests.site.form.successwindow.Success;
import com.andersenlab.autotests.site.form.successwindow.SuccessPoor;
import com.andersenlab.autotests.site.logic.Navigation;
import com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.getspecialist.GetSpecialist;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.testng.Assert;

import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor //для FormPopUp
public class RequestForm implements FormData, RequestFormLocators, Spamable, FormPopUp {
    //этот класс используется для проверки окон request specialist/get quote/request consultation. перегруженный checkTitle(String) не использовать в новом коде
    private final RequestFormElements el = new RequestFormElements();
    private Success success;
    private String title;
    private String currentUrl;
    private final String errorMessageAttribute = "forms-module--error--3R6sz";
    private final String errorMessage = "precondition not met";
    private String uniqNameForCheckedNda = null;
    private String uniqNameForUncheckedNda = null;
    private Country country = Country.UA;//значение по умолчанию
    private Pages page = Pages.MOBILE_DEV;//переопределяется сеттером
    private boolean isCalc = false;

    public RequestForm(String title) {
        this.title = title;
        success = new SuccessPoor();
    }

    public RequestForm(String title, Success success) {
        //этот конструктор вызывается в случае Know the real price of the project
        this.title = title;
        this.success = success;
        isCalc = true;
    }

    //контракт------------------------------------------------------------------------------------------------------------------------------------------

    public void setConditions(final Pages page, final Country country) {
        //вызывать в beforeClass после prepare(page, country);
        this.country = country;
        this.page = page;
        currentUrl = Warp.currentURL();
    }

    public void inputMailValidationPositive() {
        //Валидация поля Corporate E-mail и отправка сообщения (позитивный кейс)
        enterNotCooperateMail();
        enterValidPhone();
        uniqNameForCheckedNda = makeUniqName();
        enterName(uniqNameForCheckedNda);
        checkTheBoxNda();
        sendRequest();
        closeSuccessWindow(currentUrl);

        doBefore();
        uniqNameForUncheckedNda = makeUniqName();
        enterName(uniqNameForUncheckedNda);
        enterCooperateMail();
        sendRequest();
        closeSuccessWindow(currentUrl);
        Warp.delay(FormData.DELAY); //нехорошо, но иначе только в потоках/за разные пробеги через файл и т д
    }

    public void inputMailValidationNegative() {
        //Валидация поля Corporate E-mail (негативный кейс)
        emptyInputRequest();
        closeReqWindow(currentUrl);
        doBefore();
        enterInvalidMail();
    }

    public void inputPhoneValidationAndSend() {
        //Валидация поля "Phone" и отправка сообщения
        enterValidPhone();
        sendRequest();
        closeSuccessWindow(currentUrl);
        doBefore();
        enterInvalidPhone();
    }

    public void dbRecordCheckedNda() {
        //Запись БД включен чекбокс NDA. dependsOnMethods = "inputMailValidationPositive" БД/form_data/message/NDA - on
        recordIsPresentDb(uniqNameForCheckedNda, true);
        Navigation.gotoLink(currentUrl);
    }

    public void dbRecordUncheckedNda() {
        //Запись БД чекбокс NDA не включен. dependsOnMethods = "inputPhoneValidationAndSend" БД/form_data/message/NDA - off
        recordIsPresentDb(uniqNameForUncheckedNda, false);
        Navigation.gotoLink(currentUrl);
    }

    public void emailSent() {
        //Отправка обратной связи на почту - косвенно, через БД/form_data/notifyTo/email - ok. проверяем наличие 1/2 записей(см выше)
        emailSentDb(uniqNameForCheckedNda, uniqNameForUncheckedNda);
        Navigation.gotoLink(currentUrl);
    }

    public void linkPhoneMail() {
        //Переход по ссылкам поп-апа
        linkPhone(country);
        linkMail();
    }

    @Step
    @Override
    public void checkTitle() {
        Assert.assertEquals(el.getTitleWindowReq().getText(), title);
        Assertions.elementShouldBeVisible(TITLE_REQ);
    }

    @Override
    public void closeReq() {
        el.getButtonCloseReqWindow().click();
    }

    @Override
    public String goodReq(String mail, String phone) {
        //doBefore(); //если сломается строка ниже
        (new GetSpecialist()).getButtonReqSpec().click();
        el.getInputMail().sendKeys(mail);
        el.getInputPhone().sendKeys(phone);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss SSS");
        String date = java.time.LocalTime.now().format(dtf);
        String uniqName = Spamable.NAME_BASE + date;
        el.getInputName().sendKeys(uniqName);
        if (Spamable.CHECK_BOX) checkTheBoxNda();
        el.getButtonSendReq().click();
        success.checkAndClose();
        return uniqName;
    }

    @Override
    public void precondition() {
        String link2 = "find-developers/front-end";
        String link = WebDriverRunner.getWebDriver().getCurrentUrl() + link2;
        Navigation.gotoLink(link);
    }

    //контракт------------------------------------------------------------------------------------------------------------------------------------------

    @Step
    private void enterNotCooperateMail() {
        el.getInputMail().sendKeys(MAIL_NOT_COOPERATE);
        Assertions.elementShouldBeVisible(HINT_MAIL_COOPER);
        Assertions.elementShouldHaveText(HINT_MAIL_COOPER, TEXT_HINT_MAIL_COOPER);
    }

    @Step
    private void enterName(String name) {
        el.getInputName().sendKeys(name);
    }

    private String makeUniqName() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss SSS");
        String date = java.time.LocalTime.now().format(dtf);
        return NAME + date;
    }

    @Step
    private void checkTheBoxNda() {
        Warp.clickUntouchable(el.getCheckBoxProtect(), -27, 0);
    }

    @Step
    private void enterValidPhone() {
        el.getInputPhone().sendKeys(PHONE_VALID);
        Assert.assertTrue(el.getInputPhone().isDisplayed());
    }

    @Step
    private void sendRequest() {
        el.getButtonSendReq().click();
        Warp.delay(2);
    }

    @Step
    private void closeSuccessWindow(String expectedUrl) {
        success.checkAndClose();
        Assert.assertEquals(expectedUrl, Warp.currentURL());
    }

    @Step
    private void enterCooperateMail() {
        el.getInputMail().sendKeys(MAIL_COOPERATE);
        Assert.assertTrue(el.getInputMail().isDisplayed());
    }

    @Step
    private void emptyInputRequest() {
        Assert.assertFalse(el.getAskPhone().exists());
        Assert.assertFalse(el.getAskMail().exists());
        el.getButtonSendReq().click();
        Warp.delay(2);
        Assert.assertEquals(el.getAskPhone().getText(), TEXT_ASK_PHONE);
        Assert.assertEquals(el.getAskMail().getText(), TEXT_ASK_MAIL);
        Assert.assertEquals(el.getAskPhone().getAttribute("class"), errorMessageAttribute);
        Assert.assertEquals(el.getAskMail().getAttribute("class"), errorMessageAttribute);
    }

    @Step
    private void closeReqWindow(String expectedUrl) {
        el.getButtonCloseReqWindow().click();
        Assert.assertEquals(expectedUrl, Warp.currentURL());
    }

    @Step
    private void enterInvalidMail() {
        el.getInputMail().sendKeys(MAIL_INVALID);
        el.getInputPhone().click();
        Assert.assertEquals(el.getAskMail().getText(), TEXT_ASK_MAIL);
        Assert.assertEquals(el.getAskMail().getAttribute("class"), errorMessageAttribute);
    }

    @Step
    private void enterInvalidPhone() {
        el.getInputPhone().sendKeys(PHONE_INVALID);
        el.getInputName().click();
        Warp.delay(1);
        Assert.assertEquals(el.getAskPhone().getText(), TEXT_ASK_PHONE);
        Assert.assertEquals(el.getAskPhone().getAttribute("class"), errorMessageAttribute);
    }

    private void recordIsPresentDb(final String name, final boolean NDA) {//NDA=true - box checked
        if (name == null) Assert.fail(errorMessage);
        final String QUERY = "SELECT * FROM `form_data` WHERE `email` = '"
                + ((NDA) ? FormData.MAIL_NOT_COOPERATE : FormData.MAIL_COOPERATE)
                + "' AND `name`='" + name + "'  AND `message` LIKE '%"
                + ((NDA) ? "NDA - on" : "NDA - off")
                + "%' AND `date` BETWEEN \n" +
                "DATE_SUB(NOW(), INTERVAL 1 DAY) AND NOW() ORDER BY `id` DESC LIMIT 30";
        Db db = new Db();
        Assert.assertTrue(db.recordIsPresent(QUERY, 300));
    }

    private void emailSentDb(final String name1, final String name2) {
        if (name1 == null & name2 == null) Assert.fail(errorMessage);//для этой нам нужно хоть одно имя в базе
        String name = (name1 != null) ? name1 : name2;//если не упали выше, то одно не нулл
        final String QUERY = "SELECT * FROM `form_data` \n" +
                "WHERE (`email` = 'qaands+3@gmail.com' OR `email` = 'qaands@andersenlab.com') \n" +
                "AND `name`='" + name + "' AND `notifyTo` LIKE '%email - ok%' \n" +
                "AND `date` BETWEEN DATE_SUB(NOW(), INTERVAL 1 DAY) AND NOW() ORDER BY `id` DESC LIMIT 30";
        Db db = new Db();
        Assert.assertTrue(db.recordIsPresent(QUERY, 300));
    }

    @Step
    private void linkPhone(Country country) {
        Warp.checkLinkThisTab(el.getLinkPhone(), getLinkPhoneHref(country));
    }

    @Step
    private void linkMail() {
        Warp.checkLinkThisTab(el.getLinkMail(), LINK_MAIL_HREF);
    }
}

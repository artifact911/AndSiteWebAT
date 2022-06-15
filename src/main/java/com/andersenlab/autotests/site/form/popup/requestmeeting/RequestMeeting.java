package com.andersenlab.autotests.site.form.popup.requestmeeting;

import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.db.webdb.Db;
import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.form.commonforms.FormData;
import com.andersenlab.autotests.site.form.successwindow.Success;
import com.andersenlab.autotests.site.form.successwindow.SuccessPoor;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.time.format.DateTimeFormatter;

@Getter
public class RequestMeeting implements FormData, RequestMeetingLocators {
    private RequestMeetingElements el = new RequestMeetingElements();
    private Success success = new SuccessPoor();
    private String title  = "Request a meeting";;
    private String currentUrl;
    private String uniqName = null;
    private Country country = Country.UA;//значение по умолчанию
    private Pages page = Pages.HOMEPAGE;//переопределяется сеттером

    //контракт------------------------------------------------------------------------------------------------------------------------------------------

    public void setConditions(final Pages page, final Country country) {
        //вызывать в beforeClass после prepare(page, country);
        this.country = country;
        this.page = page;
        currentUrl = Warp.currentURL();
    }

    public void requestMeetingPopUpDisplaying() {
       displayingWindowReqAttributes(country);
       linksPrivacyTermsCursorReaction();
       linkPrivacyPolicy();
       linkTerms();
    }


    public void linkPhoneMail() {
        //Переход по ссылкам поп-апа
        linkPhone(country);
        linkMail();
    }

    public void requestMeetingFieldsValidation() {
       inputEmptyRequest();
       inputInvalidMail();
    }

    public void requestMeetingSendMessage() {
        uniqName =makeUniqName();
       enterCooperateMail(uniqName);
    }

    public void dbRecord() {
       recordIsPresentDb(uniqName);
    }

    public void requestMeetingClosingWindow() {
       closeReqWindow(currentUrl);
    }

    //контракт------------------------------------------------------------------------------------------------------------------------------------------

    @Step
    private void displayingWindowReqAttributes(Country country) {
        Assert.assertEquals(title, el.getTitleWindowReq().getAttribute("innerText"));

        Assert.assertEquals(el.getLinkPhone().getAttribute("href"), getLinkPhoneHref(country));
        el.getLinkPhoneSVG().shouldBe(Condition.visible);
        el.getLinkPhone().shouldBe(Condition.visible);
        el.getLinkPhone().shouldHave(Condition.text(getLinkPhoneText(country)));

        Assert.assertEquals(el.getLinkMail().getAttribute("href"), LINK_MAIL_HREF);
        el.getLinkMailSVG().shouldBe(Condition.visible);
        el.getLinkMail().shouldBe(Condition.visible);
        el.getLinkMail().shouldHave(Condition.text(TEXT_LINK_MAIL));


        Assert.assertEquals(el.getInputName().getAttribute("placeholder"), "Name");
        Assert.assertEquals(el.getInputMail().getAttribute("placeholder"), "Phone or Corporate E-mail");
        Assert.assertEquals(el.getInputComment().getAttribute("placeholder"), "Describe your request");

        el.getButtonSend().shouldBe(Condition.visible);
        el.getButtonSend().shouldHave(Condition.text(TEXT_BUTTON_SEND_REQ));

        el.getCaptcha().shouldBe(Condition.visible);
        el.getCaptcha().shouldHave(Condition.text(TEXT_CAPTCHA));
    }

    @Step
    private void linksPrivacyTermsCursorReaction() {
        Assert.assertEquals(el.getLinkPrivacyPolicy().getCssValue("border-color"), PRIVATE_POLICY_TERMS_NOT_HOVERED_COLOR);
        Assert.assertEquals(el.getLinkPrivacyPolicy().hover().getCssValue("border-color"), PRIVATE_POLICY_TERMS_HOVERED_COLOR);
        Assertions.mouseIsPointer(LINK_PRIVACY_POLICY);
        Assert.assertEquals(el.getLinkTerms().getCssValue("border-color"), PRIVATE_POLICY_TERMS_NOT_HOVERED_COLOR);
        Assert.assertEquals(el.getLinkTerms().hover().getCssValue("border-color"), PRIVATE_POLICY_TERMS_HOVERED_COLOR);
        Assertions.mouseIsPointer(LINK_TERMS);
    }

    @Step
    private void linkPrivacyPolicy() {
        Warp.checkLinkNewTab(el.getLinkPrivacyPolicy(), PRIVACY_POLICY_HREF);
    }

    @Step
    private void linkTerms() {
        Warp.checkLinkNewTab(el.getLinkTerms(), TERMS_HREF);
    }

    @Step
    private void linkPhone(Country country) {
        Warp.checkLinkThisTab(el.getLinkPhone(), getLinkPhoneHref(country));
    }

    @Step
    private void linkMail() {
        Warp.checkLinkThisTab(el.getLinkMail(), LINK_MAIL_HREF);
    }

    @Step
    private void inputEmptyRequest() {
        Assert.assertEquals(el.getAskMailPhone().getAttribute("class"), "control");
        el.getButtonSend().click();
        Assert.assertEquals(el.getAskMailPhone().getAttribute("data-error-message"), TEXT_ASK_MAIL_PHONE);
        Assert.assertEquals(el.getAskMailPhone().getAttribute("class"), "control field_error");
    }

    @Step
    private void inputInvalidMail() {
        el.getInputMail().sendKeys(MAIL_INVALID);
        Assert.assertTrue(el.getInputMail().isDisplayed());
        el.getButtonSend().click();
        Warp.delay(1);
        Assert.assertEquals(el.getAskMailPhone().getAttribute("data-error-message"), TEXT_ASK_MAIL_PHONE);
        Assert.assertEquals(el.getAskMailPhone().getAttribute("class"), "control field_error");
    }

    private String makeUniqName() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss SSS");
        String date = java.time.LocalTime.now().format(dtf);
        return NAME + date;
    }

    @Step
    private void enterCooperateMail(String name) {
        el.getInputMail().sendKeys(MAIL_COOPERATE);
        Assert.assertTrue(el.getInputMail().isDisplayed());
        el.getInputName().sendKeys(name);
        el.getButtonSend().click();
        success.checkAndClose();
    }

    @Step
    private void recordIsPresentDb(String name) {
        if (name == null) Assert.fail("precondition not met");
        final String QUERY = "SELECT * FROM `form_data` WHERE `email` = '" + MAIL_COOPERATE + "' AND `name`='" + name + "'  AND `message` LIKE '%NDA - off%' AND `date` BETWEEN \n" +
                "DATE_SUB(NOW(), INTERVAL 1 DAY) AND NOW() ORDER BY `id` DESC LIMIT 30";
        Db db = new Db();
        Assert.assertTrue(db.recordIsPresent(QUERY, 300));
    }

    @Step
    public void closeReqWindow(String expectedUrl) {
        el.getButtonCloseReqWindow().click();
        Assert.assertFalse(Warp.isElementPresent(TITLE_REQ));
        Assert.assertEquals(expectedUrl, Warp.currentURL());
        Selenide.refresh();
        doBefore();
        Warp.clickUntouchable(el.getButtonSend(), -140, 0);
        Assert.assertFalse(Warp.isElementPresent(TITLE_REQ));
        doBefore();
        el.getButtonSend().sendKeys(Keys.ESCAPE);
        Assert.assertFalse(Warp.isElementPresent(TITLE_REQ));
    }

    @Step
    public void precondition() {
        doBefore();
    }
}

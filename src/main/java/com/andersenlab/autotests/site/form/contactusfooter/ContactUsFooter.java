package com.andersenlab.autotests.site.form.contactusfooter;

import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.db.webdb.Db;
import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.form.spam.Spamable;
import com.andersenlab.autotests.site.form.commonforms.FormData;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.format.DateTimeFormatter;

@Getter
public class ContactUsFooter implements FormData, CUFooterLocators, Spamable {
    private CUFooterElements el = new CUFooterElements();

    @Step
    public void displayAll() {
        //top
        el.getTitle().should(Condition.visible);
        el.getTitle().should(Condition.text(TEXT_TITLE));
        //left
        el.getLinkSkype().should(Condition.visible);
        el.getLinkWhatsApp().should(Condition.visible);
        el.getLinkTelegram().should(Condition.visible);
        el.getLinkLinked().should(Condition.visible);
        el.getLinkFb().should(Condition.visible);

        el.getLinkPhone().should(Condition.visible);
        el.getLinkMail().should(Condition.visible);
        el.getLinkPhoneSvg().should(Condition.visible);
        el.getLinkMailSvg().should(Condition.visible);

        el.getAddressHQ().should(Condition.visible);
        el.getAddressHQ().should(Condition.text(TEXT_ADDRESS_HQ));
        el.getAddressRO().should(Condition.visible);
        el.getAddressRO().should(Condition.text(TEXT_ADDRESS_RO));
        //centre
        el.getCityKyiv().should(Condition.visible);
        el.getCityVilnius().should(Condition.visible);
        //right
        Assert.assertEquals(el.getInputName().getAttribute("placeholder"), "Name");
        Assert.assertEquals(el.getInputMail().getAttribute("placeholder"), "Corporate E-mail");
//        Assert.assertEquals(el.getInputPhone().getAttribute("placeholder"), "Phone");
        Assert.assertEquals(el.getInputComment().getAttribute("placeholder"), "Comments");
        el.getCheckBoxProtect().should(Condition.visible);
        el.getCheckBoxProtectI().should(Condition.visible);
        el.getCheckBoxProtectI().click();
        el.getCheckBoxProtectIPopup().should(Condition.visible);
        el.getCheckBoxProtectIPopup().should(Condition.text(TEXT_CHECKBOX_TO_PROTECT_I));
        el.getButtonCloseCheckBoxProtectIPopup().click();
        el.getButtonSend().should(Condition.visible);
        //bottom
        el.getCopyright().should(Condition.visible);
        el.getCopyright().should(Condition.text(TEXT_COPYRIGHT));
        el.getCaptcha().should(Condition.visible);
        el.getCaptcha().should(Condition.text(TEXT_CAPTCHA));
    }

    @Step
    public void sendButtonHovered() {
        Assert.assertEquals(el.getButtonSend().getCssValue("text-decoration"), "none solid rgb(2, 3, 3)");
        Assert.assertEquals(el.getButtonSend().hover().getCssValue("text-decoration"), "none solid rgb(2, 3, 3)");
        Assertions.mouseIsPointer(BUTTON_SEND_REQ);
    }

    @Step
    public void hoverPointer() {
        Assert.assertEquals(el.getLinkSkype().getCssValue("background"), "rgba(255, 255, 255, 0.1) none repeat scroll 0% 0% / auto padding-box border-box");
        Assert.assertNotEquals(el.getLinkSkype().hover().getCssValue("background"), "rgba(255, 255, 255, 0.1) none repeat scroll 0% 0% / auto padding-box border-box");
        Assertions.mouseIsPointer(LINK_SKYPE);
        Assert.assertEquals(el.getLinkWhatsApp().getCssValue("background"), "rgba(255, 255, 255, 0.1) none repeat scroll 0% 0% / auto padding-box border-box");
        Assert.assertNotEquals(el.getLinkWhatsApp().hover().getCssValue("background"), "rgba(255, 255, 255, 0.1) none repeat scroll 0% 0% / auto padding-box border-box");
        Assertions.mouseIsPointer(LINK_WHATSAPP);
        Assert.assertEquals(el.getLinkTelegram().getCssValue("background"), "rgba(255, 255, 255, 0.1) none repeat scroll 0% 0% / auto padding-box border-box");
        Assert.assertNotEquals(el.getLinkTelegram().hover().getCssValue("background"), "rgba(255, 255, 255, 0.1) none repeat scroll 0% 0% / auto padding-box border-box");
        Assertions.mouseIsPointer(LINK_TELEGRAM);
        Assert.assertEquals(el.getLinkLinked().getCssValue("background"), "rgba(0, 0, 0, 0) none repeat scroll 0% 0% / auto padding-box border-box");
        Assert.assertNotEquals(el.getLinkLinked().hover().getCssValue("background"), null);
        Assertions.mouseIsPointer(LINK_LINKED);
        Assert.assertEquals(el.getLinkFb().getCssValue("background"), "rgba(0, 0, 0, 0) none repeat scroll 0% 0% / auto padding-box border-box");
        Assert.assertNotEquals(el.getLinkFb().hover().getCssValue("background"), null);
        Assertions.mouseIsPointer(LINK_FB);
        Assert.assertEquals(el.getLinkPhone().getCssValue("color"), "rgba(255, 255, 255, 1)");
        Assert.assertEquals(el.getLinkPhone().hover().getCssValue("color"), "rgba(254, 218, 0, 1)");
        Assertions.mouseIsPointer(LINK_PHONE);
        Assert.assertEquals(el.getLinkMail().getCssValue("color"), "rgba(255, 255, 255, 1)");
        Assert.assertEquals(el.getLinkMail().hover().getCssValue("color"), "rgba(254, 218, 0, 1)");
        Assertions.mouseIsPointer(LINK_MAIL);
        Assert.assertFalse(el.getCityKyiv().getAttribute("class").contains("active"));
        Assert.assertTrue(el.getCityKyiv().hover().getAttribute("class").contains("active"));
        Assert.assertFalse(el.getCityVilnius().getAttribute("class").contains("active"));
        Assert.assertTrue(el.getCityVilnius().hover().getAttribute("class").contains("active"));
        Assert.assertEquals(el.getLinkPrivacyPolicy().getCssValue("border-color"), PRIVATE_POLICY_TERMS_NOT_HOVERED_COLOR);
        Assert.assertEquals(el.getLinkPrivacyPolicy().hover().getCssValue("border-color"), PRIVATE_POLICY_TERMS_HOVERED_COLOR);
        Assertions.mouseIsPointer(LINK_PRIVACY_POLICY);
        Assert.assertEquals(el.getLinkTerms().getCssValue("border-color"), PRIVATE_POLICY_TERMS_NOT_HOVERED_COLOR);
        Assert.assertEquals(el.getLinkTerms().hover().getCssValue("border-color"), PRIVATE_POLICY_TERMS_HOVERED_COLOR);
        Assertions.mouseIsPointer(LINK_TERMS);
    }

    @Step
    public void linkCheck(){
        Warp.checkLinkNewTab(el.getLinkSkype(), LINK_SKYPE_HREF);
        Warp.checkLinkNewTab(el.getLinkWhatsApp(), LINK_WHATSAPP_HREF);
        Warp.checkLinkThisTab(el.getLinkTelegram(), LINK_TELEGRAM_HREF);
        Warp.checkLinkNewTab(el.getLinkLinked(), LINK_LINKED_HREF);
        Warp.checkLinkNewTab(el.getLinkFb(), LINK_FB_HREF);

        Warp.checkLinkNewTab(el.getLinkPrivacyPolicyAndersen(), PRIVATE_POLICY_ANDERSEN_LINK);
        Warp.checkLinkNewTab(el.getLinkPrivacyPolicy(), PRIVACY_POLICY_HREF);
        Warp.checkLinkNewTab(el.getLinkTerms(), TERMS_HREF);
    }


    @Step
    public void linkPhoneMail(Country country) {
        Warp.checkLinkNewTab(el.getLinkPhone(), getLinkPhoneHref(country));
        Warp.checkLinkThisTab(el.getLinkMail(), LINK_MAIL_HREF);

    }

    @Step
    public void enterNotCooperateMail() {
        el.getInputMail().sendKeys(MAIL_NOT_COOPERATE);
        Assertions.elementShouldBeVisible(HINT_MAIL_COOPER);
        Assertions.elementShouldHaveText(HINT_MAIL_COOPER, TEXT_HINT_MAIL_COOPER);
    }

    @Step
    public void enterName(String name) {
        el.getInputName().sendKeys(name);
    }

    public String makeUniqName() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss SSS");
        String date = java.time.LocalTime.now().format(dtf);
        return NAME + date;
    }

    @Step
    public void checkTheBoxNda() {
        Warp.clickUntouchable(el.getCheckBoxProtect(), -27, 0);
    }

    @Step
    public void enterValidPhone() {
        el.getInputPhone().sendKeys(PHONE_VALID);
        Assert.assertTrue(el.getInputPhone().isDisplayed());
    }

    @Step
    public void sendRequest() {
        el.getButtonSend().click();
        Assertions.elementShouldBeVisible(WINDOW_SUCCESS);
        Assertions.elementShouldHaveText(WINDOW_SUCCESS, TEXT_TITLE_SUCCESS);
    }

    @Step
    public void closeSuccessWindow(String expectedUrl) {
        Assertions.elementShouldBeVisible(WINDOW_SUCCESS);
        el.getButtonCloseSuccessWindow().click();
        Assertions.elementShouldNotBeVisible(WINDOW_SUCCESS);
        Assert.assertEquals(expectedUrl, Warp.currentURL());
    }

    @Step
    public void enterCooperateMail() {
        el.getInputMail().sendKeys(MAIL_COOPERATE);
        Assert.assertTrue(el.getInputMail().isDisplayed());
    }

    @Step
    public void emptyInputRequest() {
        Assert.assertEquals(el.getAskPhone().getAttribute("class"), "control");
        Assert.assertEquals(el.getAskMail().getAttribute("class"), "control");
        el.getButtonSend().click();
        Assert.assertEquals(el.getAskPhone().getAttribute("data-error-message"), TEXT_ASK_PHONE);
        Assert.assertEquals(el.getAskPhone().getAttribute("class"), "control field_error");
        Assert.assertEquals(el.getAskMail().getAttribute("data-error-message"), TEXT_ASK_MAIL);
        Assert.assertEquals(el.getAskMail().getAttribute("class"), "control field_error");
    }

    @Step
    public void enterInvalidMail() {
        el.getInputMail().sendKeys(MAIL_INVALID);
        el.getInputPhone().click();
        Assert.assertEquals(el.getAskMail().getAttribute("data-error-message"), TEXT_ASK_MAIL);
        Assert.assertEquals(el.getAskMail().getAttribute("class"), "control field_error");
    }

    @Step
    public void enterInvalidPhone() {
        el.getInputPhone().sendKeys(PHONE_INVALID);
        el.getInputName().click();
        Assert.assertEquals(el.getAskPhone().getAttribute("data-error-message"), TEXT_ASK_PHONE);
        Assert.assertEquals(el.getAskPhone().getAttribute("class"), "control field_error");
    }

    @Step
    public void recordIsPresentDb(String name) {
        if (name == null) Assert.fail("precondition not met");
        final String QUERY = "SELECT * FROM `form_data` WHERE `email` = 'qaands+3@gmail.com' AND `name`='" + name + "'  AND `message` LIKE '%NDA - on%' AND `date` BETWEEN \n" +
                "DATE_SUB(NOW(), INTERVAL 1 DAY) AND NOW() ORDER BY `id` DESC LIMIT 30";
        Db db = new Db();
        Assert.assertTrue(db.recordIsPresent(QUERY, 300));
    }

    @Step
    private void gallery() {
        String highlighted = "photo-gallery__secondary-slide photo-gallery__wrapper track__wrapper-image js-wrapper-image photo-gallery__image_loaded js-active-wrapper";
        String def = "photo-gallery__secondary-slide photo-gallery__wrapper track__wrapper-image js-wrapper-image js-active-wrapper photo-gallery__image_loaded";
        String unHighlighted = "photo-gallery__secondary-slide photo-gallery__wrapper track__wrapper-image js-wrapper-image photo-gallery__image_loaded";
        String firstPhoto = el.getPhotoMainGallery().getAttribute("src");
        el.getPhotoMainGallery().isDisplayed();
        Assert.assertEquals(el.getOrdinalGallery().getAttribute("innerText"), "1");
        Assert.assertTrue(el.getPhotoPrev1Gallery().getAttribute("class").contains("active"));
        Assert.assertFalse(el.getPhotoPrev2Gallery().getAttribute("class").contains("active"));

        el.getPhotoMainGallery().click();
        String secondPhoto = el.getPhotoMainGallery().getAttribute("src");
        el.getPhotoMainGallery().isDisplayed();
        Assert.assertNotEquals(firstPhoto, secondPhoto);
        Assert.assertEquals(el.getOrdinalGallery().getAttribute("innerText"), "2");
        Assert.assertTrue(el.getPhotoPrev2Gallery().getAttribute("class").contains("active"));
        Assert.assertFalse(el.getPhotoPrev1Gallery().getAttribute("class").contains("active"));

        el.getButtonPrevGallery().click();
        el.getPhotoMainGallery().isDisplayed();
        Assert.assertEquals(firstPhoto, el.getPhotoMainGallery().getAttribute("src"));
        Assert.assertEquals(el.getOrdinalGallery().getAttribute("innerText"), "1");
        Assert.assertTrue(el.getPhotoPrev1Gallery().getAttribute("class").contains("active"));
        Assert.assertFalse(el.getPhotoPrev2Gallery().getAttribute("class").contains("active"));

        el.getButtonNextGallery().click();
        el.getPhotoMainGallery().isDisplayed();
        Assert.assertEquals(secondPhoto, el.getPhotoMainGallery().getAttribute("src"));
        Assert.assertEquals(el.getOrdinalGallery().getAttribute("innerText"), "2");

        el.getButtonPrevGallery().click();
        el.getPhotoPrev2Gallery().click();
        el.getPhotoMainGallery().isDisplayed();
        Assert.assertEquals(secondPhoto, el.getPhotoMainGallery().getAttribute("src"));
        Assert.assertEquals(el.getOrdinalGallery().getAttribute("innerText"), "2");
        el.getButtonCloseGallery().click();
    }

    @Step
    public void galleryK() {
        Warp.clickUntouchable(el.getCityKyiv(), 0, 0);
        Warp.delay(3);
        Assert.assertTrue(el.getWindowGallery().isDisplayed());
        Assert.assertEquals(el.getTitleGallery().getAttribute("innerText"), "Our office in Kyiv");
        gallery();
    }

    @Step
    public void galleryV() {
        Warp.clickUntouchable(el.getCityVilnius(), 0, 0);
        Warp.delay(3);
        Assert.assertTrue(el.getWindowGallery().isDisplayed());
        Assert.assertEquals(el.getTitleGallery().getAttribute("innerText"), "Our office in Vilnius");
        gallery();
    }

    @Step
    public void checkSuccessWindow() {
        el.getWindowSuccess().shouldBe(Condition.visible);
        el.getTitleSuccessWindow().shouldHave(Condition.text(TEXT_TITLE_SUCCESS));
    }

    public String goodReq(String mail, String phone) {
        el.getInputMail().sendKeys(mail);
        el.getInputPhone().sendKeys(phone);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss SSS");
        String date = java.time.LocalTime.now().format(dtf);
        String uniqName = Spamable.NAME_BASE + date;
        el.getInputName().sendKeys(uniqName);
        if (Spamable.CHECK_BOX) checkTheBoxNda();
        el.getButtonSend().click();
        el.getButtonCloseSuccessWindow().click();
        return uniqName;
    }

    public void precondition() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        Actions action = new Actions(driver);
        action.moveToElement(el.getButtonSend()).build().perform();
    }

}




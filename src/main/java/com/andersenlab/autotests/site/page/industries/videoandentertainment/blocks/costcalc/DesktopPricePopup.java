package com.andersenlab.autotests.site.page.industries.videoandentertainment.blocks.costcalc;

import com.andersenlab.autotests.core.configs.constants.CSSProperties.TextDecoration;
import com.andersenlab.autotests.core.configs.constants.CSSProperties.Animation;
import com.andersenlab.autotests.core.configs.constants.CSSProperties.Color;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.Google;
import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.form.commonforms.FormData;
import com.andersenlab.autotests.site.form.successwindow.Success;
import com.andersenlab.autotests.site.form.successwindow.SuccessRich;
import com.andersenlab.autotests.site.page.services.salesforce.blocks.costcalculator.CalcPopupGift;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class DesktopPricePopup implements FormData {
    DesktopPricePopupLocators locators = new DesktopPricePopupLocators();
    DesktopPricePopupData data = new DesktopPricePopupData();
    Success success;

    private final SelenideElement btn;
    private final SelenideElement title = $(locators.getTITLE());
    private final SelenideElement close = $(locators.getCLOSE_BTN());
    private final ElementsCollection tags = $$(locators.getTAGS());

    private final SelenideElement nameField = $(locators.getNAME());
    private final SelenideElement mailField = $(locators.getMAIL());
    private final SelenideElement phoneField = $(locators.getPHONE());
    private final SelenideElement commentsField = $(locators.getCOMMENTS());

    private final SelenideElement NDAtext = $(locators.getNDA_LABEL());
    private final SelenideElement NDAhintBtn = $(locators.getNDA_I());
    private final SelenideElement NDAhintPopup = $(locators.getNDA_POPUP());
    private final SelenideElement NDAhintCloseBtn = $(locators.getNDA_POPUP_CLOSE_BTN());

    private final SelenideElement sendBtn = $(locators.getSEND_BTN());
    private final SelenideElement giftMsg = $(locators.getGIFT_MESSAGE());

    private final SelenideElement recaptchaText = $(locators.getRECAPTCHA_TEXT());
    private final SelenideElement privacyLink = $(locators.getPRIVACY_LINK());
    private final SelenideElement termsLink = $(locators.getTERMS_LINK());

    private final CalcPopupGift gift;


    private final List<String> expectedTags;
    private final String expectedTitle = data.getTitle();
    private final String expectedGiftMessage = data.getGiftMsg();

    public DesktopPricePopup(List<String> expectedTags, SelenideElement btn, Country country){
        this.expectedTags = expectedTags;
        this.btn = btn;
        this.success = new SuccessRich(country);
        gift = new CalcPopupGift();
    }

    public void checkPopup(){
        formCheck();
        formFill();
        formSend();
        mailCheck();
    }

    private void formCheck(){
        checkCloseBtn();
        checkTitle();
        checkTags();
        checkFormElements();
        checkNDA();
        checkGiftMsg();
        checkRECAPTCHA();
    }

    private void formFill(){
        nameField.sendKeys(NAME);
        Assert.assertTrue(nameField.isDisplayed());
        Assert.assertEquals(nameField.getAttribute("value"), NAME);

        mailField.sendKeys(MAIL_COOPERATE);
        Assert.assertTrue(mailField.isDisplayed());
        Assert.assertEquals(mailField.getAttribute("value"), MAIL_COOPERATE);

        phoneField.sendKeys(PHONE_VALID);
        Assert.assertTrue(phoneField.isDisplayed());
        Assert.assertEquals(phoneField.getAttribute("value"), "+101324657980");

        commentsField.sendKeys(data.getComment());
        Assert.assertTrue(commentsField.isDisplayed());
        Assert.assertEquals(commentsField.getAttribute("value"), data.getComment());
    }

    private void formSend(){
        sendBtn.click();
        success.checkAndClose();
    }

    private void mailCheck(){
        /**not realized*/
    }

    private void checkCloseBtn(){
        btn.click();
        if (gift.visible()) {
            gift.close();
        }
        Assert.assertTrue(title.isDisplayed());
        close.click();
        Assert.assertFalse(title.isDisplayed());
        btn.click();
        if (gift.visible()) {
            gift.close();
        }
        Assert.assertTrue(title.isDisplayed());
    }

    private void checkTitle(){
        Assert.assertEquals(title.getText(), expectedTitle);
    }

    private void checkTags(){
        Assert.assertEquals(tags.size(), expectedTags.size());
        for (int index=0; index<tags.size(); index++){
            Assert.assertEquals(tags.get(index).getText(), expectedTags.get(index));
            Assert.assertEquals(tags.get(index).getCssValue("background-color"), Color.GRAY.getCode());
            tags.get(index).hover();
            Wait().until(ExpectedConditions.attributeToBe(tags.get(index),"background-color", Color.YELLOW.getCode()));
            Assert.assertEquals(tags.get(index).getCssValue("background-color"), Color.YELLOW.getCode());
        }
        tags.get(0).click();
        Assert.assertEquals(tags.size(), expectedTags.size()-1);
    }

    private void checkFormElements(){
        Assert.assertEquals(nameField.getAttribute("placeholder"), "Name");
        Assert.assertEquals(mailField.getAttribute("placeholder"), "Corporate E-mail");
        Assert.assertEquals(phoneField.getAttribute("value"), "+375"); // TODO: сделать адаптивную проверку кода страны
        Assert.assertEquals(commentsField.getAttribute("placeholder"), "Leave your comments");
    }

    private void checkNDA(){
        Assertions.mouseIsPointer(NDAhintBtn);
        Assert.assertEquals(NDAtext.getText(), data.getNDA());
        Assert.assertFalse(NDAhintPopup.isDisplayed());
        NDAhintBtn.click();
        Assert.assertEquals(NDAhintPopup.getText(), data.getNDAhint());
        Assertions.mouseIsPointer(NDAhintCloseBtn);
        NDAhintCloseBtn.click();
        Assert.assertFalse(NDAhintPopup.isDisplayed());
    }

    private void checkGiftMsg(){
        Assert.assertEquals(giftMsg.getText(), expectedGiftMessage);
    }

    private void checkRECAPTCHA(){
        Assert.assertEquals(privacyLink.getCssValue("text-decoration"), TextDecoration.BLACK_UNDERLINE.getCode());
        Assert.assertEquals(privacyLink.hover().getCssValue("animation"), Animation.DEFAULT.getCode());
        Assertions.mouseIsPointer(privacyLink);
        Assert.assertEquals(termsLink.getCssValue("text-decoration"), TextDecoration.BLACK_UNDERLINE.getCode());
        Assert.assertEquals(termsLink.hover().getCssValue("animation"), Animation.DEFAULT.getCode());
        Assertions.mouseIsPointer(termsLink);
        Assert.assertEquals(privacyLink.getAttribute("href"), Google.expectedPrivacyLink);
        Assert.assertEquals(termsLink.getAttribute("href"), Google.expectedTermsLink);
        Assert.assertEquals(recaptchaText.getText().replaceAll(" ", ""), Google.expectedRECAPTCHAText.replaceAll(" ", ""));
    }
}

class DesktopPricePopupLocators {
    private final String BASE = "//section[contains(@class,'ResultModalDesktop-module--container')]";

    @Getter private final By CLOSE_BTN = By.xpath(BASE + "//button[contains(@class,'close')]");
    @Getter private final By TITLE = By.xpath(BASE + "//h4");
    @Getter private final By TAGS = By.xpath(BASE + "//button[contains(@class,'tag')]");

    @Getter private final By NAME = By.xpath(BASE + "//input[@name='name']");
    @Getter private final By MAIL = By.xpath(BASE + "//input[@name='email']");
    @Getter private final By PHONE = By.xpath(BASE + "//input[@name='phone']");
    @Getter private final By COMMENTS = By.xpath(BASE + "//textarea[@name='message']");

    @Getter private final By NDA_LABEL = By.xpath(BASE + "//div[contains(@class,'nda')]//div[@class='font-size-sm']");
    @Getter private final By NDA_CHECKBOX = By.xpath(BASE + "");
    @Getter private final By NDA_I = By.cssSelector("form#calc-form-effective svg use");
    @Getter private final By NDA_POPUP = By.cssSelector("span.react-tooltip-lite div.hint-module--text--39o4y");
    @Getter private final By NDA_POPUP_CLOSE_BTN = By.cssSelector("span.react-tooltip-lite svg");

    @Getter private final By SEND_BTN = By.xpath(BASE + "//button[contains(@class, 'sendButton')]");
    @Getter private final By GIFT_MESSAGE = By.xpath(BASE + "//button[contains(@class, 'sendButton')]/following-sibling::div");
    @Getter private final By RECAPTCHA_TEXT = By.xpath(BASE + "//article[contains(@class,'captcha')]");
    @Getter private final By PRIVACY_LINK = By.xpath(BASE + "//article[contains(@class,'captcha')]//a[1]");
    @Getter private final By TERMS_LINK = By.xpath(BASE + "//article[contains(@class,'captcha')]//a[2]");
}

@Getter
class DesktopPricePopupData{
    private final String title = "Please, leave your contact details to receive the quote";
    private final String NDA = "I want to protect my data by signing an NDA.";
    private final String NDAhint = "Before we discuss any details about your project you can request to sign a Non Disclosure Agreement";
    private final String giftMsg = "Two weeks at no costs*";
    private final String comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
}
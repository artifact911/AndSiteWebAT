package com.andersenlab.autotests.site.page.services.augmentation.modal.requestspqcialist;

import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import lombok.Getter;
import org.testng.Assert;

import java.util.Set;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class RequestSpecialistModal implements RequestSpecialistModalLocators {

    private final SelenideElement modalWindow = $(MODAL_WINDOW);
    private final SelenideElement modalWindowCloseButton = $(MODAL_WINDOW_CLOSE);
    private final SelenideElement sendRequestButton = $(SEND_REQUEST_BUTTON);
    private final SelenideElement phoneNumberLink = $(PHONE_NUMBER_LINK);
    private final SelenideElement eMailLink = $(EMAIL_LINK);
    private final SelenideElement toolType = $(TOOLTYPE);
    private final SelenideElement toolTypeText = $(TOOLTYPE_TEXT);
    private final SelenideElement toolTypeTextCloseButton = $(TOOLTYPE_TEXT_CLOSE);
    private final SelenideElement checkBox = $(CHECK_BOX);
    private final SelenideElement checkBoxIsSelected = $(CHECK_BOX_isSELECTED);
    private final SelenideElement privacyPolicyLink = $(PRIVACY_POLICY_LINK);
    private final SelenideElement termsOfServiceLink = $(TERMS_OF_SERVICE_LINK);

    @Step
    public void checkHoverAndPointerSendReqBtn() {
        waitVisible(sendRequestButton);
        checkHoverAndPointer(sendRequestButton, "background");
    }

    @Step
    public void checkToolType() {
        checkHoverAndPointer(toolType, "color");
        toolType.click();
        waitVisible(toolTypeText);
        Assert.assertTrue(toolTypeText.isDisplayed());
        toolTypeTextCloseButton.click();
        Assert.assertFalse(toolTypeText.isDisplayed());
    }

    @Step
    public void checkCheckBox() {
        waitVisible(checkBox);
        checkBox.click();
        Assert.assertTrue(checkBoxIsSelected.isSelected());
        checkBox.click();
        Assert.assertFalse(checkBox.isSelected());
    }

    @Step
    public void checkReCaptchaLink() {
        waitVisible(privacyPolicyLink);
        checkHoverAndPointer(privacyPolicyLink, "color");
        waitVisible(termsOfServiceLink);
        checkHoverAndPointer(termsOfServiceLink, "color");
        Warp.openTargetLinkAndCheckUrl(privacyPolicyLink);
        Warp.openTargetLinkAndCheckUrl(termsOfServiceLink);
    }

    private void checkHoverAndPointer(SelenideElement el, String attribute) {
        waitVisible(el);
        Warp.checkHoverElement(el, attribute);
        Warp.mouseIsPointer(el);
    }

    private void waitVisible(SelenideElement el) {
        el.waitUntil(Condition.visible, 5000, 1000);
    }
}

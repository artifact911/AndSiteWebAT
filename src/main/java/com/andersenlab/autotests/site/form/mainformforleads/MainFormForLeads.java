package com.andersenlab.autotests.site.form.mainformforleads;

import com.andersenlab.autotests.core.configs.constants.CSSProperties;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;

import java.util.Objects;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class MainFormForLeads {

    private final SelenideElement modalWindow = $(By.xpath("//div[contains(@class, 'Modal-module--container')]"));
    private final SelenideElement titleOfModalWindow = $(By.xpath("//h3[contains(@class, 'requestConsultation-module')]"));
    private final SelenideElement emailField = $(By.xpath("//form[@id='request-consultation']//input[@placeholder='Corporate E-mail']"));
    private final SelenideElement emailTooltipV2 = $(By.xpath("//section[contains(@class, 'tooltip-module')]"));
    private final SelenideElement emailTooltip = $(By.cssSelector("#request-consultation > div:nth-child(1) > div.forms-module--fieldWrapperTwo--26OtI section"));
    private final SelenideElement tipUnderThePhoneNumberField = $(By.xpath("//p[text()='Please, enter your phone number']"));
    private final SelenideElement phoneField = $(By.xpath("//form[@id='request-consultation']//input[@placeholder='Phone']"));
    private final SelenideElement ndaTooltipIcon = $(By.xpath("//form[@id='request-consultation']//div[contains(@class, 'Hint-module--wrapper-')]/*[name()='svg']"));
    private final SelenideElement ndaTooltip = $(By.xpath("//div[contains(@class, 'Hint-module--content')]"));
    private final SelenideElement ndaTooltipClose = $(By.xpath("//div[contains(@class, 'Hint-module--content')]/*[name()='svg']"));
    private final SelenideElement checkbox = $(By.xpath("//form[@id='request-consultation']//div[contains(@class, 'forms-module--nda')]"));
    private final SelenideElement selectedCheckbox = $(By.xpath("//form[@id='request-consultation']//input[@name='nda']"));
    private final SelenideElement sendRequestButton = $(By.xpath("//form[@id='request-consultation']//button"));
    private final SelenideElement successfulModalWindow = $(By.xpath("//div[contains(@class, 'Modal-module--container')]"));
    private final SelenideElement successfulModalWindowText = $(By.xpath("//p[contains(@class, 'SuccessModal-module')]"));
    private final SelenideElement successfulModalWindowCloseButton = $(By.xpath("//button[contains(@class, 'close-button')]"));
    @Getter
    private final SelenideElement buttonInMainModule = $(By.xpath("//div[contains(@class,'Feature-module')]//button[contains(@class, 'button-module')]"));
    @Getter
    private final SelenideElement buttonInIntroModule = $(By.xpath("//div[contains(@class, 'TitleWith-module--container')]//button[contains(@class, 'button-module')]"));

    private final String notCorporateEmail = "qaands@gmail.com";
    private final String emailTooltipText = "For industry-based consultancy, a corporate email is preferred.";
    private final String tipUnderThePhoneNumberFieldText = "Please, enter your phone number";
    private final String phoneNumber = "121234567";
    private final String ndaTooltipText = "Before we discuss any details about your project you can request to sign a Non Disclosure Agreement";
    private final String successfulText = "Thank you for your interest!\n" + "\n" + "We will contact you ASAP!";

    private void moveAndClickCustomWaiters(SelenideElement el) {
        try {
            Warp.scrollToElement(el);
            el.waitUntil(enabled, 7000, 1000).click();
        } catch (ElementClickInterceptedException e) {
            Warp.forceClick(el);
        }
    }

    @Step
    public void scrollToButtonAndCheckTitle(SelenideElement button, String title) {
            try {
                Warp.scrollToElement(button.shouldBe(Condition.visible));
                button.click();
            } catch (ElementNotFound | StaleElementReferenceException e) {
                refresh();
                moveAndClickCustomWaiters(button);
        }
        modalWindow.shouldBe(Condition.visible);
        titleOfModalWindow.shouldBe(Condition.visible);
        Assert.assertEquals(titleOfModalWindow.getText(), title);
    }

    @Step
    public void checkEmailField() {
        actions().moveToElement(emailField).click().sendKeys(notCorporateEmail).perform();
        try {
            emailTooltip.shouldBe(Condition.visible).shouldHave(Condition.exactText(emailTooltipText));
        } catch (ElementNotFound e) {
            if (Objects.equals(emailField.getAttribute("value"), "")) {
                moveAndClickCustomWaiters(emailField);
                actions().moveToElement(emailField).click().sendKeys(notCorporateEmail).perform();
                emailTooltipV2.shouldBe(Condition.visible).shouldHave(Condition.exactText(emailTooltipText));
            } else moveAndClickCustomWaiters(emailField);
            emailTooltipV2.shouldBe(Condition.visible).shouldHave(Condition.exactText(emailTooltipText));
        }
        tipUnderThePhoneNumberField.shouldBe(Condition.visible).shouldHave(Condition.exactText(tipUnderThePhoneNumberFieldText));
        Assert.assertEquals(tipUnderThePhoneNumberField.getCssValue("color"), CSSProperties.Color.YELLOW.getCode());
    }

    @Step
    public void checkPhoneField() {
        actions().moveToElement(phoneField).click().sendKeys(phoneNumber).perform();
        Assert.assertFalse(tipUnderThePhoneNumberField.isDisplayed());
    }

    @Step
    public void checkNda() {
        ndaTooltipIcon.click();
        ndaTooltip.shouldBe(Condition.visible).shouldHave(Condition.exactText(ndaTooltipText));
        ndaTooltipClose.click();
        checkbox.click();
        Assert.assertTrue(selectedCheckbox.isSelected());
    }

    @Step
    public void sendFormAndCheckSuccessfulModalWindow() {
        sendRequestButton.click();
        successfulModalWindow.shouldBe(Condition.visible);
        successfulModalWindowText.shouldBe(Condition.visible).shouldHave(Condition.exactText(successfulText));
        successfulModalWindowCloseButton.click();
        Assert.assertFalse(successfulModalWindow.isDisplayed());
    }
}
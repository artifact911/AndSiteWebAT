package com.andersenlab.autotests.site.page.services.augmentation.calculator;

import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import static com.andersenlab.autotests.site.page.services.augmentation.calculator.CalculatorElements.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import io.qameta.allure.Step;
import lombok.Getter;

@Getter
public class Calculator implements CalculatorLocators {

    CalculatorElements el = new CalculatorElements();

    protected static void moveAndClick(SelenideElement el) {
        try {
            Warp.scrollToElement(el);
            actions().moveToElement(el.waitUntil(enabled, 7000, 1000)).click().perform();
        } catch (ElementClickInterceptedException | ElementNotFound e) {
            Warp.forceClick(el);
        }
    }

    private static void waitDisabled(SelenideElement el) {
        el.waitUntil(disabled, 5000, 1000);
    }

    private static int intHandler(String text) {
        int actualNumber = Integer.parseInt(text.replaceAll("[^0-9]", ""));
        return actualNumber;
    }

    @Step
    public void checkYourDevelopmentTeamBlock() {
        checkClPointers();
        checkToolTips();
        checkAdditionButtonFirstBlock();
        checkReduceButtonFirstBlock();
        checkPopUpDeletion();
    }

    @Step
    public void checkYouMayAlsoIncludeBlock() {
        checkButtonSecondBlock();
    }

    @Step
    public void checkBusinessIndustryBlock() {
        checkBusinessDomain();
    }

    @Step
    public void durationOfYourProjectBlock() {
        checkDurationOfYourProjectDefaultValues();
        checkDurationOfYourProjectNineMonth();
        checkDurationOfYourProjectOneYear();
        checkDurationOfYourProject23Month();
        checkDurationOfYourProjectTwoYears();
        checkButtonGetPrice();
    }

    @Step
    public void checkSendFormBlock() {
        checkClickSendForm();
        checkGetPriceButton();
        checkToolTipNearSendFormButton();
        checkRecapthaRefs();
    }

    protected void checkClPointers() {
        Assertions.mouseIsPointer(el.plusButton);
        Assertions.mouseIsPointer(el.minusButton);
        Warp.mouseIsPointer(el.clearAll);
    }

    protected void checkToolTips() {
        moveAndClick(el.jsToolTip);
        el.jsToolTipInfo.shouldBe(visible);
        moveAndClick(el.rubyToolTip);
        el.rubyToolTipInfo.shouldBe(visible);
        moveAndClick(el.angularToolTip);
        el.angularToolTipInfo.shouldBe(visible);
    }

    protected void checkAdditionButtonFirstBlock() {
        moveAndClick(el.javaPlusButton);
        int actualValue = Integer.parseInt(el.javaCounter.getAttribute("value"));
        Assert.assertEquals(actualValue, 1);

        String text = el.javaPopUp.shouldBe(visible).getText();
        Assert.assertEquals(intHandler(text), 1);

        el.javaHighLight.shouldBe(visible);
        moveAndClick(el.javaMinusButton);
    }

    protected void checkReduceButtonFirstBlock() {
        moveAndClick(el.javaPlusButton);
        Warp.forceClick(el.javaMinusButton);
        int actualValue = Integer.parseInt(el.javaCounter.getAttribute("value"));
        Assert.assertEquals(actualValue, 0);
        el.javaPopUp.shouldBe(hidden);
        waitDisabled(el.javaHighLight);
    }

    protected void checkButtonSecondBlock() {
        Warp.scrollToElement(el.pmPlusButton);
        Warp.forceClick(el.pmPlusButton);
        int actualValue = Integer.parseInt(el.pmCounter.getAttribute("value"));
        Assert.assertEquals(actualValue, 1);

        el.pmPopUp.shouldBe(visible);
        String text = el.pmPopUp.getText();
        Assert.assertEquals(intHandler(text), 1);

        Warp.forceClick(el.pmMinusButton);
        int actualValue2 = Integer.parseInt(el.pmCounter.getAttribute("value"));
        Assert.assertEquals(actualValue2, 0);
        el.pmPopUp.shouldBe(hidden);
    }

    protected void checkBusinessDomain() {
        moveAndClick(el.fsRadioButton);
        String actualColor = Color.fromString(el.fsRadioButton.getCssValue("border-color")).asHex();
        Assert.assertEquals(actualColor, yellowColor);

        el.fsPopUp.shouldBe(visible);
        Assert.assertEquals(el.fsPopUp.getText(), "Financial Services");

        Warp.forceClick(el.telecomRadioButton);
        String colorIsMissing = el.fsRadioButton.getCssValue("border-color");
        String missingColor = Color.fromString(colorIsMissing).asHex();
        Assert.assertEquals(missingColor, greyColor);
        moveAndClick(el.telecomClosePopUp);
    }

    protected void checkDurationOfYourProjectDefaultValues() {
        Warp.scrollToElement(el.getPriceButton);
        int defaultValue = Integer.parseInt(el.durationLine.getAttribute("aria-valuenow"));
        Assert.assertEquals(defaultValue, 6);
        el.durationLinePopUp.shouldBe(hidden);
    }

    protected void checkDurationOfYourProjectNineMonth() {
        moveAndClick(el.durationLine9Month);
        el.durationLinePopUp.shouldBe(visible);

        el.durationLineCloud.shouldBe(visible);
        String numberOfMonth = el.durationLineCloud.getText();
        Assert.assertEquals(intHandler(numberOfMonth), 9);

        String text = el.durationLinePopUp.getText();
        Assert.assertEquals(intHandler(text), 9);

        String attributeValue = el.durationLineColorTrack.getAttribute("style");
        String attributeValue2 = attributeValue.substring(attributeValue.lastIndexOf("width: ") + 7);
        int yellowLineWidth = Integer.parseInt(attributeValue2.substring(0, attributeValue2.indexOf("%")));
        Assert.assertEquals(yellowLineWidth, 36);
    }

    protected void checkDurationOfYourProjectOneYear() {
        Warp.scrollToElement(el.getPriceButton);
        moveAndClick(el.durationLine1Year);
        el.durationLineCloud.shouldBe(visible);
        String numberOfMonth = el.durationLineCloud.getText();
        Assert.assertEquals(intHandler(numberOfMonth), 12);
    }

    protected void checkDurationOfYourProject23Month() {
        moveAndClick(el.durationLine23Month);
        el.durationLineCloud.shouldBe(visible);
        el.durationLinePopUp.shouldBe(visible);
        String text = el.durationLinePopUp.getText();
        Assert.assertEquals(intHandler(text), 23);
    }

    protected void checkDurationOfYourProjectTwoYears() {
        moveAndClick(el.durationLine2Years);
        String numberOfMonth = el.durationLineCloud.shouldBe(visible).getText();
        Assert.assertEquals(intHandler(numberOfMonth), 24);

        String text = el.durationLinePopUp.shouldBe(visible).getText();
        Assert.assertEquals(intHandler(text), 24);
        moveAndClick(el.durationLinePopUp);
    }

    protected void checkButtonGetPrice() {
        Warp.scrollToElement(el.forScrollToMaps);
        Warp.mouseIsPointer(el.getPriceButton);
    }

    protected void checkClickSendForm() {
        Warp.scrollToElement(el.clearAll);
        moveAndClick(el.javaPlusButton);
        Warp.scrollToElement(el.pmPlusButton.shouldBe(enabled));
        Warp.forceClick(el.pmPlusButton);

        moveAndClick(el.getPricePopUp);
        el.sendForm.shouldBe(visible);
        Warp.mouseIsPointer(el.crossButton);
        moveAndClick(el.crossButton);
        el.sendForm.shouldBe(hidden);
        moveAndClick(el.javaPopUpExactOne);
        moveAndClick(el.pmPopUp);
    }

    protected void checkGetPriceButton() {
        moveAndClick(el.getPriceButton);
        el.sendForm.shouldBe(visible);
        moveAndClick(el.crossButton.shouldBe(enabled));
    }

    protected void checkPopUpDeletion() {
        moveAndClick(el.javaPlusButton);
        Warp.forceClick(el.pmPlusButton);
        Warp.scrollToElement(el.getPriceButton.shouldBe(visible));

        moveAndClick(el.javaPopUpExactOne);
        el.javaPopUpExactOne.shouldBe(hidden);
        moveAndClick(el.pmPopUp);
        el.pmPopUp.shouldBe(hidden);
    }

    protected void checkToolTipNearSendFormButton() {
        Warp.scrollToElement(el.bottomPageText);
        Warp.scrollToElement(el.toolTipNearSendForm.shouldBe(visible));
        Warp.mouseIsPointer(el.toolTipNearSendForm);
        moveAndClick(el.toolTipNearSendForm.shouldBe(enabled));
        el.toolTipNearSendFormInfo.shouldBe(visible);

        moveAndClick(el.ndaCheckBox);
        el.toolTipNearSendFormInfo.shouldBe(hidden);

        moveAndClick(el.ndaCheckBox);
        String colorMiss = el.ndaCheckBox.getAttribute("background-color");
        Assert.assertNull(colorMiss);
    }

    protected void checkRecapthaRefs() {
        Warp.scrollToElement(PL_REF);
        Warp.mouseIsPointer(PL_REF);
        Warp.scrollToElement(TERMS_REF);
        Warp.mouseIsPointer(TERMS_REF);
        String mainTitle = Warp.tabTitle();

        Warp.openNewTab(el.plRef.shouldBe(visible));

        Assert.assertNotEquals(Warp.tabTitle(), mainTitle);
        Selenide.closeWindow();

        switchTo().window(0);
        Warp.openNewTab(el.termsRef.shouldBe(visible));
        Assert.assertNotEquals(Warp.tabTitle(), mainTitle);
        Selenide.closeWindow();
        switchTo().window(0);
    }
}

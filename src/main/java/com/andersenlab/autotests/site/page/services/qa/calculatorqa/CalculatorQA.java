package com.andersenlab.autotests.site.page.services.qa.calculatorqa;

import com.andersenlab.autotests.core.configs.constants.CSSProperties;
import com.andersenlab.autotests.core.db.DbConnectionActual;
import com.andersenlab.autotests.site.form.contactusfooterform.ContactUsFooterForm;
import com.andersenlab.autotests.site.page.services.augmentation.calculator.Calculator;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;

import java.sql.SQLException;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.refresh;

public class CalculatorQA extends Calculator {

    CalculatorQAElements el = new CalculatorQAElements();
    ContactUsFooterForm contactUsFooterForm = new ContactUsFooterForm();

    @Step
    public void preparationForModalWindow() {
        Warp.scrollToElement(el.getWebButton());
        moveAndClick(el.getWebButton());
        moveAndClick(el.getSmokeButton());
        moveAndClick(el.getGetPricePopUp());
    }

    @Step
    public void checkPositiveEmailNonCorporate() {
        el.getBase().shouldBe(visible);
        actions().moveToElement(el.getNameField().shouldBe(visible)).click().sendKeys(contactUsFooterForm.getValidUserName()).perform();
        actions().moveToElement(el.getEmailField().shouldBe(visible)).click().sendKeys(el.getNotCorporateEmail()).perform();
        el.getEmailToolTip().shouldBe(visible).shouldHave(exactText(el.getEmailTooltipText()));
        el.getTipUnderPhone().shouldBe(visible).shouldHave(exactText(el.getTipUnderThePhoneNumberFieldText()));
        Assert.assertEquals(el.getTipUnderPhone().getCssValue("color"), CSSProperties.Color.BRIGHT_LIGHT_YELLOW.getCode());

        actions().moveToElement(el.getPhoneField()).click().sendKeys(el.getPhoneNumber()).perform();
        Assert.assertFalse(el.getTipUnderPhone().isDisplayed());

        moveAndClick(el.getNdaButton());
        moveAndClick(el.getSendButton());
        el.getSuccessModalWindow().shouldBe(visible);
        el.getSuccessModalWindowText().shouldBe(visible).shouldHave(exactText(el.getSuccessfulText()));
        moveAndClick(el.getSuccessModalWindowClose());
        el.getSuccessModalWindow().shouldBe(hidden);
        refresh();
    }

    @Step
    public void checkPositiveEmailCorporate() {
        el.getBase().shouldBe(visible);
        actions().moveToElement(el.getNameField().shouldBe(visible)).click().sendKeys(contactUsFooterForm.getValidUserName()).perform();
        actions().moveToElement(el.getEmailField().shouldBe(visible)).click().sendKeys(el.getCorporateEmail()).perform();
        el.getEmailToolTip().shouldBe(hidden);
        el.getTipUnderPhone().shouldBe(hidden);

        actions().moveToElement(el.getPhoneField()).click().sendKeys(el.getPhoneNumber()).perform();
        Assert.assertFalse(el.getTipUnderPhone().isDisplayed());

        moveAndClick(el.getSendButton());
        el.getSuccessModalWindow().shouldBe(visible);
        el.getSuccessModalWindowText().shouldBe(visible).shouldHave(exactText(el.getSuccessfulText()));
        moveAndClick(el.getSuccessModalWindowClose());
        el.getSuccessModalWindow().shouldBe(hidden);
    }

    @Step
    public void checkNegativeEmailWithoutCreds() {
        el.getBase().shouldBe(visible);
        moveAndClick(el.getSendButton());
        el.getTipUnderEmail().shouldBe(visible).shouldHave(exactText(el.getTipUnderEmailField()));
        Assert.assertEquals(el.getTipUnderEmail().getCssValue("color"), CSSProperties.Color.BRIGHT_LIGHT_YELLOW.getCode());

        el.getTipUnderPhone().shouldBe(visible).shouldHave(exactText(el.getTipUnderThePhoneNumberFieldText()));
        Assert.assertEquals(el.getTipUnderPhone().getCssValue("color"), CSSProperties.Color.BRIGHT_LIGHT_YELLOW.getCode());

        actions().moveToElement(el.getEmailField().shouldBe(visible)).click().sendKeys(el.getInvalidEmail()).perform();
        moveAndClick(el.getPhoneField());
        refresh();
    }

    @Step
    public void checkNegativeEmailWithCreds() {
        el.getBase().shouldBe(visible);
        actions().moveToElement(el.getEmailField().shouldBe(visible)).click().sendKeys(el.getInvalidEmail()).perform();
        moveAndClick(el.getPhoneField());

        el.getTipUnderEmail().shouldBe(visible).shouldHave(exactText(el.getTipUnderEmailField()));
        Assert.assertEquals(el.getTipUnderEmail().getCssValue("color"), CSSProperties.Color.BRIGHT_LIGHT_YELLOW.getCode());
        refresh();
    }

    @Step
    public void checkLongNegativePhone() {
        el.getBase().shouldBe(visible);
        actions().moveToElement(el.getPhoneField().shouldBe(visible)).click().sendKeys(el.getInvalidLongPhoneNumber()).perform();
        String limitedValue = "+375" + el.getInvalidLongPhoneNumber().substring(0, 14);
        Assert.assertEquals(el.getPhoneField().getAttribute("value"),limitedValue);
    }

    @Step
    public void ndaCheckDBPositive() throws SQLException {
        DbConnectionActual.openConnection(el.getUrl(), el.getUser(), el.getPassword());
        ArrayList<String> list = new ArrayList<>(DbConnectionActual.selectRecords(DbConnectionActual.createSelectQuery(el.getQuery())));
        String stringValue = list.get(4).substring(list.get(4).length() - 5);
        boolean ndaValue = Boolean.parseBoolean(stringValue.trim());
        Assert.assertTrue(ndaValue);
    }

    @Step
    public void ndaCheckDBNegative() throws SQLException {
        DbConnectionActual.openConnection(el.getUrl(), el.getUser(), el.getPassword());
        ArrayList<String> list = new ArrayList<>(DbConnectionActual.selectRecords(DbConnectionActual.createSelectQuery(el.getQuery())));
        String stringValue = list.get(4).substring(list.get(4).length() - 5);
        boolean ndaValue = Boolean.parseBoolean(stringValue.trim());
        Assert.assertFalse(ndaValue);
    }
}


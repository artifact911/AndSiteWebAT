package com.andersenlab.autotests.site.page.services.augmentation.modal.requestspqcialist;

import org.openqa.selenium.By;

public interface RequestSpecialistModalLocators {

    String MODAL_PATH = "//div[@id='___gatsby']/section/div/div";
    String LINKS = "//h3[contains(text(), 'Request specialist')]/../div/a";
    String TOOL_TEXT_PATH = "//div[contains(@class, 'hint-module--text--39o4y')]";

    By MODAL_WINDOW = By.xpath(MODAL_PATH);
    By MODAL_WINDOW_CLOSE = By.xpath(MODAL_PATH + "//button[not(text())]");
    By SEND_REQUEST_BUTTON = By.xpath("//form[@id='request-consultation']//button");
    By PHONE_NUMBER_LINK = By.xpath(LINKS + "[1]");
    By EMAIL_LINK = By.xpath(LINKS + "[2]");
    By TOOLTYPE = By.xpath("//*[@id='request-consultation']//*[@class='hint-module--icon--2-3NE']");
    By TOOLTYPE_TEXT = By.xpath(TOOL_TEXT_PATH);
    By TOOLTYPE_TEXT_CLOSE = By.xpath(TOOL_TEXT_PATH + "/../*[2]");
    By CHECK_BOX = By.xpath(MODAL_PATH + "//*[@class='checkbox-module--checkbox--3fXL1 forms-module--ndaCheckbox--33MxF']");
    By PRIVACY_POLICY_LINK = By.xpath(MODAL_PATH + "//a[contains(text(), 'Privacy Policy')]");
    By TERMS_OF_SERVICE_LINK = By.xpath(MODAL_PATH + "//a[contains(text(), 'Terms of Service')]");

    /**
     * юзать для проверки состояния чекбокса
     * для физического клика юзать CHECK_BOX
     */
    By CHECK_BOX_isSELECTED = By.xpath(MODAL_PATH + "//*[@class='checkbox-module--input--3jt-P']");
}


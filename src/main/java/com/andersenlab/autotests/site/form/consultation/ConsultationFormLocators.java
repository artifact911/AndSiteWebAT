package com.andersenlab.autotests.site.form.consultation;

import org.openqa.selenium.By;

public interface ConsultationFormLocators {
    String BASE = "//form[@id='attach-form']/..";

    By TITLE = By.xpath(BASE + "//*[contains(@class, 'title') and not(contains(@class, 'subtitle'))]");
    By SUBTITLE = By.xpath(BASE + "//p[contains(@class, 'subtitle')]");
    By INPUT_NAME = By.xpath(BASE + "//input[@name='name']");
    By INPUT_MAIL = By.xpath(BASE + "//input[@name='email']");
    By INPUT_PHONE = By.xpath(BASE + "//input[@name='phone']");
    By INPUT_COMMENT = By.xpath(BASE + "//textarea[@name='message']");
    By CHECKBOX_TO_PROTECT = By.xpath(BASE + "//label[contains(@class, 'checkbox')]");
    By CHECKBOX_TO_PROTECT_TEXT = By.xpath(BASE + "//label[contains(@class, 'checkbox')]//span[contains(@class, 'Text')]");
    By BUTTON_SEND_REQ = By.xpath(BASE + "//button[contains(@class, 'send')]");
    By NDA_HINT_TEXT = By.xpath("//div[contains(@class, 'hint-module--text')]");
    By NDA_CLOSE_BTN = By.cssSelector("span.react-tooltip-lite div>svg");
    By NDA_OPEN_HINT = By.cssSelector("form#attach-form div.hint-module--wrapper--jyTiU > svg >use");
    By HINT_MAIL_COOPER = By.xpath(BASE + "//input[@name='email']//..//..//section[contains(@class, 'tooltip')]");
    By ASK_PHONE = By.xpath(BASE + "//input[@name='phone']//..//..//p[contains(@class, 'forms-module--error')]");
    By ASK_MAIL = By.xpath(BASE + "//input[@name='email']//..//..//p[contains(@class, 'forms-module--error')]");
    By PRIVACY_POLICY = By.xpath(BASE + "//a[contains(@href, 'privacy')]");
    By TERMS_OF_SERVICE = By.xpath(BASE + "//a[contains(@href, 'terms')]");
}

package com.andersenlab.autotests.site.page.services.qa.calculatorqa;

import org.openqa.selenium.By;

public interface CalculatorQALocators {
    String baseString = "//div[contains(@class, 'Modal-module--content')]";
    By EMAIL_FIELD = By.xpath(baseString + "//input[@name='email']");
    By NAME_FIELD = By.xpath(baseString + "//input[@name='name']");
    By NDA_TOOL_TIP = By.xpath(baseString + "//div[contains(@class, 'hint-module--wrapper')]");
    By EMAIL_TOOL_TIP = By.xpath("//section[contains(@class, 'tooltip-module')]");
    By TIP_UNDER_PHONE = By.xpath("//p[contains(@class, 'forms-module--error') and contains(text(), 'phone')]");
    By TIP_UNDER_EMAIL = By.xpath("//p[contains(@class, 'forms-module--error') and contains(text(), 'email')]");
    By PHONE_FIELD = By.xpath(baseString +"//input[@name='phone']");
    By NDA_BUTTON = By.xpath(baseString + "//span[contains(@class, 'Checkbox-module')]");
    By SEND_BUTTON = By.xpath(baseString + "//button[contains(@class, 'button-module--size')]");
    By SUCCESS_MODAL_WINDOW = By.xpath("//div[contains(@class, 'Modal-module--content')]");
    By SUCCESS_MODAL_WINDOW_TEXT = By.xpath("//p[contains(@class, 'SuccessModal-module')]");
    By SUCCESS_MODAL_WINDOW_CLOSE = By.xpath("//button[contains(@class, 'close-button')]");

    By WEB_BUTTON = By.xpath("//div[contains(text(), 'Web')]/../span");
    By SMOKE_BUTTON = By.xpath("//div[contains(text(), 'Smoke')]/../span");
    By GET_PRICE_POP_UP_BUTTON = By.xpath("//button[contains(@class, 'PreviewModal')]");
}

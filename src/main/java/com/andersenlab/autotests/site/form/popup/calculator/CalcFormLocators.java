package com.andersenlab.autotests.site.form.popup.calculator;

import com.andersenlab.autotests.site.utility.Warp;
import org.openqa.selenium.By;

public interface CalcFormLocators {

    default void doBefore() {
        //сроллимся к кнопке "Get price"
        Warp.scrollToElement("//section[contains(@class, 'container-module--container')]//button[contains(text(), 'Get price')]");
        //нажимаем
        Warp.clickSimple("//section[contains(@class, 'container-module--container')]//button[contains(text(), 'Get price')]");
        //временно, попап с подарками
        Warp.clickSimpleIfPresent("//section[contains(@class, 'gift')]//button[contains(@class, 'close')]");
    }

    String BASE = "//section[contains(@class, 'ResultModalDesktop-module--container')]";

    By WINDOW_REQ = By.xpath(BASE);
    By TITLE_REQ = By.xpath(BASE + "/div/h4[contains(@class, 'title')]");

    By LINK_PHONE = By.xpath(BASE + "//a[contains(@href, 'tel:+')]");
    By LINK_MAIL = By.xpath(BASE + "//a[contains(@href, 'mailto:')]");

    By BUTTON_CLOSE_REQ_WINDOW = By.xpath(BASE + "//button[contains(@class, 'close-button')]");

    By INPUT_NAME = By.xpath(BASE + "//input[@name='name']");
    By INPUT_MAIL = By.xpath(BASE + "//input[@name='email']");
    By INPUT_PHONE = By.xpath(BASE + "//input[@name='phone']");
    By INPUT_COMMENT = By.xpath(BASE + "//textarea[@name='message']");
    By BUTTON_SEND = By.xpath(BASE + "//button[@type='submit']");

    By HINT_MAIL_COOPER = By.xpath(BASE + "//section[contains(@class,'tooltip-module')]");
    By ASK_PHONE = By.xpath(BASE + "//input[@name='phone']//..//../p");
    By ASK_MAIL = By.xpath(BASE + "//input[@name='email']//..//../p");

    By CHECKBOX_TO_PROTECT = By.xpath(BASE + "//label[contains(@class, 'checkbox')]");
    By CHECKBOX_TO_PROTECT_I = By.cssSelector("#form-footer > div.nda-signature.white-text > div > div > div > svg"); //By.xpath(BASE + "//label[contains(@class, 'checkbox')]/following-sibling::div/div/*");
    String TEXT_CHECKBOX_TO_PROTECT_I = "Before we discuss any details about your project you can request to sign a Non Disclosure Agreement";
    By CHECKBOX_TO_PROTECT_I_POPUP = By.xpath("//div[@class='popup-info js-popup-tooltip']");
    By BUTTON_CLOSE_CHECKBOX_TO_PROTECT_I_POPUP =  By.xpath("//div[@class='popup-info js-popup-tooltip']/*[3]");

    By CAPTCHA = By.xpath(BASE + "//p[contains(@class,'captcha')]");
    By LINK_PRIVACY_POLICY = By.xpath(BASE + "//a[contains(@href, 'privacy')]");
    By LINK_TERMS = By.xpath(BASE + "//a[contains(@href, 'terms')]");


}

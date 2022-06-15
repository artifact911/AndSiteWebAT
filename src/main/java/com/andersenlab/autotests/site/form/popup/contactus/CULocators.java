package com.andersenlab.autotests.site.form.popup.contactus;

import org.openqa.selenium.By;

/**
 * https://devblog.andersenlab.com/uk/
 *  qaands@gmail.com
 */
public interface CULocators {
    String BASE = "//div[@id='popup_feedback' and contains(@class, 'active')]";
    //top
    By TITLE = By.xpath(BASE + "//div[@class='popup__title h3']");
    String TEXT_TITLE = "Contact us";
    By BUTTON_CLOSE = By.xpath(BASE + "//span[contains(@class, 'close')]");
    //left
    By LINK_PHONE = By.xpath(BASE + "//a[contains(@href, 'tel:+')]");
    By LINK_MAIL = By.xpath(BASE + "//a[contains(@href, 'mailto:')]");
    By LINK_PHONE_SVG = By.xpath(BASE + "//a[contains(@href, 'tel:+')]/*[1]");
    By LINK_MAIL_SVG = By.xpath(BASE + "//a[contains(@href, 'mailto:')]/*[1]");
    By ASK_PHONE = By.xpath(BASE + "//input[@name='phone']//..");
    By ASK_MAIL = By.xpath(BASE + "//input[@name='email']//..");

    By TITLE_HQ = By.xpath(BASE + "//div[contains(@class, 'our-contacts_footer')]/h3");
    String TEXT_TITLE_HQ = "Headquarters";
    By ADDRESS_HQ = By.xpath(BASE + "//span[@class='our-contacts__contact-inner']");
    String TEXT_ADDRESS_HQ = "\n                            75 Zhylianska Street, Floor 3, Eurasia Business                            Center, Kyiv, Ukraine                        ";
    By TITLE_RO = By.xpath(BASE + "//div[@class='our-contacts']/h3");
    String TEXT_TITLE_RO = "Headquarters";
    By ADDRESS_RO = By.xpath(BASE + "//div[@class='our-contacts']/p");
    String TEXT_ADDRESS_RO = "\n                        Laisves pr. 60-1107, LT-05120 Vilnius, Lithuania\n                    ";

    By LINK_SKYPE = By.xpath(BASE + "//a[contains(@href, 'skype')]");
    By LINK_WHATSAPP = By.xpath(BASE + "//a[contains(@href, 'whatsapp')]");
    By LINK_TELEGRAM = By.xpath(BASE + "//a[contains(@href, 'tg://resolve')]");
    By LINK_LINKED = By.xpath(BASE + "//a[contains(@href, 'linkedin')]");
    By LINK_FB = By.xpath(BASE + "//a[contains(@href, 'facebook.com')]");
    //right
    By BUTTON_SEND = By.xpath(BASE + "//button[contains(@class, 'submit')]");
    By INPUT_NAME = By.xpath(BASE + "//input[@name='name']");
    By INPUT_MAIL = By.xpath(BASE + "//input[@name='email']");
    By INPUT_PHONE = By.xpath(BASE + "//input[@name='phone']");
    By INPUT_COMMENT = By.xpath(BASE + "//textarea[@name='message']");
    By CHECKBOX_TO_PROTECT = By.xpath(BASE + "//label[contains(@class, 'checkbox')]");
    By CHECKBOX_TO_PROTECT_I = By.cssSelector("#form-feedback > div.nda-signature > div > div > div > svg");
    String TEXT_CHECKBOX_TO_PROTECT_I = "Before we discuss any details about your project you can request to sign a Non Disclosure Agreement";
    By CHECKBOX_TO_PROTECT_I_POPUP = By.xpath("//div[@class='popup-info js-popup-tooltip']"); //"/html/body/div[10]"
    By BUTTON_CLOSE_CHECKBOX_TO_PROTECT_I_POPUP =  By.cssSelector("body > div.popup-info.js-popup-tooltip > svg");
    By HINT_MAIL_COOPER = By.xpath(BASE + "//input[@name='email']//..//p[contains(@class, 'popup-info__text')]");
    //success
    String BASE_SUCCESS = "//div[@id='popup-success' and contains(@class, 'active')]";
    By WINDOW_SUCCESS = By.xpath(BASE_SUCCESS);
    By BUTTON_CLOSE_SUCCESS_WINDOW = By.xpath(BASE_SUCCESS + "//span[contains(@class, 'close')]");
    By TITLE_SUCCESS = By.xpath(BASE_SUCCESS + "//p");

    By CONTACT_US_BUTTON = By.xpath("//*[@id='menu-bottom']/ul/li[4]/button");

    By CAPTCHA = By.xpath("//p[contains(@class, 'captcha')]");
    String TEXT_CAPTCHA = "\n                This site is protected by reCAPTCHA and the Google                ";

    By LINK_PRIVACY_POLICY = By.xpath(BASE + "//a[contains(@href, 'google.com/privacy')]");
    By LINK_TERMS = By.xpath(BASE + "//a[contains(@href, 'google.com/terms')]");
}

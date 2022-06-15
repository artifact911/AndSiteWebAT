package com.andersenlab.autotests.site.form.contactusfooter;

import org.openqa.selenium.By;

/**
 * https://devblog.andersenlab.com/uk/
 * qaands@gmail.com
 */
public interface CUFooterLocators {
    String BASE_SECTION = "//section[@id='contact-us']";
    //top
    By TITLE = By.xpath(BASE_SECTION + "/h2");
    String TEXT_TITLE = "Contact us";
    //left
    By LINK_SKYPE = By.xpath(BASE_SECTION + "//a[contains(@href, 'skype')]");
    By LINK_WHATSAPP = By.xpath(BASE_SECTION + "//a[contains(@href, 'whatsapp')]");
    By LINK_TELEGRAM = By.xpath(BASE_SECTION + "//a[contains(@href, 'tg://resolve')]");
    By LINK_LINKED = By.xpath(BASE_SECTION + "//a[contains(@href, 'linkedin')]");
    By LINK_FB = By.xpath(BASE_SECTION + "//a[contains(@href, 'facebook.com')]");

    By TITLE_HQ = By.xpath(BASE_SECTION + "//div[contains(@class, 'our-contacts_footer')]/h3");
    String TEXT_TITLE_HQ = "Headquarters";
    By ADDRESS_HQ = By.xpath(BASE_SECTION + "//span[@class='our-contacts__contact-inner']");
    String TEXT_ADDRESS_HQ = "\n                            75 Zhylianska Street, Floor 3, Eurasia Business                            Center, Kyiv, Ukraine                        ";
    By TITLE_RO = By.xpath(BASE_SECTION + "//div[@class='our-contacts']/h3");
    String TEXT_TITLE_RO = "Headquarters";
    By ADDRESS_RO = By.xpath(BASE_SECTION + "//div[@class='our-contacts']/p");
    String TEXT_ADDRESS_RO = "\n                        Laisves pr. 60-1107, LT-05120 Vilnius, Lithuania\n                    ";

    By LINK_PHONE = By.xpath(BASE_SECTION + "//a[contains(@href, 'tel:+')]");
    By LINK_PHONE_SVG = By.cssSelector("#contact-us > div.footer__main.box-md > div.footer__contacts > div.our-contacts.our-contacts_footer > a.footer__phone > svg");
    By LINK_MAIL = By.xpath(BASE_SECTION + "//a[contains(@href, 'mailto:')]");
    By LINK_MAIL_SVG = By.cssSelector("#contact-us > div.footer__main.box-md > div.footer__contacts > div.our-contacts.our-contacts_footer > a.footer__email > svg");

    //centre
    By CITY_KYIV_POINTER = By.cssSelector("#kyivMarker");
    By CITY_VILNIUS_POINTER = By.cssSelector("#vilniusMarker");
    By CITY_KYIV = By.xpath("//*[@id='kyivText']");
    By CITY_VILNIUS = By.xpath("//*[@id='vilnius']");
    //right
    String BASE_FORM = "//form[@id='form-footer']";
    By BUTTON_SEND_REQ = By.xpath(BASE_FORM + "//button[contains(@class,'button')]");
    By INPUT_NAME = By.xpath(BASE_FORM + "//input[@name='name']");
    By INPUT_MAIL = By.xpath(BASE_FORM + "//input[@name='email']");
    By INPUT_PHONE = By.xpath(BASE_FORM + "//input[@name='phone']");
    By INPUT_COMMENT = By.xpath(BASE_FORM + "//textarea[@name='message']"); //дополнить см. ScheduleYourFreeLocators
    By CHECKBOX_TO_PROTECT = By.xpath(BASE_FORM + "//label[contains(@class, 'checkbox')]");
    By CHECKBOX_TO_PROTECT_I = By.cssSelector("#form-footer > div.nda-signature.white-text > div > div > div > svg");
    String TEXT_CHECKBOX_TO_PROTECT_I = "Before we discuss any details about your project you can request to sign a Non Disclosure Agreement";
    By CHECKBOX_TO_PROTECT_I_POPUP = By.xpath("/html/body/div[10]"); //"//div[@class='popup-info js-popup-tooltip']"
    By BUTTON_CLOSE_CHECKBOX_TO_PROTECT_I_POPUP =  By.cssSelector("body > div.popup-info.js-popup-tooltip > svg");
    By HINT_MAIL_COOPER = By.xpath(BASE_FORM + "//input[@name='email']//..//p[contains(@class, 'popup-info__text')]");
    By ASK_PHONE = By.xpath(BASE_FORM + "//input[@name='phone']//..");
    By ASK_MAIL = By.xpath(BASE_FORM + "//input[@name='email']//..");
    //bottom
    By COPYRIGHT = By.xpath("//div[@class='copyright box-md']//div[@class='copyright__column']/span/..");
    String TEXT_COPYRIGHT = "© Copyright 2007-2021 Andersen Software, Inc. All Rights Reserved. Privacy Policy";
    By LINK_PRIVACY_POLICY_ANDERSEN = By.xpath("//div[@class='copyright box-md']//div[@class='copyright__column']/span/..//a[contains(@href, 'dev.andersenlab.com/privacy-policy')]");
    String LINK_PRIVACY_POLICY_ANDERSEN_VALUE = "https://dev.andersenlab.com/privacy-policy";

    By CAPTCHA = By.xpath("//div[@class='copyright__column']/following-sibling::div[@class='copyright__column']");
    String TEXT_CAPTCHA = "\n                This site is protected by reCAPTCHA and the Google                ";

    By LINK_PRIVACY_POLICY = By.xpath("//footer//a[contains(@href, 'google.com/privacy')]");
    By LINK_TERMS = By.xpath("//footer//a[contains(@href, 'google.com/terms')]");
    String LINK_NOT_HOVERED_COLOR = "rgb(255, 255, 255)";
    String LINK_HOVERED_COLOR = "rgb(254, 218, 0)";
    //success
    String BASE_SUCCESS = "//div[@id='popup-success' and contains(@class, 'active')]";
    By WINDOW_SUCCESS = By.xpath(BASE_SUCCESS);
    By BUTTON_CLOSE_SUCCESS_WINDOW = By.xpath(BASE_SUCCESS + "//span[contains(@class, 'close')]");
    By TITLE_SUCCESS = By.xpath(BASE_SUCCESS + "//p");

    String PRIVATE_POLICY_TERMS_NOT_HOVERED_COLOR = "rgb(255, 255, 255)";
    String PRIVATE_POLICY_TERMS_HOVERED_COLOR = "rgb(254, 218, 0)";

    String PRIVATE_POLICY_ANDERSEN_LINK = "https://dev.andersenlab.com/privacy-policy";

    //gallery
    String BASE_GALLERY = "//section[@id='popup-gallery']";
    By WINDOW_GALLERY = By.xpath(BASE_GALLERY + "/div");
    By BUTTON_CLOSE_WINDOW_GALLERY = By.xpath(BASE_GALLERY + "//span[contains(@class, 'popup__close')]");
    By TITLE_WINDOW_GALLERY = By.xpath(BASE_GALLERY +"//h2");

    By PHOTO_WINDOW_GALLERY = By.xpath(BASE_GALLERY + "//img[@class='photo-gallery_full_image']");
    By PHOTO_PREVIEW_1_WINDOW_GALLERY = By.xpath(BASE_GALLERY + "//div[@data-number='0']");
    By PHOTO_PREVIEW_2_WINDOW_GALLERY = By.xpath(BASE_GALLERY + "//div[@data-number='1']");
//    By PHOTOS_PREVIEW = By.xpath(BASE_GALLERY + "//img[@class='photo-gallery__image track__image js-track-image']");//если нужно будет работать со списком фото
    By BUTTON_NEXT_PHOTO_WINDOW_GALLERY = By.xpath(BASE_GALLERY + "//button[contains(@class, 'js-right')]");
    By BUTTON_PREV_PHOTO_WINDOW_GALLERY = By.xpath(BASE_GALLERY + "//button[contains(@class, 'js-left')]");
    By ORDINAL_PHOTO_WINDOW_GALLERY = By.xpath(BASE_GALLERY + "//span[contains(@class, 'js-start-number')]");
}

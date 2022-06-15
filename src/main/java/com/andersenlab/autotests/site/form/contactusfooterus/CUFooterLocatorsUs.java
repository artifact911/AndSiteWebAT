package com.andersenlab.autotests.site.form.contactusfooterus;

import org.openqa.selenium.By;

/**
 * https://devblog.andersenlab.com/uk/
 * qaands@gmail.com
 */
public interface CUFooterLocatorsUs {
    String BASE_SECTION = "//div[@id='contact-us']";
    //top
    By TITLE = By.xpath("//h2[contains(text(), 'Contact us')]");
    String TEXT_TITLE = "Contact us";
    //left
    By LINK_SKYPE = By.xpath(BASE_SECTION + "//a[contains(@href, 'skype')]");
    By LINK_WHATSAPP = By.xpath(BASE_SECTION + "//a[contains(@href, 'whatsapp')]");
    By LINK_TELEGRAM = By.xpath(BASE_SECTION + "//a[contains(@href, 'tg://resolve')]");
    By LINK_LINKED = By.xpath(BASE_SECTION + "//a[contains(@href, 'linkedin')]");
    By LINK_FB = By.xpath(BASE_SECTION + "//a[contains(@href, 'facebook.com')]");

    By TITLE_HQ = By.xpath(BASE_SECTION + "//div[contains(text(), 'Headquarters')]");
    String TEXT_TITLE_HQ = "Headquarters";
    By ADDRESS_HQ = By.xpath(BASE_SECTION + "//p[contains(text(), 'Camelback Rd. Suite D')]");
    String TEXT_ADDRESS_HQ = "\n                                                            Camelback Rd. Suite D,\n                                " + "\n" +
            "                                Office 367 Scottsdale, AZ\n                                                    ";
    By TITLE_RO = By.xpath(BASE_SECTION + "//div[contains(text(), 'Representative office')]");
    String TEXT_TITLE_RO = "Headquarters";
    By ADDRESS_RO = By.xpath(BASE_SECTION + "//p[contains(text(), '445 Park Ave, Manhattan')]");
    String TEXT_ADDRESS_RO = "445 Park Ave, Manhattan,\n10022, New York City, USA";

    By LINK_PHONE = By.xpath(BASE_SECTION + "//a[contains(@href, 'tel:+')]");
    By LINK_PHONE_SVG = By.xpath(BASE_SECTION + "//a[contains(@href, 'tel:+')]/../*[contains(@class, 'svg')]");
    By LINK_MAIL = By.xpath(BASE_SECTION + "//a[contains(@href, 'mailto:')]");
    By LINK_MAIL_SVG = By.xpath(BASE_SECTION + "//a[contains(@href, 'mailto:')]/../*[contains(@class, 'svg')]");

    //centre
    By CITY_KYIV_POINTER = By.cssSelector("#kyiv");
    By CITY_KYIV = By.xpath("//*[@id='kyiv']");

    //right
    String BASE_FORM = "//form[@id='contact']";
    By BUTTON_SEND = By.xpath(BASE_FORM + "//button[contains(@type,'submit')]");
    By INPUT_NAME = By.xpath(BASE_FORM + "//input[@name='name']");
    By INPUT_MAIL = By.xpath(BASE_FORM + "//input[@name='email']");
    By INPUT_PHONE = By.xpath(BASE_FORM + "//input[@name='phone']");
    By INPUT_COMMENT = By.xpath(BASE_FORM + "//textarea[@name='message']"); //дополнить см. ScheduleYourFreeLocators

    By ASK_PHONE = By.xpath(BASE_FORM + "//input[@name='phone']//..");
    By ASK_MAIL = By.xpath(BASE_FORM + "//input[@name='email']//..");
    String TEXT_ASK_PHONE_MAIL = "Please enter a valid information";
    //bottom
    By COPYRIGHT = By.xpath("//div[@class='copyright box-md']//div[@class='copyright__column']/span/..");
    String TEXT_COPYRIGHT = "© Copyright 2007-2021 Andersen Software, Inc. All Rights Reserved. Privacy Policy";
    By LINK_PRIVACY_POLICY_ANDERSEN = By.xpath("//div[@class='copyright box-md']//div[@class='copyright__column']//a[contains(@href, '/privacy-policy')]");
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

    String PRIVATE_POLICY_ANDERSEN_LINK = "https://devblog.andersenlab.com/privacy-policy"; //FIXME "https://devblog.andersenlab.com/privacy-policy/"

    //gallery
    String BASE_GALLERY = "//section[@id='popup_gallery']";
    By WINDOW_GALLERY = By.xpath(BASE_GALLERY + "/div");
    By BUTTON_CLOSE_WINDOW_GALLERY = By.xpath(BASE_GALLERY + "//span[contains(@class, 'popup__close')]");
    By TITLE_WINDOW_GALLERY = By.xpath(BASE_GALLERY +"//h2");

    By PHOTO_WINDOW_GALLERY = By.xpath(BASE_GALLERY + "//img[contains(@class, 'gallery_full_image')]");
    By PHOTO_PREVIEW_1_WINDOW_GALLERY = By.xpath(BASE_GALLERY + "//div[@data-number='0']");
    By PHOTO_PREVIEW_2_WINDOW_GALLERY = By.xpath(BASE_GALLERY + "//div[@data-number='1']");
//    By PHOTOS_PREVIEW = By.xpath(BASE_GALLERY + "//img[@class='photo-gallery__image track__image js-track-image']");//если нужно будет работать со списком фото
    By BUTTON_NEXT_PHOTO_WINDOW_GALLERY = By.xpath(BASE_GALLERY + "//button[contains(@class, 'js-right')]");
    By BUTTON_PREV_PHOTO_WINDOW_GALLERY = By.xpath(BASE_GALLERY + "//button[contains(@class, 'js-left')]");
    By ORDINAL_PHOTO_WINDOW_GALLERY = By.xpath(BASE_GALLERY + "//span[contains(@class, 'js-start-number')]");
}

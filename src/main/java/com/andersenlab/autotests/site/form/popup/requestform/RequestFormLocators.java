package com.andersenlab.autotests.site.form.popup.requestform;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface RequestFormLocators {

    default void doBefore(){
        //метод заменен вызовом элемента из класса страницы. не удалять.
        //$(By.xpath("//button[@data-popup='popup_request' and @data-title='Request specialists']")).click();
        ($(By.xpath("//button/span"))).click();
    }
    
    String BASE = "//div[contains(@class, 'modal-module--container')]";
    By TITLE_REQ = By.xpath("//*[@id='___gatsby']/section/div/div/div/h3");
    By BUTTON_CLOSE_REQ = By.xpath(BASE + "//button[contains(@class, 'close-button')]");

    By LINK_PHONE = By.xpath(BASE + "//a[contains(@href, 'tel:+')]");
    By LINK_MAIL = By.xpath(BASE + "//a[contains(@href, 'mailto:')]");
    By LINK_PHONE_SVG = By.xpath(BASE + "//a[contains(@href, 'tel:+')]/*[1]");
    By LINK_MAIL_SVG = By.xpath(BASE + "//a[contains(@href, 'mailto:')]/*[1]");

    By INPUT_NAME = By.xpath(BASE + "//input[@name='name']");
    By INPUT_MAIL = By.xpath(BASE + "//input[@name='email']");
    By INPUT_PHONE = By.xpath(BASE + "//input[@name='phone']");
    By INPUT_COMMENT = By.xpath(BASE + "//textarea[@name='message']");
    By BUTTON_SEND = By.xpath(BASE + "//button[@type='submit']");

    By HINT_MAIL_COOPER = By.xpath(BASE + "//section[contains(@class,'tooltip-module')]");
    By ASK_PHONE = By.xpath(BASE + "//input[@name='phone']//..//../p");
    By ASK_MAIL = By.xpath(BASE + "//input[@name='email']//..//../p");

    By CHECKBOX_TO_PROTECT = By.xpath(BASE + "//label[contains(@class, 'checkbox')]");
    By CHECKBOX_TO_PROTECT_SPAN = By.xpath(BASE + "//label[contains(@class, 'checkbox')]/span");
    By CHECKBOX_TO_PROTECT_I = By.cssSelector("section.modal-module--popup--1hVvE div.hint-module--wrapper--jyTiU >svg");
    String TEXT_CHECKBOX_TO_PROTECT_I = "Before we discuss any details about your project you can request to sign a Non Disclosure Agreement";
    By CHECKBOX_TO_PROTECT_I_POPUP = By.xpath("//div[contains(@class,'hint-module--text')]");
    By BUTTON_CLOSE_CHECKBOX_TO_PROTECT_I_POPUP =  By.cssSelector("svg.hint-module--close--3MOcu");

    By CAPTCHA = By.xpath(BASE + "//p[contains(@class,'captcha')]");

    By LINK_PRIVACY_POLICY = By.xpath(BASE + "//a[contains(@href, 'privacy')]");
    By LINK_TERMS = By.xpath(BASE + "//a[contains(@href, 'terms')]");


}

package com.andersenlab.autotests.site.form.commonforms;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LocatorsForms {
    //заготовка на будущее для упорядочивания форм запросов/попап запросов
    String BASE = "//div[@id='popup_request' and contains(@class, 'active')]";
    //    String BASE = "(//section[(@id='attach-sale') or (@id='calc-popup-effective' and contains(@class, 'visible'))])[last()]";
    By TITLE = By.xpath(BASE + "//*[contains(@class, 'title') and not(contains(@class, 'subtitle'))]");

    By INPUT_NAME = By.xpath(BASE + "//input[@name='name']");
    By INPUT_MAIL = By.xpath(BASE + "//input[@name='email']");
    By INPUT_PHONE = By.xpath(BASE + "//input[@name='phone']");
    By INPUT_COMMENT = By.xpath(BASE + "//textarea[@name='message']");
    By BUTTON_SEND_REQ = By.xpath(BASE + "//button[contains(@class, 'submit')]");

    By CHECKBOX_TO_PROTECT = By.xpath(BASE + "//label[contains(@class, 'checkbox')]");
    By CHECKBOX_TO_PROTECT_I = By.xpath(BASE + "//label[contains(@class, 'checkbox')]/following-sibling::div/div/*");
    String TEXT_CHECKBOX_TO_PROTECT_I = "Before we discuss any details about your project you can request to sign a Non Disclosure Agreement";
    By CHECKBOX_TO_PROTECT_I_POPUP = By.xpath("//div[@class='popup-info js-popup-tooltip']");
    By BUTTON_CLOSE_CHECKBOX_TO_PROTECT_I_POPUP = By.xpath("//div[@class='popup-info js-popup-tooltip']/*[3]");

    By HINT_MAIL_COOPER = By.xpath(BASE + "//input[@name='email']//..//p[contains(@class, 'popup-info__text')]");
    By ASK_PHONE = By.xpath(BASE + "//input[@name='phone']//..");
    By ASK_MAIL = By.xpath(BASE + "//input[@name='email']//..");

    String BASE_SUCCESS = "//div[@id='popup-success' and contains(@class, 'active')]";
    By WINDOW_SUCCESS = By.xpath(BASE_SUCCESS);
    By BUTTON_CLOSE_SUCCESS = By.xpath(BASE_SUCCESS + "//span[contains(@class, 'close')]");
    By TITLE_SUCCESS = By.xpath(BASE_SUCCESS + "//p");

    By LINK_PHONE = By.xpath(BASE + "//a[contains(@href, 'tel:+')]");
    By LINK_MAIL = By.xpath(BASE + "//a[contains(@href, 'mailto:')]");

    private SelenideElement LinkPhone = $(LINK_PHONE);
    private SelenideElement LinkMail = $(LINK_MAIL);
    private SelenideElement InputName = $(INPUT_NAME);
    private SelenideElement InputMail = $(INPUT_MAIL);
    private SelenideElement InputPhone = $(INPUT_PHONE);
    private SelenideElement InputComment = $(INPUT_COMMENT);
    private SelenideElement CheckBoxProtect = $(CHECKBOX_TO_PROTECT);
    private SelenideElement CheckBoxProtectI = $(CHECKBOX_TO_PROTECT_I);
    private SelenideElement CheckBoxProtectIPopup = $(CHECKBOX_TO_PROTECT_I_POPUP);
    private SelenideElement ButtonCloseCheckBoxProtectIPopup = $(BUTTON_CLOSE_CHECKBOX_TO_PROTECT_I_POPUP);
    private SelenideElement ButtonSendReq = $(BUTTON_SEND_REQ);

    private SelenideElement TitleSuccess = $(TITLE_SUCCESS);
    private SelenideElement ButtonCloseSuccessWindow = $(BUTTON_CLOSE_SUCCESS);

    private SelenideElement HintMailCooper = $(HINT_MAIL_COOPER);
    private SelenideElement AskPhone = $(ASK_PHONE);
    private SelenideElement AskMail = $(ASK_MAIL);
    private SelenideElement TitleWindowReq = $(TITLE);



    By WINDOW_REQ = By.xpath(BASE);
    private SelenideElement WindowReq = $(WINDOW_REQ);

}

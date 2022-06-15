package com.andersenlab.autotests.site.page.industries.ecommerce.blocks.letstalk;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
class LetsTalkLocators {
    static final By SEND_BUTTON = By.xpath("//button[contains(@class,'button form__button')]");
    static final By FIELD_NAME = By.xpath("(//input[@name='name'])[1]");
    static final By FIELD_EMAIL = By.xpath("//form[@id='job-form-dropzone']//input[@type='email']");
    static final By FIELD_PHONE = By.xpath("//form[@id='job-form-dropzone']//input[@name='phone']");
    static final By FIELD_COMMENT = By.xpath("(//textarea[@name='message'])[1]");
    static final By BLOCK_TITLE = By.xpath("//h2[contains(@class,'h1 h1_margin-bottom')]");
    static final By POPUP_THANK = By.xpath("//div[@id='popup-success']");
    static final By POPUP_CLOSE_BUTTON = By.cssSelector(".popup_active .popup__close.js--popup-close");
    static final By DROP_FILES_BUTTON = By.xpath("//div[contains(@class,'dropzone__wrap dz-clickable')]");
    static final By INPUT_FILE = By.xpath("//input [@type='file']");
    static final By UPLOAD_FORM_FILE_SIZE = By.xpath("//div[@class='dz-size']");
    static final By UPLOAD_FORM_FILE_NAME = By.xpath("//div[@class='dz-filename']");
    static final By UPLOAD_FORM_ERROR = By.xpath("//div[@class='dz-error-message']");
    static final String NO_EMAIL_ERROR = ".control_invalid.field_error";
}

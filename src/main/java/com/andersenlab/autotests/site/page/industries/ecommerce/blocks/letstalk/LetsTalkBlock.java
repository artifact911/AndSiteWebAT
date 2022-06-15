package com.andersenlab.autotests.site.page.industries.ecommerce.blocks.letstalk;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.industries.ecommerce.blocks.letstalk.LetsTalkLocators.*;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class LetsTalkBlock {
    LetsTalkOperations operations = new LetsTalkOperations();

    private SelenideElement sendButton = $(SEND_BUTTON);
    private SelenideElement fieldEmail = $(FIELD_EMAIL);
    private SelenideElement fieldPhone = $(FIELD_PHONE);
    private SelenideElement fieldName = $(FIELD_NAME);
    private SelenideElement popupThank = $(POPUP_THANK);
    private SelenideElement popupCloseButton = $(POPUP_CLOSE_BUTTON);
    private SelenideElement dropFilesButton = $(DROP_FILES_BUTTON);
    private SelenideElement inputFile = $(INPUT_FILE);
    private SelenideElement uploadFormFileSize = $(UPLOAD_FORM_FILE_SIZE);
    private SelenideElement uploadFormFileName = $(UPLOAD_FORM_FILE_NAME);
    private SelenideElement uploadFormError = $(UPLOAD_FORM_ERROR);
}

package com.andersenlab.autotests.site.page.industries.ecommerce.blocks.reachout;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.industries.ecommerce.blocks.reachout.ReachLocators.*;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ReachBlock {
    ReachOperations operations = new ReachOperations();

    private SelenideElement openReachFormButton = $(OPEN_REACH_FORM_BUTTON);
    private SelenideElement reachFormEmail = $(REACH_FORM_EMAIL);
    private SelenideElement reachFormPhone = $(REACH_FORM_PHONE);
    private SelenideElement reachFormSendButton = $(REACH_FORM_SEND_BUTTON);
    private SelenideElement reachForm = $(REACH_FORM);
    private SelenideElement popupSuccess = $(POPUP_SUCCESS);
    private SelenideElement closeSuccessPopupButton = $(CLOSE_SUCCESS_POPUP_BUTTON);
    private SelenideElement closeRequestPopupButton = $(CLOSE_REQUEST_POPUP_BUTTON);

}

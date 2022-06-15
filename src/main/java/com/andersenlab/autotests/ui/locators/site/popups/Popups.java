package com.andersenlab.autotests.ui.locators.site.popups;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.ui.locators.site.popups.PopupsLocators.*;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class Popups {
    private SelenideElement activePopup_Request = $(ACTIVE_POPUP_REQUEST);
}

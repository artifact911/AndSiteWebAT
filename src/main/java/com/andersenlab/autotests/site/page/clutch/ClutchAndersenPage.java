package com.andersenlab.autotests.site.page.clutch;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.clutch.ClutchAndersenPageLocators.PAGE_TITLE;
import static com.codeborne.selenide.Selenide.$;
/**
 *  Page andersen on CLUTCH.CO ______  https://clutch.co/profile/andersen
 */
@Getter
public class ClutchAndersenPage {

    private SelenideElement pageTitle = $(PAGE_TITLE);
}

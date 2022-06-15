package com.andersenlab.autotests.site.page.topcompanies.interactivetv;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.topcompanies.interactivetv.InteractiveTvPageLocators.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Interactive TV  ______  https://dev.andersenlab.com/case-interactive-tv.php
 */
@Getter
public class InteractiveTvPage {

    private SelenideElement tvTitle = $(TV_TITLE);
}

package com.andersenlab.autotests.site.page.topcompanies;

import com.codeborne.selenide.SelenideElement;

import static com.andersenlab.autotests.site.page.topcompanies.TopCompaniesSharedLocators.HEADER_TITLE;
import static com.codeborne.selenide.Selenide.$;

public class TopCompaniesSharedElements {
    private SelenideElement headerTitle = $(HEADER_TITLE);
}

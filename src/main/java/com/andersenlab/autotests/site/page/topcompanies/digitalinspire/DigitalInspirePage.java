package com.andersenlab.autotests.site.page.topcompanies.digitalinspire;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.topcompanies.TopCompaniesSharedLocators.*;
import static com.codeborne.selenide.Selenide.$;

/**
 *  Digital inspire page https://dev.andersenlab.com/our-projects/software-for-certificates-storage
 */
@Getter
public class DigitalInspirePage {
    private SelenideElement headerTitle = $(HEADER_TITLE);
}

package com.andersenlab.autotests.site.page.topcompanies.decta;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.topcompanies.TopCompaniesSharedLocators.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * DECTA PAGE https://dev.andersenlab.com/our-projects/solution-for-internet-acquiring
 */
@Getter
public class DectaPage {
    private SelenideElement headerTitle = $(HEADER_TITLE);
}

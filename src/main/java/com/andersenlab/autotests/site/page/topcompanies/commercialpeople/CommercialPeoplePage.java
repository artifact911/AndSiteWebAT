package com.andersenlab.autotests.site.page.topcompanies.commercialpeople;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.topcompanies.TopCompaniesSharedLocators.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Commercial people page https://andersenlab.com/our-projects/commercial-property-rent-portal
 */
@Getter
public class CommercialPeoplePage {
    private SelenideElement headerTitle = $(HEADER_TITLE);
}

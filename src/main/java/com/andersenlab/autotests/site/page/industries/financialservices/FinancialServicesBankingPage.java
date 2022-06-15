package com.andersenlab.autotests.site.page.industries.financialservices;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.industries.financialservices.FinancialServicesBankingLocators.TITLE;
import static com.codeborne.selenide.Selenide.$;

/**
 * FinTech and Banking Software Development Services https://andersenlab.com/industries/financial-services
 */
@Getter
public class FinancialServicesBankingPage {
    private SelenideElement title = $(TITLE);
}

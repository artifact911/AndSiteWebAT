package com.andersenlab.autotests.site.page.homepage.blocks.navbar.industries;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.homepage.blocks.navbar.industries.IndustriesLocators.*;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class Industries {
    private SelenideElement eCommerce = $(ECOMMERCE);
    private SelenideElement financialServices =$(FINANCIAL_SERVICES);
    private SelenideElement eLearning = $(ELEARNING);
    private SelenideElement travelAndHospitality = $(TRAVEL_AND_HOSPITALITY);
    private SelenideElement healthcare = $(HEALTHCARE);
    private SelenideElement videoAndEntertainment = $(VIDEO_AND_ENTERTAINMENT);
    private SelenideElement realEstate = $(REAL_ESTATE);
    private SelenideElement telecom = $(TELECOM);
    private SelenideElement iGaming = $(IGAMING);
    private SelenideElement supplyChain = $(SUPPLY_CHAIN);
    private SelenideElement enterprise =$(ENTERPRISE);
    private SelenideElement retail = $(RETAIL);
}

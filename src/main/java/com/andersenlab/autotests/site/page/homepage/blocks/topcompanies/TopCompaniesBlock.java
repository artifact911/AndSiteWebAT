package com.andersenlab.autotests.site.page.homepage.blocks.topcompanies;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.homepage.blocks.topcompanies.TopCompaniesLocators.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Блок "Top companies rely on Andersen"
 */
@Getter
public class TopCompaniesBlock {
    private SelenideElement linkMercedesMe = $(LINK_MERCEDES_ME);
    private SelenideElement linkInteractiveTv = $(LINK_INTERACTIVE_TV);
    private SelenideElement linkMediaMarkt = $(LINK_MEDIA_MARKT);
    private SelenideElement linkFintechBanking = $(LINK_FINTECH_BANKING);
    private SelenideElement linkEcommerce = $(LINK_ECOMMERCE);
    private SelenideElement linkHealthcare = $(LINK_HEALTHCARE);
    private SelenideElement linkVideoEntertainment = $(LINK_VIDEO_ENTERTAINMENT);
    private SelenideElement linkRealEstate = $(LINK_REAL_ESTATE);
    private SelenideElement linkTravelHospitality = $(LINK_TRAVEL_HOSPITALITY);
}

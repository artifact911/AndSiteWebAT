package com.andersenlab.autotests.site.page.industries.ecommerce.blocks.industryleaders;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;


import static com.andersenlab.autotests.site.page.industries.ecommerce.blocks.industryleaders.IndustryLeadersLocators.*;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class IndustryLeadersBlock {
    private SelenideElement mediaMarktPreview = $(MEDIA_MARKT_PREVIEW);
    private SelenideElement dectaPreview = $(DECTA_PREVIEW);
    private SelenideElement gmcsPreview = $(GMCS_PREVIEW);
    private SelenideElement digitalInspirePreview= $(DIGITAL_INSPIRE_PREVIEW);
    private SelenideElement showMoreButton = $(SHOW_MORE_BUTTON);
    private SelenideElement commercialPeoplePreview = $(COMMERCIAL_PEOPLE_PREVIEW);
}

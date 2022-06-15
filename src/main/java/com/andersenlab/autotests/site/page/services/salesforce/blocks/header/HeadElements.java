package com.andersenlab.autotests.site.page.services.salesforce.blocks.header;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class HeadElements implements HeadLocators {
    private SelenideElement Heading = Selenide.$(HEADING);
    private SelenideElement Widget = Selenide.$(WIDGET);
    private SelenideElement LinkPhone = Selenide.$(LINK_PHONE);
}

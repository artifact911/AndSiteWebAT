package com.andersenlab.autotests.site.page.services.salesforce.blocks.smthtothink;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class SmthToThinkElements implements SmthToThinkLocators {
    private SelenideElement title = $(TITLE);
    private SelenideElement subtitle = $(SUBTITLE);
    private SelenideElement vc = $(VC);
}

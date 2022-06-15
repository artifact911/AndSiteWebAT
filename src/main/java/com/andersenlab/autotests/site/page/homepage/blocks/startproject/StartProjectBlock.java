package com.andersenlab.autotests.site.page.homepage.blocks.startproject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.homepage.blocks.startproject.StartProjectLocators.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Start your project within 10 days
 */
@Getter
public class StartProjectBlock {
    private SelenideElement linkMoreInformation = $(LINK_MORE_INFORMATION);
    private SelenideElement linkProvenExpertise = $(LINK_PROVEN_EXPERTISE);
    private SelenideElement linkSatisfiedClients = $(LINK_SATISFIED_CLIENTS);
}

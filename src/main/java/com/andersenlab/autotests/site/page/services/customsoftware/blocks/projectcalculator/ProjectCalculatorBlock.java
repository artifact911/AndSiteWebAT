package com.andersenlab.autotests.site.page.services.customsoftware.blocks.projectcalculator;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.services.customsoftware.blocks.projectcalculator.ProjectCalculatorLocators.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Блок Project calculator
 */
@Getter
public class ProjectCalculatorBlock {
    private SelenideElement projCalculatorOpener = $(PROJ_CALCULATOR_OPENER);
    private SelenideElement addNetDev = $(ADD_NET_DEV);
    private SelenideElement removeNetDev = $(REMOVE_NET_DEV);
    private SelenideElement resetCalculator = $(RESET_CALCULATOR);
    private SelenideElement netDevCount = $(NET_DEV_COUNT);
}

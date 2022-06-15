package com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.versatiletools;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.versatiletools.VersatileToolsLocators.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Блок "Versatile tools we work with"
 */
@Getter
public class VersatileToolsBlock {
    private SelenideElement arrowNext = $(ARROW_NEXT);
    private SelenideElement arrowPrevious = $(ARROW_PREVIOUS);
    private SelenideElement activeSlider = $(ACTIVE_SLIDER);
    private ElementsCollection technologiesItems = $$(TECHNOLOGIES_ITEMS);
}

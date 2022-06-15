package com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.knowrealprice;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
/**
 * Блок "Know the real price of the project"
 */
@Getter
public class KnowRealPriceBlock implements KnowRealPriceLocators{
    private SelenideElement plusJsDev = $(PLUS_JS_DEV);
    private SelenideElement minusJsDev = $(MINUS_JS_DEV);
    private SelenideElement CountJsDev = $(COUNT_JS_DEV);

    private SelenideElement plusAngular = $(PLUS_ANGULAR);
    private SelenideElement minusAngular = $(MINUS_ANGULAR);
    private SelenideElement CountAngular = $(COUNT_ANGULAR);

    private SelenideElement plusReact = $(PLUS_REACT);
    private SelenideElement minusReact = $(MINUS_REACT);
    private SelenideElement CountReact = $(COUNT_REACT);

    private SelenideElement ResetDev = $(RESET_DEV);

    private SelenideElement plusPm = $(PLUS_PM);
    private SelenideElement minusPm = $(MINUS_PM);
    private SelenideElement CountPm = $(COUNT_PM);

    private SelenideElement plusQa = $(PLUS_QA);
    private SelenideElement minusQa = $(MINUS_QA);
    private SelenideElement CountQa = $(COUNT_QA);

    private SelenideElement ResetInclude = $(RESET_INCLUDE);
    private SelenideElement ButtonClosePanel = $(CLOSE_BUTTON_PANEL);
    private SelenideElement Panel = $(PANEL);
}

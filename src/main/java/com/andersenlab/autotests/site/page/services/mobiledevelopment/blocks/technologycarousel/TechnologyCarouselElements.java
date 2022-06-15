package com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.technologycarousel;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class TechnologyCarouselElements implements TechnologyCarouselLocators {
    private ElementsCollection techItems = $$(TECH_ITEMS);
    private ElementsCollection sliders = $$(SLIDERS);
    private SelenideElement arrowNext = $(ARROW_NEXT);
    private SelenideElement arrowPrev = $(ARROW_PREV);
    private SelenideElement sliderActive = $(SLIDER_ACTIVE);
    private SelenideElement nextSection = $(NEXT_SECTION);
}

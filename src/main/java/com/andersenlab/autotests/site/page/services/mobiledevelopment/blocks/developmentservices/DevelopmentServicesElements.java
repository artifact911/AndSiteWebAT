package com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.developmentservices;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class DevelopmentServicesElements implements DevelopmentServicesLocators {
    private SelenideElement Title2 = $(TITLE2);
    private ElementsCollection Arts2 = $$(ARTICLES_TITLE2);
}

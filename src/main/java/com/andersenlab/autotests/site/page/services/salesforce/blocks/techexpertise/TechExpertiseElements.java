package com.andersenlab.autotests.site.page.services.salesforce.blocks.techexpertise;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class TechExpertiseElements implements TechExpertiseLocators {
    private SelenideElement title = $(TITLE);
    private SelenideElement subtitle = $(SUBTITLE);
    private ElementsCollection articles = $$(ARTICLES);

}

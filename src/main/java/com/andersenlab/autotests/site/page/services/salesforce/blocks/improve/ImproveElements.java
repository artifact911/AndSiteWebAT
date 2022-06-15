package com.andersenlab.autotests.site.page.services.salesforce.blocks.improve;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class ImproveElements implements ImproveLocators {
    private SelenideElement Title = $(TITLE);
    private ElementsCollection Articles = $$(ARTICLES);
}

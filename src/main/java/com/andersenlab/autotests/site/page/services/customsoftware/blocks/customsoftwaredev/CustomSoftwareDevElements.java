package com.andersenlab.autotests.site.page.services.customsoftware.blocks.customsoftwaredev;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class CustomSoftwareDevElements implements CustomSoftwareDevLocators{
    private SelenideElement Header = Selenide.$(HEADER);
    private SelenideElement Description = Selenide.$(DESCRIPTION);
    private SelenideElement HeaderArticle1 = Selenide.$(HEADER_ARTICLE1);
    private SelenideElement HeaderArticle2 = Selenide.$(HEADER_ARTICLE2);
    private SelenideElement HeaderArticle3 = Selenide.$(HEADER_ARTICLE3);
    private SelenideElement Article1 = Selenide.$(ARTICLE1);
    private SelenideElement Article2 = Selenide.$(ARTICLE2);
    private SelenideElement Article3 = Selenide.$(ARTICLE3);
}

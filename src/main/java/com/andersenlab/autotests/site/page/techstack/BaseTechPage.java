package com.andersenlab.autotests.site.page.techstack;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.techstack.BaseTechLocators.*;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class BaseTechPage {
    protected SelenideElement introTitle = $(INTRO_TITLE);
    protected SelenideElement featureTitle = $(FEATURE_TITLE);
    protected SelenideElement pdfDocument = $(PDF_DOCUMENT);
}

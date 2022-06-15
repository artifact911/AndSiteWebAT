package com.andersenlab.autotests.site.page.services.salesforce.blocks.projectexamples;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class ProjectExamplesElements implements ProjectExamplesLocators {
    private SelenideElement title = $(TITLE);
    private SelenideElement subtitle = $(SUBTITLE);
    private ElementsCollection vcs = $$(VCS);
    private SelenideElement concept = $(CONCEPT);
    private SelenideElement buttonCloseConcept = $(BUTTON_CLOSE_CONCEPT);
}

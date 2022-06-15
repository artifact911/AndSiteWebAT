package com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class IntroElements implements IntroLocators {
    private SelenideElement Heading = $(HEADING);
    private ElementsCollection Widgets = $$(WIDGETS);
    private SelenideElement LinkPhone = $(LINK_PHONE);
}

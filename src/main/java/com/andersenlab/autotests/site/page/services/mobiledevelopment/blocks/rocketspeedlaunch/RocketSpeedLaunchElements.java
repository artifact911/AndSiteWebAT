package com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.rocketspeedlaunch;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class RocketSpeedLaunchElements implements RocketSpeedLaunchLocators{
    private ElementsCollection articles = $$(ARTICLES);
    private SelenideElement title = $(TITLE);
    private SelenideElement buttonReq = $(BUTTON_REQ);
}

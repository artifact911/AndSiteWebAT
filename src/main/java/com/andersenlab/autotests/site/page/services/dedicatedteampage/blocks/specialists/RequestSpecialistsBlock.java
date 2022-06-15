package com.andersenlab.autotests.site.page.services.dedicatedteampage.blocks.specialists;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.services.dedicatedteampage.blocks.specialists.RequestSpecialistsLocators.TITLE;
import static com.codeborne.selenide.Selenide.$;
/**
 * dedicated-team page
 */
@Getter
public class RequestSpecialistsBlock {
    private SelenideElement title = $(TITLE);
}

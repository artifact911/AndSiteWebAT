package com.andersenlab.autotests.site.page.services.dedicatedteampage.blocks.technologies;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.services.dedicatedteampage.blocks.technologies.TechnologiesBlockLocators.H2_TITLE;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class TechnologiesBlock {

    private SelenideElement h2Title = $(H2_TITLE);
}

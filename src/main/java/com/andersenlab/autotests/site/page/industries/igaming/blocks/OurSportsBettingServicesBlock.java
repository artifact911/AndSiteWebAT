package com.andersenlab.autotests.site.page.industries.igaming.blocks;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class OurSportsBettingServicesBlock extends OurSportsBettingServicesLocators {
    private final SelenideElement title = $(getTITLE());
    private final ElementsCollection buttons = $$(getBUTTONS());
    private final ElementsCollection buttonsTitles = $$(getBUTTONS_TITLES());
    private final SelenideElement articleTitle = $(getARTICLE_TITLE());
    private final SelenideElement article = $(getARTICLE_TEXT());
}

class OurSportsBettingServicesLocators {
    private final String SECTION_BASE = "//div[contains(@class, 'WhatWeDo')]//..//..";
    @Getter private final By TITLE = By.xpath(SECTION_BASE + "/h2");
    @Getter private final By BUTTONS = By.xpath("//button[contains(@class,'WhatWeDo-module--tabButton--RB-af')]");
    @Getter private final By BUTTONS_TITLES = By.xpath("//button[contains(@class,'WhatWeDo-module--tabButton--RB-af')]//h4");
    private final String CURRENT_ARTICLE = "//div[(contains(@class,'WhatWeDo-module--content--24W65')) and not (contains(@class, 'hidden'))]";
    @Getter private final By ARTICLE_TITLE = By.xpath(CURRENT_ARTICLE + "/h3");
    @Getter private final By ARTICLE_TEXT = By.xpath(CURRENT_ARTICLE + "/p");
}
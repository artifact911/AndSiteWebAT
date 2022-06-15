package com.andersenlab.autotests.site.page.industries.igaming.blocks.ourprojectsblock;

import lombok.Getter;
import org.openqa.selenium.By;

class ProjectArticlesLocators {
    private final String BASE = "//article[contains(@class, 'ConceptCard-module--vcCard')]/..";
    @Getter private final By TITLE = By.xpath(BASE + "//h3");
    @Getter private final By SUBTITLE = By.xpath(BASE + "//p");
    @Getter private final By CARD_BUTTON = By.xpath(BASE + "//div[contains(@class, 'button')]");
    @Getter private final By CARD_IMAGE = By.xpath(BASE + "//div[contains(@class, 'button')]//picture/img");
}

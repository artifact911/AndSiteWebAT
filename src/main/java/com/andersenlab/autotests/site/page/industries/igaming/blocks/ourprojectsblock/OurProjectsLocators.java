package com.andersenlab.autotests.site.page.industries.igaming.blocks.ourprojectsblock;

import lombok.Getter;
import org.openqa.selenium.By;

public class OurProjectsLocators {
    private final String BASE = "//section[@id='concepts-list']";

    @Getter private final By TITLE = By.xpath(BASE + "//h2");
    @Getter private final By SUBTITLE = By.xpath(BASE + "//h2/following-sibling::p");
    @Getter private final By SHOW_MORE = By.xpath(BASE + "//div[contains(@class, 'showRow')]/button");
}
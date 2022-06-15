package com.andersenlab.autotests.site.page.industries.igaming.blocks.ourprojectsblock;

import lombok.Getter;
import org.openqa.selenium.By;

class ProjectPopupLocators {
    private final String BASE = "//section[contains(@class, 'modal-module--popup')]";
    private final String HIDDEN = "//div[@class='ImageListConcept-module--hiddenContent--Ae7YX']";
    @Getter private final By TITLE = By.xpath(BASE + "//div[contains(@class, 'ConceptHeader')]");
    @Getter private final By SECTION_TITLE = By.xpath(BASE + "//div[contains(@class, 'VisualConcept')]//h3");
    @Getter private final By CONTACT_US = By.xpath(BASE + "//div[contains(@class, 'conceptForm-module--container')]//h3");
    @Getter private final By CLOSE_BTN = By.xpath(BASE + "//button[contains(@class, 'close')]");
    @Getter private final By IMAGE = By.xpath(BASE + "//picture//img");
    @Getter private final By STRING = By.xpath(BASE + HIDDEN + "//*[contains(@class,'font-size-md') or contains(@class, 'title-module--title--2ZlKC')]");
}

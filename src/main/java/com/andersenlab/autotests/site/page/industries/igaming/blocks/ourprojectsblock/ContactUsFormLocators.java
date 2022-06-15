package com.andersenlab.autotests.site.page.industries.igaming.blocks.ourprojectsblock;

import lombok.Getter;
import org.openqa.selenium.By;

class ContactUsFormLocators {
    private final String BASE = "//div[contains(@class, 'conceptForm-module')]";
    @Getter private final By TITLE = By.xpath(BASE + "//h3");
    @Getter private final By NDA_CHECKBOX = By.xpath(BASE + "//div[contains(@class, 'font-size-sm')]");
    @Getter private final By NDA_I_BTN = By.cssSelector("section.modal-module--popup--1hVvE label svg");
    @Getter private final By NDA_POPUP = By.xpath("//div[contains(@class, 'hint-module--text')]");
    @Getter private final By NDA_POPUP_CLOSE = By.cssSelector("div.hint-module--content--1LyDt svg");
    @Getter private final By RECAPTCHA_TEXT = By.xpath(BASE + "//article//div");
    @Getter private final By PRIVACY = By.xpath(BASE + "//article//a[@href='https://policies.google.com/privacy']");
    @Getter private final By TERMS = By.xpath(BASE + "//article//a[@href='https://policies.google.com/terms']");
}

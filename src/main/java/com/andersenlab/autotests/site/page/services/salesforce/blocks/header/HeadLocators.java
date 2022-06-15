package com.andersenlab.autotests.site.page.services.salesforce.blocks.header;

import org.openqa.selenium.By;

public interface HeadLocators {
    By HEADING = By.xpath("//h1[contains(@class, 'intro__title')]");
    By WIDGET = By.xpath("//img[contains(@src, '/icons/logos/clutch')]");
    By LINK_PHONE = By.xpath("//a[contains(@class, 'header__phone')]");
}

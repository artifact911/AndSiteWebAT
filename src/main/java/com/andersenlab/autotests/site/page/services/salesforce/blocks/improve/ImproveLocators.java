package com.andersenlab.autotests.site.page.services.salesforce.blocks.improve;

import org.openqa.selenium.By;

public interface ImproveLocators {
    String BASE = "//section[@id='improve-your-business-to-customer-collaboration']";
    By TITLE = By.xpath(BASE + "//h3[contains(@class, 'soft-dev-advantages__title')]");
    By ARTICLES = By.xpath(BASE + "//div[contains(@class, 'soft-dev-advantages__item-content')]");
    int ARTS_QUANTITY = 6;

    String TEXT_TITLE = "Improve your business-to-customer collaboration";
}

package com.andersenlab.autotests.site.page.services.salesforce.blocks.techexpertise;

import org.openqa.selenium.By;

public interface TechExpertiseLocators {
    String BASE = "//section[contains(@class, 'what-we-do container')]";
    By TITLE = By.xpath(BASE + "//h2[@class='what-we-do__title h2']");
    By SUBTITLE = By.xpath(BASE + "//p[contains(@class, 'subtitle')]");
    By ARTICLES = By.xpath(BASE + "//div[contains(@class,'what-we-do__wrapper')]//article");
    int ARTS_QUANTITY = 6;

    String TEXT_TITLE = "What we do";
//    String TEXT_SUBTITLE = "We design and develop tools that increase loyalty to your brand. To do this, Andersen uses the flagship Salesforce Products, including:";

}

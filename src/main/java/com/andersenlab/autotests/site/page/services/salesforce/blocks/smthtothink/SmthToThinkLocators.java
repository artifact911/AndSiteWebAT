package com.andersenlab.autotests.site.page.services.salesforce.blocks.smthtothink;

import org.openqa.selenium.By;

public interface SmthToThinkLocators {
    String BASE = "//section[contains(@class, 'js-articles-container')]";
    By TITLE = By.xpath(BASE + "//h2");
    By SUBTITLE = By.xpath(BASE + "//p[contains(@class, 'subtitle')]");
    By VC = By.xpath(BASE + "//a");

    String VC_HREF = "https://dev.andersenlab.com/blueprint/new-world-without-queues";
    String TEXT_TITLE = "Something to think about";
    String TEXT_SUBTITLE = "Benefit from learning the freshest news from Salesforce ecosystem to effectively utilize them for your business.";

}

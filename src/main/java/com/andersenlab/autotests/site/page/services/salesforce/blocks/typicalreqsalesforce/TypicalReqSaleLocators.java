package com.andersenlab.autotests.site.page.services.salesforce.blocks.typicalreqsalesforce;

import org.openqa.selenium.By;

public interface TypicalReqSaleLocators {
    String BASE = "//section[@class='soft-dev-reach container container_gray_bg ']/preceding-sibling::section[@id='why-andersen']";
    By HEADER = By.xpath(BASE + "//h2");

    By HEADER_ARTICLE1 = By.xpath(BASE + "/div/div/article[1]/header");
    By HEADER_ARTICLE2 = By.xpath(BASE + "/div/div/article[2]/header");
    By HEADER_ARTICLE3 = By.xpath(BASE + "/div/div/article[3]/header");

    By ARTICLE1 = By.xpath(BASE + "/div/div/article[1]/p");
    By ARTICLE2 = By.xpath(BASE + "/div/div/article[2]/p");
    By ARTICLE3 = By.xpath(BASE + "/div/div/article[3]/p");

    String TEXT_HEADER = "There are three groups of typical requests related to Salesforce";

    String TEXT_HEADER_ARTICLE1 = "I want to implement Salesforce or other CRM system";
    String TEXT_HEADER_ARTICLE2 = "I need customization of my existing Salesforce platform";
    String TEXT_HEADER_ARTICLE3 = "I’m looking to extend my team and acquire additional resources";

    String TEXT_ARTICLE1 = "A specialist will advise you, as well as help to choose and implement the right CRM system from scratch.";
    String TEXT_ARTICLE2 = "We can help you upgrade your current Salesforce system with custom solutions or integrate 3rd party modules.";
    String TEXT_ARTICLE3 = "Andersen helps meet your business needs by providing a team of certified specialists with the tech stack you need:";
}

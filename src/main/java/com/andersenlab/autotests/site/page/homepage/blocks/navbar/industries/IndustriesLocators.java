package com.andersenlab.autotests.site.page.homepage.blocks.navbar.industries;

import org.openqa.selenium.By;

public class IndustriesLocators {
    final static String BASE = new String("//li[@name='industries']");

    final static By ECOMMERCE = By.xpath(BASE + "//a[contains(@href, 'ecommerce')]");
    final static By FINANCIAL_SERVICES = By.xpath(BASE + "//a[contains(@href, 'financial-services')]");
    final static By ELEARNING = By.xpath(BASE + "//a[contains(@href, 'eLearning')]");
    final static By TRAVEL_AND_HOSPITALITY = By.xpath(BASE + "//a[contains(@href, 'travel-hospitality')]");
    final static By HEALTHCARE = By.xpath(BASE + "//a[contains(@href, 'healthcare')]");
    final static By VIDEO_AND_ENTERTAINMENT = By.xpath(BASE + "//a[contains(@href, 'video-entertainment')]");
    final static By REAL_ESTATE = By.xpath(BASE + "//a[contains(@href, 'real-estate')]");
    final static By TELECOM = By.xpath(BASE + "//a[contains(@href, 'telecom')]");
    final static By IGAMING = By.xpath(BASE + "//a[contains(@href, 'gambling')]");
    final static By SUPPLY_CHAIN = By.xpath(BASE + "//a[contains(@href, 'supply-chain')]");
    final static By ENTERPRISE = By.xpath(BASE + "//a[contains(@href, 'enterprise')]");
    final static By RETAIL = By.xpath(BASE + "//a[contains(@href, 'retail')]");
}

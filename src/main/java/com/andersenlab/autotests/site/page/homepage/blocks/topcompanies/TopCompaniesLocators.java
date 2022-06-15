package com.andersenlab.autotests.site.page.homepage.blocks.topcompanies;


import org.openqa.selenium.By;

class TopCompaniesLocators {
    static final By LINK_MERCEDES_ME = By.xpath("//a[contains(@href, 'case-mercedes')]");
    static final By LINK_INTERACTIVE_TV = By.xpath("//a[contains(@href, 'case-interactive-tv')]");
    static final By LINK_MEDIA_MARKT = By.xpath("//a[contains(@href, 'mediamarkt')]");
    static final By LINK_FINTECH_BANKING = By.xpath("//section[@class='what-we-do container ']//a[contains(@href, 'financial-services')]");
    static final By LINK_ECOMMERCE = By.xpath("//section[@class='what-we-do container ']//a[contains(@href, 'ecommerce')]");
    static final By LINK_HEALTHCARE = By.xpath("//section[@class='what-we-do container ']//a[contains(@href, 'healthcare')]");
    static final By LINK_VIDEO_ENTERTAINMENT = By.xpath("//span[text()[normalize-space()='Video & Entertainment']]");
    static final By LINK_REAL_ESTATE = By.xpath("//section[@class='what-we-do container ']//a[contains(@href, 'real-estate')]");
    static final By LINK_TRAVEL_HOSPITALITY = By.xpath("//section[@class='what-we-do container ']//a[contains(@href, 'travel-hospitality')]");
}

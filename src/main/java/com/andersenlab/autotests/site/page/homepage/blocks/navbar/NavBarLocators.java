package com.andersenlab.autotests.site.page.homepage.blocks.navbar;

import org.openqa.selenium.By;

public class NavBarLocators {

    static final By HOMEPAGE = By.xpath("//header//a[contains(@class, 'header__logo-wrap')]");
    static final By TECHSTACK = By.xpath("//li[@name='technologies']");
    static final By INDUSTRIES = By.xpath("//li[@name='industries']");
    static final By SERVICES = By.xpath("//li[@name='other-specialists']");
    static final By COMPANY = By.xpath("//li[@name='company']");
    static final By PROJECTS = By.xpath("//li//a[@name='our-projects']");
    static final By SEARCH = By.xpath("//form[@class='search-panel']");
    static final By PRICING = By.xpath("//a[@class='button button_sm button_header']");

}

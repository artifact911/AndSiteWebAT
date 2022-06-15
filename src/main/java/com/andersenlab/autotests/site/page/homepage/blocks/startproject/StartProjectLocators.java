package com.andersenlab.autotests.site.page.homepage.blocks.startproject;

import org.openqa.selenium.By;

public class StartProjectLocators {
    static final By LINK_MORE_INFORMATION = By.xpath("//section[@id='features-index']//a[contains(@class, 'feature__button')]");
    static final By LINK_PROVEN_EXPERTISE = By.xpath("(//div[@class='feature__row ']/a)[1]");
    static final By LINK_SATISFIED_CLIENTS = By.xpath("//a[@href=\"https://dev.andersenlab.com/engineers-on-projects\"]");
}
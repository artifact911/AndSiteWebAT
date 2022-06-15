package com.andersenlab.autotests.ui.locators.site;

import org.openqa.selenium.By;

public class HeaderBlock {

    public static final By headerTopBlock = By.xpath("//div[contains(@class, 'header__topline-inside')]");
    public static final By headerBottomBlock = By.xpath("//div[contains(@class, 'header__botline-inside')]");
    public static final By phoneNumber = By.cssSelector(".phone.js-header-phone");
}

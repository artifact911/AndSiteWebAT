package com.andersenlab.autotests.site.page.industries.ecommerce.blocks.attractsell;

import org.openqa.selenium.By;

class AttractSellLocators {
    static final By WATCH_VIDEO_BUTTON = By.xpath("//button[@class='feature__button button ']");
    static final By VIDEO_BLOCK = By.cssSelector("div#video>div");
    static By CLOSE_VIDEO_BUTTON = By.xpath("(//div[@class='popup__close js--popup-close'])[2]");
    static By OUTSIDE_VIDEO_POPUP = By.xpath("//div[@class='popup popup_active']");
}

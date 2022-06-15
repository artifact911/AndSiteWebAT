package com.andersenlab.autotests.site.page.homepage.blocks.clients;

import org.openqa.selenium.By;

class OurSatisfiedClientsBlockLocators {

    static By LINK_TO_CLUTCH = By.xpath("//div[contains(@class,'slick-active')]//*[contains(@class,'link-img')]");
    static By LINK_MORE_REFERENCES = By.xpath("//section[contains(@class, 'our-satisfied-clients')]//a[contains(text(),'More References')]");
    static By CLOSE_VIDEO_BUTTON = By.xpath("//div[@class='popup__close js--popup-close']");
    static By VIDEO_BLOCK = By.cssSelector("div#video>div");
    static By LINK_VIDEO_ELEMENT = By.xpath("//section[contains(@class,'our-satisfied-clients')]//article[@aria-hidden='false']//img[contains(@class,'video-player__poster')]");
    static By CURRENT_ARTICLE = By.xpath("//section[contains(@class,'our-satisfied-clients')]//article[@aria-hidden='false']");
    static By BLOCK_TITLE = By.xpath("//h2[@class='references__title h1']");

}


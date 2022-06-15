package com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.versatiletools;

import org.openqa.selenium.By;

class VersatileToolsLocators {
    static final By ARROW_NEXT = By.xpath("(//button[@class='slick-next slick-arrow'])[1]");
    static final By ARROW_PREVIOUS = By.xpath("(//button[@class='slick-prev slick-arrow'])[1]");
    static final By ACTIVE_SLIDER = By.xpath("(//li[@class='slick-active']//button)[1]");
    static final By TECHNOLOGIES_ITEMS = By.cssSelector(".technology-carousel__list .slick-list");
}

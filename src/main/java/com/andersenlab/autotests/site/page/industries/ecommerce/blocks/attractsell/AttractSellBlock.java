package com.andersenlab.autotests.site.page.industries.ecommerce.blocks.attractsell;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.industries.ecommerce.blocks.attractsell.AttractSellLocators.*;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class AttractSellBlock {
    private SelenideElement watchVideoButton = $(WATCH_VIDEO_BUTTON);
    private SelenideElement videoBlock = $(VIDEO_BLOCK);
    private SelenideElement closeVideoButton = $(CLOSE_VIDEO_BUTTON);
    private SelenideElement outsideVideoPopup = $(OUTSIDE_VIDEO_POPUP);
}

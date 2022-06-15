package com.andersenlab.autotests.site.page.homepage.blocks.clients;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.homepage.blocks.clients.OurSatisfiedClientsBlockLocators.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Блок "Our Satisfied Clients"
 */
@Getter
public class OurSatisfiedClientsBlock {

    private SelenideElement linkToClutch = $(LINK_TO_CLUTCH);
    private SelenideElement linkMoreReferences = $(LINK_MORE_REFERENCES);
    private SelenideElement closeVideoButton = $(CLOSE_VIDEO_BUTTON);
    private SelenideElement linkVideoBlock = $(LINK_VIDEO_ELEMENT);
    private SelenideElement videoBlock = $(VIDEO_BLOCK);
    private SelenideElement blockTitle = $(BLOCK_TITLE);
    private SelenideElement currentArticle = $(CURRENT_ARTICLE);
}

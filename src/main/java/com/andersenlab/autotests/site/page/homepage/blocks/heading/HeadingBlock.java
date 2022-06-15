package com.andersenlab.autotests.site.page.homepage.blocks.heading;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.homepage.blocks.heading.HeadingLocators.INTRO_TITLE;
import static com.codeborne.selenide.Selenide.$;

/**
 * Блок "Название"
 */
@Getter
public class HeadingBlock {

    private SelenideElement introTitle = $(INTRO_TITLE);
}

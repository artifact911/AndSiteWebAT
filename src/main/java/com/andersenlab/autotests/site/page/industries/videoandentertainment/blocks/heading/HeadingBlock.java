package com.andersenlab.autotests.site.page.industries.videoandentertainment.blocks.heading;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.industries.videoandentertainment.blocks.heading.HeadingLocators.TITLE;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class HeadingBlock {
    private SelenideElement title = $(TITLE);
}

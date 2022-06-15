package com.andersenlab.autotests.site.page.industries.healthcare.blocks.heading;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
class HeadingLocators {
    static final By TITLE = By.xpath("//h1[contains(text(),'Healthcare ')]");
}
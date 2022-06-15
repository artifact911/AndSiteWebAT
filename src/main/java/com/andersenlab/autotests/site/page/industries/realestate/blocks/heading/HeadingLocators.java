package com.andersenlab.autotests.site.page.industries.realestate.blocks.heading;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class HeadingLocators {
    static final By TITLE = By.xpath("//h1[contains(@class,'intro__title ')]");
}

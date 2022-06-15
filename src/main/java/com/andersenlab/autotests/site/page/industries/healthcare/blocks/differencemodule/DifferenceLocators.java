package com.andersenlab.autotests.site.page.industries.healthcare.blocks.differencemodule;

import lombok.Getter;
import org.openqa.selenium.By;

public class DifferenceLocators {
    private final String BASE = "section:nth-child(7)";

    @Getter private final By TITLE = By.cssSelector(BASE + " p");
    @Getter private final By DIFFERENCE_CARD_IMG = By.cssSelector(BASE + " svg use");
    @Getter private final By DIFFERENCE_CARD_TXT = By.cssSelector(BASE + " svg + p");
    @Getter private final By DIFFERENCE_LIST_TXT = By.cssSelector(BASE + " ul li");
}

package com.andersenlab.autotests.site.page.techstack;

import org.openqa.selenium.By;

public class BaseTechLocators {
    static final By INTRO_TITLE = By.tagName("h1");
    static final By FEATURE_TITLE = By.xpath("//h2[@class='feature__title h2']");
    static final By PDF_DOCUMENT = By.cssSelector("embed[type='application/pdf']");
}

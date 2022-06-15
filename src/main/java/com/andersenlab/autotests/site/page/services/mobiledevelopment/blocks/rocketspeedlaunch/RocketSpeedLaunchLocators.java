package com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.rocketspeedlaunch;

import org.openqa.selenium.By;

public interface RocketSpeedLaunchLocators {
    String BASE = "//h2[contains(text(), 'Rocket-speed')]//..//..";
    By TITLE = By.xpath(BASE + "//h2");
    By BUTTON_REQ = By.xpath(BASE + "//button[contains(text(), 'Request specialist')]");
    By ARTICLES = By.xpath(BASE + "//h2[contains(@class, 'title-module--title--2ZlKC Card-module')]");
    String TEXT_TITLE = "Rocket-speed Launch with Top-notch Mobile App Developers";
    String[] TEXT_ARTICLES = {
            "2 days to qualified CVs",
            "3 days to interview",
            "10 days to launch",
            "2-week free trial"
    };
}

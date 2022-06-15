package com.andersenlab.autotests.site.page.company.greetings;

import org.openqa.selenium.By;

public class GreetingsLocators {
    private static final String BASE = "//div[contains(@class, 'GreetingCard')]/../../div[@class='box-md']";
    public static final By TITLE = By.xpath(BASE + "//p[contains(@class, 'title')]");
    public static final By PHOTO = By.xpath(BASE + "//img[@alt='author']");
    public static final By NAME = By.xpath(BASE + "//a[contains(@href, 'linkedin.com/')]");
    public static final By LINKEDIN = By.cssSelector("figcaption.GreetingCard-module--authorInfo--1dx2g svg");
    public static final By FORBES = By.cssSelector("svg.GreetingCard-module--logoIcon--1Od5v.GreetingCard-module--icon--1um-d");
    public static final By POSITION = By.xpath(BASE + "//figcaption/p");
    public static final By GREETING_MESSAGE = By.xpath(BASE + "//p[contains(@class, 'subtitle') and not(contains(@class, 'authorPosition'))]");
    public static final By VIDEO_PREVIEW = By.xpath(BASE + "//div[contains(@class, 'videoPlayer')]/img");
    public static final By VIDEO_POPUP = By.xpath("//div[contains(@class, 'modal-module--player')]");
    public static final By VIDEO_CLOSE_BTN = By.xpath("//div[contains(@class, 'modal-module--player')]/button");
}

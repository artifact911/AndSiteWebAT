package com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.technologycarousel;

import org.openqa.selenium.By;

public interface TechnologyCarouselLocators {

    String BASE = "//section[contains(@class, 'tools-slider')]";
    By TECH_ITEMS = By.xpath(BASE + "//div[contains(@class,'slick-active')]//span[contains(@class, 'tools-module--itemTextWrapper')]");
    By ARROW_NEXT = By.xpath(BASE + "//button[contains(@class, 'slick-next')]");
    By SLIDER_ACTIVE = By.xpath(BASE + "//li[@class='slick-active']//button");
    By SLIDERS = By.xpath(BASE + "//li//button");
    By ARROW_PREV = By.xpath(BASE + "//button[contains(@class, 'slick-prev')]");
    By NEXT_SECTION = By.xpath(BASE + "/./following-sibling::section[1]");

    String[] TEXT_TECH_ITEMS = {
            "Airplay",
            "Rx",
            "iOS",
            "watchOS",
            "tvOS",
            "Flutter",
            "React Native",
            "Android Studio",
            "Kotlin",
            "Java",
            "Android Jetpack",
            "Firebase",
            "Espresso UI Testing",
            "Mockito Unit Testing",
            "RXJava",
            "Glide - Image",
            "Loading Library",
            "ExoPlayer",
            "Swift",
            "Swift objective-c",
            "xCode",
            "CocoaPods",
            "GitLab",
            "Fastlane",
            "Swagger",
            "Apple Pay",
            "AR Kit",
            "Siri Kit",
            "Core Location",
            "Core ML",
            "Airplay",
            "Rx",
            "iOS",
            "watchOS",
            "tvOS",
            "Flutter",
            "React Native",
            "Android Studio",
            "Kotlin",
            "Java"
    };
}

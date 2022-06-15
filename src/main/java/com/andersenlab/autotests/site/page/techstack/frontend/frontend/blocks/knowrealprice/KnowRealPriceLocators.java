package com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.knowrealprice;

import org.openqa.selenium.By;

interface KnowRealPriceLocators {
    String SECTION_TEAM = "//section[@data-name='team']";
    By COUNT_JS_DEV = By.xpath(SECTION_TEAM + "//input[@data-name='JavaScript']");
    By PLUS_JS_DEV = By.xpath(SECTION_TEAM + "//input[@data-name='JavaScript']//following-sibling::span"); //span[contains(@class, 'js-calculator-plus')]
    By MINUS_JS_DEV = By.xpath(SECTION_TEAM + "//input[@data-name='JavaScript']//preceding-sibling::span"); //span[contains(@class, 'js-calculator-minus')]

    By COUNT_ANGULAR = By.xpath(SECTION_TEAM + "//input[@data-name='Angular']");
    By PLUS_ANGULAR = By.xpath(SECTION_TEAM + "//input[@data-name='Angular']//following-sibling::span");
    By MINUS_ANGULAR = By.xpath(SECTION_TEAM + "//input[@data-name='Angular']//preceding-sibling::span");

    By COUNT_REACT = By.xpath(SECTION_TEAM + "//input[@data-name='React.js']");
    By PLUS_REACT = By.xpath(SECTION_TEAM + "//input[@data-name='React.js']//following-sibling::span");
    By MINUS_REACT = By.xpath(SECTION_TEAM + "//input[@data-name='React.js']//preceding-sibling::span");

    String SECTION_OWN = "//section[@data-name='additional_services']";
    By COUNT_PM = By.xpath(SECTION_OWN + "//input[@data-name='Project Manager']");
    By PLUS_PM = By.xpath(SECTION_OWN + "//input[@data-name='Project Manager']//following-sibling::span");
    By MINUS_PM = By.xpath(SECTION_OWN + "//input[@data-name='Project Manager']//preceding-sibling::span");

    By COUNT_QA = By.xpath(SECTION_OWN + "//input[@data-name='QA Engineer']");
    By PLUS_QA = By.xpath(SECTION_OWN + "//input[@data-name='QA Engineer']//following-sibling::span");
    By MINUS_QA = By.xpath(SECTION_OWN + "//input[@data-name='QA Engineer']//preceding-sibling::span");

    By RESET_DEV = By.xpath(SECTION_TEAM + "//button[contains(@class, 'js-reset-section')]");
    By RESET_INCLUDE = By.xpath(SECTION_OWN + "//button[contains(@class, 'js-reset-section')]");

    String BASE_POPUP = "//section[@id='calc-popup-effective' and contains(@class, 'visible')]";
    By PANEL = By.xpath(BASE_POPUP);
    By CLOSE_BUTTON_PANEL = By.xpath(BASE_POPUP + "//button[contains(@class, 'close')]");

}

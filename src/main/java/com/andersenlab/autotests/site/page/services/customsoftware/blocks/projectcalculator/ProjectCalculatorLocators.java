package com.andersenlab.autotests.site.page.services.customsoftware.blocks.projectcalculator;

import org.openqa.selenium.By;

class ProjectCalculatorLocators {
    static final By PROJ_CALCULATOR_OPENER = By.xpath("//h2[text()[normalize-space()='Project calculator']]");
    static final By ADD_NET_DEV = By.xpath("(//input[@data-name='.NET']/following-sibling::span)[2]");
    static final By REMOVE_NET_DEV = By.xpath("(//input[@data-name='.NET']/preceding-sibling::span)[2]");
    static final By RESET_CALCULATOR = By.xpath("(//button[@type='reset'])[1]");
    static final By NET_DEV_COUNT = By.xpath("(//input[@data-name='.NET'])[2]");

}

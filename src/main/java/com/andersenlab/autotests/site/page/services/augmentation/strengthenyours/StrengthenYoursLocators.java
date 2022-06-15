package com.andersenlab.autotests.site.page.services.augmentation.strengthenyours;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface StrengthenYoursLocators {

    String GENERAL_BULLET_NAME_2 = "//div[@class='feature-module--column--Je_yn'][2]";
    String DIVS_GENERAL = "/div[@class='items-module--row--1EzPH']";
    String DIVS_MAJOR = "/div[@class='items-module--count--2OP6A']";
    String DIVS_NAME_MAJOR = "/div[@class='items-module--row--1EzPH']";
    String DIVS_SERGEANT = "/div[@class='items-module--descr--hfXms']";

    By STRENGTHEN_H2 = By.xpath("//div[@class='feature-module--column--Je_yn']/h2");
    By REQUEST_SPECIALIST_BUTTON = By.xpath("//span[contains(text(), 'Request specialists')]");
    By BULLET_1_NAME = By.xpath(GENERAL_BULLET_NAME_2 + DIVS_NAME_MAJOR + "[1]/h3");
    By BULLET_2_NAME = By.xpath(GENERAL_BULLET_NAME_2 + DIVS_NAME_MAJOR + "[2]/h3");
    By BULLET_3_NAME = By.xpath(GENERAL_BULLET_NAME_2 + DIVS_NAME_MAJOR + "[3]/h3");

   /**
    * TODO Подумать, как сделать красивее. Это описание из буллетов
    * Ожидаемый текст лежит частями в трех разных местах
    * Эти элементы нужны ТОЛЬКО что бы достать описание
    * */
    SelenideElement CHOOSE_TEXT_1 = $(By.xpath(GENERAL_BULLET_NAME_2 + DIVS_GENERAL + "[1]" + DIVS_SERGEANT));
    SelenideElement CHOOSE_TEXT_2 = $(By.xpath(GENERAL_BULLET_NAME_2 + DIVS_GENERAL + "[1]" + DIVS_MAJOR + "/div/span"));
    SelenideElement CHOOSE_TEXT_3 = $(By.xpath(GENERAL_BULLET_NAME_2 + DIVS_GENERAL + "[1]" + DIVS_MAJOR + "/span"));

    SelenideElement START_TEXT_1 = $(By.xpath(GENERAL_BULLET_NAME_2 + DIVS_GENERAL + "[2]" + DIVS_SERGEANT));
    SelenideElement START_TEXT_2 = $(By.xpath(GENERAL_BULLET_NAME_2 + DIVS_GENERAL + "[2]" + DIVS_MAJOR + "/div/span"));
    SelenideElement START_TEXT_3 = $(By.xpath(GENERAL_BULLET_NAME_2 + DIVS_GENERAL + "[2]" + DIVS_MAJOR + "/span"));

    SelenideElement RISK_TEXT_1 = $(By.xpath(GENERAL_BULLET_NAME_2 + DIVS_GENERAL + "[3]" + DIVS_SERGEANT));
    SelenideElement RISK_TEXT_2 = $(By.xpath(GENERAL_BULLET_NAME_2 + DIVS_GENERAL + "[3]" + DIVS_MAJOR + "/div/span"));
    SelenideElement RISK_TEXT_3 = $(By.xpath(GENERAL_BULLET_NAME_2 + DIVS_GENERAL + "[3]" + DIVS_MAJOR + "/span"));
}

package com.andersenlab.autotests.site.page.services.augmentation.benefits;

import org.openqa.selenium.By;

interface BenefitsLocators {

    String EXPECTED_INTRO = "Team augmentation benefits";
    String EXPECTED_subINTRO = "Extending your IT team with specialists provided by an outsourcing company is an advantageous solution. Here are four main benefits of including Andersen’s professionals in your project development";
    String BASE_INTRO_TEXT = "(//div[@class='box-md']/h2[contains(@class, 'title-module--title--2ZlKC')])[1]";
    String SECOND_PART_TO_INTRO = "/..//h3[contains(@class, 'title-module--title--2ZlKC')]";

    By INTRO_TEXT = By.xpath(BASE_INTRO_TEXT);
    By INTRO_DESCRIPTION = By.xpath(BASE_INTRO_TEXT + "/../p");
    By SET_ARTICLE_ICON = By.xpath(BASE_INTRO_TEXT + "/..//*[@class='Card-module--icon--2wyTT']");
    By SET_ARTICLE_INTRO = By.xpath(BASE_INTRO_TEXT + SECOND_PART_TO_INTRO);
    By SET_ARTICLE_DESCRIPTION = By.xpath(BASE_INTRO_TEXT + SECOND_PART_TO_INTRO + "/../p");
}

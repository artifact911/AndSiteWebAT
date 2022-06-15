package com.andersenlab.autotests.site.page.industries.healthcare.blocks;

import com.andersenlab.autotests.site.page.industries.igaming.blocks.ourprojectsblock.OurProjectsBlock;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.ourprojectsblock.OurProjectsLocators;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SomethingToThinkAboutBlock extends OurProjectsBlock {
    protected SomethingToThinkAboutLocators locators = new  SomethingToThinkAboutLocators();

    public SomethingToThinkAboutBlock(){
        title = $(locators.getTITLE());
        subtitle = $(locators.getSUBTITLE());
        showMore = $(locators.getSHOW_MORE());
        articleTitles = $$(locators.getARTICLE_TITLE());
        articleSubtitles = $$(locators.getARTICLE_SUBTITLE());
        articleCardButtons = $$(locators.getCARD_BUTTON());
        articleCardImages = $$(locators.getCARD_IMAGE());
    }
}

class SomethingToThinkAboutLocators extends OurProjectsLocators {
    private final String BASE = "//section[@id='concepts-list'][2]";
    private final String BASE_ARTICLE = "//article[contains(@class, 'ShowcaseItem-module--vcCard')]";
    @Getter private final By TITLE = By.xpath(BASE + "//p[contains(@class, 'title')]");
    @Getter private final By SUBTITLE = By.xpath(BASE + "//p[contains(@class, 'subtitle')]");
    @Getter private final By SHOW_MORE = By.xpath(BASE + "//div[contains(@class, 'showRow')]/button");
    @Getter private final By ARTICLE_TITLE = By.xpath(BASE_ARTICLE + "//p[contains(@class, 'title')]");
    @Getter private final By ARTICLE_SUBTITLE = By.xpath(BASE_ARTICLE + "//p[contains(@class, 'description')]");
    @Getter private final By CARD_BUTTON = By.xpath(BASE_ARTICLE + "//a");
    @Getter private final By CARD_IMAGE = By.xpath(BASE_ARTICLE + "//a[contains(@class, 'button')]//picture/img");
}
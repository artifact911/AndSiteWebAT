package com.andersenlab.autotests.site.page.industries.healthcare.blocks;

import com.andersenlab.autotests.site.page.industries.enterprise.blocks.CompetitorsChoose;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WhyCustomersChooseAndersen extends CompetitorsChoose{
    private final WhyCustomersChooseAndersenLocators locators = new WhyCustomersChooseAndersenLocators();

    public WhyCustomersChooseAndersen(String title, String subtitle, List<List<String>> articles){
        super(title, subtitle, articles);
        super.title = $(locators.getTITLE());
        super.subtitle = $(locators.getSUBTITLE());
        super.cardsTitles= $$(locators.getCARDS_TITLES());
        super.cardsTexts = $$(locators.getCARDS_TEXTS());
        super.cardsImages = $$(locators.getCARDS_IMAGES());
    }
}

class WhyCustomersChooseAndersenLocators {
    private final String BASE = "//p[contains(text(), 'Why Healthcare Companies Choose Andersen')]/../..";
    private final String CARD_BASE = "//article";

    @Getter private final By TITLE = By.xpath(BASE + "//p[contains(@class, 'title')]");
    @Getter private final By SUBTITLE = By.xpath(BASE + "//p[contains(@class, 'subtitle')]");
    @Getter private final By CARDS_TITLES = By.xpath(BASE + CARD_BASE + "//p[contains(@class, 'title')]");
    @Getter private final By CARDS_TEXTS = By.xpath(BASE + CARD_BASE + "//p[contains(@class, 'subtitle')]");
    @Getter private final By CARDS_IMAGES = By.cssSelector("article div > svg > use");
}
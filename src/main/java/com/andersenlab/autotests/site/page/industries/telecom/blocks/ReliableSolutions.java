package com.andersenlab.autotests.site.page.industries.telecom.blocks;

import com.andersenlab.autotests.site.page.industries.enterprise.blocks.CompetitorsChoose;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ReliableSolutions extends CompetitorsChoose{
    private final ReliableSolutionsLocators locators = new ReliableSolutionsLocators();

    public ReliableSolutions(String title, String subtitle, List<List<String>> articles){
        super(title, subtitle, articles);
        super.title = $(locators.getTITLE());
        super.subtitle = $(locators.getSUBTITLE());
        super.cardsTitles= $$(locators.getCARDS_TITLES());
        super.cardsTexts = $$(locators.getCARDS_TEXTS());
        super.cardsImages = $$(locators.getCARDS_IMAGES());
    }
}

class ReliableSolutionsLocators {
    private final String BASE = "//h2[contains(text(), 'Reliable telecom')]/../../..";
    private final String CARD_BASE = "//article";

    @Getter private final By TITLE = By.xpath(BASE + "//header/h2");
    @Getter private final By SUBTITLE = By.xpath(BASE + "//header/p");
    @Getter private final By CARDS_TITLES = By.xpath(BASE + CARD_BASE + "//h2");
    @Getter private final By CARDS_TEXTS = By.xpath(BASE + CARD_BASE + "//p");
    @Getter private final By CARDS_IMAGES = By.cssSelector("article div svg use");
}
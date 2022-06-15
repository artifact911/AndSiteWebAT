package com.andersenlab.autotests.site.page.industries.telecom.blocks;

import com.andersenlab.autotests.site.page.industries.enterprise.blocks.CompetitorsChoose;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OurServices extends CompetitorsChoose{
    private final OurServicesLocators locators = new OurServicesLocators();

    private final List<List<String>> expectedArticles;

    public OurServices(String title, String subtitle, List<List<String>> articles){
        super(title, subtitle, articles);
        super.title = $(locators.getTITLE());
        super.subtitle = $(locators.getSUBTITLE());
        super.cardsTitles= $$(locators.getCARDS_TITLES());
        super.cardsTexts = $$(locators.getCARDS_VALUES());
        super.cardsImages = $$(locators.getCARDS_IMAGES());
        this.expectedArticles = articles;
    }

    @Step
    @Override
    public void checkCards() {
        for (int i=0, k=0; i<cardsTitles.size(); i++){
            Assert.assertEquals(cardsTitles.get(i).getText(), expectedArticles.get(i).get(0));
            for (int j = 0; j<expectedArticles.get(i).get(1).split("\n").length; j++, k++)
                Assert.assertEquals(cardsTexts.get(k).getText(), expectedArticles.get(i).get(1).split("\n")[j]);
            Assert.assertTrue(cardsImages.get(i).getAttribute("xlink:href").contains(expectedArticles.get(i).get(2)));
        }
    }
}

class OurServicesLocators {
    private final String BASE = "//h2[contains(text(), 'Telecom software development services')]/../../..";
    private final String CARD_BASE = "//article";

    @Getter private final By TITLE = By.xpath(BASE + "//header/h2");
    @Getter private final By SUBTITLE = By.xpath(BASE + "//header/p");
    @Getter private final By CARDS_TITLES = By.xpath(BASE + CARD_BASE + "//h3");
    @Getter private final By CARDS_VALUES = By.xpath(BASE + CARD_BASE + "//h4");
    @Getter private final By CARDS_IMAGES = By.cssSelector("section:nth-child(2) article div svg use");
}
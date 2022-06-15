package com.andersenlab.autotests.site.page.industries.realestate.blocks;

import com.andersenlab.autotests.site.page.industries.enterprise.blocks.CompetitorsChoose;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BenefitsOfCustomSoftware extends CompetitorsChoose{
    private final BenefitsOfCustomSoftwareLocators locators = new BenefitsOfCustomSoftwareLocators();

    private final List<List<String>> expectedArticles;

    public BenefitsOfCustomSoftware(String title, String subtitle, List<List<String>> articles){
        super(title, subtitle, articles);
        super.title = $(locators.getTITLE());
        super.subtitle = $(locators.getSUBTITLE());
        super.cardsTitles= $$(locators.getCARDS_TITLES());
        super.cardsTexts = $$(locators.getCARDS_TEXTS());
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

class BenefitsOfCustomSoftwareLocators {
    private final String BASE = "//h2[contains(text(), 'benefits of custom real estate')]/../..";
    private final String CARD_BASE = BASE + "//article";

    @Getter private final By TITLE = By.xpath(BASE + "//h2");
    @Getter private final By SUBTITLE = By.xpath(BASE + "//p");
    @Getter private final By CARDS_TITLES = By.xpath(BASE + CARD_BASE + "//h3");
    @Getter private final By CARDS_TEXTS = By.xpath(BASE + CARD_BASE + "//h4");
    @Getter private final By CARDS_IMAGES = By.cssSelector("article div svg use");
}
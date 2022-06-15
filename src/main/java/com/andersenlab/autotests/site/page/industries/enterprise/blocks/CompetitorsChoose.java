package com.andersenlab.autotests.site.page.industries.enterprise.blocks;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CompetitorsChoose {
    private CompetitorsChooseLocators locators = new CompetitorsChooseLocators();
    public SelenideElement title = $(locators.getTITLE());
    public SelenideElement subtitle = $(locators.getSUBTITLE());
    public ElementsCollection cardsTitles= $$(locators.getCARDS_TITLES());
    public ElementsCollection cardsTexts = $$(locators.getCARDS_TEXTS());
    public ElementsCollection cardsImages = $$(locators.getCARDS_IMAGES());
    private final String expectedTitle;
    private final String expectedSubtitle;
    private final List<List<String>> expectedArticles;

    public CompetitorsChoose(String title, List<List<String>> articles){
        this.expectedTitle = title;
        this.expectedSubtitle = "";
        this.expectedArticles = articles;
    }

    public CompetitorsChoose(String title, String subtitle, List<List<String>> articles){
        this.expectedTitle = title;
        this.expectedSubtitle = subtitle;
        this.expectedArticles = articles;
    }

    @Step
    public void checkTitle(){
        Assert.assertEquals(title.getText(), expectedTitle);
        Assert.assertTrue(title.isDisplayed());
    }

    @Step
    public void checkSubtitle(){
        Assert.assertEquals(subtitle.getText(), expectedSubtitle);
        Assert.assertTrue(subtitle.isDisplayed());
    }

    @Step
    public void checkCards(){
        for (int i=0; i<cardsTitles.size(); i++){
            Assert.assertEquals(cardsTitles.get(i).getText(), expectedArticles.get(i).get(0));
            Assert.assertEquals(cardsTexts.get(i).getText(), expectedArticles.get(i).get(1));
            checkImage(cardsImages.get(i), expectedArticles.get(i).get(2));
        }
    }

    private void checkImage(SelenideElement image, String expectedLink){
        Assert.assertTrue(image.getAttribute("xlink:href").contains(expectedLink));
    }
}

class CompetitorsChooseLocators {
    private final String BASE = "//h2[contains(text(), 'competitors')]/../../..";
    private final String CARD_BASE = "//article";

    @Getter private final By TITLE = By.xpath(BASE + "//header/p[contains(@class, 'title')]");
    @Getter private final By SUBTITLE = By.xpath(BASE + "//header/p[contains(@class, 'subtitle')]");
    @Getter private final By CARDS_TITLES = By.xpath(BASE + CARD_BASE + "//h2");
    @Getter private final By CARDS_TEXTS = By.xpath(BASE + CARD_BASE + "//p");
    @Getter private final By CARDS_IMAGES = By.cssSelector("article div svg use");
}
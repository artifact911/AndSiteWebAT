package com.andersenlab.autotests.site.page.services.salesforce.blocks.improve;

import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
@Getter
public class Improve {
    private String BASE;
    private String url;
    private String POPUP_CLOSE;

    private SelenideElement title;
    private SelenideElement popupClose;
    private ElementsCollection articles;
    private ElementsCollection paragraphs;
    private ElementsCollection moreButtons;
    private int ARTS_QUANTITY;
    private String TEXT_TITLE;

    public Improve(String BASE, int ARTS_QUANTITY) {
        this.BASE = BASE;
        this.ARTS_QUANTITY = ARTS_QUANTITY;
        calc();
    }

    private void calc() {
        String TITLE;
        String ARTICLES;
        String MORE_BUTTONS;
        String PARAGRAPHS;
        TITLE = BASE + "//*[contains(text(), 'What we do')]";

        url = Warp.currentURL();
        if (url.contains("salesforce")) {
            ARTICLES = BASE + "//div[contains(@class, 'soft-dev-advantages__item-content')]";
            TEXT_TITLE = "Improve your business-to-customer collaboration";
        } else if (url.contains("quality-assurance-services")) {
            ARTICLES = BASE + "//article[contains(@class, 'card-default')]//h3[@class='card-default__title h4']";
            POPUP_CLOSE = "//div[contains(@id, 'custom-popup') and contains(@style, 'display: block;')]//div[contains(@class, 'popup__close')]";
            popupClose = $(By.xpath(POPUP_CLOSE));
            TEXT_TITLE = "What we do";
        } else if (url.contains("maintenance-support")) {
            ARTICLES = BASE + "//article[contains(@class, 'what-we-do__item')]";
            TEXT_TITLE = "What we do";
        } else if (url.contains("eLearning") & BASE.equals("//h2[contains(text(), 'What we do')]//..//..")) {
            ARTICLES = BASE + "//div[contains(@class, 'WhatWeDo-module--item')]";
            TEXT_TITLE = "What we do";
        } else if (url.contains("eLearning") & BASE.equals("//h2[contains(text(), 'Take full advantage of eLearning Software Development Services')]//..//..")) {
            ARTICLES = BASE + "//div[contains(@class, 'CardWithList-module--item')]";
            TEXT_TITLE = "Take full advantage of eLearning Software Development Services";
        } else if (url.contains("enterprise")) {
            ARTICLES = BASE + "//div[contains(@class, 'CardWithShadow-module')]";
            TEXT_TITLE = "Enterprise software development services";
        }else if (url.contains("custom-software-development") & BASE.equals("//section[contains(@class, 'what-we-do container container_gray_bg')]")) {
            ARTICLES = BASE + "//article[contains(@class, 'card-default')]";
            TEXT_TITLE = "What we do";
        } else throw new IllegalArgumentException();
        MORE_BUTTONS = ARTICLES + "//button";
        PARAGRAPHS = ARTICLES + "//p";
        title = $(By.xpath(TITLE));
        articles = $$(By.xpath(ARTICLES));
        moreButtons = $$(By.xpath(MORE_BUTTONS));
        paragraphs = $$(By.xpath(PARAGRAPHS));
    }

    @Step
    public void displayingElements() {
        Warp.scrollToElement(title);
        Assert.assertEquals(title.getAttribute("innerText"), TEXT_TITLE);
        title.should(Condition.visible);
        Assert.assertEquals(articles.size(), ARTS_QUANTITY);

        for (int i = 0; i < ARTS_QUANTITY; i++) {
            SelenideElement art = articles.get(i);
            Assert.assertTrue(art.isDisplayed());
            if (url.contains("qa-engineers")) checkArtQA(i);
            else if (url.contains("salesforce")) checkArtSalesForce(i); //блоки, для которых проверяется только количество,  в этом ветвлении не упоминается
        }
    }

    private void checkArtSalesForce(int i) {
        String s = paragraphs.get(i).getAttribute("innerText");
        moreButtons.get(i).click();
        Assert.assertTrue(s.length() < paragraphs.get(i).getAttribute("innerText").length());
        moreButtons.get(i).click();
        Assert.assertEquals(s, paragraphs.get(i).getAttribute("innerText"));
    }

    private void checkArtQA(int i) {
        Assert.assertEquals(Warp.isElementPresent(POPUP_CLOSE), 0);
        moreButtons.get(i).click();
        Assert.assertEquals(Warp.isElementPresent(POPUP_CLOSE), 1);
        popupClose.click();
        Warp.delay(1);
        Assert.assertEquals(Warp.isElementPresent(POPUP_CLOSE), 0);
    }

}

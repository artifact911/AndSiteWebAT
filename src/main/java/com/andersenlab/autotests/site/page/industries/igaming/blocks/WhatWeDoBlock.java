package com.andersenlab.autotests.site.page.industries.igaming.blocks;

import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class WhatWeDoBlock extends WhatWeDoLocators {
    private final SelenideElement title = $(getTITLE());
    private final ElementsCollection articleTitles = $$(getARTICLE_TITLES());
    private final ElementsCollection seeMore = $$(getSEE_MORE());
    private final ElementsCollection requestService = $$(getREQUEST_SERVICE());

    private final SelenideElement popupTitle = $(getPOPUP_TITLE());
    private final SelenideElement popupCloseBtn = $(getPOPUP_CLOSE_BTN());

    @Step
    public void checkWhatWeDoTitle(){
        Assert.assertEquals(title.getText(), textTitle());
    }

    @Step
    public void checkWhatWeDoCards(){
        for (SelenideElement btn: seeMore){
            Assert.assertFalse(popupTitle.isDisplayed());
            btn.click();
            Warp.delay(1);
            Assert.assertTrue(popupTitle.isDisplayed());
            popupCloseBtn.click();
            Warp.delay(1);
            Assert.assertFalse(popupTitle.isDisplayed());
        }
    }

    @Step
    public void checkWhatWeDoArticles(){
        for (int index=0; index<articleTitles.size(); index++){
            Assert.assertTrue(articleTitles.get(index).isDisplayed());
            Assert.assertFalse(seeMore.get(index).exists());
        }
    }
    private String textTitle(){
        //дописывать по необходимости
        switch (Warp.tabTitle()) {
            case "Custom EMR Software Development":
                return "Custom EHR/EMR software solutions";
            case "IoMT and Healthcare Data Analytics solutions | Andersen":
                return "Healthcare Data Analytics Solutions";
            case "Custom Healthcare and Medical Software Development":
                return "Custom Healthcare Software Solutions";
            case "Telemedicine software development":
                return "Custom Telehealth & Telemedicine Solutions";
            case "Custom eLearning Development Services - Andersen":
            case "Custom Enterprise Software for Your Growth":
            case "Software Development for the Online Gambling Industry | Andersenlab":
            case "Retail Software Development | Andersen":
            case "Telecom Software Development - Custom Telecom Solutions - Andersen":
            case "Custom Software Development for Media & Entertainment | Andersen":
                return "What we do";
            default:
                throw new IllegalArgumentException();
        }
    }
}

@Getter
class WhatWeDoLocators {
    private final String SECTION_BASE = "//div[contains(@class, 'WhatWeDo')]//..//../div[@class='box-md']";
    private final By TITLE = By.xpath(SECTION_BASE + "//h2");
    private final By ARTICLE_TITLES = By.xpath(SECTION_BASE + "//article//h3");
    private final By SEE_MORE = By.xpath(SECTION_BASE + "//article//button");
    private final By REQUEST_SERVICE = By.xpath(SECTION_BASE + "//div[contains(@class, 'Alert-module--hint')]//button");

    private final String POPUP_BASE = "//section[contains(@class, 'popup')]";
    private final By POPUP_TITLE = By.xpath(POPUP_BASE + "//*[contains(@class,'title-module--title') and not(contains(@class,'Card'))]");
    private final By POPUP_CLOSE_BTN = By.xpath(POPUP_BASE + "//button[contains(@class,'close')]");
}


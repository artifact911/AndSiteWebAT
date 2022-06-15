package com.andersenlab.autotests.site.logic;

import com.andersenlab.autotests.core.configs.constants.CSSProperties;
import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.OurSportsBettingServicesBlock;
import com.andersenlab.autotests.site.utility.Warp;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.Wait;

public class WhatWeDoGridCheck {
    private final String active = "wIj48cGF0aCBzdHJva2U9IiNGRURBMDAiIGQ9Ik0xIDkuNUw1LjUgNSAxIC41Ii8+PC9zdmc+";
    private final String unactive = "xIj48cGF0aCBzdHJva2U9IiM1NTYxNzAiIGQ9Ik0xIDEwbDQuNS00LjVMMSAxIi8+PC9zdmc+";
    private final OurSportsBettingServicesBlock ourSportsBettingServicesBlock = new OurSportsBettingServicesBlock();

    @Step
    public void checkTitleAndSubtitle(String title, String subtitle){
        Assert.assertEquals(ourSportsBettingServicesBlock.getTitle().getText(), title);
    }

    @Step
    public void checkArticlesGrid(List<String> buttons, List<String> titles, List<String> texts){
        Assert.assertEquals(ourSportsBettingServicesBlock.getArticleTitle().getText(), titles.get(0));
        Assert.assertEquals(ourSportsBettingServicesBlock.getButtonsTitles().get(0).getText(), buttons.get(0));
        Assert.assertEquals(ourSportsBettingServicesBlock.getArticle().getText(), texts.get(0));
        for (int i=1; i<ourSportsBettingServicesBlock.getButtons().size(); i++){
            Assert.assertTrue(ourSportsBettingServicesBlock.getButtons().get(i-1).getCssValue("background-image").contains(active));
            Assert.assertTrue(ourSportsBettingServicesBlock.getButtons().get(i).getCssValue("background-image").contains(unactive));
            ourSportsBettingServicesBlock.getButtons().get(i).click();
            Assert.assertTrue(ourSportsBettingServicesBlock.getButtons().get(i).getCssValue("background-image").contains(active));
            ourSportsBettingServicesBlock.getButtons().get(i-1).click();
            Wait().until(ExpectedConditions.attributeToBe(ourSportsBettingServicesBlock.getButtons().get(i),"background-color",CSSProperties.Color.INVISIBLE.getCode()));
            Assert.assertEquals(ourSportsBettingServicesBlock.getButtons().get(i).getCssValue("background-color"), CSSProperties.Color.INVISIBLE.getCode());
            Assert.assertEquals(ourSportsBettingServicesBlock.getButtons().get(i).hover().getCssValue("background-color"), CSSProperties.Color.WHITE.getCode());
            Assertions.mouseIsPointer(ourSportsBettingServicesBlock.getButtons().get(i));
            ourSportsBettingServicesBlock.getButtons().get(i).click();
            Assert.assertEquals(ourSportsBettingServicesBlock.getButtons().get(i).getCssValue("background-color"), CSSProperties.Color.WHITE.getCode());
            Assert.assertEquals(ourSportsBettingServicesBlock.getArticleTitle().getText(), titles.get(i));
            Assert.assertEquals(ourSportsBettingServicesBlock.getButtonsTitles().get(i).getText(), buttons.get(i));
            Assert.assertEquals(ourSportsBettingServicesBlock.getArticle().getText(), texts.get(i));
        }
    }
}

package com.andersenlab.autotests.site.logic;

import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.ourprojectsblock.OurProjectsBlock;
import com.andersenlab.autotests.site.utility.Warp;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.Wait;

public class OurProjectsCheck {
    protected OurProjectsBlock block;

    public OurProjectsCheck(){
        block = new OurProjectsBlock();
    }

    @Step
    public void checkTitleAndSubtitle(String title, String subtitle){
        Assert.assertEquals(block.getTitle().getText(), title);
        Assert.assertEquals(block.getSubtitle().getText(), subtitle);
    }

    @Step
    public void checkCaseCards(List<List<String>> cards){
        while (block.getShowMore().isDisplayed())
        {
            block.getShowMore().click();
        }
        Assert.assertFalse(block.getShowMore().isDisplayed());
        for(int index=0; index<cards.size(); index++){
            checkCaseCard(index, cards.get(index));
        }
    }

    @Step
    public void checkCardLinks(List<List<String>> cards){
        for(int index=0; index<cards.size(); index++){
            Warp.checkLinkNewTab(block.getArticleCardButtons().get(index), cards.get(index).get(3));
        }
    }

    private void checkCaseCard(int index, List<String> card){
        Assert.assertEquals(block.getArticleTitles().get(index).getText(), card.get(0));
        Assert.assertEquals(block.getArticleSubtitles().get(index).getText(), card.get(1));
        Assertions.mouseIsPointer(block.getArticleCardButtons().get(index));
        Wait().until(ExpectedConditions.visibilityOf(block.getArticleCardImages().get(index)));
        Assert.assertTrue(block.getArticleCardImages().get(index).getAttribute("src").contains(card.get(2)));
    }
}

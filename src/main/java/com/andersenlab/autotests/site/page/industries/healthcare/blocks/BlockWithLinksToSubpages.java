package com.andersenlab.autotests.site.page.industries.healthcare.blocks;

import com.andersenlab.autotests.core.configs.constants.CSSProperties.Color;
import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BlockWithLinksToSubpages {
    private final BlockWithLinksToSubpagesLocators locators = new BlockWithLinksToSubpagesLocators();

    protected SelenideElement title = $(locators.getTITLE());
    protected ElementsCollection subtitle = $$(locators.getSUBTITLE());
    protected ElementsCollection links = $$(locators.getLINKS());
    protected ElementsCollection images = $$(locators.getIMAGES());
    protected ElementsCollection titles = $$(locators.getARTICLE_TITLES());
    protected SelenideElement linkToMain = $(locators.getLINK_TO_MAIN());

    private final List<String> expectedTexts;
    private final List<List<String>> expectedCards;
    private List<String> expectedLinkToMain = Arrays.asList("", "", "");

    public BlockWithLinksToSubpages(List<String> texts, List<List<String>> cards){
        expectedTexts = texts;
        expectedCards = cards;
    }
    public BlockWithLinksToSubpages(List<String> texts, List<List<String>> cards, List<String> link){
        expectedTexts = texts;
        expectedCards = cards;
        expectedLinkToMain = link;
    }

    public void checkMainPageBlock(){
        Warp.scrollToElement(locators.getLINKS());
        checkBlockTexts();
        checkArticles();
    }

    public void checkSubpageBlock(){
        checkBlockTexts();
        checkArticles();
    }

    @Step
    private void checkBlockTexts(){
        Assert.assertEquals(title.getText(), expectedTexts.get(0));
        if (subtitle.size()>1){
            Assert.assertEquals(subtitle.get(0).getText(), expectedTexts.get(1));
            Assert.assertEquals(subtitle.get(1).getText(), expectedTexts.get(2));
        }
        else if (subtitle.size()==1){
            Assert.assertEquals(subtitle.get(0).getText(), expectedTexts.get(1));
        }
    }

    @Step
    private void checkArticles(){
        for(int index=0; index<titles.size(); index++){
            Assert.assertEquals(titles.get(index).getText(), expectedCards.get(index).get(0));
            Assert.assertTrue(images.get(index).getAttribute("xlink:href").contains(expectedCards.get(index).get(1)));
            checkLink(links.get(index), expectedCards.get(index).get(2));
        }
    }

    @Step
    private void checkLinkToMainPage(){
        Assert.assertEquals(linkToMain.getText(), expectedLinkToMain.get(0));
        Assert.assertTrue(linkToMain.getAttribute("href").contains(expectedLinkToMain.get(2)));
        Assert.assertEquals(linkToMain.getCssValue("color"), Color.BLACK_LINK.getCode());
        Assert.assertEquals(linkToMain.hover().getCssValue("color"), Color.YELLOW.getCode());
        Assertions.mouseIsPointer(linkToMain);
    }

    @Step
    private void checkLink(SelenideElement element, String link){
        if(!element.has(Condition.attribute("href")))
            Assert.assertTrue(element.parent().getAttribute("href").contains(link));
        else
            Assert.assertTrue(element.getAttribute("href").contains(link));
        Assert.assertEquals(element.getText(), "See more");
        Assert.assertEquals(element.getCssValue("color"), Color.BLACK_LINK.getCode());
        Assert.assertEquals(element.hover().getCssValue("color"), Color.YELLOW.getCode());
        Assertions.mouseIsPointer(element);
    }
}

class BlockWithLinksToSubpagesLocators{
    private final String BASE = "//h2[contains(text(), 'Healthcare Software Solutions and Services')]/../..";

    @Getter private final By TITLE = By.xpath(BASE + "//h2");
    @Getter private final By SUBTITLE = By.xpath(BASE + "//h2/following-sibling::p");
    @Getter private final By LINKS = By.xpath(BASE + "//a[contains(@class,'SmallCard-module--item--R8a4y')]//div");
    @Getter private final By IMAGES = By.cssSelector("a.SmallCard-module--item--R8a4y svg use");
    @Getter private final By ARTICLE_TITLES = By.xpath(BASE + "//a[contains(@class,'SmallCard-module--item--R8a4y')]//h3");
    @Getter private final By LINK_TO_MAIN = By.xpath(BASE + "//a[contains(@class,'SmallCard-module--item--R8a4y')]");
}
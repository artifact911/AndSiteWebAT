package com.andersenlab.autotests.site.page.services.customsoftware.blocks.featuresindex;

import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.form.popup.requestform.RequestForm;
import com.andersenlab.autotests.site.form.commonforms.FormData;
import com.andersenlab.autotests.site.utility.Warp;
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

@Getter
public class FeaturesIndex implements FormData {
    private final FeaturesIndexLocators locators = new FeaturesIndexLocators();
    private final SelenideElement title = $(locators.getTITLE());
    private final SelenideElement img = $(locators.getIMG());
    private final SelenideElement subtitle = $(locators.getSUBTITLE());
    private final SelenideElement buttonReq = $(locators.getBTN());
    private final ElementsCollection articlesTitles = $$(locators.getARTICLES_TITLES());
    private final ElementsCollection articlesTexts = $$(locators.getARTICLES_TEXTS());
    private final ElementsCollection articlesCountDescription = $$(locators.getARTICLES_COUNT_DESCR());

    private final String expectedTitle;
    private final String expectedImgLink;
    private final String expectedSubtitle;
    private final String expectedBtnTitle;
    private final List<List<String>> expectedArticles;

    public FeaturesIndex(List<String> left, List<List<String>> right){
        this.expectedTitle = left.get(0);
        this.expectedSubtitle = left.get(1);
        this.expectedImgLink = left.get(2);
        this.expectedBtnTitle = left.get(3);
        this.expectedArticles = right;
    }

    public FeaturesIndex(){
        this.expectedTitle = "";
        this.expectedImgLink = "";
        this.expectedSubtitle = "";
        this.expectedBtnTitle = "Request consultation";
        this.expectedArticles = Arrays.asList(Arrays.asList("", "", ""), Arrays.asList("", "", ""), Arrays.asList("", "", ""));
    }

    @Step
    public void displayingElementsAndFunction(String title) {
        Assertions.mouseIsPointer(buttonReq);
        buttonReq.click();
        Warp.delay(1);
        new RequestForm(title).checkTitle();
        new RequestForm(title).closeReq();
    }

    @Step
    public void checkTitle(){
        Assert.assertEquals(title.getText(), expectedTitle);
    }

    @Step
    public void checkSubtitle(){
        if (subtitle.exists())
            Assert.assertEquals(subtitle.getText(), expectedSubtitle);
    }

    @Step
    public void checkImg(){
        Assert.assertTrue(img.getAttribute("xlink:href").contains(expectedImgLink));
    }

    @Step
    public void checkBtn(){

        Assert.assertEquals(buttonReq.getText(), expectedBtnTitle);
        Assertions.mouseIsPointer(buttonReq);
        openPopup();
        Warp.delay(1);
        new RequestForm(expectedBtnTitle).checkTitle();
        new RequestForm(expectedBtnTitle).closeReq();
    }

    @Step
    public void checkArticles(){
        for (int index=0; index<expectedArticles.size(); index++){
            Assert.assertEquals(articlesTitles.get(index).getText(), expectedArticles.get(index).get(0));
            Assert.assertEquals(articlesTexts.get(index).getText(), expectedArticles.get(index).get(1));
            Assert.assertEquals(articlesCountDescription.get(index).getText(), expectedArticles.get(index).get(2));
        }
    }

    @Step
    public void openPopup(){
        buttonReq.click();
    }
}

class FeaturesIndexLocators{
    private final String BASE = "section.feature-module--container--20iFg";
    private final String ARTICLES = " div.items-module--row--1EzPH";

    @Getter private final By TITLE = By.cssSelector(BASE + " h2");
    @Getter private final By SUBTITLE = By.cssSelector(BASE + " p");
    @Getter private final By IMG = By.cssSelector(BASE + " svg use");
    @Getter private final By BTN = By.cssSelector(BASE + " button");
    @Getter private final By ARTICLES_TITLES = By.cssSelector(BASE + ARTICLES + " h3");
    @Getter private final By ARTICLES_TEXTS = By.cssSelector(BASE + ARTICLES + " div.items-module--descr--hfXms");
    @Getter private final By ARTICLES_COUNT_DESCR = By.cssSelector(BASE + ARTICLES + " span.font-size-sm");
}

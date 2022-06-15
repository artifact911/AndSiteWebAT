package com.andersenlab.autotests.site.page.services.augmentation.benefits;

import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class Benefits implements BenefitsLocators {

    private final SelenideElement textIntro = $(INTRO_TEXT);
    private final SelenideElement textDescription = $(INTRO_DESCRIPTION);
    private final ElementsCollection setArticleIcon = $$(SET_ARTICLE_ICON);
    private final ElementsCollection setArticleIntro = $$(SET_ARTICLE_INTRO);
    private final ElementsCollection setArticleDescription = $$(SET_ARTICLE_DESCRIPTION);

    @Step
    public void checkIntro() {
        Warp.scrollToElement(textIntro);
        Assert.assertEquals(textIntro.getText(), EXPECTED_INTRO);
        Assert.assertEquals(textDescription.getText(), EXPECTED_subINTRO);
    }

    @Step
    public void checkArticlesAmount() {
        Assert.assertTrue(setArticleIcon.size() == 4
                && setArticleIntro.size() == 4
                && setArticleDescription.size() == 4);
    }
}

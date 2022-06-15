package com.andersenlab.autotests.site.page.industries.retail;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class CustomSoftwareDevelopmentBlock extends CustomSoftwareDevelopmentBlockLocators{
    private final SelenideElement title = $(getTITLE());
    private final SelenideElement subtitle = $(getSUBTITLE());
    public ElementsCollection articleTitles= $$(getARTICLE_TITLES());
    public ElementsCollection articleTexts = $$(getARTICLE_TEXTS());
    public ElementsCollection articleImages = $$(getARTICLE_IMAGES());

    @Step
    public void checkImg(SelenideElement img, String expectedImgLink) {
        Assert.assertTrue(img.getAttribute("xlink:href").contains(expectedImgLink));
    }

    @Step
    public void checkTitle(String expectedTitle, String expectedSubtitle) {
        Assert.assertEquals(title.getText(), expectedTitle);
        Assert.assertEquals(subtitle.getText(), expectedSubtitle);
    }

    @Step
    public void checkArticles(List<List<String>> cards) {
        for (int i=0; i<cards.size(); i++){
            Assert.assertEquals(articleTitles.get(i).getText(), cards.get(i).get(0));
            Assert.assertEquals(articleTexts.get(i).getText(), cards.get(i).get(1));
            checkImg(articleImages.get(i), cards.get(i).get(2));
        }
    }
}

class CustomSoftwareDevelopmentBlockLocators{
    private final String BASE = "//main/section[2]";
    @Getter private final By TITLE = By.xpath(BASE + "//h2");
    @Getter private final By SUBTITLE = By.xpath(BASE + "//p");
    @Getter private final By ARTICLE_TITLES = By.xpath(BASE + "//article//h3");
    @Getter private final By ARTICLE_TEXTS = By.xpath(BASE + "//article//p");
    @Getter private final By ARTICLE_IMAGES = By.cssSelector("article div svg use");
}

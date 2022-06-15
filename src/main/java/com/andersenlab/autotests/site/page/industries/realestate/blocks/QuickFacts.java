package com.andersenlab.autotests.site.page.industries.realestate.blocks;

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

public class QuickFacts {
    private final QuickFactsLocators locators = new QuickFactsLocators();
    private final SelenideElement title = $(locators.getTITLE());
    private final SelenideElement img = $(locators.getIMG());
    private final ElementsCollection list = $$(locators.getLIST());

    private final String expectedTitle = "Quick fact";
    private final String expectedImgLink = "#question";
    private final List<String> expectedTexts = Arrays.asList(
            "Nowadays, up to 93% of purchasers use applications and websites to solve their housing problem.",
            "At the same time, only 17% of people turn to real estate agents before studying the available information on the Internet. According to Technavio, this trend will remain, and in the coming years, the share of digital solutions in the real estate market will grow by 8% CAGR."
    );

    @Step
    public void checkTitle(){
        Assert.assertEquals(title.getText(), expectedTitle);
        Assert.assertTrue(img.getAttribute("xlink:href").contains(expectedImgLink));
    }

    @Step
    public void checkTexts(){
        for (int index = 0; index<expectedTexts.size(); index++){
            Assert.assertEquals(list.get(index).getText(), expectedTexts.get(index));
        }
    }
}

class QuickFactsLocators{
    private final String BASE = "section.QuickFacts-module--container--1sLXO";
    @Getter private final By TITLE = By.cssSelector(BASE + " h2");
    @Getter private final By IMG = By.cssSelector(BASE + " svg use");
    @Getter private final By LIST = By.cssSelector(BASE + " li");
}

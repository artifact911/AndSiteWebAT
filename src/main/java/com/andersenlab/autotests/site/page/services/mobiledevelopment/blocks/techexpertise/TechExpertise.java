package com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.techexpertise;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TechExpertise {
    private String BASE;
    private By TITLE;
    private By ARTICLES_TITLE;
    private SelenideElement Title;
    private ElementsCollection Arts;
    private String TEXT_TITLE;
    private String[] TEXT_ARTICLES_TITLE;

    public TechExpertise(String BASE) {
        this.BASE = BASE;
        calc();
    }

    private void calc(){
        TITLE = By.xpath(BASE + "//h2[contains(text(), 'Andersen')]");
        ARTICLES_TITLE = By.xpath(BASE + "//h2[contains(@class, 'Card-module--title--26C22')]");
        Title = $(TITLE);
        Arts = $$(ARTICLES_TITLE);
        TEXT_TITLE = new ProblemsTextsC(BASE).getTEXT_TITLE();
        TEXT_ARTICLES_TITLE = new ProblemsTextsC(BASE).getTEXT_ARTICLES_TITLE();
    }

    @Step
    public void displayingElementsAndFunction() {
        Assert.assertEquals(Title.getAttribute("innerText"), TEXT_TITLE);
        for (int i = 0; i < Arts.size(); i++) {
            Assert.assertEquals(Arts.get(i).getAttribute("innerText"), TEXT_ARTICLES_TITLE[i]);
        }
    }
}

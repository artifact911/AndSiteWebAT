package com.andersenlab.autotests.site.page.services.customsoftware.blocks.page;


import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

/**
 * Страница Custom software development  https://dev.andersenlab.com/services/custom-software-development
 */
@Getter
public class Page {
    private PageTexts pageTexts;
    private final String BASE = "//section[contains(@class, 'intro')]";
    private final By TITLE = By.xpath(BASE + "//h1");
    private final By META1 = By.xpath("//meta[@name='description']");
    private final By META2 = By.xpath("//meta[@property='og:title']");
    private final By META3 = By.xpath("//meta[@property='og:description']");

    //связывание статическое - на этапе компиляции. если значения полей станет нужно менять во время выполнения, то
    //объявлять сдесь, а считать в конструкторе
    private SelenideElement Title = $(TITLE);
    private SelenideElement Meta1 = $(META1);
    private SelenideElement Meta2 = $(META2);
    private SelenideElement Meta3 = $(META3);

    public Page(PageTexts pageTexts) {
        this.pageTexts = pageTexts;
    }

    @Step
    public void displayingTitle() {
        Assert.assertEquals(Warp.tabTitle(), pageTexts.getTEXT_TITLE_TAB());
        Assert.assertEquals(Title.getAttribute("innerText"), pageTexts.getTEXT_TITLE());

        Assert.assertEquals(Meta1.getAttribute("content"), pageTexts.getCONTENT_DESCR());
        Assert.assertEquals(Meta2.getAttribute("content"), pageTexts.getCONTENT_TITLE());
        Assert.assertEquals(Meta3.getAttribute("content"), pageTexts.getCONTENT_DESCR());

    }
}

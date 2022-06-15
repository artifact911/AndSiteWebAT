package com.andersenlab.autotests.site.page.industries.igaming.blocks;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class SoftwareDevelopment extends SoftwareDevelopmentLocators{
    private final SelenideElement title = $(getTITLE());
    private final SelenideElement subtitle = $(getSUBTITLE());
    private final ElementsCollection articles = $$(getARTICLES());
    private final ElementsCollection articleTitle = $$(getARTICLE_TITLES());
    private final ElementsCollection linksSeeMore = $$(getLINKS_SEE_MORE());
}

@Getter
class SoftwareDevelopmentLocators {
    private final String BASE = "//h2[contains(text(), 'software development')]//..//..//../div[@class='box-md']";
    private final By TITLE = By.xpath(BASE + "/header/h2");
    private final By SUBTITLE = By.xpath(BASE + "/header/p");
    private final By ARTICLES = By.xpath(BASE + "//article");
    private final By ARTICLE_TITLES = By.xpath(BASE + "//article//h2");
    private final By LINKS_SEE_MORE = By.xpath(BASE + "//article//a[@href]");
}
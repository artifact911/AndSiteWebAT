package com.andersenlab.autotests.site.page.industries.healthcare.blocks.heading;

import com.andersenlab.autotests.site.page.industries.healthcare.blocks.BlockWithLinksToSubpages;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BlockWithLinksToServices extends BlockWithLinksToSubpages {
    BlockWithLinksToServicesLocators locators = new BlockWithLinksToServicesLocators();

    public BlockWithLinksToServices(List<String> texts, List<List<String>> cards){
        super(texts, cards);
        title = $(locators.getTITLE());
        subtitle = $$(locators.getSUBTITLE());
        links = $$(locators.getLINKS());
        images = $$(locators.getIMAGES());
        titles = $$(locators.getARTICLE_TITLES());
    }
}

class BlockWithLinksToServicesLocators {
    private final String BASE = "//h2[contains(text(), 'Check out our consultancy services')]/../..";

    @Getter private final By TITLE = By.xpath(BASE + "//h2");
    @Getter private final By SUBTITLE = By.xpath(BASE + "//h2/following-sibling::p");
    @Getter private final By LINKS = By.xpath(BASE + "//a");
    @Getter private final By IMAGES = By.cssSelector("div.SmallCard-module--item--R8a4y svg use");
    @Getter private final By ARTICLE_TITLES = By.xpath(BASE + "//h3");
}
package com.andersenlab.autotests.site.page.industries.healthcare.blocks;

import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AdvisoryBlock{
    AdvisoryBlockLocators locators = new AdvisoryBlockLocators();

    private final SelenideElement title = $(locators.getTITLE());
    private final SelenideElement subtitle = $(locators.getSUBTITLE());
    private final ElementsCollection photos = $$(locators.getPHOTO());
    private final ElementsCollection names = $$(locators.getNAME_TEXT());
    private final ElementsCollection namesLinks = $$(locators.getNAME_LINK());
    private final ElementsCollection linkedinLinks = $$(locators.getLINKEDIN());
    private final ElementsCollection positions = $$(locators.getPOSITION());
    private final ElementsCollection bios = $$(locators.getBIO());

    @Step
    public void checkBlock(List<String> block){
        Assert.assertEquals(title.getText(), block.get(0));
        Assert.assertEquals(subtitle.getText(), block.get(1));
    }

    @Step
    public void checkAdvisory(List<List<String>> advisory){
        for (int index=0; index<names.size(); index++){
            checkLink(names.get(index), namesLinks.get(index), linkedinLinks.get(index), advisory.get(index));
            checkExpert(photos.get(index), positions.get(index), bios.get(index), advisory.get(index));
        }
    }

    private void checkExpert(SelenideElement photo, SelenideElement position, SelenideElement bio, List<String> expert){
        Assert.assertTrue(photo.getAttribute("src").contains(expert.get(0)));
        Assert.assertEquals(position.getText(), expert.get(3));
        Assert.assertEquals(bio.getText(), expert.get(4));
    }

    private void checkLink(SelenideElement name, SelenideElement nameLink, SelenideElement linkedin, List<String> expert){
        Assert.assertEquals(name.getText(), expert.get(2));
        Warp.checkLinkNewTab(nameLink, expert.get(1));
        Assertions.mouseIsPointer(name);
        Assertions.mouseIsPointer(linkedin);
    }
}

class AdvisoryBlockLocators{
    private final String BASE = "//div[contains(@class, 'Сonsultants-module--container')]";

    @Getter private final By TITLE = By.xpath(BASE + "//p");
    @Getter private final By SUBTITLE = By.xpath(BASE + "//p[contains(@class, 'subtitle')]");
    @Getter private final By PHOTO = By.xpath(BASE + "//img");
    @Getter private final By NAME_LINK = By.xpath(BASE + "//article//a");
    @Getter private final By NAME_TEXT = By.xpath(BASE + "//p[contains(@class, 'authorName')]");
    @Getter private final By LINKEDIN = By.xpath(BASE + "//article//*[name()='svg']");
    @Getter private final By POSITION = By.xpath(BASE + "//article//figcaption//p[contains(@class, 'subtitle')]");
    @Getter private final By BIO = By.xpath(BASE + "//article/p[contains(@class, 'subtitle')]");
}
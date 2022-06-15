package com.andersenlab.autotests.site.page.industries.videoandentertainment.blocks;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CompanyOfExperts {
    private final CompanyOfExpertsLocators locators = new CompanyOfExpertsLocators();

    private final SelenideElement title = $(locators.getTITLE());
    private final SelenideElement subtitle = $(locators.getSUBTITLE());
    private final ElementsCollection icons = $$(locators.getICON());
    private final ElementsCollection iconsNames = $$(locators.getICON_NAME());

    private final String expectedTitle;
    private final String expectedSubtitle;
    private final List<List<String>> certificates;

    public CompanyOfExperts(List<String> text, List<List<String>> certificates){
        expectedTitle = text.get(0);
        expectedSubtitle = text.get(1);
        this.certificates = certificates;
    }

    @Step
    public void checkTitle(){
        Assert.assertEquals(title.getText(), expectedTitle);
    }

    @Step
    public void checkSubtitle(){
        Assert.assertEquals(subtitle.getText(), expectedSubtitle);
    }

    @Step
    public void checkCertificates(){
        for (int index=0; index<certificates.size(); index++){
            Assert.assertEquals(icons.get(index).getAttribute("data-src"), certificates.get(index).get(0));
            Assert.assertEquals(iconsNames.get(index).getText(), certificates.get(index).get(1));
        }
    }

    @Step
    public void checkLogos(){
        for (int index=0; index<certificates.size(); index++){
            Assert.assertEquals(icons.get(index).getAttribute("data-src"), certificates.get(index).get(0));
        }
    }
}

class CompanyOfExpertsLocators{
    private final String BASE = "//section[contains(@class, 'CompanyOfExperts-module--container--3MwPC')]";

    @Getter private final By TITLE = By.xpath(BASE + "//p[contains(@class, 'title')]");
    @Getter private final By SUBTITLE = By.xpath(BASE + "//p[contains(@class, 'subtitle')]");
    @Getter private final By ICON = By.xpath(BASE + "//img");
    @Getter private final By ICON_NAME = By.xpath(BASE + "//figcaption");
}
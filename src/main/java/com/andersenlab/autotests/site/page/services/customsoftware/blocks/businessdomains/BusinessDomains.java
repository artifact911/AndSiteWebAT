package com.andersenlab.autotests.site.page.services.customsoftware.blocks.businessdomains;

import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BusinessDomains {

    String BASE = "//section[@id='industries']";
    private final SelenideElement title = $(By.xpath(BASE + "//h2[contains(text(), 'Expert custom solutions')]"));
    private final SelenideElement description = $(By.xpath(BASE + "//p[contains(@class, 'subtitle')]"));
    private final ElementsCollection cards = $$(By.xpath(BASE + "//a[contains(@href, 'industries')]"));
    private final ElementsCollection seeMoreButton = $$(By.xpath(BASE + "//div[@class='CardWithShadow-module--link--1KgAX']"));

    String TEXT_TITLE = "Expert custom solutions with over 1000+ projects delivered";
    String TEXT_DESCRIPTION = "Assisting businesses across major industries address complex problems with technology solutions. We use industry-specific knowledge to custom-tailor solutions to meet each customer's unique needs.";
    String[] TEXT_HREFS = {
            "https://stage.andersenlab.com/industries/financial-services",
            "https://stage.andersenlab.com/industries/logistics",
            "https://stage.andersenlab.com/industries/healthcare",
            "https://stage.andersenlab.com/industries/retail"
    };

    @Step
    public void displayingElements() {
        Warp.scrollToElement(BASE);
        title.shouldBe(Condition.visible);
        Assert.assertEquals(title.getAttribute("innerText"), TEXT_TITLE);
        description.shouldBe(Condition.visible);
        Assert.assertEquals(description.getAttribute("innerText"), TEXT_DESCRIPTION);
        for (int i = 0; i < cards.size(); i++) {
            Warp.checkLinkThisTab(cards.get(i), TEXT_HREFS[i]);
            Assertions.mouseIsPointer(seeMoreButton.get(i));
            seeMoreButton.get(i).click();
            Assert.assertEquals(Warp.currentURL(), TEXT_HREFS[i]);
            Selenide.back();
        }
    }
}
package com.andersenlab.autotests.site.page.services.maintenance.blocks;

import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FinancialServices {
    //блок очень похож на резюме, можно объединить
    String BASE;
    private SelenideElement title;
    private ElementsCollection arts;
    private String textTitle;
    private final String[] hrefs = {"https://dev.andersenlab.com/services/maintenance-support/help-desk-and-call-center",
            "https://dev.andersenlab.com/services/maintenance-support/advanced-it-support",
            "https://dev.andersenlab.com/services/maintenance-support/infrastructure-development-support"
    };

    public FinancialServices() {
        BASE = "//section[contains(@class, 'financial-services')]";
        textTitle = "What you get";
        calc();
    }

    private void calc() {
        By TITLE = By.xpath(BASE + "//h2");
        By BUTTONS_SEE_MORE = By.xpath(BASE + "//article[not(contains(@style, 'display: none'))]//a[contains(@class, 'button')]");
        title = $(TITLE);
        arts = $$(BUTTONS_SEE_MORE);
    }

    @Step
    public void displayingElementsAndFunction() {
        Warp.scrollToElement(arts.first());
        Assert.assertEquals(title.getAttribute("innerText"), textTitle);
        int artsQuantity = arts.size();
        for (int i = 0; i < artsQuantity; i++) {
            Assertions.mouseIsPointer(arts.get(i));
            Warp.checkLinkThisTab(arts.get(i), hrefs[i]);
        }
    }

}

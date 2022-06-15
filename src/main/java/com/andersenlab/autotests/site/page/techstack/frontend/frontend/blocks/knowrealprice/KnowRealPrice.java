package com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.knowrealprice;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;

public class KnowRealPrice {
    private KnowRealPriceBlock el = new KnowRealPriceBlock();

    @Step
    public void addSomeSpecialist() {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(el.getResetInclude()).perform();
        el.getPlusJsDev().click();
        el.getPlusAngular().click();
        if(el.getButtonClosePanel().isDisplayed()) el.getButtonClosePanel().click();
        el.getPlusReact().click();
        el.getPlusQa().click();
        el.getPlusPm().click();
    }
}

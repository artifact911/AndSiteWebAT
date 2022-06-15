package com.andersenlab.autotests.site.page.services.salesforce.blocks.costcalculator;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GetPriceBtn {
    private final String BASE = "//p[contains(@class, 'title-module--title--2ZlKC')]//..//..";
    private final By PRICE_BUTTON = By.xpath(BASE + "//button[text()='Get price']");

    public final SelenideElement priceButton = $(PRICE_BUTTON);

    public void pricePopup(){
        priceButton.click();
    }
}

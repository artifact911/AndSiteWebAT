package com.andersenlab.autotests.site.page.services.salesforce.blocks.costcalculator;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CalcPopupGift {
    private String BASE = "//section[contains(@class, 'gift')]";
    private By TITLE = By.xpath(BASE + "//h3[contains(@class, 'title')]");
    private By CLOSE_BUTTON = By.xpath(BASE + "//button[contains(@class, 'close-button')]");

    private final SelenideElement CloseButton = $(CLOSE_BUTTON);
    private final SelenideElement Title = $(TITLE);

    public void close() {
        CloseButton.click();
    }

    public boolean visible() {
        return Title.isDisplayed();
    }
}

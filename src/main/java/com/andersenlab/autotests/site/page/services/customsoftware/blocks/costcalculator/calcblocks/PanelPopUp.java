package com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks;

import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class PanelPopUp {
    //locators
    private final String BASE_POPUP = "//section[contains(@class, 'ResultModalDesktop-module')]";
    private final By BUTTON_CLOSE = By.xpath(BASE_POPUP + "//button[contains(@class, 'close-button')]");
    private final By BUTTON_GET_PRICE_PANEL = By.xpath(BASE_POPUP + "//button[contains( translate(., 'CEGIPRT', 'cegiprt'), 'get price')]");
    private final By BUTTON_GET_PRICE = By.xpath("//main//button[contains( translate(., 'CEGIPRT', 'cegiprt'), 'get price')]");
    private final By TITLE = By.xpath(BASE_POPUP + "//h4");
    private final By CHOSEN_UNITS = By.xpath(BASE_POPUP + "//button[contains(@class, 'filterTag')]");
    //elements
    private final SelenideElement ButtonClose = $(BUTTON_CLOSE);
    private final SelenideElement ButtonGetPanel = $(BUTTON_GET_PRICE_PANEL);
    private final SelenideElement ButtonGetPrice = $(BUTTON_GET_PRICE);
    private final SelenideElement Title = $(TITLE);
    private final ElementsCollection ChosenUnits = $$(CHOSEN_UNITS);
    private final String TEXT_TITLE = "Please, leave your contact details to receive the quote";

    @Step
    public void close() {
        ButtonClose.click();
    }

    @Step
    public boolean isChosenItemPresent(String name) {
        return Warp.isElementPresent(By.xpath(BASE_POPUP + "//button[contains(text(), '" + name + "')]"));
    }

    @Step
    public void getPricePanel() {
        ButtonGetPanel.click();
    }

    @Step
    public void getPricePage() {
        ButtonGetPrice.click();
    }

    @Step
    public int chosenUnitsQuantity() {
        return ChosenUnits.size();
    }

    @Step
    public void checkTitle() {
        Assert.assertEquals(Title.getText(), TEXT_TITLE);
    }



}

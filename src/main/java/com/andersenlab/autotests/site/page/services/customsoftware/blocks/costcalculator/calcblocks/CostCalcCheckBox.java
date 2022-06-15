package com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks;

import com.andersenlab.autotests.core.steps.Assertions;
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
public class CostCalcCheckBox implements ToBottomScrollable{

    private String BASE;
    private By CHECKBOXES;
    private By ITEM_NAMES;
    private By TITLE;
    private By BUTTON_CLEAR;

    private ElementsCollection CheckBoxes;
    private ElementsCollection ItemNames;
    private SelenideElement ButtonClear;
    private SelenideElement title;
    private ElementsCollection nextSection;

    public CostCalcCheckBox(String BASE) {
        this.BASE = BASE;
        calc();
    }

    private void calc() {
        CHECKBOXES = By.xpath(BASE + "//label[contains(@class, 'checkbox')]");
        ITEM_NAMES = By.xpath(BASE + "//input[contains(@class, 'checkbox')]/following-sibling::div[contains(@class, 'title')]");
        TITLE = By.xpath(BASE + "//header/p[contains(@class, 'title')]");
        BUTTON_CLEAR = By.xpath(BASE + "//button[contains(text(), 'Clear all')]");

        CheckBoxes = $$(CHECKBOXES);
        ItemNames = $$(ITEM_NAMES);
        ButtonClear = $(BUTTON_CLEAR);
        title = $(TITLE);
    }

    public void scrollToBottom(){
        scrollToBottom(BASE);
    }

    @Step
    public void behaviourBlock() {
        scrollToBottom(BASE);
        PanelPopUp panel = new PanelPopUp();
        int quantity = CheckBoxes.size();
        int checkedIndex = Warp.randomInt(quantity);
        Assertions.mouseIsPointer(CheckBoxes.get(checkedIndex));
        Assert.assertTrue(Warp.isElementPresent(TITLE));
        Warp.clickUntouchable(CheckBoxes.get(checkedIndex), 0, 0);
        Warp.delay(2);
        int oneMore = (checkedIndex < quantity - 1) ? checkedIndex + 1 : checkedIndex - 1;
        Warp.clickUntouchable(CheckBoxes.get(oneMore), 0, 0);
        Assert.assertEquals(panel.getChosenUnits().size(), 2);
        panel.getChosenUnits().first().click();
        Assert.assertEquals(panel.getChosenUnits().size(), 1);
        ButtonClear.click();
        Assert.assertTrue(panel.getChosenUnits().isEmpty());
        panel.close();
    }

    @Step
    public String checkUnit(int index) {
        if (index > CheckBoxes.size() || index < 0) throw new IllegalArgumentException("BAD INDEX");
        CheckBoxes.get(index).click();
        return ItemNames.get(index).getAttribute("innerText");
    }

    @Step
    public void clearAll() {
        ButtonClear.click();
    }

    @Step
    public String sectionTitle() {
        return title.getAttribute("innerText");
    }

    @Step
    public int checkBoxQuantity() {
        return CheckBoxes.size();
    }

    public SelenideElement getTITLE() {
        return title;
    }

}

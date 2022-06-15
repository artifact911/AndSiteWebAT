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
public class CostCalcRadioButton implements ToBottomScrollable{

    private final String RB_UNCHECKED_B_COLOR = "rgb(224, 224, 224)";
    private final String RB_CHECKED_B_COLOR = "rgb(254, 218, 0)";

    private String BASE;
    private By RADIO_BUTTONS;
    private By ITEM_NAMES;
    private By TITLE;
    private By NEXT_SECTION;

    private ElementsCollection RadioButtons;
    private ElementsCollection ItemNames;
    private SelenideElement ButtonClear;
    private SelenideElement title;
    private ElementsCollection nextSection;

    public CostCalcRadioButton(String BASE) {
        this.BASE = BASE;
        calc();
    }

    private void calc() {
        RADIO_BUTTONS = By.xpath(BASE + "//label[contains(@class, 'radio-btn')]/span");
        ITEM_NAMES = By.xpath(BASE + "//label[contains(@class, 'radio-btn')]/span/following-sibling::div[contains(@class, 'name')]");
        TITLE = By.xpath(BASE + "//h3");
        NEXT_SECTION = By.xpath(BASE + "/./following-sibling::section[1]//p[contains(@class, 'description')]");

        RadioButtons = $$(RADIO_BUTTONS);
        ItemNames = $$(ITEM_NAMES);
        title = $(TITLE);
        nextSection = $$(NEXT_SECTION);
    }

    public void scrollToBottom(){
        scrollToBottom(BASE);
    }

    @Step
    public void behaviourBlock() {
        scrollToBottom(BASE);
        Assert.assertTrue(Warp.isElementPresent(TITLE));
        PanelPopUp panel = new PanelPopUp();
        int quantity = RadioButtons.size();
        int checkedIndex = Warp.randomInt(quantity);
        Assertions.mouseIsPointer(RadioButtons.get(checkedIndex));

        Assert.assertEquals(RadioButtons.get(checkedIndex).getCssValue("border-color"), RB_UNCHECKED_B_COLOR);
        RadioButtons.get(checkedIndex).click();
        Assert.assertEquals(RadioButtons.get(checkedIndex).getCssValue("border-color"), RB_CHECKED_B_COLOR);
        Assert.assertEquals(panel.getChosenUnits().size(), 1);

        for (int i = 0; i < quantity; i++) {
            if(i != checkedIndex) Assert.assertEquals(RadioButtons.get(i).getCssValue("border-color"), RB_UNCHECKED_B_COLOR);
            else Assert.assertEquals(RadioButtons.get(i).getCssValue("border-color"), RB_CHECKED_B_COLOR);
        }

        int oneElse = (checkedIndex < quantity - 1) ? checkedIndex + 1 : checkedIndex - 1;
        RadioButtons.get(oneElse).click();
        Assert.assertEquals(RadioButtons.get(oneElse).getCssValue("border-color"), RB_CHECKED_B_COLOR);
        Assert.assertEquals(RadioButtons.get(checkedIndex).getCssValue("border-color"), RB_UNCHECKED_B_COLOR);
        Assert.assertEquals(panel.getChosenUnits().size(), 1);
        (panel.getChosenUnits().first()).click();
        Assert.assertEquals(panel.getChosenUnits().size(), 0);
        panel.close();
    }


    @Step
    public String checkUnit(int index) {
        if (index > RadioButtons.size() || index < 0) throw new IllegalArgumentException("BAD INDEX");
        RadioButtons.get(index).click();
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
        return RadioButtons.size();
    }

    public SelenideElement getTITLE() {
        return title;
    }

}

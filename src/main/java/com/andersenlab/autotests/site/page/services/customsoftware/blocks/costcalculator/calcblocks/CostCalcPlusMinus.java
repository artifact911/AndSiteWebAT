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
public class CostCalcPlusMinus implements ToBottomScrollable{
    private String BASE;

    private By COUNTS;
    private By PLUS;
    private By MINUS;
    private By ITEM_NAMES;
    private By TITLE;
    private By BUTTON_CLEAR;
    private By NEXT_SECTION;

    private ElementsCollection Counts;
    private ElementsCollection Plus;
    private ElementsCollection Minus;
    private ElementsCollection ItemNames;
    private SelenideElement ButtonClear;
    private SelenideElement title;
    private ElementsCollection nextSection;

    public CostCalcPlusMinus(String BASE) {
        this.BASE = BASE; //если база будет меняться от стр к стр, то раскомментить эту строку и получать базу аргументом конструктора
        ITEM_NAMES = By.xpath(BASE + "//div[contains(@class, 'counter-module--title')]");
        calc();
    }
    public CostCalcPlusMinus(String BASE, String ITEM_NAMES) {
        this.BASE = BASE; //если база будет меняться от стр к стр, то раскомментить эту строку и получать базу аргументом конструктора
        this.ITEM_NAMES = By.xpath(BASE + ITEM_NAMES);
        calc();
    }

    private void calc() {
        COUNTS = By.xpath(BASE + "//input");
        PLUS = By.xpath(BASE + "//button[contains(@class, 'plus')]");
        MINUS = By.xpath(BASE + "//button[contains(@class, 'minus')]");
        TITLE = By.xpath(BASE + "//header/p[contains(@class, 'title')]");
        BUTTON_CLEAR = By.xpath(BASE + "//button[contains(text(), 'Clear all')]");
        NEXT_SECTION = By.xpath(BASE + "/./following-sibling::section[1]//p[contains(@class, 'subtitle')]");

        Counts = $$(COUNTS);
        Plus = $$(PLUS);
        Minus = $$(MINUS);
        ItemNames = $$(ITEM_NAMES);
        ButtonClear = $(BUTTON_CLEAR);
        title = $(TITLE);
        nextSection = $$(NEXT_SECTION);
    }

    @Step
    public void behaviourBlock() {
        Warp.scrollToElement(getButtonClear());
        PanelPopUp panel = new PanelPopUp();
        int quantity = Counts.size();
        int checkedIndex = Warp.randomInt(quantity);
        Assertions.mouseIsPointer(Plus.get(checkedIndex));
        Assertions.mouseIsPointer(Minus.get(checkedIndex));
        Assert.assertTrue(Warp.isElementPresent(TITLE));
        Warp.clickUntouchable(Plus.get(checkedIndex), 0, 0);
        Warp.scrollToElement(nextSection.first());
        Warp.delay(2);
        int oneMore = (checkedIndex < quantity - 1) ? checkedIndex + 1 : checkedIndex - 1;
        Warp.clickUntouchable(Plus.get(oneMore), 0, 0);
        Warp.delay(2);
        Assert.assertEquals(panel.getChosenUnits().size(), 2);
        Assert.assertEquals(Counts.get(checkedIndex).getValue(), "1");
        Assert.assertEquals(Counts.get(oneMore).getValue(), "1");
        panel.getChosenUnits().first().click();
        Assert.assertEquals(Counts.get(checkedIndex).getValue(), "0");
        Assert.assertEquals(panel.getChosenUnits().size(), 1);
        ButtonClear.click();
        Assert.assertTrue(panel.getChosenUnits().isEmpty());
        Assert.assertEquals(Counts.get(oneMore).getValue(), "0");
        panel.close();
    }

    @Step
    public String checkUnit(int index) {
        if (index > Plus.size() || index < 0) throw new IllegalArgumentException("BAD INDEX");
        Plus.get(index).click();
//        Wrap.clickUntouchable(Plus.get(index), 0, 0);// если строка выше перестанет работать, раскомментить это
        return ItemNames.get(index).getAttribute("innerText");
    }

}

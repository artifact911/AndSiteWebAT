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
public class CostCalcBudgetBar implements ToBottomScrollable {
    private String BASE;

    private By TITLE;
    private By STRAIGHTEDGE_STEPS;
    private By BAR;

    private SelenideElement title;
    private ElementsCollection straightedgeSteps;
    private SelenideElement bar;

    private final String TEXT_TITLE = " Select estimated budget";

    public CostCalcBudgetBar(String BASE) {
        this.BASE = BASE;
        calc();
    }

    private void calc() {
        TITLE = By.xpath(BASE + "//h3");
        STRAIGHTEDGE_STEPS = By.xpath(BASE + "//div[contains(@class, 'ui-slider-labels__label')]");//точки псевдоэлементами, потому привязка к меткам
        BAR = By.xpath(BASE + "//div[contains(@class, 'ui-slider-range')]");

        title = $(TITLE);
        straightedgeSteps = $$(STRAIGHTEDGE_STEPS);
        bar = $(BAR);
    }

    @Step
    public void behaviourBlock() {
        PanelPopUp panel = new PanelPopUp();

        scrollToBottom(BASE);
        Assert.assertEquals(title.getAttribute("innerText"), TEXT_TITLE);
        Assert.assertEquals(bar.getAttribute("style"), "width: 20%;");

        for (int i = 1; i < 5; i++) {
            Warp.clickUntouchable(straightedgeSteps.get(i), 0, -21);
            Assert.assertEquals(bar.getAttribute("style"), "width: " + (20 * (i + 1)) + "%;");
        }

        Assert.assertEquals(panel.getChosenUnits().size(), 1);
        panel.getChosenUnits().first().click();
        Assert.assertTrue(panel.getChosenUnits().isEmpty());
        Assert.assertEquals(bar.getAttribute("style"), "width: 20%;");

        panel.close();
    }
}
